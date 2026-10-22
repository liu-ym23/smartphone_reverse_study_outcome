package com.larus.multitask_management.impl;

import com.larus.im.NetworkTriggerType;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends com.larus.im.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f359452a;

    @Override // com.larus.im.h
    public final NetworkTriggerType triggerType() {
        if (this.f359452a == false) goto L6;
        return NetworkTriggerType.Auto;
    L6:
        return NetworkTriggerType.User;
    }

    public n(boolean r100) {
        this.f359452a = r100;
    }
}
