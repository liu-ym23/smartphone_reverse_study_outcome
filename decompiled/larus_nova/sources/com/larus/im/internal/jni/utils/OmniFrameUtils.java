package com.larus.im.internal.jni.utils;

import com.larus.im.internal.jni.media.OmniAudioFormat;
import com.larus.im.internal.jni.media.OmniAudioFormatType;
import com.larus.im.internal.jni.media.OmniAudioFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/utils/OmniFrameUtils;", "", "<init>", "()V", "createAudioEngineFrame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "data", "", "sampleRate", "", "channels", "extData", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniFrameUtils {
    public static final OmniFrameUtils INSTANCE = null;

    static {
        INSTANCE = new OmniFrameUtils();
    }

    private OmniFrameUtils() {
    }

    public final OmniAudioFrame createAudioEngineFrame(byte[] r110, int r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "data");
        return new OmniAudioFrame(r110, new OmniAudioFormat(OmniAudioFormatType.PCM_FORMAT_INT16, r111, r112), null, 0.0f, 0, r113, false, 92, null);
    }
}
