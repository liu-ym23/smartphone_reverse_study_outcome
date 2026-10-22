package io.noties.markwon.ext.tables;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableCell;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class m<N extends uvc.b> implements lsc.m.c<TableCell> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.c f492540a;

    public m(g.c r100) {
        this.f492540a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        TableCell r102 = (TableCell) r101;
        int r103 = r100.length();
        r100.c(r102);
        List<g.a> r104 = this.f492540a.f492530a;
        TableCell.Alignment r105 = r102.f525649i;
        if (r105 == null) goto L8;
        int r106 = b.f492507a[r105.ordinal()];
        int r107 = 1;
        if (r106 == 1) goto L9;
        r107 = 2;
        if (r106 != 2) goto L8;
    L9:
        ArrayList r108 = (ArrayList) r104;
        r108.add(new g.a(r107, r100.builder().e(r103)));
        return;
    L8:
        r107 = 0;
        goto L9
    }
}
