package com.bytedance.ee.bear.wikiv2.extension;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a.b {
    public final /* synthetic */ c a;

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final Boolean a() {
        a.b r0 = this.a.c;
        if (r0 != null) goto L5;
        tt5.a.h("MultiTaskExtension", "getCanRead: multiTaskInfoCallback null!");
        return Boolean.FALSE;
    L5:
        return r0.a();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getDocName() {
        a.b r0 = this.a.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDocName();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final Integer getObjType() {
        a.b r0 = this.a.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getObjType();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getToken() {
        a.b r0 = this.a.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getToken();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getUrl() {
        a.b r0 = this.a.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getUrl();
    }

    public b(c r1) {
        this.a = r1;
    }
}
