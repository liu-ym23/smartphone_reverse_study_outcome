package com.larus.im.internal.jni.model;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b)\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010,\u001a\u00020\u0003H\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\u009f\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010!R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010!¨\u0006>"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVVideoFrameData;", "", "width", "", "height", "rotation", "timestampUs", "", "bufferType", "pixelFormat", "contentType", "isFirstFrame", "", "captureTimestampMs", "planes", "", "Lcom/larus/im/internal/jni/model/OmniAVVideoPlaneData;", "textureId", "textureMatrix", "", "hwContext", "isReplacement", "<init>", "(IIIJIIIZJLjava/util/List;I[FLjava/lang/Object;Z)V", "getWidth", "()I", "getHeight", "getRotation", "getTimestampUs", "()J", "getBufferType", "getPixelFormat", "getContentType", "()Z", "getCaptureTimestampMs", "getPlanes", "()Ljava/util/List;", "getTextureId", "getTextureMatrix", "()[F", "getHwContext", "()Ljava/lang/Object;", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "toString", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVVideoFrameData {
    private final int bufferType;
    private final long captureTimestampMs;
    private final int contentType;
    private final int height;
    private final Object hwContext;
    private final boolean isFirstFrame;
    private final boolean isReplacement;
    private final int pixelFormat;
    private final List<OmniAVVideoPlaneData> planes;
    private final int rotation;
    private final int textureId;
    private final float[] textureMatrix;
    private final long timestampUs;
    private final int width;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniAVVideoFrameData copy$default(OmniAVVideoFrameData r110, int r111, int r112, int r113, long r210, int r211, int r212, int r213, boolean r214, long r215, List r216, int r217, float[] r310, Object r311, boolean r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        int r100 = r110.width;
    L7:
        if ((r313 & 2) == 0) goto L9;
        int r101 = r110.height;
    L11:
        if ((r313 & 4) == 0) goto L13;
        int r102 = r110.rotation;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r103 = r110.timestampUs;
    L19:
        if ((r313 & 16) == 0) goto L21;
        int r104 = r110.bufferType;
    L23:
        if ((r313 & 32) == 0) goto L25;
        int r105 = r110.pixelFormat;
    L27:
        if ((r313 & 64) == 0) goto L29;
        int r106 = r110.contentType;
    L31:
        if ((r313 & 128) == 0) goto L33;
        boolean r114 = r110.isFirstFrame;
    L35:
        if ((r313 & 256) == 0) goto L37;
        long r115 = r110.captureTimestampMs;
    L39:
        if ((r313 & 512) == 0) goto L41;
        List r116 = r110.planes;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        int r117 = r110.textureId;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        float[] r118 = r110.textureMatrix;
    L50:
        float[] r315 = r118;
        if ((r313 & 4096) == 0) goto L53;
        Object r119 = r110.hwContext;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        boolean r107 = r110.isReplacement;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r116, r117, r315, r119, r107);
    L57:
        r107 = r312;
        goto L59
    L53:
        r119 = r311;
        goto L55
    L49:
        r118 = r310;
        goto L50
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final int component1() {
        return this.width;
    }

    public final List<OmniAVVideoPlaneData> component10() {
        return this.planes;
    }

    public final int component11() {
        return this.textureId;
    }

    public final float[] component12() {
        return this.textureMatrix;
    }

    public final Object component13() {
        return this.hwContext;
    }

    public final boolean component14() {
        return this.isReplacement;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.rotation;
    }

    public final long component4() {
        return this.timestampUs;
    }

    public final int component5() {
        return this.bufferType;
    }

    public final int component6() {
        return this.pixelFormat;
    }

    public final int component7() {
        return this.contentType;
    }

    public final boolean component8() {
        return this.isFirstFrame;
    }

    public final long component9() {
        return this.captureTimestampMs;
    }

    public final OmniAVVideoFrameData copy(int r110, int r210, int r211, long r212, int r213, int r214, int r215, boolean r216, long r217, List<OmniAVVideoPlaneData> r310, int r311, float[] r312, Object r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r310, "planes");
        return new OmniAVVideoFrameData(r110, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314);
    }

    public String toString() {
        return "OmniAVVideoFrameData(width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + ", timestampUs=" + this.timestampUs + ", bufferType=" + this.bufferType + ", pixelFormat=" + this.pixelFormat + ", contentType=" + this.contentType + ", isFirstFrame=" + this.isFirstFrame + ", captureTimestampMs=" + this.captureTimestampMs + ", planes=" + this.planes + ", textureId=" + this.textureId + ", textureMatrix=" + Arrays.toString(this.textureMatrix) + ", hwContext=" + this.hwContext + ", isReplacement=" + this.isReplacement + ')';
    }

    public int hashCode() {
        int r100 = ((((this.width * 31) + this.height) * 31) + this.rotation) * 31;
        long r101 = this.timestampUs;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.bufferType) * 31) + this.pixelFormat) * 31) + this.contentType) * 31;
        int r103 = 1231;
        if (this.isFirstFrame == false) goto L5;
        int r104 = 1231;
    L6:
        long r105 = this.captureTimestampMs;
        int r106 = (((((((r102 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.planes.hashCode()) * 31) + this.textureId) * 31;
        float[] r107 = this.textureMatrix;
        int r108 = 0;
        if (r107 == null) goto L9;
        int r109 = Arrays.hashCode(r107);
    L10:
        int r110 = (r106 + r109) * 31;
        Object r111 = this.hwContext;
        if (r111 == null) goto L13;
        r108 = r111.hashCode();
    L13:
        int r112 = (r110 + r108) * 31;
        if (this.isReplacement == true) goto L18;
        r103 = 1237;
    L18:
        return r112 + r103;
    L9:
        r109 = 0;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final int getBufferType() {
        return this.bufferType;
    }

    public final long getCaptureTimestampMs() {
        return this.captureTimestampMs;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Object getHwContext() {
        return this.hwContext;
    }

    public final int getPixelFormat() {
        return this.pixelFormat;
    }

    public final List<OmniAVVideoPlaneData> getPlanes() {
        return this.planes;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final int getTextureId() {
        return this.textureId;
    }

    public final float[] getTextureMatrix() {
        return this.textureMatrix;
    }

    public final long getTimestampUs() {
        return this.timestampUs;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isFirstFrame() {
        return this.isFirstFrame;
    }

    public final boolean isReplacement() {
        return this.isReplacement;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAVVideoFrameData) == true) goto L8;
        return false;
    L8:
        OmniAVVideoFrameData r101 = (OmniAVVideoFrameData) r100;
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L15;
        return false;
    L15:
        if (this.rotation == r101.rotation) goto L18;
        return false;
    L18:
        if (this.timestampUs == r101.timestampUs) goto L21;
        return false;
    L21:
        if (this.bufferType == r101.bufferType) goto L24;
        return false;
    L24:
        if (this.pixelFormat == r101.pixelFormat) goto L27;
        return false;
    L27:
        if (this.contentType == r101.contentType) goto L30;
        return false;
    L30:
        if (this.isFirstFrame == r101.isFirstFrame) goto L33;
        return false;
    L33:
        if (this.captureTimestampMs == r101.captureTimestampMs) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.planes, r101.planes) == true) goto L39;
        return false;
    L39:
        if (this.textureId == r101.textureId) goto L41;
        return false;
    L41:
        float[] r102 = this.textureMatrix;
        if (r102 == null) goto L50;
        float[] r103 = r101.textureMatrix;
        if (r103 != null) goto L47;
        return false;
    L47:
        if (Arrays.equals(r102, r103) == true) goto L53;
        return false;
    L53:
        if (Intrinsics.areEqual(this.hwContext, r101.hwContext) == true) goto L56;
        return false;
    L56:
        if (this.isReplacement == r101.isReplacement) goto L58;
        return false;
    L58:
        return true;
    L50:
        if (r101.textureMatrix == null) goto L53;
        return false;
    }

    public OmniAVVideoFrameData(int r100, int r101, int r102, long r103, int r110, int r111, int r112, boolean r113, long r114, List<OmniAVVideoPlaneData> r115, int r116, float[] r117, Object r118, boolean r210) {
        Intrinsics.checkNotNullParameter(r115, "planes");
        this.width = r100;
        this.height = r101;
        this.rotation = r102;
        this.timestampUs = r103;
        this.bufferType = r110;
        this.pixelFormat = r111;
        this.contentType = r112;
        this.isFirstFrame = r113;
        this.captureTimestampMs = r114;
        this.planes = r115;
        this.textureId = r116;
        this.textureMatrix = r117;
        this.hwContext = r118;
        this.isReplacement = r210;
    }

    public /* synthetic */ OmniAVVideoFrameData(int r210, int r211, int r212, long r213, int r214, int r215, int r216, boolean r217, long r310, List r311, int r312, float[] r313, Object r314, boolean r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 64) == 0) goto L5;
        int r110 = 0;
    L7:
        if ((r316 & 128) == 0) goto L9;
        boolean r111 = false;
    L11:
        if ((r316 & 256) == 0) goto L13;
        long r112 = 0;
    L15:
        if ((r316 & 512) == 0) goto L17;
        List r113 = CollectionsKt.emptyList();
    L19:
        if ((r316 & 1024) == 0) goto L21;
        int r114 = 0;
    L23:
        if ((r316 & 2048) == 0) goto L25;
        float[] r115 = null;
    L27:
        if ((r316 & 4096) == 0) goto L29;
        Object r116 = null;
    L31:
        if ((r316 & 8192) == 0) goto L33;
        boolean r117 = false;
    L34:
        this(r210, r211, r212, r213, r214, r215, r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L33:
        r117 = r315;
        goto L34
    L29:
        r116 = r314;
        goto L31
    L25:
        r115 = r313;
        goto L27
    L21:
        r114 = r312;
        goto L23
    L17:
        r113 = r311;
        goto L19
    L13:
        r112 = r310;
        goto L15
    L9:
        r111 = r217;
        goto L11
    L5:
        r110 = r216;
        goto L7
    }
}
