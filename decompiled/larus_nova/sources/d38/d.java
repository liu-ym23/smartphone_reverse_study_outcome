package d38;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.impl.sdkimpl.proxymethod.SdkPushProxyMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends c38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<? extends Annotation> f466759a;

    public d() {
        this.f466759a = Reflection.getOrCreateKotlinClass(SdkPush.class);
    }

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.f466759a;
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return new SdkPushProxyMethod(r100);
    }
}
