package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f435068g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f435072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f435073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmMarkedSpeakerType f435074f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435075a = null;

        static {
            int[] r100 = new int[MmMarkedSpeakerType.values().length];
            r100[MmMarkedSpeakerType.LARK_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmMarkedSpeakerType.TEMPORARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmMarkedSpeakerType.CLUSTER_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f435075a = r100;
        }
    }

    static {
    }

    public c() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f435069a, r101.f435069a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435070b, r101.f435070b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435071c, r101.f435071c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435072d, r101.f435072d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435073e, r101.f435073e) == true) goto L24;
        return false;
    L24:
        if (this.f435074f == r101.f435074f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f435069a.hashCode() * 31) + this.f435070b.hashCode()) * 31) + this.f435071c.hashCode()) * 31) + this.f435072d.hashCode()) * 31;
        d r101 = this.f435073e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f435074f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        int r100 = b.f435075a[this.f435074f.ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return "MmMarkedSpeaker(id='" + this.f435069a + "', name='" + this.f435070b + "', avatarUrl='" + this.f435072d + "', speakerType=" + this.f435074f + ')';
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return "MmMarkedSpeaker(id='" + this.f435069a + "', name='" + this.f435070b + "', avatarUrl='" + this.f435072d + "', speakerType=" + this.f435074f + ')';
    L13:
        return "MmMarkedSpeaker(id='" + this.f435069a + "', name='" + this.f435070b + "', department='" + this.f435071c + "', image=" + this.f435073e + ", speakerType=" + this.f435074f + ')';
    }

    public c(String r100, String r101, String r102, String r103, d r104, MmMarkedSpeakerType r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "department");
        Intrinsics.checkNotNullParameter(r103, "avatarUrl");
        Intrinsics.checkNotNullParameter(r105, "speakerType");
        this.f435069a = r100;
        this.f435070b = r101;
        this.f435071c = r102;
        this.f435072d = r103;
        this.f435073e = r104;
        this.f435074f = r105;
    }

    public /* synthetic */ c(String r100, String r101, String r102, String r103, d r110, MmMarkedSpeakerType r111, int r112) {
        String r104 = "";
        if ((r112 & 1) == 0) goto L5;
        String r105 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r107 = "";
    L15:
        if ((r112 & 8) != 0) goto L19;
        r104 = r103;
    L19:
        if ((r112 & 16) == 0) goto L21;
        r110 = null;
    L21:
        d r108 = r110;
        if ((r112 & 32) == 0) goto L24;
        r111 = MmMarkedSpeakerType.CLUSTER_ID;
    L24:
        String r109 = r105;
        String r113 = r106;
        String r114 = r107;
        String r115 = r104;
        this(r109, r113, r114, r115, r108, r111);
        return;
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r105 = r100;
        goto L7
    }
}
