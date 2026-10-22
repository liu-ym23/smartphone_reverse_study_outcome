package l17;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class o extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.webkit.CookieManager f507011a;

    @Override // java.net.CookieManager
    public final CookieStore getCookieStore() {
        throw new UnsupportedOperationException();
    }

    public o(CookiePolicy r100) {
        super(null, r100);
        this.f507011a = android.webkit.CookieManager.getInstance();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final Map<String, List<String>> get(URI r100, Map<String, List<String>> r101) throws IOException {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        String r102 = r100.toString();
        HashMap r103 = new HashMap();
        String r104 = this.f507011a.getCookie(r102);
        if (r104 == null) goto L8;
        r103.put("Cookie", Arrays.asList(new String[]{r104}));
    L8:
        return r103;
    L11:
        return null;
    L9:
        return null;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final void put(URI r100, Map<String, List<String>> r101) throws IOException {
        if (r100 == null) goto L19;
        if (r101 == null) goto L28;
        String r102 = r100.toString();
        Iterator<String> r103 = r101.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L29;
        String r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.equalsIgnoreCase("Set-Cookie2") == true) goto L15;
        if (r104.equalsIgnoreCase("Set-Cookie") == false) goto L7;
    L15:
        Iterator<String> r105 = r101.get(r104).iterator();
    L17:
        if (r105.hasNext() == false) goto L7;
        String r106 = r105.next();
        this.f507011a.setCookie(r102, r106);
        goto L17
    L29:
        return;
    L28:
        return;
    }
}
