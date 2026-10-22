package com.bytedance.android.window.shop.holder.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.z1;
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
public final class o<T> implements Consumer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public o(WindowHeaderFollowAboutPresenter r1, View r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r15) {
        WindowFollowCommitDTO r16 = (WindowFollowCommitDTO) r15;
        boolean r1 = true;
        int r2 = 0;
        if (r16.getStatusCode() == 0) goto L19;
        String r0 = r16.getStatusMsg();
        if (r0 != null) goto L7;
    L10:
        if (r1 == false) goto L12;
        WindowHeaderFollowAboutPresenter r17 = this.a;
        int r3 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r17.Y().c(), 2131896788);
    L13:
        View r18 = this.b;
        if (r18 == null) goto L16;
        r18.setVisibility(0);
    L16:
        View r19 = this.c;
        if (r19 == null) goto L85;
        r19.setVisibility(0);
        return;
    L85:
        return;
    L12:
        WindowHeaderFollowAboutPresenter r4 = this.a;
        int r5 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r4.Y().c(), r16.getStatusMsg());
        goto L13
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L10
    L19:
        View r6 = this.b;
        if (r6 == null) goto L22;
        r6.setVisibility(8);
    L22:
        View r7 = this.c;
        if (r7 == null) goto L25;
        r7.setVisibility(0);
    L25:
        this.a.d0().getShopParam().setFollowStatus(1);
        this.a.l0(true);
        WindowHeaderFollowAboutPresenter.i0(this.a);
        int r8 = uq3.l.b;
        final uq3.l r110 = uq3.l.a.a(r16);
        if (r110.a == null) goto L83;
        final Context r9 = this.a.Y().c();
        final ECWindowDialogFragment r10 = (ECWindowDialogFragment) this.a.z.getValue();
        com.bytedance.android.ec.window.base.repository.vo.d r11 = r110.a;
        if (r11 == null) goto L30;
        String r12 = r11.c();
    L31:
        final JSONObject r13 = z1.g(r12);
        com.bytedance.android.ec.window.base.repository.vo.d r14 = r110.a;
        if (r14 == null) goto L34;
        final String r20 = r14.e();
    L35:
        WindowFloatLayout r21 = new WindowHeaderFollowAboutPresenter$doFollowCommit$1$1(r110, r9, r10, r13, r20);
        com.bytedance.android.ec.window.base.repository.vo.d r22 = r110.a;
        if (r22 == null) goto L38;
        String r23 = r22.d();
    L39:
        Pair[] r24 = new Pair[3];
        com.bytedance.android.ec.window.base.repository.vo.d r25 = r110.a;
        if (r25 == null) goto L42;
        String r26 = r25.c();
    L43:
        r24[0] = TuplesKt.to("data", r26);
        WindowHeaderFollowAboutPresenter r27 = this.a;
        Pair[] r28 = new Pair[16];
        r28[0] = TuplesKt.to("kol_id", r27.d0().getShopParam().getAuthorId());
        r28[1] = TuplesKt.to("sec_kol_id", r27.d0().getShopParam().getSecAuthorId());
        r28[2] = TuplesKt.to("entrance_location", r27.d0().getShopParam().getEntranceLocation());
        r28[3] = TuplesKt.to("enter_from", r27.d0().getShopParam().getEntranceLocation());
        if (r27.d0().getShopParam().getBrandTag() == null) goto L46;
        r2 = 1;
    L46:
        r28[4] = TuplesKt.to("brand_verified", Integer.valueOf(r2));
        Integer r29 = r27.d0().getShopParam().getFollowStatus();
        if (r29 == null) goto L49;
        String r30 = String.valueOf(r29.intValue());
    L50:
        String r31 = "";
        if (r30 != null) goto L53;
        r30 = "";
    L53:
        r28[5] = TuplesKt.to("follow_status", r30);
        String r32 = r27.d0().getShopParam().getTempId();
        if (r32 != null) goto L56;
        r32 = "";
    L56:
        r28[6] = TuplesKt.to("temp_id", r32);
        String r33 = r27.d0().getShopParam().getSearchParams();
        if (r33 != null) goto L59;
        r33 = "";
    L59:
        r28[7] = TuplesKt.to("search_params", r33);
        String r34 = r27.d0().getShopParam().getStoreSourcePage();
        if (r34 != null) goto L62;
        r34 = "";
    L62:
        r28[8] = TuplesKt.to("store_source_page", r34);
        String r35 = r27.d0().getShopParam().getStoreSourceMethod();
        if (r35 != null) goto L65;
        r35 = "";
    L65:
        r28[9] = TuplesKt.to("store_source_method", r35);
        String r36 = r27.d0().getShopParam().getStoreGroupType();
        if (r36 != null) goto L68;
        r36 = "";
    L68:
        r28[10] = TuplesKt.to("store_group_type", r36);
        String r37 = (String) r27.d0().getShopParam().getPassThroughParam("pass_through_api");
        if (r37 == null) goto L72;
        r31 = r37;
    L72:
        r28[11] = TuplesKt.to("pass_through_api", r31);
        r28[12] = TuplesKt.to("author_id", r27.d0().getShopParam().getAuthorId());
        r28[13] = TuplesKt.to("sec_author_id", r27.d0().getShopParam().getSecAuthorId());
        r28[14] = TuplesKt.to("store_type", "window");
        JSONObject r38 = new JSONObject();
        if (r27.d0().getShopParam().isEcShare() == false) goto L76;
        r38.put("is_ec_shopping", 1);
        r38.put("share_content", r27.d0().getShopParam().getShareContent());
        r38.put("share_object", r27.d0().getShopParam().getShareObject());
    L76:
        if (Intrinsics.areEqual(r27.d0().getShopParam().getShareContent(), "shop") == false) goto L78;
        r38.put("entrance_location", r27.d0().getShopParam().getEntranceLocation());
    L78:
        r38.put("pre_product_id", r27.d0().getShopParam().getPreProductId());
        r38.put("pre_group_id", r27.d0().getShopParam().getPreGroupId());
        r38.put("pre_room_id", r27.d0().getShopParam().getPreRoomId());
        r28[15] = TuplesKt.to("log_extra", r38.toString());
        r24[1] = TuplesKt.to("metaInfo", MapsKt.mutableMapOf(r28));
        com.bytedance.android.ec.window.base.repository.vo.d r111 = r110.a;
        if (r111 == null) goto L81;
        String r112 = r111.e();
    L82:
        r24[2] = TuplesKt.to("name", r112);
        r21.e(r23, MapsKt.mapOf(r24), null);
        return;
    L81:
        r112 = null;
        goto L82
    L49:
        r30 = null;
        goto L50
    L42:
        r26 = null;
        goto L43
    L38:
        r23 = null;
        goto L39
    L34:
        r20 = null;
        goto L35
    L30:
        r12 = null;
        goto L31
    L83:
        UIUtils.displayToast(this.a.Y().c(), 2131896752);
    }
}
