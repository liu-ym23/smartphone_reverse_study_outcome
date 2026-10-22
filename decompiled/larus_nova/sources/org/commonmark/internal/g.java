package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.Document;

/* JADX INFO: loaded from: classes42.dex */
public final class g extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Document f525687a;

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
    }

    @Override // wvc.a, wvc.d
    public final boolean e(Block r100) {
        return true;
    }

    @Override // wvc.a, wvc.d
    public final boolean isContainer() {
        return true;
    }

    public g() {
        this.f525687a = new Document();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525687a;
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        return wvc.c.a(((h) r100).f525691b);
    }
}
