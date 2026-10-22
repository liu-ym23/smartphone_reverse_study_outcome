package com.obric.livecard.api.entity;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003*\u0016\u0010\u0004\"\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"readWidgetFromParcel", "Lcom/obric/livecard/api/entity/IslandWidget;", "parcel", "Landroid/os/Parcel;", "OnViewClickListener", "Lkotlin/Function0;", "", "LiveCard-sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IslandSessionEntityKt {
    public static final IslandWidget readWidgetFromParcel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        return (IslandWidget) r100.readParcelable(IslandWidget.class.getClassLoader());
    L5:
        e = move-exception;
        e.getMessage();
        throw e;
    }
}
