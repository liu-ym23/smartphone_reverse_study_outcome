package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmLocationIdentityType f434997b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434998a = null;

        static {
            int[] r100 = new int[MmLocationIdentityType.values().length];
            r100[MmLocationIdentityType.RECORDING_ID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmLocationIdentityType.MINUTES_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f434998a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f434996a, r101.f434996a) == true) goto L12;
        return false;
    L12:
        if (this.f434997b == r101.f434997b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434996a.hashCode() * 31) + this.f434997b.hashCode();
    }

    public final String toString() {
        return "MmLocationIdentity(value=" + this.f434996a + ", type=" + this.f434997b + ')';
    }

    public final MmLocationIdentityType getType() {
        return this.f434997b;
    }

    public b(String r100, MmLocationIdentityType r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f434996a = r100;
        this.f434997b = r101;
    }
}
