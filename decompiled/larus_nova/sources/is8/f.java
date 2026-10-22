package is8;

import com.larus.bmhome.upload.sdk.api.model.FallbackPolicy;
import com.larus.bmhome.upload.sdk.api.model.PreprocessPolicy;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.TracePolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreprocessPolicy f495664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoutePolicy f495665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RegisterPolicy f495666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TracePolicy f495667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FallbackPolicy f495668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f495669f;

    public f() {
        this(null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f495664a == r101.f495664a) goto L12;
        return false;
    L12:
        if (this.f495665b == r101.f495665b) goto L15;
        return false;
    L15:
        if (this.f495666c == r101.f495666c) goto L18;
        return false;
    L18:
        if (this.f495667d == r101.f495667d) goto L21;
        return false;
    L21:
        if (this.f495668e == r101.f495668e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495669f, r101.f495669f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f495664a.hashCode() * 31) + this.f495665b.hashCode()) * 31) + this.f495666c.hashCode()) * 31) + this.f495667d.hashCode()) * 31) + this.f495668e.hashCode()) * 31) + this.f495669f.hashCode();
    }

    public final String toString() {
        return "UploadPolicy(preprocessPolicy=" + this.f495664a + ", routePolicy=" + this.f495665b + ", registerPolicy=" + this.f495666c + ", tracePolicy=" + this.f495667d + ", fallbackPolicy=" + this.f495668e + ", retryPolicy=" + this.f495669f + ')';
    }

    public f(RoutePolicy r100, RegisterPolicy r101, int r102) {
        b r103 = null;
        if ((r102 & 1) == 0) goto L5;
        PreprocessPolicy r104 = PreprocessPolicy.Auto;
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = RoutePolicy.Auto;
    L10:
        if ((r102 & 4) == 0) goto L13;
        r101 = RegisterPolicy.Auto;
    L13:
        if ((r102 & 8) == 0) goto L15;
        TracePolicy r105 = TracePolicy.Enabled;
    L17:
        if ((r102 & 16) == 0) goto L19;
        FallbackPolicy r106 = FallbackPolicy.Enabled;
    L21:
        if ((r102 & 32) == 0) goto L23;
        r103 = new b(0);
    L23:
        Intrinsics.checkNotNullParameter(r104, "preprocessPolicy");
        Intrinsics.checkNotNullParameter(r100, "routePolicy");
        Intrinsics.checkNotNullParameter(r101, "registerPolicy");
        Intrinsics.checkNotNullParameter(r105, "tracePolicy");
        Intrinsics.checkNotNullParameter(r106, "fallbackPolicy");
        Intrinsics.checkNotNullParameter(r103, "retryPolicy");
        this.f495664a = r104;
        this.f495665b = r100;
        this.f495666c = r101;
        this.f495667d = r105;
        this.f495668e = r106;
        this.f495669f = r103;
        return;
    L19:
        r106 = null;
        goto L21
    L15:
        r105 = null;
        goto L17
    L5:
        r104 = null;
        goto L7
    }
}
