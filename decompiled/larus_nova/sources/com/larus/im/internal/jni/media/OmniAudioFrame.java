package com.larus.im.internal.jni.media;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003JS\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010*\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "", "data", "", SubInfo.KEY_FORMAT, "Lcom/larus/im/internal/jni/media/OmniAudioFormat;", "refData", "amplitude", "", "timestamp", "", "extData", "", "muted", "", "<init>", "([BLcom/larus/im/internal/jni/media/OmniAudioFormat;[BFJLjava/lang/String;Z)V", "getData", "()[B", "getFormat", "()Lcom/larus/im/internal/jni/media/OmniAudioFormat;", "getRefData", "getAmplitude", "()F", "getTimestamp", "()J", "getExtData", "()Ljava/lang/String;", "getMuted", "()Z", "equals", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "toString", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioFrame {
    private final float amplitude;
    private final byte[] data;
    private final String extData;
    private final OmniAudioFormat format;
    private final boolean muted;
    private final byte[] refData;
    private final long timestamp;

    public static /* synthetic */ OmniAudioFrame copy$default(OmniAudioFrame r100, byte[] r110, OmniAudioFormat r111, byte[] r112, float r113, long r114, String r115, boolean r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        byte[] r101 = r100.data;
    L7:
        if ((r117 & 2) == 0) goto L9;
        OmniAudioFormat r102 = r100.format;
    L11:
        if ((r117 & 4) == 0) goto L13;
        byte[] r103 = r100.refData;
    L15:
        if ((r117 & 8) == 0) goto L17;
        float r104 = r100.amplitude;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.timestamp;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.extData;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.muted;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final byte[] component1() {
        return this.data;
    }

    public final OmniAudioFormat component2() {
        return this.format;
    }

    public final byte[] component3() {
        return this.refData;
    }

    public final float component4() {
        return this.amplitude;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.extData;
    }

    public final boolean component7() {
        return this.muted;
    }

    public final OmniAudioFrame copy(byte[] r110, OmniAudioFormat r111, byte[] r112, float r113, long r114, String r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, SubInfo.KEY_FORMAT);
        return new OmniAudioFrame(r110, r111, r112, r113, r114, r115, r116);
    }

    public String toString() {
        return "OmniAudioFrame(data=" + Arrays.toString(this.data) + ", format=" + this.format + ", refData=" + Arrays.toString(this.refData) + ", amplitude=" + this.amplitude + ", timestamp=" + this.timestamp + ", extData=" + this.extData + ", muted=" + this.muted + ')';
    }

    public int hashCode() {
        int r100 = ((Float.floatToIntBits(this.amplitude) * 31) + Arrays.hashCode(this.data)) * 31;
        byte[] r101 = this.refData;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = Arrays.hashCode(r101);
    L6:
        long r104 = this.timestamp;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.extData;
        if (r106 == null) goto L9;
        r102 = r106.hashCode();
    L9:
        int r107 = (r105 + r102) * 31;
        if (this.muted == false) goto L12;
        int r108 = 1231;
    L14:
        return r107 + r108;
    L12:
        r108 = 1237;
        goto L14
    L5:
        r103 = 0;
        goto L6
    }

    public final float getAmplitude() {
        return this.amplitude;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getExtData() {
        return this.extData;
    }

    public final OmniAudioFormat getFormat() {
        return this.format;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final byte[] getRefData() {
        return this.refData;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAudioFrame) == true) goto L8;
        return false;
    L8:
        OmniAudioFrame r101 = (OmniAudioFrame) r100;
        if (this.amplitude != r101.amplitude) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.refData, r101.refData) == true) goto L21;
        return false;
    L21:
        if (this.timestamp == r101.timestamp) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extData, r101.extData) == true) goto L27;
        return false;
    L27:
        if (this.muted == r101.muted) goto L29;
        return false;
    L29:
        return true;
    L11:
        r102 = false;
        goto L12
    }

    public OmniAudioFrame(byte[] r100, OmniAudioFormat r101, byte[] r102, float r103, long r104, String r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        this.data = r100;
        this.format = r101;
        this.refData = r102;
        this.amplitude = r103;
        this.timestamp = r104;
        this.extData = r105;
        this.muted = r106;
    }

    public /* synthetic */ OmniAudioFrame(byte[] r110, OmniAudioFormat r111, byte[] r112, float r113, long r114, String r115, boolean r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 4) == 0) goto L5;
        byte[] r100 = null;
    L7:
        if ((r210 & 8) == 0) goto L9;
        float r101 = 0.0f;
    L11:
        if ((r210 & 16) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r210 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r210 & 64) == 0) goto L21;
        boolean r117 = false;
    L22:
        this(r110, r111, r100, r101, r102, r103, r117);
        return;
    L21:
        r117 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
