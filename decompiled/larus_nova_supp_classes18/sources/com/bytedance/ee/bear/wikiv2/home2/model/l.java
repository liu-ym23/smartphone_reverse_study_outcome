package com.bytedance.ee.bear.wikiv2.home2.model;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public final List<SpaceBean> a;
    public final boolean b;
    public final WikiSpacesResp.Origin c;
    public final String d;
    public final WikiSpaceFilterInfo e;
    public final Map<String, Integer> f;

    public /* synthetic */ l() {
        throw null;
    }

    public l(List r7) {
        WikiSpacesResp.Origin r3 = WikiSpacesResp.Origin.Network;
        WikiSpaceFilterInfo.Companion.getClass();
        this(r7, false, r3, null, WikiSpaceFilterInfo.access$getNoFilterInfo$cp());
    }

    public final l a(WikiSpacesResp r9) {
        Intrinsics.checkNotNullParameter(r9, "resp");
        List<SpaceBean> r0 = r9.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L17:
        return this;
    L11:
        if (r9.e != this.c) goto L17;
        if (r9.a.isSameFilterWith(this.e) == false) goto L17;
        ArrayList r3 = new ArrayList(this.a);
        r3.addAll(r0);
        return new l(r3, r9.c, this.c, r9.d, this.e);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        return this.f.containsKey(r2);
    }

    public final SpaceBean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        Integer r3 = this.f.get(r2);
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
        return (SpaceBean) ListProtector.get(this.a, r4);
    L6:
        return null;
    }

    public l(WikiSpacesResp r8, WikiSpaceFilterInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "resp");
        List<SpaceBean> r0 = r8.b;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List<SpaceBean> r2 = r0;
        boolean r3 = r8.c;
        WikiSpacesResp.Origin r4 = r8.e;
        String r5 = r8.d;
        if (r9 != null) goto L8;
        r9 = r8.a;
    L8:
        this(r2, r3, r4, r5, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(List<? extends SpaceBean> r2, boolean r3, WikiSpacesResp.Origin r4, String r5, WikiSpaceFilterInfo r6) {
        Intrinsics.checkNotNullParameter(r2, "wikiSpaces");
        Intrinsics.checkNotNullParameter(r4, "origin");
        Intrinsics.checkNotNullParameter(r6, "filterInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        List<? extends SpaceBean> r7 = r2;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
        int r10 = 0;
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r8.add(TuplesKt.to(((SpaceBean) r11).space_id, Integer.valueOf(r10)));
        r10 = r12;
        goto L4
    L9:
        this.f = MapsKt.toMap(r8);
    }
}
