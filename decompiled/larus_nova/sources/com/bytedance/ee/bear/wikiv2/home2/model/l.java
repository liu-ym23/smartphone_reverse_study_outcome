package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpaceBean> f240936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f240937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WikiSpacesResp.Origin f240938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f240939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WikiSpaceFilterInfo f240940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f240941f;

    public /* synthetic */ l() {
        throw null;
    }

    public l(List r100) {
        WikiSpacesResp.Origin r101 = WikiSpacesResp.Origin.Network;
        WikiSpaceFilterInfo.Companion.getClass();
        this(r100, false, r101, null, WikiSpaceFilterInfo.access$getNoFilterInfo$cp());
    }

    public final l a(WikiSpacesResp r100) {
        Intrinsics.checkNotNullParameter(r100, "resp");
        List<SpaceBean> r101 = r100.f240918b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L17:
        return this;
    L11:
        if (r100.f240921e != this.f240938c) goto L17;
        if (r100.f240917a.isSameFilterWith(this.f240940e) == false) goto L17;
        ArrayList r103 = new ArrayList(this.f240936a);
        r103.addAll(r101);
        return new l(r103, r100.f240919c, this.f240938c, r100.f240920d, this.f240940e);
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        return this.f240941f.containsKey(r100);
    }

    public final SpaceBean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Integer r101 = this.f240941f.get(r100);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        return (SpaceBean) ListProtector.get(this.f240936a, r102);
    L6:
        return null;
    }

    public l(WikiSpacesResp r100, WikiSpaceFilterInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "resp");
        List<SpaceBean> r102 = r100.f240918b;
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List<SpaceBean> r103 = r102;
        boolean r104 = r100.f240919c;
        WikiSpacesResp.Origin r105 = r100.f240921e;
        String r106 = r100.f240920d;
        if (r101 != null) goto L8;
        r101 = r100.f240917a;
    L8:
        this(r103, r104, r105, r106, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(List<? extends SpaceBean> r100, boolean r101, WikiSpacesResp.Origin r102, String r103, WikiSpaceFilterInfo r104) {
        Intrinsics.checkNotNullParameter(r100, "wikiSpaces");
        Intrinsics.checkNotNullParameter(r102, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r104, "filterInfo");
        this.f240936a = r100;
        this.f240937b = r101;
        this.f240938c = r102;
        this.f240939d = r103;
        this.f240940e = r104;
        List<? extends SpaceBean> r105 = r100;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
        int r108 = 0;
    L4:
        if (r107.hasNext() == false) goto L9;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r106.add(TuplesKt.to(((SpaceBean) r109).space_id, Integer.valueOf(r108)));
        r108 = r110;
        goto L4
    L9:
        this.f240941f = MapsKt.toMap(r106);
    }
}
