package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f528982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f528983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f528985f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f528980a, r101.f528980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528981b, r101.f528981b) == true) goto L15;
        return false;
    L15:
        if (this.f528982c == r101.f528982c) goto L18;
        return false;
    L18:
        if (this.f528983d == r101.f528983d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528984e, r101.f528984e) == true) goto L24;
        return false;
    L24:
        if (this.f528985f == r101.f528985f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528980a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f528981b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f528982c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f528983d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f528984e;
        if (r111 == null) goto L14;
        r101 = r111.hashCode();
    L14:
        int r112 = (r110 + r101) * 31;
        if (this.f528985f == false) goto L17;
        int r113 = 1231;
    L19:
        return r112 + r113;
    L17:
        r113 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLLMQueryBeginEvent(questionID=" + this.f528980a + ", asrTaskID=" + this.f528981b + ", roundID=" + this.f528982c + ", startListenTimestampMs=" + this.f528983d + ", localMessageId=" + this.f528984e + ", continueTts=" + this.f528985f + ')';
    }

    public z(String r100, String r101, long r102, long r103, String r104, boolean r105) {
        this.f528980a = r100;
        this.f528981b = r101;
        this.f528982c = r102;
        this.f528983d = r103;
        this.f528984e = r104;
        this.f528985f = r105;
    }
}
