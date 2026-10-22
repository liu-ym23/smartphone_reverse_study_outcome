package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.ec.core.anchorv3.q {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;

    public final void c() {
        AnchorV4HeadV2VO r0 = this.e.e;
        if (r0 == null) goto L16;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L17;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.getOrNull(r1, this.f);
        if (r2 == null) goto L18;
        HeaderSliceModel r3 = r2.getSlice();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.getHasReportedShowEvent() == true) goto L20;
        r3.setHasReportedShowEvent(true);
        IAction r4 = r3.getShowActions();
        if (r4 == null) goto L21;
        e r5 = this.e;
        r5.h.d(r4, r5.E, null);
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L17:
        return;
    }

    public h(e r1, int r2) {
        this.e = r1;
        this.f = r2;
        super(3);
    }
}
