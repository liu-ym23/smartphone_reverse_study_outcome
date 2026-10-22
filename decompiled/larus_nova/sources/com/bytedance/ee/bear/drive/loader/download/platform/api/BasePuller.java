package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller.Params;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller.Result;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BasePuller<PARAMS extends Params, RESULT extends Result> implements IApiPuller<PARAMS, RESULT> {
    public static final String TAG = "DrivePlatform_BasePuller";
    private final String mPath;
    private NetService.d<com.bytedance.ee.bear.contract.Result<RESULT>> mPuller;

    public static abstract class Params implements Serializable {
        public Params() {
        }
    }

    public static abstract class Result implements Serializable {
        public Result() {
        }
    }

    public static /* synthetic */ Publisher a(BasePuller r100, Params r101, Throwable r102) {
        return r100.lambda$pull$0(r101, r102);
    }

    private Type parseType() {
        final Type[] r100 = {((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]};
        return new AnonymousClass1(this, r100).getType();
    L5:
        e = move-exception;
        throw new IllegalStateException("BasePuller parseType() fail !!!", e);
    }

    public Flowable<RESULT> pull(final PARAMS r100) {
        NetService.f r101 = buildRequest(this.mPath, r100);
        return this.mPuller.a(r101).map(new AnonymousClass2(this)).onErrorResumeNext(new a(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
    public /* bridge */ /* synthetic */ Flowable pull(Object r100) {
        return pull((Params) r100);
    }

    public BasePuller(NetService r100, String r101) {
        this.mPath = r101;
        this.mPuller = r100.Rb(parseType());
    }

    private Publisher lambda$pull$0(Params r100, Throwable r101) throws Exception {
        tt5.a.e(TAG, String.format("%s pull error, params: %s. ", new Object[]{getClass().getSimpleName(), r100.toString()}), r101, false);
        return Flowable.error(r101);
    }

    public NetService.f buildRequest(String r100, PARAMS r101) {
        NetService.f r102 = new NetService.f(r100);
        r102.f216913j = JSON.toJSONString(r101);
        r102.f216906c = 1;
        return r102;
    }
}
