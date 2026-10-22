package com.ss.ugc.effectplatform.bridge.network;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\f\u0018\u0000 /2\u00020\u0001:\u00010BO\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%¢\u0006\u0004\b,\u0010-B-\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010.R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010!R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/NetResponse;", "", "", "logId$delegate", "Lkotlin/Lazy;", "getLogId", "()Ljava/lang/String;", "logId", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "bodyStream", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "getBodyStream", "()Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "setBodyStream", "(Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;)V", "", "contentLength", "J", "getContentLength", "()J", "setContentLength", "(J)V", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "setErrorMsg", "(Ljava/lang/String;)V", "filePath", "getFilePath", "setFilePath", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "<init>", "(ILcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(ILcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;JLjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "effect_bridge_release"}, k = 1, mv = {1, 4, 0})
public final class NetResponse {
    public static final a Companion = null;
    public static final String HEADER_KEY_LOG_ID = "x-tt-logid";
    private ByteReadStream bodyStream;
    private long contentLength;
    private String errorMsg;
    private String filePath;
    private Map<String, String> headers;
    private final Lazy logId$delegate;
    private int statusCode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getLogId() {
        return (String) this.logId$delegate.getValue();
    }

    public final ByteReadStream getBodyStream() {
        return this.bodyStream;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setBodyStream(ByteReadStream r100) {
        this.bodyStream = r100;
    }

    public final void setContentLength(long r100) {
        this.contentLength = r100;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setFilePath(String r100) {
        this.filePath = r100;
    }

    public final void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public NetResponse(int r110, ByteReadStream r111, long r112, String r113) {
        this(r110, r111, r112, r113, null, null, 32, null);
    }

    public NetResponse(int r100, ByteReadStream r101, long r102, String r103, String r104, Map<String, String> r105) {
        this.statusCode = r100;
        this.bodyStream = r101;
        this.contentLength = r102;
        this.errorMsg = r103;
        this.filePath = r104;
        this.headers = r105;
        this.logId$delegate = LazyKt.lazy(new NetResponse$logId$2(this));
    }

    public /* synthetic */ NetResponse(int r100, ByteReadStream r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 8) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r102, r110);
    }

    public /* synthetic */ NetResponse(int r110, ByteReadStream r111, long r112, String r113, String r114, Map r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        Map r102 = null;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
