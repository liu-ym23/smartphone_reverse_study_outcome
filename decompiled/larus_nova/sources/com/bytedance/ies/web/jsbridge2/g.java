package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public abstract class g<P, R> extends d<P, R> {
    private a0 proxy;

    public abstract R invoke(P r100, CallContext r101) throws Exception;

    public void terminate() throws JsBridgeException {
        a0 r100 = this.proxy;
        if (r100 == null) goto L7;
        r100.terminate();
        return;
    L7:
        throw new JsBridgeException(0);
    }

    public g() {
        this.proxy = null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public /* bridge */ /* synthetic */ PermissionGroup getPermission() {
        return super.getPermission();
    }

    public void setProxy(a0 r100) {
        this.proxy = r100;
    }

    public void terminate(String r100) throws JsBridgeException {
        a0 r101 = this.proxy;
        if (r101 == null) goto L7;
        r101.terminate();
        return;
    L7:
        throw new JsBridgeException(0, r100);
    }
}
