package com.larksuite.framework.mvp;

import com.larksuite.framework.mvp.IView.IViewDelegate;

/* JADX INFO: loaded from: classes24.dex */
public class a<VD extends IView.IViewDelegate> implements IView<VD> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VD f285682a;

    public a() {
    }

    public void destroy() {
        this.f285682a = null;
    }

    @Override // com.larksuite.framework.mvp.IView
    public void setViewDelegate(VD r100) {
        this.f285682a = r100;
    }
}
