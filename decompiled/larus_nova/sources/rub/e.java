package rub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ToastType f539331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f539332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingUILaunchMode f539333e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f539329a, r101.f539329a) == true) goto L12;
        return false;
    L12:
        if (this.f539330b == r101.f539330b) goto L15;
        return false;
    L15:
        if (this.f539331c == r101.f539331c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f539332d, r101.f539332d) == true) goto L21;
        return false;
    L21:
        if (this.f539333e == r101.f539333e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f539329a.hashCode() * 31) + this.f539330b) * 31) + this.f539331c.hashCode()) * 31;
        Integer r101 = this.f539332d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f539333e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmToastConfig(content=" + this.f539329a + ", duration=" + this.f539330b + ", type=" + this.f539331c + ", iconRes=" + this.f539332d + ", uiLaunchMode=" + this.f539333e + ')';
    }

    public final ToastType getType() {
        return this.f539331c;
    }

    public static e a(e r100, MmRecordingUILaunchMode r101) {
        String r102 = r100.f539329a;
        int r103 = r100.f539330b;
        ToastType r104 = r100.f539331c;
        Integer r105 = r100.f539332d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r104, "type");
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
        return new e(r102, r103, r104, r105, r101);
    }

    public /* synthetic */ e(String r100, ToastType r101, MmRecordingUILaunchMode r102, int r110) {
        if ((r110 & 4) == 0) goto L5;
        r101 = ToastType.NORMAL;
    L5:
        ToastType r103 = r101;
        if ((r110 & 16) == 0) goto L8;
        r102 = MmRecordingUILaunchMode.UNKNOWN;
    L8:
        this(r100, 0, r103, null, r102);
    }

    public e(String r100, int r101, ToastType r102, Integer r103, MmRecordingUILaunchMode r104) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r104, "uiLaunchMode");
        this.f539329a = r100;
        this.f539330b = r101;
        this.f539331c = r102;
        this.f539332d = r103;
        this.f539333e = r104;
    }
}
