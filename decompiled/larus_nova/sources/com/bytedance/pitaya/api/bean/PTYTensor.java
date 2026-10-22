package com.bytedance.pitaya.api.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001&BO\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\f\n\u0004\b \u0010\u000f\u0012\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTensor;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "", "dataType", "dataTypeSize", "", "rawBytes", "[B", "getRawBytes", "()[B", "", "rawFloats", "[F", "getRawFloats", "()[F", "I", "getDataType", "()I", "dataFormat", "getDataFormat", "", "dims", "[I", "getDims", "()[I", "fraction", "getFraction", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "rawDataType", "getRawDataType$annotations", "()V", "<init>", "([B[FII[IILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYTensor extends PTYClass {
    public static final a Companion = null;
    public static final int DATA_FORMAT_NCHW = 0;
    public static final int DATA_FORMAT_NHWC = 1;
    public static final int DATA_TYPE_Double = 22;
    public static final int DATA_TYPE_Float16 = 20;
    public static final int DATA_TYPE_Float32 = 21;
    public static final int DATA_TYPE_Int16 = 11;
    public static final int DATA_TYPE_Int32 = 12;
    public static final int DATA_TYPE_Int8 = 10;
    public static final int DATA_TYPE_U8 = 0;
    public static final int DATA_TYPE_UNKNOWN = 999;
    public static final int DATA_TYPE_Uint16 = 1;
    public static final int DATA_TYPE_Uint32 = 2;
    private final int dataFormat;
    private final int dataType;
    private final int[] dims;
    private final int fraction;
    private final String name;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final int dataTypeSize(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L8;
    L14:
        return 4;
    L8:
        if (r100 == 20) goto L15;
        if (r100 == 22) goto L13;
        switch(r100) {
            case 10: goto L18;
            case 11: goto L15;
            case 12: goto L14;
            default: goto L12;
        };
    L12:
        return 0;
    L18:
        return 1;
    L13:
        return 8;
    L15:
        return 2;
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public final int getDataFormat() {
        return this.dataFormat;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final int[] getDims() {
        return this.dims;
    }

    public final int getFraction() {
        return this.fraction;
    }

    public final String getName() {
        return this.name;
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public PTYTensor(byte[] r100, float[] r101, int r102, int r103, int[] r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r106, "name");
        super(0);
        this.rawBytes = r100;
        this.rawFloats = r101;
        this.dataType = r102;
        this.dataFormat = r103;
        this.dims = r104;
        this.fraction = r105;
        this.name = r106;
        if (r100 == null) goto L5;
        int r107 = 2;
    L7:
        this.rawDataType = r107;
        return;
    L5:
        if (r101 == null) goto L10;
        r107 = 3;
        goto L7
    L10:
        throw new IllegalArgumentException("Tensor has no data!");
    }

    public /* synthetic */ PTYTensor(byte[] r110, float[] r111, int r112, int r113, int[] r114, int r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        byte[] r100 = null;
    L7:
        if ((r117 & 2) == 0) goto L9;
        float[] r101 = null;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r117 & 32) == 0) goto L21;
        int r104 = 0;
    L22:
        this(r100, r101, r102, r103, r114, r104, r116);
        return;
    L21:
        r104 = r115;
        goto L22
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
