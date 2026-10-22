package com.bytedance.ee.bear.drive.biz.permission;

import b95.l;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrivePluginHost f223159a;

    @Override // b95.l.a
    public final void cancel() {
        k75.a.a(this.f223159a);
    }

    @Override // b95.l.a
    public final void confirm() {
        k75.a.a(this.f223159a);
    }

    public a(DrivePluginHost r100) {
        this.f223159a = r100;
    }
}
