package androidx.camera.video.internal.encoder;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface EncoderFactory {
    Encoder createEncoder(Executor r1, EncoderConfig r2) throws InvalidConfigException;
}
