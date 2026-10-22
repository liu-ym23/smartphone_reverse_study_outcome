package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIGroup;

/* JADX INFO: loaded from: classes32.dex */
public abstract class UISimpleView<T extends ViewGroup> extends UIGroup<T> {
    public UISimpleView(Context r100) {
        this((LynxContext) r100);
    }

    public UISimpleView(LynxContext r100) {
        this(r100, null);
    }

    public UISimpleView(LynxContext r100, Object r101) {
        super(r100, r101);
    }
}
