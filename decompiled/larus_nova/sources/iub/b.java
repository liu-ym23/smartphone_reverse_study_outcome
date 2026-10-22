package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmAIInterpretationEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmAIInterpretationEventType f495805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f495806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f495807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f495809e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f495805a == r101.f495805a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495806b, r101.f495806b) == true) goto L15;
        return false;
    L15:
        if (this.f495807c == r101.f495807c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495808d, r101.f495808d) == true) goto L21;
        return false;
    L21:
        if (this.f495809e == r101.f495809e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495805a.hashCode() * 31;
        n r101 = this.f495806b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + this.f495807c) * 31) + this.f495808d.hashCode()) * 31) + this.f495809e;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmAIInterpretationEvent(type=" + this.f495805a + ", language=" + this.f495806b + ", errorCode=" + this.f495807c + ", message=" + this.f495808d + ", statusCode=" + this.f495809e + ')';
    }

    public final MmAIInterpretationEventType getType() {
        return this.f495805a;
    }

    public b(MmAIInterpretationEventType r100, n r101, String r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f495805a = r100;
        this.f495806b = r101;
        this.f495807c = 0;
        this.f495808d = r102;
        this.f495809e = r103;
    }
}
