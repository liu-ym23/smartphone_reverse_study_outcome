package com.larus.bmhome.chat.list.cell.test;

import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class c {
    public static final Map<String, String> a(Map<String, String> r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "parent");
        if (r100 == null) goto L6;
        Map<String, String> r102 = MapsKt.toMutableMap(r100);
        if (r102 == null) goto L6;
    L7:
        Map<String, String> r103 = r101.getExt();
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        Pair r105 = null;
        if (r104 == true) goto L33;
        String r106 = r103.get("suffix_active_delete_message_id_list");
        if (r106 != null) goto L20;
    L25:
        String r107 = r103.get("sub_active_msg_id_list");
        if (r107 == null) goto L33;
        if ((true ^ StringsKt.isBlank(r107)) == true) goto L31;
        r107 = null;
    L31:
        if (r107 == null) goto L33;
        r105 = TuplesKt.to("sub_active_msg_id_list", r107);
        goto L33
    L20:
        if ((!StringsKt.isBlank(r106)) == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L25;
        r105 = TuplesKt.to("suffix_active_delete_message_id_list", r106);
    L33:
        if (r105 == null) goto L35;
        r102.put((String) r105.component1(), (String) r105.component2());
        r102.put("crowd_test_delete_tip_anchor", "1");
    L35:
        return r102;
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
    L6:
        r102 = new LinkedHashMap();
        goto L7
    }
}
