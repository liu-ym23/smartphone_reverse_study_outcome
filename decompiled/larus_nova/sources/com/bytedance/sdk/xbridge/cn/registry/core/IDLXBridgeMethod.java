package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000 \u00182\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u000bH&R\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeContext", "", "", "params", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$a;", "callback", "", "realHandle", "", "canRunInBackground", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "compatibility", "getName", "()Ljava/lang/String;", "name", "Companion", "Access", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "Compatibility", "XBridgeThreadType", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IDLXBridgeMethod {
    public static final int APPID_EMPTY = 1001;
    public static final int BDX_BRIDGE_NULL = -13;
    public static final int BRIDGE_RELEASED = -12;
    public static final int CANCELLED = -7;
    public static final b Companion = null;
    public static final int EXCEPTION_THROWN = -999;
    public static final int FAIL = 0;
    public static final int HANDLE_ERROR = -11;
    public static final int HOST_MEMORY_HIGH = -1004;
    public static final int IDL_ERROR = -10;
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
    public static final int UNKNOWN_APP_ID = 0;
    public static final int UNKNOWN_ERROR = -1000;
    public static final int UNKNOWN_HOST = -4;
    public static final int UNREGISTERED = -2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PUBLIC", "PROTECT", "PRIVATE", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum Access extends Enum<Access> {
        private static final /* synthetic */ Access[] $VALUES = null;
        public static final Access PRIVATE = null;
        public static final Access PROTECT = null;
        public static final Access PUBLIC = null;
        public static final Access SECURE = null;
        private final String value;

        private static final /* synthetic */ Access[] $values() {
            return new Access[]{PUBLIC, PROTECT, PRIVATE, SECURE};
        }

        public static Access valueOf(String r100) {
            return (Access) r27.a.a(Access.class, r100);
        }

        public static Access[] values() {
            return (Access[]) $VALUES.clone();
        }

        static {
            PUBLIC = new Access("PUBLIC", 0, "public");
            PROTECT = new Access("PROTECT", 1, "protected");
            PRIVATE = new Access("PRIVATE", 2, BridgePrivilege.PRIVATE);
            SECURE = new Access("SECURE", 3, "secure");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private Access(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "", "", "value", "Z", "getValue", "()Z", "Compatible", "InCompatible", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Compatibility extends Enum<Compatibility> {
        public static final Compatibility Compatible = null;
        public static final Compatibility InCompatible = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Compatibility[] f270077a = null;
        private final boolean value;

        public static Compatibility valueOf(String r100) {
            return (Compatibility) r27.a.a(Compatibility.class, r100);
        }

        public static Compatibility[] values() {
            return (Compatibility[]) f270077a.clone();
        }

        static {
            Compatibility r100 = new Compatibility("Compatible", 0, true);
            Compatible = r100;
            Compatibility r101 = new Compatibility("InCompatible", 1, false);
            InCompatible = r101;
            f270077a = new Compatibility[]{r100, r101};
        }

        public final boolean getValue() {
            return this.value;
        }

        public Compatibility(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SYNC_THREAD", "MAIN_THREAD", "ASYNC_THREAD", "MAIN_THREAD_OPT", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum XBridgeThreadType extends Enum<XBridgeThreadType> {
        public static final XBridgeThreadType ASYNC_THREAD = null;
        public static final XBridgeThreadType MAIN_THREAD = null;
        public static final XBridgeThreadType MAIN_THREAD_OPT = null;
        public static final XBridgeThreadType SYNC_THREAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ XBridgeThreadType[] f270078a = null;
        private final String value;

        public static XBridgeThreadType valueOf(String r100) {
            return (XBridgeThreadType) r27.a.a(XBridgeThreadType.class, r100);
        }

        public static XBridgeThreadType[] values() {
            return (XBridgeThreadType[]) f270078a.clone();
        }

        static {
            XBridgeThreadType r100 = new XBridgeThreadType("SYNC_THREAD", 0, "sync_thread");
            SYNC_THREAD = r100;
            XBridgeThreadType r101 = new XBridgeThreadType("MAIN_THREAD", 1, "main_thread");
            MAIN_THREAD = r101;
            XBridgeThreadType r102 = new XBridgeThreadType("ASYNC_THREAD", 2, "async_thread");
            ASYNC_THREAD = r102;
            XBridgeThreadType r103 = new XBridgeThreadType("MAIN_THREAD_OPT", 3, "main_thread_opt");
            MAIN_THREAD_OPT = r103;
            f270078a = new XBridgeThreadType[]{r100, r101, r102, r103};
        }

        public final String getValue() {
            return this.value;
        }

        public XBridgeThreadType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void invoke(Map<String, ? extends Object> r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f270079a = null;

        static {
            f270079a = new b();
        }

        public b() {
        }
    }

    static {
        Companion = b.f270079a;
    }

    boolean canRunInBackground();

    Access getAccess();

    Compatibility getCompatibility();

    String getName();

    void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, a r102);
}
