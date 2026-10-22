package com.larksuite.component.blockit.service;

import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes24.dex */
public interface IGetDataCallbackWrapper<Data> extends IGetDataCallback<Data> {

    /* JADX INFO: renamed from: com.larksuite.component.blockit.service.IGetDataCallbackWrapper$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<Data> {
        public static void $default$onSuccess(IGetDataCallbackWrapper r100, Object r101) {
            r100.onSuccess(r101, new a(false, 0));
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f283136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f283137b;

        public a(boolean r100, long r101) {
            this.f283136a = r100;
            this.f283137b = r101;
        }
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    void onSuccess(Data r100);

    void onSuccess(Data r100, a r101);
}
