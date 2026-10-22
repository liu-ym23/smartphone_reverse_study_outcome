package com.ss.android.lark.audio.recorder;

import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f409110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f409112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f409113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f409114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f409115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f409116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f409117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f409118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f409119k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f409109a, r101.f409109a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409110b, r101.f409110b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409111c, r101.f409111c) == true) goto L18;
        return false;
    L18:
        if (this.f409112d == r101.f409112d) goto L21;
        return false;
    L21:
        if (this.f409113e == r101.f409113e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409114f, r101.f409114f) == true) goto L27;
        return false;
    L27:
        if (this.f409115g == r101.f409115g) goto L30;
        return false;
    L30:
        if (this.f409116h == r101.f409116h) goto L33;
        return false;
    L33:
        if (this.f409117i == r101.f409117i) goto L36;
        return false;
    L36:
        if (this.f409118j == r101.f409118j) goto L39;
        return false;
    L39:
        if (this.f409119k == r101.f409119k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((this.f409109a.hashCode() * 31) + this.f409110b.hashCode()) * 31) + this.f409111c.hashCode()) * 31) + this.f409112d) * 31) + this.f409113e) * 31) + this.f409114f.hashCode()) * 31) + this.f409115g) * 31) + this.f409116h) * 31) + this.f409117i) * 31) + this.f409118j) * 31;
        if (this.f409119k == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AudioRecordConfig(scene=" + this.f409109a + ", compatStrategy=" + this.f409110b + ", audioRecordToken=" + this.f409111c + ", notifyCallbackInterval=" + this.f409112d + ", notifyCallbackFrameSize=" + this.f409113e + ", encoder=" + this.f409114f + ", sampleRateInHz=" + this.f409115g + ", channelConfig=" + this.f409116h + ", audioFormat=" + this.f409117i + ", audioSource=" + this.f409118j + ", needHandleInterruptEvent=" + this.f409119k + ')';
    }

    public static c a(c r110, int r111, AudioRecordHelper.a r112) {
        String r100 = r110.f409109a;
        b r101 = r110.f409110b;
        String r102 = r110.f409111c;
        int r103 = r110.f409113e;
        int r104 = r110.f409115g;
        int r105 = r110.f409116h;
        int r106 = r110.f409117i;
        int r113 = r110.f409118j;
        boolean r114 = r110.f409119k;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "compatStrategy");
        Intrinsics.checkNotNullParameter(r102, "audioRecordToken");
        Intrinsics.checkNotNullParameter(r112, "encoder");
        return new c(r100, r101, r102, r111, r103, r112, r104, r105, r106, r113, r114);
    }

    public /* synthetic */ c(String r110, b r111, String r112, int r113, boolean r210, int r211) {
        if ((r211 & 16) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r211 & 32) == 0) goto L9;
        j r101 = AudioEncoder.ENCODER_OPUS.encoder();
    L10:
        j r102 = r101;
        if ((r211 & 64) == 0) goto L13;
        int r114 = 16000;
    L15:
        if ((r211 & 128) == 0) goto L17;
        int r115 = 16;
    L19:
        if ((r211 & 256) == 0) goto L21;
        int r116 = 2;
    L23:
        if ((r211 & 512) == 0) goto L25;
        int r117 = 1;
    L27:
        if ((r211 & 1024) == 0) goto L29;
        boolean r118 = false;
    L30:
        this(r110, r111, r112, r113, r100, r102, r114, r115, r116, r117, r118);
        return;
    L29:
        r118 = r210;
        goto L30
    L25:
        r117 = 0;
        goto L27
    L21:
        r116 = 0;
        goto L23
    L17:
        r115 = 0;
        goto L19
    L13:
        r114 = 0;
        goto L15
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = 0;
        goto L7
    }

    public c(String r100, b r101, String r102, int r103, int r104, j r105, int r106, int r107, int r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "compatStrategy");
        Intrinsics.checkNotNullParameter(r102, "audioRecordToken");
        Intrinsics.checkNotNullParameter(r105, "encoder");
        this.f409109a = r100;
        this.f409110b = r101;
        this.f409111c = r102;
        this.f409112d = r103;
        this.f409113e = r104;
        this.f409114f = r105;
        this.f409115g = r106;
        this.f409116h = r107;
        this.f409117i = r110;
        this.f409118j = r111;
        this.f409119k = r112;
    }
}
