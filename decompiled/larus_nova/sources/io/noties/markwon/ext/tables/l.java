package io.noties.markwon.ext.tables;

import org.commonmark.ext.gfm.tables.TableHead;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class l<N extends uvc.b> implements lsc.m.c<TableHead> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.c f492539a;

    public l(g.c r100) {
        this.f492539a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        this.f492539a.f492532c = true;
        r100.c((TableHead) r101);
        this.f492539a.f492532c = false;
    }
}
