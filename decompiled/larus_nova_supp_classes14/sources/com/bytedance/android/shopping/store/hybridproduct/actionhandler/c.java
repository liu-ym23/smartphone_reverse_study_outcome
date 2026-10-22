package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.utils.q;
import com.bytedance.android.shopping.store.utils.s;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final q a(ECShopHybridProductViewModel r27, boolean r28, String r29) {
        if (r27 == null) goto L4;
        ECStoreParam r1 = r27.getStoreParam();
    L6:
        if (r27 == null) goto L8;
        String r3 = r27.getEcomEntranceFrom();
    L9:
        if (r1 == null) goto L11;
        String r4 = r1.getSearchParams();
    L12:
        if (r1 == null) goto L14;
        String r5 = r1.getPreProductId();
    L15:
        if (r1 == null) goto L17;
        String r6 = r1.getPreRoomId();
    L18:
        if (r1 == null) goto L20;
        String r7 = r1.getPreGroupId();
    L22:
        if (r1 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r1 == null) goto L29;
        String r9 = r1.getShareContent();
    L30:
        if (r1 == null) goto L32;
        String r10 = r1.getShareObject();
    L33:
        if (r1 == null) goto L35;
        String r11 = r1.getPageName();
    L36:
        if (r1 == null) goto L38;
        String r12 = r1.getEntranceLocation();
    L39:
        if (r1 == null) goto L41;
        Integer r13 = r1.getFollowStatus();
    L42:
        if (r1 == null) goto L44;
        String r14 = r1.getTempId();
    L45:
        if (r1 == null) goto L47;
        String r15 = r1.getStoreSourcePage();
    L48:
        if (r1 == null) goto L50;
        String r16 = r1.getStoreSourceMethod();
    L51:
        if (r1 == null) goto L53;
        String r17 = r1.getStoreGroupType();
    L54:
        if (r1 == null) goto L56;
        String r18 = r1.getLiveAnchorId();
    L57:
        Set<String> r19 = s.a;
        if (r27 == null) goto L62;
        jm.a<LayoutTypes> r110 = r27.getLayoutType();
        if (r110 == null) goto L62;
        LayoutTypes r111 = (LayoutTypes) r110.getValue();
    L63:
        String r112 = s.f(r111);
        if (r27 != null) goto L66;
    L68:
        String r0 = "0";
    L69:
        if (r1 == null) goto L71;
        String r24 = (String) r1.getPassThroughParam("icon_type");
    L72:
        if (r1 == null) goto L74;
        String r25 = (String) r1.getPassThroughParam("pass_through_api");
    L76:
        return new q(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r112, CommentServiceId.HOT_SPOT, r0, r28, r29, r24, r25);
    L74:
        r25 = null;
        goto L76
    L71:
        r24 = null;
        goto L72
    L66:
        if (r27.hasDiscountSelected() != true) goto L68;
        r0 = CommentScene.COMMENTSCENE_NO_AWEME;
    L62:
        r111 = null;
        goto L63
    L56:
        r18 = null;
        goto L57
    L53:
        r17 = null;
        goto L54
    L50:
        r16 = null;
        goto L51
    L47:
        r15 = null;
        goto L48
    L44:
        r14 = null;
        goto L45
    L41:
        r13 = null;
        goto L42
    L38:
        r12 = null;
        goto L39
    L35:
        r11 = null;
        goto L36
    L32:
        r10 = null;
        goto L33
    L29:
        r9 = null;
        goto L30
    L24:
        if (r1.isEcShare() != true) goto L26;
        r8 = true;
        goto L27
    L20:
        r7 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L4:
        r1 = null;
        goto L6
    }
}
