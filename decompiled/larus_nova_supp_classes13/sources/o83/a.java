package o83;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final List<b> a;
    public Integer b;

    public final String toString() {
        List<b> r0 = this.a;
        if (r0 == null) goto L9;
        List<b> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        b r4 = (b) r3.next();
        r2.add("addressType=" + r4.c + " bizcode=" + r4.e);
        goto L6
    L8:
        String r5 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null);
    L10:
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    L9:
        r5 = null;
        goto L10
    }

    public a(List r3, Integer r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this.a = r3;
        this.b = r4;
    }

    public final JSONObject a(boolean r10, Set<String> r11, Set<String> r12) {
        JSONObject r0 = new JSONObject();
        if (r12 != null) goto L5;
    L6:
        JSONArray r2 = new JSONArray();
        List<b> r3 = this.a;
        if (r3 == null) goto L28;
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L28;
        b r5 = (b) r4.next();
        if (r11 == null) goto L15;
        if (CollectionsKt.contains(r11, r5.e) == false) goto L10;
    L15:
        r5.getClass();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = r5.a;
        int r8 = b.f;
        if (r7 == null) goto L20;
        if (r10 == false) goto L19;
        r7 = b.a.a(r7, false);
    L19:
        r6.put("address", r7);
    L20:
        if (r10 == true) goto L27;
        JSONObject r9 = r5.b;
        if (r9 == null) goto L26;
        if (r10 == false) goto L25;
        r9 = b.a.a(r9, false);
    L25:
        r6.put("latest_address", r9);
    L26:
        r6.put("address_type", r5.c);
        r6.put("is_main_page", r5.d);
    L27:
        r6.put("biz_code", r5.e);
        r2.put(r6);
    L28:
        Unit r13 = Unit.INSTANCE;
        r0.put("address_list", r2);
    L29:
        Integer r14 = this.b;
        if (r14 == null) goto L36;
        int r15 = r14.intValue();
        if (r12 != null) goto L34;
    L35:
        r0.put("error_code", r15);
        goto L36
    L34:
        if (r12.contains("error_code") == true) goto L35;
    L36:
        return r0;
    L5:
        if (r12.contains("address_list") == false) goto L29;
        goto L6
    }
}
