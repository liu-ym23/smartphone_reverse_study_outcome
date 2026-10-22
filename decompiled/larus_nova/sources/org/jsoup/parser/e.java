package org.jsoup.parser;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f526024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParseErrorList f526025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f526026c;

    public e(b r100) {
        this.f526024a = r100;
        this.f526026c = d.f526020c;
        this.f526025b = ParseErrorList.noTracking();
    }

    public final List<j> a(String r100, Element r101, String r102) {
        b r103 = (b) this.f526024a;
        r103.getClass();
        r103.f526004l = HtmlTreeBuilderState.Initial;
        r103.w(new StringReader(r100), r102, this);
        r103.f526009q = r101;
        byte r104 = 1;
        r103.f526016x = true;
        Element r105 = null;
        if (r101 != null) goto L5;
    L69:
        r103.f();
        if (r101 == null) goto L86;
        j r106 = r105.f525933a;
        if (r106 != null) goto L74;
        List r107 = Collections.emptyList();
    L82:
        if (r107.isEmpty() == true) goto L94;
        r105.V(r107);
    L94:
        return r105.j();
    L74:
        List<j> r108 = r106.n();
        ArrayList r109 = new ArrayList(r108.size() - 1);
        Iterator<j> r110 = r108.iterator();
    L76:
        if (r110.hasNext() == false) goto L80;
        j r111 = r110.next();
        if (r111 == r105) goto L76;
        r109.add(r111);
        goto L76
    L80:
        r107 = r109;
        goto L82
    L86:
        return r103.f526070d.j();
    L5:
        if (r101.x() == null) goto L7;
        r103.f526070d.f525892m = r101.x().f525892m;
    L7:
        String r112 = r101.f525906d.f526035b;
        r112.getClass();
        switch(r112.hashCode()) {
            case -1321546630: goto L50;
            case -1191214428: goto L47;
            case -1003243718: goto L43;
            case -907685685: goto L39;
            case 118807: goto L35;
            case 109780401: goto L31;
            case 110371416: goto L27;
            case 1192721831: goto L23;
            case 1551550924: goto L19;
            case 1973234167: goto L15;
            case 2115613112: goto L11;
            default: goto L53;
        };
    L53:
        r104 = -1;
    L54:
        switch(r104) {
            case 0: goto L61;
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L60;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L60;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L60;
            default: goto L55;
        };
    L55:
        r103.f526069c.p(TokeniserState.Data);
    L62:
        Element r113 = new Element(r103.g(r112, r103.f526074h), r102, null);
        r103.f526070d.G(r113);
        r103.f526071e.add(r113);
        r103.L();
        Element r114 = r101;
    L63:
        if (r114 == null) goto L68;
        if ((r114 instanceof org.jsoup.nodes.h) == true) goto L66;
        r114 = (Element) r114.f525933a;
        goto L63
    L66:
        r103.f526008p = (org.jsoup.nodes.h) r114;
    L68:
        r105 = r113;
        goto L69
    L56:
        r103.f526069c.p(TokeniserState.PLAINTEXT);
        goto L62
    L57:
        r103.f526069c.p(TokeniserState.Data);
        goto L62
    L58:
        r103.f526069c.p(TokeniserState.ScriptData);
        goto L62
    L59:
        r103.f526069c.p(TokeniserState.Rcdata);
        goto L62
    L60:
        r103.f526069c.p(TokeniserState.Rawtext);
        goto L62
    L61:
        r103.f526069c.p(TokeniserState.Data);
        r103.H(HtmlTreeBuilderState.InTemplate);
        goto L62
    L11:
        if (r112.equals("noembed") == false) goto L53;
        r104 = 10;
        goto L54
    L15:
        if (r112.equals("plaintext") == false) goto L53;
        r104 = 9;
        goto L54
    L19:
        if (r112.equals("noscript") == false) goto L53;
        r104 = 8;
        goto L54
    L23:
        if (r112.equals("noframes") == false) goto L53;
        r104 = 7;
        goto L54
    L27:
        if (r112.equals("title") == false) goto L53;
        r104 = 6;
        goto L54
    L31:
        if (r112.equals("style") == false) goto L53;
        r104 = 5;
        goto L54
    L35:
        if (r112.equals("xml") == false) goto L53;
        r104 = 4;
        goto L54
    L39:
        if (r112.equals("script") == false) goto L53;
        r104 = 3;
        goto L54
    L43:
        if (r112.equals("textarea") == false) goto L53;
        r104 = 2;
        goto L54
    L47:
        if (r112.equals("iframe") == true) goto L54;
    L50:
        if (r112.equals(ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L53;
        r104 = 0;
        goto L54
    }
}
