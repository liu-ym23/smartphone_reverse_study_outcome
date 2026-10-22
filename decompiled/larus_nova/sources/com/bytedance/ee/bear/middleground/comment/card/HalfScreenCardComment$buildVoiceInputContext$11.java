package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class HalfScreenCardComment$buildVoiceInputContext$11 extends FunctionReferenceImpl implements Function2<List<? extends String>, Function1<? super Map<String, ? extends Boolean>, ? extends Unit>, Unit> {
    public HalfScreenCardComment$buildVoiceInputContext$11(Object r100) {
        super(2, r100, CommentVoiceMentionPermissionHelper.class, "fetchMentionUserReadPermissions", "fetchMentionUserReadPermissions(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> r100, Function1<? super Map<String, Boolean>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((CommentVoiceMentionPermissionHelper) this.receiver).c(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> r100, Function1<? super Map<String, ? extends Boolean>, ? extends Unit> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
