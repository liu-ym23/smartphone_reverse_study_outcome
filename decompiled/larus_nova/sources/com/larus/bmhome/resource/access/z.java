package com.larus.bmhome.resource.access;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f313783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f313784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f313785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f313786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f313787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, q0> f313788g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f313782a, r101.f313782a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313783b, r101.f313783b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313784c, r101.f313784c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313785d, r101.f313785d) == true) goto L21;
        return false;
    L21:
        if (this.f313786e == r101.f313786e) goto L24;
        return false;
    L24:
        if (this.f313787f == r101.f313787f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313788g, r101.f313788g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f313782a.hashCode() * 31) + this.f313783b.hashCode()) * 31) + this.f313784c.hashCode()) * 31) + this.f313785d.hashCode()) * 31;
        long r101 = this.f313786e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f313787f;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f313788g.hashCode();
    }

    public final String toString() {
        return "ResourceAccessSnapshot(taskId=" + this.f313782a + ", key=" + this.f313783b + ", state=" + this.f313784c + ", request=" + this.f313785d + ", createdAtMs=" + this.f313786e + ", updatedAtMs=" + this.f313787f + ", nodeStates=" + this.f313788g + ')';
    }

    public z(String r100, r0 r101, a0 r102, w r103, long r104, long r105, Map<String, q0> r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "request");
        Intrinsics.checkNotNullParameter(r110, "nodeStates");
        this.f313782a = r100;
        this.f313783b = r101;
        this.f313784c = r102;
        this.f313785d = r103;
        this.f313786e = r104;
        this.f313787f = r105;
        this.f313788g = r110;
    }

    public /* synthetic */ z(String r110, r0 r111, a0 r112, w r113, long r114, long r210, int r211) {
        if ((r211 & 16) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r211 & 32) == 0) goto L9;
        long r115 = 0;
    L11:
        if ((r211 & 64) == 0) goto L13;
        Map r101 = MapsKt.emptyMap();
    L14:
        this(r110, r111, r112, r113, r100, r115, r101);
        return;
    L13:
        r101 = null;
        goto L14
    L9:
        r115 = r210;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
