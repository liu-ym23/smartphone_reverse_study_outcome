package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class f implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Promise f461919a;

    public /* synthetic */ f(Promise r100) {
        this.f461919a = r100;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final /* synthetic */ Runnable bind(Object r100) {
        return Callback.CC.$default$bind(this, r100);
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r100) {
        this.f461919a.reject((Exception) r100);
    }
}
