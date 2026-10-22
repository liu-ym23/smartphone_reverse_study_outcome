package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Button;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class UIUtil {

    public class a implements DialogInterface.OnShowListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface r100) {
            if ((r100 instanceof AlertDialog) == true) goto L6;
            HMSLog.e("UIUtil", "In enableFocusedForButtonsInTV, DialogInterface is invalid, dialog = " + r100);
            return;
        L6:
            AlertDialog r101 = (AlertDialog) r100;
            UIUtil.a(r101, -2, false);
            UIUtil.a(r101, -3, false);
            UIUtil.a(r101, -1, true);
        }
    }

    public UIUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isTVDevice() {
        return getSystemProperties(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS, "default").equalsIgnoreCase(CommonCmd.AIDL_PLATFORM_TYPE_TV);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_utils_UIUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static int a(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public static <T extends Dialog> T enableFocusedForButtonsInTV(T r100) {
        r100.setCanceledOnTouchOutside(false);
        if (isTVDevice() == true) goto L6;
        return r100;
    L6:
        if ((r100 instanceof AlertDialog) == true) goto L9;
        HMSLog.e("UIUtil", "In enableFocusedForButtonsInTV, dialog is invalid, dialog = " + r100);
        return r100;
    L9:
        r100.setOnShowListener(new a());
        return r100;
    }

    public static int getDialogThemeId(Activity r100) {
        if (a(r100) == 0) goto L7;
        return 0;
    L7:
        if (r100 != null) goto L9;
    L17:
        return 3;
    L9:
        if (r100.getResources() == null) goto L17;
        if (r100.getResources().getConfiguration() == null) goto L17;
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L17;
        return 2;
    }

    public static boolean isActivityFullscreen(Activity r100) {
        if (r100 != null) goto L7;
        HMSLog.w("UIUtil", "activity is null");
        return false;
    L7:
        if ((r100.getWindow().getAttributes().flags & 1024) != 1024) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isBackground(Context r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        KeyguardManager r102 = (KeyguardManager) r100.getSystemService("keyguard");
        if (r101 == null) goto L30;
        if (r102 == null) goto L32;
        List<ActivityManager.RunningAppProcessInfo> r103 = r101.getRunningAppProcesses();
        if (r103 != null) goto L12;
        return true;
    L12:
        String r104 = getProcessName(r100, Process.myPid());
        Iterator<ActivityManager.RunningAppProcessInfo> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L34;
        ActivityManager.RunningAppProcessInfo r106 = r105.next();
        if (TextUtils.equals(r106.processName, r104) == false) goto L14;
        HMSLog.i("UIUtil", "appProcess.importance is " + r106.importance);
        if (r106.importance != 100) goto L20;
        boolean r107 = true;
    L21:
        boolean r108 = r102.isKeyguardLocked();
        HMSLog.i("UIUtil", "isForground is " + r107 + "***  isLockedState is " + r108);
        if (r107 == false) goto L31;
        if (r108 == true) goto L33;
        return false;
    L33:
        return true;
    L31:
        return true;
    L20:
        r107 = false;
        goto L21
    L34:
        return true;
    L32:
        return true;
    L30:
        return true;
    }

    public static Intent modifyIntentBehaviorsSafe(Intent r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getAction();
        if ("android.intent.action.SEND".equals(r101) == false) goto L8;
    L15:
        r100.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
    L16:
        r100.setFlags((((r100.getFlags() & (-129)) & (-65)) & (-2)) & (-3));
        return r100;
    L8:
        if ("android.intent.action.SEND_MULTIPLE".equals(r101) == true) goto L15;
        if ("android.media.action.IMAGE_CAPTURE".equals(r101) == true) goto L15;
        if ("android.media.action.IMAGE_CAPTURE_SECURE".equals(r101) == true) goto L15;
        if ("android.media.action.VIDEO_CAPTURE".equals(r101) == false) goto L16;
        goto L15
    }

    public static Activity getActiveActivity(Activity r100, Context r101) {
        if (isBackground(r101) == false) goto L6;
        HMSLog.i("UIUtil", "isBackground" + isBackground(r101));
        return null;
    L6:
        if (r100 != null) goto L10;
        HMSLog.i("UIUtil", "activity is null");
        return ActivityMgr.INST.getCurrentActivity();
    L10:
        if (r100.isFinishing() == false) goto L13;
        HMSLog.i("UIUtil", "activity isFinishing is " + r100.isFinishing());
        return ActivityMgr.INST.getCurrentActivity();
    L13:
        return r100;
    }

    public static String getProcessName(Context r100, int r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        if (r102 == null) goto L16;
        List<ActivityManager.RunningAppProcessInfo> r103 = r102.getRunningAppProcesses();
        if (r103 == null) goto L16;
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();
        if (r105.pid != r101) goto L11;
        return r105.processName;
    L16:
        return "";
    }

    public static String getSystemProperties(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_huawei_hms_utils_UIUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        return (String) r102.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});
    L4:
        HMSLog.e("UIUtil", "An exception occurred while reading: getSystemProperties:" + r100);
        return r101;
    }

    public static /* synthetic */ void a(AlertDialog r100, int r101, boolean r102) {
        b(r100, r101, r102);
    }

    private static void b(AlertDialog r100, int r101, boolean r102) {
        Button r103 = r100.getButton(r101);
        if (r103 != null) goto L6;
        HMSLog.e("UIUtil", "In enableFocused, button is null.");
        return;
    L6:
        r103.setFocusable(true);
        r103.setFocusableInTouchMode(true);
        if (r102 == false) goto L10;
        r103.requestFocus();
        return;
    }
}
