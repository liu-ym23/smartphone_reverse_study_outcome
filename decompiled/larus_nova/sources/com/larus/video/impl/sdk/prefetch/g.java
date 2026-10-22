package com.larus.video.impl.sdk.prefetch;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f375859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<String> f375860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f375861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f375862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f375863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f375864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f375865h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f375858a, r101.f375858a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375859b, r101.f375859b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f375860c, r101.f375860c) == true) goto L18;
        return false;
    L18:
        if (this.f375861d == r101.f375861d) goto L21;
        return false;
    L21:
        if (this.f375862e == r101.f375862e) goto L24;
        return false;
    L24:
        if (this.f375863f == r101.f375863f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f375864g, r101.f375864g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f375865h, r101.f375865h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f375858a.hashCode() * 31) + this.f375859b.hashCode()) * 31) + this.f375860c.hashCode()) * 31;
        long r101 = this.f375861d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f375862e) * 31;
        if (this.f375863f == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        Integer r105 = this.f375864g;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        Map<String, String> r109 = this.f375865h;
        if (r109 == null) goto L15;
        r106 = r109.hashCode();
    L15:
        return r108 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "CachedPreloadItemIdsData(messageId=" + this.f375858a + ", itemIdToRequestIdMap=" + this.f375859b + ", itemIdList=" + this.f375860c + ", cacheValidTimeStamp=" + this.f375861d + ", dataFrom=" + this.f375862e + ", firstUse=" + this.f375863f + ", imprIndex=" + this.f375864g + ", itemIdToChannelIdMap=" + this.f375865h + ')';
    }

    public static g a(g r110) {
        String r100 = r110.f375858a;
        Map<String, String> r101 = r110.f375859b;
        ArrayList<String> r102 = r110.f375860c;
        long r103 = r110.f375861d;
        int r104 = r110.f375862e;
        Integer r105 = r110.f375864g;
        Map<String, String> r106 = r110.f375865h;
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "itemIdToRequestIdMap");
        Intrinsics.checkNotNullParameter(r102, "itemIdList");
        return new g(r100, r101, r102, r103, r104, false, r105, r106);
    }

    public /* synthetic */ g(String r110, Map r111, ArrayList r112, long r113, int r114, Integer r115, Map r210, int r211) {
        if ((r211 & 32) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r211 & 64) == 0) goto L9;
        Integer r116 = null;
    L11:
        if ((r211 & 128) == 0) goto L13;
        Map r117 = null;
    L14:
        this(r110, r111, r112, r113, r114, r100, r116, r117);
        return;
    L13:
        r117 = r210;
        goto L14
    L9:
        r116 = r115;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public g(String r100, Map<String, String> r101, ArrayList<String> r102, long r103, int r104, boolean r105, Integer r106, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "itemIdToRequestIdMap");
        Intrinsics.checkNotNullParameter(r102, "itemIdList");
        this.f375858a = r100;
        this.f375859b = r101;
        this.f375860c = r102;
        this.f375861d = r103;
        this.f375862e = r104;
        this.f375863f = r105;
        this.f375864g = r106;
        this.f375865h = r110;
    }
}
