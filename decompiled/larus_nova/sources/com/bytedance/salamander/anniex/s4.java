package com.bytedance.salamander.anniex;

/* JADX INFO: loaded from: classes20.dex */
public final class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ManualState f268372b;

    public final boolean a() {
        boolean r100 = this.f268371a;
        ManualState r101 = this.f268372b;
        if (r101 != ManualState.DEFAULT) goto L5;
        return r100;
    L5:
        if (r101 != ManualState.ON) goto L7;
        return true;
    L7:
        return false;
    }

    public s4(boolean r100) {
        this.f268372b = ManualState.DEFAULT;
        this.f268371a = r100;
    }
}
