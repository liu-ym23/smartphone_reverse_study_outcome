package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.View;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;

/* JADX INFO: loaded from: classes32.dex */
public class UIBounceView extends UISimpleView<com.lynx.tasm.behavior.ui.view.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f382903a;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        return new com.lynx.tasm.behavior.ui.view.a(r100);
    }

    @LynxProp(customType = "right", name = "direction")
    public void setDirection(f6a.a r100) {
        if (r100.getType() != ReadableType.String) goto L17;
        String r101 = r100.asString();
        if (r101.equals("right") == false) goto L8;
        this.f382903a = 0;
        return;
    L8:
        if (r101.equals("left") == false) goto L11;
        this.f382903a = 1;
        return;
    L11:
        if (r101.equals("top") == false) goto L14;
        this.f382903a = 2;
        return;
    L14:
        if (r101.equals("bottom") == false) goto L21;
        this.f382903a = 3;
        return;
    L21:
        return;
    }

    public UIBounceView(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f382903a = 0;
    }
}
