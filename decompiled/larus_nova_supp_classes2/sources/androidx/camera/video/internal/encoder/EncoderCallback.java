package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface EncoderCallback {
    public static final EncoderCallback EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.EncoderCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onEncodePaused(EncoderCallback r0) {
        }
    }

    void onEncodeError(EncodeException r1);

    void onEncodePaused();

    void onEncodeStart();

    void onEncodeStop();

    void onEncodedData(EncodedData r1);

    void onOutputConfigUpdate(OutputConfig r1);

    static {
        EMPTY = new AnonymousClass1();
    }
}
