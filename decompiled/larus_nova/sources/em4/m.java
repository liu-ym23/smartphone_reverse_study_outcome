package em4;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes15.dex */
public final class m extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f473070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f473071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f473072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f473073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f473074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f473075f;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r110, Outline r111) {
        int r100 = this.f473070a.getWidth();
        int r101 = this.f473070a.getHeight();
        int r112 = ((((this.f473071b ? 1 : 0) << 3) + ((this.f473072c ? 1 : 0) << 2)) + ((this.f473073d ? 1 : 0) << 1)) + (this.f473074e ? 1 : 0);
        if (r112 == 1) goto L35;
        if (r112 == 2) goto L33;
        if (r112 != 3) goto L7;
        if (r111 == null) goto L50;
        float r102 = this.f473075f;
        r111.setRoundRect(0, (int) (0 - r102), r100, r101, r102);
        return;
    L50:
        return;
    L7:
        if (r112 != 4) goto L9;
        if (r111 == null) goto L48;
        float r103 = this.f473075f;
        r111.setRoundRect((int) (0 - r103), 0, r100, (int) (r101 + r103), r103);
        return;
    L48:
        return;
    L9:
        if (r112 != 5) goto L11;
        if (r111 == null) goto L46;
        float r104 = this.f473075f;
        r111.setRoundRect((int) (0 - r104), 0, r100, r101, r104);
        return;
    L46:
        return;
    L11:
        if (r112 != 8) goto L13;
        if (r111 == null) goto L44;
        float r105 = this.f473075f;
        r111.setRoundRect(0, 0, (int) (r100 + r105), (int) (r101 + r105), r105);
        return;
    L44:
        return;
    L13:
        if (r112 != 10) goto L15;
        if (r111 == null) goto L42;
        float r106 = this.f473075f;
        r111.setRoundRect(0, 0, (int) (r100 + r106), r101, r106);
        return;
    L42:
        return;
    L15:
        if (r112 != 12) goto L17;
        if (r111 == null) goto L40;
        float r107 = this.f473075f;
        r111.setRoundRect(0, 0, r100, (int) (r101 + r107), r107);
        return;
    L40:
        return;
    L17:
        if (r112 != 15) goto L55;
        if (r111 == null) goto L38;
        r111.setRoundRect(0, 0, r100, r101, this.f473075f);
        return;
    L38:
        return;
    L55:
        return;
    L33:
        if (r111 == null) goto L52;
        float r108 = this.f473075f;
        r111.setRoundRect(0, (int) (0 - r108), (int) (r100 + r108), r101, r108);
        return;
    L52:
        return;
    L35:
        if (r111 == null) goto L54;
        float r113 = 0;
        float r109 = this.f473075f;
        r111.setRoundRect((int) (r113 - r109), (int) (r113 - r109), r100, r101, r109);
        return;
    }

    public m(View r100, boolean r101, boolean r102, boolean r103, boolean r104, float r105) {
        this.f473070a = r100;
        this.f473071b = r101;
        this.f473072c = r102;
        this.f473073d = r103;
        this.f473074e = r104;
        this.f473075f = r105;
    }
}
