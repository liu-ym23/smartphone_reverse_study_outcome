package dwc;

import java.io.StringReader;
import org.jsoup.nodes.Document;
import org.jsoup.parser.b;
import org.jsoup.parser.e;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static Document a(String r100) {
        b r101 = new b();
        r101.w(new StringReader(r100), "", new e(r101));
        r101.f();
        r101.f526068b.d();
        r101.f526068b = null;
        r101.f526069c = null;
        r101.f526071e = null;
        r101.f526075i = null;
        return r101.f526070d;
    }
}
