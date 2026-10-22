package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceFinalDispatcherKt {
    public static final void a(final p r1, final CharSequence r2, final Function1<? super p, Boolean> r3, Function2<? super CharSequence, ? super Function1<? super Boolean, Unit>, Unit> r4, final Function3<? super p, ? super CharSequence, ? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "isTargetValid");
        Intrinsics.checkNotNullParameter(r4, "confirmBeforeSend");
        Intrinsics.checkNotNullParameter(r5, "send");
        if (((Boolean) r3.invoke(r1)).booleanValue() == true) goto L5;
        return;
    L5:
        r4.invoke(r2, new CommentVoiceFinalDispatcherKt$dispatchCommentVoiceFinalText$1(r3, r1, r5, r2));
    }
}
