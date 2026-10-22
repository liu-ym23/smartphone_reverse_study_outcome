package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopRightControlsComponent$handleFavouriteWithMeta$1 implements com.bytedance.android.shopping.anchorv4.bottom.w {
    public final /* synthetic */ TopRightControlsComponent a;

    public final CommonMeta a() {
        return this.a.c.a();
    }

    public final long getDuration() {
        return this.a.c.getDuration();
    }

    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.a.c.b();
    }

    public TopRightControlsComponent$handleFavouriteWithMeta$1(TopRightControlsComponent r1) {
        this.a = r1;
    }

    public final void n(final String r12, final Map<String, ? extends Object> r13, final boolean r14, final boolean r15, final String r16, final PageFinder r17) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        this.a.c(new TopRightControlsComponent$handleFavouriteWithMeta$1$track$1(this, r13, r16, r17, r12, r15, r14));
    }
}
