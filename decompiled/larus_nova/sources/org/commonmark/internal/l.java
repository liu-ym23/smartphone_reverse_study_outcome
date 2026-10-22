package org.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: classes42.dex */
public final class l extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IndentedCodeBlock f525716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f525717b;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r100, h.a r101) {
            h r102 = (h) r100;
            if (r102.f525696g >= 4) goto L5;
            return null;
        L5:
            if (r102.f525697h == false) goto L7;
            return null;
        L7:
            if ((r102.h().a() instanceof Paragraph) == true) goto L13;
            d r103 = new d(new wvc.d[]{new l()});
            r103.f525670c = r102.f525692c + 4;
            return r103;
        L13:
            return null;
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        int r100 = ((ArrayList) this.f525717b).size() - 1;
    L3:
        int r101 = 0;
        if (r100 < 0) goto L20;
        CharSequence r102 = (CharSequence) ListProtector.get(this.f525717b, r100);
        int r103 = r102.length();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        char r105 = r102.charAt(r104);
        if (r105 == ' ') goto L12;
        switch(r105) {
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L12;
            default: goto L14;
        };
    L14:
        if (r104 != (-1)) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L20;
        r100 = r100 - 1;
        goto L3
    L16:
        r106 = false;
    L12:
        r104 = r104 + 1;
        goto L7
    L13:
        r104 = -1;
    L20:
        StringBuilder r107 = new StringBuilder();
    L22:
        if (r101 >= (r100 + 1)) goto L24;
        r107.append((CharSequence) ListProtector.get(this.f525717b, r101));
        r107.append('\n');
        r101 = r101 + 1;
        goto L22
    L24:
        this.f525716a.f525772h = r107.toString();
    }

    public l() {
        this.f525716a = new IndentedCodeBlock();
        this.f525717b = new ArrayList();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525716a;
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        ((ArrayList) this.f525717b).add(r100);
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        if (r101.f525696g < 4) goto L7;
        return new b(-1, r101.f525692c + 4, false);
    L7:
        if (r101.f525697h == true) goto L9;
        return null;
    L9:
        return wvc.c.a(r101.f525694e);
    }
}
