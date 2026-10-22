package vc6;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;
import zz0.j;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f554113f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f554114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f554115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f554116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f554117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zz0.b f554118e;

    public static final class a {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    static {
        f554113f = (String) m12.b.f511584k.getValue(null, m12.b.f511574a[9]);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f554114a.dispose();
        this.f554116c = null;
        this.f554115b = false;
    }

    public b(g r100, zz0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "routerService");
        this.f554117d = r100;
        this.f554118e = r101;
        this.f554114a = new CompositeDisposable();
    }
}
