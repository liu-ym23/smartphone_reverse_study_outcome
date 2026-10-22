package hv1;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f487279a;

    public b(a r100) {
        this.f487279a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        this.f487279a.f487278c.onRuntimeReady();
    }
}
