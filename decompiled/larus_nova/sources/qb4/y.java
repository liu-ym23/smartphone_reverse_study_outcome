package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.bdturing.c f532399e;

    public final void a() {
        com.bytedance.bdturing.c r100 = this.f532399e;
        if (r100.f201752l == false) goto L5;
        return;
    L5:
        com.bytedance.bdturing.c.b(r100);
        if (this.f532395a == false) goto L10;
        CardView r101 = this.f532399e.f201744d;
        if (r101 == null) goto L10;
        r101.setRadius(0.0f);
    L10:
        ViewGroup.LayoutParams r102 = this.f532396b;
        r102.width = this.f532397c;
        r102.height = this.f532398d;
        this.f532399e.f201743c.setLayoutParams(r102);
        this.f532399e.f201743c.setVisibility(0);
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

    public y(com.bytedance.bdturing.c r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532399e = r100;
        this.f532395a = r101;
        this.f532396b = r102;
        this.f532397c = r103;
        this.f532398d = r104;
    }
}
