package com.bytedance.realx.video.memory;

import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class NativeRXByteMemory extends RXVideoMemory implements RXVideoByteMemoryInterface {
    private final int height;
    private final RXPixelFormat pixelFormat;
    private final ByteBuffer[] planeData;
    private final int[] planeLineSize;
    private final int width;

    /* JADX INFO: renamed from: com.bytedance.realx.video.memory.NativeRXByteMemory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXPixelFormat = null;

        static {
            int[] r100 = new int[RXPixelFormat.values().length];
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat = r100;
            r100[RXPixelFormat.kArgb.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kBgra.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kI420.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kIYUV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kNv12.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kNv21.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRgb.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRgba.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRGB565.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kUYVY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kYUY2.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kYV12.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private static native NativeRXByteMemory nativeCreateRXByteMemory(int r100, int r101, RXPixelFormat r102, long r103);

    @Override // com.bytedance.realx.video.memory.RXVideoByteMemoryInterface
    public int getNumberOfPlanes() {
        ByteBuffer[] r100 = this.planeData;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.length;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXVideoMemoryType getMemoryType() {
        return RXVideoMemoryType.kBYTE_MEMORY;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXPixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public ByteBuffer[] getPlaneDataArray() {
        return this.planeData;
    }

    public int[] getPlaneLineSizeArray() {
        return this.planeLineSize;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoByteMemoryInterface
    public ByteBuffer getPlaneData(int r100) {
        ByteBuffer[] r101 = this.planeData;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 <= r101.length) goto L9;
        return null;
    L9:
        return r101[r100].slice();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoByteMemoryInterface
    public int getPlaneLineSize(int r100) {
        int[] r101 = this.planeLineSize;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r100 <= r101.length) goto L9;
        return 0;
    L9:
        return r101[r100];
    }

    public static NativeRXByteMemory createRXByteMemory(int r100, int r101, RXPixelFormat r102, long r103) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RXPixelFormat[r102.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return nativeCreateRXByteMemory(r100, r101, r102, r103);
    }

    public NativeRXByteMemory(int r100, int r101, long r102, ByteBuffer[] r103, int[] r104, RXPixelFormat r105) {
        super(r102);
        this.width = r100;
        this.height = r101;
        this.nativeHandle = r102;
        this.planeData = r103;
        this.planeLineSize = r104;
        this.pixelFormat = r105;
    }
}
