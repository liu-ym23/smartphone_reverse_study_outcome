package com.larus.im.internal.jni.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVAudioFrameData;", "", "data", "", "refData", "extraJson", "", "sampleRate", "", "channel", "bitDepth", "<init>", "([B[BLjava/lang/String;III)V", "getData", "()[B", "getRefData", "getExtraJson", "()Ljava/lang/String;", "getSampleRate", "()I", "getChannel", "getBitDepth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVAudioFrameData {
    private final int bitDepth;
    private final int channel;
    private final byte[] data;
    private final String extraJson;
    private final byte[] refData;
    private final int sampleRate;

    public static /* synthetic */ OmniAVAudioFrameData copy$default(OmniAVAudioFrameData r100, byte[] r101, byte[] r102, String r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.refData;
    L8:
        byte[] r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.extraJson;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.sampleRate;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.channel;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.bitDepth;
    L20:
        byte[] r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final byte[] component1() {
        return this.data;
    }

    public final byte[] component2() {
        return this.refData;
    }

    public final String component3() {
        return this.extraJson;
    }

    public final int component4() {
        return this.sampleRate;
    }

    public final int component5() {
        return this.channel;
    }

    public final int component6() {
        return this.bitDepth;
    }

    public final OmniAVAudioFrameData copy(byte[] r100, byte[] r110, String r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new OmniAVAudioFrameData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAVAudioFrameData) == true) goto L8;
        return false;
    L8:
        OmniAVAudioFrameData r101 = (OmniAVAudioFrameData) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refData, r101.refData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraJson, r101.extraJson) == true) goto L18;
        return false;
    L18:
        if (this.sampleRate == r101.sampleRate) goto L21;
        return false;
    L21:
        if (this.channel == r101.channel) goto L24;
        return false;
    L24:
        if (this.bitDepth == r101.bitDepth) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = Arrays.hashCode(this.data) * 31;
        byte[] r101 = this.refData;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.extraJson;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((((r104 + r102) * 31) + this.sampleRate) * 31) + this.channel) * 31) + this.bitDepth;
    L5:
        r103 = Arrays.hashCode(r101);
        goto L6
    }

    public String toString() {
        return "OmniAVAudioFrameData(data=" + Arrays.toString(this.data) + ", refData=" + Arrays.toString(this.refData) + ", extraJson=" + this.extraJson + ", sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", bitDepth=" + this.bitDepth + ')';
    }

    public final int getBitDepth() {
        return this.bitDepth;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getExtraJson() {
        return this.extraJson;
    }

    public final byte[] getRefData() {
        return this.refData;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public OmniAVAudioFrameData(byte[] r100, byte[] r101, String r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.refData = r101;
        this.extraJson = r102;
        this.sampleRate = r103;
        this.channel = r104;
        this.bitDepth = r105;
    }

    public /* synthetic */ OmniAVAudioFrameData(byte[] r100, byte[] r101, String r102, int r103, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        String r104 = null;
        if ((r112 & 2) == 0) goto L5;
        byte[] r105 = null;
    L7:
        if ((r112 & 4) != 0) goto L10;
        r104 = r102;
    L10:
        int r106 = 0;
        if ((r112 & 8) == 0) goto L13;
        int r107 = 0;
    L15:
        if ((r112 & 16) != 0) goto L19;
        r106 = r110;
    L19:
        if ((r112 & 32) == 0) goto L21;
        int r108 = 16;
    L22:
        this(r100, r105, r104, r107, r106, r108);
        return;
    L21:
        r108 = r111;
        goto L22
    L13:
        r107 = r103;
        goto L15
    L5:
        r105 = r101;
        goto L7
    }
}
