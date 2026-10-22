package com.ss.android.ugc.aweme.poi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/GoodsDetailHalfContainerStateEvent;", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailHalfContainerStateEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoodsDialogState f451320a;

    public GoodsDetailHalfContainerStateEvent(String r100, GoodsDialogState r101) {
        Intrinsics.checkNotNullParameter(r100, "ownerActivityName");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f451320a = r101;
    }
}
