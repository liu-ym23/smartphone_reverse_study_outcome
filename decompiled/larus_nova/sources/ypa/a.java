package ypa;

import android.graphics.PointF;
import android.view.View;
import xpa.h;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f568726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f568727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f568728c;

    public a() {
        this.f568728c = true;
    }

    @Override // xpa.h
    public final boolean a(View r100) {
        h r101 = this.f568727b;
        if (r101 == null) goto L7;
        return r101.a(r100);
    L7:
        return zpa.b.a(r100, this.f568726a, this.f568728c);
    }

    @Override // xpa.h
    public final boolean b(View r100) {
        h r101 = this.f568727b;
        if (r101 == null) goto L7;
        return r101.b(r100);
    L7:
        return zpa.b.b(r100, this.f568726a);
    }
}
