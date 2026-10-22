package com.larus.im.internal.rtcsdk.impl;

import com.larus.im.service.audio.ILLMVideoStreamIndex;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.IVideoProcessor;

/* JADX INFO: loaded from: classes30.dex */
public final class w1 extends IVideoProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.im.service.audio.w f350056a;

    public static final class a {
    }

    static {
    }

    public w1() {
    }

    @Override // com.ss.bytertc.engine.video.IVideoProcessor
    public final IVideoFrame processVideoFrame(StreamIndex r110, IVideoFrame r111) {
        if (r111 != null) goto L4;
        return r111;
    L4:
        r111.addRef();
        com.larus.im.service.audio.w r100 = this.f350056a;
        if (r100 == null) goto L25;
        ILLMVideoStreamIndex.a r101 = ILLMVideoStreamIndex.Companion;
        ILLMVideoStreamIndex r102 = null;
        if (r110 == null) goto L9;
        Integer r112 = Integer.valueOf(r110.value());
    L10:
        r101.getClass();
        ILLMVideoStreamIndex[] r103 = ILLMVideoStreamIndex.values();
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L22;
        ILLMVideoStreamIndex r106 = r103[r105];
        int r107 = ILLMVideoStreamIndex.access$getStreamIndex$p(r106);
        if (r112 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == true) goto L20;
        r105 = r105 + 1;
        goto L11
    L20:
        r102 = r106;
        goto L22
    L16:
        if (r107 != r112.intValue()) goto L18;
        r108 = true;
    L22:
        if (r102 != null) goto L24;
        r102 = ILLMVideoStreamIndex.STREAM_INDEX_UNKNOWN;
    L24:
        r100.a(r102, new t1(r111));
        goto L25
    L9:
        r112 = null;
    L25:
        com.larus.im.internal.utils.x r113 = com.larus.im.internal.utils.x.f350563a;
        com.larus.im.internal.utils.x.f350566d.getClass();
        com.larus.im.internal.utils.x.f350568f.getClass();
        return r111;
    }
}
