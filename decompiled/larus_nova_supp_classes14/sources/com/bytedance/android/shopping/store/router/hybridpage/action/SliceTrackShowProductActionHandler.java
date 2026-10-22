package com.bytedance.android.shopping.store.router.hybridpage.action;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.c;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.utils.q;
import com.bytedance.android.shopping.store.utils.s;
import com.bytedance.android.shopping.store.utils.t;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class SliceTrackShowProductActionHandler implements com.bytedance.android.shopping.store.slicecard.a {
    public final Fragment a;
    public final SliceProductCardData b;
    public final c c;

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r1, View r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
    }

    public final void e(final View r35, Map<String, ? extends Object> r36) {
        Intrinsics.checkNotNullParameter(r35, "target");
        SliceProductCardData r2 = this.b;
        if (r2 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.a.C0014a r3 = (com.bytedance.android.shopping.store.router.hybridpage.presenter.product.a.C0014a) this;
        HashSet<String> r6 = r3.d.e.x.getIdRecords();
        SliceProductCardData r7 = this.b;
        String r8 = null;
        if (r7 == null) goto L11;
        ProductBasicRequestParam r9 = r7.getProductBasicRequestParam();
    L12:
        SliceProductCardData r10 = this.b;
        if (r10 == null) goto L15;
        String r11 = r10.getEcomEntranceFrom();
    L16:
        SliceProductCardData r12 = this.b;
        if (r12 == null) goto L19;
        String r13 = r12.getSearchParams();
    L20:
        SliceProductCardData r14 = this.b;
        if (r14 == null) goto L23;
        String r15 = r14.getPreProductId();
    L24:
        SliceProductCardData r16 = this.b;
        if (r16 == null) goto L27;
        String r17 = r16.getPreRoomId();
    L28:
        SliceProductCardData r18 = this.b;
        if (r18 == null) goto L31;
        String r19 = r18.getPreGroupId();
    L32:
        SliceProductCardData r20 = this.b;
        if (r20 != null) goto L35;
    L37:
        boolean r110 = false;
    L38:
        SliceProductCardData r21 = this.b;
        if (r21 == null) goto L41;
        String r111 = r21.getShareContent();
    L42:
        SliceProductCardData r22 = this.b;
        if (r22 == null) goto L45;
        String r112 = r22.getShareObject();
    L46:
        SliceProductCardData r23 = this.b;
        if (r23 == null) goto L49;
        String r113 = r23.getPageName();
    L50:
        SliceProductCardData r24 = this.b;
        if (r24 == null) goto L53;
        String r114 = r24.getEntranceLocation();
    L54:
        SliceProductCardData r25 = this.b;
        if (r25 == null) goto L57;
        Integer r26 = r25.getFollowStatus();
    L58:
        SliceProductCardData r27 = this.b;
        if (r27 == null) goto L61;
        String r28 = r27.getTempId();
    L62:
        SliceProductCardData r29 = this.b;
        if (r29 == null) goto L65;
        String r210 = r29.getStoreSourcePage();
    L66:
        SliceProductCardData r30 = this.b;
        if (r30 == null) goto L69;
        String r211 = r30.getStoreSourceMethod();
    L70:
        SliceProductCardData r31 = this.b;
        if (r31 == null) goto L73;
        String r212 = r31.getStoreGroupType();
    L74:
        SliceProductCardData r32 = this.b;
        if (r32 == null) goto L77;
        String r213 = r32.getLiveAnchorId();
    L78:
        Set<String> r33 = s.a;
        jm.a<LayoutTypes> r4 = r3.d.e.x.getLayoutType();
        if (r4 == null) goto L81;
        LayoutTypes r34 = (LayoutTypes) r4.getValue();
    L82:
        String r214 = s.f(r34);
        if (r9 != null) goto L85;
    L87:
        boolean r215 = false;
    L88:
        if (r9 == null) goto L90;
        String r37 = r9.getMaterialId();
    L91:
        SliceProductCardData r38 = this.b;
        if (r38 == null) goto L94;
        String r39 = (String) r38.getPassThroughParam("icon_type");
    L95:
        SliceProductCardData r40 = this.b;
        if (r40 == null) goto L98;
        r8 = (String) r40.getPassThroughParam("pass_through_api");
    L98:
        t.a(r35, r36, r5, r6, new q(r11, r13, r15, r17, r19, r110, r111, r112, r113, r114, r26, r28, r210, r211, r212, r213, r214, CommentServiceId.HOT_SPOT, "0", r215, r37, r39, r8), PageFinder.via(this.a), null, new SliceTrackShowProductActionHandler$showProduct$1(this, r35));
        return;
    L94:
        r39 = null;
        goto L95
    L90:
        r37 = null;
        goto L91
    L85:
        if (r9.isCustom() != true) goto L87;
        r215 = true;
        goto L88
    L81:
        r34 = null;
        goto L82
    L77:
        r213 = null;
        goto L78
    L73:
        r212 = null;
        goto L74
    L69:
        r211 = null;
        goto L70
    L65:
        r210 = null;
        goto L66
    L61:
        r28 = null;
        goto L62
    L57:
        r26 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r113 = null;
        goto L50
    L45:
        r112 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L35:
        if (r20.isEcShare() != true) goto L37;
        r110 = true;
        goto L38
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L5:
        if (r2.isPreview() != true) goto L7;
        r5 = true;
        goto L8
    }

    public SliceTrackShowProductActionHandler(Fragment r2, SliceProductCardData r3, HybridPageViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r1, View r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.c(r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
    }
}
