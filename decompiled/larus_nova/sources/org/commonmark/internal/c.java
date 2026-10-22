package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;

/* JADX INFO: loaded from: classes42.dex */
public final class c extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockQuote f525667a;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r100, h.a r101) {
            int r102 = ((h) r100).f525694e;
            if (c.h(r100, r102) == false) goto L17;
            h r103 = (h) r100;
            int r104 = (r103.f525692c + r103.f525696g) + 1;
            CharSequence r105 = r103.f525690a;
            int r106 = r102 + 1;
            if (r106 >= r105.length()) goto L12;
            char r107 = r105.charAt(r106);
            if (r107 != '\t') goto L9;
        L11:
            boolean r108 = true;
        L13:
            if (r108 == false) goto L15;
            r104 = r104 + 1;
        L15:
            d r109 = new d(new wvc.d[]{new c()});
            r109.f525670c = r104;
            return r109;
        L9:
            if (r107 == ' ') goto L11;
        L12:
            r108 = false;
            goto L13
        L17:
            return null;
        }
    }

    public c() {
        this.f525667a = new BlockQuote();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525667a;
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        int r101 = ((h) r100).f525694e;
        if (h(r100, r101) == false) goto L15;
        h r102 = (h) r100;
        int r103 = r102.f525692c + r102.f525696g;
        boolean r104 = true;
        int r105 = r103 + 1;
        CharSequence r106 = r102.f525690a;
        int r107 = r101 + 1;
        if (r107 >= r106.length()) goto L10;
        char r108 = r106.charAt(r107);
        if (r108 != '\t') goto L9;
    L11:
        if (r104 == false) goto L14;
        r105 = r105 + 1;
    L14:
        return new b(-1, r105, false);
    L9:
        if (r108 == ' ') goto L11;
    L10:
        r104 = false;
        goto L11
    L15:
        return null;
    }

    public static boolean h(wvc.g r100, int r101) {
        CharSequence r102 = ((h) r100).f525690a;
        if (((h) r100).f525696g < 4) goto L5;
    L9:
        return false;
    L5:
        if (r101 >= r102.length()) goto L9;
        if (r102.charAt(r101) != '>') goto L9;
        return true;
    }
}
