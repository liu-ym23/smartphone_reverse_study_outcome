package msc;

import io.noties.markwon.core.CoreProps;
import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements lsc.m.c<Paragraph> {
    public e() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Paragraph r102 = (Paragraph) r101;
        Block r103 = (Block) r102.f551900a;
        boolean r104 = false;
        if (r103 == null) goto L7;
        Block r105 = (Block) r103.f551900a;
        if ((r105 instanceof ListBlock) == false) goto L7;
        boolean r106 = ((ListBlock) r105).f525778h;
    L9:
        if (r103 == null) goto L13;
        Block r107 = (Block) r103.f551900a;
        if ((r107 instanceof ListBlock) == false) goto L13;
        boolean r108 = !((ListBlock) r107).f525778h;
    L14:
        if (r106 == true) goto L21;
        if (r108 == true) goto L18;
    L20:
        r104 = true;
        goto L21
    L18:
        if (r100.B().f510591a.A == false) goto L20;
    L21:
        if (r104 == false) goto L23;
        r100.C(r102);
    L23:
        int r109 = r100.length();
        r100.c(r102);
        CoreProps.f492267i.c(r100.r(), Boolean.valueOf(r106));
        r100.G(r102, r109);
        if (r104 == false) goto L27;
        r100.q(r102);
        return;
    L27:
        return;
    L13:
        r108 = false;
    L7:
        r106 = false;
        goto L9
    }
}
