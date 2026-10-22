package eqa;

import android.graphics.PointF;
import android.view.View;
import cqa.i;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f473559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f473560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f473561c;

    public d() {
        this.f473561c = true;
    }

    public final boolean a(View r100) {
        i r101 = this.f473560b;
        if (r101 == null) goto L7;
        return ((d) r101).a(r100);
    L7:
        return hqa.b.a(r100, this.f473559a, this.f473561c);
    }

    public final boolean b(View r100) {
        i r101 = this.f473560b;
        if (r101 == null) goto L7;
        return ((d) r101).b(r100);
    L7:
        return hqa.b.b(r100, this.f473559a);
    }
}
