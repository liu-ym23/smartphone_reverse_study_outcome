package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.BdTuringVerifyActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdTuringVerifyActivity f532366e;

    public final void a() {
        BdTuringVerifyActivity r100 = this.f532366e;
        if (r100.f201666e == false) goto L6;
        return;
    L6:
        if (r100.f201662a.f498092c == false) goto L9;
        r100.f201669h.clearAnimation();
        r100.f201669h.setVisibility(8);
    L9:
        if (this.f532362a == false) goto L13;
        CardView r101 = this.f532366e.f201671j;
        if (r101 == null) goto L13;
        r101.setRadius(0.0f);
    L13:
        ViewGroup.LayoutParams r102 = this.f532363b;
        r102.width = this.f532364c;
        r102.height = this.f532365d;
        this.f532366e.f201670i.setLayoutParams(r102);
        this.f532366e.f201670i.setVisibility(0);
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

    public j(BdTuringVerifyActivity r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532366e = r100;
        this.f532362a = r101;
        this.f532363b = r102;
        this.f532364c = r103;
        this.f532365d = r104;
    }
}
