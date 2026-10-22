package d38;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerPush;
import com.larksuite.rucket.impl.serverimpl.proxymethod.ServerPushProxyMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class g extends c38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<? extends Annotation> f466763a;

    public g() {
        this.f466763a = Reflection.getOrCreateKotlinClass(ServerPush.class);
    }

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.f466763a;
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return new ServerPushProxyMethod(r100);
    }
}
