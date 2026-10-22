package com.bytedance.caijing.sdk.infra.base.impl.abtest;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService;
import com.bytedance.dataplatform.o;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u000f\u001a\u0002H\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/abtest/ABTestServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/abtest/ABTestService;", "()V", "addExtraParameter", "", "parameter", "", "", "checkABSDKInstalled", "", "experimentKeyGetValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "type", "Ljava/lang/Class;", "defaultValue", "isExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "setting", "cj-host-service-impl-abtest_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ABTestServiceImpl implements ABTestService {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService
    public boolean checkABSDKInstalled() {
        INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_abtest_ABTestServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.dataplatform.ABExtraProvider");     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    public ABTestServiceImpl() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_abtest_ABTestServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService
    public void addExtraParameter(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "parameter");
        o.a(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService
    public void setting(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = b.f499326b;
        if (jj4.a.a(r100, Object.class, new Object(), false) != null) goto L6;
        Intrinsics.throwNpe();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService
    public <T> T experimentKeyGetValue(String r100, Class<T> r101, T r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        T r102 = (T) o.d(r100, r101, r110, false, r111, null);
        if (r102 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r102;
    }
}
