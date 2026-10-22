package com.ss.android.lark.todo.impl.features.detail.comment;

import androidx.lifecycle.LiveData;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes38.dex */
public interface t0 {
    LiveData<n> getCommentAtUserInfo();

    LiveData<r> getCommentDraftLv();

    LiveData<Boolean> getCommentHasMore();

    LiveData<String> getCommentInitChatId();

    LiveData<Boolean> getCommentIsLoading();

    LiveData<Boolean> getCommentKeyboardVisible();

    LiveData<Boolean> getCommentLoadingFailed();

    LiveData<Boolean> getCommentLoadingMore();

    LiveData<List<TodoComment>> getCommentLv();

    LiveData<j0> getCommentPanelInfo();

    LiveData<r0> getCreatorInfo();

    LiveData<Pair<Integer, TodoComment>> getEditCommentInfo();

    LiveData<Pair<Integer, TodoComment>> getReplyCommentInfo();

    LiveData<Pair<Integer, Boolean>> getScrollToBottomOfComments();
}
