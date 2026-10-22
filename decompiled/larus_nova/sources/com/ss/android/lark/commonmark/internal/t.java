package com.ss.android.lark.commonmark.internal;

import v7b.d0;

/* JADX INFO: loaded from: classes35.dex */
public final class t extends y7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f417273a;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r110, h.a r111) {
            h r112 = (h) r110;
            if (r112.f417212h < 4) goto L5;
            return null;
        L5:
            int r113 = r112.f417210f;
            CharSequence r100 = r112.f417205a.f558606a;
            int r101 = r100.length();
            int r102 = 0;
            int r103 = 0;
            int r104 = 0;
        L7:
            if (r113 >= r101) goto L24;
            char r105 = r100.charAt(r113);
            if (r105 == '\t') goto L22;
            if (r105 == ' ') goto L22;
            if (r105 != '*') goto L15;
            r104 = r104 + 1;
            goto L22
        L15:
            if (r105 != '-') goto L17;
            r102 = r102 + 1;
            goto L22
        L17:
            if (r105 != '_') goto L34;
            r103 = r103 + 1;
        L34:
            boolean r114 = false;
        L35:
            if (r114 == false) goto L38;
            d r115 = new d(new y7b.d[]{new t(String.valueOf(r100.subSequence(r112.f417207c, r100.length())))});
            r115.f417184b = r100.length();
            return r115;
        L38:
            return null;
        L22:
            r113 = r113 + 1;
            goto L7
        L24:
            if (r102 < 3) goto L27;
            if (r103 != 0) goto L27;
            if (r104 != 0) goto L27;
        L33:
            r114 = true;
        L27:
            if (r103 < 3) goto L30;
            if (r102 != 0) goto L30;
            if (r104 == 0) goto L33;
        L30:
            if (r104 < 3) goto L34;
            if (r102 != 0) goto L34;
            if (r103 != 0) goto L34;
            goto L33
        }
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r100) {
        return null;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.f417273a;
    }

    public t(String r100) {
        this.f417273a = new d0();
    }
}
