package tdc;

import android.graphics.Rect;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView.ScaleType f545540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView.ScaleType f545541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f545542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f545543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f545544e;

    @Override // tdc.a
    public final ImageView.ScaleType a() {
        return this.f545541b;
    }

    @Override // tdc.a
    public final ImageView.ScaleType b() {
        return this.f545540a;
    }

    @Override // tdc.a
    public final Rect c() {
        return this.f545543d;
    }

    @Override // tdc.a
    public final Rect d() {
        return this.f545544e;
    }

    @Override // tdc.a
    public final long e() {
        return this.f545542c;
    }

    public b(ImageView.ScaleType r100, ImageView.ScaleType r101, long r102, Rect r103, Rect r104) {
        Intrinsics.checkNotNullParameter(r100, "originScaleType");
        Intrinsics.checkNotNullParameter(r101, "terminalScaleType");
        Intrinsics.checkNotNullParameter(r103, "originViewRect");
        Intrinsics.checkNotNullParameter(r104, "terminalViewRect");
        this.f545540a = r100;
        this.f545541b = r101;
        this.f545542c = r102;
        this.f545543d = r103;
        this.f545544e = r104;
    }
}
