package ubb;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f549413a = null;

    static {
        f549413a = new b();
    }

    public b() {
    }

    public static boolean a(URI r100, Collection r101, boolean r102) {
        if (r100.getScheme() == null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return r102;
    L12:
        if (StringsKt.equals(r100.getScheme(), "https", true) == true) goto L14;
        return false;
    L14:
        String r104 = r100.getHost();
        if (r104 == null) goto L17;
        String r105 = r104.toLowerCase(Locale.US);
    L18:
        if (r105 != null) goto L21;
        r105 = "";
    L21:
        if (r105.length() != 0) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
        return false;
    L26:
        Collection r107 = r101;
        if ((r107 instanceof Collection) == true) goto L29;
    L31:
        Iterator r108 = r107.iterator();
    L33:
        if (r108.hasNext() == false) goto L43;
        String r109 = StringsKt.trim((String) r108.next()).toString().toLowerCase(Locale.US);
        if (r109.length() != 0) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L40;
        boolean r111 = false;
    L41:
        if (r111 == false) goto L33;
        return true;
    L40:
        r111 = new Regex("^(?:[^.]+\\.)*" + Regex.Companion.escape(r109) + Typography.dollar).matches(r105);
        goto L41
    L37:
        r110 = false;
    L43:
        return false;
    L29:
        if (r107.isEmpty() == false) goto L31;
    L23:
        r106 = false;
        goto L24
    L17:
        r105 = null;
        goto L18
    L5:
        if (r100.getHost() != null) goto L8;
        r103 = false;
        goto L9
    }
}
