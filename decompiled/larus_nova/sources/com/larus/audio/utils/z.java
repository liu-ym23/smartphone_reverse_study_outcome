package com.larus.audio.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f290165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioLogLevel f290166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f290167c;

    public static void a(final z r210) {
        String r100 = "";
        Intrinsics.checkNotNullParameter("", "file");
        Intrinsics.checkNotNullParameter("", "function");
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r101.length < 5) goto L5;
        StackTraceElement r102 = r101[4];
    L6:
        if (r102 == null) goto L11;
        String r103 = r102.getFileName();
        if (r103 == null) goto L11;
        String r104 = r103;
    L12:
        if (r102 == null) goto L17;
        String r105 = r102.getMethodName();
        if (r105 == null) goto L17;
        r100 = r105;
    L17:
        if (r102 == null) goto L19;
        int r106 = r102.getLineNumber();
    L20:
        r0 r107 = r210.f290167c;
        ArrayList r110 = new ArrayList();
        r110.add("<What=" + c(r107.f290129a) + Typography.greater);
        Map<a0, Object> r108 = r107.f290135g;
        if (r108 != null) goto L23;
    L39:
        String r109 = r107.f290133e;
        if (r109 == null) goto L42;
        r110.add("<Who=" + c(r109) + Typography.greater);
    L42:
        String r111 = r107.f290132d;
        if (r111 == null) goto L45;
        r110.add("<Where=" + c(r111) + Typography.greater);
    L45:
        String r112 = r107.f290131c;
        if (r112 == null) goto L48;
        r110.add("<EventType=" + c(r112) + Typography.greater);
    L48:
        List<String> r113 = r107.f290130b;
        if (r113 == null) goto L57;
        if ((!r113.isEmpty()) == true) goto L54;
        r113 = null;
    L54:
        if (r113 == null) goto L57;
        r110.add("<LinkID=" + CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, new y(r210), 30, null) + Typography.greater);
    L57:
        String r114 = r107.f290134f;
        if (r114 == null) goto L60;
        r110.add("<Source=" + c(r114) + Typography.greater);
    L60:
        String r115 = CollectionsKt.joinToString$default(r110, "", null, null, 0, null, null, 62, null);
        s0 r116 = r210.f290165a;
        AudioLogLevel r117 = r210.f290166b;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "level");
        Intrinsics.checkNotNullParameter(r115, "content");
        Intrinsics.checkNotNullParameter(r104, "file");
        Intrinsics.checkNotNullParameter(r100, "function");
        String r118 = r115 + " [" + (((String) CollectionsKt.last(StringsKt.split$default(r104, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null))) + ',' + r100 + ',' + r106) + ']';
        int r119 = s0.a.f290137a[r117.ordinal()];
        if (r119 != 1) goto L63;
        m58.v r120 = m58.h.f512138i;
        if (r120 == null) goto L93;
        r120.d(r116.f290136a, r118);
        return;
    L93:
        return;
    L63:
        if (r119 != 2) goto L65;
        m58.v r121 = m58.h.f512138i;
        if (r121 == null) goto L91;
        r121.i(r116.f290136a, r118);
        return;
    L91:
        return;
    L65:
        if (r119 != 3) goto L67;
        m58.v r122 = m58.h.f512138i;
        if (r122 == null) goto L89;
        r122.w(r116.f290136a, r118);
        return;
    L89:
        return;
    L67:
        if (r119 != 4) goto L72;
        m58.v r123 = m58.h.f512138i;
        if (r123 == null) goto L87;
        r123.e(r116.f290136a, r118);
        return;
    L87:
        return;
    L72:
        throw new NoWhenBranchMatchedException();
    L23:
        if ((!r108.isEmpty()) == true) goto L26;
        r108 = null;
    L26:
        if (r108 == null) goto L39;
        StringBuilder r124 = new StringBuilder("<Params=");
        ArrayList r125 = new ArrayList(r108.size());
        Iterator<Map.Entry<a0, Object>> r126 = r108.entrySet().iterator();
    L29:
        if (r126.hasNext() == false) goto L38;
        Map.Entry<a0, Object> r127 = r126.next();
        a0 r128 = r127.getKey();
        Object r129 = r127.getValue();
        String r130 = "\"" + c(r128.f290015a) + Typography.quote;
        if ((r129 instanceof String) == false) goto L34;
        String r131 = "\"" + c((String) r129) + Typography.quote;
    L37:
        r125.add(r130 + ':' + r131);
        goto L29
    L34:
        if ((r129 instanceof Number) == false) goto L36;
        r131 = r129.toString();
        goto L37
    L36:
        r131 = "\"" + c(r129.toString()) + Typography.quote;
        goto L37
    L38:
        r124.append("{" + CollectionsKt.joinToString$default(r125, ",", null, null, 0, null, null, 62, null) + '}');
        r124.append(Typography.greater);
        r110.add(r124.toString());
        goto L39
    L19:
        r106 = -1;
    L11:
        r104 = "";
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static String c(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "<", "", false, 4, null), ">", "", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    public final void b(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r0 r101 = this.f290167c;
        Map<a0, Object> r102 = r101.f290135g;
        if (r102 != null) goto L7;
        r101.f290135g = new HashMap(r100);
        return;
    L7:
        Intrinsics.checkNotNull(r102);
        r102.putAll(r100);
    }

    public z(s0 r100, AudioLogLevel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r102, "what");
        this.f290165a = r100;
        this.f290166b = r101;
        this.f290167c = new r0(r102);
    }
}
