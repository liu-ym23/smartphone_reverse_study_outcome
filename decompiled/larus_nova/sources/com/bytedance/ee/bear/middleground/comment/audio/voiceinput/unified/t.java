package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f230667a = null;

    static {
        f230667a = new t();
    }

    public t() {
    }

    public final CommentUnifiedVoiceComponentSimpleSession a(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r100, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o r110) {
        Intrinsics.checkNotNullParameter(r100, "outerContext");
        Intrinsics.checkNotNullParameter(r110, "simpleContext");
        return new CommentUnifiedVoiceComponentSimpleSession(r100.f230400a, r100.f230401b, r100.f230404e, r100.f230406g, r100.f230407h, r110);
    }
}
