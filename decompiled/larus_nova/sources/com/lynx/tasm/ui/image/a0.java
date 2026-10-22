package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public final class a0 extends com.lynx.tasm.behavior.a {
    public a0() {
        super("filter-image", false, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
        return new UIFilterImage(r100, r101);
    }
}
