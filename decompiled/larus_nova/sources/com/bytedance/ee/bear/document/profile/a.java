package com.bytedance.ee.bear.document.profile;

import com.bytedance.ee.bear.lark.dependency.c0;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f221228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeShowProfilePlugin.a f221229b;

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onCancel() {
        if (OfficeShowProfilePlugin.access$1000(this.f221229b.f221224a) == false) goto L6;
        this.f221228a.onCallBack(OfficeShowProfilePlugin.a.a(this.f221229b, "cancel"));
        return;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onConfirm() {
        if (OfficeShowProfilePlugin.access$800(this.f221229b.f221224a) == false) goto L6;
        this.f221228a.onCallBack(OfficeShowProfilePlugin.a.a(this.f221229b, "confirm"));
        return;
    }

    public a(OfficeShowProfilePlugin.a r100, m r101) {
        this.f221229b = r100;
        this.f221228a = r101;
    }
}
