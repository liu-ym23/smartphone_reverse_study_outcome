package com.lynx.jsbridge;

import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes32.dex */
public class LynxContextModule extends LynxModule {
    protected LynxContext mLynxContext;

    @Override // com.lynx.jsbridge.LynxModule
    public void destroy() {
        super.destroy();
    }

    public LynxContextModule(LynxContext r100) {
        super(r100);
        this.mLynxContext = r100;
    }

    public LynxContextModule(LynxContext r100, Object r101) {
        super(r100, r101);
        this.mLynxContext = r100;
    }
}
