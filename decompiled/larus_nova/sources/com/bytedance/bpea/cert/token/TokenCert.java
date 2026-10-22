package com.bytedance.bpea.cert.token;

import com.bytedance.bpea.basics.BaseCert;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bpea/cert/token/TokenCert;", "Lcom/bytedance/bpea/basics/BaseCert;", "token", "", "(Ljava/lang/String;)V", "authKey", "getToken", "()Ljava/lang/String;", "auth", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "token-cert_release"}, k = 1, mv = {1, 1, 16})
public final class TokenCert extends BaseCert {
    public static final String CERT_TYPE = "TokenCert";
    public static final Companion Companion = null;
    private String authKey;
    private final String token;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/bpea/cert/token/TokenCert$Companion;", "", "()V", "CERT_TYPE", "", "with", "Lcom/bytedance/bpea/cert/token/TokenCert;", "token", "token-cert_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final TokenCert with(String r100) {
            return new TokenCert(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ TokenCert copy$default(TokenCert r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        return r100.copy(r101);
    }

    @JvmStatic
    public static final TokenCert with(String r100) {
        return Companion.with(r100);
    }

    public final String component1() {
        return this.token;
    }

    public final TokenCert copy(String r100) {
        return new TokenCert(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TokenCert) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.token, ((TokenCert) r100).token) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.token;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @Override // com.bytedance.bpea.basics.BaseCert
    public String toString() {
        return "TokenCert(token=" + this.token + ")";
    }

    @Override // com.bytedance.bpea.basics.BaseCert, com.bytedance.bpea.basics.Cert
    public String authKey() {
        return this.authKey;
    }

    public final String getToken() {
        return this.token;
    }

    public TokenCert(String r100) {
        super(r100, CERT_TYPE);
        this.token = r100;
    }

    public final TokenCert auth(String r100) {
        this.authKey = r100;
        return this;
    }
}
