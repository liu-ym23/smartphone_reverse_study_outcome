package io.noties.markwon.ext.tables;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import org.commonmark.ext.gfm.tables.TableRow;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class k<N extends uvc.b> implements lsc.m.c<TableRow> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.c f492538a;

    public k(g.c r100) {
        this.f492538a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        g.c r102 = this.f492538a;
        r102.getClass();
        r100.c((TableRow) r101);
        ((ArrayList) r102.f492531b).add(new g.b(r102.f492533d, CollectionsKt.toList(r102.f492530a), r102.f492532c));
        r102.f492533d++;
        ((ArrayList) r102.f492530a).clear();
    }
}
