package sb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f541244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f541245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f541246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f541247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ VerifyConfirmDialogActivity f541248e;

    public final void a() {
        VerifyConfirmDialogActivity r100 = this.f541248e;
        if (r100.f201785j == false) goto L5;
        return;
    L5:
        if (r100.f201783h == null) goto L15;
        r100.runOnUiThread(new vb4.k(r100));
        if (this.f541244a == false) goto L12;
        CardView r101 = this.f541248e.f201784i;
        if (r101 == null) goto L12;
        r101.setRadius(0.0f);
    L12:
        ViewGroup.LayoutParams r102 = this.f541245b;
        r102.width = this.f541246c;
        r102.height = this.f541247d;
        this.f541248e.f201783h.setLayoutParams(r102);
        this.f541248e.f201783h.setVisibility(0);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(VerifyConfirmDialogActivity r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f541248e = r100;
        this.f541244a = r101;
        this.f541245b = r102;
        this.f541246c = r103;
        this.f541247d = r104;
    }
}
