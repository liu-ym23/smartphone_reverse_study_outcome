package d38;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends c38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f466754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<? extends Annotation> f466755b;

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.f466755b;
    }

    public a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f466754a = r100;
        this.f466755b = Reflection.getOrCreateKotlinClass(SdkCall.class);
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return new com.larksuite.rucket.impl.sdkimpl.proxymethod.a(this.f466754a, r100);
    }
}
