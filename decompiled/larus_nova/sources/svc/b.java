package svc;

import org.commonmark.internal.f;
import org.commonmark.node.Emphasis;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements xvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f543686a;

    @Override // xvc.a
    public final int a() {
        return 1;
    }

    @Override // xvc.a
    public final char b() {
        return this.f543686a;
    }

    @Override // xvc.a
    public final char c() {
        return this.f543686a;
    }

    public b(char r100) {
        this.f543686a = r100;
    }

    @Override // xvc.a
    public final int d(f r100, f r101) {
        if (r100.f525682d == false) goto L5;
    L6:
        int r102 = r101.f525686h;
        if ((r102 % 3) != 0) goto L9;
    L13:
        if (r100.f525685g >= 2) goto L15;
        return 1;
    L15:
        if (r101.f525685g < 2) goto L19;
        return 2;
    L19:
        return 1;
    L9:
        if (((r100.f525686h + r102) % 3) != 0) goto L13;
        return 0;
    L5:
        if (r101.f525681c == false) goto L13;
        goto L6
    }

    @Override // xvc.a
    public final void e(Text r100, Text r101, int r102) {
        String r103 = String.valueOf(this.f543686a);
        if (r102 != 1) goto L5;
        uvc.b r104 = new Emphasis(r103);
    L6:
        uvc.b r105 = r100.f551904e;
    L7:
        if (r105 == null) goto L10;
        if (r105 == r101) goto L10;
        uvc.b r106 = r105.f551904e;
        r104.b(r105);
        r105 = r106;
    L10:
        r100.d(r104);
        return;
    L5:
        r104 = new StrongEmphasis(r103 + r103);
        goto L6
    }
}
