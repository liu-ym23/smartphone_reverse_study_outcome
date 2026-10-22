package com.larus.im.internal.audio.session.omni;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f347348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f347351d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (this.f347348a == r101.f347348a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347349b, r101.f347349b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347350c, r101.f347350c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f347348a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f347349b.hashCode()) * 31) + this.f347350c.hashCode();
    }

    public final String toString() {
        return "OmniReplyUniqueId(queryRound=" + this.f347348a + ", replyRound=" + this.f347349b + ", taskId=" + this.f347350c + ')';
    }

    public final String a() {
        return this.f347350c + '_' + this.f347348a + '_' + this.f347349b;
    }

    public o0(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "replyRound");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        this.f347348a = r100;
        this.f347349b = r101;
        this.f347350c = r102;
    }
}
