package androidx.camera.core.impl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class QuirkSettingsLoader implements Function<Context, QuirkSettings> {
    public static final String KEY_DEFAULT_QUIRK_ENABLED = "androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED";
    public static final String KEY_QUIRK_FORCE_DISABLED = "androidx.camera.core.quirks.FORCE_DISABLED";
    public static final String KEY_QUIRK_FORCE_ENABLED = "androidx.camera.core.quirks.FORCE_ENABLED";
    private static final String TAG = "QuirkSettingsLoader";

    public static class MetadataHolderService extends Service {
        private MetadataHolderService() {
        }

        @Override // android.app.Service
        public IBinder onBind(Intent r1) {
            throw new UnsupportedOperationException();
        }
    }

    public QuirkSettingsLoader() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_camera_core_impl_QuirkSettingsLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static Class<? extends Quirk> resolveQuirkName(String r4) {
        Class<? extends Quirk> r1 = INVOKESTATIC_androidx_camera_core_impl_QuirkSettingsLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r4);     // Catch: ClassNotFoundException -> L8
        if (Quirk.class.isAssignableFrom(r1) == false) goto L6;
        return r1;
    L6:
        Logger.w(TAG, r4 + " does not implement the Quirk interface.");     // Catch: ClassNotFoundException -> L8
        return null;
    L8:
        e = move-exception;
        Logger.w(TAG, "Class not found: " + r4, e);
        return null;
    }

    private static Set<Class<? extends Quirk>> resolveQuirkNames(String[] r4) {
        HashSet r0 = new HashSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Class<? extends Quirk> r3 = resolveQuirkName(r4[r2]);
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public QuirkSettings apply2(Context r6) {
        PackageManager r1 = r6.getPackageManager();
        Bundle r2 = r1.getServiceInfo(new ComponentName(r6, MetadataHolderService.class), 640).metaData;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r2 != null) goto L8;
        Logger.w(TAG, "No metadata in MetadataHolderService.");     // Catch: PackageManager.NameNotFoundException -> L9
        return null;
    L8:
        return buildQuirkSettings(r6, r2);
    L9:
        Logger.d(TAG, "QuirkSettings$MetadataHolderService is not found.");
        return null;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ QuirkSettings apply(Context r1) {
        return apply2(r1);
    }

    private static QuirkSettings buildQuirkSettings(Context r4, Bundle r5) {
        boolean r0 = r5.getBoolean(KEY_DEFAULT_QUIRK_ENABLED, true);
        String[] r1 = loadQuirks(r4, r5, KEY_QUIRK_FORCE_ENABLED);
        String[] r6 = loadQuirks(r4, r5, KEY_QUIRK_FORCE_DISABLED);
        Logger.d(TAG, "Loaded quirk settings from metadata:");
        Logger.d(TAG, "  KEY_DEFAULT_QUIRK_ENABLED = " + r0);
        Logger.d(TAG, "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(r1));
        Logger.d(TAG, "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(r6));
        return new QuirkSettings.Builder().setEnabledWhenDeviceHasQuirk(r0).forceEnableQuirks(resolveQuirkNames(r1)).forceDisableQuirks(resolveQuirkNames(r6)).build();
    }

    private static String[] loadQuirks(Context r3, Bundle r4, String r5) {
        if (r4.containsKey(r5) == false) goto L5;
        int r6 = r4.getInt(r5, -1);
        if (r6 != (-1)) goto L15;
        Logger.w(TAG, "Resource ID not found for key: " + r5);
        return new String[0];
    L15:
        return r3.getResources().getStringArray(r6);
    L12:
        e = move-exception;
        Logger.w(TAG, "Quirk class names resource not found: " + r6, e);
        return new String[0];
    L5:
        return new String[0];
    }
}
