package com.bytedance.android.shopping.store.moments.module.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.common.datachannel.ECSShopSourceMethod;
import com.bytedance.android.ec.store.common.datachannel.ECShopStoreType;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.utils.SoundState;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.moments.dto.card.ShortVideoDTO;
import com.bytedance.android.shopping.store.moments.holder.ECStoreShortVideoViewHolderNew;
import com.bytedance.android.shopping.store.moments.viewmodel.ECStoreMomentViewModel;
import com.bytedance.android.shopping.store.moments.vo.Aweme;
import com.bytedance.android.shopping.store.moments.vo.Video;
import com.bytedance.android.shopping.store.moments.widget.ECShortVideoExpandableTextView;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import com.bytedance.android.ui.base.widget.round.RoundRelativeLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.GenericDraweeView;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import im.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/module/presenter/ECStoreShortVideoPresenterNew;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/bytedance/android/ec/hybrid/list/holder/IHybridListViewHolder;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View$OnClickListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreShortVideoPresenterNew extends QFragmentPresenter implements IHybridListViewHolder, LifecycleObserver, View.OnClickListener {
    public final ECStoreViewModel A;
    public final ECStoreShortVideoViewHolderNew B;
    public final Lazy f;
    public final s83.f g;
    public RoundLinearLayout h;
    public RoundRelativeLayout i;
    public ECDraweeView j;
    public ViewGroup k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public ECShortVideoExpandableTextView o;
    public RoundRelativeLayout p;
    public TextView q;
    public TextView r;
    public PriceView s;
    public ECDraweeView t;
    public Aweme u;
    public ShortVideoDTO v;
    public StoreV2ProductItemVO w;
    public String x;
    public final String y;
    public final QLiveData<Boolean> z;

    public final boolean C3() {
        return false;
    }

    public final void D() {
        e0(false);
    }

    public final void K() {
    }

    public final void g1(int r1, int r2, double r3) {
    }

    public final ECStoreMomentViewModel i0() {
        return (ECStoreMomentViewModel) this.f.getValue();
    }

    public final void m1(int r1, double r2) {
    }

    public final void onHide() {
        e0(false);
    }

    public final void onShow() {
    }

    public final void o() {
        s83.f r0 = this.g;
        if (r0 == null) goto L5;
        r0.g(this.y);
    L5:
        ViewGroup r1 = this.k;
        if (r1 == null) goto L11;
        s83.f r2 = this.g;
        if (r2 == null) goto L11;
        r2.p(this.y, r1);
    L11:
        if (Intrinsics.areEqual(i0().getPlayVideoId(), this.x) == false) goto L13;
        i0().setPlayVideoId("");
    L13:
        ViewGroup r3 = this.k;
        if (r3 == null) goto L16;
        r3.removeAllViews();
    L16:
        GenericDraweeView r4 = this.j;
        if (r4 == null) goto L20;
        r4.setVisibility(0);
        return;
    }

    public final void onRelease() {
        s83.f r0 = this.g;
        if (r0 == null) goto L5;
        r0.g(this.y);
    L5:
        ViewGroup r1 = this.k;
        if (r1 == null) goto L10;
        s83.f r2 = this.g;
        if (r2 == null) goto L10;
        r2.p(this.y, r1);
    L10:
        ViewGroup r3 = this.k;
        if (r3 == null) goto L14;
        r3.removeAllViews();
        return;
    }

    public static int h0(Number r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$nrpx");
        if (ECStoreFoldPhoneHelper.d() == true) goto L7;
        float r4 = r3.floatValue();
        float r0 = k1.l();
        Resources r1 = Resources.getSystem();
        r3 = Float.valueOf((r4 * (r0 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density)) / 375);
    L7:
        return com.bytedance.android.shopping.extensions.b.b(r3);
    }

    public final void D1(Long r2) {
        this.z.g(Boolean.TRUE);
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    public final void b0(QModel r20) {
        QModel r1 = r20;
        com.bytedance.android.bst.api.b r3 = null;
        if ((r1 instanceof ShortVideoDTO) == true) goto L5;
        r1 = null;
    L5:
        ShortVideoDTO r2 = (ShortVideoDTO) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        this.v = r2;
        this.h = (RoundLinearLayout) Z().b(2131386278).f();
        this.n = (TextView) Z().b(2131370996).f();
        this.i = (RoundRelativeLayout) Z().b(2131370997).f();
        ?? r4 = (ECDraweeView) Z().b(2131370998).f();
        this.j = r4;
        r4.setVisibility(0);
        this.k = (ViewGroup) Z().b(2131370999).f();
        this.l = (ImageView) Z().b(2131370988).f();
        ImageView r5 = (ImageView) Z().b(2131370989).f();
        this.m = r5;
        r5.setVisibility(8);
        this.o = (ECShortVideoExpandableTextView) Z().b(2131370995).f();
        this.p = (RoundRelativeLayout) Z().b(2131370990).f();
        this.q = (TextView) Z().b(2131370994).f();
        this.s = Z().b(2131370993).f();
        this.r = (TextView) Z().b(2131370992).f();
        this.t = (ECDraweeView) Z().b(2131370991).f();
        RoundLinearLayout r6 = this.h;
        if (r6 == null) goto L11;
        qc3.a.h(r6, h0(8), h0(8), h0(8), h0(8), false);
    L11:
        RoundLinearLayout r7 = this.h;
        if (r7 == null) goto L14;
        r7.setPadding(h0(12), h0(12), h0(12), h0(12));
    L14:
        TextView r8 = this.n;
        if (r8 == null) goto L17;
        r8.setTextSize(0, h0(14));
    L17:
        TextView r9 = this.n;
        if (r9 == null) goto L20;
        r9.setBottom(h0(8));
    L20:
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L25;
        TextView r11 = this.n;
        if (r11 == null) goto L25;
        r11.setLineHeight(h0(20));
    L25:
        RoundRelativeLayout r13 = this.i;
        if (r13 == null) goto L28;
        qc3.a.h(r13, h0(8), h0(8), h0(8), h0(8), false);
    L28:
        RoundRelativeLayout r12 = this.i;
        if (r12 == null) goto L33;
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (r14 == null) goto L33;
        r14.height = h0(436);
    L33:
        RoundRelativeLayout r15 = this.p;
        if (r15 == null) goto L36;
        qc3.a.h(r15, h0(6), h0(6), h0(6), h0(6), false);
    L36:
        RoundRelativeLayout r16 = this.p;
        if (r16 == null) goto L39;
        wg.a.f(r16, 0, h0(12), 0, 0);
    L39:
        RoundRelativeLayout r17 = this.p;
        if (r17 == null) goto L44;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L44;
        r18.height = h0(53);
    L44:
        TextView r19 = this.q;
        if (r19 == null) goto L47;
        r19.setTextSize(0, h0(12));
    L47:
        TextView r21 = this.q;
        if (r21 == null) goto L52;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L52;
        r22.width = h0(26);
    L52:
        if (r10 < 28) goto L56;
        TextView r23 = this.q;
        if (r23 == null) goto L56;
        r23.setLineHeight(h0(14));
    L56:
        GenericDraweeView r24 = this.t;
        if (r24 == null) goto L61;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if (r25 == null) goto L61;
        r25.width = h0(48);
    L61:
        GenericDraweeView r26 = this.t;
        if (r26 == null) goto L66;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L66;
        r27.height = h0(48);
    L66:
        TextView r28 = this.r;
        if (r28 == null) goto L69;
        r28.setTextSize(0, h0(12));
    L69:
        PriceView r29 = this.s;
        if (r29 == null) goto L72;
        r29.setTextSize(0, h0(12));
    L72:
        AppCompatTextView r30 = this.o;
        if (r30 == null) goto L75;
        wg.a.f(r30, 0, h0(12), 0, 0);
    L75:
        ECShortVideoExpandableTextView r31 = this.o;
        if (r31 == null) goto L78;
        r31.setTextSize(0, h0(14));
    L78:
        if (r10 < 28) goto L82;
        ECShortVideoExpandableTextView r32 = this.o;
        if (r32 == null) goto L82;
        r32.setLineHeight(h0(20));
    L82:
        ImageView r33 = this.m;
        if (r33 == null) goto L85;
        r33.setOnClickListener(this);
    L85:
        ImageView r34 = this.l;
        if (r34 == null) goto L88;
        r34.setOnClickListener(this);
    L88:
        RoundRelativeLayout r35 = this.p;
        if (r35 == null) goto L91;
        r35.setOnClickListener(this);
    L91:
        RoundRelativeLayout r36 = this.i;
        if (r36 == null) goto L94;
        r36.setOnClickListener(this);
    L94:
        i0().isMute().observe(ECQuickUtilKt.a(Y()), new l(this));
        this.z.b(ECQuickUtilKt.a(Y()), new m(this));
        this.z.g(Boolean.FALSE);
        this.A.setCurrentPlaySession(this.y);
        ECQuickUtilKt.a(Y()).getLifecycle().addObserver(this);
        Map<Integer, Aweme> r37 = i0().getAwemeCacheMap();
        ShortVideoDTO r38 = this.v;
        if (r38 == null) goto L97;
        Integer r39 = Integer.valueOf(r38.getMomentId());
    L98:
        Aweme r40 = r37.get(r39);
        String r41 = "";
        if (r40 == null) goto L101;
        this.u = r40;
    L114:
        Aweme r42 = this.u;
        if (r42 == null) goto L117;
        String r43 = r42.getAwemeId();
    L118:
        this.x = com.bytedance.android.shopping.extensions.k.j(r43);
        s83.f r44 = this.g;
        if (r44 == null) goto L124;
        ShortVideoDTO r45 = this.v;
        if (r45 == null) goto L123;
        r45.getFeedData();
    L123:
        r44.r(this.x);
    L124:
        ECDraweeView r46 = this.j;
        if (r46 == null) goto L133;
        Aweme r47 = this.u;
        if (r47 == null) goto L131;
        Video r48 = r47.getVideo();
        if (r48 == null) goto L131;
        ECUrlModel r49 = r48.getOriginCover();
    L132:
        h0.d(r46, r49, null, null, null, null, null, 120);
    L131:
        r49 = null;
    L133:
        com.bytedance.android.ec.store.utils.i r50 = this.A.getMuteController();
        String r51 = this.y;
        o r52 = new o(this);
        r50.getClass();
        Intrinsics.checkNotNullParameter(r51, "id");
        Intrinsics.checkNotNullParameter(r52, "muteItem");
        r50.a.put(r51, r52);
        SoundState r53 = SoundState.MUTE;
        s83.f r54 = this.g;
        if (r54 == null) goto L136;
        r54.o(this.x);
        Integer r55 = 0;
    L137:
        RoundRelativeLayout r56 = this.i;
        if (r56 == null) goto L148;
        ViewGroup.LayoutParams r57 = r56.getLayoutParams();
        if (r57 == null) goto L148;
        if (r55 != null) goto L144;
    L145:
        int r58 = (this.B.r.getWidth() * 3) / 4;
    L147:
        r57.height = r58;
        goto L148
    L144:
        if (r55.intValue() != 0) goto L145;
        r58 = (this.B.r.getWidth() * 4) / 3;
    L148:
        RoundLinearLayout r59 = this.h;
        if (r59 == null) goto L151;
        r59.requestLayout();
    L151:
        GenericDraweeView r60 = this.j;
        if (r60 == null) goto L154;
        r60.setVisibility(0);
    L154:
        TextView r61 = this.n;
        if (r61 == null) goto L161;
        ShortVideoDTO r62 = this.v;
        if (r62 == null) goto L159;
        String r63 = r62.getMomentTime();
    L160:
        r61.setText(r63);
        goto L161
    L159:
        r63 = null;
    L161:
        AppCompatTextView r64 = this.o;
        if (r64 == null) goto L168;
        ShortVideoDTO r65 = this.v;
        if (r65 == null) goto L166;
        CharSequence r66 = r65.getTitleText();
    L167:
        r64.setText(r66);
        goto L168
    L166:
        r66 = null;
    L168:
        ShortVideoDTO r67 = this.v;
        if (r67 == null) goto L173;
        com.bytedance.android.ec.store.repository.dto.l r68 = r67.getProduct();
        if (r68 == null) goto L173;
        StoreV2ProductItemVO.Q.getClass();
        this.w = StoreV2ProductItemVO.a.b(r68);
    L173:
        TextView r69 = this.r;
        if (r69 == null) goto L180;
        StoreV2ProductItemVO r70 = this.w;
        if (r70 == null) goto L178;
        String r71 = r70.d;
    L179:
        r69.setText(r71);
        goto L180
    L178:
        r71 = null;
    L180:
        PriceView r72 = this.s;
        if (r72 == null) goto L183;
        r72.C(new ECStoreShortVideoPresenterNew$updateViews$2(this));
    L183:
        ECDraweeView r110 = this.t;
        if (r110 == null) goto L190;
        StoreV2ProductItemVO r73 = this.w;
        if (r73 == null) goto L188;
        List r111 = r73.f;
    L189:
        h0.f(r110, r111, null, null, null, 120);
        goto L190
    L188:
        r111 = null;
    L190:
        d0(false, "", "a1.b6269.c22689.d2300");
        Pair[] r74 = new Pair[4];
        r74[0] = TuplesKt.to("tab_name", "moments");
        ShortVideoDTO r75 = this.v;
        if (r75 == null) goto L193;
        Integer r76 = Integer.valueOf(r75.getMomentType());
    L194:
        r74[1] = TuplesKt.to("card_type", String.valueOf(r76));
        ShortVideoDTO r77 = this.v;
        if (r77 == null) goto L197;
        String r78 = r77.getMomentTime();
    L198:
        if (r78 == null) goto L201;
        r41 = r78;
    L201:
        r74[2] = TuplesKt.to("card_time", r41);
        r74[3] = TuplesKt.to("click_area", "more");
        Map r79 = MapsKt.mapOf(r74);
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("store") == false) goto L220;
        ShortVideoDTO r80 = this.v;
        if (r80 == null) goto L209;
        com.bytedance.android.ec.store.repository.dto.l r81 = r80.getProduct();
        if (r81 == null) goto L209;
        String r82 = r81.A();
        if (r82 == null) goto L209;
    L210:
        ECStoreParam r83 = i0().getStoreParam();
        if (r83 == null) goto L213;
        int r84 = r83.isFromAd();
    L214:
        wc.h r85 = new wc.h(r82, r84, "video", 0);
        ArrayList r86 = new ArrayList();
        LinkedHashMap r87 = new LinkedHashMap();
        ArrayList r88 = new ArrayList();
        View r89 = a0().findViewById(2131370990);
        String r112 = "a1.b6269.c22689.d64919_i" + (this.B.getAdapterPosition() + 1);
        ShortVideoDTO r113 = this.v;
        r88.add(new j(r79));
        if (r89 == null) goto L218;
        if (r112 == null) goto L218;
        r3 = new com.bytedance.android.bst.api.b(r89, r112);
        r3.a = r85;
        r3.b = r113;
        r3.c.addAll(r88);
        r3.d.putAll(r87);
        ((ArrayList) r3.e).addAll(r86);
    L218:
        if (r3 == null) goto L220;
        com.bytedance.android.bst.api.f.b(r3);
        goto L220
    L213:
        r84 = 0;
    L209:
        r82 = "0";
    L220:
        ECStoreParam r90 = i0().getStoreParam();
        if (r90 != null) goto L223;
        return;
    L223:
        if (r90.isSplitMode() != true) goto L230;
        ImageView r91 = this.l;
        if (r91 == null) goto L227;
        r91.setVisibility(8);
    L227:
        i0().isMute().setValue(Boolean.TRUE);
        return;
    L230:
        return;
    L197:
        r78 = null;
        goto L198
    L193:
        r76 = null;
        goto L194
    L136:
        r55 = null;
        goto L137
    L117:
        r43 = null;
        goto L118
    L101:
        int r92 = com.bytedance.android.ec.store.utils.h.a;
        Gson r93 = new Gson();
        ShortVideoDTO r94 = this.v;
        if (r94 == null) goto L104;
        String r95 = r94.getFeedData();
    L105:
        if (r95 != null) goto L107;
        r95 = "";
    L107:
        Aweme r96 = (Aweme) GsonProtectorUtils.fromJson(r93, r95, new n().getType());
        this.u = r96;
        if (r96 == null) goto L114;
        Map<Integer, Aweme> r97 = i0().getAwemeCacheMap();
        ShortVideoDTO r98 = this.v;
        if (r98 == null) goto L112;
        Integer r99 = Integer.valueOf(r98.getMomentId());
    L113:
        r97.put(Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(r99)), r96);
        goto L114
    L112:
        r99 = null;
        goto L113
    L104:
        r95 = null;
        goto L105
    L97:
        r39 = null;
        goto L98
    }

    public final void e0(boolean r7) {
        if (r7 == false) goto L15;
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        s83.f r1 = this.g;
        if (r1 == null) goto L6;
        r1.q(this.x);
        this.A.add(bg4.b.b(this.g.l(CollectionsKt.mutableListOf(new String[]{this.x}))).subscribe(new k(this, r8)));
        return;
    L6:
        ViewGroup r0 = this.k;
        if (r0 == null) goto L20;
        if (r1 == null) goto L13;
        Context r2 = Y().c();
        String r3 = this.x;
        String r4 = this.y;
        Boolean r5 = (Boolean) i0().isMute().getValue();
        if (r5 != null) goto L12;
        r5 = Boolean.TRUE;
    L12:
        r5.booleanValue();
        new ECStoreShortVideoPresenterNew$createVideo$$inlined$apply$lambda$1(this, r8);
        AVScene r6 = AVScene.CONTENT_DEFAULT;
        r1.a(r2, r3, r4, r0);
        Boolean r9 = Boolean.FALSE;
    L14:
        r8.element = com.bytedance.android.shopping.extensions.k.i(r9);
        return;
    L13:
        r9 = null;
        goto L14
    L20:
        return;
    L15:
        s83.f r10 = this.g;
        if (r10 == null) goto L22;
        r10.n(this.y);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r36) {
        if (r36 != null) goto L5;
        return;
    L5:
        int r1 = r36.getId();
        if (r1 != 2131370988) goto L30;
        com.bytedance.android.ec.store.utils.i r2 = this.A.getMuteController();
        String r3 = this.y;
        boolean r4 = true ^ com.bytedance.android.shopping.extensions.k.i((Boolean) i0().isMute().getValue());
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "id");
        if (r4 == false) goto L15;
        SoundState r5 = SoundState.MUTE;
        com.bytedance.android.ec.store.utils.j r6 = (com.bytedance.android.ec.store.utils.j) ((LinkedHashMap) r2.a).get(r3);
        if (r6 == null) goto L13;
        r6.a();
    L13:
        if (((com.bytedance.android.ec.store.utils.j) ((LinkedHashMap) r2.a).get(r3)) == null) goto L28;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
    L28:
        r2.b = r3;
        return;
    L15:
        SoundState r7 = SoundState.MUTE;
        Map r8 = r2.a;
        LinkedHashMap r9 = (LinkedHashMap) r8;
        com.bytedance.android.ec.store.utils.j r10 = (com.bytedance.android.ec.store.utils.j) r9.get(r2.b);
        if (r10 == null) goto L18;
        r10.a();
    L18:
        Iterator r11 = ((LinkedHashMap) r2.a).entrySet().iterator();
    L20:
        if (r11.hasNext() == false) goto L25;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        com.bytedance.android.ec.store.utils.j r14 = (com.bytedance.android.ec.store.utils.j) r12.getValue();
        if (Intrinsics.areEqual(r13, r3) == true) goto L23;
        SoundState r15 = SoundState.MUTE;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.a();
        goto L20
    L23:
        r14.getClass();
        goto L20
    L25:
        com.bytedance.android.ec.store.utils.j r16 = (com.bytedance.android.ec.store.utils.j) ((LinkedHashMap) r2.a).get(r3);
        if (r16 == null) goto L28;
        r16.b();
        goto L28
    L30:
        if (r1 != 2131370990) goto L121;
        StoreV2ProductItemVO r17 = this.w;
        if (r17 == null) goto L140;
        d0(true, "more", "a1.b6269.c22689.d64919");
        this.A.getLiveManager().b();
        ECStoreParam r18 = this.A.getStoreParam();
        BtmSDK r19 = BtmSDK.INSTANCE;
        PageFinder r20 = PageFinder.via(((QFragmentPresenter) this).e);
        BcmParams r21 = new BcmParams();
        r21.put("bst_group_type", "video");
        Unit r22 = Unit.INSTANCE;
        String r32 = r19.createJumpSourceBtmToken("a1.b6269.c22689.d64919", r20, r21);
        hm.b r23 = hm.b.c;
        Context r110 = Y().c();
        String r24 = r17.b;
        if (r24 != null) goto L37;
    L44:
        r24 = r17.a;
    L45:
        String r111 = r24;
        String r112 = r17.l;
        String r25 = r17.a;
        Integer r113 = r18.getFollowStatus();
        String r114 = r18.getWhichAccount();
        com.bytedance.commerce.base.json.a[] r26 = new com.bytedance.commerce.base.json.a[27];
        if (Intrinsics.areEqual(r18.getShareContent(), "shop") == false) goto L48;
        String r27 = "share_alert";
    L49:
        r26[0] = JsonDslUtilKt.d("product_source_page", r27);
        r26[1] = JsonDslUtilKt.d("carrier_source", "store_page");
        r26[2] = JsonDslUtilKt.d("source_method", "moments");
        String r28 = "";
        r26[3] = JsonDslUtilKt.d("tab_label", "");
        r26[4] = JsonDslUtilKt.d("category_id", "");
        r26[5] = JsonDslUtilKt.d("tab_type", "");
        r26[6] = JsonDslUtilKt.d("page_version", "");
        r26[7] = JsonDslUtilKt.d("page_name", r18.getPageName());
        r26[8] = JsonDslUtilKt.d("price_type", String.valueOf(r17.h));
        Integer r29 = r18.getFollowStatus();
        if (r29 == null) goto L52;
        String r30 = String.valueOf(r29.intValue());
    L53:
        if (r30 != null) goto L55;
        r30 = "";
    L55:
        r26[9] = JsonDslUtilKt.d("follow_status", r30);
        String r31 = r18.getTempId();
        if (r31 != null) goto L58;
        r31 = "";
    L58:
        r26[10] = JsonDslUtilKt.d("temp_id", r31);
        r26[11] = JsonDslUtilKt.d("store_type", "shop");
        String r33 = r18.getStoreSourcePage();
        if (r33 != null) goto L61;
        r33 = "";
    L61:
        r26[12] = JsonDslUtilKt.d("store_source_page", r33);
        String r34 = r18.getStoreSourceMethod();
        if (r34 != null) goto L64;
        r34 = "";
    L64:
        r26[13] = JsonDslUtilKt.d("store_source_method", r34);
        String r35 = r18.getStoreGroupType();
        if (r35 != null) goto L67;
        r35 = "";
    L67:
        r26[14] = JsonDslUtilKt.d("store_group_type", r35);
        String r37 = r18.getLiveAnchorId();
        if (r37 != null) goto L70;
        r37 = "";
    L70:
        r26[15] = JsonDslUtilKt.d("live_anchor_id", r37);
        r26[16] = JsonDslUtilKt.d("pre_product_id", r18.getPreProductId());
        r26[17] = JsonDslUtilKt.d("pre_room_id", r18.getPreRoomId());
        r26[18] = JsonDslUtilKt.d("pre_group_id", r18.getPreGroupId());
        v r38 = r17.u;
        if (r38 == null) goto L73;
        String r39 = r38.i();
    L74:
        r26[19] = JsonDslUtilKt.d("room_id", String.valueOf(r39));
        String r40 = r17.b;
        if (r40 != null) goto L77;
        r40 = "";
    L77:
        r26[20] = JsonDslUtilKt.d("promotion_id", r40);
        if (r17.c("ecom_shop_product_below") == null) goto L80;
        String r41 = CommentScene.COMMENTSCENE_NO_AWEME;
        String r210 = r41;
    L81:
        r26[21] = JsonDslUtilKt.d("is_product_info", r41);
        if (com.bytedance.android.shopping.extensions.k.c(r17.h) == false) goto L84;
        String r42 = r210;
    L85:
        r26[22] = JsonDslUtilKt.d("is_price_info", r42);
        if (r17.c("ecom_shop_product_recommend") == null) goto L88;
        String r43 = r210;
    L89:
        r26[23] = JsonDslUtilKt.d("is_recommend_info", r43);
        com.bytedance.android.ec.store.repository.dto.l.b r44 = r17.s;
        if (r44 == null) goto L92;
        String r45 = r44.d();
    L93:
        r26[24] = JsonDslUtilKt.d("content_form", r45);
        r26[25] = JsonDslUtilKt.d("card_type", "201");
        r26[26] = JsonDslUtilKt.d("content_source", "shop");
        JSONObject r46 = JsonDslUtilKt.a(r26);
        if (r18.getProductBasicRequestParam().isCustom() == false) goto L97;
        r46.accumulate("customer_id", r18.getProductBasicRequestParam().getMaterialId());
    L97:
        if (r18.isEcShare() == false) goto L99;
        r46.accumulate("share_content", r18.getShareContent());
        r46.accumulate("share_object", r18.getShareObject());
    L99:
        r46.accumulate("icon_type", r18.getPassThroughParam("icon_type"));
        JSONObject r47 = com.bytedance.android.shopping.extensions.k.w((String) r18.getPassThroughParam("pass_through_api"));
        if (r47 == null) goto L102;
        r46.accumulate(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r47.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L102:
        Map r48 = r17.o;
        if (r48 == null) goto L108;
        Iterator r49 = r48.entrySet().iterator();
    L106:
        if (r49.hasNext() == false) goto L108;
        Map.Entry r211 = (Map.Entry) r49.next();
        Iterator r212 = r49;
        String r50 = (String) r211.getKey();
        String r213 = r28;
        r46.accumulate(r50, r211.getValue());
        r28 = r213;
        r49 = r212;
    L108:
        String r214 = r28;
        Unit r51 = Unit.INSTANCE;
        String r52 = r46.toString();
        String r215 = r18.getSearchParams();
        com.bytedance.commerce.base.json.a[] r53 = new com.bytedance.commerce.base.json.a[1];
        JSONObject r54 = com.bytedance.android.shopping.extensions.k.w((String) r18.getPassThroughParam("pass_through_api"));
        if (r54 == null) goto L111;
        String r55 = r54.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L112:
        if (r55 != null) goto L114;
        String r56 = r214;
    L115:
        r53[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r56);
        JSONObject r216 = JsonDslUtilKt.a(r53);
        String r217 = (String) CollectionsKt.getOrNull(r17.f, 0);
        Long r57 = r17.c;
        if (r57 == null) goto L118;
        long r58 = r57.longValue();
    L119:
        com.bytedance.android.ec.store.common.starter.e.a(r23, r110, r111, "store_page", r112, "", "", r25, r113, "moments", r114, r52, r215, r216, r217, true, null, r58, Boolean.FALSE, this.A.getAdParams(), "7f000000", null, r32, null, 190840832);
        return;
    L118:
        r58 = SourceType.UNKNOWN.getType();
        goto L119
    L114:
        r56 = r55;
        goto L115
    L111:
        r55 = null;
        goto L112
    L92:
        r45 = "";
        goto L93
    L88:
        r43 = "0";
        goto L89
    L84:
        r42 = "0";
        goto L85
    L80:
        r210 = CommentScene.COMMENTSCENE_NO_AWEME;
        r41 = "0";
        goto L81
    L73:
        r39 = null;
        goto L74
    L52:
        r30 = null;
        goto L53
    L48:
        r27 = r18.getEntranceLocation();
        goto L49
    L37:
        if (r24.length() <= 0) goto L39;
        boolean r59 = true;
    L40:
        if (r59 == true) goto L43;
        r24 = null;
    L43:
        if (r24 != null) goto L45;
    L39:
        r59 = false;
        goto L40
    L140:
        return;
    L121:
        if (r1 != 2131370997) goto L138;
        d0(true, "video", "a1.b6269.c22689.d2300");
        this.A.getLiveManager().b();
        s83.f r60 = this.g;
        if (r60 == null) goto L125;
        r60.n(this.y);
    L125:
        final String r115 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b6269.c22689.d2300", PageFinder.via(((QFragmentPresenter) this).e), null, 4, null);
        ViewGroup r116 = this.k;
        if (r116 == null) goto L139;
        hm.b.c.c(l0.b(Y().c()), CollectionsKt.listOf(this.x), this.y, r116, new com.bytedance.android.ec.store.common.starter.f(ECShopStoreType.STORE, ECSShopSourceMethod.MOMENTS), r115, new ECStoreShortVideoPresenterNew$go2VideoPage$$inlined$apply$lambda$1(this, r115));
        return;
    L139:
        return;
    }

    public ECStoreShortVideoPresenterNew(Fragment r2, ECStoreViewModel r3, ECStoreShortVideoViewHolderNew r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        super(r2);
        this.A = r3;
        this.B = r4;
        this.f = LazyKt.lazy(new ECStoreShortVideoPresenterNew$viewModel$2(this));
        boolean r5 = ECServiceManager.a;
        s83.g r6 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r6 == null) goto L5;
        s83.f r7 = r6.p();
    L6:
        this.g = r7;
        this.x = "";
        this.y = UUID.randomUUID().toString();
        this.z = new QLiveData();
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void d0(boolean r7, String r8, String r9) {
        if (r7 == false) goto L4;
        String r10 = "moments_card_click";
    L5:
        String r3 = r10;
        Pair[] r11 = new Pair[6];
        r11[0] = TuplesKt.to("tab_name", "moments");
        ShortVideoDTO r0 = this.v;
        Map<String, String> r2 = null;
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(r0.getMomentType());
    L9:
        r11[1] = TuplesKt.to("card_type", String.valueOf(r1));
        ShortVideoDTO r4 = this.v;
        if (r4 == null) goto L12;
        String r5 = r4.getMomentTime();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r11[2] = TuplesKt.to("card_time", r5);
        r11[3] = TuplesKt.to("click_area", r8);
        ShortVideoDTO r12 = this.v;
        if (r12 == null) goto L18;
        String r13 = r12.getMomentIdStr();
    L19:
        r11[4] = TuplesKt.to("moment_id", r13);
        int r14 = com.bytedance.android.ec.store.utils.h.a;
        r11[5] = TuplesKt.to("btm_id", BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r9, Boolean.FALSE).withBtmPage(ECAppInfoService.e.getCurrentActivity()).build()));
        Map<String, ? extends Object> r6 = MapsKt.mutableMapOf(r11);
        ShortVideoDTO r15 = this.v;
        if (r15 == null) goto L22;
        r2 = r15.getLogExtra();
    L22:
        if (r2 != null) goto L24;
        r2 = MapsKt.emptyMap();
    L24:
        r6.putAll(r2);
        this.A.doAnyEventActionWithBtm(r9, PageFinder.via(a0()), r3, r6, new Pair[0]);
        return;
    L18:
        r13 = null;
        goto L19
    L12:
        r5 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    L4:
        r10 = "moments_card_show";
        goto L5
    }
}
