package rq9;

import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import com.larus.platform.model.comment.api.CommentHttpApi$PostCommentResponse;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface h {
    Object a(String r100, CommentContent r101, String r102, String r103, Continuation<? super com.larus.network.http.a<CommentHttpApi$PostCommentResponse>> r104);

    int b();

    Object c(Continuation<? super com.larus.network.http.a<b>> r100);

    Object d(String r100, Continuation<? super com.larus.network.http.a<? extends Object>> r101);

    Object e(String r100, boolean r101, Continuation<? super com.larus.network.http.a<? extends Object>> r102);

    Map<String, String> f();

    Object g(String r100, String r101, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r102);

    Object h(String r100, String r101, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r102);
}
