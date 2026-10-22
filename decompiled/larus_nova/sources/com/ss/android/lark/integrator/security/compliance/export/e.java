package com.ss.android.lark.integrator.security.compliance.export;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f428087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f428088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f428089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f428090e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f428086a, r101.f428086a) == true) goto L12;
        return false;
    L12:
        if (this.f428087b == r101.f428087b) goto L15;
        return false;
    L15:
        if (this.f428088c == r101.f428088c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f428089d, r101.f428089d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f428090e, r101.f428090e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f428086a.hashCode() * 31;
        if (this.f428087b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f428088c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Integer r105 = this.f428089d;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f428090e;
        if (r109 == null) goto L15;
        r106 = r109.hashCode();
    L15:
        return r108 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSDKFileCryptoMonitorEvent(operation=" + this.f428086a + ", result=" + this.f428087b + ", durationMs=" + this.f428088c + ", errorCode=" + this.f428089d + ", failureReason=" + this.f428090e + ')';
    }

    public e(boolean r100, long r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter("encrypt_file", WikiFolderPushPlugin.OPT);
        this.f428086a = "encrypt_file";
        this.f428087b = r100;
        this.f428088c = r101;
        this.f428089d = r102;
        this.f428090e = r103;
    }
}
