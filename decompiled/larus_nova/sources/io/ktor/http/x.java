package io.ktor.http;

import com.ss.bduploader.BDAbstractUpload;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class x implements Comparable<x> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f491916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f491917d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f491918e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f491919f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f491920g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f491921h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f491922i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f491923j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f491924k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final x f491925l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List<x> f491926m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f491927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f491928b;

    public static final class a {
    }

    static {
        x r100 = new x(100, "Continue");
        x r101 = new x(101, "Switching Protocols");
        f491916c = r101;
        x r102 = new x(102, "Processing");
        x r103 = new x(200, "OK");
        f491917d = r103;
        x r104 = new x(201, "Created");
        x r105 = new x(202, "Accepted");
        x r106 = new x(203, "Non-Authoritative Information");
        x r107 = new x(204, "No Content");
        x r108 = new x(205, "Reset Content");
        x r109 = new x(206, "Partial Content");
        x r110 = new x(207, "Multi-Status");
        x r111 = new x(300, "Multiple Choices");
        x r112 = new x(301, "Moved Permanently");
        f491918e = r112;
        x r113 = new x(302, "Found");
        f491919f = r113;
        x r114 = new x(303, "See Other");
        f491920g = r114;
        x r115 = new x(304, "Not Modified");
        f491921h = r115;
        x r116 = new x(305, "Use Proxy");
        x r117 = new x(306, "Switch Proxy");
        x r118 = new x(307, "Temporary Redirect");
        f491922i = r118;
        x r119 = new x(308, "Permanent Redirect");
        f491923j = r119;
        x r120 = new x(400, "Bad Request");
        x r121 = new x(401, "Unauthorized");
        x r122 = new x(402, "Payment Required");
        x r123 = new x(403, "Forbidden");
        x r124 = new x(404, "Not Found");
        x r125 = new x(405, "Method Not Allowed");
        x r126 = new x(406, "Not Acceptable");
        x r127 = new x(407, "Proxy Authentication Required");
        x r128 = new x(408, "Request Timeout");
        x r129 = new x(409, "Conflict");
        x r130 = new x(410, "Gone");
        x r131 = new x(411, "Length Required");
        x r132 = new x(412, "Precondition Failed");
        f491924k = r132;
        x r133 = new x(413, "Payload Too Large");
        x r134 = new x(414, "Request-URI Too Long");
        x r135 = new x(415, "Unsupported Media Type");
        x r136 = new x(416, "Requested Range Not Satisfiable");
        x r137 = new x(417, "Expectation Failed");
        x r138 = new x(422, "Unprocessable Entity");
        x r139 = new x(423, "Locked");
        x r140 = new x(424, "Failed Dependency");
        x r141 = new x(425, "Too Early");
        x r142 = new x(426, "Upgrade Required");
        x r143 = new x(BDAbstractUpload.KeyIsXQuicLibAvailable, "Too Many Requests");
        x r144 = new x(431, "Request Header Fields Too Large");
        x r145 = new x(500, "Internal Server Error");
        x r146 = new x(501, "Not Implemented");
        x r147 = new x(502, "Bad Gateway");
        x r148 = new x(503, "Service Unavailable");
        x r149 = new x(504, "Gateway Timeout");
        f491925l = r149;
        List<x> r150 = CollectionsKt.listOf(new x[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, new x(505, "HTTP Version Not Supported"), new x(506, "Variant Also Negotiates"), new x(507, "Insufficient Storage")});
        f491926m = r150;
        List<x> r151 = r150;
        LinkedHashMap r152 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r151, 10)), 16));
        Iterator<T> r153 = r151.iterator();
    L4:
        if (r153.hasNext() == false) goto L6;
        Object r154 = r153.next();
        r152.put(Integer.valueOf(((x) r154).f491927a), r154);
        goto L4
    }

    public final String toString() {
        return this.f491927a + ' ' + this.f491928b;
    }

    public final int hashCode() {
        return this.f491927a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(x r100) {
        x r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f491927a - r101.f491927a;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof x) == true) goto L5;
    L7:
        return false;
    L5:
        if (((x) r100).f491927a != this.f491927a) goto L7;
        return true;
    }

    public x(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f491927a = r100;
        this.f491928b = r101;
    }
}
