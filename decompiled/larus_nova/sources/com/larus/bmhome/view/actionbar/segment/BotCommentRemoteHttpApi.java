package com.larus.bmhome.view.actionbar.segment;

import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class BotCommentRemoteHttpApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BotCommentRemoteHttpApi f316803a = null;

    static {
        f316803a = new BotCommentRemoteHttpApi();
    }

    public BotCommentRemoteHttpApi() {
    }

    public final Object a(String r100, String r101, String r102, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotCommentRemoteHttpApi$loadCommentList$2(r100, r101, r102, null), r103);
    }
}
