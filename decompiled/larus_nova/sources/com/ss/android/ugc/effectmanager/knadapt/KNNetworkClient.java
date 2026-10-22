package com.ss.android.ugc.effectmanager.knadapt;

import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNNetworkClient;", "Lcom/ss/ugc/effectplatform/bridge/network/INetworkClient;", "effectNetWrapper", "Lcom/ss/android/ugc/effectmanager/common/listener/IEffectNetWorker;", "(Lcom/ss/android/ugc/effectmanager/common/listener/IEffectNetWorker;)V", "fetchFromNetwork", "Lcom/ss/ugc/effectplatform/bridge/network/NetResponse;", "netRequest", "Lcom/ss/ugc/effectplatform/bridge/network/NetRequest;", "logRequestedUrl", "", "effectRequest", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class KNNetworkClient implements INetworkClient {
    public static final Companion Companion = null;
    private static final String HEADER_KEY_LOG_ID = "x-tt-logid";
    private static final String TAG = "KNNetworker";
    private final IEffectNetWorker effectNetWrapper;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNNetworkClient$Companion;", "", "()V", "HEADER_KEY_LOG_ID", "", "TAG", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KNNetworkClient(IEffectNetWorker r100) {
        this.effectNetWrapper = r100;
    }

    private final void logRequestedUrl(NetRequest r100) {
        String r101 = new Regex("&?device_info=[^&]*").replace(r100.getUrl(), "");     // Catch: Exception -> L5
        Logger.INSTANCE.d(TAG, "request url: " + r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "error in print url", e);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public NetResponse fetchFromNetwork(NetRequest r110) {
        if (r110.getMethod() != HTTPMethod.POST) goto L5;
        String r100 = "POST";
    L6:
        logRequestedUrl(r110);
        EffectRequest r101 = new EffectRequest(r100, r110.getUrl(), r110.getUseCommParam());
        r101.setContentType(r110.getContentType());
        if (r110.getHeaders() == null) goto L10;
        r101.setHeaders(r110.getHeaders());
    L10:
        if (r110.getBodyParams() == null) goto L34;
        r101.setBodyParams(r110.getBodyParams());
    L34:
        InputStream r111 = this.effectNetWrapper.execute(r101);     // Catch: Exception -> L27
        String r102 = r101.getLogId();     // Catch: Exception -> L27
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        HashMap r104 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("x-tt-logid", r101.getLogId())});     // Catch: Exception -> L27
    L22:
        HashMap r105 = r104;
        if (r111 == null) goto L26;
        return new NetResponse(200, new InputStreamByteRead(r111), r101.getContentLength(), r101.getErrorMsg(), "", r105);
    L26:
        return new NetResponse(400, new EmptyByteReadStream(), 0, r101.getErrorMsg(), "", r105);
    L21:
        r104 = new HashMap();     // Catch: Exception -> L27
        goto L22
    L15:
        if (StringsKt.isBlank(r102) == true) goto L18;
        r103 = false;
    L27:
        e = move-exception;
        e.printStackTrace();
        EmptyByteReadStream r106 = new EmptyByteReadStream();
        String r107 = r101.getErrorMsg();
        if (r107 == null) goto L31;
        String r108 = r107;
    L33:
        return new NetResponse(400, r106, 0, r108, "", r101.getResponseHeaders());
    L31:
        r108 = e.getMessage();
        goto L33
    L5:
        r100 = "GET";
        goto L6
    }
}
