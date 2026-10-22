package com.bytedance.ee.bear.drive.biz.docplugin;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f222855a;

    public b(c r100) {
        this.f222855a = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.docplugin.d
    public final void b(d.a r100) {
        tt5.a.h("CCMFollow_AttachmentFollowManager", "FragmentExtraInfo onCallback, native return data . result=" + r100.toString());
        d r101 = this.f222855a.f222859d;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
