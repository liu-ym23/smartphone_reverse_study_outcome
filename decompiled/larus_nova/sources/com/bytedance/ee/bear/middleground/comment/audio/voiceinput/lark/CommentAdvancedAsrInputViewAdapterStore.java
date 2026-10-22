package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bJ\b\u0010\t\u001a\u00020\nH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/lark/CommentAdvancedAsrInputViewAdapterStore;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/lark/CommentAdvancedAsrInputViewAdapter;", "getOrCreate", "factory", "Lkotlin/Function0;", "onCleared", "", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAdvancedAsrInputViewAdapterStore extends ViewModel {
    private a adapter;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", "CommentAdvancedAsrInputViewAdapterStore onCleared");
        a r100 = this.adapter;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.adapter = null;
        super.onCleared();
    }

    public CommentAdvancedAsrInputViewAdapterStore() {
    }

    public final a getOrCreate(Function0<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        a r101 = this.adapter;
        if (r101 != null) goto L6;
        a r102 = r100.invoke();
        this.adapter = r102;
        return r102;
    L6:
        return r101;
    }
}
