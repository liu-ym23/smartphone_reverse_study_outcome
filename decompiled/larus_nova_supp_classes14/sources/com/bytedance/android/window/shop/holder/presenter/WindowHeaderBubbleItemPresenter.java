package com.bytedance.android.window.shop.holder.presenter;

import android.animation.AnimatorSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.window.shop.home.presenter.bubble.WindowHeadBubbleAdapter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.BubbleTypes;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleDoubleCard;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleSingleCard;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderBubbleItemPresenter extends ECWindowHolderBaseFragmentPresenter {
    public static final /* synthetic */ int m = 0;
    public final WindowHeaderBubbleItemPresenter$observer$1 i;
    public final Lazy j;
    public LinearLayout k;
    public com.bytedance.android.ec.window.base.common.bubble.r l;

    public static final class a {
    }

    static {
    }

    public final void c0() {
        d0().getSubCollapseProgress().removeObserver(this.i);
        com.bytedance.android.ec.window.base.common.bubble.r r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.c == true) goto L18;
        r0.getContentView().setVisibility(8);
        com.bytedance.android.ec.window.base.common.bubble.g r1 = r0.k;
        if (r1 == null) goto L9;
        r1.onDismiss();
    L9:
        AnimatorSet r2 = r0.b;
        if (r2 == null) goto L12;
        r2.removeAllListeners();
    L12:
        AnimatorSet r3 = r0.b;
        if (r3 == null) goto L15;
        r3.cancel();
    L15:
        r0.b = null;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
        r0.getContentView().removeCallbacks(r0.d);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.window.shop.holder.presenter.WindowHeaderBubbleItemPresenter$observer$1] */
    public WindowHeaderBubbleItemPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = new WindowHeaderBubbleItemPresenter$observer$1(this);
        this.j = LazyKt.lazy(new WindowHeaderBubbleItemPresenter$sharedPrefHelper$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard] */
    /* JADX WARN: Type inference failed for: r12v10, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard] */
    /* JADX WARN: Type inference failed for: r7v14, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.window.shop.widget.WindowHeadBubbleDoubleCard] */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.window.shop.widget.WindowHeadBubbleSingleCard, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v24, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.window.shop.widget.WindowHeadBubbleDoubleCard] */
    /* JADX WARN: Type inference failed for: r8v32, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard] */
    public final void b0(QModel r39) {
        View r1 = a0();
        if (r1 == null) goto L157;
        LinearLayout r2 = (LinearLayout) r1;
        this.k = r2;
        r2.setOrientation(0);
        QModel r3 = r39;
        String r4 = null;
        if ((r3 instanceof oq3.b) == true) goto L7;
        r3 = null;
    L7:
        oq3.b r5 = (oq3.b) r3;
        if (r5 == null) goto L151;
        LinearLayout r6 = this.k;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L12:
        r6.removeAllViews();
        List<uq3.e> r7 = r5.j;
        List<uq3.e> r8 = r7;
        if (r8 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
    L146:
        LinearLayout r10 = this.k;
        if (r10 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L149:
        ExtensionsKt.gone(r10);
    L150:
        d0().getSubCollapseProgress().observe(e0(), this.i);
        return;
    L21:
        if (d0().isCroppedStyleOpt() == true) goto L146;
        int r11 = r7.size();
        if (r11 != 1) goto L26;
        uq3.e r12 = (uq3.e) ListProtector.get(r7, 0);
        Object r13 = LayoutInflater.from(Y().c()).inflate(2131560996, null, false);
        if (r13 == null) goto L145;
        ?? r14 = (WindowHeadBubbleSingleCard) r13;
        Function1<String, Unit> r15 = new WindowHeaderBubbleItemPresenter$addSingleBubble$1(this);
        Function2<String, String, Unit> r16 = new WindowHeaderBubbleItemPresenter$addSingleBubble$2(this);
        WindowHeaderBubbleItemPresenter$addSingleBubble$3 r17 = new WindowHeaderBubbleItemPresenter$addSingleBubble$3(this);
        Intrinsics.checkNotNullParameter(r12, "bubbleVO");
        TextView r18 = r14.a;
        if (r18 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L86:
        r18.setText(r12.a);
        TextView r19 = r14.b;
        if (r19 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L89:
        r19.setText(r12.d);
        r14.setOnClickListener(new com.bytedance.android.window.shop.widget.v(r15, r12, r16));
        int r20 = (com.bytedance.android.ec.window.base.utils.c.a - com.bytedance.android.shopping.extensions.b.b(72)) / 4;
        SimpleDraweeView r110 = r14.c;
        if (r110 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("productOne");
    L92:
        wg.a.i(r110, r20);
        SimpleDraweeView r111 = r14.d;
        if (r111 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("productTwo");
    L95:
        wg.a.i(r111, r20);
        SimpleDraweeView r112 = r14.e;
        if (r112 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("productThree");
    L98:
        wg.a.i(r112, r20);
        SimpleDraweeView r113 = r14.f;
        if (r113 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("productFour");
    L101:
        wg.a.i(r113, r20);
        SimpleDraweeView r21 = r14.c;
        if (r21 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("productOne");
    L104:
        List<? extends ECUrlModel> r114 = r12.c;
        if (r114 == null) goto L107;
        ECUrlModel r23 = (ECUrlModel) CollectionsKt.getOrNull(r114, 0);
    L108:
        h0.d(r21, r23, null, null, null, null, null, 120);
        SimpleDraweeView r22 = r14.d;
        if (r22 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("productTwo");
    L111:
        List<? extends ECUrlModel> r115 = r12.c;
        if (r115 == null) goto L114;
        ECUrlModel r31 = (ECUrlModel) CollectionsKt.getOrNull(r115, 1);
    L115:
        h0.d(r22, r31, null, null, null, null, null, 120);
        SimpleDraweeView r24 = r14.e;
        if (r24 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("productThree");
    L118:
        List<? extends ECUrlModel> r116 = r12.c;
        if (r116 == null) goto L121;
        ECUrlModel r25 = (ECUrlModel) CollectionsKt.getOrNull(r116, 2);
    L122:
        h0.d(r24, r25, null, null, null, null, null, 120);
        SimpleDraweeView r26 = r14.f;
        if (r26 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("productFour");
    L125:
        List<? extends ECUrlModel> r117 = r12.c;
        if (r117 == null) goto L128;
        ECUrlModel r32 = (ECUrlModel) CollectionsKt.getOrNull(r117, 3);
    L129:
        h0.d(r26, r32, null, null, null, null, null, 120);
        Integer r27 = r12.f;
        if (r27 == null) goto L132;
        String r28 = String.valueOf(r27.intValue());
    L133:
        Unit r29 = (Unit) r16.invoke("bubble_show", r28);
        Unit r30 = (Unit) r17.invoke(r14, r12, 2, null);
        LinearLayout r33 = this.k;
        if (r33 != 0) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L136:
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, -2);
        r34.setMargins(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        Unit r35 = Unit.INSTANCE;
        r33.addView(r14, r34);
    L137:
        ECWindowViewModel r36 = d0();
        Pair[] r37 = new Pair[2];
        r37[0] = TuplesKt.to("bubble_cnt", String.valueOf(r7.size()));
        Integer r38 = d0().getShopParam().getFollowStatus();
        if (r38 == null) goto L140;
        r4 = String.valueOf(r38.intValue());
    L140:
        Intrinsics.checkNotNullParameter("0", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r4 != null) goto L143;
        r4 = "0";
    L143:
        r37[1] = TuplesKt.to("follow_status", r4);
        r36.doEventAction("bubble_area_show", r37);
        goto L150
    L132:
        r28 = null;
        goto L133
    L128:
        r32 = null;
        goto L129
    L121:
        r25 = null;
        goto L122
    L114:
        r31 = null;
        goto L115
    L107:
        r23 = null;
        goto L108
    L145:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleSingleCard");
    L26:
        if (r11 == 2) goto L63;
        if (r11 == 3) goto L38;
        View r40 = new RecyclerView(Y().c());
        r40.setAdapter(new WindowHeadBubbleAdapter());
        r40.setLayoutManager(new LinearLayoutManager(Y().c(), 0, false));
        r40.addItemDecoration(new WindowHeaderBubbleItemPresenter$addMoreThanThreeBubble$1());
        RecyclerView.Adapter r118 = r40.getAdapter();
        if ((r118 instanceof WindowHeadBubbleAdapter) == true) goto L31;
        r118 = null;
    L31:
        WindowHeadBubbleAdapter r119 = (WindowHeadBubbleAdapter) r118;
        if (r119 == null) goto L34;
        Function1<String, Unit> r120 = new WindowHeaderBubbleItemPresenter$addMoreThanThreeBubble$2(this);
        Function2<String, String, Unit> r121 = new WindowHeaderBubbleItemPresenter$addMoreThanThreeBubble$3(this);
        WindowHeaderBubbleItemPresenter$addMoreThanThreeBubble$4 r122 = new WindowHeaderBubbleItemPresenter$addMoreThanThreeBubble$4(this);
        Intrinsics.checkNotNullParameter(r7, "list");
        ((ArrayList) r119.a).clear();
        r119.b = r120;
        r119.c = r121;
        r119.d = r122;
        r119.notifyDataSetChanged();
        ((ArrayList) r119.a).addAll(r7);
        r119.notifyItemRangeInserted(0, r7.size());
    L34:
        LinearLayout r123 = this.k;
        if (r123 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L37:
        LinearLayout.LayoutParams r41 = new LinearLayout.LayoutParams(-1, -2);
        r41.setMargins(com.bytedance.android.shopping.extensions.b.b(12), 0, 0, 0);
        Unit r42 = Unit.INSTANCE;
        r123.addView(r40, r41);
        goto L137
    L38:
        ConstraintLayout r43 = new ConstraintLayout(Y().c());
        r43.setId(2131371274);
        Object r124 = LayoutInflater.from(Y().c()).inflate(2131560994, null, false);
        if (r124 == null) goto L62;
        final ?? r125 = (WindowHeadBubbleBaseCard) r124;
        r125.setId(2131371280);
        uq3.e r126 = (uq3.e) CollectionsKt.getOrNull(r7, 0);
        if (r126 == null) goto L43;
        r125.R5(r126, new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$1(this, r125), new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$2(this, r125), new WindowHeaderBubbleItemPresenter$addTripleBubble$1$3(this), 1);
    L43:
        Object r44 = LayoutInflater.from(Y().c()).inflate(2131560994, null, false);
        if (r44 == null) goto L60;
        final ?? r45 = (WindowHeadBubbleBaseCard) r44;
        r45.setId(2131371288);
        uq3.e r127 = (uq3.e) CollectionsKt.getOrNull(r7, 1);
        if (r127 == null) goto L48;
        r45.R5(r127, new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$3(this, r45), new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$4(this, r45), new WindowHeaderBubbleItemPresenter$addTripleBubble$2$3(this), 2);
    L48:
        Object r128 = LayoutInflater.from(Y().c()).inflate(2131560994, null, false);
        if (r128 == null) goto L58;
        final ?? r129 = (WindowHeadBubbleBaseCard) r128;
        r129.setId(2131371286);
        uq3.e r130 = (uq3.e) CollectionsKt.getOrNull(r7, 2);
        if (r130 == null) goto L53;
        r129.R5(r130, new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$5(this, r129), new WindowHeaderBubbleItemPresenter$addTripleBubble$$inlined$also$lambda$6(this, r129), new WindowHeaderBubbleItemPresenter$addTripleBubble$3$3(this), 3);
    L53:
        int r46 = (com.bytedance.android.ec.window.base.utils.c.a - com.bytedance.android.shopping.extensions.b.b(56)) / 3;
        ConstraintLayout.LayoutParams r131 = new ConstraintLayout.LayoutParams(r46, -2);
        r131.leftToLeft = 2131371274;
        Unit r132 = Unit.INSTANCE;
        r43.addView(r125, r131);
        ConstraintLayout.LayoutParams r133 = new ConstraintLayout.LayoutParams(r46, -2);
        r133.rightToRight = 2131371274;
        r43.addView(r129, r133);
        ConstraintLayout.LayoutParams r134 = new ConstraintLayout.LayoutParams(r46, -2);
        r134.rightToLeft = 2131371286;
        r134.leftToRight = 2131371280;
        r43.addView(r45, r134);
        LinearLayout r47 = this.k;
        if (r47 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L56:
        LinearLayout.LayoutParams r48 = new LinearLayout.LayoutParams(-1, -2);
        r48.setMargins(com.bytedance.android.shopping.extensions.b.b(14), 0, com.bytedance.android.shopping.extensions.b.b(14), 0);
        r47.addView(r43, r48);
        goto L137
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard");
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard");
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard");
    L63:
        LinearLayout r49 = new LinearLayout(Y().c());
        r49.setId(2131371274);
        Object r50 = LayoutInflater.from(Y().c()).inflate(2131560995, null, false);
        if (r50 == null) goto L80;
        final ?? r51 = (WindowHeadBubbleDoubleCard) r50;
        r51.setId(2131371280);
        uq3.e r210 = (uq3.e) CollectionsKt.getOrNull(r7, 0);
        if (r210 == null) goto L68;
        r51.R5(r210, new WindowHeaderBubbleItemPresenter$addDoubleBubble$$inlined$also$lambda$1(this, r51), new WindowHeaderBubbleItemPresenter$addDoubleBubble$$inlined$also$lambda$2(this, r51), new WindowHeaderBubbleItemPresenter$addDoubleBubble$1$3(this), 1);
    L68:
        Object r52 = LayoutInflater.from(Y().c()).inflate(2131560995, null, false);
        if (r52 == null) goto L78;
        final ?? r53 = (WindowHeadBubbleDoubleCard) r52;
        r53.setId(2131371288);
        uq3.e r211 = (uq3.e) CollectionsKt.getOrNull(r7, 1);
        if (r211 == null) goto L73;
        r53.R5(r211, new WindowHeaderBubbleItemPresenter$addDoubleBubble$$inlined$also$lambda$3(this, r53), new WindowHeaderBubbleItemPresenter$addDoubleBubble$$inlined$also$lambda$4(this, r53), new WindowHeaderBubbleItemPresenter$addDoubleBubble$2$3(this), 3);
    L73:
        LinearLayout.LayoutParams r54 = new LinearLayout.LayoutParams(0, -2);
        r54.weight = 1.0f;
        r54.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(9), 0);
        Unit r135 = Unit.INSTANCE;
        r49.addView(r51, r54);
        LinearLayout.LayoutParams r55 = new LinearLayout.LayoutParams(0, -2);
        r55.weight = 1.0f;
        r49.addView(r53, r55);
        LinearLayout r56 = this.k;
        if (r56 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L76:
        LinearLayout.LayoutParams r57 = new LinearLayout.LayoutParams(-1, -2);
        r57.setMargins(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        r56.addView(r49, r57);
        goto L137
    L78:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleDoubleCard");
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleDoubleCard");
    L15:
        if (r8.isEmpty() == true) goto L18;
        r9 = false;
        goto L19
    L151:
        LinearLayout r58 = this.k;
        if (r58 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L154:
        ExtensionsKt.gone(r58);
        Unit r59 = Unit.INSTANCE;
        return;
    L157:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public static final void k0(WindowHeaderBubbleItemPresenter r2, String r3) {
        r2.getClass();
        if (r3 == null) goto L7;
        UrlBuilderV2 r0 = new UrlBuilderV2(r3);
        r0.addOrReplaceParam("meta_info", cd.a.c(r2.d0().getMetaInfoWithoutKolId()));
        r0.addOrReplaceParam("shop_source_data", com.bytedance.android.ec.hybrid.list.util.k.d(r2.d0().getMetaInfo()));
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r2.Y().c(), r0.build());
        return;
    }

    public static final void j0(WindowHeaderBubbleItemPresenter r3, String r4, String r5) {
        ECWindowViewModel r0 = r3.d0();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("bubble_type", r5);
        Integer r6 = r3.d0().getShopParam().getFollowStatus();
        if (r6 == null) goto L5;
        String r7 = String.valueOf(r6.intValue());
    L6:
        r1[1] = TuplesKt.to("follow_status", r7);
        r0.doEventAction(r4, r1);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static final void i0(WindowHeaderBubbleItemPresenter r10, View r11, uq3.e r12, int r13, Function0 r14) {
        r10.getClass();
        Integer r0 = r12.f;
        int r1 = BubbleTypes.BOOK_LIST_BUBBLE.getType();
        if (r0 != null) goto L6;
    L7:
        Integer r2 = r12.f;
        int r3 = BubbleTypes.INVENTORY_LIST_BUBBLE.getType();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.intValue() == r3) goto L14;
        return;
    L14:
        if (((SharedPrefHelper) r10.j.getValue()).f("sp_key_guide_bubble_show", false) == true) goto L20;
        r10.d0().getExtraSchemaClosed().a(r10.e0(), new j(r10, r12, r11, r13, r14), false);
        return;
    L20:
        return;
    L6:
        if (r0.intValue() == r1) goto L14;
        goto L7
    }
}
