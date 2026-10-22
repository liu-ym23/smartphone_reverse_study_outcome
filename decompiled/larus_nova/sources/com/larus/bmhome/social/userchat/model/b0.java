package com.larus.bmhome.social.userchat.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 {
    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = c(r100);
        if (r101 != null) goto L6;
    L7:
        return null;
    L6:
        if (r101.intValue() != 3) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r102 = r100.getBusinessExt();
        if (r102 == null) goto L11;
        String r103 = r102.get("original_message_id");
    L12:
        if (r103 != null) goto L14;
        return null;
    L14:
        if (StringsKt.endsWith$default(r103, "-clear-context", false, 2, null) == true) goto L17;
        r103 = null;
    L17:
        if (r103 != null) goto L19;
        return null;
    L19:
        return StringsKt.removeSuffix(r103, "-clear-context");
    L11:
        r103 = null;
        goto L12
    }

    public static final int b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (StringsKt.contains$default(r100, ":", false, 2, null) == false) goto L7;
        Integer r101 = StringsKt.toIntOrNull((String) CollectionsKt.last(StringsKt.split$default(r100, new String[]{":"}, false, 0, 6, null)));
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return -1;
    }

    public static final Integer c(Message r100) {
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L8;
        String r102 = r101.get("fake_message_type");
        if (r102 == null) goto L8;
        return StringsKt.toIntOrNull(r102);
    L8:
        return null;
    }

    public static final String d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (StringsKt.contains$default(r110, ":", false, 2, null) == true) goto L5;
        return r110;
    L5:
        return (String) ListProtector.get(StringsKt.split$default(r110, new String[]{":"}, false, 0, 6, null), 0);
    }

    public static final boolean e(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getLocalMessageId();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (b(r101) != 8) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean f(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Map<String, String> r101 = r100.getBusinessExt();     // Catch: NullPointerException -> L9
        if (r101 == null) goto L6;
        String r102 = r101.get("ui_message_type");     // Catch: NullPointerException -> L9
    L7:
        return Intrinsics.areEqual(r102, "fake_message");
    L6:
        r102 = null;
    L9:
        return false;
    }

    public static final boolean g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getLocalMessageId();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (b(r101) != 9) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("is_mock_receiving");
    L7:
        return Intrinsics.areEqual(r102, "1");
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean i(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("send_loading");
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r102, "0") == true) goto L10;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final Message j(Message r410, int r411) {
        Intrinsics.checkNotNullParameter(r410, "<this>");
        if (r411 == 0) goto L6;
        if (r411 == 1) goto L6;
        long r100 = r410.getLocalIndex();
    L7:
        long r110 = r100;
        String r101 = r410.getMessageId();
        String r102 = "";
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        String r111 = k(r101, r411);
        String r103 = r410.getLocalMessageId();
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        String r112 = k(r103, r411);
        Map<String, String> r104 = r410.getBusinessExt();
        if (r104 != null) goto L16;
        r104 = new LinkedHashMap();
    L16:
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("ui_message_type", "fake_message");
        r105[1] = TuplesKt.to("fake_message_type", String.valueOf(r411));
        String r106 = r410.getMessageId();
        if (r106 != null) goto L19;
        r106 = "";
    L19:
        r105[2] = TuplesKt.to("original_message_id", r106);
        String r107 = r410.getLocalMessageId();
        if (r107 == null) goto L23;
        r102 = r107;
    L23:
        r105[3] = TuplesKt.to("original_local_message_id", r102);
        return Message.copy$default(r410, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r112, r111, r110, 0, false, null, null, null, com.larus.utils.h.c(r104, r105), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4308993, 31, null);
    L6:
        r100 = r410.getLocalIndex() + 1;
        goto L7
    }

    public static final String k(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100 + ":fake_message:" + r101;
    }
}
