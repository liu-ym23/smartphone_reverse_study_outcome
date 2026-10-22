package com.ss.android.lark.image.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.image.api.IRequestCreator;
import rkb.c;

/* JADX INFO: loaded from: classes36.dex */
public class RequestCreatorContainer extends RequestCreator {
    @Override // com.ss.android.lark.image.impl.RequestCreator, com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator load(Object r100) {
        Context r101 = this.mContext;
        if (r101 == null) goto L5;
        RequestCreator r102 = new RequestCreator(this.mImageLoader, r101);
    L13:
        return r102.load(r100);
    L5:
        Fragment r103 = this.mSupportFragment;
        if (r103 == null) goto L8;
        r102 = new RequestCreator(this.mImageLoader, r103);
        goto L13
    L8:
        android.app.Fragment r104 = this.mFragment;
        if (r104 == null) goto L11;
        r102 = new RequestCreator(this.mImageLoader, r104);
        goto L13
    L11:
        r102 = null;
        goto L13
    }

    @Override // com.ss.android.lark.image.impl.RequestCreator, com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator load(Object r100) {
        return load(r100);
    }

    public RequestCreatorContainer(c r100, android.app.Fragment r101) {
        super(r100, r101);
    }

    public RequestCreatorContainer(c r100, Context r101) {
        super(r100, r101);
    }

    public RequestCreatorContainer(c r100, Fragment r101) {
        super(r100, r101);
    }
}
