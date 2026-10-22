package hr9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006 "}, d2 = {"Lcom/larus/platform/model/security/SecurityACryptoSetting;", "", "enabled", "", "version", "", "disable_android_key_store", "disable_crypto", "<init>", "(ZIZZ)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getVersion", "()I", "setVersion", "(I)V", "getDisable_android_key_store", "setDisable_android_key_store", "getDisable_crypto", "setDisable_crypto", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("disable_android_key_store")
    private boolean disable_android_key_store;

    @SerializedName("disable_crypto")
    private boolean disable_crypto;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("version")
    private int version;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.version == r101.version) goto L15;
        return false;
    L15:
        if (this.disable_android_key_store == r101.disable_android_key_store) goto L18;
        return false;
    L18:
        if (this.disable_crypto == r101.disable_crypto) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.version) * 31;
        if (this.disable_android_key_store == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.disable_crypto == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SecurityACryptoSetting(enabled=" + this.enabled + ", version=" + this.version + ", disable_android_key_store=" + this.disable_android_key_store + ", disable_crypto=" + this.disable_crypto + ')';
    }

    public final boolean a() {
        return this.disable_android_key_store;
    }

    public final boolean b() {
        return this.disable_crypto;
    }

    public final boolean c() {
        return this.enabled;
    }

    public final int d() {
        return this.version;
    }

    public b(int r100) {
        this.enabled = true;
        this.version = 0;
        this.disable_android_key_store = false;
        this.disable_crypto = false;
    }
}
