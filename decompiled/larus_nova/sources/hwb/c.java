package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;
import qub.g;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gwb.b f487444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gwb.f f487445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f487446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gwb.c f487447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gwb.d f487448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmRecordingUILaunchMode f487449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f487450h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f487443a, r101.f487443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487444b, r101.f487444b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487445c, r101.f487445c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487446d, r101.f487446d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487447e, r101.f487447e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f487448f, r101.f487448f) == true) goto L27;
        return false;
    L27:
        if (this.f487449g == r101.f487449g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f487450h, r101.f487450h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f487443a.hashCode() * 31) + this.f487444b.hashCode()) * 31) + this.f487445c.hashCode()) * 31) + this.f487446d.hashCode()) * 31) + this.f487447e.hashCode()) * 31) + this.f487448f.hashCode()) * 31) + this.f487449g.hashCode()) * 31;
        g r101 = this.f487450h;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingFloatHostConfig(recordingId=" + this.f487443a + ", contentFactory=" + this.f487444b + ", styleProvider=" + this.f487445c + ", initialLayoutState=" + this.f487446d + ", callbacks=" + this.f487447e + ", sessionProvider=" + this.f487448f + ", uiLaunchMode=" + this.f487449g + ", uiModeBridge=" + this.f487450h + ')';
    }

    public c(String r100, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.a r101, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.b r102, d r103, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.b r104, gwb.d r105, MmRecordingUILaunchMode r106, g r107) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "contentFactory");
        Intrinsics.checkNotNullParameter(r102, "styleProvider");
        Intrinsics.checkNotNullParameter(r103, "initialLayoutState");
        Intrinsics.checkNotNullParameter(r104, "callbacks");
        Intrinsics.checkNotNullParameter(r105, "sessionProvider");
        Intrinsics.checkNotNullParameter(r106, "uiLaunchMode");
        this.f487443a = r100;
        this.f487444b = r101;
        this.f487445c = r102;
        this.f487446d = r103;
        this.f487447e = r104;
        this.f487448f = r105;
        this.f487449g = r106;
        this.f487450h = r107;
    }
}
