package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes24.dex */
public interface IPagingFetchDataCallback<Data> extends ICallback {
    boolean needContinueLoad();

    void onBeginFetchData();

    void onDataLoadFailed(ErrorResult r100);

    void onDataLoaded(Data r100);

    void onEndFetchData();
}
