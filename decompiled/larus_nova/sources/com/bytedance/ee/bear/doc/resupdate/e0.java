package com.bytedance.ee.bear.doc.resupdate;

import com.ss.android.lark.vfs.VFSFile;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VFSFile f218007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f218008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f218009c;

    public final String toString() {
        return "Resource{file=" + this.f218007a + ", version='" + this.f218008b + "'}";
    }

    public e0() {
    }

    public e0(VFSFile r100, String r101, String r102) {
        this.f218007a = r100;
        this.f218008b = r101;
        this.f218009c = r102;
    }
}
