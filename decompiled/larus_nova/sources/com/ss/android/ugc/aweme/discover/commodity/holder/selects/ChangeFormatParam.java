package com.ss.android.ugc.aweme.discover.commodity.holder.selects;

import android.view.View;
import com.ss.android.ugc.aweme.search.mob.ItemMobParam;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/selects/ChangeFormatParam;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChangeFormatParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f450285c;

    public ChangeFormatParam(String r100, String r101, ItemMobParam r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "originFormat");
        Intrinsics.checkNotNullParameter(r102, "itemMobParam");
        this.f450283a = r100;
        this.f450284b = r101;
        this.f450285c = r103;
    }
}
