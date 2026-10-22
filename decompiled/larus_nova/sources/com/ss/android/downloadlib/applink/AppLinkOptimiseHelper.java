package com.ss.android.downloadlib.applink;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* JADX INFO: loaded from: classes34.dex */
public class AppLinkOptimiseHelper {
    private static final int APP_LINK_CHECKOUT_TIMEOUT = 300000;
    private static final int TRY_CHECK_LINK_STATUS_COUNT = 10;
    private static Handler sUIHandler;

    public AppLinkOptimiseHelper() {
    }

    static {
        sUIHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ long access$000(NativeDownloadModel r100) {
        return checkAppLinkTimeout(r100);
    }

    public static /* synthetic */ int access$100(NativeDownloadModel r100) {
        return checkAppLinkSuccessCount(r100);
    }

    private static int checkAppLinkSuccessCount(NativeDownloadModel r100) {
        return DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_CHECK_COUNT, 10);
    }

    private static int checkAppLinkSuccessDelay(NativeDownloadModel r100) {
        return DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_CHECK_DELAY, 1);
    }

    private static long checkAppLinkTimeout(NativeDownloadModel r100) {
        return DownloadSettingUtils.getSetting(r100).optLong(DownloadSettingKeys.KEY_APP_LINK_CHECK_TIMEOUT, 300000);
    }

    public static boolean dialogSwitchIsOpen(NativeDownloadModel r100) {
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_OPT_DIALOG_SWITCH) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static long getInvokeAppBackTimeLimit(NativeDownloadModel r100) {
        if (r100 != null) goto L6;
        return 3000;
    L6:
        return DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_OPT_BACK_TIME_LIMIT, 3) * 1000;
    }

    public static boolean installSwitchIsOpen(NativeDownloadModel r100) {
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_OPT_INSTALL_SWITCH) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean invokeSwitchIsOpen(NativeDownloadModel r100) {
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_OPT_INVOKE_SWITCH) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean switchIsOpen(NativeDownloadModel r100) {
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_APP_LINK_OPT_SWITCH) == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ void access$200(NativeDownloadModel r100, int r101) {
        checkAppLinkSuccessDelay(r100, r101);
    }

    private static void checkAppLinkSuccessDelay(final NativeDownloadModel r100, final int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        DownloadComponentManager.getInstance().submitScheduledTask(new AnonymousClass2(r100, r101), checkAppLinkSuccessDelay(r100) * 1000);
    }

    public static void invoke(final NativeDownloadModel r100, final IAppLinkOptimiseCallback r101) {
        boolean r102 = AppStatusManager.getInstance().isAppForeground();
        if (r102 == false) goto L5;
    L7:
        boolean r103 = AppStatusManager.getInstance().isAppForeground();
        boolean r104 = true;
        if (r102 == true) goto L11;
        if (r103 == false) goto L11;
        boolean r105 = true;
    L12:
        if (r100 == null) goto L14;
        r100.setDeeplinkAfterBackApp(r105);
    L14:
        if (r105 == true) goto L18;
        if (r102 == true) goto L18;
        r104 = false;
    L18:
        r101.invoke(r104);
        if (r100 != null) goto L21;
        return;
    L21:
        checkAppLinkSuccessDelay(r100, checkAppLinkSuccessCount(r100));
        if (r103 == false) goto L24;
        return;
    L24:
        final long r106 = System.currentTimeMillis();
        AppStatusManager.getInstance().registerAppSwitchListener(new AnonymousClass1(r100, r106, r101));
        return;
    L11:
        r105 = false;
        goto L12
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        ToolUtils.tryMoveAppToFront();
        goto L7
    }
}
