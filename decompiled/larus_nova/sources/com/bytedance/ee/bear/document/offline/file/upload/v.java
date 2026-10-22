package com.bytedance.ee.bear.document.offline.file.upload;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f220483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f220484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f220485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f220486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f220487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f220488f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f220483a == r101.f220483a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f220484b, r101.f220484b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f220485c, r101.f220485c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f220486d, r101.f220486d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f220487e, r101.f220487e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f220483a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f220484b.hashCode()) * 31;
        Map<String, String> r102 = this.f220485c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Map<String, String> r106 = this.f220486d;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Map<String, String> r109 = this.f220487e;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadFileParams(isFileUseUri=" + this.f220483a + ", filePointer=" + this.f220484b + ", params=" + this.f220485c + ", extraParams=" + this.f220486d + ", extraRust=" + this.f220487e + ')';
    }

    public v(boolean r100, String r101, Map<String, String> r102, Map<String, String> r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r101, "filePointer");
        this.f220483a = r100;
        this.f220484b = r101;
        this.f220485c = r102;
        this.f220486d = r103;
        this.f220487e = r104;
    }
}
