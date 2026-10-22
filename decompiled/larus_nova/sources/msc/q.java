package msc;

import io.noties.markwon.core.CoreProps;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class q<N extends uvc.b> implements lsc.m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<N> f515539a = null;

    static {
        f515539a = new q();
    }

    public q() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Link r102 = (Link) r101;
        Intrinsics.checkNotNullParameter(r100, "visitor");
        Intrinsics.checkNotNullParameter(r102, "link");
        int r103 = r100.length();
        r100.c(r102);
        CoreProps.f492265g.c(r100.r(), r102.f525773h);
        lsc.q<String> r104 = p.f515538d;
        lsc.t r105 = r100.r();
        String r106 = r102.f525774i;
        if (r106 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        String r108 = r102.f525774i;
    L20:
        r104.c(r105, r108);
        r100.G(r102, r103);
        return;
    L11:
        uvc.b r109 = r102.f551901b;
        if ((r109 instanceof Text) == false) goto L14;
        Text r110 = (Text) r109;
    L15:
        if (r110 == null) goto L17;
        r108 = r110.f525783h;
    L18:
        if (r108 != null) goto L20;
        r108 = "";
        goto L20
    L17:
        r108 = null;
        goto L18
    L14:
        r110 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r106) == true) goto L8;
        r107 = false;
        goto L9
    }
}
