package i73;

import hl.i;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f488459a;

    @Override // hl.i
    public final void onAnimationEnd() {
        Function1 r100 = this.f488459a;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r100.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }

    public a(Function1 r100) {
        this.f488459a = r100;
    }
}
