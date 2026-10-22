package io.noties.markwon.html.tag;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import lsc.t;
import lsc.x;
import org.commonmark.node.Image;
import wsc.o;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f492629a;

    public interface a {
    }

    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton("img");
    }

    public e(f r100) {
        this.f492629a = r100;
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r110, t r111, tsc.l r112) {
        String r100 = r112.b().get("src");
        o r101 = null;
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L7:
        x r102 = ((lsc.l) r110.f510595e).a(Image.class);
        if (r102 != null) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        ((xsc.a.C8270a) r110.f510594d).getClass();
    L14:
        a r103 = this.f492629a;
        Map<String, String> r104 = r112.b();
        f r105 = (f) r103;
        r105.getClass();
        String r106 = r104.get("style");
        if (TextUtils.isEmpty(r106) == true) goto L28;
        ((tsc.c.a) r105.f492630a).getClass();
        tsc.c.a.C7768a.C7769a r107 = new tsc.c.a.C7768a.C7769a(new tsc.c.a.C7768a(r106));
        o.a r108 = null;
        o.a r109 = null;
    L18:
        if (r107.hasNext() == false) goto L29;
        tsc.d r113 = (tsc.d) r107.next();
        String r114 = r113.f547441a;
        if ("width".equals(r114) == false) goto L23;
        r108 = f.a(r113.f547442b);
    L25:
        if (r108 == null) goto L18;
        if (r109 == null) goto L18;
    L23:
        if ("height".equals(r114) == false) goto L25;
        r109 = f.a(r113.f547442b);
    L29:
        if (r108 == null) goto L32;
        if (r109 == null) goto L32;
        r101 = new o(r108, r109);
    L40:
        wsc.n.f561168a.c(r111, r100);
        wsc.n.f561170c.c(r111, r101);
        wsc.n.f561169b.c(r111, Boolean.FALSE);
        wsc.n.f561171d.c(r111, Integer.valueOf(r112.start()));
        wsc.n.f561172e.c(r111, Integer.valueOf(r112.end()));
        return r102.a(r110, r111);
    L32:
        if (r108 != null) goto L34;
        r108 = f.a(r104.get("width"));
    L34:
        if (r109 != null) goto L36;
        r109 = f.a(r104.get("height"));
    L36:
        if (r108 != null) goto L39;
        if (r109 == null) goto L40;
    L39:
        r101 = new o(r108, r109);
        goto L40
    L28:
        r108 = null;
        r109 = null;
        goto L29
    L13:
        r100 = "";
        goto L14
    L5:
        if (r110.f510591a.f515566z == true) goto L7;
        return null;
    }
}
