package com.bytedance.lark.qrsdk;

import java.net.URLEncoder;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253891a = 0;

    static {
    }

    public static String a(String r210) {
        Intrinsics.checkNotNullParameter(r210, "scanResult");
        if (b.b(r210) == false) goto L26;
        Intrinsics.checkNotNullParameter(r210, "url");
        int r100 = StringsKt.indexOf$default(r210, '#', 0, false, 6, null);
        if (r100 < 0) goto L7;
        String r101 = r210.substring(0, r100);
    L8:
        String r102 = "";
        if (r100 < 0) goto L11;
        String r103 = r210.substring(r100);
    L12:
        int r104 = StringsKt.indexOf$default(r101, '?', 0, false, 6, null);
        if (r104 < 0) goto L31;
        int r105 = r104 + 1;
        String r106 = r101.substring(r105);
        String r107 = r101.substring(0, r105);
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        String r109 = CollectionsKt.joinToString$default(StringsKt.split$default(r106, new String[]{"&"}, false, 0, 6, null), "&", null, null, 0, null, new QRLoginPayloadParser$ensureDoubaoBizSource$updatedQuery$1(r108), 30, null);
        if (r108.element == false) goto L19;
        return r107 + r109 + r103;
    L19:
        if (StringsKt.endsWith$default(r101, "?", false, 2, null) == true) goto L25;
        if (StringsKt.endsWith$default(r101, "&", false, 2, null) == true) goto L25;
        r102 = "&";
    L25:
        return r101 + r102 + "biz_source=doubao" + r103;
    L31:
        return r101 + "?biz_source=doubao" + r103;
    L11:
        r103 = "";
        goto L12
    L7:
        r101 = r210;
        goto L8
    L26:
        String r110 = b.a(r210);
        if (r110 != null) goto L29;
        return null;
    L29:
        Intrinsics.checkNotNullParameter(r110, "token");
        return "https://accounts.feishu.cn/accounts/page/qrlogin/doubao?token=" + StringsKt.replace$default(URLEncoder.encode(r110, "UTF-8"), Marker.ANY_NON_NULL_MARKER, "%20", false, 4, null) + "&biz_source=doubao";
    }
}
