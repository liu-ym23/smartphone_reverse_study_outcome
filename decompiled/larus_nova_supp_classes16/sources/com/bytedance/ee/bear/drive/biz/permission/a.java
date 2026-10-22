package com.bytedance.ee.bear.drive.biz.permission;

import b95.l;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements l.a {
    public final /* synthetic */ DrivePluginHost a;

    @Override // b95.l.a
    public final void cancel() {
        k75.a.a(this.a);
    }

    @Override // b95.l.a
    public final void confirm() {
        k75.a.a(this.a);
    }

    public a(DrivePluginHost r1) {
        this.a = r1;
    }
}
