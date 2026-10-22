package fp9;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class l implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rv9.c f478325b;

    public /* synthetic */ l(int r100, rv9.c r101) {
        this.f478324a = r100;
        this.f478325b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return "jank degrade execution failed, currentIndex=" + this.f478324a + ", totalCount=" + this.f478325b.c();
    }
}
