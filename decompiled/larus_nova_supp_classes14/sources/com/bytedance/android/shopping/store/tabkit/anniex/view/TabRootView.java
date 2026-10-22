package com.bytedance.android.shopping.store.tabkit.anniex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.DeviceUtil;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.component.TabHybridComponent;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.q;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import hk3.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020!¢\u0006\u0004\b8\u00109R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/anniex/view/TabRootView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/store/tabkit/anniex/TabKitAnnieXTabFragment;", "a", "Lcom/bytedance/android/shopping/store/tabkit/anniex/TabKitAnnieXTabFragment;", "getTabFragment", "()Lcom/bytedance/android/shopping/store/tabkit/anniex/TabKitAnnieXTabFragment;", "setTabFragment", "(Lcom/bytedance/android/shopping/store/tabkit/anniex/TabKitAnnieXTabFragment;)V", "tabFragment", "b", "Landroid/widget/FrameLayout;", "getTitleContainer", "()Landroid/widget/FrameLayout;", "setTitleContainer", "(Landroid/widget/FrameLayout;)V", "titleContainer", "", "c", "Z", "getShowTitle", "()Z", "setShowTitle", "(Z)V", "showTitle", "Lcom/bytedance/android/ec/core/widget/StatusView;", "d", "Lcom/bytedance/android/ec/core/widget/StatusView;", "getStatusView", "()Lcom/bytedance/android/ec/core/widget/StatusView;", "setStatusView", "(Lcom/bytedance/android/ec/core/widget/StatusView;)V", "statusView", "", "f", "Lkotlin/Lazy;", "getStatusBarHeight", "()I", "statusBarHeight", "Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "getTabKitViewModel", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "tabKitViewModel", "Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;", "getComponent", "()Lcom/bytedance/android/shopping/store/tabkit/anniex/component/TabHybridComponent;", "component", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabRootView extends FrameLayout {
    public TabKitAnnieXTabFragment a;
    public FrameLayout b;
    public boolean c;
    public StatusView d;
    public TopTabItemView e;
    public final Lazy f;

    public TabRootView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TabRootView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getStatusBarHeight() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final TabHybridComponent getComponent() {
        TabKitAnnieXTabFragment r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridComponent();
    }

    private final k getTab() {
        TabKitAnnieXTabFragment r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTab();
    }

    private final TabKitViewModel getTabKitViewModel() {
        TabKitAnnieXTabFragment r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTabKitViewModel();
    }

    public final void d() {
        TabKitAnnieXTabFragment r0 = this.a;
        if (r0 == null) goto L28;
        LifecycleOwner r1 = r0.getViewLifecycleOwner();
        if (r1 == null) goto L31;
        TabKitViewModel r2 = getTabKitViewModel();
        if (r2 == null) goto L12;
        MutableLiveData<Float> r3 = r2.getScreenOffsetFactor();
        if (r3 == null) goto L12;
        r3.observe(r1, new TabRootView$initObserver$1(this));
    L12:
        TabKitViewModel r4 = getTabKitViewModel();
        if (r4 == null) goto L17;
        MutableLiveData<y> r5 = r4.getCurrentTab();
        if (r5 == null) goto L17;
        r5.observe(r1, new TabRootView$initObserver$2(this));
    L17:
        TabKitViewModel r6 = getTabKitViewModel();
        if (r6 == null) goto L22;
        MutableLiveData<Integer> r7 = r6.getScreenState();
        if (r7 == null) goto L22;
        r7.observe(r1, new TabRootView$initObserver$3(this));
    L22:
        TabKitViewModel r8 = getTabKitViewModel();
        if (r8 == null) goto L29;
        MutableLiveData<Boolean> r9 = r8.isUseNativeTopBar();
        if (r9 == null) goto L30;
        r9.observe(r1, new TabRootView$initObserver$4(this));
        return;
    L30:
        return;
    L29:
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        k r0 = getTab();
        int r1 = 6;
        String r4 = null;
        int r6 = 0;
        if (r0 == null) goto L205;
        s r2 = r0.f();
        if (r2 == null) goto L205;
        String r3 = r2.b();
        if (r3 == null) goto L205;
        int r7 = a.a;
        int r8 = com.bytedance.android.ec.base.settings.a.a;
        Object r9 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L170
        Object r11 = d.c.get("ec_tabkit_error_show_opt");     // Catch: Throwable -> L63
        if (r11 != null) goto L15;
    L60:
        Object r12 = null;
    L61:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L63
    L65:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L170
        if (r14 == null) goto L69;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L170
    L69:
        if (Result.isFailure-impl(r13) == false) goto L72;
        r13 = null;
    L72:
        if ((r13 instanceof Boolean) == true) goto L74;
        r13 = null;
    L74:
        Object r15 = (Boolean) r13;     // Catch: Throwable -> L170
        if (r15 != null) goto L81;
        Object r16 = d.a.get("ec_tabkit_error_show_opt");     // Catch: Throwable -> L170
        if ((r16 instanceof Boolean) == true) goto L80;
        r16 = null;
    L80:
        r15 = (Boolean) r16;     // Catch: Throwable -> L170
    L81:
        if (r15 != null) goto L180;
        int r17 = c.a;     // Catch: Throwable -> L170
        Object r18 = d.c.get("ec_tabkit_error_show_opt");     // Catch: Throwable -> L136
        if (r18 != null) goto L88;
    L133:
        Object r19 = null;
    L134:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L136
    L138:
        Throwable r110 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L161
        if (r110 == null) goto L142;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L161
    L142:
        if (Result.isFailure-impl(r20) == false) goto L145;
        r20 = null;
    L145:
        if ((r20 instanceof Boolean) == true) goto L147;
        r20 = null;
    L147:
        r15 = (Boolean) r20;     // Catch: Throwable -> L161
        if (r15 != null) goto L168;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L161
        if (r21 == null) goto L153;
        Object r22 = r21.getHostABValue("ec_tabkit_error_show_opt", r9);     // Catch: Throwable -> L161
    L154:
        if (r22 != null) goto L156;
    L167:
        r15 = r9;
        goto L168
    L156:
        if ((r22 instanceof Boolean) == true) goto L158;
        r22 = null;
    L158:
        r15 = (Boolean) r22;     // Catch: Throwable -> L161
        if (r15 != null) goto L168;
    L161:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L170
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r112 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L170
        if (r112 == null) goto L166;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L170
    L166:
        if (Result.isFailure-impl(r15) == false) goto L168;
    L153:
        r22 = null;
    L168:
        d.d("ec_tabkit_error_show_opt", r15);     // Catch: Throwable -> L170
        goto L180
    L88:
        if ((r18 instanceof Boolean) == true) goto L90;
        Object r113 = null;
    L91:
        r19 = (Boolean) r113;     // Catch: Throwable -> L136
        if (r19 != null) goto L134;
        if ((r18 instanceof Number) == false) goto L121;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L103;
        Float r23 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L136
        if ((r23 instanceof Boolean) == true) goto L101;
        r23 = null;
    L101:
        r19 = (Boolean) r23;     // Catch: Throwable -> L136
        goto L134
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L109;
        Double r24 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L136
        if ((r24 instanceof Boolean) == true) goto L107;
        r24 = null;
    L107:
        r19 = (Boolean) r24;     // Catch: Throwable -> L136
        goto L134
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L115;
        Integer r25 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L136
        if ((r25 instanceof Boolean) == true) goto L113;
        r25 = null;
    L113:
        r19 = (Boolean) r25;     // Catch: Throwable -> L136
        goto L134
    L115:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L121;
        Long r26 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L136
        if ((r26 instanceof Boolean) == true) goto L119;
        r26 = null;
    L119:
        r19 = (Boolean) r26;     // Catch: Throwable -> L136
    L121:
        if ((r18 instanceof JSONObject) == false) goto L123;
    L242:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L129
        Object r27 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Boolean.class);     // Catch: Throwable -> L129
        if ((r27 instanceof Boolean) == true) goto L127;
        r27 = null;
    L127:
        Object r28 = Result.constructor-impl((Boolean) r27);     // Catch: Throwable -> L129
    L131:
        r19 = r28;
        if (Result.isFailure-impl(r19) == false) goto L134;
    L129:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L136
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L136
        goto L131
    L123:
        if ((r18 instanceof JSONArray) == false) goto L133;
    L90:
        r113 = r18;
    L136:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L161
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L180:
        if (((Boolean) r15).booleanValue() == true) goto L204;
        Intrinsics.checkNotNullParameter(r3, "$this$safeGetQueryParameter");
        Intrinsics.checkNotNullParameter("ec_ssr_request_id", "key");
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r3), "ec_ssr_request_id");     // Catch: Throwable -> L190
        if (r5 != null) goto L185;
    L187:
        r5 = null;
    L188:
        Object r29 = Result.constructor-impl(r5);     // Catch: Throwable -> L190
    L193:
        if (Result.isFailure-impl(r29) == false) goto L195;
        r29 = null;
    L195:
        String r30 = (String) r29;
        if (r30 != null) goto L198;
    L201:
        boolean r31 = true;
    L202:
        if (r31 == false) goto L204;
    L198:
        if (StringsKt.isBlank(r30) == true) goto L201;
        r31 = false;
        goto L202
    L185:
        if ((!StringsKt.isBlank(r5)) == false) goto L187;
    L190:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
    L204:
        StatusView r33 = new StatusView(getContext(), null, 6, 0);
        View r34 = th.a.c(r33.getContext(), 2131560977, r33, false);
        FrameLayout.LayoutParams r35 = new FrameLayout.LayoutParams(-2, -2);
        r35.gravity = 17;
        Unit r36 = Unit.INSTANCE;
        r34.setLayoutParams(r35);
        r33.b(null, r34, true);
        r33.showLoading();
        f.a(this, r33);
        this.d = r33;
        goto L205
    L15:
        if ((r11 instanceof Boolean) == true) goto L17;
        Object r116 = null;
    L18:
        r12 = (Boolean) r116;     // Catch: Throwable -> L63
        if (r12 != null) goto L61;
        if ((r11 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r37 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L63
        if ((r37 instanceof Boolean) == true) goto L28;
        r37 = null;
    L28:
        r12 = (Boolean) r37;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r38 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L63
        if ((r38 instanceof Boolean) == true) goto L34;
        r38 = null;
    L34:
        r12 = (Boolean) r38;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r39 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L63
        if ((r39 instanceof Boolean) == true) goto L40;
        r39 = null;
    L40:
        r12 = (Boolean) r39;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r40 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L63
        if ((r40 instanceof Boolean) == true) goto L46;
        r40 = null;
    L46:
        r12 = (Boolean) r40;     // Catch: Throwable -> L63
    L48:
        if ((r11 instanceof JSONObject) == false) goto L50;
    L250:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L56
        Object r41 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Boolean.class);     // Catch: Throwable -> L56
        if ((r41 instanceof Boolean) == true) goto L54;
        r41 = null;
    L54:
        Object r42 = Result.constructor-impl((Boolean) r41);     // Catch: Throwable -> L56
    L58:
        r12 = r42;
        if (Result.isFailure-impl(r12) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L63
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r11 instanceof JSONArray) == false) goto L60;
    L17:
        r116 = r11;
    L63:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L170
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Object r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L175;
        EnsureManager.ensureNotReachHere(r45);
    L175:
        if (Result.isFailure-impl(r44) == true) goto L178;
        r9 = r44;
    L178:
        r15 = r9;
    L205:
        TabKitViewModel r46 = getTabKitViewModel();
        if (r46 == null) goto L217;
        TabKitAnnieXTabFragment r47 = this.a;
        if (r47 == null) goto L217;
        if (this.c == false) goto L217;
        TopTabItemView r48 = new TopTabItemView(getContext(), null == true ? 1 : 0, r1, r6);
        r48.setEnableImageIcon(false);
        FrameLayout.LayoutParams r49 = new FrameLayout.LayoutParams(-2, -2);
        r49.gravity = 17;
        Unit r50 = Unit.INSTANCE;
        r48.setLayoutParams(r49);
        r48.setTab(r47.getTab());
        r48.setSelected(true);
        this.e = r48;
        f();
        FrameLayout r51 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r52 = new FrameLayout.LayoutParams(-2, b.b(44));
        r52.gravity = 49;
        if (r46.isFullScreen() == false) goto L216;
        r52.setMargins(r52.leftMargin, getStatusBarHeight(), r52.rightMargin, r52.bottomMargin);
    L216:
        r51.setLayoutParams(r52);
        r51.addView(this.e);
        this.b = r51;
        addView(r51);
    L217:
        TabKitViewModel r53 = getTabKitViewModel();
        if (r53 == null) goto L256;
        k r54 = getTab();
        if (r54 == null) goto L223;
        Integer r55 = r54.n();
    L225:
        if (Intrinsics.areEqual(r55, r53.getRouterParams().getAnchorTabId()) == false) goto L231;
        k r56 = getTab();
        if (r56 == null) goto L230;
        r4 = r56.e();
        if (r4 == null) goto L230;
    L234:
        Integer r57 = com.bytedance.android.ec.core.utils.s.b(r4);
        if (r57 == null) goto L254;
        int r58 = r57.intValue();
        View r59 = getRootView();
        if (r59 == null) goto L255;
        r59.setBackgroundColor(r58);
        return;
    L255:
        return;
    L254:
        return;
    L230:
        r4 = r53.getRouterParams().getAnchorBGColor();
        goto L234
    L231:
        k r60 = getTab();
        if (r60 == null) goto L234;
        r4 = r60.e();
        goto L234
    L223:
        r55 = null;
        goto L225
    }

    public final void f() {
        TabKitViewModel r0 = getTabKitViewModel();
        if (r0 != null) goto L5;
        return;
    L5:
        TabKitAnnieXTabFragment r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        Boolean r2 = (Boolean) r0.isUseNativeTopBar().getValue();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L64;
        k r4 = getTab();
        Integer r5 = null;
        if (r4 == null) goto L15;
        q r6 = r4.p();
        if (r6 == null) goto L15;
        p r7 = e.o(r6, getTabKitViewModel());
    L16:
        TopTabItemView r8 = this.e;
        if (r8 == null) goto L19;
        r8.setTabBarStyleConfig(r7);
    L19:
        TopTabItemView r9 = this.e;
        if (r9 == null) goto L22;
        r9.setFullScreenState(r0.isFullScreen());
    L22:
        if (r7 == null) goto L24;
        Integer r10 = r7.c();
    L26:
        if (r10 != null) goto L29;
    L33:
        if (r10 != null) goto L36;
    L40:
        FrameLayout r11 = this.b;
        if (r11 == null) goto L43;
        r11.setVisibility(0);
    L43:
        com.bytedance.android.shopping.store.tabkit.model.d r12 = r0.getTopTabBarVisibilityMap().get(getTab());
        if (r0.isFullScreen() == true) goto L47;
        if (r12 == null) goto L49;
        Boolean r13 = r12.a;
    L51:
        if (Intrinsics.areEqual(r13, r3) == false) goto L56;
        FrameLayout r14 = this.b;
        if (r14 == null) goto L60;
        r14.setVisibility(0);
    L60:
        FrameLayout r15 = this.b;
        if (r7 == null) goto L63;
        r5 = r7.a();
    L63:
        e.b(r15, r5, r1.getTabKitFragment().Mc().k, r1.getTabKitFragment().Mc().j);
        return;
    L56:
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L60;
        FrameLayout r16 = this.b;
        if (r16 == null) goto L60;
        ExtensionsKt.gone(r16);
    L49:
        r13 = null;
        goto L51
    L47:
        if (r12 == null) goto L49;
        r13 = r12.b;
        goto L51
    L36:
        if (r10.intValue() != 1) goto L40;
        FrameLayout r17 = this.b;
        if (r17 == null) goto L43;
        r17.setVisibility(0);
        goto L43
    L29:
        if (r10.intValue() != 2) goto L33;
        FrameLayout r18 = this.b;
        if (r18 == null) goto L43;
        ExtensionsKt.gone(r18);
        goto L43
    L24:
        r10 = null;
    L15:
        r7 = null;
        goto L16
    L64:
        FrameLayout r19 = this.b;
        if (r19 == null) goto L69;
        ExtensionsKt.gone(r19);
        return;
    }

    public final boolean getShowTitle() {
        return this.c;
    }

    public final StatusView getStatusView() {
        return this.d;
    }

    public final TabKitAnnieXTabFragment getTabFragment() {
        return this.a;
    }

    public final FrameLayout getTitleContainer() {
        return this.b;
    }

    public static final /* synthetic */ TabHybridComponent a(TabRootView r0) {
        return r0.getComponent();
    }

    public static final /* synthetic */ int b(TabRootView r0) {
        return r0.getStatusBarHeight();
    }

    public static final /* synthetic */ k c(TabRootView r0) {
        return r0.getTab();
    }

    public final void setShowTitle(boolean r1) {
        this.c = r1;
    }

    public final void setStatusView(StatusView r1) {
        this.d = r1;
    }

    public final void setTabFragment(TabKitAnnieXTabFragment r1) {
        this.a = r1;
    }

    public final void setTitleContainer(FrameLayout r1) {
        this.b = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (((Boolean) DeviceUtil.a.getValue()).booleanValue() == false) goto L8;
        TabHybridComponent r3 = getComponent();
        if (r3 == null) goto L9;
        getMeasuredWidth();
        getMeasuredHeight();
        r3.b();
        return;
    L9:
        return;
    }

    public TabRootView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = LazyKt.lazy(new TabRootView$statusBarHeight$2(r2));
    }

    public /* synthetic */ TabRootView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
