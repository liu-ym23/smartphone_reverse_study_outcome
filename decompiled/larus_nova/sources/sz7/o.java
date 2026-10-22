package sz7;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes24.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f544002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f544003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f544004c;

    @Override // sz7.k
    public final void setIcon(Drawable r100) {
        Integer r101 = this.f544002a;
        if (r101 == null) goto L12;
        if (r101 != null) goto L7;
    L8:
        if (r100 == null) goto L10;
        r100.mutate();
    L10:
        if (r100 == null) goto L12;
        r100.setTint(this.f544002a.intValue());
        goto L12
    L7:
        if (r101.intValue() != 0) goto L8;
    L12:
        q r102 = this.f544003b;
        r102.e(q.a(r102, r100, this.f544004c));
    }

    public o(Integer r100, q r101, Drawable r102) {
        this.f544002a = r100;
        this.f544003b = r101;
        this.f544004c = r102;
    }
}
