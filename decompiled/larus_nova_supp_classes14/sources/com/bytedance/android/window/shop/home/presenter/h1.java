package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.repository.dto.WindowFollowCommitDTO;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h1<T> implements Consumer {
    public final /* synthetic */ ECWindowInfoPresenterBase a;

    public h1(ECWindowInfoPresenterBase r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        WindowFollowCommitDTO r15 = (WindowFollowCommitDTO) r14;
        boolean r1 = true;
        int r2 = 0;
        if (r15.getStatusCode() == 0) goto L13;
        String r0 = r15.getStatusMsg();
        if (r0 != null) goto L7;
    L10:
        if (r1 == false) goto L12;
        ECWindowInfoPresenterBase r16 = this.a;
        int r3 = ECWindowInfoPresenterBase.E;
        UIUtils.displayToast(r16.u().c(), 2131896788);
        return;
    L12:
        ECWindowInfoPresenterBase r4 = this.a;
        int r5 = ECWindowInfoPresenterBase.E;
        UIUtils.displayToast(r4.u().c(), r15.getStatusMsg());
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L10
    L13:
        this.a.O().getShopParam().setFollowStatus(1);
        this.a.e0(true);
        ECWindowInfoPresenterBase.a0(this.a);
        this.a.getClass();
        int r6 = uq3.l.b;
        final uq3.l r17 = uq3.l.a.a(r15);
        if (r17.a == null) goto L74;
        ECWindowInfoPresenterBase r7 = this.a;
        r7.getClass();
        final Context r8 = r7.u().c();
        final ECWindowDialogFragment r9 = r7.I();
        com.bytedance.android.ec.window.base.repository.vo.d r10 = r17.a;
        if (r10 == null) goto L18;
        String r11 = r10.c();
    L19:
        final JSONObject r12 = com.bytedance.android.ec.core.utils.z1.g(r11);
        com.bytedance.android.ec.window.base.repository.vo.d r13 = r17.a;
        if (r13 == null) goto L22;
        final String r18 = r13.e();
    L23:
        WindowFloatLayout r19 = new ECWindowInfoPresenterBase$showFollowSuccessLynxNotice$1(r17, r8, r9, r12, r18);
        com.bytedance.android.ec.window.base.repository.vo.d r20 = r17.a;
        if (r20 == null) goto L26;
        String r21 = r20.d();
    L27:
        Pair[] r22 = new Pair[4];
        com.bytedance.android.ec.window.base.repository.vo.d r23 = r17.a;
        if (r23 == null) goto L30;
        String r24 = r23.c();
    L31:
        r22[0] = TuplesKt.to("data", r24);
        Pair[] r25 = new Pair[17];
        r25[0] = TuplesKt.to("kol_id", r7.O().getShopParam().getAuthorId());
        r25[1] = TuplesKt.to("sec_kol_id", r7.O().getShopParam().getSecAuthorId());
        r25[2] = TuplesKt.to("entrance_location", r7.O().getShopParam().getEntranceLocation());
        r25[3] = TuplesKt.to("enter_from", r7.O().getShopParam().getEntranceLocation());
        if (r7.O().getShopParam().getBrandTag() == null) goto L34;
        r2 = 1;
    L34:
        r25[4] = TuplesKt.to("brand_verified", Integer.valueOf(r2));
        Integer r26 = r7.O().getShopParam().getFollowStatus();
        if (r26 == null) goto L37;
        String r27 = String.valueOf(r26.intValue());
    L38:
        String r28 = "";
        if (r27 != null) goto L41;
        r27 = "";
    L41:
        r25[5] = TuplesKt.to("follow_status", r27);
        String r29 = r7.O().getShopParam().getTempId();
        if (r29 != null) goto L44;
        r29 = "";
    L44:
        r25[6] = TuplesKt.to("temp_id", r29);
        String r30 = r7.O().getShopParam().getSearchParams();
        if (r30 != null) goto L47;
        r30 = "";
    L47:
        r25[7] = TuplesKt.to("search_params", r30);
        String r31 = r7.O().getShopParam().getStoreSourcePage();
        if (r31 != null) goto L50;
        r31 = "";
    L50:
        r25[8] = TuplesKt.to("store_source_page", r31);
        String r32 = r7.O().getShopParam().getStoreSourceMethod();
        if (r32 != null) goto L53;
        r32 = "";
    L53:
        r25[9] = TuplesKt.to("store_source_method", r32);
        String r33 = r7.O().getShopParam().getStoreGroupType();
        if (r33 != null) goto L56;
        r33 = "";
    L56:
        r25[10] = TuplesKt.to("store_group_type", r33);
        String r34 = r7.O().getEntranceInfo();
        if (r34 != null) goto L59;
        r34 = "";
    L59:
        r25[11] = TuplesKt.to("entrance_info", r34);
        String r35 = (String) r7.O().getShopParam().getPassThroughParam("pass_through_api");
        if (r35 == null) goto L63;
        r28 = r35;
    L63:
        r25[12] = TuplesKt.to("pass_through_api", r28);
        r25[13] = TuplesKt.to("author_id", r7.O().getShopParam().getAuthorId());
        r25[14] = TuplesKt.to("sec_author_id", r7.O().getShopParam().getSecAuthorId());
        r25[15] = TuplesKt.to("store_type", "window");
        JSONObject r36 = new JSONObject();
        if (r7.O().getShopParam().isEcShare() == false) goto L67;
        r36.put("is_ec_shopping", 1);
        r36.put("share_content", r7.O().getShopParam().getShareContent());
        r36.put("share_object", r7.O().getShopParam().getShareObject());
    L67:
        if (Intrinsics.areEqual(r7.O().getShopParam().getShareContent(), "shop") == false) goto L69;
        r36.put("entrance_location", r7.O().getShopParam().getEntranceLocation());
    L69:
        r36.put("pre_product_id", r7.O().getShopParam().getPreProductId());
        r36.put("pre_group_id", r7.O().getShopParam().getPreGroupId());
        r36.put("pre_room_id", r7.O().getShopParam().getPreRoomId());
        r25[16] = TuplesKt.to("log_extra", r36.toString());
        r22[1] = TuplesKt.to("metaInfo", MapsKt.mutableMapOf(r25));
        com.bytedance.android.ec.window.base.repository.vo.d r37 = r17.a;
        if (r37 == null) goto L72;
        String r38 = r37.e();
    L73:
        r22[2] = TuplesKt.to("name", r38);
        r22[3] = TuplesKt.to("component", com.bytedance.android.shopping.extensions.k.v(r17.a));
        r19.e(r21, MapsKt.mapOf(r22), null);
        return;
    L72:
        r38 = null;
        goto L73
    L37:
        r27 = null;
        goto L38
    L30:
        r24 = null;
        goto L31
    L26:
        r21 = null;
        goto L27
    L22:
        r18 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L74:
        UIUtils.displayToast(this.a.u().c(), 2131896752);
    }
}
