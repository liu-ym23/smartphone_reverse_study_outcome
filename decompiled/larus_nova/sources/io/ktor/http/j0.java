package io.ktor.http;

import com.ss.bduploader.UploadKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class j0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0 f491877c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0 f491878d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j0 f491879e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, j0> f491880f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f491882b;

    public static final class a {
        public static j0 a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            String r101 = io.ktor.util.t.c(r100);
            j0 r102 = (j0) ((LinkedHashMap) j0.f491880f).get(r101);
            if (r102 == null) goto L5;
            return r102;
        L5:
            return new j0(r101, 0);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f491881a, r101.f491881a) == true) goto L12;
        return false;
    L12:
        if (this.f491882b == r101.f491882b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f491881a.hashCode() * 31) + this.f491882b;
    }

    public final String toString() {
        return "URLProtocol(name=" + this.f491881a + ", defaultPort=" + this.f491882b + ')';
    }

    static {
        j0 r100 = new j0("http", 80);
        f491877c = r100;
        j0 r101 = new j0("https", UploadKeys.KeyIsGetVideoMeta);
        j0 r102 = new j0("ws", 80);
        f491878d = r102;
        j0 r103 = new j0("wss", UploadKeys.KeyIsGetVideoMeta);
        f491879e = r103;
        List r104 = CollectionsKt.listOf(new j0[]{r100, r101, r102, r103, new j0("socks", 1080)});
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Object r107 = r106.next();
        r105.put(((j0) r107).f491881a, r107);
        goto L4
    L6:
        f491880f = r105;
    }

    public j0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f491881a = r100;
        this.f491882b = r101;
        boolean r102 = false;
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r100.length()) goto L12;
        char r105 = r100.charAt(r103);
        if (Character.toLowerCase(r105) == r105) goto L9;
        r104 = false;
    L9:
        if (r104 == false) goto L13;
        r103 = r103 + 1;
    L13:
        if (r102 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("All characters should be lower case".toString());
    L12:
        r102 = true;
        goto L13
    }
}
