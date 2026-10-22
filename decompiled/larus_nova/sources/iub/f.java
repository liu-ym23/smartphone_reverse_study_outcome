package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f495828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmMarkedSpeakerType f495829g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f495823a, r101.f495823a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495824b, r101.f495824b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495825c, r101.f495825c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495826d, r101.f495826d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495827e, r101.f495827e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495828f, r101.f495828f) == true) goto L27;
        return false;
    L27:
        if (this.f495829g == r101.f495829g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f495823a.hashCode() * 31) + this.f495824b.hashCode()) * 31) + this.f495825c.hashCode()) * 31) + this.f495826d.hashCode()) * 31) + this.f495827e.hashCode()) * 31) + this.f495828f.hashCode()) * 31) + this.f495829g.hashCode();
    }

    public final String toString() {
        return "MmMarkedSpeakerData(id=" + this.f495823a + ", name=" + this.f495824b + ", department=" + this.f495825c + ", avatarUrl=" + this.f495826d + ", imageKey=" + this.f495827e + ", imageFsUnit=" + this.f495828f + ", speakerType=" + this.f495829g + ')';
    }

    public f() {
        this("", "", "", "", "", "", MmMarkedSpeakerType.CLUSTER_ID);
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, MmMarkedSpeakerType r106) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "department");
        Intrinsics.checkNotNullParameter(r103, "avatarUrl");
        Intrinsics.checkNotNullParameter(r104, "imageKey");
        Intrinsics.checkNotNullParameter(r105, "imageFsUnit");
        Intrinsics.checkNotNullParameter(r106, "speakerType");
        this.f495823a = r100;
        this.f495824b = r101;
        this.f495825c = r102;
        this.f495826d = r103;
        this.f495827e = r104;
        this.f495828f = r105;
        this.f495829g = r106;
    }
}
