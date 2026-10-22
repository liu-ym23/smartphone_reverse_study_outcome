package g2a;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public c() {
    }

    public abstract String b(CharSequence r100, int r101);

    public final String a(String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new Regex(h.f479759c).replace(r100, new b(this, r101));
    L6:
        return "[regex-erase-error-" + r100.length() + ']';
    }

    public final String c(String r110, int r111) {
        boolean r100 = false;
        if (r110.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
    L28:
        JSONObject r102 = new JSONObject(r110);     // Catch: Throwable -> L30
        d(r102, r111);     // Catch: Throwable -> L30
        return r102.toString();
    L9:
        if (r110.charAt(0) == '{') goto L11;
    L12:
        int r103 = StringsKt.indexOf$default(r110, '{', 0, false, 6, null);     // Catch: Throwable -> L30
        String r104 = "";
        if (r103 < 0) goto L16;
        String r105 = StringsKt.take(r110, r103);     // Catch: Throwable -> L30
    L17:
        int r106 = StringsKt.lastIndexOf$default(r110, '}', 0, false, 6, null);     // Catch: Throwable -> L30
        if (r106 < 0) goto L20;
        r104 = r110.substring(r106);     // Catch: Throwable -> L30
        int r107 = r106 + 1;     // Catch: Throwable -> L30
    L21:
        if (r103 == (-1)) goto L27;
        if (r107 == (-1)) goto L27;
        if (r107 <= r103) goto L27;
        return r105 + c(r110.substring(r103, r107), r111) + r104;
    L27:
        return a(r110, r111);
    L20:
        r107 = -1;
        goto L21
    L16:
        r105 = "";
        r103 = -1;
        goto L17
    L11:
        if (r110.charAt(r110.length() - 1) == '}') goto L28;
    L6:
        r101 = false;
        goto L7
    L31:
        if (StringsKt.findAnyOf$default(r110, h.f479758b, 0, false, 6, null) == null) goto L33;
        r100 = true;
    L33:
        if (r100 == true) goto L35;
        return r110;
    L35:
        return "[json-erase-error-" + r110.length() + ']';
    }

    public final void d(JSONObject r110, int r111) {
        Iterator<String> r100 = r110.keys();
    L4:
        if (r100.hasNext() == false) goto L19;
        String r101 = r100.next();
        Object r102 = r110.get(r101);
        Lazy r103 = h.f479757a;
        List<String> r104 = h.f479758b;
        if (r104.contains(r101) == true) goto L8;
        if ((r102 instanceof String) == true) goto L14;
        Intrinsics.checkNotNull(r102);
        e(r102, r111);
        goto L4
    L14:
        if (StringsKt.findAnyOf$default((CharSequence) r102, r104, 0, false, 6, null) == null) goto L4;
        JSONObject r105 = new JSONObject((String) r102);     // Catch: Throwable -> L17
        d(r105, r111);     // Catch: Throwable -> L17
        r110.put(r101, r105.toString());     // Catch: Throwable -> L17
    L17:
        r110.put(r101, a((String) r102, r111));
        goto L4
    L8:
        if ((r102 instanceof String) == true) goto L9;
        Intrinsics.checkNotNull(r102);
        e(r102, r111);
        goto L4
    L9:
        r110.put(r101, b((CharSequence) r102, r111));
        goto L4
    }

    public final void e(Object r100, int r101) {
        if ((r100 instanceof JSONObject) == false) goto L6;
        d((JSONObject) r100, r101);
        return;
    L6:
        if ((r100 instanceof JSONArray) == false) goto L21;
        JSONArray r102 = (JSONArray) r100;
        int r103 = r102.length();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L22;
        JSONObject r105 = r102.optJSONObject(r104);
        if (r105 == null) goto L13;
        d(r105, r101);
    L15:
        r104 = r104 + 1;
        goto L8
    L13:
        if ((r102.get(r104) instanceof String) == false) goto L15;
        r102.put(r104, b(r102.get(r104).toString(), r101));
        goto L15
    L22:
        return;
    }

    public String f(CharSequence r100, boolean r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        return "";
    L9:
        if (r101 == true) goto L11;
        if (r102 == false) goto L16;
        return c(r100.toString(), r103);
    L16:
        return a(r100.toString(), r103);
    L11:
        return b(r100, r103);
    L5:
        r104 = false;
        goto L6
    }
}
