package ye1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f567358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f567359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f567361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f567362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f567363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f567364g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f567358a == r101.f567358a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f567359b, r101.f567359b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f567360c, r101.f567360c) == true) goto L12;
        return false;
    L12:
        if (this.f567361d == r101.f567361d) goto L14;
        return false;
    L14:
        if (this.f567362e == r101.f567362e) goto L16;
        return false;
    L16:
        if (this.f567363f == r101.f567363f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f567364g, r101.f567364g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean r100 = this.f567358a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f567359b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f567360c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        long r109 = this.f567361d;
        int r110 = (((r106 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f567362e;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f567363f;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        IRoom r115 = this.f567364g;
        if (r115 == null) goto L17;
        r104 = r115.hashCode();
    L17:
        return r114 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "BackupSeiInfo[isFromBackup = " + this.f567358a + ", backupSource = " + this.f567359b + ", streamId = " + this.f567360c + ", backupPts = " + this.f567361d + ", timeDiff = " + this.f567363f + ']';
    }

    public a(boolean r100, String r101, long r102, long r103, long r104, IRoom r110) {
        Intrinsics.checkNotNullParameter(r101, "backupSource");
        Intrinsics.checkNotNullParameter("", "streamId");
        this.f567358a = r100;
        this.f567359b = r101;
        this.f567360c = "";
        this.f567361d = r102;
        this.f567362e = r103;
        this.f567363f = r104;
        this.f567364g = r110;
    }
}
