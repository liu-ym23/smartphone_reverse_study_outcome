package com.ss.android.ugc.aweme.search.common.ambient.viewholder;

import android.view.View;
import com.ss.android.ugc.aweme.utils.scrollcontroller.IScrollViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ambient/viewholder/ECDefaultScrollViewHolder;", "Lcom/ss/android/ugc/aweme/utils/scrollcontroller/IScrollViewHolder;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECDefaultScrollViewHolder implements IScrollViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f451462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f451463b;

    public View b() {
        return this.f451463b;
    }

    public ECDefaultScrollViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        this.f451463b = r100;
        this.f451462a = 1.0f;
    }

    @Override // com.ss.android.ugc.aweme.utils.scrollcontroller.IScrollViewHolder
    public void a(float r100) {
        float r101 = this.f451462a * 0.0f;
        b().setTranslationY(r100 + r101);
    }
}
