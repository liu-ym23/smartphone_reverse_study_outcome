package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: classes32.dex */
public class UIComponent extends UIView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f383172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f383173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f383174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f383175d;

    public interface a {
    }

    public interface b {
        void a(UIComponent r100);
    }

    public String getType() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.f383172a = null;
        this.f383175d = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        b r100 = this.f383172a;
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        a r100 = this.f383175d;
        if (r100 == null) goto L18;
        UIListContainer r101 = (UIListContainer) r100;
        if (r101.f382777e == true) goto L7;
        return;
    L7:
        if (r101.f382794v == false) goto L20;
        String r102 = this.f383173b;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r101.f382795w.contains(r102) == false) goto L14;
        r101.h0(this, r101.f382797y, true);
        return;
    L14:
        if (r101.f382796x.contains(r102) == false) goto L16;
        r101.h0(this, r101.f382798z, true);
        return;
    L16:
        r101.h0(this, r101.f382797y, false);
        r101.h0(this, r101.f382798z, false);
        return;
    L20:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView
    public final com.lynx.tasm.behavior.ui.view.a onCreateView(Context r100) {
        return new com.lynx.tasm.behavior.ui.view.b(r100);
    }

    @LynxProp(name = "item-key")
    public void setItemKey(String r100) {
        this.f383173b = r100;
    }

    @LynxProp(defaultInt = 0, name = "z-index")
    public void setZIndex(int r100) {
        this.f383174c = r100;
    }

    public UIComponent(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f383174c = 0;
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }
}
