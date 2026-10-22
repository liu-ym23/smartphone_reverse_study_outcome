package dwb;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingSlotKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dwb.a f470395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dwb.a f470396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dwb.a f470397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dwb.a f470398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f470399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f470400f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f470401a = null;

        static {
            int[] r100 = new int[MmRecordingSlotKey.values().length];
            r100[MmRecordingSlotKey.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MmRecordingSlotKey.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MmRecordingSlotKey.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MmRecordingSlotKey.TOOLBAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f470401a = r100;
        }
    }

    public b() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f470395a, r101.f470395a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470396b, r101.f470396b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470397c, r101.f470397c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470398d, r101.f470398d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470399e, r101.f470399e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f470400f, r101.f470400f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        dwb.a r100 = this.f470395a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        dwb.a r104 = this.f470396b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        dwb.a r107 = this.f470397c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        dwb.a r110 = this.f470398d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((((r109 + r101) * 31) + this.f470399e.hashCode()) * 31) + this.f470400f.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingSlotsConfig(top=" + this.f470395a + ", title=" + this.f470396b + ", middle=" + this.f470397c + ", toolbar=" + this.f470398d + ", contentPolicy=" + this.f470399e + ", layoutPolicy=" + this.f470400f + ')';
    }

    public b(dwb.a.b r100, dwb.a.b r101, dwb.a.b r102, c r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 16) == 0) goto L15;
        r103 = new c(false);
    L15:
        if ((r104 & 32) == 0) goto L17;
        d r105 = new d(0);
    L18:
        Intrinsics.checkNotNullParameter(r103, "contentPolicy");
        Intrinsics.checkNotNullParameter(r105, "layoutPolicy");
        this.f470395a = r100;
        this.f470396b = r101;
        this.f470397c = null;
        this.f470398d = r102;
        this.f470399e = r103;
        this.f470400f = r105;
        return;
    L17:
        r105 = null;
        goto L18
    }
}
