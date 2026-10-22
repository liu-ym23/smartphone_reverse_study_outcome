package com.ss.android.lark.share_group;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
class ShareGroupChatHelper$4 implements IGetDataCallback<Boolean> {
    final /* synthetic */ TextView val$button;
    final /* synthetic */ Chat val$chat;
    final /* synthetic */ ShareGroupChatContent val$content;
    final /* synthetic */ Context val$context;
    final /* synthetic */ TextView val$hint;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        if (TextUtils.isEmpty(r100.getDisplayMsg()) == true) goto L5;
        UDToast.show(this.val$context, r100.getDisplayMsg());
    L5:
        Log.e(r100.toString());
    }

    public void onSuccess(Boolean r100) {
        UDToast.show(this.val$context, R.string.Lark_Legacy_RequestSentApprovalPendingToast);
        ShareGroupChatContent.GroupState r101 = ShareGroupChatContent.GroupState.PENDING_APPROVAL;
        q.c(r101, this.val$button, this.val$hint);
        this.val$content.setJoinChatErrState(r101);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }

    public ShareGroupChatHelper$4(Context r100, Chat r101, TextView r102, TextView r103, ShareGroupChatContent r104) {
        this.val$context = r100;
        this.val$chat = r101;
        this.val$button = r102;
        this.val$hint = r103;
        this.val$content = r104;
    }
}
