package com.obric.sva.sdk.effectplatform;

import android.accounts.NetworkErrorException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.sva.sdk.network.InputStreamByteRead;
import com.obric.sva.sdk.network.NetworkProxyKt;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/TTNETImplNetWorker;", "Lcom/ss/ugc/effectplatform/bridge/network/INetworkClient;", "<init>", "()V", "request", "Lcom/ss/ugc/effectplatform/bridge/network/NetResponse;", "effectRequest", "Lcom/ss/ugc/effectplatform/bridge/network/NetRequest;", "setHeaders", "", "Lcom/bytedance/retrofit2/client/Header;", "headerParams", "", "", "fetchFromNetwork", "netRequest", "logRequestedUrl", "", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTNETImplNetWorker implements INetworkClient {
    public static final Companion Companion = null;
    private static final String TAG = "OkHttpImplNetWorker";
    private static final String TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final String TYPE_JSON = "application/json";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/TTNETImplNetWorker$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_JSON", "TYPE_FORM_URLENCODED", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[HTTPMethod.values().length];
            r100[HTTPMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[HTTPMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTNETImplNetWorker() {
    }

    private final void logRequestedUrl(NetRequest r100) {
        LogUtils.d(TAG, "request url: " + new Regex("&?device_info=[^&]*").replace(r100.getUrl(), ""), new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "error in print url", new Object[]{e});
    }

    private final NetResponse request(NetRequest r110) throws Exception {
        List<Header> r100 = setHeaders(r110.getHeaders());
        int r101 = WhenMappings.$EnumSwitchMapping$0[r110.getMethod().ordinal()];
        TypedInput r102 = null;
        if (r101 != 1) goto L5;
        SsResponse r111 = NetworkProxyKt.streamByGet$default(r110.getUrl(), r110.getUseCommParam(), 0, r100, 4, null);
    L16:
        if (r111 == null) goto L18;
        Integer r103 = Integer.valueOf(r111.code());
    L19:
        if (r111 == null) goto L21;
        r102 = (TypedInput) r111.body();
    L21:
        if (r103 != null) goto L24;
    L28:
        StringBuilder r104 = new StringBuilder("http response code:");
        Object r105 = r103;
        if (r103 != null) goto L31;
        r105 = "unknown";
    L31:
        r104.append(r105);
        throw new NetworkErrorException(r104.toString());
    L24:
        if (r103.intValue() != 200) goto L28;
        if (r102 == null) goto L28;
        return new NetResponse(r103.intValue(), new InputStreamByteRead(r102.in()), r102.length(), null);
    L18:
        r103 = null;
        goto L19
    L5:
        if (r101 != 2) goto L14;
        String r106 = r110.getContentType();
        if (Intrinsics.areEqual(r106, "application/json") == false) goto L10;
        r111 = NetworkProxyKt.streamByPostJson$default(r110.getUrl(), r110.getUseCommParam(), 0, r110.getBodyParams(), r100, 4, null);
        goto L16
    L10:
        if (Intrinsics.areEqual(r106, "application/x-www-form-urlencoded") == false) goto L12;
        r111 = NetworkProxyKt.streamByPostForm$default(r110.getUrl(), r110.getUseCommParam(), 0, r110.getBodyParams(), r100, 4, null);
        goto L16
    L12:
        r111 = null;
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final List<Header> setHeaders(Map<String, String> r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return null;
    L11:
        ArrayList r102 = new ArrayList();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, String> r104 = r103.next();
        r102.add(new Header(r104.getKey(), r104.getValue()));
        goto L13
    L15:
        return r102;
    L4:
        if (r100.isEmpty() == true) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public NetResponse fetchFromNetwork(NetRequest r110) {
        Intrinsics.checkNotNullParameter(r110, "netRequest");
        logRequestedUrl(r110);     // Catch: Exception -> L5
        return request(r110);
    L5:
        e = move-exception;
        LogUtils.e(TAG, e.getMessage(), new Object[]{e});
        return new NetResponse(-1, new EmptyByteReadStream(), -1, null, 8, null);
    }
}
