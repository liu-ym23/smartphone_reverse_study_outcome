package rvc;

import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.internal.f;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements xvc.a {
    public a() {
    }

    @Override // xvc.a
    public final int a() {
        return 2;
    }

    @Override // xvc.a
    public final char b() {
        return '~';
    }

    @Override // xvc.a
    public final char c() {
        return '~';
    }

    @Override // xvc.a
    public final int d(f r100, f r101) {
        if (r100.f525685g >= 2) goto L5;
        return 0;
    L5:
        if (r101.f525685g < 2) goto L9;
        return 2;
    L9:
        return 0;
    }

    @Override // xvc.a
    public final void e(Text r100, Text r101, int r102) {
        Strikethrough r103 = new Strikethrough();
        b r104 = r100.f551904e;
    L3:
        if (r104 == null) goto L6;
        if (r104 == r101) goto L6;
        b r105 = r104.f551904e;
        r103.b(r104);
        r104 = r105;
    L6:
        r100.d(r103);
    }
}
