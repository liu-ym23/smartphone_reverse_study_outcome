package com.larus.agents.impl.experience;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f286691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WorkExperienceSource f286692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f286693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f286694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f286695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f286696i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f286688a, r101.f286688a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286689b, r101.f286689b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f286690c, r101.f286690c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f286691d, r101.f286691d) == true) goto L21;
        return false;
    L21:
        if (this.f286692e == r101.f286692e) goto L24;
        return false;
    L24:
        if (this.f286693f == r101.f286693f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f286694g, r101.f286694g) == true) goto L30;
        return false;
    L30:
        if (this.f286695h == r101.f286695h) goto L33;
        return false;
    L33:
        if (this.f286696i == r101.f286696i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f286688a.hashCode() * 31) + this.f286689b.hashCode()) * 31) + this.f286690c.hashCode()) * 31) + this.f286691d.hashCode()) * 31) + this.f286692e.hashCode()) * 31;
        long r101 = this.f286693f;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f286694g.hashCode()) * 31;
        if (this.f286695h == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f286696i;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "WorkExperienceSummary(id=" + this.f286688a + ", name=" + this.f286689b + ", description=" + this.f286690c + ", type=" + this.f286691d + ", source=" + this.f286692e + ", createdAt=" + this.f286693f + ", tags=" + this.f286694g + ", autoOptimize=" + this.f286695h + ", updatedAt=" + this.f286696i + ')';
    }

    public final String getType() {
        return this.f286691d;
    }

    public t(String r100, String r101, String r102, String r103, WorkExperienceSource r104, long r105, List<String> r106, boolean r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "source");
        Intrinsics.checkNotNullParameter(r106, PromotionProductPrivilegesStruct.TAGS);
        this.f286688a = r100;
        this.f286689b = r101;
        this.f286690c = r102;
        this.f286691d = r103;
        this.f286692e = r104;
        this.f286693f = r105;
        this.f286694g = r106;
        this.f286695h = r110;
        this.f286696i = r111;
    }
}
