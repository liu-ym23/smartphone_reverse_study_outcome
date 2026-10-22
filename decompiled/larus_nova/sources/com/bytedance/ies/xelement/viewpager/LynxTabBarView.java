package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.bytedance.ies.xelement.viewpager.tabbar.LynxTabLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import r86.d;
import r86.f;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-tabbar", "x-tabbar-pro"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0007J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000bH\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000bH\u0007J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0007H\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0007H\u0007J\u001c\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0007¨\u0006,"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/LynxTabBarView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/ies/xelement/viewpager/tabbar/LynxTabLayout;", "", "color", "", "setBackground", "", "enable", "setTabNewGesture", "setTabIndicatorColor", "", "value", "setTabInterspace", "setTabHeight", "setTabHeightRpx", "", "left", "setTabPaddingLeft", "right", "setTabPaddingRight", "setTabIndicatorWidth", "setTabIndicatorHeight", "setTabIndicatorRadius", "set", GXTemplateKey.GAIAX_LAYER_GRAVITY, "setTablayoutGravity", "height", "setBorderHeight", "top", "setBorderTop", "width", "setBorderWidth", "setBorderLineColor", "disable", "setDisableAttachEvent", "setOriginChangeEvent", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public class LynxTabBarView extends UISimpleView<LynxTabLayout> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f250449k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxTabLayout f250451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f250452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f250453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TabLayout.Tab f250454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, String> f250456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<r86.a> f250457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f250458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f250459j;

    public static final class a {
        public static LynxTabLayout a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            LynxTabLayout r101 = new LynxTabLayout(r100, null);
            r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r101.setTabMode(0);
            r101.setSelectedTabIndicator(R.drawable.lynx_tab_indicator);
            r101.setSelectedTabIndicatorHeight(-1);
            r101.setBackgroundResource(R.drawable.lynx_tab_line_bg);
            r101.getBackground().mutate();
            Drawable r102 = r101.getTabSelectedIndicator();
            if (r102 == null) goto L5;
            r102.mutate();
        L5:
            int r103 = LynxTabBarView.f250449k;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            Field r105 = TabLayout.class.getDeclaredField("tabPaddingStart");     // Catch: Throwable -> L8
            r105.setAccessible(true);     // Catch: Throwable -> L8
            r105.set(r101, 0);     // Catch: Throwable -> L8
            Field r106 = TabLayout.class.getDeclaredField("tabPaddingEnd");     // Catch: Throwable -> L8
            r106.setAccessible(true);     // Catch: Throwable -> L8
            r106.set(r101, 0);     // Catch: Throwable -> L8
            Field r107 = TabLayout.class.getDeclaredField("tabPaddingTop");     // Catch: Throwable -> L8
            r107.setAccessible(true);     // Catch: Throwable -> L8
            r107.set(r101, 0);     // Catch: Throwable -> L8
            Field r108 = TabLayout.class.getDeclaredField("tabPaddingBottom");     // Catch: Throwable -> L8
            r108.setAccessible(true);     // Catch: Throwable -> L8
            r108.set(r101, 0);     // Catch: Throwable -> L8
            Field r109 = TabLayout.class.getDeclaredField("requestedTabMinWidth");     // Catch: Throwable -> L8
            r109.setAccessible(true);     // Catch: Throwable -> L8
            r109.set(r101, 0);     // Catch: Throwable -> L8
            Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Result.m9452exceptionOrNullimpl(r110);
            return r101;
        L8:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }
    }

    public interface b {
        void a(TabLayout.Tab r100);
    }

    public static final class c implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxTabBarView f250460a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
        }

        public c(LynxTabBarView r100) {
            this.f250460a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            LynxTabBarView r101 = this.f250460a;
            if (r101.f250450a == false) goto L30;
            int r102 = 0;
            if (r100 != null) goto L7;
            r101.getClass();
        L19:
            EventEmitter r103 = this.f250460a.getLynxContext().getEventEmitter();
            m7a.a r104 = new m7a.a(this.f250460a.getSign(), "change");
            LynxTabBarView r105 = this.f250460a;
            String r106 = (String) ((HashMap) r105.f250456g).get(Integer.valueOf(r102));
            if (r106 != null) goto L22;
            r106 = "";
        L22:
            r104.a("tag", r106);
            r104.a("index", Integer.valueOf(r102));
            if (r105.f250454e != r100) goto L25;
            String r107 = "click";
        L26:
            r104.a("scene", r107);
            r103.sendCustomEvent(r104);
            this.f250460a.f250454e = null;
            return;
        L25:
            r107 = "slide";
            goto L26
        L7:
            LynxTabLayout r108 = r101.f250451b;
            if (r108 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            r108 = null;
        L10:
            int r109 = r108.getTabCount();
            int r110 = 0;
        L11:
            if (r110 >= r109) goto L19;
            LynxTabLayout r111 = r101.f250451b;
            if (r111 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            r111 = null;
        L16:
            if (r111.getTabAt(r110) == r100) goto L17;
            r110 = r110 + 1;
            goto L11
        L17:
            r102 = r110;
            goto L19
        }
    }

    static {
    }

    public LynxTabBarView() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    public final void M() {
        LynxTabLayout r100 = this.f250451b;
        LynxTabLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r100 = null;
    L5:
        r100.addOnTabSelectedListener(this.f250459j);
        if (this.f250455f == true) goto L16;
        c r102 = this.f250459j;
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r103 = null;
    L10:
        LynxTabLayout r104 = this.f250451b;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L14:
        r102.onTabSelected(r103.getTabAt(r101.getSelectedTabPosition()));
        return;
    L13:
        r101 = r104;
        goto L14
    }

    public final void N() {
        LynxTabLayout r100 = this.f250451b;
        LynxTabLayout r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r100 = null;
    L6:
        if (r100.getBackground() != null) goto L16;
        LynxTabLayout r102 = this.f250451b;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r102 = null;
    L10:
        r102.setBackgroundResource(R.drawable.lynx_tab_line_bg);
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L14:
        r101.getBackground().mutate();
        return;
    L13:
        r101 = r103;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        if (this.f250458i <= 0.0f) goto L11;
        LynxTabLayout r100 = this.f250451b;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r100 = null;
    L7:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L11;
        int r102 = t86.a.f545052a;
        r101.height = t86.a.c(this.mContext, this.f250458i);
    L11:
        super.measure();
    }

    public final void O(int r100) {
        Iterator<T> r101 = this.mChildren.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        LynxBaseUI r103 = (LynxBaseUI) r102;
        if ((r103 instanceof LynxTabbarItem) == true) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        LynxTabbarItem r105 = (LynxTabbarItem) r102;
        if (r105 == null) goto L19;
        Integer r106 = r105.f250526a;
        if (r106 == null) goto L19;
        r100 = r106.intValue();
    L19:
        P(0, r100);
        return;
    L8:
        if (((LynxTabbarItem) r103).f250529d == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 == null) goto L7;
        LynxTabLayout r101 = a.a(r100);
        this.f250451b = r101;
        this.f250453d = new d(this);
        r101.addOnAttachStateChangeListener(new f(this));
        LynxTabLayout r102 = this.f250451b;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        goto L7
    L9:
        return r102;
    L7:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        if ((r100 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof LynxTabbarItem) == false) goto L12;
        this.mChildren.remove(r100);
        ArrayList<r86.a> r101 = this.f250457h;
        LynxTabbarItem r102 = (LynxTabbarItem) r100;
        View r103 = r102.f250528c;
        TypeIntrinsics.asMutableCollection(r101).remove(r103);
        LynxTabLayout r104 = this.f250451b;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r104 = null;
    L9:
        r104.removeTab(r102.f250527b);
        return;
    }

    @LynxProp(name = "tab-indicator-top")
    public final void set(float r100) {
        LynxTabLayout r101 = this.f250451b;
        LayerDrawable r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        Drawable r103 = r101.getTabSelectedIndicator();
        if ((r103 instanceof LayerDrawable) == false) goto L8;
        r102 = (LayerDrawable) r103;
    L8:
        LayerDrawable r104 = r102;
        if (r104 == null) goto L12;
        int r105 = t86.a.f545052a;
        r104.setLayerInset(0, 0, 0, 0, t86.a.a(this.mContext, r100));
        return;
    }

    @LynxProp(name = "background")
    public final void setBackground(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N();
        GradientDrawable r101 = null;
        LynxTabLayout r102 = null;
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L8:
        r102.setBackgroundColor(t86.a.d(r100));
        return;
    L7:
        r102 = r103;
        goto L8
    L9:
        LynxTabLayout r104 = this.f250451b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r104 = null;
    L12:
        Drawable r105 = r104.getBackground();
        if ((r105 instanceof LayerDrawable) == false) goto L15;
        LayerDrawable r106 = (LayerDrawable) r105;
    L16:
        if (r106 == null) goto L18;
        Drawable r107 = r106.getDrawable(0);
    L20:
        if ((r107 instanceof GradientDrawable) == false) goto L22;
        r101 = (GradientDrawable) r107;
    L22:
        if (r101 == null) goto L26;
        r101.setColor(t86.a.d(r100));
        return;
    L26:
        return;
    L18:
        r107 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBackgroundColor(int r100) {
        N();
        GradientDrawable r101 = null;
        LynxTabLayout r102 = null;
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L8:
        r102.setBackgroundColor(r100);
        return;
    L7:
        r102 = r103;
        goto L8
    L9:
        LynxTabLayout r104 = this.f250451b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r104 = null;
    L12:
        Drawable r105 = r104.getBackground();
        if ((r105 instanceof LayerDrawable) == false) goto L15;
        LayerDrawable r106 = (LayerDrawable) r105;
    L16:
        if (r106 == null) goto L18;
        Drawable r107 = r106.getDrawable(0);
    L20:
        if ((r107 instanceof GradientDrawable) == false) goto L22;
        r101 = (GradientDrawable) r107;
    L22:
        if (r101 == null) goto L26;
        r101.setColor(r100);
        return;
    L26:
        return;
    L18:
        r107 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    }

    @LynxProp(name = "border-height")
    public final void setBorderHeight(float r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        N();
        LynxTabLayout r101 = this.f250451b;
        GradientDrawable r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L8:
        Drawable r103 = r101.getBackground();
        if ((r103 instanceof LayerDrawable) == false) goto L11;
        LayerDrawable r104 = (LayerDrawable) r103;
    L12:
        if (r104 == null) goto L14;
        Drawable r105 = r104.getDrawable(1);
    L16:
        if ((r105 instanceof GradientDrawable) == false) goto L18;
        r102 = (GradientDrawable) r105;
    L18:
        if (r102 == null) goto L21;
        int r106 = r102.getIntrinsicWidth();
        int r107 = t86.a.f545052a;
        r102.setSize(r106, t86.a.a(this.mContext, r100));
        return;
    L21:
        return;
    L14:
        r105 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    }

    @LynxProp(name = GXTemplateKey.STYLE_BORDER_COLOR)
    public final void setBorderLineColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        N();
        LynxTabLayout r101 = this.f250451b;
        GradientDrawable r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L8:
        Drawable r103 = r101.getBackground();
        if ((r103 instanceof LayerDrawable) == false) goto L11;
        LayerDrawable r104 = (LayerDrawable) r103;
    L12:
        if (r104 == null) goto L14;
        Drawable r105 = r104.getDrawable(1);
    L16:
        if ((r105 instanceof GradientDrawable) == false) goto L18;
        r102 = (GradientDrawable) r105;
    L18:
        if (r102 == null) goto L21;
        r102.setColor(t86.a.d(r100));
        return;
    L21:
        return;
    L14:
        r105 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    }

    @LynxProp(name = GXTemplateKey.FLEXBOX_BORDER_TOP)
    public final void setBorderTop(float r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        N();
        LynxTabLayout r101 = this.f250451b;
        LayerDrawable r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L8:
        Drawable r103 = r101.getBackground();
        if ((r103 instanceof LayerDrawable) == false) goto L11;
        r102 = (LayerDrawable) r103;
    L11:
        LayerDrawable r104 = r102;
        if (r104 == null) goto L15;
        int r105 = t86.a.f545052a;
        r104.setLayerInset(0, 0, 0, 0, t86.a.a(this.mContext, r100));
        return;
    }

    @LynxProp(name = GXTemplateKey.STYLE_BORDER_WIDTH)
    public final void setBorderWidth(float r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        N();
        int r101 = t86.a.f545052a;
        int r102 = (int) (t86.a.b(this.mContext) * (r100 / 375.0f));
        LynxTabLayout r103 = this.f250451b;
        GradientDrawable r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r103 = null;
    L8:
        Drawable r105 = r103.getBackground();
        if ((r105 instanceof LayerDrawable) == false) goto L11;
        LayerDrawable r106 = (LayerDrawable) r105;
    L12:
        if (r106 == null) goto L14;
        Drawable r107 = r106.getDrawable(1);
    L16:
        if ((r107 instanceof GradientDrawable) == false) goto L18;
        r104 = (GradientDrawable) r107;
    L18:
        if (r104 == null) goto L21;
        r104.setSize(r102, r104.getIntrinsicHeight());
        return;
    L21:
        return;
    L14:
        r107 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    }

    @LynxProp(defaultBoolean = true, name = "disable-attach-event")
    public final void setDisableAttachEvent(boolean r100) {
        this.f250455f = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        Objects.toString(r100);
        if (r100 == null) goto L6;
        this.f250450a = r100.containsKey("change");
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        super.setLynxDirection(r100);
        LynxTabLayout r101 = null;
        if (r100 == 2) goto L11;
        if (r100 == 2) goto L11;
        LynxTabLayout r102 = this.f250451b;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L10:
        ViewCompat.setLayoutDirection(r101, 0);
        return;
    L9:
        r101 = r102;
    L11:
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L15:
        ViewCompat.setLayoutDirection(r101, 1);
        return;
    L14:
        r101 = r103;
        goto L15
    }

    @LynxProp(defaultBoolean = false, name = "android-force-bind-change-event")
    public final void setOriginChangeEvent(boolean r100) {
        if (this.f250451b == null) goto L6;
        M();
        return;
    }

    @LynxProp(name = "tab-height")
    public final void setTabHeight(float r100) {
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L9;
        int r104 = t86.a.f545052a;
        r103.height = t86.a.a(this.mContext, r100);
    L9:
        LynxTabLayout r105 = this.f250451b;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L13:
        r102.requestLayout();
        return;
    L12:
        r102 = r105;
        goto L13
    }

    @LynxProp(name = "tab-height-rpx")
    public final void setTabHeightRpx(float r100) {
        this.f250458i = r100;
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L9;
        int r104 = t86.a.f545052a;
        r103.height = t86.a.c(this.mContext, this.f250458i);
    L9:
        LynxTabLayout r105 = this.f250451b;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L13:
        r102.requestLayout();
        return;
    L12:
        r102 = r105;
        goto L13
    }

    @LynxProp(name = "tab-indicator-color")
    public final void setTabIndicatorColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        LynxTabLayout r101 = this.f250451b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        r101.setSelectedTabIndicatorColor(t86.a.d(r100));
    }

    @LynxProp(name = "tab-indicator-height")
    public final void setTabIndicatorHeight(float r100) {
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        Drawable r103 = r101.getTabSelectedIndicator();
        if ((r103 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r104 = (LayerDrawable) r103;
    L9:
        if (r104 == null) goto L11;
        Drawable r105 = r104.getDrawable(0);
    L13:
        if ((r105 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r106 = (GradientDrawable) r105;
    L16:
        if (r106 == null) goto L18;
        int r107 = r106.getIntrinsicWidth();
        int r108 = t86.a.f545052a;
        r106.setSize(r107, t86.a.a(this.mContext, r100));
    L18:
        LynxTabLayout r109 = this.f250451b;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L22:
        r102.requestLayout();
        return;
    L21:
        r102 = r109;
        goto L22
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    @LynxProp(name = "tab-indicator-radius")
    public final void setTabIndicatorRadius(float r100) {
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        Drawable r103 = r101.getTabSelectedIndicator();
        if ((r103 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r104 = (LayerDrawable) r103;
    L9:
        if (r104 == null) goto L11;
        Drawable r105 = r104.getDrawable(0);
    L13:
        if ((r105 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r106 = (GradientDrawable) r105;
    L16:
        if (r106 == null) goto L19;
        int r107 = t86.a.f545052a;
        r106.setCornerRadius(t86.a.a(this.mContext, r100));
    L19:
        LynxTabLayout r108 = this.f250451b;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L23:
        r102.requestLayout();
        return;
    L22:
        r102 = r108;
        goto L23
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    @LynxProp(name = "tab-indicator-width")
    public final void setTabIndicatorWidth(float r100) {
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        Drawable r103 = r101.getTabSelectedIndicator();
        if ((r103 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r104 = (LayerDrawable) r103;
    L9:
        if (r104 == null) goto L11;
        Drawable r105 = r104.getDrawable(0);
    L13:
        if ((r105 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r106 = (GradientDrawable) r105;
    L16:
        if (r106 == null) goto L18;
        int r107 = t86.a.f545052a;
        r106.setSize((int) (t86.a.b(this.mContext) * (r100 / 375.0f)), r106.getIntrinsicHeight());
    L18:
        LynxTabLayout r108 = this.f250451b;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L22:
        r102.requestLayout();
        return;
    L21:
        r102 = r108;
        goto L22
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    @LynxProp(name = "tab-inter-space")
    public final void setTabInterspace(float r100) {
        this.f250452c = r100 / 2;
    }

    @LynxProp(defaultBoolean = false, name = "tab-new-gesture-enable")
    public final void setTabNewGesture(boolean r100) {
        LynxTabLayout r101 = this.f250451b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        r101.setNewGesture(r100);
    }

    @LynxProp(name = "tab-padding-left")
    public final void setTabPaddingLeft(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L37
        LynxTabLayout r102 = this.f250451b;     // Catch: Throwable -> L37
        Object r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L37
        r102 = null;
    L6:
        Class<? super Object> r104 = r102.getClass().getSuperclass();     // Catch: Throwable -> L37
        if (r104 == null) goto L9;
        Field r105 = r104.getDeclaredField("contentInsetStart");     // Catch: Throwable -> L37
    L11:
        if (r105 == null) goto L14;
        r105.setAccessible(true);     // Catch: Throwable -> L37
    L14:
        if (r105 == null) goto L19;
        LynxTabLayout r106 = this.f250451b;     // Catch: Throwable -> L37
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L37
        r106 = null;
    L18:
        int r107 = t86.a.f545052a;     // Catch: Throwable -> L37
        r105.set(r106, Integer.valueOf(t86.a.a(this.mContext, r100)));     // Catch: Throwable -> L37
    L19:
        LynxTabLayout r108 = this.f250451b;     // Catch: Throwable -> L37
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L37
        r108 = null;
    L22:
        Class<? super Object> r109 = r108.getClass().getSuperclass();     // Catch: Throwable -> L37
        if (r109 == null) goto L25;
        Method r110 = r109.getDeclaredMethod("applyModeAndGravity", new Class[0]);     // Catch: Throwable -> L37
    L26:
        if (r110 == null) goto L29;
        r110.setAccessible(true);     // Catch: Throwable -> L37
    L29:
        if (r110 == null) goto L35;
        LynxTabLayout r111 = this.f250451b;     // Catch: Throwable -> L37
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L37
    L34:
        r103 = r110.invoke(r103, new Object[0]);     // Catch: Throwable -> L37
        goto L35
    L33:
        r103 = r111;
    L35:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L37
        return;
    L25:
        r110 = null;
        goto L26
    L9:
        r105 = null;
    L37:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @LynxProp(name = "tab-padding-right")
    public final void setTabPaddingRight(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
        LynxTabLayout r102 = this.f250451b;     // Catch: Throwable -> L27
        LynxTabLayout r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L27
        r102 = null;
    L6:
        Class<? super Object> r104 = r102.getClass().getSuperclass();     // Catch: Throwable -> L27
        if (r104 == null) goto L9;
        Field r105 = r104.getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L27
    L10:
        if (r105 == null) goto L13;
        r105.setAccessible(true);     // Catch: Throwable -> L27
    L13:
        if (r105 == null) goto L18;
        LynxTabLayout r106 = this.f250451b;     // Catch: Throwable -> L27
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L27
        r106 = null;
    L17:
        Object r107 = r105.get(r106);     // Catch: Throwable -> L27
    L19:
        if (r107 == null) goto L26;
        LinearLayout r108 = (LinearLayout) r107;     // Catch: Throwable -> L27
        int r109 = r108.getPaddingStart();     // Catch: Throwable -> L27
        int r110 = r108.getPaddingTop();     // Catch: Throwable -> L27
        int r111 = t86.a.f545052a;     // Catch: Throwable -> L27
        ViewCompat.setPaddingRelative(r108, r109, r110, t86.a.a(this.mContext, r100), r108.getPaddingBottom());     // Catch: Throwable -> L27
        LynxTabLayout r112 = this.f250451b;     // Catch: Throwable -> L27
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L27
    L24:
        r103.requestLayout();     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return;
    L23:
        r103 = r112;
        goto L24
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L27
    L18:
        r107 = null;
        goto L19
    L9:
        r105 = null;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @LynxProp(name = "tab-layout-gravity")
    public final void setTablayoutGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        String r101 = r100.toLowerCase(Locale.ROOT);
        int r102 = r101.hashCode();
        LynxTabLayout r103 = null;
        if (r102 == (-1364013995)) goto L46;
        if (r102 == 3143043) goto L25;
        if (r102 == 3317767) goto L10;
        return;
    L10:
        if (r101.equals("left") == false) goto L90;
        LynxTabLayout r104 = this.f250451b;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r104 = null;
    L15:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L19;
        r105.width = -1;
    L19:
        LynxTabLayout r106 = this.f250451b;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L23:
        r103.requestLayout();
        return;
    L22:
        r103 = r106;
        goto L23
    L90:
        return;
    L25:
        if (r101.equals(LynxVideoManagerLite.FILL) == false) goto L91;
        LynxTabLayout r107 = this.f250451b;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r107 = null;
    L30:
        r107.setTabMode(1);
        LynxTabLayout r108 = this.f250451b;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r108 = null;
    L33:
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L37;
        r109.width = -1;
    L37:
        LynxTabLayout r110 = this.f250451b;
        if (r110 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r110 = null;
    L40:
        r110.setTabGravity(0);
        LynxTabLayout r111 = this.f250451b;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L44:
        r103.requestLayout();
        return;
    L43:
        r103 = r111;
        goto L44
    L91:
        return;
    L46:
        if (r101.equals("center") == false) goto L92;
        LynxTabLayout r112 = this.f250451b;
        if (r112 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r112 = null;
    L51:
        r112.setTabGravity(1);
        LynxTabLayout r113 = this.f250451b;
        if (r113 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r113 = null;
    L54:
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L86;
        r114.width = -1;
    L86:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L78
        LynxTabLayout r116 = this.f250451b;     // Catch: Throwable -> L78
        if (r116 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L78
        r116 = null;
    L61:
        Class<? super Object> r117 = r116.getClass().getSuperclass();     // Catch: Throwable -> L78
        if (r117 == null) goto L64;
        Field r118 = r117.getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L78
    L65:
        if (r118 == null) goto L68;
        r118.setAccessible(true);     // Catch: Throwable -> L78
    L68:
        if (r118 == null) goto L73;
        LynxTabLayout r119 = this.f250451b;     // Catch: Throwable -> L78
        if (r119 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L78
        r119 = null;
    L72:
        Object r120 = r118.get(r119);     // Catch: Throwable -> L78
    L74:
        if (r120 == null) goto L77;
        LinearLayout r121 = (LinearLayout) r120;     // Catch: Throwable -> L78
        r121.setGravity(17);     // Catch: Throwable -> L78
        r121.getLayoutParams().width = -2;     // Catch: Throwable -> L78
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L78
    L80:
        LynxTabLayout r122 = this.f250451b;
        if (r122 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L84:
        r103.requestLayout();
        return;
    L83:
        r103 = r122;
        goto L84
    L77:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L78
    L73:
        r120 = null;
        goto L74
    L64:
        r118 = null;
    L78:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L80
    }

    public LynxTabBarView(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f250452c = 9.0f;
        this.f250455f = true;
        this.f250456g = new HashMap();
        this.f250457h = new ArrayList();
        this.f250458i = -1.0f;
        this.f250459j = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18, types: [T, com.google.android.material.tabs.TabLayout$Tab] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.google.android.material.tabs.TabLayout$Tab] */
    public final void P(int r100, int r101) {
        int r102 = this.mChildren.size();
    L3:
        if (r100 >= r102) goto L52;
        LynxBaseUI r103 = (LynxBaseUI) ListProtector.get(this.mChildren, r100);
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        LynxTabLayout r105 = this.f250451b;
        TabLayout.TabView r106 = null;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r105 = null;
    L7:
        ?? r107 = r105.getTabAt(r100);
        r104.element = r107;
        if (r107 != 0) goto L17;
        LynxTabLayout r108 = this.f250451b;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r108 = null;
    L12:
        ?? r109 = r108.newTab();
        LynxTabLayout r110 = this.f250451b;
        LynxTabLayout r111 = r110;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r111 = 0;
    L15:
        r111.addTab(r109);
        r104.element = r109;
    L17:
        if ((r103 instanceof LynxTabbarItem) == false) goto L19;
        ((LynxTabbarItem) r103).f250527b = (TabLayout.Tab) r104.element;
    L19:
        if (r101 != r100) goto L23;
        TabLayout.Tab r112 = (TabLayout.Tab) r104.element;
        if (r112 == null) goto L23;
        r112.select();
    L23:
        TabLayout.Tab r113 = (TabLayout.Tab) r104.element;
        if (r113 == null) goto L27;
        r113.setCustomView((View) ListProtector.get(this.f250457h, r100));
    L27:
        TabLayout.Tab r114 = (TabLayout.Tab) r104.element;
        if (r114 == null) goto L30;
        TabLayout.TabView r115 = r114.view;
    L31:
        if (r115 == null) goto L33;
        r115.setBackgroundColor(0);
    L33:
        int r116 = t86.a.f545052a;
        int r117 = t86.a.a(this.mContext, this.f250452c);
        TabLayout.Tab r118 = (TabLayout.Tab) r104.element;
        if (r118 == null) goto L36;
        View r119 = r118.getCustomView();
    L37:
        Intrinsics.checkNotNull(r119);
        TabLayout.Tab r120 = (TabLayout.Tab) r104.element;
        if (r120 == null) goto L40;
        View r121 = r120.getCustomView();
    L41:
        Intrinsics.checkNotNull(r121);
        int r122 = r121.getPaddingTop();
        TabLayout.Tab r123 = (TabLayout.Tab) r104.element;
        if (r123 == null) goto L44;
        View r124 = r123.getCustomView();
    L45:
        Intrinsics.checkNotNull(r124);
        ViewCompat.setPaddingRelative(r119, r117, r122, r117, r124.getPaddingBottom());
        TabLayout.Tab r125 = (TabLayout.Tab) r104.element;
        if (r125 == null) goto L48;
        r106 = r125.view;
    L48:
        if (r106 == null) goto L51;
        r106.setOnClickListener(new r86.c(this, r104));
        r100 = r100 + 1;
        goto L3
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L44:
        r124 = null;
        goto L45
    L40:
        r121 = null;
        goto L41
    L36:
        r119 = null;
        goto L37
    L30:
        r115 = null;
        goto L31
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        if ((r100 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof LynxTabbarItem) == false) goto L19;
        LynxTabbarItem r102 = (LynxTabbarItem) r100;
        r102.setParent(this);
        ListProtector.add(this.mChildren, r101, r100);
        r86.a r103 = new r86.a(this.mContext);
        r103.setOverflow(r102.getOverflow());
        r103.addView(((LynxUI) r100).getView());
        r102.f250528c = r103;
        ListProtector.add(this.f250457h, r101, r103);
        if (r102.getProps().containsKey("tag") == false) goto L10;
        Integer r104 = Integer.valueOf(r101);
        Map<Integer, String> r105 = this.f250456g;
        HashMap r106 = (HashMap) r105;
        r106.put(r104, String.valueOf(r102.getProps().get("tag")));
    L10:
        if (r102.f250529d == false) goto L12;
        int r107 = r101;
    L13:
        P(r101, r107);
        LynxTabLayout r108 = this.f250451b;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r108 = null;
    L16:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r108, "tabLayout");
        r102.f250526a = Integer.valueOf(r101);
        r102.f250530e = r108;
        return;
    L12:
        r107 = 0;
        goto L13
    }

    @LynxUIMethod
    public final void selectTab(ReadableMap r110, Callback r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        JavaOnlyMap r100 = new JavaOnlyMap();
        r100.put("success", Boolean.FALSE);
        if (r110.hasKey("index") == false) goto L24;
        int r112 = r110.getInt("index");
        if (r112 < 0) goto L21;
        LynxTabLayout r101 = this.f250451b;
        LynxTabLayout r102 = null;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L10:
        if (r112 >= r101.getTabCount()) goto L21;
        LynxTabLayout r103 = this.f250451b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L15:
        TabLayout.Tab r113 = r102.getTabAt(r112);
        if (r113 == null) goto L18;
        r113.select();
    L18:
        r100.put("success", Boolean.TRUE);
        if (r111 == null) goto L28;
        r111.invoke(new Object[]{0, r100});
        return;
    L28:
        return;
    L14:
        r102 = r103;
    L21:
        r100.put("msg", "index out of bounds");
        if (r111 == null) goto L30;
        r111.invoke(new Object[]{0, r100});
        return;
    L30:
        return;
    L24:
        r100.put("msg", "no index key");
        if (r111 == null) goto L32;
        r111.invoke(new Object[]{0, r100});
        return;
    }
}
