package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes32.dex */
public class RawTextShadowNode extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f382240v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f382241w;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final String toString() {
        return n() + " [text: " + this.f382240v + "]";
    }

    public RawTextShadowNode() {
        this.f382240v = null;
        this.f382241w = false;
    }

    @LynxProp(name = "pseudo")
    public void setPsuedo(boolean r100) {
        this.f382241w = r100;
    }

    @LynxProp(name = "text")
    public void setText(f6a.a r100) {
        this.f382240v = b.b(r100);
        q();
    }
}
