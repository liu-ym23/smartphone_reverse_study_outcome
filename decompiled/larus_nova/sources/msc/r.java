package msc;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.x;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class r<N extends uvc.b> implements lsc.m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f515540a;

    public r(p r100) {
        this.f515540a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r110, uvc.b r111) {
        Image r112 = (Image) r111;
        Intrinsics.checkNotNullParameter(r110, "visitor");
        Intrinsics.checkNotNullParameter(r112, "image");
        x r100 = ((lsc.l) r110.B().f510595e).a(Image.class);
        if (r100 != null) goto L5;
        r110.c(r112);
        return;
    L5:
        int r101 = r110.length();
        r110.c(r112);
        if (r101 != r110.length()) goto L8;
        r110.builder().a(65532);
    L8:
        lsc.h r102 = r110.B();
        boolean r103 = r112.f551900a instanceof Link;
        xsc.a r104 = r102.f510594d;
        String r113 = r112.f525770h;
        ((xsc.a.C8270a) r104).getClass();
        lsc.t r105 = r110.r();
        wsc.n.f561168a.c(r105, r113);
        wsc.n.f561169b.c(r105, Boolean.valueOf(r103));
        lsc.q<wsc.o> r106 = wsc.n.f561170c;
        this.f515540a.getClass();
        Matcher r114 = PatternProtector.compile(":(\\d+):(\\d+):(\\d+):(\\d+):(\\d+):(\\d+)").matcher(r113);
        if (r114.find() == false) goto L24;
        List r115 = StringsKt.split$default(r114.group(), new String[]{":"}, false, 0, 6, null);
        ArrayList r107 = new ArrayList();
        Iterator r116 = r115.iterator();
    L12:
        if (r116.hasNext() == false) goto L17;
        Integer r108 = StringsKt.toIntOrNull((String) r116.next());
        if (r108 == null) goto L12;
        r107.add(r108);
        goto L12
    L17:
        if (r107.size() < 4) goto L24;
        int r117 = ((Number) ListProtector.get(r107, 2)).intValue() - ((Number) ListProtector.get(r107, 0)).intValue();
        int r109 = ((Number) ListProtector.get(r107, 3)).intValue() - ((Number) ListProtector.get(r107, 1)).intValue();
        if (r117 <= 0) goto L24;
        if (r109 <= 0) goto L24;
        wsc.o r118 = new wsc.o(new wsc.o.a(r117, GXTemplateKey.GAIAX_PX), new wsc.o.a(r109, GXTemplateKey.GAIAX_PX));
    L25:
        r106.c(r105, r118);
        wsc.n.f561171d.c(r105, Integer.valueOf(r101));
        wsc.n.f561172e.c(r105, Integer.valueOf(r110.builder().length()));
        r110.o(r101, r100.a(r102, r105));
        return;
    L24:
        r118 = null;
        goto L25
    }
}
