package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0012H\u0007J\b\u0010*\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000bH\u0002J(\u00100\u001a\u0002012\u0006\u0010\u0003\u001a\u00020!2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010)\u001a\u00020\u0012H\u0002J\"\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u00109\u001a\u00020#2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u00109\u001a\u00020#H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIButtonGroupUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "segmentedView", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "actionGroupView", "Lcom/obric/oui/button/OButtonGroup;", "optionsJson", "Lorg/json/JSONObject;", "titlesCache", "", "", "selectedIndex", "", "defaultBarColor", "Ljava/lang/Integer;", "defaultIndicatorColor", "defaultSelectedTextColor", "defaultUnselectedTextColor", "barColorOverride", "indicatorColorOverride", "selectedTextColorOverride", "unselectedTextColorOverride", "originalIndicatorColor", "originalSelectedTextColor", "suppressEvent", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setSelectedIndex", "index", MapMonitorConst.EVENT_DESTROY, "renderActionButtonGroup", "json", "attachSegmentedView", "attachActionGroupView", "group", "createActionGroupItemView", "Landroid/view/View;", "groupAppearance", "Lcom/obric/miniapp/lynx/MiniAppButtonAppearance;", MapController.ITEM_LAYER_TAG, "Lcom/obric/miniapp/lynx/MiniAppButtonGroupItem;", "sendEvent", "type", "title", "applyButtonGroupAppearance", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIButtonGroupUI extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f397870q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f397871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTabSegmentedLayout f397872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f397873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f397874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f397875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f397876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f397877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f397878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f397879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f397880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f397881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f397882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f397883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f397884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f397885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f397886p;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.f397871a = null;
        this.f397872b = null;
        super.destroy();
    }

    public LynxOUIButtonGroupUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397874d = CollectionsKt.emptyList();
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        r101.setMinimumHeight(o1.t(r100, 52));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        Object r102 = null;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.miniapp_oui_button_group, null, false);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout");
        OTabSegmentedLayout r104 = (OTabSegmentedLayout) r103;
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setOnTabSelectListener(new y1(this));
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        Field r106 = OTabSegmentedLayout.class.getDeclaredField("mBarColor");     // Catch: Throwable -> L5
        r106.setAccessible(true);     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(r106.getInt(r104)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r107) == true) goto L11;
        r102 = r107;
    L11:
        this.f397876f = (Integer) r102;
        this.f397877g = r104.getIndicatorColor();
        this.f397884n = r104.getIndicatorColor();
        this.f397878h = r104.getTextSelectColor();
        this.f397885o = r104.getTextSelectColor();
        this.f397879i = r104.getTextUnselectColor();
        this.f397871a = r101;
        this.f397872b = r104;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, o1.t(r100, 44));
        r108.gravity = 17;
        Unit r109 = Unit.INSTANCE;
        r101.addView(r104, r108);
        return r101;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v67, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.view.View, android.widget.Button, com.obric.oui.button.OButton] */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.obric.oui.button.OIconButton] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OButtonGroup] */
    @LynxProp(name = "options")
    public final void setOptions(String r210) {
        JSONObject r100 = o1.G(r210);
        this.f397873c = r100;
        OTabSegmentedLayout r101 = this.f397872b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        boolean r102 = true;
        Object r103 = null;
        if (r100.optBoolean("selectable", true) == true) goto L68;
        FrameLayout r104 = this.f397871a;
        if (r104 == null) goto L158;
        List r105 = o1.h(r104.getContext(), r100);
        List r106 = r105;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        r110.add(((r4) r107.next()).f398269a);
        goto L14
    L16:
        this.f397874d = r110;
        r104.removeAllViews();
        if (r105.isEmpty() == true) goto L159;
        ?? r108 = new OButtonGroup(r104.getContext(), null, 0, 14);
        q4 r109 = o1.g(r100, r104.getContext());
        Iterator r111 = r105.iterator();
        final int r112 = 0;
    L21:
        if (r111.hasNext() == false) goto L57;
        Object r113 = r111.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        final r4 r115 = (r4) r113;
        Context r116 = r104.getContext();
        q4 r117 = o1.e(r109, o1.g(r115.f398273e, r116));
        if (StringsKt.isBlank(r115.f398269a) == false) goto L37;
        ?? r118 = o1.c(r116, r117);
        Drawable r119 = o1.q(r118.getBackground());
        ColorStateList r120 = r118.getImageTintList();
        Integer r121 = o1.k(r117, r115.f398272d, o1.K(r117, r115.f398272d, ColorProtector.parseColor("#1F2329")));
        r118.setImageDrawable(o1.q(r115.f398270b));
        boolean r122 = r115.f398272d;
        Float r123 = r117.f398247b;
        if (r123 == null) goto L30;
        float r124 = r123.floatValue();
    L31:
        r118.setBackground(o1.j(r116, r117, r122, r119, r124));
        if (r121 == null) goto L35;
        ColorStateList r125 = ColorStateList.valueOf(r121.intValue());
        if (r125 == null) goto L35;
    L36:
        r118.setImageTintList(r125);
        o1.b(r118, r117);
        r118.setEnabled(r115.f398272d ^ r102);
        r118.setOnClickListener(new w1(this, r112));
        Object r126 = null;
    L56:
        r108.D(r118, new ViewGroup.MarginLayoutParams(-2, -2));
        r103 = r126;
        r112 = r114;
        r104 = r104;
        r109 = r109;
        r102 = true;
    L35:
        r125 = r120;
        goto L36
    L30:
        r124 = 12.0f;
        goto L31
    L37:
        r118 = o1.d(r116);
        Drawable r127 = o1.q(r118.getBackground());
        ColorStateList r128 = r118.getTextColors();
        int r129 = o1.K(r117, r115.f398272d, r118.getCurrentTextColor());
        Integer r130 = o1.k(r117, r115.f398272d, r129);
        Drawable r131 = o1.n(r115.f398270b, r130);
        Drawable r132 = o1.n(r115.f398271c, r130);
        r118.setText(r115.f398269a);
        r126 = null;
        r118.setCompoundDrawablesRelativeWithIntrinsicBounds(r131, null, r132, null);
        if (r131 != null) goto L42;
        if (r132 != null) goto L42;
        int r133 = 0;
    L43:
        r118.setCompoundDrawablePadding(r133);
        if (r130 == null) goto L46;
        ColorStateList r134 = ColorStateList.valueOf(r130.intValue());
    L47:
        r118.setCompoundDrawableTintList(r134);
        boolean r135 = r115.f398272d;
        Float r136 = r117.f398247b;
        if (r136 == null) goto L50;
        float r137 = r136.floatValue();
    L51:
        r118.setBackground(o1.j(r116, r117, r135, r127, r137));
        o1.p(r118, r117);
        if (o1.v(r117) == false) goto L54;
        r118.setTextColor(r129);
    L55:
        r118.setEnabled(!r115.f398272d);
        r118.setOnClickListener(new x1(this, r112, r115));
        goto L56
    L54:
        r118.setTextColor(r128);
        goto L55
    L50:
        r137 = 12.0f;
        goto L51
    L46:
        r134 = null;
    L42:
        r133 = o1.t(r116, 6);
        goto L43
    L57:
        Object r138 = r103;
        ?? r139 = this.f397871a;
        if (r139 == 0) goto L160;
        ViewParent r140 = r108.getParent();
        if ((r140 instanceof ViewGroup) == false) goto L63;
        ?? r141 = (ViewGroup) r140;
    L64:
        if (r141 == 0) goto L66;
        r141.removeView(r108);
    L66:
        r139.removeAllViews();
        FrameLayout.LayoutParams r142 = new FrameLayout.LayoutParams(-2, -2);
        r142.gravity = 17;
        Unit r143 = Unit.INSTANCE;
        r139.addView(r108, r142);
        return;
    L63:
        r141 = r138;
        goto L64
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L68:
        FrameLayout r144 = this.f397871a;
        if (r144 == null) goto L81;
        OTabSegmentedLayout r145 = this.f397872b;
        if (r145 == null) goto L81;
        ViewParent r146 = r145.getParent();
        if ((r146 instanceof ViewGroup) == false) goto L77;
        ViewGroup r147 = (ViewGroup) r146;
    L78:
        if (r147 == null) goto L80;
        r147.removeView(r145);
    L80:
        r144.removeAllViews();
        FrameLayout.LayoutParams r148 = new FrameLayout.LayoutParams(-1, o1.t(r144.getContext(), 44));
        r148.gravity = 17;
        Unit r149 = Unit.INSTANCE;
        r144.addView(r145, r148);
        r145.setVisibility(0);
        goto L81
    L77:
        r147 = null;
    L81:
        OTabSegmentedLayout r150 = this.f397872b;
        if (r150 == null) goto L84;
        Context r151 = r150.getContext();
    L85:
        this.f397880j = o1.E(o1.D(r100, new String[]{"barColor", "backgroundColor", "bar_color", "background_color"}), r151);
        this.f397881k = o1.E(o1.D(r100, new String[]{"indicatorColor", "selectedBackgroundColor", "indicator_color", "selected_background_color"}), r151);
        this.f397882l = o1.E(o1.D(r100, new String[]{"textSelectColor", "selectedTextColor", "text_select_color", "selected_text_color"}), r151);
        this.f397883m = o1.E(o1.D(r100, new String[]{"textUnselectColor", "unselectedTextColor", "text_unselect_color", "unselected_text_color"}), r151);
        OTabSegmentedLayout r152 = this.f397872b;
        if (r152 == null) goto L121;
        Integer r153 = this.f397880j;
        if (r153 != null) goto L91;
        r153 = this.f397876f;
    L91:
        if (r153 == null) goto L101;
        int r154 = r153.intValue();
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L95
        Field r156 = OTabSegmentedLayout.class.getDeclaredField("mBarColor");     // Catch: Throwable -> L95
        r156.setAccessible(true);     // Catch: Throwable -> L95
        r156.setInt(r152, r154);     // Catch: Throwable -> L95
        r152.invalidate();     // Catch: Throwable -> L95
        Object r157 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);
        if (r158 == null) goto L101;
        FLogger.f375446a.e("LynxOUIButtonGroupUI", "set segmented bar color failed", r158);
    L95:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L101:
        if (this.f397875e != (-1)) goto L107;
        r152.setIndicatorColor(0);
        Integer r160 = this.f397883m;
        if (r160 == null) goto L105;
        int r161 = r160.intValue();
    L106:
        r152.setTextSelectColor(r161);
    L116:
        Integer r162 = this.f397883m;
        if (r162 == null) goto L119;
        int r163 = r162.intValue();
    L120:
        r152.setTextUnselectColor(r163);
        goto L121
    L119:
        r163 = this.f397879i;
        goto L120
    L105:
        r161 = this.f397879i;
        goto L106
    L107:
        Integer r164 = this.f397881k;
        if (r164 == null) goto L110;
        int r165 = r164.intValue();
    L111:
        r152.setIndicatorColor(r165);
        Integer r166 = this.f397882l;
        if (r166 == null) goto L114;
        int r167 = r166.intValue();
    L115:
        r152.setTextSelectColor(r167);
        goto L116
    L114:
        r167 = this.f397878h;
        goto L115
    L110:
        r165 = this.f397877g;
    L121:
        List r168 = o1.h(r101.getContext(), r100);
        List r169 = r168;
        ArrayList r170 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r169, 10));
        Iterator r171 = r169.iterator();
    L123:
        if (r171.hasNext() == false) goto L126;
        r170.add(((r4) r171.next()).f398269a);
        goto L123
    L126:
        if (r170.isEmpty() == false) goto L129;
        this.f397874d = CollectionsKt.emptyList();
        r101.setVisibility(8);
        return;
    L129:
        this.f397874d = r170;
        r101.setVisibility(0);
        this.f397886p = true;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L139
        String[] r173 = (String[]) r170.toArray(new String[0]);     // Catch: Throwable -> L139
        List r174 = r168;     // Catch: Throwable -> L139
        ArrayList r175 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r174, 10));     // Catch: Throwable -> L139
        Iterator r176 = r174.iterator();     // Catch: Throwable -> L139
    L132:
        if (r176.hasNext() == false) goto L137;
        Object r177 = ((r4) r176.next()).f398270b;     // Catch: Throwable -> L139
        if (r177 != null) goto L136;
        r177 = new ColorDrawable(0);     // Catch: Throwable -> L139
    L136:
        r175.add(r177);     // Catch: Throwable -> L139
        goto L132
    L137:
        r101.e(r173, (Drawable[]) r175.toArray(new Drawable[0]));     // Catch: Throwable -> L139
        Object r178 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L139
    L141:
        Throwable r179 = Result.m9452exceptionOrNullimpl(r178);
        if (r179 == null) goto L144;
        FLogger.f375446a.e("LynxOUIButtonGroupUI", "set titles failed", r179);
    L144:
        this.f397886p = false;
        setSelectedIndex(r100.optInt("selectedIndex", this.f397875e));
        return;
    L139:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r178 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L141
    L84:
        r151 = null;
        goto L85
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r100) {
        OTabSegmentedLayout r101 = this.f397872b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 >= 0) goto L8;
    L9:
        r100 = -1;
    L10:
        this.f397875e = r100;
        this.f397886p = true;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L31
        if (r100 != (-1)) goto L18;
        r101.setIndicatorColor(0);     // Catch: Throwable -> L31
        r101.setTextSelectColor(r101.getTextUnselectColor());     // Catch: Throwable -> L31
        if ((!this.f397874d.isEmpty()) == true) goto L16;
    L29:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L36;
        FLogger.f375446a.e("LynxOUIButtonGroupUI", "set selected index failed", r104);
    L36:
        this.f397886p = false;
        return;
    L16:
        if (r101.getCurrentTab() >= 0) goto L29;
        r101.setCurrentTab(0);     // Catch: Throwable -> L31
        goto L29
    L18:
        Integer r105 = this.f397881k;     // Catch: Throwable -> L31
        if (r105 == null) goto L21;
        int r106 = r105.intValue();     // Catch: Throwable -> L31
    L22:
        r101.setIndicatorColor(r106);     // Catch: Throwable -> L31
        Integer r107 = this.f397882l;     // Catch: Throwable -> L31
        if (r107 == null) goto L25;
        int r108 = r107.intValue();     // Catch: Throwable -> L31
    L26:
        r101.setTextSelectColor(r108);     // Catch: Throwable -> L31
        int r109 = r101.getCurrentTab();     // Catch: Throwable -> L31
        int r110 = this.f397875e;     // Catch: Throwable -> L31
        if (r109 == r110) goto L29;
        r101.setCurrentTab(r110);     // Catch: Throwable -> L31
        goto L29
    L25:
        r108 = this.f397885o;     // Catch: Throwable -> L31
        goto L26
    L21:
        r106 = this.f397884n;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L8:
        if (r100 < this.f397874d.size()) goto L10;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        super.updatePropertiesInterval(o1.S(r110, this.f397873c, new String[]{"titles", "items", "selectedIndex", "selectable", "barColor", "backgroundColor", "indicatorColor", "selectedBackgroundColor", "textSelectColor", "selectedTextColor", "textUnselectColor", "unselectedTextColor"}, new String[]{"titles", "items"}, 2));
    }

    public final void M(int r100, String r101) {
        LynxContext r102 = getLynxContext();
        if (r102 == null) goto L12;
        EventEmitter r103 = r102.getEventEmitter();
        if (r103 == null) goto L13;
        m7a.a r104 = new m7a.a(getSign(), "change");
        r104.a("index", Integer.valueOf(r100));
        r104.a("value", Integer.valueOf(r100));
        if (r101 == null) goto L10;
        r104.a("title", r101);
    L10:
        r103.sendCustomEvent(r104);
        return;
    L13:
        return;
    }
}
