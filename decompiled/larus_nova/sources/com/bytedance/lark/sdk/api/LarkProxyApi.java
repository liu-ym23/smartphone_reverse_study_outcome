package com.bytedance.lark.sdk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public interface LarkProxyApi {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/sdk/api/LarkProxyApi$ProxyType;", "", "<init>", "(Ljava/lang/String;I)V", "HTTP", "HTTPS", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ProxyType extends Enum<ProxyType> {
        public static final ProxyType HTTP = null;
        public static final ProxyType HTTPS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProxyType[] f254121a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254122b = null;

        public static EnumEntries<ProxyType> getEntries() {
            return f254122b;
        }

        static {
            ProxyType r100 = new ProxyType("HTTP", 0);
            HTTP = r100;
            ProxyType r101 = new ProxyType("HTTPS", 1);
            HTTPS = r101;
            ProxyType[] r102 = {r100, r101};
            f254121a = r102;
            f254122b = EnumEntriesKt.enumEntries(r102);
        }

        public static ProxyType[] values() {
            return (ProxyType[]) f254121a.clone();
        }

        public static ProxyType valueOf(String r100) {
            return (ProxyType) a.a(ProxyType.class, r100);
        }

        public ProxyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a(String r100, String r101, ProxyType r102);

    void b();
}
