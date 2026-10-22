package com.bytedance.ee.bear.doc.resupdate;

import com.ss.android.lark.vfs.VFSFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 {
    public final VFSFile a;
    public String b;
    public String c;

    public final String toString() {
        return "Resource{file=" + this.a + ", version='" + this.b + "'}";
    }

    public e0() {
    }

    public e0(VFSFile r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
