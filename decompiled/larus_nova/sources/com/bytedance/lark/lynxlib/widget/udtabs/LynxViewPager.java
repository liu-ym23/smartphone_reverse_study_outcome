package com.bytedance.lark.lynxlib.widget.udtabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.lark.lynxlib.widget.udtabs.childitem.LynxViewpagerItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ie6.d;
import ie6.e;
import ie6.f;
import ie6.h;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lynxlib/widget/udtabs/LynxViewPager;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/lark/lynxlib/widget/udtabs/Pager;", "", "selectIndex", "", "setSelect", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ud-tabs_release"}, k = 1, mv = {1, 5, 1})
public class LynxViewPager extends UISimpleView<Pager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f253297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pager f253298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larksuite.component.universe_design.tab.b f253299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f253300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f253301e;

    public static final class a {
    }

    public static final class b implements LynxViewpagerItem.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxViewPager f253302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f253303b;

        @Override // com.bytedance.lark.lynxlib.widget.udtabs.childitem.LynxViewpagerItem.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Pager r101 = this.f253302a.f253298b;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPager");
            r101 = null;
        L5:
            int r102 = this.f253303b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "newTag");
            ListProtector.set(r101.f253309e, r102, r100);
            r101.f253305a.notifyDataSetChanged();
        }

        public b(LynxViewPager r100, int r101) {
            this.f253302a = r100;
            this.f253303b = r101;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        int r100 = this.mChildren.size() - 1;
        if (r100 < 0) goto L20;
        int r101 = 0;
    L5:
        int r102 = r101 + 1;
        LynxBaseUI r103 = (LynxBaseUI) ListProtector.get(this.mChildren, r101);
        boolean r104 = r103 instanceof LynxUI;
        if (r104 == false) goto L11;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r103).getView()) == true) goto L11;
    L17:
        if (r102 > r100) goto L22;
        r101 = r102;
        goto L5
    L22:
        return;
    L11:
        if (needCustomLayout() == true) goto L15;
        if (r104 == false) goto L17;
        r103.layout();
        goto L17
    L15:
        if ((r103 instanceof UIGroup) == false) goto L17;
        ((UIGroup) r103).layoutChildren();
        goto L17
    }

    public LynxViewPager(LynxContext r100) {
        super(r100);
        this.f253300d = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 == null) goto L26;
        Pager r101 = new Pager(r100);
        this.f253298b = r101;
        r101.setInterceptTouchEventListener(new d(this));
        Pager r102 = this.f253298b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r102 = null;
    L8:
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f253301e = new e(this);
        Pager r103 = this.f253298b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r103 = null;
    L11:
        e r104 = this.f253301e;
        Intrinsics.checkNotNull(r104);
        r103.setTabSelectedListener$ud_tabs_release(r104);
        Pager r105 = this.f253298b;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r105 = null;
    L14:
        r105.setTabClickListenerListener(new f());
        Pager r106 = this.f253298b;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r106 = null;
    L17:
        r106.getMViewPager().addOnPageChangeListener(new LynxViewPager$initDefaultValue$3(this));
        Pager r107 = this.f253298b;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r107 = null;
    L20:
        r107.addOnAttachStateChangeListener(new h(this));
        Pager r108 = this.f253298b;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        return null;
    L24:
        return r108;
    L26:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof LynxUI) == false) goto L42;
        this.mChildren.remove(r100);
        UDTabLayout r101 = null;
        Pager r102 = null;
        ((LynxUI) r100).setParent(null);
        if ((r100 instanceof LynxViewpagerItem) == false) goto L29;
        LynxViewpagerItem r103 = (LynxViewpagerItem) r100;
        if (r103.getProps().hasKey("tag") == false) goto L23;
        Pager r104 = this.f253298b;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r104 = null;
    L11:
        String r105 = String.valueOf(r103.f253315a);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "tag");
        if (r105.length() != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L23;
        if (((ArrayList) r104.f253309e).contains(r105) == false) goto L21;
        ((ArrayList) r104.f253309e).remove(r105);
    L21:
        if (((ArrayList) r104.f253309e).size() <= 0) goto L23;
        r104.a(null);
        goto L23
    L14:
        r106 = false;
    L23:
        Pager r107 = this.f253298b;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
    L27:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ((ArrayList) r102.f253308d).remove(r103);
        r102.f253305a.notifyDataSetChanged();
        return;
    L26:
        r102 = r107;
        goto L27
    L29:
        if ((r100 instanceof LynxTabBarView) == false) goto L40;
        Pager r108 = this.f253298b;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r108 = null;
    L33:
        UDTabLayout r109 = ((LynxTabBarView) r100).f253293c;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L37:
        if (r101 == null) goto L39;
        r108.removeView(r101);
        return;
    L39:
        r108.getClass();
        return;
    L36:
        r101 = r109;
        goto L37
    L40:
        LLog.e(BaseLynxViewPager.TAG, "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L6;
        this.f253297a = r100.containsKey("change");
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        super.setLynxDirection(r100);
        Pager r101 = this.f253298b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r101 = null;
    L5:
        r101.setLynxDirection(r100);
    }

    @LynxProp(name = "select-index")
    public final void setSelect(int r100) {
        Pager r101 = this.f253298b;
        Pager r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r101 = null;
    L6:
        if (r101.getCurrentSelectIndex() != r100) goto L8;
        return;
    L8:
        if (r100 < 0) goto L21;
        Pager r103 = this.f253298b;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r103 = null;
    L12:
        PagerAdapter r104 = r103.getMViewPager().getAdapter();
        if (r104 != null) goto L15;
        int r105 = 0;
    L16:
        if (r100 >= r105) goto L21;
        Pager r106 = this.f253298b;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r106 = null;
    L20:
        r106.setCurrentSelectIndex(r100);
        goto L21
    L15:
        r105 = r104.getCount();
    L21:
        Pager r107 = this.f253298b;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
    L25:
        r102.setSelectedIndex(r100);
        return;
    L24:
        r102 = r107;
        goto L25
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof LynxUI) == false) goto L32;
        ListProtector.add(this.mChildren, r101, r100);
        ((LynxUI) r100).setParent(this);
        Pager r102 = null;
        if ((r100 instanceof LynxViewpagerItem) == false) goto L24;
        LynxViewpagerItem r103 = (LynxViewpagerItem) r100;
        if (r103.getProps().hasKey("tag") == false) goto L18;
        Pager r104 = this.f253298b;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r104 = null;
    L11:
        String r105 = String.valueOf(r103.f253315a);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "tag");
        ((ArrayList) r104.f253309e).add(r105);
        boolean r106 = true;
        int r107 = ((ArrayList) r104.f253309e).size() - 1;
        if (r105.length() > 0) goto L15;
        r106 = false;
    L15:
        if (r106 == false) goto L17;
        r104.a(null);
    L17:
        b r108 = new b(this, r107);
        Intrinsics.checkNotNullParameter(r108, "mPropChaneListener");
        r103.f253316b = r108;
    L18:
        Pager r109 = this.f253298b;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
    L22:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ((ArrayList) r102.f253308d).add(r103);
        r102.f253305a.notifyDataSetChanged();
        return;
    L21:
        r102 = r109;
        goto L22
    L24:
        if ((r100 instanceof LynxTabBarView) == false) goto L30;
        Pager r110 = this.f253298b;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
    L29:
        r102.setTabLayout((LynxTabBarView) r100);
        return;
    L28:
        r102 = r110;
        goto L29
    L30:
        LLog.e(BaseLynxViewPager.TAG, "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }

    @LynxUIMethod
    public final void selectTab(ReadableMap r110, Callback r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        JavaOnlyMap r100 = new JavaOnlyMap();
        r100.put("success", Boolean.FALSE);
        if (r110.hasKey("index") == false) goto L26;
        int r112 = r110.getInt("index");
        if (r112 < 0) goto L22;
        Pager r101 = this.f253298b;
        Pager r102 = null;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r101 = null;
    L9:
        PagerAdapter r103 = r101.getMViewPager().getAdapter();
        if (r103 != null) goto L12;
        int r104 = 0;
    L13:
        if (r112 >= r104) goto L22;
        Pager r105 = this.f253298b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
    L18:
        r102.setCurrentSelectIndex(r112);
        r100.put("success", Boolean.TRUE);
        if (r111 == null) goto L33;
        r111.invoke(new Object[]{0, r100});
        return;
    L33:
        return;
    L17:
        r102 = r105;
        goto L18
    L12:
        r104 = Integer.valueOf(r103.getCount()).intValue();
    L22:
        r100.put("msg", "index out of bounds");
        if (r111 == null) goto L34;
        r111.invoke(new Object[]{0, r100});
        return;
    L34:
        return;
    L26:
        r100.put("msg", "no index key");
        if (r111 == null) goto L35;
        r111.invoke(new Object[]{0, r100});
        return;
    }

    public static final void M(LynxViewPager r100, String r101, int r102, String r103) {
        EventEmitter r104 = r100.getLynxContext().getEventEmitter();
        m7a.a r105 = new m7a.a(r100.getSign(), "change");
        r105.a("tag", r101);
        r105.a("index", Integer.valueOf(r102));
        r105.a("scene", r103);
        Unit r106 = Unit.INSTANCE;
        r104.sendCustomEvent(r105);
    }
}
