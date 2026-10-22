package com.bytedance.dux.window.bean;

import androidx.lifecycle.Observer;
import hm4.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dux/window/bean/DuxBreakPointStore;", "Landroidx/lifecycle/Observer;", "Lhm4/d;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBreakPointStore implements Observer<d> {
    public DuxBreakPointStore() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DuxBreakPointStore) == true) goto L8;
        return false;
    L8:
        ((DuxBreakPointStore) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "DuxBreakPointStore(config=null, listener=null)";
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(d r100) {
    }
}
