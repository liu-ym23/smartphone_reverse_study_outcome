package sbc;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.vote.v1.PaginatedVotedIndexInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f541329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Entity f541330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PaginatedVotedIndexInfo f541331c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f541329a == r101.f541329a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f541330b, r101.f541330b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f541331c, r101.f541331c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f541329a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f541330b.hashCode()) * 31) + this.f541331c.hashCode();
    }

    public final String toString() {
        return "VotedIndexInfoResponse(voteVersion=" + this.f541329a + ", entity=" + this.f541330b + ", votedIndexInfos=" + this.f541331c + ')';
    }

    public a(long r100, Entity r101, PaginatedVotedIndexInfo r102) {
        Intrinsics.checkNotNullParameter(r101, "entity");
        Intrinsics.checkNotNullParameter(r102, "votedIndexInfos");
        this.f541329a = r100;
        this.f541330b = r101;
        this.f541331c = r102;
    }
}
