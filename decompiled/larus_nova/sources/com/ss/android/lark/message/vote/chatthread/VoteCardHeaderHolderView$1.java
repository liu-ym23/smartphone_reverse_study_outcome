package com.ss.android.lark.message.vote.chatthread;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
class VoteCardHeaderHolderView$1 extends UIGetDataCallback<rrb.a> {
    final /* synthetic */ a this$0;

    public VoteCardHeaderHolderView$1(a r100) {
    }

    @Override // com.larksuite.framework.callback.UIGetDataCallback
    public void onErrored(ErrorResult r100) {
        Log.e("vote action fail:" + r100.toString());
    }

    @Override // com.larksuite.framework.callback.UIGetDataCallback
    public /* bridge */ /* synthetic */ void onSuccessed(rrb.a r100) {
        onSuccessed2(r100);
    }

    /* JADX INFO: renamed from: onSuccessed, reason: avoid collision after fix types in other method */
    public void onSuccessed2(rrb.a r100) {
        Log.i("vote action success");
    }
}
