package yk9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f568274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f568275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f568276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f568277f;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f568272a, r101.f568272a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568273b, r101.f568273b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568274c, r101.f568274c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f568275d, r101.f568275d) == true) goto L21;
        return false;
    L21:
        if (this.f568276e == r101.f568276e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f568277f, r101.f568277f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f568272a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f568273b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f568274c.hashCode()) * 31) + this.f568275d.hashCode()) * 31;
        if (this.f568276e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        Integer r109 = this.f568277f;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return r108 + r101;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MinutesHardwareRecordingContext(conversationId=" + this.f568272a + ", sourceLanguage=" + this.f568273b + ", mobParams=" + this.f568274c + ", extraParams=" + this.f568275d + ", isCallRecording=" + this.f568276e + ", productId=" + this.f568277f + ')';
    }

    public c(Integer r100) {
        Map<String, String> r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "mobParams");
        Intrinsics.checkNotNullParameter("", "extraParams");
        this.f568272a = null;
        this.f568273b = null;
        this.f568274c = r101;
        this.f568275d = "";
        this.f568276e = false;
        this.f568277f = r100;
    }
}
