package com.obric.assistant.special_input;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f392749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f392750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f392751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f392752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f392753e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.f392749a == r101.f392749a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392750b, r101.f392750b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392751c, r101.f392751c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f392752d, r101.f392752d) == true) goto L21;
        return false;
    L21:
        if (this.f392753e == r101.f392753e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f392749a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f392750b.hashCode()) * 31) + this.f392751c.hashCode()) * 31;
        q0 r102 = this.f392752d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r101 + r103) * 31;
        long r105 = this.f392753e;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L9:
        r103 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PhoneOperationAttachmentDraftContext(hasAttachment=" + this.f392749a + ", localMsgId=" + this.f392750b + ", fileIdentifiers=" + this.f392751c + ", specialPanel=" + this.f392752d + ", updatedAt=" + this.f392753e + ')';
    }

    public k0(boolean r100, String r101, List<String> r102, q0 r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "localMsgId");
        Intrinsics.checkNotNullParameter(r102, "fileIdentifiers");
        this.f392749a = r100;
        this.f392750b = r101;
        this.f392751c = r102;
        this.f392752d = r103;
        this.f392753e = r104;
    }
}
