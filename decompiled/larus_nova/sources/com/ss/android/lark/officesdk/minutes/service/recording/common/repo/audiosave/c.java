package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmAudioSaveIdentityType f434883b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434884a = null;

        static {
            int[] r100 = new int[MmAudioSaveIdentityType.values().length];
            r100[MmAudioSaveIdentityType.RECORDING_ID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmAudioSaveIdentityType.MINUTES_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f434884a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f434882a, r101.f434882a) == true) goto L12;
        return false;
    L12:
        if (this.f434883b == r101.f434883b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434882a.hashCode() * 31) + this.f434883b.hashCode();
    }

    public final String toString() {
        return "MmAudioSaveIdentity(value=" + this.f434882a + ", type=" + this.f434883b + ')';
    }

    public final MmAudioSaveIdentityType getType() {
        return this.f434883b;
    }

    public c(String r100, MmAudioSaveIdentityType r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f434882a = r100;
        this.f434883b = r101;
    }
}
