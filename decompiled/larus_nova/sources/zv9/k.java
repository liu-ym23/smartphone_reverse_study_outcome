package zv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/security/FileShareSecurityConfig;", "", "enableEnterpriseFileCrypto", "", "<init>", "(Z)V", "getEnableEnterpriseFileCrypto", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("enable_enterprise_file_crypto")
    private final boolean enableEnterpriseFileCrypto;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (this.enableEnterpriseFileCrypto == ((k) r100).enableEnterpriseFileCrypto) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.enableEnterpriseFileCrypto == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "FileShareSecurityConfig(enableEnterpriseFileCrypto=" + this.enableEnterpriseFileCrypto + ')';
    }

    public final boolean a() {
        return this.enableEnterpriseFileCrypto;
    }

    public k(int r100) {
        this.enableEnterpriseFileCrypto = false;
    }
}
