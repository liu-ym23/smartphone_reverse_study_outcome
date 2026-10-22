package np4;

import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view.HorizontalScrollBar;
import kotlin.jvm.internal.Intrinsics;
import mt4.b;
import mt4.c;
import mt4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f520039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HorizontalScrollBar f520040b;

    @Override // mt4.b
    public final void a(int r100) {
        this.f520040b.setRvScrollRange(r100);
        this.f520040b.a();
    }

    public a(d r100, HorizontalScrollBar r101) {
        this.f520039a = r100;
        this.f520040b = r101;
    }

    @Override // mt4.b
    public final void b(c r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "position");
        float r105 = r101 / this.f520039a.f515638b.f515641c;
        HorizontalScrollBar r106 = this.f520040b;
        int r107 = r106.getMeasuredWidth();
        HorizontalScrollBar r108 = this.f520040b;
        r106.f207695c = r107 - r108.f207696d;
        r108.f207693a.setTranslationX(r105 * r108.f207695c);
    }
}
