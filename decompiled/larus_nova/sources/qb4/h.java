package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.BdTuringQaSmsVerifyActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdTuringQaSmsVerifyActivity f532356e;

    public final void a() {
        BdTuringQaSmsVerifyActivity r100 = this.f532356e;
        if (r100.f201644e == false) goto L6;
        return;
    L6:
        if (r100.f201640a.f498092c == false) goto L9;
        r100.f201647h.clearAnimation();
        r100.f201647h.setVisibility(8);
    L9:
        if (this.f532352a == false) goto L13;
        CardView r101 = this.f532356e.f201649j;
        if (r101 == null) goto L13;
        r101.setRadius(0.0f);
    L13:
        ViewGroup.LayoutParams r102 = this.f532353b;
        r102.width = this.f532354c;
        r102.height = this.f532355d;
        this.f532356e.f201648i.setLayoutParams(r102);
        this.f532356e.f201648i.setVisibility(0);
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

    public h(BdTuringQaSmsVerifyActivity r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532356e = r100;
        this.f532352a = r101;
        this.f532353b = r102;
        this.f532354c = r103;
        this.f532355d = r104;
    }
}
