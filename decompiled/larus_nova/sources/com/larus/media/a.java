package com.larus.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f358977k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioDeviceMode f358978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f358979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecordSourceType f358980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlayScenario f358981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudioInputRoutePolicy f358982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AudioOutputRoutePolicy f358983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f358984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f358985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f358986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f358987j;

    /* JADX INFO: renamed from: com.larus.media.a$a, reason: collision with other inner class name */
    public static final class C4419a {
        public static a c() {
            return new a(0);
        }

        public C4419a() {
        }

        public static /* synthetic */ a b(AudioOutputRoutePolicy r100, boolean r101, int r102) {
            if ((r102 & 8) == 0) goto L5;
            AudioInputRoutePolicy r103 = AudioInputRoutePolicy.PREFER_BLUETOOTH_WHEN_AVAILABLE;
        L7:
            if ((r102 & 16) == 0) goto L9;
            r100 = AudioOutputRoutePolicy.PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE;
        L9:
            AudioOutputRoutePolicy r104 = r100;
            if ((r102 & 32) == 0) goto L13;
            r101 = false;
        L13:
            if ((r102 & 64) == 0) goto L15;
            boolean r105 = true;
        L17:
            return a(true, false, false, r103, r104, r101, r105);
        L15:
            r105 = false;
            goto L17
        L5:
            r103 = null;
            goto L7
        }

        public static a a(boolean r110, boolean r111, boolean r112, AudioInputRoutePolicy r113, AudioOutputRoutePolicy r114, boolean r115, boolean r116) {
            Intrinsics.checkNotNullParameter(r113, "inputRoutePolicy");
            Intrinsics.checkNotNullParameter(r114, "outputRoutePolicy");
            return new a(AudioDeviceMode.COMMUNICATION, r116, RecordSourceType.VOICE_COMMUNICATION, PlayScenario.VOICE_COMMUNICATION, r113, r114, r115, r110, r111, r112);
        }
    }

    static {
        new C4419a();
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f358978a == r101.f358978a) goto L12;
        return false;
    L12:
        if (this.f358979b == r101.f358979b) goto L15;
        return false;
    L15:
        if (this.f358980c == r101.f358980c) goto L18;
        return false;
    L18:
        if (this.f358981d == r101.f358981d) goto L21;
        return false;
    L21:
        if (this.f358982e == r101.f358982e) goto L24;
        return false;
    L24:
        if (this.f358983f == r101.f358983f) goto L27;
        return false;
    L27:
        if (this.f358984g == r101.f358984g) goto L30;
        return false;
    L30:
        if (this.f358985h == r101.f358985h) goto L33;
        return false;
    L33:
        if (this.f358986i == r101.f358986i) goto L36;
        return false;
    L36:
        if (this.f358987j == r101.f358987j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f358978a.hashCode() * 31;
        int r101 = 1231;
        if (this.f358979b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 31) + this.f358980c.hashCode()) * 31) + this.f358981d.hashCode()) * 31) + this.f358982e.hashCode()) * 31) + this.f358983f.hashCode()) * 31;
        if (this.f358984g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f358985h == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f358986i == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f358987j == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioDeviceRuntimeConfig(mode=" + this.f358978a + ", applySystemCommunicationMode=" + this.f358979b + ", recordSource=" + this.f358980c + ", playScenario=" + this.f358981d + ", inputRoutePolicy=" + this.f358982e + ", outputRoutePolicy=" + this.f358983f + ", holdPlaybackDuringReconfigure=" + this.f358984g + ", enableHardwareAec=" + this.f358985h + ", enableHardwareNs=" + this.f358986i + ", enableHardwareAgc=" + this.f358987j + ')';
    }

    public /* synthetic */ a(int r110) {
        this(AudioDeviceMode.MEDIA, true, RecordSourceType.MIC, PlayScenario.MEDIA, AudioInputRoutePolicy.PREFER_BLUETOOTH_WHEN_AVAILABLE, AudioOutputRoutePolicy.DEFAULT, false, false, false, false);
    }

    public a(AudioDeviceMode r100, boolean r101, RecordSourceType r102, PlayScenario r103, AudioInputRoutePolicy r104, AudioOutputRoutePolicy r105, boolean r106, boolean r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r102, "recordSource");
        Intrinsics.checkNotNullParameter(r103, "playScenario");
        Intrinsics.checkNotNullParameter(r104, "inputRoutePolicy");
        Intrinsics.checkNotNullParameter(r105, "outputRoutePolicy");
        this.f358978a = r100;
        this.f358979b = r101;
        this.f358980c = r102;
        this.f358981d = r103;
        this.f358982e = r104;
        this.f358983f = r105;
        this.f358984g = r106;
        this.f358985h = r107;
        this.f358986i = r110;
        this.f358987j = r111;
    }
}
