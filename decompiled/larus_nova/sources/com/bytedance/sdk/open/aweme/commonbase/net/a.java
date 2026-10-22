package com.bytedance.sdk.open.aweme.commonbase.net;

import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.core.net.OpenNetHeaders;

/* JADX INFO: loaded from: classes22.dex */
public class a implements OpenNetworkService {

    /* JADX INFO: renamed from: com.bytedance.sdk.open.aweme.commonbase.net.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C3767a {
    }

    public class b implements IOpenHostNetCall {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OpenHostRequest f269616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f269617b;

        private b(a r100, OpenHostRequest r101) {
            this.f269617b = r100;
            this.f269616a = r101;
        }

        public /* synthetic */ b(a r100, OpenHostRequest r101, C3767a r102) {
            this(r100, r101);
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public void cancel() {
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public OpenHostResponse execute() {
            return new OpenHostResponse(-1, "please implement OpenNetworkService", this.f269616a.getUrl(), OpenNetHeaders.empty, null, new Exception("please implement OpenNetworkService"));
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public OpenHostRequest getRequest() {
            return this.f269616a;
        }
    }

    public a() {
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenNetworkService
    public IOpenHostNetCall newCall(OpenHostRequest r100) {
        return new b(this, r100, null);
    }
}
