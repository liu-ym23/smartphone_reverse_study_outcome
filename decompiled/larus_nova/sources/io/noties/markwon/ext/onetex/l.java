package io.noties.markwon.ext.onetex;

import io.noties.markwon.onetex.LatexMathBlock;
import org.commonmark.node.Block;

/* JADX INFO: loaded from: classes41.dex */
public class l extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatexMathBlock f492446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f492447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f492448c;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        LatexMathBlock r100 = this.f492446a;
        r100.f492652h = this.f492447b.toString();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f492446a;
    }

    public l(int r100) {
        this.f492446a = new LatexMathBlock();
        this.f492447b = new StringBuilder();
        this.f492448c = r100;
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        this.f492447b.append(r100);
        this.f492447b.append('\n');
    }

    @Override // wvc.d
    public wvc.c f(wvc.g r100) {
        org.commonmark.internal.h r101 = (org.commonmark.internal.h) r100;
        int r102 = r101.f525694e;
        CharSequence r103 = r101.f525690a;
        int r104 = r103.length();
        if (r101.f525696g >= 4) goto L18;
        int r105 = r102;
    L5:
        if (r105 >= r104) goto L10;
        if ('$' != r103.charAt(r105)) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        int r106 = r105 - r102;
    L11:
        int r107 = this.f492448c;
        if (r106 != r107) goto L18;
        if (tvc.d.b(' ', r103, r102 + r107, r104) != r104) goto L18;
        return wvc.c.b();
    L10:
        r106 = r104 - r102;
    L18:
        return wvc.c.a(r101.f525691b);
    }
}
