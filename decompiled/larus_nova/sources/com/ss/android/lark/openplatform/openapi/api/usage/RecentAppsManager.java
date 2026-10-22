package com.ss.android.lark.openplatform.openapi.api.usage;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import el9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public class RecentAppsManager implements IRecentAppsManager {
    private static final String TAG = "RecentAppsManager";
    private IRecentAppsManager recentAppsImpl;

    public interface OnAppDeleteListener {
        void onFail(String r100);

        void onSuccess();
    }

    public interface OnDataGetListener {
        void onFail(boolean r100);

        void onSuccess(List<AppLaunchInfo> r100, boolean r101);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public IRecentAppsManager getImpl() {
        if (this.recentAppsImpl != null) goto L10;
        this.recentAppsImpl = (IRecentAppsManager) INVOKESTATIC_com_ss_android_lark_openplatform_openapi_api_usage_RecentAppsManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppbrandHostConstants.ImplClass.RECENT_APPS_MANAGER_IMPL).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
    L10:
        return this.recentAppsImpl;
    }

    public RecentAppsManager() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_openplatform_openapi_api_usage_RecentAppsManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public void addDataChangeListener(DataChangeListener r100) {
        if (getImpl() == null) goto L6;
        this.recentAppsImpl.addDataChangeListener(r100);
        return;
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public boolean removeDataChangeListener(DataChangeListener r100) {
        if (getImpl() != null) goto L5;
        return false;
    L5:
        return this.recentAppsImpl.removeDataChangeListener(r100);
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public List<AppLaunchInfo> getRecentAppList(OnDataGetListener r100, IAppContext r101) {
        if (getImpl() == null) goto L7;
        return this.recentAppsImpl.getRecentAppList(r100, r101);
    L7:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public void deleteRecentApp(String r100, OnAppDeleteListener r101, IAppContext r102) {
        if (getImpl() == null) goto L6;
        this.recentAppsImpl.deleteRecentApp(r100, r101, r102);
        return;
    }
}
