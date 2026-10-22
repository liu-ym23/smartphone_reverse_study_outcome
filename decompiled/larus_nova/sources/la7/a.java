package la7;

import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f508205a;

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        d r100 = this.f508205a;
        if (r100.f508213c == false) goto L7;
        r100.b(0.0f);
        r100.f508213c = false;
        r100.a();
        return;
    }

    public a(d r100) {
        this.f508205a = r100;
    }
}
