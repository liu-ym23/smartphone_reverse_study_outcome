package androidx.camera.video.internal.encoder;

import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface InputBuffer {
    boolean cancel();

    ByteBuffer getByteBuffer();

    ListenableFuture<Void> getTerminationFuture();

    void setEndOfStream(boolean r1);

    void setPresentationTimeUs(long r1);

    boolean submit();
}
