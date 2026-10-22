package com.bytedance.android.shopping.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.f;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/slice/ComponentDTOVH;", "Lcom/bytedance/android/ecom/arch/slice/slices/SlcBaseViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentDTOVH extends SlcBaseViewHolder<ComponentDTO> {
    public final SlcContext b;
    public final f c;
    public final View d;

    public final f V3() {
        return this.c;
    }

    public final SlcContext W3() {
        return this.b;
    }

    public final View s0() {
        return this.d;
    }

    public final void Y3(g r2) {
        Intrinsics.checkNotNullParameter(r2, "slice");
        this.d.setVisibility(8);
    }

    public ComponentDTOVH(SlcContext r3, f r4) {
        View r0 = new View(r3.getContext());
        Intrinsics.checkNotNullParameter(r3, "slcContext");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        Intrinsics.checkNotNullParameter(r0, "slcView");
        super(r0);
        this.b = r3;
        this.c = r4;
        this.d = r0;
    }
}
