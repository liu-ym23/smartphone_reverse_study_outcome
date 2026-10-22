package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static r f230431a;

    static {
    }

    public k() {
    }

    public static /* synthetic */ void b(Function2 r100) {
        a("CommentAdvancedAsrInputViewAdapter", CommentVoiceMentionDependencyProvider$createMentionDependency$1.INSTANCE, CommentVoiceMentionDependencyProvider$createMentionDependency$2.INSTANCE, r100);
    }

    public static void a(String r100, Function1 r101, Function0 r102, Function2 r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "mentionResultHandler");
        Intrinsics.checkNotNullParameter(r102, "canSelectAtGroupMember");
        r r104 = f230431a;
        if (r104 != null) goto L8;
        r104 = (r) PluginServiceLoader.loadFirstOrNull(r.class);
        if (r104 == null) goto L7;
        f230431a = r104;
        goto L8
    L7:
        r104 = null;
    L8:
        if (r104 != null) goto L10;
        tt5.a.k(r100, "createMentionDependency failed: ICommentVoiceMentionDependency is null");
    L10:
        if (r104 == null) goto L13;
        r104.a();
        return;
    }
}
