package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentVoiceFinalDispatcherKt {
    public static final void a(final p r100, final CharSequence r101, final Function1<? super p, Boolean> r102, Function2<? super CharSequence, ? super Function1<? super Boolean, Unit>, Unit> r103, final Function3<? super p, ? super CharSequence, ? super Boolean, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "isTargetValid");
        Intrinsics.checkNotNullParameter(r103, "confirmBeforeSend");
        Intrinsics.checkNotNullParameter(r104, "send");
        if (r102.invoke(r100).booleanValue() == true) goto L5;
        return;
    L5:
        r103.invoke(r101, new CommentVoiceFinalDispatcherKt$dispatchCommentVoiceFinalText$1(r102, r100, r104, r101));
    }
}
