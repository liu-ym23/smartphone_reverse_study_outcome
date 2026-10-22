package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView;
import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.IMMeta;
import com.bytedance.android.shopping.anchorv4.bottom.h0;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponentV2;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.CustomMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.ShareBtnAnimController;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.utils.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopRightControlsComponent implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a, com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.e {
    public TopRightControlsVO a;
    public com.bytedance.android.shopping.anchorv4.nav.controls.c b;
    public final a0 c;
    public final ViewGroup d;
    public final TagsScrollBoxComponentView e;
    public final TagsScrollBoxComponentView f;
    public final ViewGroup g;
    public final TagsScrollBoxComponentView h;
    public final AnchorV3SearchEditView i;
    public final TextView j;
    public final ViewGroup k;
    public final Lifecycle l;

    public final int M0() {
        return 0;
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final View t() {
        return null;
    }

    public final void L() {
        AnchorV3SearchEditView r0 = this.i;
        if (r0 == null) goto L6;
        r0.setEnabled(true);
        return;
    }

    public final void onScan() {
        if (PdpPerfOpt.d() == true) goto L5;
        ViewGroup r0 = this.g;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        if (this.c.isExpanded() == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L18;
        ExtensionsKt.b(r0, this);
        return;
    L18:
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L7;
        r0 = this.d;
        goto L9
    L7:
        r0 = this.g;
        goto L9
    }

    public final void M(int r2) {
        AnchorV3SearchEditView r3 = this.i;
        if (r3 == null) goto L6;
        r3.setEnabled(false);
        return;
    }

    public final void a(TopRightControlsVO r21) {
        TagsScrollBoxComponent r1 = r21.getDarkElements();
        TagsScrollBoxComponentView r2 = null;
        if (r1 == null) goto L7;
        List r3 = r1.getButtonList();
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.size());
    L9:
        if (com.bytedance.android.shopping.extensions.k.f(r4) <= 0) goto L19;
        TagsScrollBoxComponent r5 = r21.getLightElements();
        if (r5 == null) goto L15;
        List r6 = r5.getButtonList();
        if (r6 == null) goto L15;
        Integer r7 = Integer.valueOf(r6.size());
    L17:
        if (com.bytedance.android.shopping.extensions.k.f(r7) <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
        TopRightControlsVO r9 = r21;
    L23:
        if (r9 == null) goto L73;
        ViewGroup r10 = this.g;
        if (r10 == null) goto L27;
        r10.setVisibility(0);
    L27:
        TagsScrollBoxComponentView r11 = this.h;
        if (r11 == null) goto L30;
        TagsScrollBoxComponentView.b(r11, r9.getDarkElements(), r9.getShowExtraElement(), 12);
    L30:
        ViewGroup r12 = this.d;
        if (r12 == null) goto L33;
        r12.setVisibility(0);
    L33:
        TagsScrollBoxComponentView r13 = this.e;
        if (r13 == null) goto L36;
        TagsScrollBoxComponentView.b(r13, r9.getLightElements(), r9.getShowExtraElement(), 12);
    L36:
        TagsScrollBoxComponentView r14 = this.e;
        TagsScrollBoxComponent r15 = r9.getLightElements();
        TopRightControlsVO r16 = this.a;
        if (r16 == null) goto L39;
        TopRightControlsMeta r17 = r16.getTopRightMeta();
    L40:
        TopRightWidgetController r18 = new TopRightWidgetController(r14, r15, r17, this.l, this.c);
        Iterator<T> r19 = r18.b.iterator();
    L42:
        if (r19.hasNext() == false) goto L44;
        ((com.bytedance.android.shopping.anchorv4.nav.controls.d) r19.next()).a();
        goto L42
    L44:
        Unit r20 = Unit.INSTANCE;
        this.b = r18;
        TagsScrollBoxComponent r22 = new TagsScrollBoxComponent(null, null, 0, 0, null, false, 0, null, null, null, 1023, null);
        TagsScrollBoxComponent r23 = r9.getLightElements();
        if (r23 == null) goto L68;
        List r24 = r23.getButtonList();
        if (r24 == null) goto L68;
        ArrayList r25 = new ArrayList();
        Iterator r26 = r24.iterator();
    L50:
        if (r26.hasNext() == false) goto L69;
        Object r27 = r26.next();
        TextWithOneIconElement r28 = (TextWithOneIconElement) r27;
        Action r29 = r28.getAction();
        if (r29 == null) goto L54;
        String r30 = r29.getId();
    L56:
        if (Intrinsics.areEqual(r30, "action_share") == true) goto L65;
        Action r31 = r28.getAction();
        if (r31 == null) goto L60;
        String r32 = r31.getId();
    L62:
        if (Intrinsics.areEqual(r32, "action_collect") == true) goto L65;
        boolean r33 = false;
    L66:
        if (r33 == false) goto L50;
        r25.add(r27);
        goto L50
    L60:
        r32 = null;
    L65:
        r33 = true;
        goto L66
    L54:
        r30 = null;
    L69:
        r22.setButtonList(r25);
        TagsScrollBoxComponentView r34 = this.f;
        if (r34 == null) goto L72;
        TagsScrollBoxComponentView.b(r34, r22, null, 14);
        r2 = r34;
    L72:
        if (r2 == null) goto L73;
    L79:
        TagsScrollBoxComponentView r35 = this.e;
        if (r35 == null) goto L82;
        ExtensionsKt.e(r35, this);
    L82:
        TagsScrollBoxComponentView r36 = this.h;
        if (r36 == null) goto L85;
        ExtensionsKt.e(r36, this);
    L85:
        TagsScrollBoxComponentView r37 = this.f;
        if (r37 == null) goto L88;
        ExtensionsKt.e(r37, this);
    L88:
        this.c.q(this, r21, 0);
        return;
    L68:
        r25 = null;
        goto L69
    L39:
        r17 = null;
    L73:
        ViewGroup r38 = this.g;
        if (r38 == null) goto L76;
        r38.setVisibility(8);
    L76:
        ViewGroup r39 = this.d;
        if (r39 == null) goto L79;
        r39.setVisibility(8);
        Unit r40 = Unit.INSTANCE;
        goto L79
    L22:
        r9 = null;
    L15:
        r7 = null;
    L19:
        r8 = false;
    L7:
        r4 = null;
        goto L9
    }

    public final void c(Function1<? super vg3.z, Unit> r2) {
        this.c.d(r2);
    }

    public final void b(boolean r5, boolean r6) {
        CommonMeta r0 = this.c.a();
        String r1 = null;
        if (r0 == null) goto L8;
        ECAdLogExtra r2 = r0.getAdLogExtra();
        if (r2 == null) goto L8;
        String r3 = r2.getCreativeId();
        if (r3 == null) goto L8;
    L16:
        if (r3 != null) goto L18;
        return;
    L18:
        CommonMeta r4 = this.c.a();
        if (r4 == null) goto L21;
        Map r7 = h73.a.a(r4);
    L22:
        CommonMeta r8 = this.c.a();
        if (r8 == null) goto L29;
        String r9 = r8.getEntranceInfo();
        if (r9 == null) goto L29;
        JSONObject r10 = com.bytedance.android.shopping.extensions.k.w(r9);
        if (r10 == null) goto L29;
        r1 = r10.optString("log_extra");
    L29:
        if (r5 == false) goto L31;
        AdLogUtils.r(r3, r7, r1);
        return;
    L31:
        if (r6 == true) goto L33;
        AdLogUtils.l(r3, r7, r1);
        return;
    L33:
        AdLogUtils.m(r3, r7, r1);
        return;
    L21:
        r7 = null;
    L8:
        CommonMeta r11 = this.c.a();
        if (r11 == null) goto L15;
        String r12 = r11.getEntranceInfo();
        if (r12 == null) goto L15;
        JSONObject r13 = com.bytedance.android.shopping.extensions.k.w(r12);
        if (r13 == null) goto L15;
        r3 = r13.optString("creative_id");
    L15:
        r3 = null;
        goto L16
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r2, Object r3) {
        if (r2 == null) goto L4;
        String r4 = r2.getId();
    L5:
        if (r4 != null) goto L8;
        return;
    L8:
        switch(r4.hashCode()) {
            case -966266847: goto L29;
            case 198295501: goto L26;
            case 1497533277: goto L23;
            case 1525717969: goto L20;
            case 1583526525: goto L17;
            case 1583540158: goto L14;
            case 1850421398: goto L11;
            default: goto L46;
        };
    L46:
        return;
    L11:
        if (r4.equals("action_share") == false) goto L32;
        c(TopRightControlsComponent$handleShowToHub$3.INSTANCE);
        return;
    L32:
        return;
    L14:
        if (r4.equals("action_more") == false) goto L34;
        c(TopRightControlsComponent$handleShowToHub$6.INSTANCE);
        return;
    L34:
        return;
    L17:
        if (r4.equals("action_mall") == false) goto L36;
        c(TopRightControlsComponent$handleShowToHub$5.INSTANCE);
        return;
    L36:
        return;
    L20:
        if (r4.equals("action_search") == false) goto L38;
        final String r5 = new BtmItemBuilder("a1.b8094.c9263.d4884", Boolean.FALSE).withView(this.i).createBtmId();
        c(new TopRightControlsComponent$handleShowToHub$2(r5));
        return;
    L38:
        return;
    L23:
        if (r4.equals("action_report") == false) goto L40;
        c(TopRightControlsComponent$handleShowToHub$7.INSTANCE);
        return;
    L40:
        return;
    L26:
        if (r4.equals("action_im") == false) goto L42;
        c(TopRightControlsComponent$handleShowToHub$4.INSTANCE);
        return;
    L42:
        return;
    L29:
        if (r4.equals("action_collect") == false) goto L44;
        c(TopRightControlsComponent$handleShowToHub$1.INSTANCE);
        return;
    L44:
        return;
    L4:
        r4 = null;
        goto L5
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(final View r53, Action r54, Object r55) {
        Intrinsics.checkNotNullParameter(r53, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r54, "action");
        TopRightControlsVO r2 = this.a;
        if (r2 == null) goto L114;
        TopRightControlsMeta r3 = r2.getTopRightMeta();
        if (r3 == null) goto L139;
        boolean r8 = this.c.isExpanded();
        long r6 = this.c.p();
        String r4 = r54.getId();
        if (r4 == null) goto L140;
        IMMeta r5 = null;
        switch(r4.hashCode()) {
            case -966266847: goto L101;
            case 198295501: goto L82;
            case 1497533277: goto L68;
            case 1525717969: goto L63;
            case 1583526525: goto L51;
            case 1583540158: goto L28;
            case 1850421398: goto L14;
            default: goto L141;
        };
    L141:
        return;
    L14:
        if (r4.equals("action_share") == false) goto L115;
        ShareMeta r7 = r3.getShareMeta();
        if (r7 != null) goto L18;
        return;
    L18:
        ShareMeta r12 = r7.fillCommonMeta(this.c.a());
        if (r12 == null) goto L142;
        String r9 = Intrinsics.stringPlus(r12.getProductId(), "_" + System.currentTimeMillis());
        ShareMeta r10 = ShareMeta.copy$default(r12, null, null, null, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, r9, "product_detail", null, Integer.MAX_VALUE, 2, null);
        ih3.f r11 = ih3.f.b;
        r11.createDurationMonitor(r9);
        r11.a(r9);
        com.bytedance.android.shopping.anchorv4.nav.controls.c r13 = this.b;
        if (r13 == null) goto L26;
        ShareBtnAnimController r14 = r13.a();
        if (r14 == null) goto L26;
        r14.d = true;
    L26:
        new ShareComponentV2(new n(this.c), r53, r10, "top", this.b).a();
        b(true, false);
        return;
    L142:
        return;
    L115:
        return;
    L28:
        if (r4.equals("action_more") == false) goto L117;
        CustomMeta r0 = r3.getMoreMeta();
        if (r0 != null) goto L32;
        return;
    L32:
        c(TopRightControlsComponent$handlerMoreWithMeta$1.INSTANCE);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L45
        String r16 = r0.getData();     // Catch: Throwable -> L45
        if (r16 == null) goto L36;
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L45
    L38:
        if (r17.optBoolean("handle_schema_by_host", false) == false) goto L40;
        this.c.openSchema(r0.getSchema());     // Catch: Throwable -> L45
        return;
    L40:
        ViewGroup r18 = this.k;     // Catch: Throwable -> L45
        if (r18 == null) goto L43;
        r5 = r18.getContext();     // Catch: Throwable -> L45
    L43:
        String r1 = r0.getSchema();     // Catch: Throwable -> L45
        r17.put("identifier", AnchorV4DataManager.d);     // Catch: Throwable -> L45
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L45
        com.bytedance.android.shopping.anchorv4.containers.b.b(r5, r1, r17, false);     // Catch: Throwable -> L45
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L119;
        ECExceptionMonitor.e(r21);
        return;
    L119:
        return;
    L36:
        r17 = new JSONObject();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L117:
        return;
    L51:
        if (r4.equals("action_mall") == false) goto L121;
        CustomMeta r23 = r3.getMallMeta();
        if (r23 != null) goto L55;
        return;
    L55:
        ViewGroup r24 = this.k;
        if (r24 == null) goto L58;
        r5 = r24.getContext();
    L58:
        String r25 = r23.getSchema();
        if (r5 == null) goto L122;
        if (r25 == null) goto L123;
        this.c.openSchema(r25);
        c(TopRightControlsComponent$handlerMallWithMeta$1$1.INSTANCE);
        return;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L63:
        if (r4.equals("action_search") == false) goto L125;
        AnchorV3SearchEditView r26 = this.i;
        if (r26 == null) goto L126;
        r26.a(r53);
        return;
    L126:
        return;
    L125:
        return;
    L68:
        if (r4.equals("action_report") == false) goto L128;
        ViewGroup r27 = this.k;
        if (r27 != null) goto L72;
        return;
    L72:
        if (r27.getContext() == null) goto L130;
        a0 r28 = this.c;
        TopRightControlsVO r29 = this.a;
        if (r29 == null) goto L80;
        TopRightControlsMeta r30 = r29.getTopRightMeta();
        if (r30 == null) goto L80;
        h0 r31 = r30.getReportMeta();
        if (r31 == null) goto L80;
        r5 = r31.a();
    L80:
        r28.openSchema(r5);
        c(TopRightControlsComponent$handleActionToHub$1$1.INSTANCE);
        return;
    L130:
        return;
    L128:
        return;
    L82:
        if (r4.equals("action_im") == false) goto L132;
        final a0 r32 = this.c;
        CommonMeta r33 = r32.a();
        TopRightControlsVO r34 = this.a;
        if (r34 == null) goto L88;
        TopRightControlsMeta r35 = r34.getTopRightMeta();
        if (r35 == null) goto L88;
        r5 = r35.getImMeta();
    L88:
        if (r5 == null) goto L133;
        IMMeta r36 = r5.fillCommonMeta(r33);
        if (r36 != null) goto L93;
        return;
    L93:
        if (com.bytedance.android.ec.core.opt.ab.u.c() != 1) goto L99;
        String r37 = r36.getImUrl();
        if (r37 == null) goto L134;
        int r38 = ECSdk.a;
        IShoppingAbilities r39 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r39 == null) goto L135;
        r39.openIM(r53.getContext(), new df.m(r37, r53, "a1.b8094.c9263.d197106"), new df.l(r36.getPromotionSource(), r36.getSourcePage(), r36.getEnterMethod()), new TopRightControlsComponent$handleIMWithMeta$$inlined$let$lambda$1(this, r53, r32));
        return;
    L135:
        return;
    L134:
        return;
    L99:
        new IMComponent(r32, r53, r36, "a1.b8094.c9263.d197106").b();
        return;
    L133:
        return;
    L132:
        return;
    L101:
        if (r4.equals("action_collect") == false) goto L138;
        CollectMeta r40 = r3.getCollectMeta();
        if (r40 != null) goto L105;
        return;
    L105:
        Set r41 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.c r42 = ECProcessMonitor.c("ec_product_detail", "collect");
        int r43 = i0.a;
        String r44 = i0.b(this.c.b());
        if (r44 != null) goto L108;
        r44 = "";
    L108:
        r42.f(MapsKt.mapOf(TuplesKt.to("product_type", r44)));
        TagsScrollBoxComponentView r110 = this.h;
        TagsScrollBoxComponentView r45 = this.e;
        TagsScrollBoxComponentView r46 = this.f;
        CommonMeta r111 = this.c.a();
        com.bytedance.android.shopping.anchorv4.bottom.x r112 = new com.bytedance.android.shopping.anchorv4.bottom.x(r6, r8, this.c.compositeDisposable(), r55);
        CollectMeta r47 = r40.fillCommonMeta(r111);
        if (r47 == null) goto L144;
        new com.bytedance.android.shopping.anchorv4.bottom.v(new TopRightControlsComponent$handleFavouriteWithMeta$1(this), r53.getContext(), r110, r45, r46, r47, r112, null).a();
        b(false, r47.getCollected());
        return;
    L144:
        return;
    L138:
        return;
    L140:
        return;
    L139:
        return;
    }

    public TopRightControlsComponent(TopNavigationComponentV1$dependency$1 r2, ViewGroup r3, TagsScrollBoxComponentView r4, TagsScrollBoxComponentView r5, ViewGroup r6, TagsScrollBoxComponentView r7, AnchorV4SearchEditView r8, TextView r9, ViewGroup r10, Lifecycle r11) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
    }
}
