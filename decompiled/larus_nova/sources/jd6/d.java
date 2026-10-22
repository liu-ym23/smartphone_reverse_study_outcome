package jd6;

import com.byted.cast.common.Constants;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes19.dex */
public abstract class d {
    public d() {
    }

    public long contentLength() {
        return -1;
    }

    public abstract String contentType();

    public boolean isStreamingUpload() {
        return false;
    }

    public boolean writeChunkTo(BufferedSink r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        return true;
    }

    public abstract void writeTo(BufferedSink r100);
}
