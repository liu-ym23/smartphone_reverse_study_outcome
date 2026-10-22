package com.bytedance.ies.xbridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fJ\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0002H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0012\u001a\u00020\rH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/model/params/a;", "provideParamModel", "Li66/a;", "provideResultModel", "Lcom/bytedance/ies/xbridge/XReadableMap;", "params", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "callback", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "type", "", "handle", "Lg66/c;", "contextProviderFactory", "setProviderFactory", "release", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "access", "", "getName", "()Ljava/lang/String;", "name", "Companion", "Access", "Callback", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface XBridgeMethod extends com.bytedance.sdk.xbridge.cn.protocol.h {
    public static final int CANCELLED = -7;
    public static final a Companion = null;
    public static final int FAIL = 0;
    public static final int INVALID_PARAM = -3;
    public static final int INVALID_RESULT = -5;
    public static final int KEY_NOT_FOUND = 2;
    public static final int MALFORMEDRESPONSE_ERROR = -1003;
    public static final int NETWORK_TIMEOUT = -1002;
    public static final int NETWORK_UNREACHABLE = -1001;
    public static final int NOT_FOUND = -9;
    public static final int OPERATION_TIMEOUT = -8;
    public static final String PARAM_CODE = "code";
    public static final String PARAM_DATA = "data";
    public static final String PARAM_MSG = "msg";
    public static final int SUCCESS = 1;
    public static final int UNAUTHORIZED = -1;
    public static final int UNAUTHORIZED_ACCESS = -6;
    public static final int UNKNOWN_ERROR = -1000;
    public static final int UNREGISTERED = -2;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeMethod$Access;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PUBLIC", "PRIVATE", "PROTECT", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Access extends Enum<Access> {
        public static final Access PRIVATE = null;
        public static final Access PROTECT = null;
        public static final Access PUBLIC = null;
        public static final Access SECURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Access[] f249436a = null;
        private final String value;

        public static Access valueOf(String r100) {
            return (Access) r27.a.a(Access.class, r100);
        }

        public static Access[] values() {
            return (Access[]) f249436a.clone();
        }

        static {
            Access r100 = new Access("PUBLIC", 0, "public");
            PUBLIC = r100;
            Access r101 = new Access("PRIVATE", 1, BridgePrivilege.PRIVATE);
            PRIVATE = r101;
            Access r102 = new Access("PROTECT", 2, "protected");
            PROTECT = r102;
            Access r103 = new Access("SECURE", 3, "secure");
            SECURE = r103;
            f249436a = new Access[]{r100, r101, r102, r103};
        }

        public final String getValue() {
            return this.value;
        }

        public Access(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "", AbsMethodDelegate.TAG_INVOKE, "", "data", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public interface Callback {
        void invoke(Map<String, Object> r100);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f249437a = null;

        static {
            f249437a = new a();
        }

        public a() {
        }
    }

    public interface b {
        void sendJsEvent(String r100, XReadableMap r101);
    }

    static {
        Companion = a.f249437a;
    }

    Access getAccess();

    String getName();

    void handle(XReadableMap r100, Callback r101, XBridgePlatformType r102);

    Class<? extends com.bytedance.ies.xbridge.model.params.a> provideParamModel();

    Class<? extends i66.a> provideResultModel();

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    void release();

    void setProviderFactory(g66.c r100);
}
