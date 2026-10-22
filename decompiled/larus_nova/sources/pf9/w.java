package pf9;

import com.larus.im.service.audio.z0;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f528975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f528976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h> f528978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f528979e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f528975a == r101.f528975a) goto L12;
        return false;
    L12:
        if (this.f528976b == r101.f528976b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528977c, r101.f528977c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528978d, r101.f528978d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528979e, r101.f528979e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f528975a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f528976b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f528977c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r102 + r105) * 31) + this.f528978d.hashCode()) * 31;
        Map<String, String> r107 = this.f528979e;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowLLMImageUploadFinish(success=" + this.f528975a + ", code=" + this.f528976b + ", message=" + this.f528977c + ", results=" + this.f528978d + ", ext=" + this.f528979e + ')';
    }

    public w(boolean r100, long r101, String r102, List<h> r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r103, "results");
        this.f528975a = r100;
        this.f528976b = r101;
        this.f528977c = r102;
        this.f528978d = r103;
        this.f528979e = r104;
    }
}
