package com.larus.community.impl.detail.comment;

import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class CreationDetailCommentRemoteHttpApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationDetailCommentRemoteHttpApi f329251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f329252b;

    static {
        f329251a = new CreationDetailCommentRemoteHttpApi();
    }

    public CreationDetailCommentRemoteHttpApi() {
    }

    public final Object a(String r100, String r101, String r102, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$loadCommentList$2(r100, r101, r102, null), r103);
    }
}
