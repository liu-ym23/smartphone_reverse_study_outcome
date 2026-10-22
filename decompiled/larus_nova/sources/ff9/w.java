package ff9;

import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.vlm.EncodedVideoFrameType;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f476778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f476779b = null;

    static {
        int[] r100 = new int[EncodedVideoFrameType.values().length];
        r100[EncodedVideoFrameType.KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L19:
        r100[EncodedVideoFrameType.DELTA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L6:
        f476778a = r100;
        int[] r101 = new int[EncodedVideoCodecType.values().length];
        r101[EncodedVideoCodecType.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
    L29:
        r101[EncodedVideoCodecType.H265.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
    L23:
        r101[EncodedVideoCodecType.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
    L25:
        r101[EncodedVideoCodecType.MJPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
    L11:
        f476779b = r101;
    }
}
