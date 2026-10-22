package io.noties.markwon.maybe;

import lsc.m;

/* JADX INFO: loaded from: classes41.dex */
public class MaybeNode<Target> extends uvc.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Target f492632h;

    public MaybeNode() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MaybeNode(uvc.b r100) {
        this.f492632h = r100;
    }

    @Override // uvc.b
    public final void a(uvc.c r100) {
        if ((r100 instanceof m) == false) goto L8;
        m r101 = (m) r100;
        m.c<uvc.b> r102 = r101.i(this);
        if (r102 == null) goto L8;
        r102.a(r101, this);
        return;
    L8:
        uvc.b r103 = this.f551901b;
    L9:
        if (r103 == null) goto L11;
        uvc.b r104 = r103.f551904e;
        r103.a(r100);
        r103 = r104;
        goto L9
    }
}
