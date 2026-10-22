package com.ss.android.ugc.aweme.poi.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/POI_PREVIEW_DIALOG_SHOW_EVENT;", "", "", "b", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class POI_PREVIEW_DIALOG_SHOW_EVENT {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f451326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f451327b;

    public final String getType() {
        return this.f451327b;
    }

    public POI_PREVIEW_DIALOG_SHOW_EVENT(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "poiEnterId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f451326a = r100;
        this.f451327b = r101;
    }
}
