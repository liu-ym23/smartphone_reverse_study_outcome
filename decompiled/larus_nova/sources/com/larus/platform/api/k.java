package com.larus.platform.api;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f365180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<String> f365183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CachedVideosPreloadFrom f365184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f365185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f365186g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f365180a, r101.f365180a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365181b, r101.f365181b) == true) goto L15;
        return false;
    L15:
        if (this.f365182c == r101.f365182c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365183d, r101.f365183d) == true) goto L21;
        return false;
    L21:
        if (this.f365184e == r101.f365184e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365185f, r101.f365185f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365186g, r101.f365186g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f365180a.hashCode() * 31) + this.f365181b.hashCode()) * 31;
        long r101 = this.f365182c;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f365183d.hashCode()) * 31) + this.f365184e.hashCode()) * 31;
        Integer r103 = this.f365185f;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        HashMap<String, String> r107 = this.f365186g;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "CmdCachedVideoItems(cachedVideoItemsToRequestId=" + this.f365180a + ", messageId=" + this.f365181b + ", cacheTimeStamp=" + this.f365182c + ", itemIdList=" + this.f365183d + ", dataFrom=" + this.f365184e + ", imprIndex=" + this.f365185f + ", cachedVideoItemsToChannelId=" + this.f365186g + ')';
    }

    public k(HashMap<String, String> r100, String r101, long r102, ArrayList<String> r103, CachedVideosPreloadFrom r104, Integer r105, HashMap<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "cachedVideoItemsToRequestId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, "itemIdList");
        Intrinsics.checkNotNullParameter(r104, "dataFrom");
        this.f365180a = r100;
        this.f365181b = r101;
        this.f365182c = r102;
        this.f365183d = r103;
        this.f365184e = r104;
        this.f365185f = r105;
        this.f365186g = r106;
    }
}
