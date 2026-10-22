package m33;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a<STATE extends g, PROPS extends u33.a> extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l33.b<STATE, PROPS> f511708a;

    public abstract String d();

    public abstract void e(e43.a r100);

    public a(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.f511708a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        e(new e43.a(r100, r101));
    }
}
