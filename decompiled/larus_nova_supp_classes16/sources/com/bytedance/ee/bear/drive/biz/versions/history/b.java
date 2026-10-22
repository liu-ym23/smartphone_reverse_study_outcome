package com.bytedance.ee.bear.drive.biz.versions.history;

import b95.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements l.a {
    public final /* synthetic */ DriveHistoryModePlugin a;

    @Override // b95.l.a
    public final void cancel() {
    }

    @Override // b95.l.a
    public final void confirm() {
        k75.a.a(this.a.getHost());
    }

    public b(DriveHistoryModePlugin r1) {
        this.a = r1;
    }
}
