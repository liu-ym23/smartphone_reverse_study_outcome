package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraObricGlassesExploreDetailType f339569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f339570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d1 f339571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x0 f339572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x0 f339573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d1> f339574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d1 f339575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<d1> f339576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<d1> f339577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f339578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f339579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<z> f339580m;

    public r0() {
        throw null;
    }

    public r0(String r110, DoraObricGlassesExploreDetailType r111, d1 r112, d1 r113, x0 r210, x0 r211, d1 r212, List r213, List r214, b0 r215, String r216, List r217, int r218) {
        if ((r218 & 2) == 0) goto L5;
        DoraObricGlassesExploreDetailType r100 = DoraObricGlassesExploreDetailType.INTRODUCTION;
    L6:
        b0 r101 = null;
        if ((r218 & 32) == 0) goto L9;
        x0 r102 = null;
    L11:
        if ((r218 & 128) == 0) goto L13;
        List<d1> r114 = CollectionsKt.emptyList();
    L15:
        if ((r218 & 256) == 0) goto L17;
        d1 r115 = null;
    L19:
        if ((r218 & 512) == 0) goto L21;
        List r116 = CollectionsKt.emptyList();
    L23:
        if ((r218 & 1024) == 0) goto L25;
        List r117 = CollectionsKt.emptyList();
    L27:
        if ((r218 & 2048) != 0) goto L31;
        r101 = r215;
    L31:
        if ((r218 & 8192) == 0) goto L33;
        List r103 = CollectionsKt.emptyList();
    L34:
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r100, "detailType");
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r113, "description");
        Intrinsics.checkNotNullParameter(r210, "image");
        Intrinsics.checkNotNullParameter(r114, "querySpecs");
        Intrinsics.checkNotNullParameter(r116, "detailDescriptionSpecs");
        Intrinsics.checkNotNullParameter(r117, "detailQuerySpecs");
        Intrinsics.checkNotNullParameter(r216, "cardContentType");
        Intrinsics.checkNotNullParameter(r103, "basicItemSpecs");
        this.f339568a = r110;
        this.f339569b = r100;
        this.f339570c = r112;
        this.f339571d = r113;
        this.f339572e = r210;
        this.f339573f = r102;
        this.f339574g = r114;
        this.f339575h = r115;
        this.f339576i = r116;
        this.f339577j = r117;
        this.f339578k = r101;
        this.f339579l = r216;
        this.f339580m = r103;
        return;
    L33:
        r103 = r217;
        goto L34
    L25:
        r117 = r214;
        goto L27
    L21:
        r116 = r213;
        goto L23
    L17:
        r115 = r212;
        goto L19
    L13:
        r114 = null;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r111;
        goto L6
    }
}
