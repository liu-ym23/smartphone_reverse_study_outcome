package com.mammon.speechaudiosdk.kmp.param;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014¨\u0006 "}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "", SubInfo.KEY_FORMAT, "", "sampleRate", "", "channel", "bitRate", "enableNetTransportCompress", "", "isPlanar", "<init>", "(Ljava/lang/String;IIIZZ)V", "getFormat", "()Ljava/lang/String;", "getSampleRate", "()I", "getChannel", "getBitRate", "getEnableNetTransportCompress", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioConfigParam {
    private final int bitRate;
    private final int channel;
    private final boolean enableNetTransportCompress;
    private final String format;
    private final boolean isPlanar;
    private final int sampleRate;

    public SpeechAudioConfigParam() {
        this(null, 0, 0, 0, false, false, 63, null);
    }

    public static /* synthetic */ SpeechAudioConfigParam copy$default(SpeechAudioConfigParam r100, String r101, int r102, int r103, int r104, boolean r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.format;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.sampleRate;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.channel;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.bitRate;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.enableNetTransportCompress;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isPlanar;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.format;
    }

    public final int component2() {
        return this.sampleRate;
    }

    public final int component3() {
        return this.channel;
    }

    public final int component4() {
        return this.bitRate;
    }

    public final boolean component5() {
        return this.enableNetTransportCompress;
    }

    public final boolean component6() {
        return this.isPlanar;
    }

    public final SpeechAudioConfigParam copy(String r100, int r110, int r111, int r112, boolean r113, boolean r114) {
        return new SpeechAudioConfigParam(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechAudioConfigParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioConfigParam r101 = (SpeechAudioConfigParam) r100;
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L12;
        return false;
    L12:
        if (this.sampleRate == r101.sampleRate) goto L15;
        return false;
    L15:
        if (this.channel == r101.channel) goto L18;
        return false;
    L18:
        if (this.bitRate == r101.bitRate) goto L21;
        return false;
    L21:
        if (this.enableNetTransportCompress == r101.enableNetTransportCompress) goto L24;
        return false;
    L24:
        if (this.isPlanar == r101.isPlanar) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.format;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.sampleRate) * 31) + this.channel) * 31) + this.bitRate) * 31;
        int r103 = 1231;
        if (this.enableNetTransportCompress == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.isPlanar == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioConfigParam(format=" + this.format + ", sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", bitRate=" + this.bitRate + ", enableNetTransportCompress=" + this.enableNetTransportCompress + ", isPlanar=" + this.isPlanar + ')';
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final boolean getEnableNetTransportCompress() {
        return this.enableNetTransportCompress;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final boolean isPlanar() {
        return this.isPlanar;
    }

    public SpeechAudioConfigParam(String r100, int r101, int r102, int r103, boolean r104, boolean r105) {
        this.format = r100;
        this.sampleRate = r101;
        this.channel = r102;
        this.bitRate = r103;
        this.enableNetTransportCompress = r104;
        this.isPlanar = r105;
    }

    public /* synthetic */ SpeechAudioConfigParam(String r100, int r101, int r102, int r103, boolean r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = null;
    L5:
        boolean r105 = false;
        if ((r111 & 2) == 0) goto L8;
        int r113 = 0;
    L10:
        if ((r111 & 4) == 0) goto L12;
        int r106 = 0;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = 0;
    L18:
        if ((r111 & 16) == 0) goto L20;
        boolean r108 = false;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
