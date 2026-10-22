package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f435078h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSpeakerCandidateType f435079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f435082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f435083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f435084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmMarkedSpeakerType f435085g;

    public static final class a {
        public static e a(LarkSpeakerInfo r100) {
            MmRecordingSpeakerCandidateType r101 = MmRecordingSpeakerCandidateType.NORMAL;
            if (r100 == null) goto L6;
            String r102 = r100.mid;
            if (r102 == null) goto L6;
        L7:
            if (r100 == null) goto L10;
            String r103 = r100.mname;
            if (r103 == null) goto L10;
        L11:
            if (r100 == null) goto L14;
            String r104 = r100.mdepartment;
            if (r104 == null) goto L14;
        L16:
            if (r100 == null) goto L20;
            Image r105 = r100.mavatar;
            if (r105 == null) goto L20;
            d r106 = new d(r105.mkey, r105.mfs_unit);
        L22:
            return new e(r101, r102, r103, r104, null, r106, MmMarkedSpeakerType.LARK_USER, 16);
        L20:
            r106 = null;
        L14:
            r104 = "";
        L10:
            r103 = "";
        L6:
            r102 = "";
            goto L7
        }

        public static e b(SpeakerInfo r110) {
            MmRecordingSpeakerCandidateType r100 = MmRecordingSpeakerCandidateType.NORMAL;
            if (r110 == null) goto L6;
            String r101 = r110.mid;
            if (r101 == null) goto L6;
        L7:
            if (r110 == null) goto L10;
            String r102 = r110.mname;
            if (r102 == null) goto L10;
        L12:
            if (r110 == null) goto L17;
            String r111 = r110.mavatar;
            if (r111 == null) goto L17;
            String r103 = r111;
        L19:
            return new e(r100, r101, r102, null, r103, null, MmMarkedSpeakerType.TEMPORARY, 40);
        L17:
            r103 = "";
        L10:
            r102 = "";
        L6:
            r101 = "";
            goto L7
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435086a = null;

        static {
            int[] r100 = new int[MmMarkedSpeakerType.values().length];
            r100[MmMarkedSpeakerType.LARK_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmMarkedSpeakerType.TEMPORARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmMarkedSpeakerType.CLUSTER_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f435086a = r100;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f435079a == r101.f435079a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435080b, r101.f435080b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435081c, r101.f435081c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435082d, r101.f435082d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435083e, r101.f435083e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435084f, r101.f435084f) == true) goto L27;
        return false;
    L27:
        if (this.f435085g == r101.f435085g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f435079a.hashCode() * 31) + this.f435080b.hashCode()) * 31) + this.f435081c.hashCode()) * 31) + this.f435082d.hashCode()) * 31) + this.f435083e.hashCode()) * 31;
        d r101 = this.f435084f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f435085g.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        int r100 = b.f435086a[this.f435085g.ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 != 3) goto L13;
        if (this.f435079a != MmRecordingSpeakerCandidateType.ADD_NEW) goto L18;
        return "MmSpeakerCandidate(type=" + this.f435079a + ", name='" + this.f435081c + "', speakerType=" + this.f435085g + ')';
    L18:
        return "MmSpeakerCandidate(type=" + this.f435079a + ", id='" + this.f435080b + "', name='" + this.f435081c + "', avatarUrl='" + this.f435083e + "', speakerType=" + this.f435085g + ')';
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        return "MmSpeakerCandidate(type=" + this.f435079a + ", id='" + this.f435080b + "', name='" + this.f435081c + "', avatarUrl='" + this.f435083e + "', speakerType=" + this.f435085g + ')';
    L16:
        return "MmSpeakerCandidate(type=" + this.f435079a + ", id='" + this.f435080b + "', name='" + this.f435081c + "', department='" + this.f435082d + "', image=" + this.f435084f + ", speakerType=" + this.f435085g + ')';
    }

    public final MmRecordingSpeakerCandidateType getType() {
        return this.f435079a;
    }

    public e(MmRecordingSpeakerCandidateType r100, String r101, String r102, String r103, String r104, d r105, MmMarkedSpeakerType r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = "";
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = "";
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r106 = MmMarkedSpeakerType.CLUSTER_ID;
    L20:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "department");
        Intrinsics.checkNotNullParameter(r104, "avatarUrl");
        Intrinsics.checkNotNullParameter(r106, "speakerType");
        this.f435079a = r100;
        this.f435080b = r101;
        this.f435081c = r102;
        this.f435082d = r103;
        this.f435083e = r104;
        this.f435084f = r105;
        this.f435085g = r106;
    }
}
