package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f435039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingUITab f435040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingWindowMode f435041f;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f435036a, r101.f435036a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435037b, r101.f435037b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435038c, r101.f435038c) == true) goto L18;
        return false;
    L18:
        if (this.f435039d == r101.f435039d) goto L21;
        return false;
    L21:
        if (this.f435040e == r101.f435040e) goto L24;
        return false;
    L24:
        if (this.f435041f == r101.f435041f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f435036a.hashCode() * 31) + this.f435037b.hashCode()) * 31) + this.f435038c.hashCode()) * 31;
        long r101 = this.f435039d;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f435040e.hashCode()) * 31) + this.f435041f.hashCode();
    }

    public final String toString() {
        return "MmRecordingMetaEntity(meetingId=" + this.f435036a + ", minutesToken=" + this.f435037b + ", topic=" + this.f435038c + ", meetingStartTime=" + this.f435039d + ", currentTab=" + this.f435040e + ", windowMode=" + this.f435041f + ')';
    }

    public /* synthetic */ b(int r100) {
        this("", "", UIHelper.getString(R.string.MMWeb_G_Record_NewRecording_Title), 0, MmRecordingUITab.SUBTITLE, MmRecordingWindowMode.FULL_SCREEN_ACTIVITY);
    }

    public b(String r100, String r101, String r102, long r103, MmRecordingUITab r104, MmRecordingWindowMode r105) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Intrinsics.checkNotNullParameter(r101, "minutesToken");
        Intrinsics.checkNotNullParameter(r102, "topic");
        Intrinsics.checkNotNullParameter(r104, "currentTab");
        Intrinsics.checkNotNullParameter(r105, "windowMode");
        this.f435036a = r100;
        this.f435037b = r101;
        this.f435038c = r102;
        this.f435039d = r103;
        this.f435040e = r104;
        this.f435041f = r105;
    }

    public static b a(b r100, String r101, String r110, String r111, long r112, MmRecordingUITab r113, MmRecordingWindowMode r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r102 = r100.f435036a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r103 = r100.f435037b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r104 = r100.f435038c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        long r105 = r100.f435039d;
    L19:
        if ((r115 & 16) == 0) goto L21;
        MmRecordingUITab r106 = r100.f435040e;
    L23:
        if ((r115 & 32) == 0) goto L25;
        MmRecordingWindowMode r107 = r100.f435041f;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "meetingId");
        Intrinsics.checkNotNullParameter(r103, "minutesToken");
        Intrinsics.checkNotNullParameter(r104, "topic");
        Intrinsics.checkNotNullParameter(r106, "currentTab");
        Intrinsics.checkNotNullParameter(r107, "windowMode");
        return new b(r102, r103, r104, r105, r106, r107);
    L25:
        r107 = r114;
        goto L26
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
