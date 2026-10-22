package com.ss.android.ugc.aweme.search.common.mob;

import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.ec.search.common.RequestInfoSensitive;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ECSearchSugShowEvent;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSugShowEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f451760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f451761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f451762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RequestInfoSensitive f451763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f451764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JsonObject f451765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f451766g;

    public ECSearchSugShowEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f451766g = r100;
    }
}
