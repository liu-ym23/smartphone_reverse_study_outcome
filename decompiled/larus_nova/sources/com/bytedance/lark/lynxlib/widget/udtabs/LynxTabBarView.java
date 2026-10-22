package com.bytedance.lark.lynxlib.widget.udtabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.b;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ie6.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u001c\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/lark/lynxlib/widget/udtabs/LynxTabBarView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "setTabLayoutGravity", "setTabMode", "", "full", "setIndicatorFullWidth", "disable", "setDisableAttachEvent", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ud-tabs_release"}, k = 1, mv = {1, 5, 1})
public class LynxTabBarView extends UISimpleView<UDTabLayout> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f253290g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f253291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f253292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDTabLayout f253293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f253294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f253295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, String> f253296f;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    public LynxTabBarView(LynxContext r100) {
        super(r100);
        this.f253291a = true;
        this.f253296f = new HashMap();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDTabLayout r101 = new UDTabLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r101.setTabMode(2);
        this.f253293c = r101;
        c r102 = new c(this);
        r101.addOnTabSelectedListener(r102);
        UDTabLayout r103 = this.f253293c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r103 = null;
    L8:
        r103.addOnAttachStateChangeListener(new ie6.b(this, r102));
        UDTabLayout r104 = this.f253293c;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        return null;
    L12:
        return r104;
    L14:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @LynxProp(defaultBoolean = false, name = "disable-attach-event")
    public final void setDisableAttachEvent(boolean r100) {
        this.f253295e = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        Intrinsics.stringPlus("events: ", r100);
        if (r100 == null) goto L6;
        this.f253292b = r100.containsKey("change");
        return;
    }

    @LynxProp(name = "indicator-full-width")
    public final void setIndicatorFullWidth(boolean r100) {
        UDTabLayout r101 = this.f253293c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        r101.setIndicatorFullWidth(r100);
    }

    @LynxProp(name = "tab-layout-gravity")
    public final void setTabLayoutGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        String r101 = r100.toLowerCase(Locale.ROOT);
        int r102 = r101.hashCode();
        UDTabLayout r103 = null;
        if (r102 == (-1364013995)) goto L26;
        if (r102 == 3143043) goto L18;
        if (r102 == 3317767) goto L10;
        return;
    L10:
        if (r101.equals("left") == false) goto L37;
        UDTabLayout r104 = this.f253293c;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L16:
        r103.setTabGravity(2);
        return;
    L15:
        r103 = r104;
        goto L16
    L37:
        return;
    L18:
        if (r101.equals(LynxVideoManagerLite.FILL) == false) goto L38;
        UDTabLayout r105 = this.f253293c;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L24:
        r103.setTabGravity(1);
        return;
    L23:
        r103 = r105;
        goto L24
    L38:
        return;
    L26:
        if (r101.equals("center") == false) goto L39;
        UDTabLayout r106 = this.f253293c;
        if (r106 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L32:
        r103.setTabGravity(0);
        return;
    L31:
        r103 = r106;
        goto L32
    }

    @LynxProp(name = "tab-mode")
    public final void setTabMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        String r101 = r100.toLowerCase(Locale.ROOT);
        int r102 = r101.hashCode();
        UDTabLayout r103 = null;
        if (r102 == (-907680051)) goto L26;
        if (r102 == 3005871) goto L18;
        if (r102 == 97445748) goto L10;
        return;
    L10:
        if (r101.equals("fixed") == false) goto L37;
        UDTabLayout r104 = this.f253293c;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L16:
        r103.setTabMode(1);
        return;
    L15:
        r103 = r104;
        goto L16
    L37:
        return;
    L18:
        if (r101.equals("auto") == false) goto L38;
        UDTabLayout r105 = this.f253293c;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L24:
        r103.setTabMode(2);
        return;
    L23:
        r103 = r105;
        goto L24
    L38:
        return;
    L26:
        if (r101.equals(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L39;
        UDTabLayout r106 = this.f253293c;
        if (r106 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L32:
        r103.setTabMode(0);
        return;
    L31:
        r103 = r106;
        goto L32
    }

    @LynxUIMethod
    public final void selectTab(ReadableMap r110, Callback r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        JavaOnlyMap r100 = new JavaOnlyMap();
        r100.put("success", Boolean.FALSE);
        if (r110.hasKey("index") == false) goto L29;
        int r112 = r110.getInt("index");
        if (r112 < 0) goto L25;
        UDTabLayout r101 = this.f253293c;
        UDTabLayout r102 = null;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L10:
        if (r112 >= r101.getTabCount()) goto L25;
        UDTabLayout r103 = this.f253293c;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L15:
        b r113 = r102.getTabAt(r112);
        if (r113 == null) goto L21;
        UDTabLayout r104 = r113.f285293b;
        if (r104 == null) goto L21;
        r104.selectTab(r113);
    L21:
        r100.put("success", Boolean.TRUE);
        if (r111 == null) goto L36;
        r111.invoke(new Object[]{0, r100});
        return;
    L36:
        return;
    L14:
        r102 = r103;
    L25:
        r100.put("msg", "index out of bounds");
        if (r111 == null) goto L37;
        r111.invoke(new Object[]{0, r100});
        return;
    L37:
        return;
    L29:
        r100.put("msg", "no index key");
        if (r111 == null) goto L38;
        r111.invoke(new Object[]{0, r100});
        return;
    }
}
