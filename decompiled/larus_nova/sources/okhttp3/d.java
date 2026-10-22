package okhttp3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f523818b;

    public final int hashCode() {
        return ((899 + this.f523817a.hashCode()) * 31) + this.f523818b.hashCode();
    }

    public final String toString() {
        return this.f523817a + " authParams=" + this.f523818b;
    }

    public final boolean equals(@Nullable Object r100) {
        if ((r100 instanceof d) == false) goto L9;
        d r101 = (d) r100;
        if (r101.f523817a.equals(this.f523817a) == false) goto L9;
        if (r101.f523818b.equals(this.f523818b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public d(String r100, Map<String, String> r101) {
        if (r101 == null) goto L15;
        this.f523817a = r100;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getKey() != null) goto L10;
        String r105 = null;
    L11:
        r102.put(r105, r104.getValue());
        goto L6
    L10:
        r105 = r104.getKey().toLowerCase(Locale.US);
        goto L11
    L12:
        this.f523818b = Collections.unmodifiableMap(r102);
        return;
    L15:
        throw new NullPointerException("authParams == null");
    }
}
