package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.g0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sg2.v;
import xi2.f0;
import xi2.m0;
import xi2.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/IronPromotionListBackgroundView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronPromotionListBackgroundView extends FrameLayout {
    public static final /* synthetic */ int w = 0;
    public ViewGroup a;
    public ECNetImageView b;
    public TextView c;
    public ConstraintLayout d;
    public ECNetImageView e;
    public ECDraweeView f;
    public TextView g;
    public ECDraweeView h;
    public Group i;
    public ECCustomizedElementView j;
    public ECCustomizedElementView k;
    public boolean l;
    public gi2.a m;
    public jf.d n;
    public ECPromotionList.s o;
    public int p;
    public String q;
    public Map<String, String> r;
    public TitleSwitchHelperV2 s;
    public TitleSwitchHelperV2 t;
    public boolean u;
    public final b v;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ IronPromotionListBackgroundView g;

        public b(IronPromotionListBackgroundView r3) {
            this.g = r3;
            super(null, "bind_key_live_promotion_list", 1);
        }

        public final void a(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            IronPromotionListBackgroundView r0 = this.g;
            ECPromotionList.s r1 = r0.o;
            if (r1 == null) goto L69;
            w r2 = r1.marketComponent;
            if (r2 == null) goto L70;
            TextView r3 = r0.c;
            if (r3 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("marketComponentTextView");
        L9:
            Object r4 = r3.getTag();
            String r5 = null;
            if ((r4 instanceof f0) == true) goto L12;
            r4 = null;
        L12:
            f0 r6 = (f0) r4;
            if (r6 == null) goto L15;
            String r7 = r6.d();
        L16:
            String r8 = a2.d(r7);
            if (r8 == null) goto L71;
            BcmParams.a r9 = BcmParams.Companion;
            m0 r11 = r2.b();
            if (r11 == null) goto L21;
            Map<String, String> r12 = r11.a();
        L22:
            r9.getClass();
            com.bytedance.android.btm.api.model.d r13 = BtmUtilsKt.d("a1.b0715.c9204.d320869", BcmParams.a.c(r12), PageFinder.via(r10));
            if (r0.p != 2) goto L57;
            jf.d r14 = r0.n;
            if (r14 == null) goto L31;
            Context r15 = r0.getContext();
            gi2.a r16 = r0.m;
            if (r16 == null) goto L29;
            LiveRoomParams r17 = (LiveRoomParams) r16.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        L30:
            r14.o(r15, r8, r17, r13);
            goto L31
        L29:
            r17 = null;
        L31:
            gi2.a r18 = r0.m;
            if (r18 == null) goto L34;
            LiveRoomParams r19 = (LiveRoomParams) r18.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        L35:
            com.bytedance.android.ec.common.api.jump.model.b r20 = r0.m;
            if (r20 != null) goto L38;
            r20 = com.bytedance.android.ec.common.api.jump.model.b.a;
        L38:
            v r21 = new v("livesdk_click_store_entrance", r20);
            r21.c("store_type", "shop");
            if (r19 == null) goto L41;
            String r22 = r19.getEnterFromMerge();
        L42:
            r21.c("store_source_page", r22);
            if (r19 == null) goto L45;
            String r23 = r19.getEnterMethod();
        L46:
            r21.c("store_source_method", r23);
            r21.c("store_group_type", "live");
            m0 r24 = r2.b();
            if (r24 == null) goto L52;
            Map<String, String> r25 = r24.c();
            if (r25 == null) goto L52;
            String r26 = r25.get("author_id");
            if (r26 == null) goto L52;
        L53:
            r21.c("author_id", r26);
            r21.c("live_anchor_id", r0.q);
            r21.c("entrance_location", "live_brand_speical");
            ECLiveABUtils r27 = ECLiveABUtils.INSTANCE;
            if (r27.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L56;
            r21.c("schema", StringsKt.take(r8, r27.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue()));
        L56:
            r21.i(null);
            IronPromotionListBackgroundView.g(r0.m, r8, r13);
        L67:
            xh.c.a("Live").d("good_list", "top_atmosphere", MapsKt.mapOf(TuplesKt.to("position", "right")));
            return;
        L52:
            r26 = "";
            goto L53
        L45:
            r23 = null;
            goto L46
        L41:
            r22 = null;
            goto L42
        L34:
            r19 = null;
            goto L35
        L57:
            if (r6 == null) goto L59;
            String r28 = r6.e();
        L60:
            m0 r29 = r2.b();
            TextView r30 = r0.c;
            if (r30 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("marketComponentTextView");
        L63:
            CharSequence r31 = r30.getText();
            if (r31 == null) goto L66;
            r5 = r31.toString();
        L66:
            IronPromotionListBackgroundView.e(r0, r8, r28, r29, r5, r0.m);
            IronPromotionListBackgroundView.g(r0.m, r8, r13);
            goto L67
        L59:
            r28 = null;
            goto L60
        L21:
            r12 = null;
            goto L22
        L71:
            return;
        L15:
            r7 = null;
            goto L16
        L70:
            return;
        }
    }

    static {
    }

    public IronPromotionListBackgroundView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronPromotionListBackgroundView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int f(int r2) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L7;
        return (int) ((r2 * ((ViewGroup) r0).getWidth()) / 375.0f);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final String c(String r4, com.bytedance.android.btm.api.model.d r5) {
        UrlBuilderV2 r0 = new UrlBuilderV2(r4);
        BtmUtilsKt.c(r0, r5);
        gi2.a r6 = this.m;
        if (r6 == null) goto L18;
        LiveRoomParams r7 = r6.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r7 == null) goto L18;
        JSONObject r8 = new JSONObject();
        String r1 = r7.getGroupId();     // Catch: Exception -> L14
        if (r1 == null) goto L10;
        r8.put("group_id", r1);     // Catch: Exception -> L14
    L10:
        r8.put("room_id", r7.getRoomId());     // Catch: Exception -> L14
        r8.put("request_id", r7.getRequestId());     // Catch: Exception -> L14
        r8.put("action_type", r7.getActionType());     // Catch: Exception -> L14
        r8.put("enter_from_merge", r7.getEnterFromMerge());     // Catch: Exception -> L14
        r8.put("enter_method", r7.getEnterMethod());     // Catch: Exception -> L14
        String r9 = r7.isOtherChannel();     // Catch: Exception -> L14
        if (r9 == null) goto L16;
        r8.put("is_other_channel", r9);     // Catch: Exception -> L14
    L16:
        Unit r10 = Unit.INSTANCE;
        r0.addOrReplaceParam("source_info", r8);
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L18:
        return r0.build();
    }

    public IronPromotionListBackgroundView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.p = 1;
        this.q = "";
        this.v = new b(this);
    }

    public static void g(com.bytedance.android.ec.common.api.jump.model.a r3, String r4, com.bytedance.android.btm.api.model.d r5) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        v r1 = new v("ecom_module_click", r3);
        r1.c("schema", StringsKt.take(r4, r0.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue()));
        r1.c("page_name", "livesdk_live_room");
        r1.c("module_name", "livesdk_live_list");
        r1.c("click_area", "header_promotion");
        r1.i(r5.a);
    }

    public /* synthetic */ IronPromotionListBackgroundView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void a(IronPromotionListBackgroundView r3, m0 r4, String r5, gi2.a r6) {
        r3.getClass();
        if (r4 == null) goto L14;
        String r0 = r4.b();
        if (r0 == null) goto L15;
        String r1 = r0.concat("show");
        if (r6 != null) goto L9;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L9:
        v r2 = new v(r1, r6);
        r2.d(r4.c());
        r2.d(r3.r);
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r2.c("button_text", r5);
        r2.i("a1.b0715.c9204.d320869");
        return;
    L15:
        return;
    }

    public static /* synthetic */ void e(IronPromotionListBackgroundView r7, String r8, String r9, m0 r10, String r11, gi2.a r12) {
        r7.d(r8, r9, r10, r11, r12, -1);
    }

    public final void d(String r10, final String r11, m0 r12, String r13, final gi2.a r14, int r15) {
        BcmParams.a r0 = BcmParams.Companion;
        if (r12 == null) goto L5;
        Map<String, String> r1 = r12.a();
    L6:
        r0.getClass();
        final com.bytedance.android.btm.api.model.d r2 = BtmUtilsKt.d("a1.b0715.c9204.d320869", BcmParams.a.c(r1), PageFinder.via(this));
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = r10;
        if (r11 == null) goto L10;
        Map r16 = LoginUtil.a;
        LoginUtil.f(getContext(), new IronPromotionListBackgroundView$doClickComponent$$inlined$let$lambda$1(r11, this, r14, r3, r2));
    L15:
        if (r12 == null) goto L29;
        String r17 = r12.b();
        if (r17 == null) goto L29;
        String r18 = r17.concat("click");
        if (r14 != null) goto L21;
        gi2.a r4 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L22:
        v r19 = new v(r18, r4);
        r19.d(r12.c());
        r19.d(this.r);
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        r19.c("button_text", r13);
        ECLiveABUtils r110 = ECLiveABUtils.INSTANCE;
        if (r110.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L28;
        r19.c("schema", StringsKt.take((String) r3.element, r110.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue()));
    L28:
        r19.i(r2.a);
        goto L29
    L21:
        r4 = r14;
    L29:
        g(r14, r10, r2);
        return;
    L10:
        if (r15 != 4) goto L12;
        r3.element = c(r10, r2);
    L12:
        jf.d r5 = this.n;
        if (r5 == null) goto L15;
        r5.p(getContext(), (String) r3.element, r2, "list_card_topatmosphere", this.u);
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public static void b(final IronPromotionListBackgroundView r32, final ECPromotionList.s r33, final int r34, final String r35, final gi2.a r36, jf.d r37, boolean r38) {
        r32.getClass();
        Intrinsics.checkNotNullParameter(r35, "roomId");
        int r0 = ph.b.a;
        Intrinsics.checkNotNullParameter(r32, "view");
        if (com.bytedance.android.ec.core.opt.ab.j.a().j() == false) goto L5;
        ph.b.b(r32);
    L5:
        r32.p = r34;
        r32.q = r35;
        r32.n = r37;
        r32.m = r36;
        r32.u = r38;
        if (a2.b(r33.image) == true) goto L8;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
        ECPromotionList.s r6 = r33;
    L16:
        if (r6 == null) goto L328;
        r32.o = r33;
        r32.r = null;
        if (r32.l == true) goto L20;
        r32.l = true;
        th.a.c(r32.getContext(), 2131564723, r32, true);
        r32.b = r32.findViewById(2131380907);
        r32.a = (ViewGroup) r32.findViewById(2131378746);
        r32.c = (TextView) r32.findViewById(2131390923);
        r32.e = r32.findViewById(2131380909);
        r32.f = r32.findViewById(2131370423);
        r32.g = (TextView) r32.findViewById(2131390856);
        r32.h = r32.findViewById(2131370428);
        r32.d = r32.findViewById(2131377755);
        r32.i = r32.findViewById(2131373978);
        r32.j = (ECCustomizedElementView) r32.findViewById(2131384599);
        r32.k = (ECCustomizedElementView) r32.findViewById(2131377765);
        Space r2 = (Space) r32.findViewById(2131384611);
    L20:
        r32.setVisibility(0);
        int r3 = r32.f(54);
        ViewGroup.LayoutParams r4 = r32.getLayoutParams();
        if ((r4 instanceof RelativeLayout.LayoutParams) == true) goto L23;
        r4 = null;
    L23:
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r4;
        if (r5 == null) goto L30;
        r5.bottomMargin = r32.f(-22);
        ViewParent r7 = r32.getParent();
        if (r7 == null) goto L29;
        r5.height = Math.max((int) ((((long) ((ViewGroup) r7).getWidth()) * r33.height) / r33.width), r3);
        goto L30
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L30:
        ViewGroup r8 = r32.a;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L33:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof RelativeLayout.LayoutParams) == true) goto L36;
        r9 = null;
    L36:
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r9;
        if (r10 == null) goto L43;
        ViewParent r11 = r32.getParent();
        if (r11 == null) goto L42;
        r10.bottomMargin = (int) ((((ViewGroup) r11).getWidth() * 11.0f) / 375.0f);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L43:
        String r12 = r33.image;
        long r13 = r33.width;
        long r14 = r33.height;
        ECNetImageView r15 = r32.findViewById(2131380908);
        final ECPromotionList.s r16 = r6;
        if (r14 >= 54) goto L48;
        if (r15 == null) goto L47;
        r15.setVisibility(0);
    L47:
        boolean r17 = true;
    L51:
        int r18 = -3;
        if (r17 == false) goto L57;
        if (r36 == null) goto L55;
        v r19 = new v("livesdk_list_top_background_size_error", r36);
        r19.c("background_url", r12);
        r19.c("background_width", String.valueOf(r13));
        r19.c("background_height", String.valueOf(r14));
        List<f0> r20 = null;
        r19.i(null);
    L56:
        ECLiveImageUtils.ECNetImageInfo r21 = new ECLiveImageUtils.ECNetImageInfo();
        r21.url = r12;
        boolean r22 = true;
        r21.autoPlayAnimations = true;
        r21.disableFade = true;
        r21.width = r32.getLayoutParams().width;
        r21.height = -3;
        r21.autoScaleOneSide = true;
        ECLiveImageUtils.b(r15, r21);
    L58:
        ECLiveImageUtils.ECNetImageInfo r23 = new ECLiveImageUtils.ECNetImageInfo();
        r23.url = r33.image;
        r23.autoPlayAnimations = r22;
        r23.disableFade = r22;
        r23.width = r32.getLayoutParams().width;
        if (r17 == true) goto L61;
        r18 = r32.getLayoutParams().height;
    L61:
        r23.height = r18;
        r23.autoScaleOneSide = r17;
        ECNetImageView r24 = r32.b;
        if (r24 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
    L64:
        ECLiveImageUtils.b(r24, r23);
        ECDraweeView r25 = r32.h;
        if (r25 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("rightIconArrow");
    L68:
        if (r34 != 4) goto L70;
        int r26 = 0;
    L71:
        r25.setVisibility(r26);
        ECPromotionList.g r27 = r16.backgroundLeft;
        if (r27 == null) goto L78;
        String r28 = r27.linkUrl;
        if (r28 == null) goto L78;
        if (r28.length() <= 0) goto L78;
        final boolean r29 = true;
    L79:
        w r30 = r16.marketComponent;
        if (r30 == null) goto L130;
        List<f0> r31 = r30.d();
        if (r31 == null) goto L130;
        if ((!r31.isEmpty()) == true) goto L87;
        r31 = r20;
    L87:
        if (r31 == null) goto L130;
        w r39 = r16.marketComponent;
        ECCustomizedElementView r40 = r32.j;
        if (r40 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L91:
        r40.setVisibility(8);
        Group r41 = r32.i;
        if (r41 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("rightMarketComponentGroup");
    L94:
        r41.setVisibility(0);
        ECUrlModel r42 = r39.c();
        if (r42 == null) goto L103;
        ECNetImageView r43 = r32.e;
        if (r43 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L99:
        r43.getLayoutParams().width = (int) UIUtils.dip2Px(r43.getContext(), r42.getWidth());
        r43.getLayoutParams().height = (int) UIUtils.dip2Px(r43.getContext(), r42.getHeight());
        ECNetImageView r44 = r32.e;
        if (r44 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L102:
        ECLiveImageUtils.j(r44, r42.getFirstUrl());
        r43.setVisibility(0);
    L107:
        List<f0> r45 = r39.d();
        if (r45 != null) goto L110;
    L125:
        TextView r46 = r32.c;
        if (r46 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("marketComponentTextView");
    L128:
        r46.setVisibility(8);
    L129:
        Unit r47 = Unit.INSTANCE;
    L170:
        final xi2.e r48 = r16.leftBackgroundComponent;
        if (r48 == null) goto L252;
        ECCustomizedElementView r49 = r32.k;
        if (r49 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L175:
        r49.setVisibility(0);
        ConstraintLayout r50 = r32.d;
        if (r50 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("leftContentLayout");
    L178:
        r50.setVisibility(8);
        ECCustomizedElementView r51 = r32.k;
        if (r51 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L181:
        r51.e();
        List<xi2.f> r52 = r48.b();
        if (r52 != null) goto L184;
    L250:
        final xi2.e r110 = r48;
    L251:
        Object r53 = r110;
        CharSequence r111 = "";
    L317:
        if (r53 != null) goto L336;
        ECCustomizedElementView r54 = r32.k;
        if (r54 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L321:
        r54.setVisibility(8);
        TextView r55 = r32.g;
        if (r55 != null) goto L324;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L324:
        r55.setText(r111);
        ECDraweeView r56 = r32.f;
        if (r56 != null) goto L327;
        Intrinsics.throwUninitializedPropertyAccessException("leftIcon");
    L327:
        r56.setVisibility(8);
        Unit r57 = Unit.INSTANCE;
        return;
    L336:
        return;
    L184:
        if ((!r52.isEmpty()) == true) goto L187;
        r52 = null;
    L187:
        if (r52 == null) goto L250;
        if (ViewCompat.isLaidOut(r32) == true) goto L191;
    L249:
        r110 = r48;
        final Map r58 = null;
        r32.addOnLayoutChangeListener(new IronPromotionListBackgroundView$bindData$$inlined$let$lambda$3(r110, r16, r32, r58, r36, r34, r35));
        goto L251
    L191:
        if (r32.isLayoutRequested() == true) goto L249;
        TitleSwitchHelperV2 r59 = r32.t;
        if (r59 == null) goto L195;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r59.d);
        r59.e.e();
    L195:
        ECCustomizedElementView r60 = r32.j;
        if (r60 != null) goto L198;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L198:
        r60.setClickable(false);
        ECCustomizedElementView r61 = r32.k;
        if (r61 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L201:
        final Map r112 = null;
        r110 = r48;
        Function2<String, String, Unit> r113 = new IronPromotionListBackgroundView$bindData$$inlined$let$lambda$1(r48, r16, r32, r33, r112, r36, r34, r35);
        Function2<m0, String, Unit> r210 = new IronPromotionListBackgroundView$bindData$$inlined$let$lambda$2(r110, r16, r32, r33, r112, r36, r34, r35);
        ECCustomizedElementView r62 = r32.k;
        if (r62 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L204:
        TitleSwitchHelperV2 r63 = new TitleSwitchHelperV2(r61, r110, r34, r35, r113, r210, true, Integer.valueOf(r62.getMeasuredWidth()));
        r32.t = r63;
        r63.a();
        xi2.e r64 = r16.backgroundComponent;
        if (r64 == null) goto L222;
        List<xi2.f> r65 = r64.b();
        if (r65 == null) goto L222;
        List<xi2.f> r66 = r65;
        if ((r66 instanceof Collection) == true) goto L211;
    L213:
        Iterator<T> r67 = r66.iterator();
    L215:
        if (r67.hasNext() == false) goto L219;
        if (cg4.a.a(((xi2.f) r67.next()).b()) == false) goto L215;
        boolean r68 = true;
    L220:
        if (r68 != true) goto L222;
        boolean r69 = true;
    L223:
        ECCustomizedElementView r70 = r32.j;
        if (r70 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L226:
        r70.setClickable(r69);
        w r71 = r16.marketComponent;
        if (r71 == null) goto L244;
        List<f0> r72 = r71.d();
        if (r72 == null) goto L244;
        List<f0> r73 = r72;
        if ((r73 instanceof Collection) == true) goto L233;
    L235:
        Iterator<T> r74 = r73.iterator();
    L237:
        if (r74.hasNext() == false) goto L241;
        if (cg4.a.a(((f0) r74.next()).d()) == false) goto L237;
        boolean r75 = true;
    L242:
        if (r75 != true) goto L244;
        boolean r114 = true;
    L245:
        Group r76 = r32.i;
        if (r76 != null) goto L248;
        Intrinsics.throwUninitializedPropertyAccessException("rightMarketComponentGroup");
    L248:
        r76.setClickable(r114);
    L241:
        r75 = false;
        goto L242
    L233:
        if (r73.isEmpty() == false) goto L235;
    L244:
        r114 = false;
    L219:
        r68 = false;
        goto L220
    L211:
        if (r66.isEmpty() == false) goto L213;
    L222:
        r69 = false;
        goto L223
    L252:
        final ECPromotionList.g r115 = r16.backgroundLeft;
        if (r115 == null) goto L316;
        ConstraintLayout r77 = r32.d;
        if (r77 != null) goto L257;
        Intrinsics.throwUninitializedPropertyAccessException("leftContentLayout");
    L257:
        r77.setVisibility(0);
        ECCustomizedElementView r78 = r32.k;
        if (r78 != null) goto L260;
        Intrinsics.throwUninitializedPropertyAccessException("leftElementBlockView");
    L260:
        r78.setVisibility(8);
        String r79 = r115.image;
        if (cg4.a.a(r79) == true) goto L264;
        r79 = null;
    L264:
        if (r79 == null) goto L269;
        ECDraweeView r80 = r32.f;
        if (r80 != null) goto L268;
        Intrinsics.throwUninitializedPropertyAccessException("leftIcon");
    L268:
        r80.setVisibility(0);
        y.g(r80, r79, UtilityKotlinExtentionsKt.d(Integer.valueOf(r115.width)), UtilityKotlinExtentionsKt.d(Integer.valueOf(r115.height)));
    L273:
        String r81 = r115.format;
        if (cg4.a.a(r81) == true) goto L277;
        r81 = null;
    L277:
        if (r81 == null) goto L294;
        TextView r82 = r32.g;
        if (r82 != null) goto L281;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L281:
        r82.setVisibility(0);
        TextView r83 = r32.g;
        if (r83 != null) goto L284;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L284:
        r83.setText(r81);
        if (r115.fontSize <= 0) goto L290;
        TextView r85 = r32.g;
        if (r85 != null) goto L289;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L289:
        r85.setTextSize(1, r115.fontSize);
    L290:
        int r86 = s.a;
        int r87 = s.a(r115.color, ColorProtector.parseColor("#FE2C55"));
        TextView r88 = r32.g;
        if (r88 != null) goto L293;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L293:
        r88.setTextColor(r87);
        r111 = "";
    L298:
        BcmParams.a r89 = BcmParams.Companion;
        m0 r90 = r115.extra;
        if (r90 == null) goto L301;
        Map<String, String> r91 = r90.a();
    L302:
        r89.getClass();
        BcmParams r92 = BcmParams.a.c(r91);
        ConstraintLayout r93 = r32.d;
        if (r93 != null) goto L305;
        Intrinsics.throwUninitializedPropertyAccessException("leftContentLayout");
    L305:
        final com.bytedance.android.btm.api.model.d r94 = BtmUtilsKt.d("a1.b0715.c9204.d320869", r92, PageFinder.via(r93));
        final String r95 = a2.d(r115.linkUrl);
        if (r95 == null) goto L312;
        ConstraintLayout r96 = r32.d;
        if (r96 != null) goto L310;
        Intrinsics.throwUninitializedPropertyAccessException("leftContentLayout");
    L310:
        final Map r97 = null;
        com.bytedance.android.ec.core.widget.f.c(r96, null, "bind_key_live_promotion_list", new IronPromotionListBackgroundView$bindData$$inlined$let$lambda$4(r95, r94, r115, r32, r33, r97, r36, r34, r35), 1);
    L312:
        m0 r98 = r115.extra;
        if (r98 == null) goto L315;
        g0 r99 = new g0(Intrinsics.stringPlus(r98.b(), "show"), r36);
        r99.g(r98.c());
        r99.l(r94.a, r94.b.btmPageId);
    L315:
        r53 = r115;
        goto L317
    L301:
        r91 = null;
        goto L302
    L294:
        TextView r100 = r32.g;
        if (r100 != null) goto L297;
        Intrinsics.throwUninitializedPropertyAccessException("leftFormat");
    L297:
        r111 = "";
        r100.setText(r111);
        goto L298
    L269:
        ECDraweeView r101 = r32.f;
        if (r101 != null) goto L272;
        Intrinsics.throwUninitializedPropertyAccessException("leftIcon");
    L272:
        r101.setVisibility(8);
        goto L273
    L316:
        r111 = "";
        r53 = null;
        goto L317
    L110:
        if ((!r45.isEmpty()) == true) goto L113;
        r45 = null;
    L113:
        if (r45 == null) goto L125;
        TextView r102 = r32.c;
        if (r102 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("marketComponentTextView");
    L117:
        m r103 = new m(r102, r39, r32.r, r32.v, r32.p, r32.q, r32.m);
        List<f0> r104 = r103.d.d();
        if (r104 == null) goto L129;
        r103.a((f0) ListProtector.get(r104, 0));
        if (r103.d.a() <= 0) goto L129;
        if (r104.size() <= 1) goto L129;
        r103.b();
        goto L129
    L103:
        ECNetImageView r105 = r32.e;
        if (r105 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L106:
        r105.setVisibility(8);
        Unit r106 = Unit.INSTANCE;
    L130:
        TextView r107 = r32.c;
        if (r107 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("marketComponentTextView");
    L133:
        r107.setVisibility(8);
        ECNetImageView r108 = r32.e;
        if (r108 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L136:
        r108.setVisibility(8);
        final xi2.e r109 = r16.backgroundComponent;
        if (r109 == null) goto L166;
        Group r116 = r32.i;
        if (r116 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("rightMarketComponentGroup");
    L141:
        r116.setVisibility(8);
        ECCustomizedElementView r117 = r32.j;
        if (r117 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L144:
        r117.setVisibility(0);
        ECCustomizedElementView r118 = r32.j;
        if (r118 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L147:
        r118.e();
        List<xi2.f> r119 = r109.b();
        if (r119 != null) goto L150;
    L162:
        ECCustomizedElementView r120 = r32.j;
        if (r120 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L165:
        r120.setVisibility(8);
        Unit r121 = Unit.INSTANCE;
        goto L170
    L150:
        if ((!r119.isEmpty()) == true) goto L153;
        r119 = null;
    L153:
        if (r119 == null) goto L162;
        TitleSwitchHelperV2 r122 = r32.s;
        if (r122 == null) goto L157;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r122.d);
        r122.e.e();
    L157:
        ECCustomizedElementView r123 = r32.j;
        if (r123 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L160:
        TitleSwitchHelperV2 r124 = new TitleSwitchHelperV2(r123, r109, r32.p, r32.q, new IronPromotionListBackgroundView$showRightInterestView$$inlined$let$lambda$1(r32, r109, r36, r29), new IronPromotionListBackgroundView$showRightInterestView$$inlined$let$lambda$2(r32, r109, r36, r29), !r29, null);
        r32.s = r124;
        r124.a();
        if (Unit.INSTANCE != null) goto L170;
    L166:
        ECCustomizedElementView r125 = r32.j;
        if (r125 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L169:
        r125.setVisibility(8);
        Unit r126 = Unit.INSTANCE;
    L78:
        r29 = false;
        goto L79
    L70:
        r26 = 8;
        goto L71
    L55:
        r20 = null;
        goto L56
    L57:
        r22 = true;
        r20 = null;
        goto L58
    L48:
        if (r15 == null) goto L50;
        r15.setVisibility(8);
    L50:
        r17 = false;
        goto L51
    L328:
        r32.setVisibility(8);
        Unit r127 = Unit.INSTANCE;
        return;
    L15:
        r6 = null;
        goto L16
    L8:
        if (r33.height <= 0) goto L12;
        if (r33.width <= 0) goto L12;
        r1 = true;
        goto L13
    }
}
