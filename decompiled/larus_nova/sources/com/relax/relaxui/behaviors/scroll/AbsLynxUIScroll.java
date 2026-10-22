package com.relax.relaxui.behaviors.scroll;

import android.view.ViewGroup;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbsLynxUIScroll<T extends ViewGroup> extends UISimpleView<T> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405605a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f405605a = r100;
            r100[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f405605a[ReadableType.String.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public abstract void M(boolean r100);

    public abstract void N(boolean r100);

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @LynxProp(defaultInt = 0, name = "scroll-to-index")
    public abstract void scrollToIndex(int r100);

    @LynxProp(defaultBoolean = false, name = "block-descendant-focusability")
    public void setBlockDescendantFocusability(boolean r100) {
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-nested")
    public void setEnableNewNested(boolean r100) {
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean r100) {
    }

    @LynxProp(defaultBoolean = false, name = "forbid-fling-focus-change")
    public void setForbidFlingFocusChange(boolean r100) {
    }

    @LynxProp(defaultInt = 0, name = "lower-threshold")
    public abstract void setLowerThreshole(int r100);

    @LynxProp(defaultBoolean = false, name = "scroll-bar-enable")
    public abstract void setScrollBarEnable(boolean r100);

    @LynxProp(defaultInt = 0, name = "scroll-left")
    public abstract void setScrollLeft(int r100);

    @LynxProp(defaultBoolean = false, name = "scroll-tap")
    public abstract void setScrollTap(boolean r100);

    @LynxProp(defaultInt = 0, name = "scroll-top")
    public abstract void setScrollTop(int r100);

    @LynxProp(defaultInt = 0, name = "upper-threshold")
    public abstract void setUpperThreshole(int r100);

    public AbsLynxUIScroll(LynxContext r100) {
        super(r100);
    }

    @LynxProp(name = "scroll-x")
    public void setScrollX(f6a.a r100) {
        if (r100 != null) goto L4;
        M(false);
        return;
    L4:
        int r101 = a.f405605a[r100.getType().ordinal()];
        if (r101 != 1) goto L7;
        M(r100.asBoolean());
        return;
    L7:
        if (r101 != 2) goto L14;
        M("true".equals(r100.asString()));
        return;
    }

    @LynxProp(name = "scroll-y")
    public void setScrollY(f6a.a r100) {
        if (r100 != null) goto L5;
        N(true);
        return;
    L5:
        int r101 = a.f405605a[r100.getType().ordinal()];
        if (r101 != 1) goto L8;
        N(r100.asBoolean());
        return;
    L8:
        if (r101 != 2) goto L15;
        N("true".equals(r100.asString()));
        return;
    }
}
