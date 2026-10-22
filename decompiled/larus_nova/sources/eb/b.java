package eb;

import com.lynx.tasm.q1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f471780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f471781b;

    @Override // com.lynx.tasm.q1
    public final void onFirstScreen() {
        super.onFirstScreen();
        this.f471781b.invoke();
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.f471780a.invoke();
    }

    public b(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onLoadSuccessOuter");
        Intrinsics.checkNotNullParameter(r101, "onFirstScreenOuter");
        this.f471780a = r100;
        this.f471781b = r101;
    }
}
