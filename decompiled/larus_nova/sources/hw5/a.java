package hw5;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowAsrErrorType f487417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f487421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f487422f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f487417a == r101.f487417a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487418b, r101.f487418b) == true) goto L15;
        return false;
    L15:
        if (this.f487419c == r101.f487419c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487420d, r101.f487420d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487421e, r101.f487421e) == true) goto L24;
        return false;
    L24:
        if (this.f487422f == r101.f487422f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f487417a.hashCode() * 31) + this.f487418b.hashCode()) * 31) + this.f487419c) * 31) + this.f487420d.hashCode()) * 31;
        a r101 = this.f487421e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f487422f;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowAsrError(type=" + this.f487417a + ", errorMessage=" + this.f487418b + ", errorCode=" + this.f487419c + ", raw=" + this.f487420d + ", cause=" + this.f487421e + ", retryCount=" + this.f487422f + ')';
    }

    public final FlowAsrErrorType getType() {
        return this.f487417a;
    }

    public /* synthetic */ a(FlowAsrErrorType r100, String r101, int r110, String r111) {
        this(r100, r101, r110, r111, null, 0);
    }

    public a(FlowAsrErrorType r100, String r101, int r102, String r103, a r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Intrinsics.checkNotNullParameter(r103, TemplateNodeType.RAW);
        this.f487417a = r100;
        this.f487418b = r101;
        this.f487419c = r102;
        this.f487420d = r103;
        this.f487421e = r104;
        this.f487422f = r105;
    }
}
