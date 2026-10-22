package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.view.ECWindowLiveCircleView;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowBaseInfoPresenterBase;", "Lcom/bytedance/android/window/shop/home/presenter/ECWindowInfoPresenterBase;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowBaseInfoPresenterBase extends ECWindowInfoPresenterBase {
    public static final /* synthetic */ int H = 0;
    public final int F;
    public final int G;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowBaseInfoPresenterBase a;

        public a(ECWindowBaseInfoPresenterBase r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            uq3.a r6 = (uq3.a) r5;
            if (r6 == null) goto L28;
            ECWindowBaseInfoPresenterBase r0 = this.a;
            int r1 = ECWindowBaseInfoPresenterBase.H;
            if (r0.F() == false) goto L23;
            uq3.o r7 = r6.c;
            if (r7 == null) goto L11;
            WindowV3LiveRoomVO r8 = r7.f;
        L12:
            if (r8 == null) goto L23;
            if (r0.O().isCroppedStyle() == false) goto L17;
        L19:
            SimpleDraweeView r9 = r0.v;
            if (r9 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("headImg");
        L22:
            r9.setOnClickListener(r0);
            goto L23
        L17:
            if (r0.d0() == true) goto L19;
            ECWindowLiveCircleView r10 = r0.w().b(2131371289).f();
            r10.setVisibility(0);
            r10.a();
            r0.w().b(2131371290).f().setVisibility(0);
            goto L19
        L11:
            r8 = null;
        L23:
            ECWindowBaseInfoPresenterBase r11 = this.a;
            View r2 = r11.w().b(2131370894).f();
            View r3 = r11.w().b(2131378860).f();
            View r4 = r11.w().b(2131376606).f();
            wg.a.c(r2);
            r11.O().getTopBarInfoParam().getClass();
            r11.O().getTopBarInfoParam().getClass();
            wg.a.c(r3);
            r11.O().getTopBarInfoParam().getClass();
            r11.O().getTopBarInfoParam().getClass();
            wg.a.c(r4);
            r11.O().getTopBarInfoParam().getClass();
            r11.O().getTopBarInfoParam().getClass();
            com.bytedance.android.window.shop.home.f r12 = r11.O().getTopBarInfoParam();
            r4.getHeight();
            r12.getClass();
            com.bytedance.android.window.shop.home.f r13 = r11.O().getTopBarInfoParam();
            r4.getWidth();
            r13.getClass();
            com.bytedance.android.ec.window.base.common.taskgraph.b<?> r14 = this.a.O().getPipeline();
            if (r14 == null) goto L27;
            r14.b(WindowLaunchTask.h, Unit.INSTANCE);
            return;
        L27:
            return;
        }
    }

    public ECWindowBaseInfoPresenterBase() {
        this.F = (int) 4294967295L;
        this.G = 654301398;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final void i0() {
        if (F() == false) goto L8;
        Function3<String, Boolean, String, Unit> r0 = O().getJump2Live();
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke("live_cell_head", Boolean.FALSE, null);
    L7:
        k0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to("click_area", "1031")));
        return;
    L8:
        h0();
        k0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to("click_area", "1032")));
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final int b0() {
        return this.G;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final int c0() {
        return this.F;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.ECWindowInfoPresenterBase
    public final void A(QModel r4) {
        super.A(r4);
        O().getHeaderResponse().a(U(), new a(this), false);
    }

    public final void k0(String r10, Map<String, String> r11) {
        uq3.a r12 = (uq3.a) O().getHeaderResponse().getValue();
        String r0 = null;
        if (r12 == null) goto L5;
        uq3.o r13 = r12.c;
    L6:
        uq3.a r1 = (uq3.a) O().getHeaderResponse().getValue();
        if (r1 == null) goto L24;
        uq3.o r2 = r1.c;
        if (r2 == null) goto L24;
        if (r2.u != true) goto L24;
        if (r13 == null) goto L14;
        List<uq3.p> r3 = r13.r;
    L15:
        List<uq3.p> r4 = r3;
        if (r4 != null) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L24;
        boolean r6 = true;
    L25:
        if (r13 == null) goto L27;
        ECUrlModel r7 = r13.g;
    L28:
        if (r7 == null) goto L30;
        String r8 = CommentServiceId.HOT_SPOT;
    L31:
        ECWindowViewModel r9 = O();
        Pair[] r14 = new Pair[8];
        r14[0] = TuplesKt.to("store_type", "window");
        if (r13 == null) goto L36;
        uq3.k r15 = r13.s;
        if (r15 == null) goto L36;
        String r16 = r15.a;
    L37:
        r14[1] = TuplesKt.to("fans_cnt", r16);
        Integer r17 = O().getShopParam().getFollowStatus();
        if (r17 == null) goto L40;
        String r18 = String.valueOf(r17.intValue());
    L41:
        r14[2] = TuplesKt.to("follow_status", r18);
        r14[3] = TuplesKt.to("author_id", O().getShopParam().getAuthorId());
        r14[4] = TuplesKt.to("entrance_info", O().getEntranceInfo());
        if (r13 == null) goto L48;
        WindowAuthorReputationVO r19 = r13.e;
        if (r19 == null) goto L48;
        Double r110 = r19.getScore();
        if (r110 == null) goto L48;
        r0 = String.valueOf(r110.doubleValue());
    L48:
        r14[5] = TuplesKt.to("experience_score", r0);
        if (r6 == false) goto L51;
        String r111 = CommentScene.COMMENTSCENE_NO_AWEME;
    L52:
        r14[6] = TuplesKt.to("is_fans_comment", r111);
        r14[7] = TuplesKt.to("background_picture_type", r8);
        r9.doEventAction("store_experience_score_click", r11, r14);
        return;
    L51:
        r111 = "0";
        goto L52
    L40:
        r18 = null;
    L36:
        r16 = null;
        goto L37
    L30:
        r8 = "102";
        goto L31
    L27:
        r7 = null;
        goto L28
    L18:
        if (r4.isEmpty() == true) goto L21;
        r5 = false;
        goto L22
    L14:
        r3 = null;
    L24:
        r6 = false;
        goto L25
    L5:
        r13 = null;
        goto L6
    }
}
