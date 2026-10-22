package io.noties.markwon.ext.onetex;

import android.text.TextUtils;
import io.noties.markwon.onetex.LatexMathBlock;
import org.commonmark.node.Block;

/* JADX INFO: loaded from: classes41.dex */
public final class u extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatexMathBlock f492481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f492482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f492483c;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r100, org.commonmark.internal.h.a r101) {
            org.commonmark.internal.h r102 = (org.commonmark.internal.h) r100;
            if (r102.f525696g < 4) goto L5;
            return null;
        L5:
            int r103 = r102.f525694e;
            CharSequence r104 = r102.f525690a;
            int r105 = r104.length();
            String r106 = r104.subSequence(r103, r105).toString();
            String r107 = "\\[";
            if (r106.startsWith("\\[") == true) goto L13;
            r107 = "\\(";
            if (r106.startsWith("\\(") == true) goto L13;
            r107 = "";
        L13:
            if (TextUtils.isEmpty(r107) == false) goto L16;
            return null;
        L16:
            if (tvc.d.b(' ', r104, r103 + 2, r105) == r105) goto L18;
            return null;
        L18:
            org.commonmark.internal.d r108 = new org.commonmark.internal.d(new wvc.d[]{new u(r107)});
            r108.f525669b = r105 + 1;
            return r108;
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        LatexMathBlock r100 = this.f492481a;
        r100.f492652h = this.f492482b.toString();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f492481a;
    }

    public u(String r100) {
        this.f492481a = new LatexMathBlock();
        this.f492482b = new StringBuilder();
        this.f492483c = r100;
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        this.f492482b.append(r100);
        this.f492482b.append('\n');
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        org.commonmark.internal.h r101 = (org.commonmark.internal.h) r100;
        CharSequence r102 = r101.f525690a;
        if (TextUtils.isEmpty(r102) == true) goto L5;
        int r103 = r101.f525694e;
        int r104 = r102.length();
        if (r101.f525696g >= 4) goto L28;
        String r105 = r102.subSequence(r103, r104).toString();
        if (TextUtils.isEmpty(r105) == false) goto L12;
    L20:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L28;
        if (tvc.d.b(' ', r102, r103 + 2, r104) != r104) goto L28;
        return wvc.c.b();
    L12:
        if ("\\(".equals(this.f492483c) == false) goto L17;
        if (r105.startsWith("\\)") == true) goto L20;
    L17:
        if ("\\[".equals(this.f492483c) == true) goto L19;
    L21:
        r106 = false;
        goto L22
    L19:
        if (r105.startsWith("\\]") == false) goto L21;
    L28:
        return wvc.c.a(r101.f525691b);
    L5:
        return wvc.c.b();
    }
}
