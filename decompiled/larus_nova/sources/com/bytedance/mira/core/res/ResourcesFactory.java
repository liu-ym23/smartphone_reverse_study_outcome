package com.bytedance.mira.core.res;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class ResourcesFactory {
    private static final String RES_CLASS_NAME_STANDARD = "android.content.res.Resources";
    private static final String TAG = "ResourcesFactory";

    /* JADX INFO: renamed from: com.bytedance.mira.core.res.ResourcesFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultResourcesAdapter {
        public DefaultResourcesAdapter() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_mira_core_res_ResourcesFactory$DefaultResourcesAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
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

        public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory$DefaultResourcesAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public Resources createNewResources(Resources r100, AssetManager r110) {
            String r101 = r100.getClass().getName();
            Constructor r102 = INVOKESTATIC_com_bytedance_mira_core_res_ResourcesFactory$DefaultResourcesAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).getDeclaredConstructor(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class});     // Catch: Exception -> L5
            r102.setAccessible(true);     // Catch: Exception -> L5
            return (Resources) r102.newInstance(new Object[]{r110, INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory$DefaultResourcesAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), r100.getConfiguration()});
        L5:
            e = move-exception;
            MiraLogger.e(ResourcesFactory.TAG, "create adapted resources failed: ".concat(r101), e);
            return null;
        }
    }

    public static class HWResourcesAdapter extends DefaultResourcesAdapter {
        private static final String RES_CLASS_NAME = "android.content.res.HwResources";

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private HWResourcesAdapter() {
        }

        public /* synthetic */ HWResourcesAdapter(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_mira_core_res_ResourcesFactory$HWResourcesAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
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

        public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory$HWResourcesAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public static boolean isHWResources(String r100) {
            return RES_CLASS_NAME.equals(r100);
        }

        @Override // com.bytedance.mira.core.res.ResourcesFactory.DefaultResourcesAdapter
        public Resources createNewResources(Resources r110, AssetManager r111) {
            if (Build.VERSION.SDK_INT > 23) goto L12;
            return super.createNewResources(r110, r111);
        L12:
            Class<?> r100 = INVOKESTATIC_com_bytedance_mira_core_res_ResourcesFactory$HWResourcesAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.DisplayAdjustments");     // Catch: Exception -> L9
            Constructor r101 = INVOKESTATIC_com_bytedance_mira_core_res_ResourcesFactory$HWResourcesAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(RES_CLASS_NAME).getDeclaredConstructor(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class, r100, IBinder.class});     // Catch: Exception -> L9
            r101.setAccessible(true);     // Catch: Exception -> L9
            return (Resources) r101.newInstance(new Object[]{r111, INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory$HWResourcesAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r110), r110.getConfiguration(), MethodUtils.invokeMethod(r110, "getDisplayAdjustments", new Object[0]), null});
        L9:
            e = move-exception;
            MiraLogger.e(ResourcesFactory.TAG, "create adapted hwResources over android7 failed: ".concat(r110.getClass().getName()), e);
            return null;
        }
    }

    public static class VivoResourcesAdapter extends DefaultResourcesAdapter {
        private static final String RES_CLASS_NAME = "android.content.res.VivoResources";

        private VivoResourcesAdapter() {
        }

        public /* synthetic */ VivoResourcesAdapter(AnonymousClass1 r100) {
            this();
        }

        public static boolean isVivoResources(String r100) {
            return RES_CLASS_NAME.equals(r100);
        }

        @Override // com.bytedance.mira.core.res.ResourcesFactory.DefaultResourcesAdapter
        public Resources createNewResources(Resources r100, AssetManager r101) {
            Resources r102 = super.createNewResources(r100, r101);
            if (r102 != null) goto L9;
        L8:
            return r102;
        L9:
            MethodUtils.invokeMethod(r102, "init", new Object[]{Mira.getAppContext().getPackageName()});     // Catch: Exception -> L6
            FieldUtils.writeField(r102, "mThemeValues", FieldUtils.readField(r100, "mThemeValues"));     // Catch: Exception -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public ResourcesFactory() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized Resources createResources(Resources r100, AssetManager r101) {
        monitor-enter(ResourcesFactory.class);
        String r102 = r100.getClass().getName();     // Catch: Throwable -> L17
        Resources r103 = null;
        Object[] r104 = 0;
        Object[] r105 = 0;
        if (RES_CLASS_NAME_STANDARD.equals(r102) == false) goto L7;
    L13:
        if (r103 != null) goto L15;
        r103 = new Resources(r101, INVOKEVIRTUAL_com_bytedance_mira_core_res_ResourcesFactory_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), r100.getConfiguration());     // Catch: Throwable -> L17
    L15:
        monitor-exit(ResourcesFactory.class);
        return r103;
    L7:
        if (HWResourcesAdapter.isHWResources(r102) == false) goto L10;
        r103 = new HWResourcesAdapter(r105 == true ? 1 : 0).createNewResources(r100, r101);     // Catch: Throwable -> L17
        goto L13
    L10:
        if (VivoResourcesAdapter.isVivoResources(r102) == false) goto L12;
        r103 = new VivoResourcesAdapter(r104 == true ? 1 : 0).createNewResources(r100, r101);     // Catch: Throwable -> L17
        goto L13
    L12:
        r103 = new DefaultResourcesAdapter().createNewResources(r100, r101);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
