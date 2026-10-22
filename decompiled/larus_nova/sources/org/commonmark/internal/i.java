package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;

/* JADX INFO: loaded from: classes42.dex */
public class i extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FencedCodeBlock f525706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f525707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f525708c;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r110, h.a r111) {
            h r112 = (h) r110;
            int r113 = r112.f525696g;
            if (r113 < 4) goto L5;
            return null;
        L5:
            int r100 = r112.f525694e;
            CharSequence r114 = r112.f525690a;
            int r101 = r114.length();
            int r102 = r100;
            int r103 = 0;
            int r104 = 0;
        L7:
            if (r102 >= r101) goto L16;
            char r105 = r114.charAt(r102);
            if (r105 == '`') goto L13;
            if (r105 != '~') goto L16;
            r104 = r104 + 1;
        L14:
            r102 = r102 + 1;
            goto L7
        L13:
            r103 = r103 + 1;
        L16:
            if (r103 < 3) goto L29;
            if (r104 != 0) goto L29;
            int r106 = r100 + r103;
            int r107 = r114.length();
        L20:
            if (r106 >= r107) goto L25;
            if (r114.charAt(r106) == '`') goto L26;
            r106 = r106 + 1;
        L26:
            if (r106 != (-1)) goto L32;
            i r115 = new i('`', r103, r113);
        L33:
            if (r115 == null) goto L42;
            d r108 = new d(new wvc.d[]{r115});
            r108.f525669b = r100 + r115.f525706a.f525763i;
            return r108;
        L42:
            return null;
        L32:
            r115 = null;
            goto L33
        L25:
            r106 = -1;
        L29:
            if (r104 < 3) goto L32;
            if (r103 != 0) goto L32;
            r115 = new i('~', r104, r113);
            goto L33
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        FencedCodeBlock r100 = this.f525706a;
        r100.f525765k = tvc.a.a(this.f525707b.trim());
        FencedCodeBlock r101 = this.f525706a;
        r101.f525766l = this.f525708c.toString();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525706a;
    }

    @Override // wvc.a, wvc.d
    public void d(CharSequence r100) {
        if (this.f525707b != null) goto L5;
        this.f525707b = r100.toString();
        return;
    L5:
        this.f525708c.append(r100);
        this.f525708c.append('\n');
    }

    @Override // wvc.d
    public wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        int r102 = r101.f525694e;
        int r103 = r101.f525691b;
        CharSequence r104 = r101.f525690a;
        boolean r105 = false;
        if (r101.f525696g >= 4) goto L13;
        FencedCodeBlock r106 = this.f525706a;
        char r107 = r106.f525762h;
        int r108 = r106.f525763i;
        int r109 = tvc.d.b(r107, r104, r102, r104.length()) - r102;
        if (r109 >= r108) goto L8;
    L10:
        boolean r110 = false;
    L11:
        if (r110 == false) goto L13;
        r105 = true;
        goto L13
    L8:
        if (tvc.d.c(r104, r102 + r109, r104.length()) != r104.length()) goto L10;
        r110 = true;
    L13:
        if (r105 == true) goto L15;
        int r111 = this.f525706a.f525764j;
        int r112 = r104.length();
    L17:
        if (r111 <= 0) goto L23;
        if (r103 >= r112) goto L23;
        if (r104.charAt(r103) != ' ') goto L23;
        r103 = r103 + 1;
        r111 = r111 - 1;
    L23:
        return wvc.c.a(r103);
    L15:
        return wvc.c.b();
    }

    public i(char r100, int r101, int r102) {
        FencedCodeBlock r103 = new FencedCodeBlock();
        this.f525706a = r103;
        this.f525708c = new StringBuilder();
        r103.f525762h = r100;
        r103.f525763i = r101;
        r103.f525764j = r102;
    }
}
