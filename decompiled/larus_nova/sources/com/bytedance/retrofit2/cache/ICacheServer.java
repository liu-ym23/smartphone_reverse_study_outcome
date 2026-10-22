package com.bytedance.retrofit2.cache;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;

/* JADX INFO: loaded from: classes6.dex */
public interface ICacheServer {
    Response getCacheResponse(Request r100);

    Response putCacheResponse(Request r100, Response r101);
}
