package tx9;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b2 {
    public static final boolean a(JSONObject r100) {
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (d(r100, "_mixed_richmedia_download_trace") != true) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static final JSONObject b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        if (Intrinsics.areEqual(r103, "_mixed_richmedia_download_trace") == true) goto L4;
        if (Intrinsics.areEqual(r103, "_mixed_richmedia_download_suppress") == true) goto L4;
        r101.put(r103, r100.opt(r103));
        goto L4
    L11:
        return r101;
    }

    public static final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("_mixed_richmedia_download_trace", 1);
    }

    public static final boolean d(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if (r102 != null) goto L6;
        return false;
    L6:
        if ((r102 instanceof Boolean) == false) goto L9;
        return ((Boolean) r102).booleanValue();
    L9:
        if ((r102 instanceof Number) == false) goto L14;
        if (((Number) r102).intValue() == 0) goto L22;
    L19:
        return true;
    L22:
        return false;
    L14:
        if ((r102 instanceof String) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r102, "1") == true) goto L19;
        if (StringsKt.equals((String) r102, "true", true) == true) goto L19;
        return false;
    }

    public static final boolean e(Map<?, ?> r100, String r101) {
        if (r100 == null) goto L21;
        Object r102 = r100.get(r101);
        if (r102 == null) goto L21;
        if ((r102 instanceof Boolean) == false) goto L10;
        return ((Boolean) r102).booleanValue();
    L10:
        if ((r102 instanceof Number) == false) goto L15;
        if (((Number) r102).intValue() == 0) goto L21;
    L20:
        return true;
    L15:
        if ((r102 instanceof String) == false) goto L21;
        if (Intrinsics.areEqual(r102, "1") == true) goto L20;
        if (StringsKt.equals((String) r102, "true", true) == true) goto L20;
    L21:
        return false;
    }

    public static final void f(JSONObject r100, boolean r101) {
        boolean r102 = a(r100);
        if (r100 == null) goto L7;
        boolean r103 = true;
        if (d(r100, "_mixed_richmedia_download_suppress") != true) goto L7;
    L8:
        g(r100, r102, r103, r101);
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static final void g(JSONObject r100, boolean r101, boolean r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r103 == false) goto L6;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.remove("_mixed_richmedia_download_trace");
        r100.remove("_mixed_richmedia_download_suppress");
    L6:
        if (r101 == false) goto L11;
        if (r102 == true) goto L12;
        com.larus.platform.service.o.f365780a.reportEvent("mixed_richmedia_download", b(r100));
        return;
    L12:
        return;
    }
}
