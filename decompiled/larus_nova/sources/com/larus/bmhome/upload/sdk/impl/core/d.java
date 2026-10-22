package com.larus.bmhome.upload.sdk.impl.core;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import is8.g;
import is8.j;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f314862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0<j> f314863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f314864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f314865e;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f314861a, r101.f314861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314862b, r101.f314862b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314863c, r101.f314863c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314864d, r101.f314864d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f314865e, r101.f314865e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f314861a.hashCode() * 31) + this.f314862b.hashCode()) * 31) + this.f314863c.hashCode()) * 31;
        Job r101 = this.f314864d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f314865e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadTaskRecord(taskId=" + this.f314861a + ", request=" + this.f314862b + ", states=" + this.f314863c + ", job=" + this.f314864d + ", pendingCancellationReason=" + this.f314865e + ')';
    }

    public d(String r100, g r101, StateFlowImpl r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "states");
        this.f314861a = r100;
        this.f314862b = r101;
        this.f314863c = r102;
        this.f314864d = null;
        this.f314865e = null;
    }
}
