package com.ss.android.ugc.aweme.search.common.saas;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.nova.R;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\u000b\u001a\u0004\u0018\u00010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/ECSearchTopBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "rightIcon", "", "setupRightIconVisibility", "setupRightIconExposure", "Landroid/widget/TextView;", "getCenterText", "Landroid/widget/ImageView;", "getLeftIcon", "getRightIcon", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchTopBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f451984g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f451985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f451986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f451987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f451988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f451989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f451990f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/ECSearchTopBarView$Companion;", "", "()V", "APPLET_SCENE_KEY", "", "DEFAULT_SIZE", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final TextView getCenterText() {
        return this.f451986b;
    }

    public final ImageView getLeftIcon() {
        return this.f451987c;
    }

    public final ImageView getRightIcon() {
        return this.f451988d;
    }

    public static final void R5(final ECSearchTopBarView r100) {
        r100.getClass();
        final Function1<String, Unit> r101 = new ECSearchTopBarView$handleOrderClick$entranceAction$1(r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L5
        r103.put("current_page", r100.f451990f.optString("current_page"));     // Catch: Throwable -> L5
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r100.f451990f.optString(MusicAppletPage.KEY_MESSAGE_ID));     // Catch: Throwable -> L5
        r103.put("pid", r100.f451990f.optString("product_id"));     // Catch: Throwable -> L5
        r103.put("query", r100.f451990f.optString("keyword"));     // Catch: Throwable -> L5
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L5
        AppLogNewUtils.onEventV3("order_manage_click", r103);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        String r105 = r100.f451985a;
        if (r105 == null) goto L10;
        r101.invoke(r105);
        return;
    L10:
        ITradeSearchHostService r106 = TradeSearch.c(TradeSearch.f453393a);
        if (r106 == null) goto L19;
        ITradeSearchHostAbility r107 = r106.getITradeSearchHostAbility();
        if (r107 == null) goto L20;
        r107.getMallOrderEntranceSchema(new ECSearchTopBarView$handleOrderClick$2(r100, r101));
        return;
    L20:
        return;
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void setupRightIconExposure(final View r100) {
        r100.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this, r100));
    }

    private final void setupRightIconVisibility(View r100) {
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        Boolean r102 = null;
        if (r101 == null) goto L5;
        ITradeSearchHostAbility r103 = r101.getITradeSearchHostAbility();
    L6:
        if (r103 == null) goto L9;
        r102 = r103.isGuestMode();
    L9:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L11;
        r100.setVisibility(8);
        return;
    L11:
        r100.setVisibility(0);
        setupRightIconExposure(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public ECSearchTopBarView(Context r100, String r101, Function0<Unit> r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "onBackClick");
        Intrinsics.checkNotNullParameter(r111, "ecomSaasExtra");
        super(r100);
        this.f451989e = r110;
        this.f451990f = r111;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        IECAIHostService.Companion.getClass();
        boolean r102 = IECAIHostService.a.a().isInApplet();
        if (r102 != true) goto L5;
        setPadding(0, 0, 0, 0);
    L6:
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.saas_ec_search_top_bar_text);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.startToStart = 0;
        r104.endToEnd = 0;
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutParams(r104);
        if (IECAIHostService.a.a().isInApplet() != true) goto L9;
        r103.setPadding(DimenExtensionsKt.a(89), 0, DimenExtensionsKt.a(92), 0);
    L10:
        r103.setTextSize(1, 17);
        r103.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), R.color.ec_text_primary_light));
        r103.setText(r101);
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        this.f451986b = r103;
        IECAIHostService r106 = IECAIHostService.a.a();
        if (r106.isInApplet() == true) goto L13;
        Logger.a("AppletDebug", "createLeftIcon normalLeftIcon");
        ImageView r107 = new ImageView(getContext());
        r107.setId(R.id.saas_ec_search_top_bar_close);
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(-2, -2);
        r108.startToStart = 0;
        r108.topToTop = 0;
        r108.bottomToBottom = 0;
        r107.setLayoutParams(r108);
        r107.setImageResource(R.drawable.saas_ec_search_top_bar_back);
        r107.setOnClickListener(new ECSearchTopBarView$createNormalLeftIcon$$inlined$apply$lambda$1(this));
        this.f451987c = r107;
        View r109 = r107;
    L26:
        final IECAIHostService r112 = IECAIHostService.a.a();
        if (r112.isInApplet() != true) goto L40;
        Logger.a("AppletDebug", "createRightIcon capsuleComponent");
        CapsuleComponent r113 = r112.createCapsuleComponent(getContext());
        if (r113 == null) goto L31;
        r113.setScene("search_result");
    L31:
        if (r113 == null) goto L33;
        r113.setOnClickCloseListener(new ECSearchTopBarView$createRightIcon$1(r112));
    L33:
        if (r113 == null) goto L35;
        r113.setOnClickMenuListener(new ECSearchTopBarView$createRightIcon$2(this, r112));
    L35:
        if (r113 == null) goto L39;
        View r114 = r113.getView();
        if (r114 == null) goto L39;
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(-2, -2);
        r115.endToEnd = 0;
        r115.topToTop = 0;
        r115.bottomToBottom = 0;
        r114.setLayoutParams(r115);
        View r116 = r114;
    L41:
        addView(this.f451986b);
        addView(r109);
        addView(r116);
        if (r102 == true) goto L45;
        setupRightIconVisibility(r116);
        return;
    L45:
        return;
    L39:
        View r117 = new View(getContext());
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(DimenExtensionsKt.b(36), DimenExtensionsKt.b(36));
        r118.endToEnd = 0;
        r118.topToTop = 0;
        r118.bottomToBottom = 0;
        r117.setLayoutParams(r118);
        r116 = r117;
        goto L41
    L40:
        Logger.a("AppletDebug", "createRightIcon normalRightIcon");
        ImageView r119 = new ImageView(getContext());
        r119.setId(R.id.saas_ec_search_top_bar_order);
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(-2, -2);
        r120.endToEnd = 0;
        r120.topToTop = 0;
        r120.bottomToBottom = 0;
        r119.setLayoutParams(r120);
        r119.setImageResource(R.drawable.saas_ec_search_top_bar_order);
        r119.setOnClickListener(new ECSearchTopBarView$createNormalRightIcon$$inlined$apply$lambda$1(this));
        this.f451988d = r119;
        r116 = r119;
        goto L41
    L13:
        if (r106.isLandingPage() == false) goto L15;
        Logger.a("AppletDebug", "createLeftIcon isLandingPage, create emptyView");
        View r121 = new View(getContext());
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(DimenExtensionsKt.b(36), DimenExtensionsKt.b(36));
        r122.startToStart = 0;
        r122.topToTop = 0;
        r122.bottomToBottom = 0;
        r121.setLayoutParams(r122);
        r109 = r121;
        goto L26
    L15:
        Logger.a("AppletDebug", "createLeftIcon backComponent");
        BackComponent r123 = r106.createBackComponent(getContext());
        if (r123 == null) goto L18;
        r123.setOnClickListener(new ECSearchTopBarView$createLeftIcon$2(this));
    L18:
        if (r123 == null) goto L20;
        r123.setScene("search_result");
    L20:
        if (r123 == null) goto L24;
        View r124 = r123.getView();
        if (r124 == null) goto L24;
        ConstraintLayout.LayoutParams r125 = new ConstraintLayout.LayoutParams(-2, -2);
        r125.startToStart = 0;
        r125.topToTop = 0;
        r125.bottomToBottom = 0;
        r124.setLayoutParams(r125);
        r109 = r124;
    L24:
        View r126 = new View(getContext());
        ConstraintLayout.LayoutParams r127 = new ConstraintLayout.LayoutParams(DimenExtensionsKt.b(36), DimenExtensionsKt.b(36));
        r127.startToStart = 0;
        r127.topToTop = 0;
        r127.bottomToBottom = 0;
        r126.setLayoutParams(r127);
        r109 = r126;
        goto L26
    L9:
        r103.setPadding(DimenExtensionsKt.a(87), 0, DimenExtensionsKt.a(90), 0);
        goto L10
    L5:
        setPadding(0, 0, DimenExtensionsKt.a(10), 0);
        goto L6
    }
}
