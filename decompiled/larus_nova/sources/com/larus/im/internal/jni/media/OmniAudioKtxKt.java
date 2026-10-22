package com.larus.im.internal.jni.media;

import fuc.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0000\u001a*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0000\u001a\"\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"DEFAULT_QUERY_ROUND", "", "DEFAULT_REPLY_ROUND", "", "DEFAULT_TASK_ID", "nowMs", "audioSize2Ms", "", "size", "sampleRate", "channel", "bit", "audioSizePerMs", "omnisdk-av_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioKtxKt {
    public static final long DEFAULT_QUERY_ROUND = 0;
    public static final String DEFAULT_REPLY_ROUND = "";
    public static final String DEFAULT_TASK_ID = "";

    public static final long nowMs() {
        return a.a().a();
    }

    public static final int audioSizePerMs(int r100, int r101, int r102) {
        if (r100 <= 0) goto L11;
        if (r101 > 0) goto L5;
        return 0;
    L5:
        if (r101 <= 3) goto L7;
        return 0;
    L7:
        if (r102 >= 8) goto L10;
        return 0;
    L10:
        return (((r100 / 1000) * r101) * r102) / 8;
    L11:
        return 0;
    }

    public static final int audioSize2Ms(int r100, int r101, int r102, int r103) {
        int r104 = audioSizePerMs(r101, r102, r103);
        if (r104 > 0) goto L6;
        return 0;
    L6:
        return r100 / r104;
    }

    public static /* synthetic */ int audioSizePerMs$default(int r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = 16;
    L6:
        return audioSizePerMs(r100, r101, r102);
    }

    public static /* synthetic */ int audioSize2Ms$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = 16;
    L6:
        return audioSize2Ms(r100, r101, r102, r103);
    }
}
