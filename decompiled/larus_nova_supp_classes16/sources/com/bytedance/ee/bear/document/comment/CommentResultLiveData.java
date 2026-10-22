package com.bytedance.ee.bear.document.comment;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.comment.bean.CommentResultBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommentResultLiveData extends MutableLiveData<CommentResultBean> {
    public Observer<? super CommentResultBean> a;

    public CommentResultLiveData() {
    }

    public final void observe(LifecycleOwner r2, Observer<? super CommentResultBean> r3) {
        Observer<? super CommentResultBean> r0 = this.a;
        if (r0 == null) goto L5;
        removeObserver(r0);
        setValue(null);
    L5:
        this.a = r3;
        super/*androidx.lifecycle.LiveData*/.observe(r2, r3);
    }
}
