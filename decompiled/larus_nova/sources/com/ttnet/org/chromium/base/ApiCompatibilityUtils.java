package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class ApiCompatibilityUtils {

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisLmr1 {
        private ApisLmr1() {
        }

        public static void setAccessibilityTraversalBefore(View r100, int r101) {
            r100.setAccessibilityTraversalBefore(r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisM {
        private ApisM() {
        }

        public static void setStatusBarIconColor(View r100, boolean r101) {
            int r102 = r100.getSystemUiVisibility();
            if (r101 == false) goto L5;
            int r103 = r102 | 8192;
        L6:
            r100.setSystemUiVisibility(r103);
            return;
        L5:
            r103 = r102 & (-8193);
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisN {
        private ApisN() {
        }

        public static boolean isDemoUser() {
            return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
        }

        public static String getLocale(InputMethodSubtype r100) {
            return r100.getLanguageTag();
        }

        public static boolean isInMultiWindowMode(Activity r100) {
            return r100.isInMultiWindowMode();
        }

        public static String toHtml(Spanned r100, int r101) {
            return Html.toHtml(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisO {
        private ApisO() {
        }

        public static Bundle createLaunchDisplayIdActivityOptions(int r100) {
            ActivityOptions r101 = ActivityOptions.makeBasic();
            r101.setLaunchDisplayId(r100);
            return r101.toBundle();
        }

        public static void disableSmartSelectionTextClassifier(TextView r100) {
            r100.setTextClassifier(TextClassifier.NO_OP);
        }

        public static void initNotificationSettingsIntent(Intent r100, String r101) {
            r100.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            r100.putExtra("android.provider.extra.APP_PACKAGE", r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisP {
        private ApisP() {
        }

        public static String getProcessName() {
            return Application.getProcessName();
        }

        public static Bitmap getBitmapByUri(ContentResolver r100, Uri r101) throws IOException {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(r100, r101));
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ApisQ {
        private ApisQ() {
        }

        public static boolean isRunningInUserTestHarness() {
            return ActivityManager.isRunningInUserTestHarness();
        }

        public static List<Integer> getTargetableDisplayIds(Activity r100) {
            ArrayList r101 = new ArrayList();
            if (r100 != null) goto L5;
            return r101;
        L5:
            DisplayManager r102 = (DisplayManager) r100.getSystemService("display");
            if (r102 != null) goto L8;
            return r101;
        L8:
            Display[] r103 = r102.getDisplays();
            ActivityManager r104 = (ActivityManager) r100.getSystemService("activity");
            int r105 = r103.length;
            int r106 = 0;
        L9:
            if (r106 >= r105) goto L16;
            Display r107 = r103[r106];
            if (r107.getState() != 2) goto L15;
            if (r104.isActivityStartAllowedOnDisplay(r100, r107.getDisplayId(), new Intent(r100, r100.getClass())) == false) goto L15;
            r101.add(Integer.valueOf(r107.getDisplayId()));
        L15:
            r106 = r106 + 1;
            goto L9
        L16:
            return r101;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int compareBoolean(boolean r100, boolean r101) {
        if (r100 != r101) goto L4;
        return 0;
    L4:
        if (r100 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int compareLong(long r100, long r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r100 != r101) goto L7;
        return 0;
    L7:
        return 1;
    }

    private static boolean isPasswordInputType(int r100) {
        int r101 = r100 & UnixStat.PERM_MASK;
        if (r101 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r101 == 225) goto L10;
        if (r101 == 18) goto L10;
        return false;
    }

    public static Intent getNotificationSettingsIntent() {
        Intent r100 = new Intent();
        String r101 = ContextUtils.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ApisO.initNotificationSettingsIntent(r100, r101);
    L6:
        return r100;
    L5:
        r100.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
        r100.putExtra("app_package", r101);
        r100.putExtra("app_uid", ContextUtils.getApplicationContext().getApplicationInfo().uid);
        goto L6
    }

    public static String getProcessName() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (String) INVOKESTATIC_com_ttnet_org_chromium_base_ApiCompatibilityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ApisP.getProcessName();
    }

    public static boolean isDemoUser() {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
    L7:
        return false;
    L5:
        if (ApisN.isDemoUser() == false) goto L7;
        return true;
    }

    public static boolean isRunningInUserTestHarness() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return ApisQ.isRunningInUserTestHarness();
    }

    private ApiCompatibilityUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_ApiCompatibilityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Bundle createLaunchDisplayIdActivityOptions(int r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return ApisO.createLaunchDisplayIdActivityOptions(r100);
    }

    public static void disableSmartSelectionTextClassifier(TextView r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        ApisO.disableSmartSelectionTextClassifier(r100);
        return;
    }

    public static byte[] getBytesUtf8(String r100) {
        return r100.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String getLocale(InputMethodSubtype r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.getLocale(r100);
    L7:
        return r100.getLocale();
    }

    public static List<Integer> getTargetableDisplayIds(Activity r100) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return ApisQ.getTargetableDisplayIds(r100);
    L7:
        return new ArrayList();
    }

    public static boolean isInMultiWindowMode(Activity r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return ApisN.isInMultiWindowMode(r100);
    }

    public static <T> T requireNonNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static void setPasswordEditTextContentDescription(EditText r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return;
    L6:
        if (isPasswordInputType(r100.getInputType()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100.getHint()) == true) goto L12;
        r100.setContentDescription(r100.getHint());
        return;
    }

    public static Bitmap getBitmapByUri(ContentResolver r100, Uri r101) throws IOException {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApisP.getBitmapByUri(r100, r101);
    L7:
        return MediaStore.Images.Media.getBitmap(r100, r101);
    }

    public static int getColor(Resources r100, int r101) throws Resources.NotFoundException {
        return r100.getColor(r101);
    }

    public static Drawable getDrawable(Resources r100, int r101) throws Resources.NotFoundException {
        return getDrawableForDensity(r100, r101, 0);
    }

    public static <T> T requireNonNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static void setAccessibilityTraversalBefore(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        ApisLmr1.setAccessibilityTraversalBefore(r100, r101);
        return;
    }

    public static void setImageTintList(ImageView r100, ColorStateList r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 != 21) goto L8;
        if (r101 == null) goto L8;
        if (r100.getImageTintMode() != null) goto L8;
        r100.setImageTintMode(PorterDuff.Mode.SRC_IN);
    L8:
        ImageViewCompat.setImageTintList(r100, r101);
        if (r102 != 21) goto L13;
        if (r101 != null) goto L14;
        r100.refreshDrawableState();
        return;
    L14:
        return;
    }

    public static void setStatusBarColor(Window r100, int r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
    L9:
        r100.addFlags(Integer.MIN_VALUE);
    L10:
        r100.setStatusBarColor(r101);
        return;
    L5:
        if (r101 != (-16777216)) goto L9;
        if (r100.getNavigationBarColor() != (-16777216)) goto L9;
        r100.clearFlags(Integer.MIN_VALUE);
        goto L10
    }

    public static void setStatusBarIconColor(View r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        ApisM.setStatusBarIconColor(r100, r101);
        return;
    }

    public static void setTextAppearance(TextView r100, int r101) {
        r100.setTextAppearance(r100.getContext(), r101);
    }

    public static String toHtml(Spanned r100, int r101) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.toHtml(r100, r101);
    L7:
        return Html.toHtml(r100);
    }

    public static Drawable getDrawableForDensity(Resources r100, int r101, int r102) {
        StrictMode.ThreadPolicy r103 = StrictMode.allowThreadDiskReads();
        if (r102 != 0) goto L7;
        Drawable r104 = r100.getDrawable(r101, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r103);
        return r104;
    L7:
        Drawable r105 = r100.getDrawableForDensity(r101, r102, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r103);
        return r105;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r103);
        throw th;
    }

    public static int checkPermission(Context r100, String r101, int r102, int r103) {
        return com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission(r100, r101, r102, r103);
    L4:
        return -1;
    }

    private static int com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
