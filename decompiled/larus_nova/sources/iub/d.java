package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmDisplayAvatarTypeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmDisplayAvatarTypeData f495813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495816d;

    public d() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f495813a == r101.f495813a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495814b, r101.f495814b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495815c, r101.f495815c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495816d, r101.f495816d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f495813a.hashCode() * 31) + this.f495814b.hashCode()) * 31) + this.f495815c.hashCode()) * 31) + this.f495816d.hashCode();
    }

    public final String toString() {
        return "MmDisplayAvatarData(type=" + this.f495813a + ", key=" + this.f495814b + ", url=" + this.f495815c + ", userId=" + this.f495816d + ')';
    }

    public final MmDisplayAvatarTypeData getType() {
        return this.f495813a;
    }

    public d(MmDisplayAvatarTypeData r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = MmDisplayAvatarTypeData.NONE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "userId");
        this.f495813a = r100;
        this.f495814b = r101;
        this.f495815c = r102;
        this.f495816d = r103;
    }
}
