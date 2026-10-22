package com.bytedance.pitaya.api.bean;

import com.dtf.face.config.IConstValues;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0017\u0018\u0000 %2\u00020\u0001:\u0002&'Bc\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u0012\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNDArray;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "", "index", "I", "getIndex", "()I", "", "rawBytes", "[B", "getRawBytes", "()[B", "", "rawFloats", "[F", "getRawFloats", "()[F", "", "shapes", "[I", "getShapes", "()[I", "type", "getType", "bits", "getBits", "lanes", "getLanes", "deviceID", "getDeviceID", IConstValues.DEVICE_TYPE, "getDeviceType", "rawDataType", "getRawDataType$annotations", "()V", "<init>", "(I[B[F[IIIIII)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DLDataType", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYNDArray extends PTYClass {
    public static final a Companion = null;
    public static final int DL_B_FLOAT = 4;
    public static final int DL_COMPLEX = 5;
    public static final int DL_FLOAT = 2;
    public static final int DL_INT = 0;
    public static final int DL_OPAQUE_HANDLE = 3;
    public static final int DL_U_INT = 1;
    private final int bits;
    private final int deviceID;
    private final int deviceType;
    private final int index;
    private final int lanes;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;
    private final int[] shapes;
    private final int type;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNDArray$DLDataType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public @interface DLDataType {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public final int getBits() {
        return this.bits;
    }

    public final int getDeviceID() {
        return this.deviceID;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getLanes() {
        return this.lanes;
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public final int[] getShapes() {
        return this.shapes;
    }

    public final int getType() {
        return this.type;
    }

    public PTYNDArray(int r100, byte[] r101, float[] r102, int[] r103, @DLDataType int r104, int r105, int r106, int r107, int r110) {
        Intrinsics.checkNotNullParameter(r103, "shapes");
        int r108 = 3;
        super(3);
        this.index = r100;
        this.rawBytes = r101;
        this.rawFloats = r102;
        this.shapes = r103;
        this.type = r104;
        this.bits = r105;
        this.lanes = r106;
        this.deviceID = r107;
        this.deviceType = r110;
        if (r101 == null) goto L5;
        r108 = 2;
    L6:
        this.rawDataType = r108;
        return;
    L5:
        if (r102 != null) goto L6;
        throw new IllegalArgumentException("NDArray has no data!");
    }

    public /* synthetic */ PTYNDArray(int r110, byte[] r111, float[] r112, int[] r113, int r114, int r115, int r116, int r210, int r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r212 & 2) == 0) goto L9;
        byte[] r101 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        float[] r102 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int[] r103 = new int[0];
    L19:
        if ((r212 & 64) == 0) goto L21;
        int r104 = 1;
    L23:
        if ((r212 & 128) == 0) goto L25;
        int r117 = 0;
    L27:
        if ((r212 & 256) == 0) goto L29;
        int r118 = 1;
    L30:
        this(r100, r101, r102, r103, r114, r115, r104, r117, r118);
        return;
    L29:
        r118 = r211;
        goto L30
    L25:
        r117 = r210;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
