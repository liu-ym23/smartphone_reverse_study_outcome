package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.tabs.TabLayout;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-tabbar-item", "x-tabbar-item-pro"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxTabbarItem;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Lcom/lynx/tasm/behavior/r0;", "", "select", "", "setSelect", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class LynxTabbarItem extends UIGroup<com.lynx.tasm.behavior.ui.view.a> implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f250526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TabLayout.Tab f250527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f250528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f250529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TabLayout f250530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f250531f;

    public static final class a {
    }

    static {
    }

    public final void M() {
        if (this.f250529d == false) goto L13;
        TabLayout r100 = this.f250530e;
        if (r100 == null) goto L14;
        Integer r101 = this.f250526a;
        if (r101 == null) goto L15;
        if (r100 == null) goto L16;
        Intrinsics.checkNotNull(r101);
        TabLayout.Tab r102 = r100.getTabAt(r101.intValue());
        if (r102 == null) goto L17;
        r102.select();
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.lynx.tasm.behavior.r0
    public final void onPatchFinish() {
        if (this.f250531f == false) goto L6;
        this.f250531f = false;
        M();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        ViewParent r100 = ((com.lynx.tasm.behavior.ui.view.a) this.mView).getParent();
        if ((r100 instanceof r86.a) == false) goto L5;
        r86.a r101 = (r86.a) r100;
    L6:
        if (r101 == null) goto L10;
        r101.setOverflow(getOverflow());
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public LynxTabbarItem(LynxContext r100) {
        super(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        return new com.lynx.tasm.behavior.ui.view.a(r100);
    }

    @LynxProp(name = "select")
    public final void setSelect(boolean r100) {
        if (this.f250529d != r100) goto L5;
        return;
    L5:
        this.f250531f = true;
        this.f250529d = r100;
        M();
    }

    public LynxTabbarItem(LynxContext r100, Object r101) {
        super(r100, r101);
    }
}
