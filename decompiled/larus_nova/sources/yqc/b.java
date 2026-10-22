package yqc;

import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.transform.OverlapPageTransformer;
import com.zhpan.bannerview.transform.ScaleInTransformer;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f568888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f568889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositePageTransformer f568890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MarginPageTransformer f568891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewPager2.PageTransformer f568892e;

    public final c a() {
        if (this.f568888a != null) goto L6;
        this.f568888a = new c();
    L6:
        return this.f568888a;
    }

    public b() {
        c r100 = new c();
        this.f568888a = r100;
        this.f568889b = new a(r100);
        this.f568890c = new CompositePageTransformer();
    }

    public final void b(boolean r100) {
        ViewPager2.PageTransformer r101 = this.f568892e;
        if (r101 == null) goto L5;
        this.f568890c.removeTransformer(r101);
    L5:
        if (r100 == false) goto L7;
        this.f568888a.getClass();
        this.f568892e = new OverlapPageTransformer();
    L8:
        this.f568890c.addTransformer(this.f568892e);
        return;
    L7:
        this.f568892e = new ScaleInTransformer();
        goto L8
    }
}
