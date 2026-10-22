package com.lynx.jsbridge;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes32.dex */
public abstract class d {
    protected LynxContext mContext;
    protected LynxGroup mGroup;

    public abstract void destroy();

    public abstract long getExtensionDelegatePtr();

    public abstract void onTemplateLoad(String r100);

    public abstract void setUp();

    public d(LynxContext r100, LynxGroup r101, com.lynx.tasm.behavior.c r102) {
        this.mContext = r100;
        this.mGroup = r101;
    }
}
