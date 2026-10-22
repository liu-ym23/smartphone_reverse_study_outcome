package fd2;

import com.bytedance.android.livesdk.message.model.ed;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ed> f476480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f476482d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L14;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f476479a, r101.f476479a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476480b, r101.f476480b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f476481c, r101.f476481c) == true) goto L12;
        return false;
    L12:
        if (this.f476482d == r101.f476482d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f476479a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ed> r104 = this.f476480b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f476481c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f476482d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MvInfoServiceData(vid=" + this.f476479a + ", colorList=" + this.f476480b + ", mvFilePath=" + this.f476481c + ", duration=" + this.f476482d + ")";
    }

    public c0(String r100, List<ed> r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        this.f476479a = r100;
        this.f476480b = r101;
        this.f476481c = r102;
        this.f476482d = r103;
    }
}
