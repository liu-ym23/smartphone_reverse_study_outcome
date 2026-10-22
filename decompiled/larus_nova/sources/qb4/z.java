package qb4;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f532400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f532401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f532403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.bdturing.c f532404e;

    public final void a() {
        com.bytedance.bdturing.c r100 = this.f532404e;
        if (r100.f201752l == false) goto L5;
        return;
    L5:
        if (r100.f201743c == null) goto L15;
        com.bytedance.bdturing.c.b(r100);
        CardView r101 = this.f532404e.f201744d;
        if (r101 != null) goto L10;
    L12:
        ViewGroup.LayoutParams r102 = this.f532401b;
        r102.width = this.f532402c;
        r102.height = this.f532403d;
        this.f532404e.f201743c.setLayoutParams(r102);
        this.f532404e.f201743c.setVisibility(0);
        return;
    L10:
        if (this.f532400a == false) goto L12;
        r101.setRadius(0.0f);
        goto L12
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

    public z(com.bytedance.bdturing.c r100, boolean r101, ViewGroup.LayoutParams r102, int r103, int r104) {
        this.f532404e = r100;
        this.f532400a = r101;
        this.f532401b = r102;
        this.f532402c = r103;
        this.f532403d = r104;
    }
}
