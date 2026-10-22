package fg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoBufferType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    ByteBuffer a();

    void addRef();

    int b();

    LiveWrappedVideoBufferType bufferType();

    int height();

    LiveWrappedVideoPixelFormat pixelFormat();

    long releaseRef();

    ByteBuffer seiData();

    int textureId();

    float[] textureMatrix();

    long timestampUs();

    int width();
}
