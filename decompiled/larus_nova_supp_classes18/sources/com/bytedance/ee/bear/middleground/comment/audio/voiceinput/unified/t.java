package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final CommentUnifiedVoiceComponentSimpleSession a(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r9, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o r10) {
        Intrinsics.checkNotNullParameter(r9, "outerContext");
        Intrinsics.checkNotNullParameter(r10, "simpleContext");
        return new CommentUnifiedVoiceComponentSimpleSession(r9.a, r9.b, r9.e, r9.g, r9.h, r10);
    }
}
