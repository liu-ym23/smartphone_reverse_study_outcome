package or9;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import pr9.h;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f524973a;

    @Override // pr9.h
    public final void N7() {
    }

    @Override // pr9.h
    public final void V5() {
    }

    @Override // pr9.h
    public final boolean onBackPressed() {
        return false;
    }

    @Override // pr9.h
    public final void xQ(pr9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public b() {
        this.f524973a = new Fragment();
    }

    @Override // pr9.h
    public final Fragment f() {
        return this.f524973a;
    }
}
