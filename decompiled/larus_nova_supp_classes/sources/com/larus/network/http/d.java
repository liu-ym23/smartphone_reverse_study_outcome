package com.larus.network.http;

import com.larus.common.apphost.AppHost;
import hq9.q1;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static final boolean e = false;
    public static q1 f;
    public static int g;
    public static e h;
    public static final Set<String> i = null;
    public static final List<String> j = null;

    static {
        a = XmlPullParser.NO_NAMESPACE;
        b = XmlPullParser.NO_NAMESPACE;
        c = XmlPullParser.NO_NAMESPACE;
        d = XmlPullParser.NO_NAMESPACE;
        AppHost.Companion r0 = AppHost.a;
        if (r0.c() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        e = r1;
        g = RecordType.NO_RECORD.getValue();
        i = SetsKt.setOf(new String[]{"/im/chain/single", "/im/sse/send/message"});
        j = CollectionsKt.listOf("page_chat_first_paint");
        return;
    L5:
        if (r0.isTestChannel() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static boolean a() {
        if (e == true) goto L5;
    L7:
        return false;
    L5:
        if (g != RecordType.DOUBAO_RECORD.getValue()) goto L7;
        return true;
    }
}
