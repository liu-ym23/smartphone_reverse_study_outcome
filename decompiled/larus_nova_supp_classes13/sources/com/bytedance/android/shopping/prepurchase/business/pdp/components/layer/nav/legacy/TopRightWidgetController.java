package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.nav.controls.ShareBtnAnimController;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopRightWidgetController implements com.bytedance.android.shopping.anchorv4.nav.controls.c {
    public final ShareBtnAnimController a;
    public final List<com.bytedance.android.shopping.anchorv4.nav.controls.d> b;
    public final a0 c;

    public final ShareBtnAnimController a() {
        return this.a;
    }

    public TopRightWidgetController(TagsScrollBoxComponentView r9, TagsScrollBoxComponent r10, TopRightControlsMeta r11, Lifecycle r12, a0 r13) {
        Intrinsics.checkNotNullParameter(r13, "anchorV4VM");
        this.c = r13;
        ShareBtnAnimController r0 = new ShareBtnAnimController(r13.c().getProductId(), r9, r10, r11, r12, new TopRightWidgetController$shareBtnAnimController$1(this));
        this.a = r0;
        this.b = CollectionsKt.listOf(r0);
    }
}
