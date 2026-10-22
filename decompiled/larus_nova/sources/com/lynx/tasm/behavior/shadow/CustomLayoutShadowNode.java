package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LynxProp;

/* JADX INFO: loaded from: classes32.dex */
public class CustomLayoutShadowNode extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f382201v;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean z() {
        return true;
    }

    public CustomLayoutShadowNode() {
        this.f382201v = false;
    }

    @LynxProp(name = "custom-layout")
    public void setCustomLayout(boolean r100) {
        this.f382201v = r100;
    }
}
