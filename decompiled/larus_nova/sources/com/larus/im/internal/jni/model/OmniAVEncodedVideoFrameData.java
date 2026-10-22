package com.larus.im.internal.jni.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVEncodedVideoFrameData;", "", "data", "", "codec", "", "width", "height", "isKeyFrame", "", "timestampUs", "", "frameId", "rotation", "seiData", "<init>", "([BIIIZJJI[B)V", "getData", "()[B", "getCodec", "()I", "getWidth", "getHeight", "()Z", "getTimestampUs", "()J", "getFrameId", "getRotation", "getSeiData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVEncodedVideoFrameData {
    private final int codec;
    private final byte[] data;
    private final long frameId;
    private final int height;
    private final boolean isKeyFrame;
    private final int rotation;
    private final byte[] seiData;
    private final long timestampUs;
    private final int width;

    public static /* synthetic */ OmniAVEncodedVideoFrameData copy$default(OmniAVEncodedVideoFrameData r110, byte[] r111, int r112, int r113, int r114, boolean r115, long r116, long r210, int r211, byte[] r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        byte[] r100 = r110.data;
    L7:
        if ((r213 & 2) == 0) goto L9;
        int r101 = r110.codec;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r102 = r110.width;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r103 = r110.height;
    L19:
        if ((r213 & 16) == 0) goto L21;
        boolean r104 = r110.isKeyFrame;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r105 = r110.timestampUs;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r106 = r110.frameId;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r117 = r110.rotation;
    L35:
        if ((r213 & 256) == 0) goto L37;
        byte[] r107 = r110.seiData;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r107);
    L37:
        r107 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final byte[] component1() {
        return this.data;
    }

    public final int component2() {
        return this.codec;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final boolean component5() {
        return this.isKeyFrame;
    }

    public final long component6() {
        return this.timestampUs;
    }

    public final long component7() {
        return this.frameId;
    }

    public final int component8() {
        return this.rotation;
    }

    public final byte[] component9() {
        return this.seiData;
    }

    public final OmniAVEncodedVideoFrameData copy(byte[] r110, int r111, int r112, int r113, boolean r114, long r115, long r210, int r211, byte[] r212) {
        Intrinsics.checkNotNullParameter(r110, "data");
        return new OmniAVEncodedVideoFrameData(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAVEncodedVideoFrameData) == true) goto L8;
        return false;
    L8:
        OmniAVEncodedVideoFrameData r101 = (OmniAVEncodedVideoFrameData) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.codec == r101.codec) goto L15;
        return false;
    L15:
        if (this.width == r101.width) goto L18;
        return false;
    L18:
        if (this.height == r101.height) goto L21;
        return false;
    L21:
        if (this.isKeyFrame == r101.isKeyFrame) goto L24;
        return false;
    L24:
        if (this.timestampUs == r101.timestampUs) goto L27;
        return false;
    L27:
        if (this.frameId == r101.frameId) goto L30;
        return false;
    L30:
        if (this.rotation == r101.rotation) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.seiData, r101.seiData) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((Arrays.hashCode(this.data) * 31) + this.codec) * 31) + this.width) * 31) + this.height) * 31;
        if (this.isKeyFrame == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.timestampUs;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.frameId;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.rotation) * 31;
        byte[] r107 = this.seiData;
        if (r107 != null) goto L9;
        int r108 = 0;
    L11:
        return r106 + r108;
    L9:
        r108 = Arrays.hashCode(r107);
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniAVEncodedVideoFrameData(data=" + Arrays.toString(this.data) + ", codec=" + this.codec + ", width=" + this.width + ", height=" + this.height + ", isKeyFrame=" + this.isKeyFrame + ", timestampUs=" + this.timestampUs + ", frameId=" + this.frameId + ", rotation=" + this.rotation + ", seiData=" + Arrays.toString(this.seiData) + ')';
    }

    public final int getCodec() {
        return this.codec;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final long getFrameId() {
        return this.frameId;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final byte[] getSeiData() {
        return this.seiData;
    }

    public final long getTimestampUs() {
        return this.timestampUs;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isKeyFrame() {
        return this.isKeyFrame;
    }

    public OmniAVEncodedVideoFrameData(byte[] r100, int r101, int r102, int r103, boolean r104, long r105, long r106, int r110, byte[] r111) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.codec = r101;
        this.width = r102;
        this.height = r103;
        this.isKeyFrame = r104;
        this.timestampUs = r105;
        this.frameId = r106;
        this.rotation = r110;
        this.seiData = r111;
    }

    public /* synthetic */ OmniAVEncodedVideoFrameData(byte[] r110, int r111, int r112, int r113, boolean r114, long r210, long r211, int r212, byte[] r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 128) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r214 & 256) == 0) goto L9;
        byte[] r116 = null;
    L10:
        this(r110, r111, r112, r113, r114, r210, r211, r115, r116);
        return;
    L9:
        r116 = r213;
        goto L10
    L5:
        r115 = r212;
        goto L7
    }
}
