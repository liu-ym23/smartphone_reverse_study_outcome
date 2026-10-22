package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements td5.d {
    public final String a;
    public final String b;
    public td5.b c;

    @Override // td5.d
    public final void destroy() {
        this.c = null;
    }

    @Override // td5.d
    public final void execute() {
        Intent r0 = new Intent();
        r0.putExtra("EXTRA_DEST_TOKEN", this.a);
        r0.putExtra("EXTRA_DEST_NAME", this.b);
        this.c.bv(r0, -1);
    }

    public g(String r1, String r2, td5.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
