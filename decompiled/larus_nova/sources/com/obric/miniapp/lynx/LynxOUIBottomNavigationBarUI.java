package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.segmentedtab.ONaviIndicatorDrawable;
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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001fH\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020-H\u0002J\"\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIBottomNavigationBarUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "bottomNav", "Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "optionsJson", "Lorg/json/JSONObject;", "titlesCache", "", "", "itemsSignatureCache", "suppressEvent", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setSelectedIndex", "index", "", MapMonitorConst.EVENT_DESTROY, "clearBottomNavigationSelfClip", "view", "Landroid/view/View;", "ensureBottomNavigationIndicatorTracksLayout", "actionBar", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "requestBottomNavigationIndicatorRecalc", "async", "syncBottomNavigationTabVisualState", "cancelBottomNavigationTabAnimation", "tabView", "resolveBottomNavigationTabTypeface", "Landroid/graphics/Typeface;", "originTypeface", "isSelected", "findBottomNavigationIndicatorDrawable", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "resolveBottomNavigationIndicatorTop", "", "cancelBottomNavigationIndicatorAnimation", "indicatorDrawable", "sendEvent", "type", "title", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIBottomNavigationBarUI extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f397864f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OBottomNavigationBar f397865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f397866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f397867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f397868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f397869e;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.f397865a = null;
        this.f397868d = null;
        super.destroy();
    }

    public LynxOUIBottomNavigationBarUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397867c = CollectionsKt.emptyList();
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    public static void M(ONaviIndicatorDrawable r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Field r102 = ONaviIndicatorDrawable.class.getDeclaredField("positionAnimator");     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r102.get(r100));     // Catch: Throwable -> L5
    L7:
        Object r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L42;
        Object r105 = Result.m9449constructorimpl(r103.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r103, new Object[0]));     // Catch: Throwable -> L14
    L16:
        Result.m9448boximpl(r105);
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L42:
        Field r107 = ONaviIndicatorDrawable.class.getDeclaredField("sizeAnimator");     // Catch: Throwable -> L19
        r107.setAccessible(true);     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl(r107.get(r100));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r108) == true) goto L25;
        r104 = r108;
    L25:
        if (r104 != null) goto L38;
    L36:
        Field r109 = ONaviIndicatorDrawable.class.getDeclaredField("isAnimRunning");     // Catch: Throwable -> L33
        r109.setAccessible(true);     // Catch: Throwable -> L33
        r109.setBoolean(r100, false);     // Catch: Throwable -> L33
        Result.m9449constructorimpl(r109);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L38:
        Object r111 = Result.m9449constructorimpl(r104.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r104, new Object[0]));     // Catch: Throwable -> L28
    L30:
        Result.m9448boximpl(r111);
    L28:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static float O(OBottomNavActionBar r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Field r102 = OBottomNavActionBar.class.getDeclaredField("indicatorSpacing");     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Float.valueOf(r102.getInt(r100)));     // Catch: Throwable -> L5
    L7:
        Float r104 = Float.valueOf(0.0f);
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = r104;
    L10:
        float r105 = ((Number) r103).floatValue();
        Field r106 = OBottomNavActionBar.class.getDeclaredField("mBarStrokeWidth");     // Catch: Throwable -> L13
        r106.setAccessible(true);     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(Float.valueOf(r106.getFloat(r100)));     // Catch: Throwable -> L13
    L15:
        Float r108 = Float.valueOf(0.0f);
        if (Result.m9455isFailureimpl(r107) == false) goto L19;
        r107 = r108;
    L19:
        return r105 + ((Number) r107).floatValue();
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void P(OBottomNavActionBar r110) {
        int r100 = r110.getCurrentTab();
        Iterator<T> r101 = r110.getTabList().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L33;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r105 = (View) r103;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        Result.m9449constructorimpl(r105.getClass().getMethod("cancelAnim", new Class[0]).invoke(r105, new Object[0]));     // Catch: Throwable -> L11
    L13:
        if (r102 != r100) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        int r108 = r110.getTextSelectColor();
    L19:
        r105.setSelected(r107);
        TextView r109 = (TextView) r105.findViewById(R.id.tv_tab_title);
        if (r109 == null) goto L29;
        r109.setTextColor(r108);
        Typeface r111 = r109.getTypeface();
        if (r107 == false) goto L28;
        if (r111 == null) goto L28;
        if (Build.VERSION.SDK_INT < 28) goto L28;
        r111 = Typeface.create(r111, 500, false);
    L28:
        r109.setTypeface(r111);
    L29:
        ImageView r112 = (ImageView) r105.findViewById(R.id.tv_tab_icon);
        if (r112 == null) goto L32;
        r112.setImageTintList(ColorStateList.valueOf(r108));
        r112.setImageAlpha(255);
    L32:
        r102 = r104;
        goto L4
    L18:
        r108 = r110.getTextUnselectColor();
        goto L19
    L15:
        r107 = false;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.miniapp.lynx.s1] */
    public final void N(final OBottomNavActionBar r100) {
        final ?? r101 = new s1(this, r100);
        r100.post(new t1(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.obric.miniapp.lynx.r1] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i4 r101 = new i4(r100);
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.miniapp_oui_bottom_navigation_bar, null, false);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OBottomNavigationBar");
        OBottomNavigationBar r103 = (OBottomNavigationBar) r102;
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r103.setChangeAlphaWhenPress(false);
        r103.setChangeAlphaWhenDisable(false);
        r103.setDuplicateParentStateEnabled(false);
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        final OBottomNavActionBar r104 = r103.getNavigationBar();
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setOnTabSelectListener(new u1(this, r104));
        final Ref.ObjectRef r105 = new Ref.ObjectRef();
        r104.addOnLayoutChangeListener(new q1(this, r104));
        ?? r106 = new r1(r104, r105, this);
        r104.addOnAttachStateChangeListener(new v1(r104, r106));
        if (r104.isAttachedToWindow() == true) goto L5;
    L7:
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        r103.setClipToOutline(false);
        this.f397865a = r103;
        r101.addView(r103);
        return r101;
    L5:
        if (r104.getViewTreeObserver().isAlive() == false) goto L7;
        r104.getViewTreeObserver().addOnPreDrawListener(r106);
        goto L7
    }

    @LynxProp(name = "options")
    public final void setOptions(String r110) {
        JSONObject r100 = o1.G(r110);
        this.f397866b = r100;
        OBottomNavigationBar r101 = this.f397865a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        JSONArray r102 = r100.optJSONArray("items");
        if (r102 != null) goto L15;
        r102 = r100.optJSONArray("tabs");
        if (r102 != null) goto L15;
        r102 = r100.optJSONArray("list");
        if (r102 != null) goto L15;
        r102 = new JSONArray();
    L15:
        if (r102.length() > 0) goto L18;
        this.f397867c = CollectionsKt.emptyList();
        this.f397868d = null;
        return;
    L18:
        String r103 = r102.toString();
        boolean r104 = !Intrinsics.areEqual(r103, this.f397868d);
        ArrayList r105 = new ArrayList(r102.length());
        if (r104 == false) goto L21;
        ArrayList r106 = new ArrayList(r102.length());
    L22:
        int r111 = r102.length();
        int r112 = 0;
        boolean r113 = false;
    L23:
        if (r112 >= r111) goto L47;
        JSONObject r114 = r102.optJSONObject(r112);
        if (r114 == null) goto L28;
        String r107 = o1.C(r114, new String[]{"title", "label", "text", "name"});
        if (r107 == null) goto L28;
    L34:
        r105.add(r107);
        if (r104 == false) goto L46;
        Context r108 = r101.getContext();
        if (r114 != null) goto L39;
        r114 = new JSONObject();
    L39:
        Object r109 = o1.N(r108, r114);
        if (r109 == null) goto L42;
        r113 = true;
    L42:
        if (r106 == null) goto L46;
        if (r109 != null) goto L45;
        r109 = new ColorDrawable(0);
    L45:
        r106.add(r109);
    L46:
        r112 = r112 + 1;
    L28:
        r107 = r102.optString(r112);
        Intrinsics.checkNotNull(r107);
        if ((!StringsKt.isBlank(r107)) == true) goto L32;
        r107 = null;
    L32:
        if (r107 != null) goto L34;
        r107 = "";
        goto L34
    L47:
        this.f397869e = true;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L63
        if (r104 == false) goto L56;
        OBottomNavActionBar r116 = r101.getNavigationBar();     // Catch: Throwable -> L63
        String[] r117 = (String[]) r105.toArray(new String[0]);     // Catch: Throwable -> L63
        if (r113 == false) goto L54;
        if (r106 == null) goto L54;
        Drawable[] r118 = (Drawable[]) r106.toArray(new Drawable[0]);     // Catch: Throwable -> L63
    L55:
        r116.h(r117, r118);     // Catch: Throwable -> L63
    L54:
        r118 = null;
    L56:
        int r119 = RangesKt.coerceIn(r100.optInt("selectedIndex", 0), 0, RangesKt.coerceAtLeast(r105.size() - 1, 0));     // Catch: Throwable -> L63
        if (r104 == false) goto L59;
    L60:
        r101.getNavigationBar().setCurrentTab(r119);     // Catch: Throwable -> L63
    L61:
        N(r101.getNavigationBar());     // Catch: Throwable -> L63
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L65:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L68;
        FLogger.f375446a.e("LynxOUIBottomNavigationBarUI", "setOptions failed", r121);
    L68:
        this.f397869e = false;
        this.f397867c = r105;
        this.f397868d = r103;
        return;
    L59:
        if (r101.getNavigationBar().getCurrentTab() == r119) goto L61;
    L63:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L65
    L21:
        r106 = null;
        goto L22
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r100) {
        OBottomNavigationBar r101 = this.f397865a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 >= 0) goto L7;
        return;
    L7:
        if (r100 >= this.f397867c.size()) goto L19;
        this.f397869e = true;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        r101.getNavigationBar().setCurrentTab(r100);     // Catch: Throwable -> L12
        N(r101.getNavigationBar());     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        this.f397869e = false;
        return;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.updatePropertiesInterval(o1.S(r100, this.f397866b, new String[]{"items", "tabs", "list", "selectedIndex"}, new String[]{"items", "tabs", "list"}, 2));
    }
}
