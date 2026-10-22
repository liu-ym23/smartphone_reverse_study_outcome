package wsc;

import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;

/* JADX INFO: loaded from: classes5.dex */
public final class i extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f561141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f561142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f561143c;

    @Override // wsc.p
    public final Rect a(a r110) {
        if ((r110 instanceof h) == false) goto L5;
        ((h) r110).getClass();
    L5:
        Rect r100 = this.f561141a;
        if (r100 != null) goto L8;
    L10:
        o r101 = r110.f561118c;
        Rect r102 = r110.f561120e.getBounds();
        int r103 = Math.max(this.f561142b, r110.f561122g) - 0;
        float r111 = r110.f561123h;
        if (r101 != null) goto L13;
        int r112 = r.f561177a;
        return r.a(r102, r103, this.f561143c);
    L13:
        o.a r104 = r101.f561173a;
        o.a r105 = r101.f561174b;
        float r106 = r102.width() / r102.height();
        if (r104 != null) goto L16;
        if (r105 != null) goto L28;
    L30:
        int r113 = r.f561177a;
        return r.a(r102, r103, this.f561143c);
    L28:
        if (GXTemplateKey.GAIAX_PE.equals(r105.f561176b) == true) goto L30;
        int r114 = r.c(r105, r111);
        r102 = new Rect(0, 0, (int) ((r114 * r106) + 0.5f), r114);
        goto L30
    L16:
        if (GXTemplateKey.GAIAX_PE.equals(r104.f561176b) == false) goto L18;
        int r107 = (int) (r103 * (r104.f561175a / 100.0f));
    L19:
        if (r105 != null) goto L21;
    L24:
        int r115 = (int) ((r107 / r106) + 0.5f);
    L25:
        r102 = new Rect(0, 0, r107, r115);
        goto L30
    L21:
        if (GXTemplateKey.GAIAX_PE.equals(r105.f561176b) == true) goto L24;
        r115 = r.c(r105, r111);
        goto L25
    L18:
        r107 = r.c(r104, r111);
        goto L19
    L8:
        if (r110.f561118c != null) goto L10;
        return r100;
    }

    public i(Rect r100, int r101, int r102) {
        this.f561141a = r100;
        this.f561142b = r101;
        this.f561143c = r102;
    }
}
