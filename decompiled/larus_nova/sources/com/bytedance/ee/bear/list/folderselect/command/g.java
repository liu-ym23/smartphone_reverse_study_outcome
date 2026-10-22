package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Intent;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements td5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f228158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f228159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public td5.b f228160c;

    @Override // td5.d
    public final void destroy() {
        this.f228160c = null;
    }

    @Override // td5.d
    public final void execute() {
        Intent r100 = new Intent();
        r100.putExtra("EXTRA_DEST_TOKEN", this.f228158a);
        r100.putExtra("EXTRA_DEST_NAME", this.f228159b);
        this.f228160c.bv(r100, -1);
    }

    public g(String r100, String r101, td5.b r102) {
        this.f228158a = r100;
        this.f228159b = r101;
        this.f228160c = r102;
    }
}
