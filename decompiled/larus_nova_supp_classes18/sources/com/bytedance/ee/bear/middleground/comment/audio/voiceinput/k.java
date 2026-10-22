package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static r a;

    static {
    }

    public k() {
    }

    public static /* synthetic */ void b(Function2 r3) {
        a("CommentAdvancedAsrInputViewAdapter", CommentVoiceMentionDependencyProvider$createMentionDependency$1.INSTANCE, CommentVoiceMentionDependencyProvider$createMentionDependency$2.INSTANCE, r3);
    }

    public static void a(String r0, Function1 r1, Function0 r2, Function2 r3) {
        Intrinsics.checkNotNullParameter(r0, "tag");
        Intrinsics.checkNotNullParameter(r1, "mentionResultHandler");
        Intrinsics.checkNotNullParameter(r2, "canSelectAtGroupMember");
        r r4 = a;
        if (r4 != null) goto L8;
        r4 = (r) PluginServiceLoader.loadFirstOrNull(r.class);
        if (r4 == null) goto L7;
        a = r4;
        goto L8
    L7:
        r4 = null;
    L8:
        if (r4 != null) goto L10;
        tt5.a.k(r0, "createMentionDependency failed: ICommentVoiceMentionDependency is null");
    L10:
        if (r4 == null) goto L13;
        r4.a();
        return;
    }
}
