package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes32.dex */
public class r extends MutableContextWrapper {
    private boolean mHasAttached;
    private MutableContextWrapper mWrapper;

    public Context getContext() {
        if (this.mHasAttached == false) goto L7;
        return getBaseContext();
    L7:
        return this.mWrapper;
    }

    public Activity getActivity() {
        return com.lynx.tasm.utils.a.getActivity(this);
    }

    public r(Context r100) {
        super(r100);
        this.mHasAttached = false;
        MutableContextWrapper r101 = new MutableContextWrapper(null);
        this.mWrapper = r101;
        r101.setBaseContext(r100);
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context r100) {
        super.setBaseContext(r100);
        this.mWrapper.setBaseContext(r100);
    }

    public void setHasLynxViewAttached(boolean r100) {
        this.mHasAttached = r100;
    }
}
