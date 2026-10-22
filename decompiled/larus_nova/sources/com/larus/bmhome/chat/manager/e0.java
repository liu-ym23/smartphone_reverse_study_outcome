package com.larus.bmhome.chat.manager;

import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, d0> f306718a = null;

    static {
        f306718a = new LinkedHashMap();
    }

    public static d0 a(String r100) {
        return (d0) ((LinkedHashMap) f306718a).get(r100);
    }

    public static void c(String r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<String, d0> r103 = f306718a;
        if (r103.containsKey(r100) == true) goto L7;
        r103.put(r100, new d0(0));
    L7:
        d0 r104 = (d0) ((LinkedHashMap) r103).get(r100);
        if (r104 != null) goto L10;
        return;
    L10:
        if (r102 == true) goto L12;
    L14:
        r104.f306713c = r101;
        return;
    L12:
        if (Intrinsics.areEqual(r104.f306713c, r101) == true) goto L14;
        r104.f306715e = null;
        r104.f306716f = null;
        r104.f306711a = null;
        r104.f306712b = 0;
        r104.f306714d = -1;
        goto L14
    }

    public static void b(String r100, Message r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 != null) goto L5;
        return;
    L5:
        Map<String, d0> r104 = f306718a;
        if (r104.containsKey(r100) == true) goto L8;
        r104.put(r100, new d0(0));
    L8:
        d0 r105 = (d0) ((LinkedHashMap) r104).get(r100);
        if (r105 != null) goto L11;
        return;
    L11:
        String r106 = r105.f306715e;
        if (r106 != null) goto L14;
    L15:
        String r107 = r105.f306716f;
        if (r107 != null) goto L18;
    L20:
        Message r108 = r105.f306711a;
        if (r108 != null) goto L23;
    L28:
        r105.f306712b = r102;
        r105.f306711a = r101;
        r105.f306714d = r103;
        return;
    L23:
        if (r108.getLocalIndex() < r101.getLocalIndex()) goto L28;
        if (Intrinsics.areEqual(r108.getLocalMessageId(), r101.getLocalMessageId()) == true) goto L27;
        return;
    L27:
        if (r102 > r105.f306712b) goto L28;
        return;
    L18:
        if (Intrinsics.areEqual(r107, r101.getLocalMessageId()) == false) goto L20;
        return;
    L14:
        if (Intrinsics.areEqual(r106, r101.getMessageId()) == false) goto L15;
    }
}
