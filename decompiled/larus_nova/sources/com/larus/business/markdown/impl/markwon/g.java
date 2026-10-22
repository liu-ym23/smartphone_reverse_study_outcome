package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.nova.R;
import io.noties.markwon.core.spans.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import lsc.m;
import lsc.q;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: classes4.dex */
public final class g<N extends uvc.b> implements m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<N> f320697a = null;

    static {
        f320697a = new g();
    }

    public g() {
    }

    @Override // lsc.m.c
    public final void a(m r100, uvc.b r101) {
        Emphasis r102 = (Emphasis) r101;
        Intrinsics.checkNotNullParameter(r100, "visitor");
        Intrinsics.checkNotNullParameter(r102, "emphasis");
        int r103 = r100.length();
        r100.c(r102);
        r100.G(r102, r103);
        uvc.b r104 = r102.f551902c;
        if ((r104 instanceof Text) == false) goto L5;
        Text r105 = (Text) r104;
    L6:
        if (r105 == null) goto L40;
        String r106 = r105.f525783h;
        q<Integer> r107 = e.f320693a;
        Intrinsics.checkNotNullParameter(r106, "input");
        boolean r108 = true;
        boolean r109 = false;
        if (r106.length() != 0) goto L10;
        boolean r110 = true;
    L11:
        if (r110 == true) goto L37;
        char r111 = StringsKt.last(r106);
        if (19968 <= r111) goto L16;
    L18:
        boolean r112 = false;
    L19:
        if (r112 == false) goto L21;
    L36:
        r109 = r108;
        goto L37
    L21:
        if (13312 <= r111) goto L23;
    L25:
        boolean r113 = false;
    L26:
        if (r113 == true) goto L36;
        if (0 <= r111) goto L30;
    L32:
        boolean r114 = false;
    L33:
        if (r114 == true) goto L36;
        r108 = false;
        goto L36
    L30:
        if (r111 >= 42720) goto L32;
        r114 = true;
        goto L33
    L23:
        if (r111 >= 19904) goto L25;
        r113 = true;
        goto L26
    L16:
        if (r111 >= 40960) goto L18;
        r112 = true;
    L37:
        if (r109 == false) goto L41;
        int r115 = r100.length();
        r100.builder().a(Typography.nbsp);
        r100.o(r115, new s(MarkdownDimensExtKt.f(R.dimen.dp_3)));
        return;
    L41:
        return;
    L10:
        r110 = false;
        goto L11
    L40:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
