package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.BdTuringQaSmsVerifyActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdTuringQaSmsVerifyActivity f532351e;

    public final void a() {
        BdTuringQaSmsVerifyActivity r100 = this.f532351e;
        if (r100.f201644e == false) goto L5;
        return;
    L5:
        if (r100.f201648i != null) goto L8;
        return;
    L8:
        if (r100.f201640a.f498092c == false) goto L11;
        r100.f201647h.clearAnimation();
        r100.f201647h.setVisibility(8);
    L11:
        if (this.f532347a == false) goto L15;
        CardView r101 = this.f532351e.f201649j;
        if (r101 == null) goto L15;
        r101.setRadius(0.0f);
    L15:
        ViewGroup.LayoutParams r102 = this.f532348b;
        r102.width = this.f532349c;
        r102.height = this.f532350d;
        this.f532351e.f201648i.setLayoutParams(r102);
        this.f532351e.f201648i.setVisibility(0);
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

    public g(BdTuringQaSmsVerifyActivity r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532351e = r100;
        this.f532347a = r101;
        this.f532348b = r102;
        this.f532349c = r103;
        this.f532350d = r104;
    }
}
