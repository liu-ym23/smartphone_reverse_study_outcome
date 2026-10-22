package o6a;

import android.graphics.PointF;
import android.view.View;
import m6a.j;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f522222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f522223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f522224c;

    public d() {
        this.f522224c = true;
    }

    public final boolean a(View r100) {
        j r101 = this.f522223b;
        if (r101 == null) goto L7;
        return ((d) r101).a(r100);
    L7:
        return r6a.b.a(r100, this.f522222a, this.f522224c);
    }

    public final boolean b(View r100) {
        j r101 = this.f522223b;
        if (r101 == null) goto L7;
        return ((d) r101).b(r100);
    L7:
        return r6a.b.b(r100, this.f522222a);
    }
}
