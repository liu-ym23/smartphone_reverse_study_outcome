package com.ivy.ivykit.api.bridge.core;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import dx7.b;
import java.util.Map;
import kotlin.Metadata;
import ux7.d;

/* JADX INFO: loaded from: classes23.dex */
public interface IvyBridgeMethod {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethod$Access;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PUBLIC", "PRIVATE", "PROTECT", "SECURE", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Access extends Enum<Access> {
        public static final Access PRIVATE = null;
        public static final Access PROTECT = null;
        public static final Access PUBLIC = null;
        public static final Access SECURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Access[] f278312a = null;
        private final String value;

        public static Access valueOf(String r100) {
            return (Access) r27.a.a(Access.class, r100);
        }

        public static Access[] values() {
            return (Access[]) f278312a.clone();
        }

        static {
            Access r100 = new Access("PUBLIC", 0, "public");
            PUBLIC = r100;
            Access r101 = new Access("PRIVATE", 1, BridgePrivilege.PRIVATE);
            PRIVATE = r101;
            Access r102 = new Access("PROTECT", 2, "protect");
            PROTECT = r102;
            Access r103 = new Access("SECURE", 3, "secure");
            SECURE = r103;
            f278312a = new Access[]{r100, r101, r102, r103};
        }

        public final String getValue() {
            return this.value;
        }

        public Access(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void invoke(Map<String, Object> r100);
    }

    void a(b r100, d.C7943d r101, IvyBridgePlatformType r102);

    void b(ex7.d r100);

    Access getAccess();

    String getName();

    void release();
}
