package com.larus.bmhome.upload.sdk.impl.post;

import com.monitor.cloudmessage.consts.CloudControlInf;
import is8.g;
import is8.l;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f314872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final is8.a f314873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f314875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f314876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f314877f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f314872a, r101.f314872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314873b, r101.f314873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314874c, r101.f314874c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314875d, r101.f314875d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f314876e, r101.f314876e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f314877f, r101.f314877f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f314872a.hashCode() * 31) + this.f314873b.hashCode()) * 31) + this.f314874c.hashCode()) * 31;
        l r101 = this.f314875d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f314876e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f314877f.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PostUploadContext(request=" + this.f314872a + ", route=" + this.f314873b + ", remoteKey=" + this.f314874c + ", mediaMeta=" + this.f314875d + ", resourceId=" + this.f314876e + ", attributes=" + this.f314877f + ')';
    }

    public c(g r100, is8.a r101, String r102, l r103, String r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r102, "remoteKey");
        Intrinsics.checkNotNullParameter(r105, "attributes");
        this.f314872a = r100;
        this.f314873b = r101;
        this.f314874c = r102;
        this.f314875d = r103;
        this.f314876e = r104;
        this.f314877f = r105;
    }
}
