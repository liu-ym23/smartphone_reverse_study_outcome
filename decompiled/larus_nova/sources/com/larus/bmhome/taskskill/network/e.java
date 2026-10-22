package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TaskSkill> f314376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f314377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314378c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f314376a, r101.f314376a) == true) goto L12;
        return false;
    L12:
        if (this.f314377b == r101.f314377b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314378c, r101.f314378c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f314376a.hashCode() * 31;
        long r101 = this.f314377b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f314378c.hashCode();
    }

    public final String toString() {
        return "LocalPcPrefetchCacheEntry(skills=" + this.f314376a + ", updateElapsedMs=" + this.f314377b + ", diskKey=" + this.f314378c + ')';
    }

    public e(List<TaskSkill> r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "skills");
        Intrinsics.checkNotNullParameter(r102, "diskKey");
        this.f314376a = r100;
        this.f314377b = r101;
        this.f314378c = r102;
    }
}
