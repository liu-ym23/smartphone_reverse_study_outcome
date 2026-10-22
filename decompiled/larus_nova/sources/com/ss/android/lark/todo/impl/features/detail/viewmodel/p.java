package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.lark.pb.todo.v1.SimpleTodo;
import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.ss.android.lark.todo.impl.features.common.share.entity.ShareEntity;
import com.ss.android.lark.todo.impl.features.detail.TodoKeyboardFragment;
import com.ss.android.lark.todo.impl.features.detail.comment.t0;
import com.ss.android.lark.todo.impl.features.detail.sections.w0;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes38.dex */
public interface p extends o, t0, k, m, com.ss.android.lark.todo.impl.features.detail.viewmodel.data.d, j, l, n {
    LiveData<Boolean> getActivityFinished();

    LiveData<Boolean> getAssigneeFragmentShowAdd();

    LiveData<Boolean> getAssigneeMultiStrategy();

    LiveData<List<AssigneeBean>> getAssignees();

    LiveData<String> getChatIdForAddUser();

    LiveData<String> getChatIdForCreate();

    LiveData<Integer> getCheckboxState();

    LiveData<b> getCommentInsertAtTag();

    LiveData<List<TaskContainerRef>> getCreateRespTaskContainerRefs();

    LiveData<TodoDetailModel.c> getDependentDialogShow();

    LiveData<ArrayList<RichText>> getDependentFinishDialogShow();

    LiveData<Boolean> getDescriptionClearFocus();

    LiveData<t> getDescriptionFragShowRichText();

    LiveData<b> getDescriptionFragmentInsertAtTag();

    LiveData<e> getDescriptionInfo();

    LiveData<f> getDescriptionInit();

    LiveData<b> getDescriptionInsertAtTag();

    LiveData<t> getDescriptionShowRichText();

    LiveData<Unit> getFastCreateExpandEvent();

    LiveData<com.ss.android.lark.todo.impl.features.detail.c> getFastCreateInitData();

    LiveData<Boolean> getFollowerFragmentShowAdd();

    LiveData<List<i>> getFollowers();

    LiveData<TodoDetailModel.d> getGanttContainerShow();

    LiveData<String> getInitAtController();

    LiveData<TodoData> getInitCreateView();

    LiveData<Boolean> getKeyboardSummaryClearFocus();

    LiveData<Boolean> getKeyboardSummaryRequestFocus();

    LiveData<Boolean> getLoading();

    LiveData<Integer> getLoadingResult();

    LiveData<Boolean> getNeedUpdate();

    LiveData<Boolean> getOwnerDeleteIconShow();

    LiveData<w0> getReferResourceLv();

    LiveData<Boolean> getReplyInThreadForCreate();

    LiveData<ShareEntity> getShareEntity();

    LiveData<List<SimpleTodo>> getShowAncestors();

    LiveData<q> getShowOrigin();

    LiveData<Boolean> getShowRevokeAssignee();

    LiveData<TodoKeyboardFragment.Companion.State> getState();

    LiveData<Boolean> getSummaryClearFocus();

    LiveData<Boolean> getSummaryHideKeyboard();

    LiveData<x> getSummaryInfo();

    LiveData<y> getSummaryInit();

    LiveData<z> getSummaryInlineInfo();

    LiveData<t> getSummaryInlineShowRichText();

    LiveData<b> getSummaryInsertAtTag();

    LiveData<b> getSummaryKeyboardInsertAtTag();

    LiveData<Boolean> getSummaryRequestFocus();

    LiveData<t> getSummaryShowRichText();

    LiveData<String> getThreadIdForCreate();

    LiveData<Boolean> getTimeFragment();

    LiveData<a0> getTimeInfo();

    LiveData<w8c.a<com.ss.android.lark.todo.impl.features.detail.viewmodel.data.k>> getToast();

    LiveData<String> getToastCreateSuccess();

    LiveData<Integer> getToastError();

    LiveData<Integer> getToastSuccess();

    LiveData<TodoData> getTodoDataLiveData();

    LiveData<Boolean> getTodoSectionViewCanShow();

    LiveData<Boolean> getUnFollowWarningDialog();

    LiveData<Boolean> isCreateFromDocsBlockLv();
}
