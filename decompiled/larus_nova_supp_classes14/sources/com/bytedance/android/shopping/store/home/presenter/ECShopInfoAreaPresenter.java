package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.ec.store.repository.vo.ECTagContainerDTO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.repository.vo.TagContainerUI;
import com.bytedance.android.ec.store.repository.vo.TagListScene;
import com.bytedance.android.ec.store.repository.vo.TagListUI;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ec.store.view.ECTagView;
import com.bytedance.android.shopping.store.home.entity.ECShopSellingPointDTO;
import com.bytedance.android.shopping.store.home.entity.ShopTags;
import com.bytedance.android.shopping.store.home.entity.ShopValueInfoItem;
import com.bytedance.android.shopping.store.home.entity.WelfareCorpLabelDTO;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.home.view.ECStoreExperienceScoreView;
import com.bytedance.android.shopping.store.home.view.ECStoreReputationViewNew;
import com.bytedance.android.shopping.store.home.view.ECStoreXzgLevelView;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopInfoAreaPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopInfoAreaPresenter extends ECShopBasePresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int y = 0;
    public View u;
    public ECTagListView v;
    public Boolean w;
    public final float x;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopInfoAreaPresenter a;

        public b(ECShopInfoAreaPresenter r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r9v39, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        public final void onChanged(Object r42) {
            final com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) r42;
            if (r2 == null) goto L505;
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.T().getStoreParam().getLifecycleMonitorId()));
            if (r1 == null) goto L8;
            r1.t();
        L8:
            com.bytedance.android.shopping.store.home.entity.e r3 = r2.b;
            if (r3 == null) goto L11;
            AuthorReputationVO r4 = r3.d;
        L13:
            if (r3 == null) goto L21;
            com.bytedance.android.shopping.store.home.entity.v r5 = r3.h;
            if (r5 == null) goto L21;
            final ECShopInfoAreaPresenter r7 = this.a;
            String r8 = r5.a();
            String r6 = r5.b();
            r7.w().b(2131371076).f().setOnClickListener(r7);
            ?? r9 = (ECShopMarqueeTextView) r7.w().b(2131371088).f();
            r9.setOnScrollEndAction(new ECShopInfoAreaPresenter$initStoreName$$inlined$apply$lambda$1(r7));
            View r10 = r7.w().b(2131371089).f();
            View r11 = r7.w().b(2131371073).f();
            if (Intrinsics.areEqual(r7.T().getStoreParam().getStoreV3UIParam().getHideDetailEntry(), Boolean.TRUE) == false) goto L19;
            int r12 = 8;
        L20:
            r11.setVisibility(r12);
            ExtensionsKt.visible(r10);
            r9.post(new n0(r9, r10, r8, r6));
            goto L21
        L19:
            r12 = 0;
        L21:
            if (r4 == null) goto L27;
            com.bytedance.android.shopping.store.home.entity.e r13 = r2.b;
            if (r13 == null) goto L25;
            List<? extends ECUrlModel> r14 = r13.i;
        L26:
            r4.setBrandImgList(r14);
            goto L27
        L25:
            r14 = null;
        L27:
            if (r4 == null) goto L33;
            com.bytedance.android.shopping.store.home.entity.e r15 = r2.b;
            if (r15 == null) goto L31;
            String r16 = r15.m;
        L32:
            r4.setShopTypeDescription(r16);
            goto L33
        L31:
            r16 = null;
        L33:
            final ECShopInfoAreaPresenter r17 = this.a;
            String r18 = "normal";
            if (r17.T().getUseNewSign() == false) goto L46;
            ExtensionsKt.gone(r17.w().b(2131371090).f());
            final ECTagListView r19 = r17.v;
            if (r19 == null) goto L45;
            com.bytedance.android.shopping.store.home.entity.e r110 = r2.b;
            if (r110 == null) goto L44;
            ShopTags r111 = r110.r;
            if (r111 == null) goto L44;
            ECTagListDTO r112 = r111.getShortTermIndicators();
            if (r112 == null) goto L44;
            r112.setScene(TagListScene.SHOP_HEADRE_FIRST_LINE_TAG_LIST.getScene());
            Unit r113 = Unit.INSTANCE;
            ECTagListView.c(r19, r112, null, MapsKt.toMutableMap(com.bytedance.android.ec.store.utils.m.b(r17.T().getBaseParams())), new ECShopInfoAreaPresenter$initReputation$$inlined$apply$lambda$1(r19, r17, r2), null, "a1.b6269.c5887.d274671", 18);
        L44:
            r19.setVisibility(0);
        L45:
            Object r20 = "position";
            String r21 = "normal";
        L473:
            ECShopInfoAreaPresenter r22 = this.a;
            View r23 = r22.w().b(2131371070).f();
            r23.setVisibility(0);
            ViewGroup.LayoutParams r24 = r23.getLayoutParams();
            if ((r24 instanceof LinearLayout.LayoutParams) == true) goto L476;
            r24 = null;
        L476:
            LinearLayout.LayoutParams r25 = (LinearLayout.LayoutParams) r24;
            if (r25 == null) goto L479;
            r25.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        L479:
            r23.setLayoutParams(r25);
            r23.setOnClickListener(r22);
            SimpleDraweeView r26 = r22.w().b(2131371066).f();
            com.bytedance.android.shopping.store.home.entity.e r27 = r2.b;
            if (r27 == null) goto L482;
            ECUrlModel r28 = r27.c;
        L483:
            ECShopBasePresenter.Y(r22, r26, r28);
            r22.T().doEventAction("store_bind_author_show", (Pair[]) Arrays.copyOf(h4.a(r22.T(), r21), 8));
            r22.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.d.class), new m0(r22));
            Boolean r29 = this.a.w;
            if (r29 == null) goto L486;
            ECShopInfoAreaPresenter.q0(this.a, r29.booleanValue());
        L486:
            ECShopInfoAreaPresenter r30 = this.a;
            r30.getClass();
            int r31 = com.bytedance.android.shopping.store.home.d0.a;
            Pair[] r32 = com.bytedance.android.shopping.store.home.d0.a(r30.T());
            ECStoreViewModel r33 = r30.T();
            SpreadBuilder r34 = new SpreadBuilder(3);
            r34.add(TuplesKt.to(r20, r21));
            r34.addSpread(r32);
            BtmSDK r35 = BtmSDK.INSTANCE;
            uj3.j r36 = r30.T().getCurrentTab();
            if (r36 != null) goto L489;
        L491:
            com.bytedance.android.btm.api.model.c r37 = new BtmItemBuilder("a1.b6269.c5887.d3193", null, 2, null).withView(r30.y()).build();
        L492:
            r34.add(TuplesKt.to("btm_id", r35.createBtmId(r37)));
            r33.doEventAction("store_experience_score_show", (Pair[]) r34.toArray(new Pair[r34.size()]));
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r38 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r39 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.T().getStoreParam().getLifecycleMonitorId()));
            if (r39 == null) goto L504;
            r39.T();
            return;
        L504:
            return;
        L489:
            if (r36.j() != true) goto L491;
            r37 = new BtmItemBuilder("a1.b0715.c722556", null, 2, null).withView(r30.y()).build();
            goto L492
        L482:
            r28 = null;
            goto L483
        L46:
            ECTagListView r40 = r17.v;
            if (r40 == null) goto L49;
            ExtensionsKt.gone(r40);
        L49:
            com.bytedance.android.shopping.store.home.entity.e r41 = r2.b;
            if (r41 == null) goto L45;
            AuthorReputationVO r114 = r41.d;
            if (r114 == null) goto L45;
            ECStoreReputationViewNew r115 = (ECStoreReputationViewNew) r17.w().b(2131371090).f();
            r115.setCommonEventParams(r17.T().getPageCommonEventParams());
            com.bytedance.android.shopping.store.home.entity.n r43 = (com.bytedance.android.shopping.store.home.entity.n) r17.T().getHeaderArea().getValue();
            if (r43 == null) goto L58;
            com.bytedance.android.shopping.store.home.entity.d r44 = r43.c;
            if (r44 == null) goto L58;
            boolean r45 = r44.e;
        L59:
            com.bytedance.android.shopping.store.home.entity.n r116 = (com.bytedance.android.shopping.store.home.entity.n) r17.T().getHeaderArea().getValue();
            if (r116 == null) goto L64;
            com.bytedance.android.shopping.store.home.entity.e r117 = r116.b;
            if (r117 == null) goto L64;
            boolean r118 = r117.e;
        L65:
            if (r45 == false) goto L68;
            if (r118 == false) goto L68;
            boolean r46 = true;
        L69:
            boolean r119 = !r46;
            ECStoreViewModel r47 = r17.T();
            Intrinsics.checkNotNullParameter(r2, "homeInfo");
            Intrinsics.checkNotNullParameter(r47, "viewModel");
            r115.f = (LinearLayout) r115.findViewById(2131385173);
            r115.b = (TextView) r115.findViewById(2131391346);
            r115.d = (TextView) r115.findViewById(2131391011);
            r115.c = (ImageView) r115.findViewById(2131391347);
            r115.e = (TextView) r115.findViewById(2131391336);
            r115.n = r115.findViewById(2131378840);
            r115.a = (ECDraweeView) r115.findViewById(2131371074);
            r115.g = (ECStoreXzgLevelView) r115.findViewById(2131371209);
            r115.h = (ECStoreExperienceScoreView) r115.findViewById(2131371080);
            r115.i = (TextView) r115.findViewById(2131385886);
            r115.j = r115.findViewById(2131370901);
            r115.k = r115.findViewById(2131370902);
            ((ArrayList) r115.o).clear();
            ((ArrayList) r115.o).add(r115.findViewById(2131387422));
            ((ArrayList) r115.o).add(r115.findViewById(2131387423));
            com.bytedance.android.shopping.store.home.entity.e r48 = r2.b;
            if (r48 == null) goto L72;
            AuthorReputationVO r49 = r48.d;
        L73:
            if (r48 == null) goto L75;
            Integer r50 = r48.k;
        L76:
            if (r50 != null) goto L79;
        L81:
            boolean r51 = false;
        L82:
            r115.m = r51;
            com.bytedance.android.shopping.store.home.entity.d r52 = r2.c;
            if (r52 == null) goto L85;
            boolean r53 = r52.d;
        L86:
            r115.l = r53;
            com.bytedance.android.shopping.store.home.entity.e r54 = r2.b;
            if (r54 == null) goto L89;
            AuthorReputationVO r120 = r54.d;
        L90:
            if (r54 == null) goto L92;
            com.bytedance.android.ec.model.o r55 = r54.j;
        L93:
            if (r55 == null) goto L95;
            boolean r56 = true;
        L96:
            if (r56 == false) goto L99;
            if (r51 == true) goto L99;
            boolean r57 = true;
        L100:
            if (r120 == null) goto L102;
            String r210 = r120.getScoreNormalText();
        L103:
            if (r210 != null) goto L105;
        L108:
            boolean r211 = true;
        L109:
            if (r120 == null) goto L113;
            Double r121 = r120.getScore();
            if (r121 == null) goto L113;
            double r122 = r121.doubleValue();
        L114:
            com.bytedance.android.shopping.store.home.entity.e r58 = r2.b;
            if (r58 == null) goto L119;
            com.bytedance.android.shopping.store.home.entity.s r59 = r58.l;
            if (r59 == null) goto L119;
            com.bytedance.android.shopping.store.home.entity.w r60 = r59.b();
        L120:
            if (r60 == null) goto L127;
            ECShopInfoAreaPresenter r212 = r17;
            if (r122 <= 0) goto L128;
            if (r57 == true) goto L128;
            if (r115.m == true) goto L128;
            boolean r61 = true;
        L129:
            if (r49 == null) goto L131;
            String r62 = r49.getScoreNormalText();
        L132:
            if (r57 == true) goto L136;
            ECStoreXzgLevelView r63 = r115.g;
            if (r63 == null) goto L163;
            r63.setVisibility(8);
        L163:
            r18 = "normal";
            r114 = r114;
        L164:
            if (r56 == true) goto L168;
            TextView r64 = r115.d;
            if (r64 == null) goto L168;
            r64.setText(r62);
        L168:
            if (r61 == false) goto L241;
            ECStoreExperienceScoreView r65 = r115.h;
            if (r65 == null) goto L173;
            r65.setVisibility(0);
        L173:
            if (r115.m == false) goto L240;
            ECStoreExperienceScoreView r66 = r115.h;
            if (r66 == null) goto L240;
            Intrinsics.checkNotNullParameter(r47, "viewModel");
            r66.a.removeAllViews();
            com.bytedance.android.shopping.store.home.entity.e r67 = r2.b;
            if (r67 == null) goto L179;
            AuthorReputationVO r68 = r67.d;
        L180:
            if (r67 == null) goto L184;
            com.bytedance.android.shopping.store.home.entity.s r69 = r67.l;
            if (r69 == null) goto L184;
            com.bytedance.android.shopping.store.home.entity.w r70 = r69.b();
        L185:
            if (r70 == null) goto L187;
            ECUrlModel r123 = r70.b();
        L188:
            if (r70 == null) goto L190;
            ECUrlModel r124 = r70.d();
        L191:
            if (r70 == null) goto L193;
            ECUrlModel r213 = r70.c();
        L194:
            if (r68 == null) goto L198;
            Double r214 = r68.getScore();
            if (r214 == null) goto L198;
            double r71 = r214.doubleValue();
        L199:
            boolean r215 = r56;
            double r310 = ((double) 5) - Math.ceil(r71);
            double r72 = 0;
            if (r71 != r72) goto L202;
            r66.c.setVisibility(8);
            r66.b.setVisibility(8);
            AuthorReputationVO r311 = r49;
        L244:
            com.bytedance.android.shopping.store.home.entity.e r73 = r2.b;
            if (r73 == null) goto L248;
            List<ECShopSellingPointDTO> r74 = r73.n;
            if (r74 == null) goto L248;
        L249:
            com.bytedance.android.shopping.store.home.entity.e r75 = r2.b;
            if (r75 == null) goto L254;
            com.bytedance.android.shopping.store.home.entity.s r76 = r75.l;
            if (r76 == null) goto L254;
            com.bytedance.android.shopping.store.home.entity.x r77 = r76.c();
        L255:
            Intrinsics.checkNotNullParameter(r74, "pointTagList");
            int r78 = RangesKt.coerceAtMost(r74.size(), 2);
            int r79 = 0;
        L256:
            if (r79 >= r78) goto L279;
            ECShopSellingPointDTO r80 = (ECShopSellingPointDTO) ListProtector.get(r74, r79);
            TextView r81 = (TextView) ListProtector.get(r115.o, r79);
            r81.setVisibility(0);
            r81.setPadding(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
            r81.setText(r80.getText());
            int r82 = com.bytedance.android.ec.core.utils.s.a;
            if (r77 == null) goto L260;
            String r83 = r77.c();
        L261:
            Integer r84 = com.bytedance.android.ec.core.utils.s.b(r83);
            if (r84 == null) goto L264;
            r81.setTextColor(r84.intValue());
        L264:
            GradientDrawable r85 = new GradientDrawable();
            if (r77 == null) goto L267;
            String r86 = r77.a();
        L268:
            Integer r87 = com.bytedance.android.ec.core.utils.s.b(r86);
            if (r87 == null) goto L271;
            r85.setColor(r87.intValue());
        L271:
            if (r77 == null) goto L273;
            String r88 = r77.b();
        L274:
            Integer r89 = com.bytedance.android.ec.core.utils.s.b(r88);
            if (r89 == null) goto L278;
            r85.setStroke(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), r89.intValue());
        L278:
            r85.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(3));
            Unit r90 = Unit.INSTANCE;
            ViewCompat.setBackground(r81, r85);
            r79 = r79 + 1;
            goto L256
        L273:
            r88 = null;
            goto L274
        L267:
            r86 = null;
            goto L268
        L260:
            r83 = null;
            goto L261
        L279:
            Map<String, String> r91 = r2.k;
            if (r91 == null) goto L282;
            String r92 = r91.get("is_flagship");
        L282:
            if (r311 == null) goto L284;
            List r93 = r311.getBrandImgList();
        L285:
            if (r93 == null) goto L287;
            ECUrlModel r94 = (ECUrlModel) CollectionsKt.firstOrNull(r93);
        L288:
            if (r94 == null) goto L295;
            GenericDraweeView r95 = r115.a;
            if (r95 == null) goto L292;
            r95.setVisibility(0);
        L292:
            ECDraweeView r96 = r115.a;
            if (r96 == null) goto L299;
            com.bytedance.android.ec.core.imagex.h0 r97 = com.bytedance.android.ec.core.imagex.h0.a;
            com.bytedance.android.shopping.store.tabkit.e.g(r96, r94);
        L299:
            if (r115.m == false) goto L318;
            if (r311 == null) goto L302;
            String r98 = r311.getShopTypeDescription();
        L304:
            if (com.bytedance.android.shopping.extensions.k.c(r98) == false) goto L318;
            if (r311 == null) goto L307;
            String r99 = r311.getShopTypeDescription();
        L308:
            TextView r100 = r115.i;
            if (r100 == null) goto L311;
            r100.setVisibility(0);
        L311:
            TextView r101 = r115.i;
            if (r101 == null) goto L314;
            r101.setText(r99);
        L314:
            TextView r102 = r115.i;
            if (r102 == null) goto L356;
            r102.setTextColor(1946157055);
        L356:
            if (r311 == null) goto L360;
            List r103 = r311.getBrandImgList();
            if (r103 == null) goto L360;
            ECUrlModel r104 = (ECUrlModel) CollectionsKt.firstOrNull(r103);
        L361:
            if (r104 == null) goto L370;
            com.bytedance.android.shopping.store.home.entity.e r105 = r2.b;
            if (r105 == null) goto L367;
            com.bytedance.android.ec.model.o r106 = r105.j;
            if (r106 == null) goto L367;
            ECUrlModel r107 = r106.g();
        L368:
            if (r107 == null) goto L370;
            ((View) ListProtector.get(r115.o, 1)).setVisibility(8);
        L367:
            r107 = null;
        L370:
            com.bytedance.android.shopping.store.home.entity.e r108 = r2.b;
            if (r108 == null) goto L383;
            Map<String, ShopValueInfoItem> r109 = r108.f;
            if (r109 == null) goto L383;
            ShopValueInfoItem r125 = r109.get("sales");
            if (r125 == null) goto L383;
            String r126 = r125.getNumberText();
            if (r126 != null) goto L379;
            r126 = "0";
        L379:
            String r127 = r125.getSuffix();
            if (r127 != null) goto L382;
            r127 = "";
        L382:
            String r128 = r126.concat(r127);
        L384:
            if (r119 == false) goto L396;
            TextView r129 = r115.e;
            if (r129 == null) goto L388;
            r129.setVisibility(0);
        L388:
            String r130 = com.bytedance.android.ec.core.utils.a2.d(r128);
            if (r130 == null) goto L393;
            TextView r131 = r115.e;
            if (r131 == null) goto L399;
            r131.setText(ag4.a.d(2131896869) + r130);
        L399:
            int r132 = 8;
        L401:
            if (r115.l == true) goto L405;
            TextView r133 = r115.e;
            if (r133 == null) goto L414;
            r133.setVisibility(r132);
        L414:
            r115.b(false);
            com.bytedance.android.shopping.store.home.entity.e r134 = r2.b;
            if (r134 == null) goto L417;
            ECTagListDTO r135 = r134.o;
        L419:
            if (r115.m == true) goto L447;
            if (r135 == null) goto L447;
            View r136 = r115.n;
            if (r136 == null) goto L426;
            r136.setVisibility(8);
        L426:
            GenericDraweeView r137 = r115.a;
            if (r137 == null) goto L429;
            r137.setVisibility(8);
        L429:
            ECStoreExperienceScoreView r138 = r115.h;
            if (r138 == null) goto L432;
            r138.setVisibility(8);
        L432:
            ECStoreXzgLevelView r139 = r115.g;
            if (r139 == null) goto L435;
            r139.setVisibility(8);
        L435:
            TextView r140 = r115.d;
            if (r140 == null) goto L438;
            r140.setVisibility(8);
        L438:
            LinearLayout r141 = r115.f;
            if (r141 == null) goto L441;
            r141.setVisibility(8);
        L441:
            r115.a();
            ECTagListView r142 = r115.j;
            if (r142 == null) goto L444;
            r142.setVisibility(0);
        L444:
            ECTagListView r143 = r115.j;
            if (r143 == null) goto L447;
            ECTagListView.c(r143, r135, null, r115.p, null, null, null, 58);
        L447:
            com.bytedance.android.shopping.store.home.entity.e r144 = r2.b;
            if (r144 == null) goto L450;
            WelfareCorpLabelDTO r145 = r144.q;
        L451:
            if (r145 == null) goto L468;
            ECTagListDTO r146 = r145.getWelfareCorpLabelReal();
            if (r146 == null) goto L456;
            boolean r147 = r146.getHasReportShow();
        L457:
            r145.setWelfareCorpLabelReal(r145.getWelfareCorpLabelNormal());
            ECTagListDTO r148 = r145.getWelfareCorpLabelReal();
            if (r148 == null) goto L460;
            r148.setHasReportShow(r147);
        L460:
            ECTagListDTO r149 = r145.getWelfareCorpLabelReal();
            if (r149 == null) goto L468;
            ECTagListView r150 = r115.k;
            if (r150 == null) goto L465;
            r150.setVisibility(0);
        L465:
            ECTagListView r151 = r115.k;
            if (r151 == null) goto L468;
            ECTagListView.c(r151, r149, null, r115.p, null, null, null, 58);
            goto L468
        L456:
            r147 = false;
        L468:
            r115.setVisibility(0);
            ECStoreViewModel r152 = r212.T();
            Pair<String, String>[] r153 = new Pair[3];
            r20 = "position";
            r21 = r18;
            r153[0] = TuplesKt.to(r20, r21);
            r153[1] = TuplesKt.to("subject", "user");
            Double r154 = r114.getScore();
            if (r154 == null) goto L471;
            String r155 = String.valueOf(r154.doubleValue());
        L472:
            r153[2] = TuplesKt.to("score", r155);
            r152.doEventAction("author_sell_score_show", r153);
            goto L473
        L471:
            r155 = null;
            goto L472
        L450:
            r145 = null;
            goto L451
        L417:
            r135 = null;
            goto L419
        L405:
            TextView r156 = r115.e;
            if (r156 == null) goto L414;
            if (r156.getVisibility() != 0) goto L410;
            boolean r157 = true;
        L412:
            if (r157 != true) goto L414;
            r115.a();
            goto L414
        L410:
            r157 = false;
            goto L412
        L393:
            TextView r158 = r115.e;
            if (r158 == null) goto L399;
            r158.setText(ag4.a.d(2131913933));
            goto L399
        L396:
            TextView r159 = r115.e;
            if (r159 == null) goto L399;
            r132 = 8;
            r159.setVisibility(8);
        L383:
            r128 = null;
        L360:
            r104 = null;
            goto L361
        L307:
            r99 = null;
            goto L308
        L302:
            r98 = null;
        L318:
            if (r122 <= 0) goto L337;
            if (r215 == true) goto L337;
            if (r61 == true) goto L337;
            LinearLayout r160 = r115.f;
            if (r160 == null) goto L324;
            r160.setVisibility(0);
        L324:
            TextView r161 = r115.b;
            if (r161 == null) goto L327;
            r161.setVisibility(0);
        L327:
            TextView r162 = r115.d;
            if (r162 == null) goto L330;
            r162.setVisibility(8);
        L330:
            TextView r163 = r115.b;
            if (r163 == null) goto L333;
            StringCompanionObject r164 = StringCompanionObject.INSTANCE;
            int r165 = 0;
            r163.setText(String.format("%.2f ", Arrays.copyOf(new Object[]{Double.valueOf(r122)}, 1)));
        L334:
            ImageView r166 = r115.c;
            if (r166 == null) goto L356;
            r166.setVisibility(r165);
            goto L356
        L333:
            r165 = 0;
        L337:
            LinearLayout r167 = r115.f;
            if (r167 == null) goto L340;
            r167.setVisibility(8);
        L340:
            if (r215 == true) goto L356;
            TextView r168 = r115.b;
            if (r168 == null) goto L344;
            r168.setVisibility(8);
        L344:
            ImageView r169 = r115.c;
            if (r169 == null) goto L347;
            r169.setVisibility(8);
        L347:
            if (r211 == true) goto L353;
            if (r61 == true) goto L353;
            TextView r170 = r115.d;
            if (r170 == null) goto L352;
            r170.setVisibility(0);
        L352:
            r115.a();
        L353:
            TextView r171 = r115.d;
            if (r171 == null) goto L356;
            r171.setVisibility(8);
            goto L356
        L295:
            GenericDraweeView r172 = r115.a;
            if (r172 == null) goto L299;
            r172.setVisibility(8);
            goto L299
        L287:
            r94 = null;
            goto L288
        L284:
            r93 = null;
        L254:
            r77 = null;
        L248:
            r74 = CollectionsKt.emptyList();
            goto L249
        L202:
            double r312 = r71;
            r66.c.setVisibility(0);
            r66.b.setVisibility(0);
            if (r70 == null) goto L211;
            String r173 = r70.a();
            if (r173 == null) goto L211;
            Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L208
            r66.b.setTextColor(Color.parseColor(r173));     // Catch: Throwable -> L208
            Object r175 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L208
        L210:
            Result.box-impl(r175);
        L208:
            th = move-exception;
            Result.Companion r176 = Result.Companion;
            r175 = Result.constructor-impl(ResultKt.createFailure(th));
        L211:
            double r177 = r312;
            int r178 = 1;
            AuthorReputationVO r313 = r68;
            r311 = r49;
        L212:
            double r179 = r178;
            double r314 = r177 - r179;
            if (r314 <= r72) goto L216;
            r66.a.addView(r66.a(r123, r47));
            r177 = r314;
            r178 = 1;
            goto L212
        L216:
            if (r177 >= 0.5d) goto L218;
            ECUrlModel r180 = r213;
            r66.a.addView(r66.a(r180, r47));
        L223:
            if (r310 <= r72) goto L225;
            r66.a.addView(r66.a(r180, r47));
            r310 = r310 - r179;
            goto L223
        L225:
            TextView r181 = r66.b;
            StringCompanionObject r182 = StringCompanionObject.INSTANCE;
            Object[] r183 = new Object[1];
            if (r313 == null) goto L230;
            Double r184 = r313.getScore();
            if (r184 == null) goto L230;
            r72 = r184.doubleValue();
        L230:
            r183[0] = Double.valueOf(r72);
            r181.setText(String.format("%.2f", Arrays.copyOf(r183, 1)));
            com.bytedance.android.shopping.store.home.entity.e r185 = r2.b;
            if (r185 == null) goto L233;
            Integer r186 = r185.k;
        L234:
            if (r186 != null) goto L237;
        L239:
            r66.c.setImageResource(2131234840);
            goto L244
        L237:
            if (r186.intValue() != 1) goto L239;
            r66.c.setImageResource(2131234793);
            goto L244
        L233:
            r186 = null;
            goto L234
        L218:
            r180 = r213;
            if (r177 != 1.0d) goto L221;
            r66.a.addView(r66.a(r123, r47));
            goto L223
        L221:
            r66.a.addView(r66.a(r124, r47));
        L198:
            r71 = 0;
            goto L199
        L193:
            r213 = null;
            goto L194
        L190:
            r124 = null;
            goto L191
        L187:
            r123 = null;
        L184:
            r70 = null;
            goto L185
        L179:
            r68 = null;
        L240:
            r311 = r49;
            r215 = r56;
            r122 = r122;
            goto L244
        L241:
            r311 = r49;
            r215 = r56;
            r122 = r122;
            ECStoreExperienceScoreView r187 = r115.h;
            if (r187 == null) goto L244;
            r187.setVisibility(8);
            goto L244
        L136:
            com.bytedance.android.shopping.store.home.entity.e r188 = r2.b;
            if (r188 == null) goto L163;
            com.bytedance.android.ec.model.o r189 = r188.j;
            if (r189 == null) goto L163;
            ECStoreXzgLevelView r190 = r115.g;
            if (r190 == null) goto L159;
            Intrinsics.checkNotNullParameter(r189, "shopXzgInfo");
            r190.c.removeAllViews();
            r190.d.removeAllViews();
            r190.f = r189;
            Integer r191 = r189.f();
            if (r191 == null) goto L145;
            int r192 = r191.intValue();
        L146:
            if (r192 != 0) goto L152;
            String r193 = r189.a();
            if (r193 == null) goto L151;
            r190.c.addView(r190.e);
            r190.e.setText(r193);
        L151:
            com.bytedance.android.ec.core.utils.y.a(r190.a, r189.g());
            com.bytedance.android.ec.core.utils.y.a(r190.b, r189.c());
        L158:
            r190.a(false);
            r190.addOnLayoutChangeListener(new com.bytedance.android.shopping.store.home.view.r(r190));
        L160:
            ECStoreXzgLevelView r194 = r115.g;
            if (r194 == null) goto L164;
            int r195 = com.bytedance.android.shopping.extensions.b.b(28);
            int r196 = com.bytedance.android.shopping.extensions.b.b(58);
            boolean r197 = r115.l;
            r194.h = r195;
            r194.i = r196;
            r194.l = r197;
            goto L164
        L152:
            r18 = "normal";
            r114 = r114;
            com.bytedance.android.ec.core.utils.y.a(r190.a, r189.g());
            com.bytedance.android.ec.core.utils.y.a(r190.b, r189.g());
            com.bytedance.android.ec.model.o r198 = r190.f;
            if (r198 == null) goto L157;
            Integer r199 = r198.f();
            if (r199 == null) goto L157;
            r199.intValue();
        L157:
            r190.c.removeAllViews();
            r190.d.removeAllViews();
            goto L158
        L145:
            r192 = 0;
            goto L146
        L159:
            r18 = "normal";
            r114 = r114;
            goto L160
        L131:
            r62 = null;
        L128:
            r61 = false;
            goto L129
        L127:
            r212 = r17;
        L119:
            r60 = null;
        L113:
            r122 = 0;
            goto L114
        L105:
            if (r210.length() == 0) goto L108;
            r211 = false;
            goto L109
        L102:
            r210 = null;
        L99:
            r57 = false;
            goto L100
        L95:
            r56 = false;
            goto L96
        L92:
            r55 = null;
            goto L93
        L89:
            r120 = null;
            goto L90
        L85:
            r53 = false;
            goto L86
        L79:
            if (r50.intValue() != 2) goto L81;
            r51 = true;
            goto L82
        L75:
            r50 = null;
            goto L76
        L72:
            r49 = null;
        L68:
            r46 = false;
        L64:
            r118 = true;
        L58:
            r45 = false;
            goto L59
        L11:
            r4 = null;
            goto L13
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopInfoAreaPresenter a;

        public c(ECShopInfoAreaPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Pair r8 = (Pair) r7;
            boolean r9 = this.a.i0();
            boolean r1 = true;
            if ((!Intrinsics.areEqual(Boolean.valueOf(r9), this.a.w)) == false) goto L23;
            this.a.w = Boolean.valueOf(r9);
            ECShopInfoAreaPresenter.q0(this.a, r9);
            if (this.a.U() == false) goto L7;
            int r10 = (int) 4279638051L;
        L9:
            if (Intrinsics.areEqual(this.a.T().isFlagShip(), Boolean.TRUE) == false) goto L11;
            r10 = (int) 4279638051L;
        L11:
            this.a.t0(r10);
            ECStoreReputationViewNew r0 = (ECStoreReputationViewNew) this.a.w().b(2131371090).f();
            if (this.a.U() == false) goto L14;
            float r3 = 1.0f;
        L15:
            r0.setXzgViewCollapse(r3);
            TextView r4 = r0.d;
            if (r4 == null) goto L19;
            r4.setTextColor(r10);
        L19:
            if (this.a.U() == false) goto L21;
            float r11 = 1.0f;
        L22:
            r0.setCollapse(r11);
            goto L23
        L21:
            r11 = this.a.Z();
            goto L22
        L14:
            r3 = this.a.Z();
            goto L15
        L7:
            r10 = ColorUtils.blendARGB(-1, (int) 4279638051L, this.a.Z());
        L23:
            ECShopInfoAreaPresenter r12 = this.a;
            boolean r2 = r12.i0();
            if (r12.U() == false) goto L26;
        L29:
            float r5 = r12.a0(0.5f);
            if (r2 == false) goto L32;
            Drawable r6 = null;
        L35:
            View r13 = r12.u;
            if (r13 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("infoArea");
        L38:
            qc3.a.e(r13, r6);
            return;
        L32:
            if (r1 == false) goto L34;
            float r14 = (1.0f - r5) * 12.0f;
            GradientDrawable r15 = new GradientDrawable();
            r15.setColor(0);
            r15.setCornerRadii(qc3.a.b(r14, r14, 0.0f, 0.0f));
            r6 = r15;
            goto L35
        L34:
            r6 = new ColorDrawable(0);
            goto L35
        L26:
            if (r12.E() == true) goto L29;
            r1 = false;
            goto L29
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopInfoAreaPresenter a;

        public d(ECShopInfoAreaPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            Float r1 = (Float) r20;
            ECShopInfoAreaPresenter r2 = this.a;
            View r3 = r2.u;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("infoArea");
        L5:
            Drawable r4 = r3.getBackground();
            if ((r4 instanceof GradientDrawable) == true) goto L8;
            r4 = null;
        L8:
            GradientDrawable r5 = (GradientDrawable) r4;
            if (r5 == null) goto L11;
            float r6 = (1.0f - r2.a0(0.5f)) * r2.x;
            r5.setCornerRadii(qc3.a.b(r6, r6, 0.0f, 0.0f));
        L11:
            float r7 = r2.b0();
            if (r2.U() == true) goto L14;
            int r8 = ColorUtils.blendARGB(-1, (int) 4279638051L, r7);
        L16:
            if (Intrinsics.areEqual(r2.T().isFlagShip(), Boolean.TRUE) == false) goto L18;
            r8 = (int) 4279638051L;
        L18:
            r2.t0(r8);
            ECStoreReputationViewNew r9 = (ECStoreReputationViewNew) r2.w().b(2131371090).f();
            TextView r10 = r9.d;
            if (r10 == null) goto L22;
            r10.setTextColor(r8);
        L22:
            if (r2.U() == false) goto L24;
            float r11 = 1.0f;
        L25:
            r9.setXzgViewCollapse(r11);
            if (r2.U() == false) goto L28;
            float r12 = 1.0f;
        L29:
            int r13 = ColorUtils.blendARGB((int) 4294967295L, (int) 4293103442L, r12);
            int r14 = ColorUtils.blendARGB(520093696, (int) 4294833649L, r12);
            int r15 = ColorUtils.blendARGB(872410081, (int) 4294958540L, r12);
            Iterator r16 = ((ArrayList) r9.o).iterator();
        L31:
            if (r16.hasNext() == false) goto L39;
            TextView r17 = (TextView) r16.next();
            Drawable r18 = r17.getBackground();
            if ((r18 instanceof GradientDrawable) == true) goto L35;
            r18 = null;
        L35:
            GradientDrawable r19 = (GradientDrawable) r18;
            if (r19 == null) goto L31;
            r19.setColor(r14);
            r19.setStroke(RangesKt.coerceAtLeast(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), 1), r15);
            r17.setTextColor(r13);
            goto L31
        L39:
            if ((!Intrinsics.areEqual(r2.T().isFlagShip(), Boolean.TRUE)) == false) goto L179;
            com.bytedance.android.shopping.store.home.entity.n r21 = (com.bytedance.android.shopping.store.home.entity.n) r2.T().getHeaderArea().getValue();
            if (r21 == null) goto L45;
            com.bytedance.android.shopping.store.home.entity.e r22 = r21.b;
            if (r22 == null) goto L45;
            WelfareCorpLabelDTO r23 = r22.q;
        L47:
            if (r2.U() == false) goto L49;
            float r24 = 1.0f;
        L50:
            if (r23 == null) goto L179;
            r23.setWelfareCorpLabelReal(r23.getWelfareCorpLabelLiving());
            ECTagListDTO r25 = r23.getWelfareCorpLabelReal();
            if (r25 == null) goto L179;
            r25.setUpdateColor(r23.getWelfareCorpLabelNormal(), r24);
            ECTagListView r26 = r9.k;
            if (r26 == null) goto L179;
            Intrinsics.checkNotNullParameter(r25, "tagListVO");
            TagListUI r27 = r25.getTagListUI();
            int r110 = com.bytedance.android.ec.core.utils.s.a;
            if (r27 == null) goto L59;
            String r111 = r27.getBgColor();
        L60:
            Integer r112 = com.bytedance.android.ec.core.utils.s.b(r111);
            if (r112 == null) goto L63;
            int r113 = r112.intValue();
        L64:
            if (r27 == null) goto L66;
            String r114 = r27.getEndBgColor();
        L67:
            Integer r115 = com.bytedance.android.ec.core.utils.s.b(r114);
            if (r115 == null) goto L70;
            int r116 = r115.intValue();
        L71:
            if (r27 == null) goto L73;
            float r117 = r27.getColorFactor();
        L74:
            int r118 = ColorUtils.blendARGB(r113, r116, r117);
            if (r27 == null) goto L77;
            String r119 = r27.getBorderColor();
        L78:
            Integer r120 = com.bytedance.android.ec.core.utils.s.b(r119);
            if (r120 == null) goto L81;
            int r121 = r120.intValue();
        L82:
            if (r27 == null) goto L84;
            String r122 = r27.getEndBorderColor();
        L85:
            Integer r123 = com.bytedance.android.ec.core.utils.s.b(r122);
            if (r123 == null) goto L88;
            int r124 = r123.intValue();
        L89:
            if (r27 == null) goto L91;
            float r125 = r27.getColorFactor();
        L92:
            int r126 = ColorUtils.blendARGB(r121, r124, r125);
            Drawable r127 = r26.getBackground();
            if ((r127 instanceof GradientDrawable) == true) goto L95;
            r127 = null;
        L95:
            GradientDrawable r128 = (GradientDrawable) r127;
            if (r128 == null) goto L102;
            r128.setColor(r118);
            if (r27 == null) goto L100;
            int r28 = com.bytedance.android.ec.store.common.uiext.ExtensionsKt.a(Double.valueOf(r27.getBorderWidth()));
        L101:
            r128.setStroke(r28, r126);
            int r29 = qc3.a.a;
            Intrinsics.checkNotNullParameter(r26, "$this$setBackgroundCompat");
            r26.setBackground(r128);
            goto L102
        L100:
            r28 = 0;
        L102:
            Iterator r30 = com.bytedance.commerce.base.view.b.a(r26).iterator();
            int r31 = 0;
        L104:
            if (r30.hasNext() == false) goto L179;
            ECTagView r129 = (View) r30.next();
            if ((r129 instanceof ECTagView) == false) goto L104;
            List r130 = r25.getTagContainers();
            if (r130 == null) goto L110;
            int r131 = r130.size();
        L111:
            if (r31 >= r131) goto L179;
            ECTagView r132 = r129;
            List r133 = r25.getTagContainers();
            if (r133 == null) goto L115;
            ECTagContainerDTO r134 = (ECTagContainerDTO) CollectionsKt.getOrNull(r133, r31);
        L116:
            r132.getClass();
            if (r134 == null) goto L178;
            TagContainerUI r135 = r134.getTagContainerUI();
            if (r135 == null) goto L144;
            int r136 = com.bytedance.android.ec.core.utils.s.a;
            Integer r137 = com.bytedance.android.ec.core.utils.s.b(r135.getBgColor());
            if (r137 == null) goto L125;
            int r32 = r137.intValue();
        L126:
            Integer r138 = com.bytedance.android.ec.core.utils.s.b(r135.getEndBgColor());
            if (r138 == null) goto L129;
            int r33 = r138.intValue();
        L130:
            int r34 = ColorUtils.blendARGB(r32, r33, r135.getColorFactor());
            Integer r35 = com.bytedance.android.ec.core.utils.s.b(r135.getBorderColor());
            if (r35 == null) goto L133;
            int r36 = r35.intValue();
        L134:
            Integer r139 = com.bytedance.android.ec.core.utils.s.b(r135.getBorderColor());
            if (r139 == null) goto L137;
            int r140 = r139.intValue();
        L138:
            int r37 = ColorUtils.blendARGB(r36, r140, r135.getColorFactor());
            Drawable r141 = r132.getBackground();
            if ((r141 instanceof GradientDrawable) == true) goto L141;
            r141 = null;
        L141:
            GradientDrawable r142 = (GradientDrawable) r141;
            if (r142 == null) goto L144;
            r142.setColor(r34);
            r142.setStroke(com.bytedance.android.ec.store.common.uiext.ExtensionsKt.a(Double.valueOf(r135.getBorderWidth())), r37);
            int r38 = qc3.a.a;
            Intrinsics.checkNotNullParameter(r132, "$this$setBackgroundCompat");
            r132.setBackground(r142);
            goto L144
        L137:
            r140 = 16777215;
            goto L138
        L133:
            r36 = 16777215;
            goto L134
        L129:
            r33 = 16777215;
            goto L130
        L125:
            r32 = 16777215;
        L144:
            int r39 = r132.getChildCount();
            int r40 = 0;
        L145:
            if (r40 >= r39) goto L178;
            View r143 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r132), r40);
            if ((r143 instanceof TextView) == false) goto L176;
            List r144 = r134.getSubTagList();
            if (r144 == null) goto L151;
            int r145 = r144.size();
        L152:
            if (r40 >= r145) goto L178;
            TextView r146 = (TextView) r143;
            List r147 = r134.getSubTagList();
            if (r147 == null) goto L156;
            com.bytedance.android.ec.store.repository.vo.s r148 = (com.bytedance.android.ec.store.repository.vo.s) CollectionsKt.getOrNull(r147, r40);
        L157:
            if (r148 == null) goto L176;
            int r149 = com.bytedance.android.ec.core.utils.s.a;
            Integer r150 = com.bytedance.android.ec.core.utils.s.b(r148.n().h());
            if (r150 == null) goto L162;
            int r151 = r150.intValue();
        L163:
            Integer r41 = com.bytedance.android.ec.core.utils.s.b(r148.n().a);
            if (r41 == null) goto L166;
            int r42 = r41.intValue();
        L167:
            int r43 = ColorUtils.blendARGB(r151, r42, r148.n().c);
            Integer r44 = com.bytedance.android.ec.core.utils.s.b(r148.n().a());
            if (r44 == null) goto L170;
            int r45 = r44.intValue();
        L171:
            Integer r152 = com.bytedance.android.ec.core.utils.s.b(r148.n().b);
            if (r152 == null) goto L174;
            int r153 = r152.intValue();
        L175:
            int r46 = ColorUtils.blendARGB(r45, r153, r148.n().c);
            r146.setTextColor(r43);
            r146.setBackgroundColor(r46);
        L177:
            r40 = r40 + 1;
            r7 = r7;
            goto L145
        L174:
            r153 = 16777215;
            goto L175
        L170:
            r45 = 16777215;
            goto L171
        L166:
            r42 = 16777215;
            goto L167
        L162:
            r151 = 16777215;
            goto L163
        L156:
            r148 = null;
            goto L157
        L151:
            r145 = 0;
        L176:
            r7 = r7;
        L178:
            r31 = r31 + 1;
            r7 = r7;
            goto L104
        L115:
            r134 = null;
            goto L116
        L110:
            r131 = 0;
            goto L111
        L91:
            r125 = 0.0f;
            goto L92
        L88:
            r124 = 16777215;
            goto L89
        L84:
            r122 = null;
            goto L85
        L81:
            r121 = 16777215;
            goto L82
        L77:
            r119 = null;
            goto L78
        L73:
            r117 = 0.0f;
            goto L74
        L70:
            r116 = 16777215;
            goto L71
        L66:
            r114 = null;
            goto L67
        L63:
            r113 = 16777215;
            goto L64
        L59:
            r111 = null;
            goto L60
        L49:
            r24 = r7;
        L45:
            r23 = null;
        L179:
            float r154 = r7;
            if (r2.U() == false) goto L182;
            float r47 = 1.0f;
        L183:
            r9.setCollapse(r47);
            if (this.a.T().getUseNewSign() == false) goto L208;
            ECShopInfoAreaPresenter r48 = this.a;
            ECTagListView r49 = r48.v;
            if (r49 != null) goto L188;
            return;
        L188:
            if (r48.U() == false) goto L190;
            float r50 = 0.0f;
        L191:
            r49.k(r50);
            return;
        L190:
            r50 = 1.0f - r48.b0();
            goto L191
        L208:
            return;
        L182:
            r47 = r154;
            goto L183
        L28:
            r12 = r7;
            goto L29
        L24:
            r11 = r7;
            goto L25
        L14:
            r8 = (int) 4279638051L;
            goto L16
        }
    }

    static {
    }

    public ECShopInfoAreaPresenter() {
        super(null);
        this.x = 12.0f;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    public final void A(QModel r5) {
        W().getLifecycle().addObserver(this);
        this.u = y();
        this.v = w().b(2131371096).f();
        View r6 = w().b(2131371076).f();
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L8;
        int r2 = com.bytedance.android.shopping.extensions.b.b(8);
        r1.rightMargin = r2;
        r1.setMarginEnd(r2);
    L8:
        r6.requestLayout();
        T().getHeaderArea().a(W(), new b(this), false);
        View r7 = this.u;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("infoArea");
    L12:
        if (U() == false) goto L14;
        GradientDrawable r3 = new GradientDrawable();
        r3.setColor(0);
        float r4 = this.x;
        r3.setCornerRadii(qc3.a.b(r4, r4, 0.0f, 0.0f));
        Unit r8 = Unit.INSTANCE;
        Drawable r9 = r3;
    L15:
        qc3.a.e(r7, r9);
        T().getSelectedTabLocation().d(W(), new c(this));
        T().getCollapseFactor().a(W(), new d(this), false);
        return;
    L14:
        r9 = new ColorDrawable(0);
        goto L15
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r5.getId()) == false) goto L5;
        return;
    L5:
        if (T().getStoreParam().isPreview() == true) goto L36;
        int r1 = r5.getId();
        if (r1 != 2131371076) goto L11;
        r0(r5);
        return;
    L11:
        if (r1 != 2131371070) goto L34;
        com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r2 == null) goto L19;
        com.bytedance.android.shopping.store.home.entity.d r3 = r2.c;
        if (r3 == null) goto L19;
        if (r3.d != true) goto L19;
        r0(r5);
        return;
    L19:
        String r6 = T().getStoreParam().getStoreHomePageUrl();
        if (r6 == null) goto L30;
        boolean r4 = ECServiceManager.a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).Z() == false) goto L24;
        r6 = UriProtector.parse(r6).buildUpon().appendQueryParameter("TPSA_version", CommentScene.COMMENTSCENE_NO_AWEME).appendQueryParameter("TPSA_biz_scene", "ecom_products_page").build().toString();
    L24:
        com.bytedance.android.ec.sdk.helper.p r7 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r8 = u();
        Context r9 = com.bytedance.android.ec.core.utils.l0.c(r8.c());
        if ((r9 instanceof FragmentActivity) == true) goto L27;
        r9 = null;
    L27:
        if (r9 != null) goto L29;
        r9 = r8.a();
    L29:
        r7.openSchema(r9, r6);
    L30:
        T().doEventAction("store_bind_author_click", (Pair[]) Arrays.copyOf(h4.a(T(), "normal"), 8));
        s0("103");
        return;
    L34:
        return;
    }

    public final void r0(View r5) {
        if (Intrinsics.areEqual(T().getStoreParam().getStoreV3UIParam().getHideDetailEntry(), Boolean.TRUE) == false) goto L5;
        return;
    L5:
        String r0 = T().getStoreParam().getStoreDetailUrl();
        if (r0 == null) goto L18;
        uj3.j r1 = T().getCurrentTab();
        if (r1 != null) goto L10;
    L12:
        String r2 = "a1.b6269.c5887.d3193";
    L13:
        int r3 = com.bytedance.android.ec.store.utils.b.a;
        String r4 = com.bytedance.android.ec.store.utils.b.b(r0, r2, PageFinder.via(this.h), null);
        if (r4 != null) goto L16;
        return;
    L16:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(u().c(), r4);
        goto L18
    L10:
        if (r1.j() != true) goto L12;
        r2 = "a1.b0715.c722556";
    L18:
        if (r5.getId() != 2131371076) goto L20;
        String r6 = "105";
    L21:
        s0(r6);
        return;
    L20:
        r6 = "";
        goto L21
    }

    public final void s0(String r5) {
        ECStoreViewModel r0 = T();
        SpreadBuilder r1 = new SpreadBuilder(3);
        r1.add(TuplesKt.to("position", "normal"));
        int r2 = com.bytedance.android.shopping.store.home.d0.a;
        r1.addSpread(com.bytedance.android.shopping.store.home.d0.a(T()));
        r1.add(TuplesKt.to("click_area", r5));
        r0.doEventAction("store_experience_score_click", (Pair[]) r1.toArray(new Pair[r1.size()]));
    }

    public final void t0(int r3) {
        ImageView r0 = (ImageView) w().b(2131371073).f();
        r0.setColorFilter(r3);
        r0.setAlpha(1.0f);
        ((ECShopMarqueeTextView) w().b(2131371088).f()).setTextColor(r3);
    }

    public static final void q0(ECShopInfoAreaPresenter r4, boolean r5) {
        ((ECShopMarqueeTextView) r4.w().b(2131371088).f()).setTextColor((int) 4279638051L);
        ImageView r0 = (ImageView) r4.w().b(2131371073).f();
        r0.setColorFilter(null);
        r0.setAlpha(0.9f);
        SimpleDraweeView r1 = r4.w().b(2131371067).f();
        GenericDraweeHierarchy r2 = r1.getHierarchy();
        RoundingParams r3 = r1.getHierarchy().getRoundingParams();
        if (r5 == true) goto L5;
    L9:
        if (r3 != null) goto L11;
        r3 = new RoundingParams();
    L11:
        RoundingParams r6 = r3.setBorderColor(219551779);
    L12:
        r2.setRoundingParams(r6);
        ((ECStoreReputationViewNew) r4.w().b(2131371090).f()).b(r5);
        return;
    L5:
        if ((!Intrinsics.areEqual(r4.T().isFlagShip(), Boolean.TRUE)) == false) goto L9;
        if (r3 != null) goto L8;
        r3 = new RoundingParams();
    L8:
        r6 = r3.setBorderColor(-1);
        goto L12
    }
}
