package com.ss.android.ugc.aweme.helper.image;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/image/ECSearchCommoditySearchFrescoCallerContextWrapper;", "Lcom/ss/android/ugc/aweme/helper/image/ECSearchCommoditySearchFrescoCallerContext;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCommoditySearchFrescoCallerContextWrapper extends ECSearchCommoditySearchFrescoCallerContext {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f450878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f450879e;

    public ECSearchCommoditySearchFrescoCallerContextWrapper(ECSearchCommoditySearchFrescoCallerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "internal");
        super(r100.f450876b, r100.f450877c);
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(r100.f450875a);
        Unit r102 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f450875a = r101;
        this.f450878d = -1;
        this.f450879e = new LinkedHashSet();
    }
}
