package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public q(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r17) {
        CommonMeta r1 = (CommonMeta) r17;
        if (r1 != null) goto L5;
    L19:
        AnchorV4NavArea r3 = this.a.i2();
        if (r3 == null) goto L46;
        TopNavigationComponentV1 r4 = this.a;
        r4.getClass();
        if (r1 == null) goto L24;
        Boolean r6 = Boolean.valueOf(r1.isLuban());
    L25:
        if (r1 == null) goto L27;
        Boolean r7 = Boolean.valueOf(r1.getThirdParty());
    L28:
        if (r1 == null) goto L30;
        String r8 = r1.getProductId();
    L31:
        Boolean r9 = Boolean.valueOf(true ^ Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r4.O1())).b.d.a(), Boolean.FALSE));
        if (r1 == null) goto L34;
        String r10 = r1.getSourcePage();
    L36:
        if (r1 == null) goto L38;
        String r13 = r1.getSearchPageSchema();
    L39:
        if (r1 == null) goto L41;
        Map r14 = r1.getSearchPageParams();
    L42:
        com.bytedance.android.shopping.anchorv3.widget.f r15 = new com.bytedance.android.shopping.anchorv3.widget.f(r6, r7, r8, r9, r10, null, null, r13, r14, 224);
        Intrinsics.checkNotNullParameter(r15, "searchParams");
        r3.post(new com.bytedance.android.shopping.anchorv4.nav.b(r3, r15));
        return;
    L41:
        r14 = null;
        goto L42
    L38:
        r13 = null;
        goto L39
    L34:
        r10 = null;
        goto L36
    L30:
        r8 = null;
        goto L31
    L27:
        r7 = null;
        goto L28
    L24:
        r6 = null;
        goto L25
    L46:
        return;
    L5:
        if (r1.getProductDeleted() != true) goto L19;
        AnchorV4NavArea r2 = this.a.i2();
        if (r2 == null) goto L11;
        ViewGroup r5 = r2.getLightIconsLayout();
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        AnchorV4NavArea r11 = this.a.i2();
        if (r11 == null) goto L16;
        AnchorV4SearchEditView r12 = r11.getSearchEditView();
        if (r12 == null) goto L16;
        r12.setVisibility(8);
    L16:
        AnchorV4NavArea r16 = this.a.i2();
        if (r16 == null) goto L44;
        r16.g(Boolean.TRUE, this.a.g2().getNativeParams().getFullMode());
        return;
    }
}
