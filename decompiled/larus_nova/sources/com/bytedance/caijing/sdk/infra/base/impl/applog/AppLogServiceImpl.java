package com.bytedance.caijing.sdk.infra.base.impl.applog;

import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/applog/AppLogServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/applog/AppLogService;", "()V", "addCommonParams", "", "url", "isApi", "", "checkInstall", "onEventV3", "", "event", "param", "Lorg/json/JSONObject;", "cj-host-service-impl-applog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppLogServiceImpl implements AppLogService {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService
    public boolean checkInstall() {
        INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_applog_AppLogServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.common.applog.ApplogServiceImpl");     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    public AppLogServiceImpl() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_applog_AppLogServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService
    public String addCommonParams(String r100, boolean r101) {
        return c0.b(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService
    public void onEventV3(String r100, JSONObject r101) {
        AppLogNewUtils.onEventV3(r100, r101);
    }
}
