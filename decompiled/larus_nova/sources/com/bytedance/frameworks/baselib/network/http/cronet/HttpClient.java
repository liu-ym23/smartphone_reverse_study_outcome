package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import lx5.b;

/* JADX INFO: loaded from: classes19.dex */
public class HttpClient {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cronet.HttpClient$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }

        public b getHttpClient(Context r100) {
            return SsCronetHttpClient.inst(r100);
        }
    }

    public HttpClient() {
    }

    static {
        IMPL = new BaseImpl(null);
    }

    public static b getHttpClient(Context r100, String r101) {
        return IMPL.getHttpClient(r100);
    }
}
