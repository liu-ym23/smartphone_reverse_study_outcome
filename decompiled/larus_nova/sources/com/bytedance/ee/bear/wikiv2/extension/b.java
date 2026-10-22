package com.bytedance.ee.bear.wikiv2.extension;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f240695a;

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final Boolean a() {
        a.b r100 = this.f240695a.f240697c;
        if (r100 != null) goto L5;
        tt5.a.h("MultiTaskExtension", "getCanRead: multiTaskInfoCallback null!");
        return Boolean.FALSE;
    L5:
        return r100.a();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getDocName() {
        a.b r100 = this.f240695a.f240697c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getDocName();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final Integer getObjType() {
        a.b r100 = this.f240695a.f240697c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getObjType();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getToken() {
        a.b r100 = this.f240695a.f240697c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getToken();
    }

    @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
    public final String getUrl() {
        a.b r100 = this.f240695a.f240697c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getUrl();
    }

    public b(c r100) {
        this.f240695a = r100;
    }
}
