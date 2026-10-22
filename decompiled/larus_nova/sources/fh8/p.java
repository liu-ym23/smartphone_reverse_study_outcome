package fh8;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes25.dex */
public final class p extends uvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<lw8.k> f477139a;

    public p(List<lw8.k> r100) {
        this.f477139a = r100;
    }

    @Override // uvc.a, uvc.c
    public final void D(Link r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        Iterator r101 = SequencesKt.generateSequence(r100.f551900a, new n()).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if ((((uvc.b) r101.next()) instanceof TableCell) == false) goto L4;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        List<lw8.k> r103 = this.f477139a;
        String r104 = r100.f525773h;
        StringBuilder r105 = new StringBuilder();
        o.b(r105, r100.f551901b);
        r103.add(new lw8.k(r104, r105.toString(), null, null));
    L11:
        c(r100);
        return;
    L8:
        r102 = false;
        goto L9
    }
}
