package com.ss.android.ugc.aweme.framework.services;

import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes40.dex */
public interface IRetrofitService {
    IRetrofit createNewRetrofit(String r100);

    IRetrofit createNewRetrofit(String r100, List<Interceptor> r101);

    RuntimeException propagateCompatibleException(ExecutionException r100) throws Exception;
}
