package se7;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Client.Provider {

    public static final class a implements Client {
        public a() {
        }

        @Override // com.bytedance.retrofit2.client.Client
        public final SsCall newSsCall(Request r100) throws IOException {
            Context r101 = TTNetInit.getTTNetDepend().getContext();
            SsOkHttp3Client r102 = SsOkHttp3Client.inst(r101);
            if (i.c(r101) == false) goto L6;
            r102.setOk3TncBridge(TNCManager.getInstance());
        L6:
            return r102.newSsCall(r100);
        }
    }

    public e() {
    }

    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return new a();
    }
}
