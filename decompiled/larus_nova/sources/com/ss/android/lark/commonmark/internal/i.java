package com.ss.android.lark.commonmark.internal;

/* JADX INFO: loaded from: classes35.dex */
public final class i extends y7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v7b.g f417226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f417227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f417228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f417229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StringBuilder f417230e;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r110, h.a r111) {
            h r112 = (h) r110;
            int r113 = r112.f417212h;
            if (r113 < 4) goto L5;
            return null;
        L5:
            int r100 = r112.f417210f;
            CharSequence r114 = r112.f417205a.f558606a;
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
            d r108 = new d(new y7b.d[]{r115});
            r108.f417184b = r100 + r115.f417226a.f553552j.intValue();
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

    @Override // y7b.a, y7b.d
    public final void c() {
        v7b.g r100 = this.f417226a;
        r100.f553555m = u7b.a.b(this.f417229d.trim());
        v7b.g r101 = this.f417226a;
        r101.f553556n = this.f417230e.toString();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.f417226a;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r100) {
        if (this.f417229d != null) goto L5;
        this.f417229d = r100.f558606a.toString();
        return;
    L5:
        this.f417230e.append(r100.f558606a);
        this.f417230e.append('\n');
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r100) {
        h r101 = (h) r100;
        int r102 = r101.f417210f;
        int r103 = r101.f417207c;
        CharSequence r104 = r101.f417205a.f558606a;
        if (r101.f417212h < 4) goto L5;
    L37:
        int r105 = this.f417226a.f553554l;
        int r106 = r104.length();
    L38:
        if (r105 <= 0) goto L44;
        if (r103 >= r106) goto L44;
        if (r104.charAt(r103) != ' ') goto L44;
        r103 = r103 + 1;
        r105 = r105 - 1;
    L44:
        return y7b.c.a(r103);
    L5:
        if (r102 >= r104.length()) goto L37;
        char r107 = this.f417227b;
        int r108 = r104.length();
        int r109 = r102;
    L7:
        if (r109 >= r108) goto L12;
        if (r104.charAt(r109) != r107) goto L10;
        r109 = r109 + 1;
        goto L7
    L10:
        r108 = r109;
    L12:
        int r110 = r108 - r102;
        if (r110 >= this.f417228c) goto L16;
    L33:
        boolean r111 = false;
    L34:
        if (r111 == false) goto L37;
        return new b(-1, -1, true);
    L16:
        if (a8b.b.c(r104, r102 + r110, r104.length()) != r104.length()) goto L33;
        v7b.g r112 = this.f417226a;
        Integer r113 = Integer.valueOf(r110);
        if (r113 == null) goto L24;
        r112.getClass();
        if (r113.intValue() >= 3) goto L24;
        throw new IllegalArgumentException("closingFenceLength needs to be >= 3");
    L24:
        Integer r114 = r112.f553552j;
        if (r114 == null) goto L32;
        if (r113 == null) goto L32;
        if (r113.intValue() >= r114.intValue()) goto L32;
        throw new IllegalArgumentException("fence lengths required to be: closingFenceLength >= openingFenceLength");
    L32:
        r112.f553553k = r113;
        r111 = true;
        goto L34
    }

    public i(char r100, int r101, int r102) {
        v7b.g r103 = new v7b.g();
        this.f417226a = r103;
        this.f417230e = new StringBuilder();
        this.f417227b = r100;
        this.f417228c = r101;
        String.valueOf(r100);
        Integer r104 = Integer.valueOf(r101);
        if (r104 != null) goto L5;
    L9:
        Integer r105 = r103.f553553k;
        if (r104 == null) goto L17;
        if (r105 == null) goto L17;
        if (r105.intValue() >= r104.intValue()) goto L17;
        throw new IllegalArgumentException("fence lengths required to be: closingFenceLength >= openingFenceLength");
    L17:
        r103.f553552j = r104;
        r103.f553554l = r102;
        return;
    L5:
        if (r104.intValue() >= 3) goto L9;
        throw new IllegalArgumentException("openingFenceLength needs to be >= 3");
    }
}
