package com.obric.assistant.cocreationreview.modules.memory;

import com.ss.android.cert.manager.constants.EventConstant;
import hda.q0;
import hda.y;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f387427j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryDataReviewModuleKey f387428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f387429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f387430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<q0> f387431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<q0> f387432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, y> f387433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f387435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387436i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f387428a == r101.f387428a) goto L12;
        return false;
    L12:
        if (this.f387429b == r101.f387429b) goto L15;
        return false;
    L15:
        if (this.f387430c == r101.f387430c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387431d, r101.f387431d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387432e, r101.f387432e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387433f, r101.f387433f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387434g, r101.f387434g) == true) goto L30;
        return false;
    L30:
        if (this.f387435h == r101.f387435h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387436i, r101.f387436i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f387428a.hashCode() * 31;
        long r101 = this.f387429b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f387430c;
        int r104 = (((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f387431d.hashCode()) * 31) + this.f387432e.hashCode()) * 31) + this.f387433f.hashCode()) * 31;
        String r105 = this.f387434g;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (r104 + r107) * 31;
        if (this.f387435h == false) goto L9;
        int r109 = 1231;
    L10:
        int r110 = (r108 + r109) * 31;
        String r111 = this.f387436i;
        if (r111 == null) goto L15;
        r106 = r111.hashCode();
    L15:
        return r110 + r106;
    L9:
        r109 = 1237;
        goto L10
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewPageDto(module=" + this.f387428a + ", observeFromTimeMillis=" + this.f387429b + ", windowEndTimeMillis=" + this.f387430c + ", pendingRecords=" + this.f387431d + ", completedRecords=" + this.f387432e + ", feedbackByRecordId=" + this.f387433f + ", nextPageCursor=" + this.f387434g + ", hasMore=" + this.f387435h + ", error=" + this.f387436i + ')';
    }

    public c(MemoryDataReviewModuleKey r100, long r101, long r102, List<q0> r103, List<q0> r104, Map<String, y> r105, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "pendingRecords");
        Intrinsics.checkNotNullParameter(r104, "completedRecords");
        Intrinsics.checkNotNullParameter(r105, "feedbackByRecordId");
        this.f387428a = r100;
        this.f387429b = r101;
        this.f387430c = r102;
        this.f387431d = r103;
        this.f387432e = r104;
        this.f387433f = r105;
        this.f387434g = r110;
        this.f387435h = r111;
        this.f387436i = r112;
    }
}
