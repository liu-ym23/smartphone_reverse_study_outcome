package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.tabbar.LynxTabLayout;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r86.h;
import r86.i;
import u86.d;
import u86.e;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006:\u0001;J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0007H\u0007J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007H\u0007J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0007H\u0007J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0015H\u0007J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015H\u0007J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0007J\u0010\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0007J\u0010\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020\fH\u0007J\u0010\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020.H\u0007J\u001c\u0010:\u001a\u00020\t2\u0006\u00107\u001a\u0002062\n\b\u0002\u00109\u001a\u0004\u0018\u000108H'¨\u0006<"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "K", "Lcom/bytedance/ies/xelement/viewpager/Pager;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/r0;", "", "color", "", "setBackground", "setTabbarBackground", "", "left", "setTabPaddingLeft", "right", "setTabPaddingRight", "top", "setTabPaddingTop", "bottom", "setTabPaddingBottom", "", "textSize", "setSelectedTextSize", "setSelectedTextColor", "setUnSelectedTextSize", "setUnSelectedTextColor", "setTabIndicatorColor", "bool", "setIndicatorVisibility", "value", "setTabInterspace", GXTemplateKey.GAIAX_LAYER_GRAVITY, "setTablayoutGravity", "boldMode", "setTextBoldMode", "setTabHeight", "setTabHeightRpx", "setTabIndicatorWidth", "setTabIndicatorHeight", "setTabIndicatorRadius", "height", "setBorderHeight", "width", "setBorderWidth", "setBorderLineColor", "", "enable", "setTabBarDragEnable", "setAllowHorizontalGesture", "selectIndex", "setSelect", "keepItemView", "setKeepItemView", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseLynxViewPager<K extends BaseCustomViewPager, T extends Pager<K>> extends UISimpleView<T> implements r0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f250593j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f250595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabLayout.Tab f250597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f250598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f250599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f250600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public T f250601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f250602i;

    public static final class a {
    }

    public static final class b implements LynxViewpagerItem.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLynxViewPager<K, T> f250603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f250604b;

        @Override // com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Pager r101 = this.f250603a.N();
            int r102 = this.f250604b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "newTag");
            List<String> r103 = r101.f250477m;
            if (r101.f250466b == null) goto L6;
            r102 = r102 - 1;
        L6:
            ListProtector.set(r103, r102, r100);
            r101.f250471g.notifyDataSetChanged();
            r101.g();
        }

        public b(BaseLynxViewPager<K, T> r100, int r101) {
            this.f250603a = r100;
            this.f250604b = r101;
        }
    }

    public static final class c implements Pager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLynxViewPager<K, T> f250605a;

        public c(BaseLynxViewPager<K, T> r100) {
            this.f250605a = r100;
        }

        @Override // com.bytedance.ies.xelement.viewpager.Pager.d
        public final void a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            BaseLynxViewPager<K, T> r102 = this.f250605a;
            int r103 = BaseLynxViewPager.f250593j;
            r102.getClass();
            if (Intrinsics.areEqual(r101, "tabbarcellappear") == false) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L9;
            EventEmitter r105 = r102.getLynxContext().getEventEmitter();
            m7a.a r106 = new m7a.a(r102.getSign(), r101);
            r106.a("position", Integer.valueOf(r100));
            r105.sendCustomEvent(r106);
            return;
        L9:
            return;
        L5:
            r104 = Intrinsics.areEqual(r101, "tabbarcelldisappear");
            goto L6
        }
    }

    static {
    }

    public abstract void M(LynxViewpagerItem r100, int r101);

    public abstract void initViewPagerChangeListener();

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    public void selectIndexIsSet(int r100) {
    }

    @LynxUIMethod
    public abstract void selectTab(ReadableMap r100, Callback r101);

    public abstract void sendTabChangeEvent(String r100, int r101, String r102);

    public final T N() {
        T r100 = this.f250601h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        int r100 = this.mChildren.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L20;
        LynxBaseUI r102 = (LynxBaseUI) ListProtector.get(this.mChildren, r101);
        if (this.f250600g == true) goto L12;
        if ((r102 instanceof LynxUI) == false) goto L12;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r102).getView()) == true) goto L12;
    L19:
        r101 = r101 + 1;
    L12:
        if (needCustomLayout() == true) goto L17;
        if ((r102 instanceof LynxUI) == false) goto L19;
        r102.layout();
        goto L19
    L17:
        if ((r102 instanceof UIGroup) == false) goto L19;
        ((UIGroup) r102).layoutChildren();
        goto L19
    }

    @Override // com.lynx.tasm.behavior.r0
    public final void onPatchFinish() {
        if (N().getMChanged() == false) goto L9;
        Pager r100 = N();
        if (r100.f250473i == false) goto L7;
        r100.f250473i = false;
        ((ArrayList) r100.f250474j).clear();
        List<LynxViewpagerItem> r101 = r100.f250474j;
        ArrayList r102 = (ArrayList) r101;
        r102.addAll(r100.f250475k);
        r100.f250471g.notifyDataSetChanged();
        r100.g();
    L7:
        selectIndexIsSet(N().getMViewPager().getCurrentItem());
        return;
    }

    public void initListener(Context r100) {
        N().getMViewPager().setMInterceptTouchEventListener(new u86.a(this));
        this.f250602i = new d(this);
        N().setTabSelectedListener$x_element_fold_view_release(this.f250602i);
        N().setTabClickListenerListener(new e(this));
        initViewPagerChangeListener();
        N().addOnAttachStateChangeListener(new u86.c(this));
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof LynxUI) == false) goto L32;
        this.mChildren.remove(r100);
        LynxTabLayout r101 = null;
        ((LynxUI) r100).setParent(null);
        if ((r100 instanceof LynxViewpagerItem) == false) goto L22;
        LynxViewpagerItem r102 = (LynxViewpagerItem) r100;
        if (r102.getProps().hasKey("tag") == false) goto L20;
        Pager r103 = N();
        String r104 = String.valueOf(r102.f250532a);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "tag");
        if (r104.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L20;
        if (((ArrayList) r103.f250477m).contains(r104) == false) goto L18;
        ((ArrayList) r103.f250477m).remove(r104);
    L18:
        if (((ArrayList) r103.f250477m).size() <= 0) goto L20;
        r103.b(null);
        goto L20
    L11:
        r105 = false;
    L20:
        Pager r106 = N();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r106.f250473i = true;
        ((ArrayList) r106.f250475k).remove(r102);
        return;
    L22:
        if ((r100 instanceof LynxTabBarView) == false) goto L30;
        Pager r107 = N();
        LynxTabLayout r108 = ((LynxTabBarView) r100).f250451b;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L27:
        if (r101 == null) goto L29;
        r107.removeView(r101);
        return;
    L29:
        r107.getClass();
        return;
    L26:
        r101 = r108;
        goto L27
    L30:
        LLog.e(com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager.TAG, "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }

    @LynxProp(name = "allow-horizontal-gesture")
    public final void setAllowHorizontalGesture(boolean r100) {
        N().setAllowHorizontalGesture(r100);
    }

    @LynxProp(name = "background")
    public final void setBackground(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setBackgroundColor(t86.a.d(r100));
    }

    @LynxProp(name = "border-height")
    public final void setBorderHeight(float r100) {
        N().setBorderHeight(r100);
    }

    @LynxProp(name = GXTemplateKey.STYLE_BORDER_COLOR)
    public final void setBorderLineColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setBorderLineColor(r100);
    }

    @LynxProp(name = GXTemplateKey.STYLE_BORDER_WIDTH)
    public final void setBorderWidth(float r100) {
        N().setBorderWidth(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r110) {
        super.setEvents(r110);
        if (r110 == null) goto L11;
        this.f250594a = true;
        this.f250596c = r110.containsKey("tabbarcellappear");
        boolean r111 = r110.containsKey("tabbarcelldisappear");
        if (this.f250596c == true) goto L7;
        if (r111 == true) goto L7;
        return;
    L7:
        final Pager r112 = N();
        int r100 = getSign();
        c r101 = new c(this);
        r112.getClass();
        Intrinsics.checkNotNullParameter("tabbarcellappear", "appearEventType");
        Intrinsics.checkNotNullParameter("tabbarcelldisappear", "disappearEventType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r112.H == true) goto L13;
        DisplayMetrics r102 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r112.getContext());
        r112.F.set(0, 0, r102.widthPixels, r102.heightPixels);
        r112.I = r100;
        r112.f250464J = r101;
        r112.K = "tabbarcellappear";
        r112.L = "tabbarcelldisappear";
        r112.getViewTreeObserver().addOnDrawListener(new h(r112));
        r112.getViewTreeObserver().addOnScrollChangedListener(new i(r112));
        r112.H = true;
        return;
    L13:
        return;
    }

    @LynxProp(name = "hide-indicator")
    public final void setIndicatorVisibility(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bool");
        if (Intrinsics.areEqual(r100, "true") == false) goto L8;
        TabLayout r101 = N().getMTabLayout();
        if (r101 == null) goto L9;
        r101.setSelectedTabIndicator(null);
        return;
    L9:
        return;
    }

    @LynxProp(name = "keep-item-view")
    public final void setKeepItemView(boolean r100) {
        this.f250600g = r100;
        N().setKeepItemView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        super.setLynxDirection(r100);
        N().setLynxDirection(r100);
    }

    @LynxProp(name = "select-index")
    public final void setSelect(int r100) {
        TabLayout r101 = N().getMTabLayout();
        int r102 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        if (r100 < 0) goto L16;
        PagerAdapter r104 = N().getMViewPager().getAdapter();
        if (r104 == null) goto L14;
        r102 = r104.getCount();
    L14:
        if (r100 >= r102) goto L16;
        N().setCurrentSelectIndex(r100);
    L16:
        N().setSelectedIndex(r100);
        return;
    L5:
        if (r101.getSelectedTabPosition() != r100) goto L7;
        r103 = true;
        goto L8
    }

    @LynxProp(name = "selected-text-color")
    public final void setSelectedTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setSelectedTextColor(r100);
    }

    @LynxProp(name = "selected-text-size")
    public final void setSelectedTextSize(float r100) {
        N().setSelectedTextSize(r100);
    }

    @LynxProp(name = "tabbar-drag")
    public final void setTabBarDragEnable(boolean r100) {
        N().setTabBarDragEnable(r100);
    }

    @LynxProp(name = "tab-height")
    public final void setTabHeight(float r100) {
        N().e(r100, false);
    }

    @LynxProp(name = "tab-height-rpx")
    public final void setTabHeightRpx(float r100) {
        N().e(r100, true);
    }

    @LynxProp(name = "tab-indicator-color")
    public final void setTabIndicatorColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setSelectedTabIndicatorColor(r100);
    }

    @LynxProp(name = "tab-indicator-height")
    public final void setTabIndicatorHeight(float r100) {
        N().setTabIndicatorHeight(r100);
    }

    @LynxProp(name = "tab-indicator-radius")
    public final void setTabIndicatorRadius(float r100) {
        N().setTabIndicatorRadius(r100);
    }

    @LynxProp(name = "tab-indicator-width")
    public final void setTabIndicatorWidth(float r100) {
        N().setTabIndicatorWidth(r100);
    }

    @LynxProp(name = "tab-inter-space")
    public final void setTabInterspace(float r100) {
        N().setTabInterspace(r100);
    }

    @LynxProp(name = "tab-padding-bottom")
    public final void setTabPaddingBottom(int r100) {
        N().setTabPaddingBottom(r100);
    }

    @LynxProp(name = "tab-padding-left")
    public final void setTabPaddingLeft(int r100) {
        N().setTabPaddingStart(r100);
    }

    @LynxProp(name = "tab-padding-right")
    public final void setTabPaddingRight(int r100) {
        N().setTabPaddingEnd(r100);
    }

    @LynxProp(name = "tab-padding-top")
    public final void setTabPaddingTop(int r100) {
        N().setTabPaddingTop(r100);
    }

    @LynxProp(name = "tabbar-background")
    public final void setTabbarBackground(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setTabbarBackground(r100);
    }

    @LynxProp(name = "tab-layout-gravity")
    public final void setTablayoutGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        N().setTablayoutGravity(r100);
    }

    @LynxProp(name = "text-bold-mode")
    public final void setTextBoldMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "boldMode");
        N().setTextBold(r100);
    }

    @LynxProp(name = "unselected-text-color")
    public final void setUnSelectedTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        N().setUnSelectedTextColor(r100);
    }

    @LynxProp(name = "unselected-text-size")
    public final void setUnSelectedTextSize(float r100) {
        N().setUnSelectedTextSize(r100);
    }

    public BaseLynxViewPager(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f250595b = true;
        this.f250598e = true;
        this.f250599f = "";
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof LynxUI) == false) goto L21;
        ListProtector.add(this.mChildren, r101, r100);
        ((LynxUI) r100).setParent(this);
        boolean r102 = true;
        if ((r100 instanceof LynxViewpagerItem) == false) goto L17;
        LynxViewpagerItem r103 = (LynxViewpagerItem) r100;
        if (r103.getProps().hasKey("tag") == false) goto L15;
        LLog.i(com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager.TAG, "insertChild: at " + r101 + " with tag = " + String.valueOf(r103.f250532a));
        Pager r104 = N();
        String r105 = String.valueOf(r103.f250532a);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "tag");
        ((ArrayList) r104.f250477m).add(r105);
        if (r105.length() > 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L14;
        r104.b(null);
    L14:
        b r106 = new b(this, r101);
        Intrinsics.checkNotNullParameter(r106, "mPropChaneListener");
        r103.f250533b = r106;
    L15:
        M(r103, r101);
        return;
    L17:
        if ((r100 instanceof LynxTabBarView) == false) goto L19;
        N().setTabBarElementAdded(true);
        N().setTabLayout((LynxTabBarView) r100);
        return;
    L19:
        LLog.e(com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager.TAG, "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }
}
