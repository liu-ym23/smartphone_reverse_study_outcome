package com.ss.android.ugc.aweme.search.common.result.sug.base;

import com.ss.android.ugc.aweme.search.common.model.ECSearchBaseModel;
import com.ss.android.ugc.aweme.search.common.model.INotifyListener;
import com.ss.android.ugc.aweme.search.common.result.sug.base.IBaseView;

/* JADX INFO: loaded from: classes40.dex */
public class BasePresenter<T extends ECSearchBaseModel, K extends IBaseView> implements INotifyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f451932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public K f451933b;

    @Override // com.ss.android.ugc.aweme.search.common.model.INotifyListener
    public void a() {
    }

    @Override // com.ss.android.ugc.aweme.search.common.model.INotifyListener
    public void onSuccess() {
    }

    public BasePresenter() {
    }
}
