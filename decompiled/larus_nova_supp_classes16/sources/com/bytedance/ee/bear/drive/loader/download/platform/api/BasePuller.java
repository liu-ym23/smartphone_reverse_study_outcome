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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public static /* synthetic */ Publisher a(BasePuller r0, Params r1, Throwable r2) {
        return r0.lambda$pull$0(r1, r2);
    }

    private Type parseType() {
        final Type[] r1 = {((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]};
        return new AnonymousClass1(this, r1).getType();
    L5:
        e = move-exception;
        throw new IllegalStateException("BasePuller parseType() fail !!!", e);
    }

    public Flowable<RESULT> pull(final PARAMS r3) {
        NetService.f r0 = buildRequest(this.mPath, r3);
        return this.mPuller.a(r0).map(new AnonymousClass2(this)).onErrorResumeNext(new a(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller
    public /* bridge */ /* synthetic */ Flowable pull(Object r1) {
        return pull((Params) r1);
    }

    public BasePuller(NetService r1, String r2) {
        this.mPath = r2;
        this.mPuller = r1.Rb(parseType());
    }

    private Publisher lambda$pull$0(Params r4, Throwable r5) throws Exception {
        tt5.a.e(TAG, String.format("%s pull error, params: %s. ", new Object[]{getClass().getSimpleName(), r4.toString()}), r5, false);
        return Flowable.error(r5);
    }

    public NetService.f buildRequest(String r2, PARAMS r3) {
        NetService.f r0 = new NetService.f(r2);
        r0.j = JSON.toJSONString(r3);
        r0.c = 1;
        return r0;
    }
}
