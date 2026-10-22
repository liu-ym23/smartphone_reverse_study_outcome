package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class MinorTag {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f198181i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, Integer>> f198183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f198184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f198185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f198186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<PoiAnchorContentElement> f198187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f198188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f198189h;

    public static final class Companion {
        public static MinorTag a(PoiAnchorContentStruct r110) {
            Intrinsics.checkNotNullParameter(r110, "struct");
            int r100 = b.f198190a;
            int r101 = r110.getStyle();
            if (r101 != 1) goto L5;
            b r102 = new b.C2847b(0);
        L12:
            b r103 = r102;
            if (r110.getElements() != null) goto L20;
            String r104 = r110.getContent();
            if (r104 != null) goto L17;
            String r105 = "";
        L19:
            return new MinorTag(r105, CollectionsKt.listOf(new Pair(r105, -1)), r103, r110.getPriority(), VideoRef.VALUE_VIDEO_REF_CATEGORY);
        L17:
            r105 = r104;
            goto L19
        L20:
            List<PoiAnchorContentElement> r106 = r110.getElements();
            if (r106 == null) goto L30;
            List<PoiAnchorContentElement> r107 = r106;
            ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
            Iterator<T> r109 = r107.iterator();
        L24:
            if (r109.hasNext() == false) goto L29;
            PoiAnchorContentElement r111 = (PoiAnchorContentElement) r109.next();
            String r112 = r111.getText();
            if (r112 != null) goto L28;
            r112 = "";
        L28:
            r108.add(new Pair(r112, Integer.valueOf(r111.getTruncateMinLength())));
            goto L24
        L29:
            List r113 = r108;
        L32:
            if ((r103 instanceof b.d) == false) goto L35;
            return new MinorTag(CollectionsKt.joinToString$default(r113, "", null, null, 0, null, MinorTag$Companion$build$content$1.INSTANCE, 30, null), r113, r103, 0, 248);
        L35:
            if ((r103 instanceof b.C2847b) == true) goto L43;
            return null;
        L43:
            return new MinorTag(CollectionsKt.joinToString$default(r113, "", null, null, 0, null, MinorTag$Companion$build$content$2.INSTANCE, 30, null), r113, r103, 0, 248);
        L30:
            r113 = CollectionsKt.emptyList();
            goto L32
        L5:
            if (r101 != 2) goto L7;
            r102 = new b.e(0);
            goto L12
        L7:
            if (r101 == 3) goto L9;
            r102 = new b.d(0);
            goto L12
        L9:
            r102 = new b.c(0);
            goto L12
        }
    }

    static {
    }

    public MinorTag() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MinorTag) == true) goto L8;
        return false;
    L8:
        MinorTag r101 = (MinorTag) r100;
        if (Intrinsics.areEqual(this.f198182a, r101.f198182a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f198183b, r101.f198183b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f198184c, r101.f198184c) == true) goto L18;
        return false;
    L18:
        if (this.f198185d == r101.f198185d) goto L21;
        return false;
    L21:
        if (this.f198186e == r101.f198186e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f198187f, r101.f198187f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f198188g, r101.f198188g) == true) goto L30;
        return false;
    L30:
        if (this.f198189h == r101.f198189h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((((this.f198182a.hashCode() * 31) + this.f198183b.hashCode()) * 31) + this.f198184c.hashCode()) * 31;
        boolean r101 = this.f198185d;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (((r100 + r103) * 31) + this.f198186e) * 31;
        List<PoiAnchorContentElement> r105 = this.f198187f;
        int r106 = 0;
        if (r105 != null) goto L8;
        int r107 = 0;
    L9:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f198188g;
        if (r109 == null) goto L13;
        r106 = r109.hashCode();
    L13:
        int r110 = (r108 + r106) * 31;
        boolean r111 = this.f198189h;
        if (r111 == true) goto L18;
        r102 = r111;
    L18:
        return r110 + r102;
    L8:
        r107 = r105.hashCode();
        goto L9
    }

    public final String toString() {
        return "MinorTag(origin=" + this.f198182a + ", sections=" + this.f198183b + ", style=" + this.f198184c + ", shouldShow=" + this.f198185d + ", priority=" + this.f198186e + ", element=" + this.f198187f + ", greyBackgroundColor=" + this.f198188g + ", adapterStyle=" + this.f198189h + ')';
    }

    public MinorTag(String r100, List r101, b r102, int r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r104 & 16) == 0) goto L9;
        r103 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "sections");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f198182a = r100;
        this.f198183b = r101;
        this.f198184c = r102;
        this.f198185d = r105;
        this.f198186e = r103;
        this.f198187f = null;
        this.f198188g = null;
        this.f198189h = false;
        return;
    L5:
        r105 = false;
        goto L7
    }
}
