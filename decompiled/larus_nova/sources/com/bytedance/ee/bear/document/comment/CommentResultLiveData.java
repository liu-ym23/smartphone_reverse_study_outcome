package com.bytedance.ee.bear.document.comment;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.comment.bean.CommentResultBean;

/* JADX INFO: loaded from: classes16.dex */
public class CommentResultLiveData extends MutableLiveData<CommentResultBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Observer<? super CommentResultBean> f219273a;

    public CommentResultLiveData() {
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super CommentResultBean> r101) {
        Observer<? super CommentResultBean> r102 = this.f219273a;
        if (r102 == null) goto L5;
        removeObserver(r102);
        setValue(null);
    L5:
        this.f219273a = r101;
        super.observe(r100, r101);
    }
}
