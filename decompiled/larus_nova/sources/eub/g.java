package eub;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmMinutesFileUploadTaskState f474162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f474168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmMinutesFileUploadTaskState f474169h;

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f474162a == r101.f474162a) goto L12;
        return false;
    L12:
        if (this.f474163b == r101.f474163b) goto L15;
        return false;
    L15:
        if (this.f474164c == r101.f474164c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474165d, r101.f474165d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474166e, r101.f474166e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474167f, r101.f474167f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474168g, r101.f474168g) == true) goto L30;
        return false;
    L30:
        if (this.f474169h == r101.f474169h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f474162a.hashCode() * 31) + this.f474163b) * 31) + this.f474164c) * 31) + this.f474165d.hashCode()) * 31) + this.f474166e.hashCode()) * 31) + this.f474167f.hashCode()) * 31;
        b r101 = this.f474168g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        MmMinutesFileUploadTaskState r105 = this.f474169h;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadTaskStatus(state=" + this.f474162a + ", progress=" + this.f474163b + ", speedKBps=" + this.f474164c + ", objectToken=" + this.f474165d + ", vhId=" + this.f474166e + ", uploadId=" + this.f474167f + ", error=" + this.f474168g + ", lastState=" + this.f474169h + ')';
    }

    public /* synthetic */ g(MmMinutesFileUploadTaskState r110, b r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r110 = MmMinutesFileUploadTaskState.Init;
    L5:
        MmMinutesFileUploadTaskState r100 = r110;
        if ((r112 & 8) == 0) goto L8;
        String r113 = "";
    L10:
        if ((r112 & 16) == 0) goto L12;
        String r101 = "";
    L14:
        if ((r112 & 32) == 0) goto L16;
        String r102 = "";
    L18:
        if ((r112 & 64) == 0) goto L20;
        b r103 = null;
    L21:
        this(r100, 0, 0, r113, r101, r102, r103, null);
        return;
    L20:
        r103 = r111;
        goto L21
    L16:
        r102 = null;
        goto L18
    L12:
        r101 = null;
        goto L14
    L8:
        r113 = null;
        goto L10
    }

    public g(MmMinutesFileUploadTaskState r100, int r101, int r102, String r103, String r104, String r105, b r106, MmMinutesFileUploadTaskState r107) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r103, "objectToken");
        Intrinsics.checkNotNullParameter(r104, "vhId");
        Intrinsics.checkNotNullParameter(r105, "uploadId");
        this.f474162a = r100;
        this.f474163b = r101;
        this.f474164c = r102;
        this.f474165d = r103;
        this.f474166e = r104;
        this.f474167f = r105;
        this.f474168g = r106;
        this.f474169h = r107;
    }

    public static g a(g r100, MmMinutesFileUploadTaskState r110, int r111, int r112, String r113, String r114, String r115, b r116, MmMinutesFileUploadTaskState r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        MmMinutesFileUploadTaskState r101 = r100.f474162a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.f474163b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.f474164c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.f474165d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.f474166e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.f474167f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        b r107 = r100.f474168g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        MmMinutesFileUploadTaskState r108 = r100.f474169h;
    L34:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r104, "objectToken");
        Intrinsics.checkNotNullParameter(r105, "vhId");
        Intrinsics.checkNotNullParameter(r106, "uploadId");
        return new g(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
