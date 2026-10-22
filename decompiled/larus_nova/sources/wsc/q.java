package wsc;

import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;

/* JADX INFO: loaded from: classes41.dex */
public final class q extends p {
    public q() {
    }

    @Override // wsc.p
    public final Rect a(a r100) {
        o r101 = r100.f561118c;
        Rect r102 = r100.f561120e.getBounds();
        int r103 = r100.f561122g;
        float r104 = r100.f561123h;
        if (r101 != null) goto L8;
        int r105 = r102.width();
        if (r105 <= r103) goto L26;
        Rect r106 = new Rect(0, 0, r103, (int) ((r102.height() / (r105 / r103)) + 0.5f));
    L27:
        return r106;
    L26:
        return r102;
    L8:
        o.a r107 = r101.f561173a;
        o.a r108 = r101.f561174b;
        float r109 = r102.width() / r102.height();
        if (r107 != null) goto L11;
        if (r108 != null) goto L23;
        return r102;
    L23:
        if (GXTemplateKey.GAIAX_PE.equals(r108.f561176b) == true) goto L29;
        int r110 = b(r108, r104);
        return new Rect(0, 0, (int) ((r110 * r109) + 0.5f), r110);
    L29:
        return r102;
    L11:
        if (GXTemplateKey.GAIAX_PE.equals(r107.f561176b) == false) goto L13;
        int r111 = (int) ((r103 * (r107.f561175a / 100.0f)) + 0.5f);
    L14:
        if (r108 != null) goto L16;
    L19:
        int r112 = (int) ((r111 / r109) + 0.5f);
    L20:
        r106 = new Rect(0, 0, r111, r112);
        goto L27
    L16:
        if (GXTemplateKey.GAIAX_PE.equals(r108.f561176b) == true) goto L19;
        r112 = b(r108, r104);
        goto L20
    L13:
        r111 = b(r107, r104);
        goto L14
    }

    public static int b(o.a r100, float r101) {
        if ("em".equals(r100.f561176b) == false) goto L5;
        float r102 = r100.f561175a * r101;
    L7:
        return (int) (r102 + 0.5f);
    L5:
        r102 = r100.f561175a;
        goto L7
    }
}
