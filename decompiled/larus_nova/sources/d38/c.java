package d38;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends c38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f466757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<? extends Annotation> f466758b;

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.f466758b;
    }

    public c(l r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f466757a = r100;
        this.f466758b = Reflection.getOrCreateKotlinClass(SdkPush.class);
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return new com.larksuite.rucket.impl.sdkimpl.proxymethod.c(this.f466757a, r100);
    }
}
