package cy8;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f465936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f465937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f465938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f465939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f465940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f465941i;

    public w() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f465933a, r101.f465933a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465934b, r101.f465934b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465935c, r101.f465935c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465936d, r101.f465936d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465937e, r101.f465937e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465938f, r101.f465938f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465939g, r101.f465939g) == true) goto L30;
        return false;
    L30:
        if (this.f465940h == r101.f465940h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465941i, r101.f465941i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f465933a.hashCode() * 31) + this.f465934b.hashCode()) * 31) + this.f465935c.hashCode()) * 31) + this.f465936d.hashCode()) * 31) + this.f465937e.hashCode()) * 31) + this.f465938f.hashCode()) * 31) + this.f465939g.hashCode()) * 31) + this.f465940h) * 31;
        Long r101 = this.f465941i;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CanvasSSEStartParams(sessionId=" + this.f465933a + ", scene=" + this.f465934b + ", path=" + this.f465935c + ", body=" + this.f465936d + ", headers=" + this.f465937e + ", queryParams=" + this.f465938f + ", timeout=" + this.f465939g + ", retryLeft=" + this.f465940h + ", sequenceId=" + this.f465941i + ')';
    }

    public w(String r100, String r101, v r102, x r103, int r104) {
        Map<String, String> r105 = MapsKt.emptyMap();
        Map<String, String> r106 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter("/creativity/canvas/generate", "path");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r105, "headers");
        Intrinsics.checkNotNullParameter(r106, "queryParams");
        Intrinsics.checkNotNullParameter(r103, "timeout");
        this.f465933a = r100;
        this.f465934b = r101;
        this.f465935c = "/creativity/canvas/generate";
        this.f465936d = r102;
        this.f465937e = r105;
        this.f465938f = r106;
        this.f465939g = r103;
        this.f465940h = r104;
        this.f465941i = null;
    }
}
