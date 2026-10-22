package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes32.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<ShadowNode> f383214a;

    public w0() {
        this.f383214a = new SparseArray();
    }

    public final ShadowNode a(int r100) {
        return this.f383214a.get(r100);
    }
}
