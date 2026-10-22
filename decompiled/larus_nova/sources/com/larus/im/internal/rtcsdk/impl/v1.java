package com.larus.im.internal.rtcsdk.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f350046e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f350047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f350050d;

    public static final class a {
        public static String a(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "replyRound");
            Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
            return r102 + '_' + r100 + '_' + r101;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v1) == true) goto L8;
        return false;
    L8:
        v1 r101 = (v1) r100;
        if (this.f350047a == r101.f350047a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350048b, r101.f350048b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350049c, r101.f350049c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f350047a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f350048b.hashCode()) * 31) + this.f350049c.hashCode();
    }

    public final String toString() {
        return "ReplyUniqueId(queryRound=" + this.f350047a + ", replyRound=" + this.f350048b + ", taskId=" + this.f350049c + ')';
    }

    public final String a() {
        return a.a(this.f350047a, this.f350048b, this.f350049c);
    }

    public v1(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "replyRound");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        this.f350047a = r100;
        this.f350048b = r101;
        this.f350049c = r102;
    }
}
