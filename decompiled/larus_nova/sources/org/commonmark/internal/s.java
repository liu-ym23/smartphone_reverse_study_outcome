package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes42.dex */
public final class s extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThematicBreak f525758a;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r110, h.a r111) {
            h r112 = (h) r110;
            if (r112.f525696g < 4) goto L5;
            return null;
        L5:
            int r113 = r112.f525694e;
            CharSequence r114 = r112.f525690a;
            int r100 = r114.length();
            int r101 = 0;
            int r102 = 0;
            int r103 = 0;
        L7:
            if (r113 >= r100) goto L24;
            char r104 = r114.charAt(r113);
            if (r104 == '\t') goto L22;
            if (r104 == ' ') goto L22;
            if (r104 != '*') goto L15;
            r103 = r103 + 1;
            goto L22
        L15:
            if (r104 != '-') goto L17;
            r101 = r101 + 1;
            goto L22
        L17:
            if (r104 != '_') goto L34;
            r102 = r102 + 1;
        L34:
            boolean r115 = false;
        L35:
            if (r115 == false) goto L38;
            d r105 = new d(new wvc.d[]{new s()});
            r105.f525669b = r114.length();
            return r105;
        L38:
            return null;
        L22:
            r113 = r113 + 1;
            goto L7
        L24:
            if (r101 < 3) goto L27;
            if (r102 != 0) goto L27;
            if (r103 != 0) goto L27;
        L33:
            r115 = true;
        L27:
            if (r102 < 3) goto L30;
            if (r101 != 0) goto L30;
            if (r103 == 0) goto L33;
        L30:
            if (r103 < 3) goto L34;
            if (r101 != 0) goto L34;
            if (r102 != 0) goto L34;
            goto L33
        }
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        return null;
    }

    public s() {
        this.f525758a = new ThematicBreak();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525758a;
    }
}
