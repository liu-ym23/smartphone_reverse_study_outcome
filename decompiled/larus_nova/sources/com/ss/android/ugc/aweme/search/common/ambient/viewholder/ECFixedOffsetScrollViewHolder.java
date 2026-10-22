package com.ss.android.ugc.aweme.search.common.ambient.viewholder;

import android.view.View;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ambient/viewholder/ECFixedOffsetScrollViewHolder;", "Lcom/ss/android/ugc/aweme/search/common/ambient/viewholder/ECDefaultScrollViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFixedOffsetScrollViewHolder extends ECDefaultScrollViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f451464c;

    @Override // com.ss.android.ugc.aweme.search.common.ambient.viewholder.ECDefaultScrollViewHolder
    public final View b() {
        return this.f451464c;
    }

    public ECFixedOffsetScrollViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        super(r100);
        this.f451464c = r100;
    }

    @Override // com.ss.android.ugc.aweme.search.common.ambient.viewholder.ECDefaultScrollViewHolder, com.ss.android.ugc.aweme.utils.scrollcontroller.IScrollViewHolder
    public final void a(float r100) {
        float r101 = this.f451462a * 0.0f;
        Logger.a("AmbientDebug", "ECFixedOffsetScrollViewHolder scrollY changed (translationY), scrollY = " + r100 + " realOffset = " + r101 + ", fixedOffset = 0.0");
        this.f451464c.setTranslationY((r100 + r101) + 0.0f);
    }
}
