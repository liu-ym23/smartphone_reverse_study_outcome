package dpb;

import java.util.Locale;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(Locale r100) {
        if (r100 != null) goto L5;
        return "locale is null";
    L5:
        String r101 = r100.getLanguage();
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r103 = r100.getCountry();
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String r104 = r100.getScript();
        if (r104 == null) goto L15;
        r102 = r104;
    L15:
        StringBuilder r105 = new StringBuilder();
        r105.append(r101);
        boolean r106 = true;
        if (r103.length() <= 0) goto L18;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L23;
        r105.append("_".concat(r103));
    L23:
        if (r102.length() > 0) goto L26;
        r106 = false;
    L26:
        if (r106 == false) goto L29;
        r105.append("_".concat(r102));
    L29:
        return r105.toString();
    L18:
        r107 = false;
        goto L20
    }
}
