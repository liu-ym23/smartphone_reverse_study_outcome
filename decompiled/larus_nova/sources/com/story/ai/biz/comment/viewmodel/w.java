package com.story.ai.biz.comment.viewmodel;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes38.dex */
public interface w {

    public static final class a {
        public static /* synthetic */ Object a(w r100, com.larus.network.http.a r101, String r102, Continuation r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            return r100.dealWithErrorAction(r101, r102, false, r103);
        }
    }

    CommentViewModel baseViewModel();

    rq9.h dataMediator();

    Object dealWithErrorAction(com.larus.network.http.a<? extends Object> r100, String r101, boolean r102, Continuation<? super Unit> r103);

    void showToast(String r100);
}
