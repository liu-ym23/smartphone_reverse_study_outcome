package io.noties.markwon.ext.onetex;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends l {

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a extends l.a {

        /* JADX INFO: renamed from: io.noties.markwon.ext.onetex.m$a$a, reason: collision with other inner class name */
        public static final class C6316a {
        }

        static {
        }

        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r100, org.commonmark.internal.h.a r101) {
            Intrinsics.checkNotNullParameter(r100, "state");
            org.commonmark.internal.h r102 = (org.commonmark.internal.h) r100;
            if (r102.f525696g >= 4) goto L16;
            int r103 = r102.f525694e;
            CharSequence r104 = r102.f525690a;
            int r105 = r104.length();
            int r106 = r103;
        L6:
            if (r106 >= r105) goto L11;
            if ('$' != r104.charAt(r106)) goto L9;
            r106 = r106 + 1;
            goto L6
        L9:
            int r107 = r106 - r103;
        L12:
            if (r107 < 1) goto L16;
            if (tvc.d.b(' ', r104, r103 + r107, r105) != r105) goto L16;
            org.commonmark.internal.d r108 = new org.commonmark.internal.d(new wvc.d[]{new l(r107)});
            r108.f525669b = r105 + 1;
            org.commonmark.internal.d r109 = r108;
        L19:
            if ((r109 instanceof org.commonmark.internal.d) == true) goto L21;
            return r109;
        L21:
            int r110 = r102.f525694e;
            CharSequence r111 = r102.f525690a;
            int r112 = r111.length();
            int r113 = r110;
        L22:
            if (r113 >= r112) goto L27;
            if ('$' != r111.charAt(r113)) goto L25;
            r113 = r113 + 1;
            goto L22
        L25:
            int r114 = r113 - r110;
        L28:
            org.commonmark.internal.d r115 = new org.commonmark.internal.d(new wvc.d[]{new m(r114)});
            r115.f525670c = r109.f525670c;
            r115.f525669b = r109.f525669b;
            if (r109.f525671d == false) goto L31;
            r115.f525671d = true;
        L31:
            return r115;
        L27:
            r114 = r112 - r110;
            goto L28
        L11:
            r107 = r105 - r103;
        L16:
            r109 = null;
            goto L19
        }
    }

    public m(int r100) {
        super(r100);
    }

    @Override // io.noties.markwon.ext.onetex.l, wvc.d
    public final wvc.c f(wvc.g r100) {
        Intrinsics.checkNotNullParameter(r100, "parserState");
        CharSequence r101 = ((org.commonmark.internal.h) r100).f525690a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return wvc.c.b();
    L13:
        return super.f(r100);
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }
}
