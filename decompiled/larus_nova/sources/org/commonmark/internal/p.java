package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: classes42.dex */
public final class p extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListItem f525750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f525751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f525752c;

    @Override // wvc.a, wvc.d
    public final boolean isContainer() {
        return true;
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525750a;
    }

    public p(int r100) {
        this.f525750a = new ListItem();
        this.f525751b = r100;
    }

    @Override // wvc.a, wvc.d
    public final boolean e(Block r100) {
        if (this.f525752c == false) goto L9;
        Block r101 = (Block) this.f525750a.f551900a;
        if ((r101 instanceof ListBlock) == false) goto L10;
        ((ListBlock) r101).f525778h = false;
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        boolean r102 = false;
        if (r101.f525697h == true) goto L5;
        int r103 = r101.f525696g;
        int r104 = this.f525751b;
        if (r103 >= r104) goto L17;
        return null;
    L17:
        return new b(-1, r101.f525692c + r104, false);
    L5:
        if (this.f525750a.f551901b != null) goto L7;
        return null;
    L7:
        Block r105 = r101.h().a();
        if ((r105 instanceof Paragraph) == false) goto L10;
    L11:
        r102 = true;
    L12:
        this.f525752c = r102;
        return wvc.c.a(r101.f525694e);
    L10:
        if ((r105 instanceof ListItem) == false) goto L12;
        goto L11
    }
}
