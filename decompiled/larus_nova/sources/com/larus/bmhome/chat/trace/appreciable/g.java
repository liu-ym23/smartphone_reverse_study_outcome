package com.larus.bmhome.chat.trace.appreciable;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f310129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f310130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f310131d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f310128a, r101.f310128a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310129b, r101.f310129b) == true) goto L15;
        return false;
    L15:
        if (this.f310130c == r101.f310130c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310131d, r101.f310131d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f310128a.hashCode() * 31) + this.f310129b.hashCode()) * 31;
        long r101 = this.f310130c;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f310131d.hashCode();
    }

    public final String toString() {
        return "AudioParam(taskId=" + this.f310128a + ", path=" + this.f310129b + ", audioDuration=" + this.f310130c + ", vid=" + this.f310131d + ')';
    }

    public g(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r103, "vid");
        this.f310128a = r100;
        this.f310129b = r101;
        this.f310130c = r102;
        this.f310131d = r103;
    }
}
