package com.larus.network.http;

import com.larus.common.apphost.AppHost;
import hq9.q1;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f360140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f360141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f360142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f360143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f360144e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static q1 f360145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f360146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static e f360147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f360148i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<String> f360149j = null;

    static {
        f360140a = "";
        f360141b = "";
        f360142c = "";
        f360143d = "";
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.c() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        f360144e = r101;
        f360146g = RecordType.NO_RECORD.getValue();
        f360148i = SetsKt.setOf(new String[]{"/im/chain/single", "/im/sse/send/message"});
        f360149j = CollectionsKt.listOf("page_chat_first_paint");
        return;
    L5:
        if (r100.isTestChannel() == false) goto L7;
        r101 = true;
        goto L8
    }

    public static boolean a() {
        if (f360144e == true) goto L5;
    L7:
        return false;
    L5:
        if (f360146g != RecordType.DOUBAO_RECORD.getValue()) goto L7;
        return true;
    }
}
