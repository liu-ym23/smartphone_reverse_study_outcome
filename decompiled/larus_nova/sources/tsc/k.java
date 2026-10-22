package tsc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.HtmlInline;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class k<N extends uvc.b> implements lsc.m.c<HtmlInline> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f547458a;

    public k(i r100) {
        this.f547458a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        HtmlInline r102 = (HtmlInline) r101;
        uvc.b r103 = r102.f551900a;
        if (r103 == null) goto L5;
        String r104 = r103.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r104, "org.commonmark.ext.gfm.tables.TableCell") == false) goto L17;
        String r105 = r102.f525769h;
        if (r105 != null) goto L11;
    L12:
        String r106 = r102.f525769h;
        if (r106 == null) goto L17;
        if (StringsKt.startsWith$default(r106, "</data-inline", false, 2, null) != true) goto L17;
        return;
    L11:
        if (StringsKt.startsWith$default(r105, "<data-inline", false, 2, null) != true) goto L12;
        return;
    L17:
        this.f547458a.o(r100, r102.f525769h);
        return;
    L5:
        r104 = null;
        goto L7
    }
}
