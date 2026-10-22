package l70;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T extends b> implements com.bytedance.android.live.core.tetris.layer.core.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f507762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v70.a f507763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleOwner f507764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.data.b f507765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.delegate.b f507766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f507767f;

    public abstract void c();

    public abstract void d();

    public final T b() {
        T r100 = this.f507762a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        this.f507767f = r100;
    }

    public final void a(ElementConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "elementConstraint");
        com.bytedance.android.live.core.tetris.layer.core.delegate.b r101 = this.f507766e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("constraintRefresh");
    L5:
        r101.a(this.f507767f, r100);
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroidx/lifecycle/ViewModel;>(Ljava/lang/Class<TT;>;)TT; */
    @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
    public final ViewModel getViewModel(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        com.bytedance.android.live.core.tetris.layer.core.data.b r101 = this.f507765d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r101.getViewModel(r100);
    }
}
