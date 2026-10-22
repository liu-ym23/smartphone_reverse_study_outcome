package uz1;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import i12.d;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f552170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.scope.a<BaseMVIViewModel<?, ?>> f552171b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.anya.b
    public final Collection<BaseMVIViewModel<?, ?>> d() {
        return this.f552171b;
    }

    @Override // com.bytedance.android.anya.b
    public final <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Iterator<BaseMVIViewModel<?, ?>> r101 = this.f552171b.iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L8;
        BaseMVIViewModel<?, ?> r103 = r101.next();
        if (r100.isInstance(r103) == false) goto L3;
    L10:
        if ((r103 instanceof BaseMVIViewModel) == false) goto L14;
        r102 = r103;
    L14:
        return (BaseMVIViewModel) r102;
    L8:
        r103 = null;
        goto L10
    }

    public a(d r100, e33.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "viewModelList");
        this.f552170a = r100;
        this.f552171b = r101;
    }
}
