package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InputComment$handleLarkSimpleVoiceTouch$3 extends FunctionReferenceImpl implements Function2<List<? extends String>, Function1<? super Map<String, ? extends Boolean>, ? extends Unit>, Unit> {
    public InputComment$handleLarkSimpleVoiceTouch$3(Object r8) {
        super(2, r8, CommentVoiceMentionPermissionHelper.class, "fetchMentionUserReadPermissions", "fetchMentionUserReadPermissions(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    public final void invoke(List<String> r2, Function1<? super Map<String, Boolean>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        ((CommentVoiceMentionPermissionHelper) ((CallableReference) this).receiver).c(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((List) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
