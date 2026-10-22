package com.lynx.tasm.behavior;

import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class a1 implements CDPResultCallback {
    public a1() {
    }

    @Override // com.lynx.devtoolwrapper.CDPResultCallback
    public final void onResult(String r100) {
        LLog.i("LynxTouchEventDispatcher", "DOM.setAttributesAsText:" + r100);
    }
}
