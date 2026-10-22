package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.BdTuringVerifyActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdTuringVerifyActivity f532361e;

    public final void a() {
        BdTuringVerifyActivity r100 = this.f532361e;
        if (r100.f201666e == false) goto L5;
        return;
    L5:
        if (r100.f201670i != null) goto L8;
        return;
    L8:
        if (r100.f201662a.f498092c == false) goto L10;
        r100.f201669h.clearAnimation();
        r100.f201669h.setVisibility(8);
    L10:
        CardView r101 = this.f532361e.f201671j;
        if (r101 != null) goto L13;
    L15:
        ViewGroup.LayoutParams r102 = this.f532358b;
        r102.width = this.f532359c;
        r102.height = this.f532360d;
        this.f532361e.f201670i.setLayoutParams(r102);
        this.f532361e.f201670i.setVisibility(0);
        return;
    L13:
        if (this.f532357a == false) goto L15;
        r101.setRadius(0.0f);
        goto L15
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

    public i(BdTuringVerifyActivity r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532361e = r100;
        this.f532357a = r101;
        this.f532358b = r102;
        this.f532359c = r103;
        this.f532360d = r104;
    }
}
