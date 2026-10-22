package com.larus.im;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l implements h {
    public l() {
    }

    @Override // com.larus.im.h
    public boolean markAsNewUser() {
        if (FlowRuntime.d() == true) goto L7;
        return false;
    L7:
        return com.larus.im.internal.delegate.c.f348197a.j();
    }
}
