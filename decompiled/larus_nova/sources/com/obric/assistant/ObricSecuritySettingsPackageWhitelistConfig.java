package com.obric.assistant;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "", "appListSignatures", "", "Lcom/obric/assistant/NotificationSignatureWhiteItem;", "globalWhiteListSignatureCheckEnabled", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getAppListSignatures", "()Ljava/util/List;", "getGlobalWhiteListSignatureCheckEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSecuritySettingsPackageWhitelistConfig {

    @SerializedName("app_list_signatures")
    private final List<NotificationSignatureWhiteItem> appListSignatures;

    @SerializedName("global_white_list_signature_check_enabled")
    @JsonAdapter(ObricBoolean01Adapter.class)
    private final Boolean globalWhiteListSignatureCheckEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricSecuritySettingsPackageWhitelistConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricSecuritySettingsPackageWhitelistConfig copy$default(ObricSecuritySettingsPackageWhitelistConfig r100, List r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appListSignatures;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.globalWhiteListSignatureCheckEnabled;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<NotificationSignatureWhiteItem> component1() {
        return this.appListSignatures;
    }

    public final Boolean component2() {
        return this.globalWhiteListSignatureCheckEnabled;
    }

    public final ObricSecuritySettingsPackageWhitelistConfig copy(List<NotificationSignatureWhiteItem> r100, Boolean r101) {
        return new ObricSecuritySettingsPackageWhitelistConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricSecuritySettingsPackageWhitelistConfig) == true) goto L8;
        return false;
    L8:
        ObricSecuritySettingsPackageWhitelistConfig r101 = (ObricSecuritySettingsPackageWhitelistConfig) r100;
        if (Intrinsics.areEqual(this.appListSignatures, r101.appListSignatures) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.globalWhiteListSignatureCheckEnabled, r101.globalWhiteListSignatureCheckEnabled) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<NotificationSignatureWhiteItem> r100 = this.appListSignatures;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.globalWhiteListSignatureCheckEnabled;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricSecuritySettingsPackageWhitelistConfig(appListSignatures=" + this.appListSignatures + ", globalWhiteListSignatureCheckEnabled=" + this.globalWhiteListSignatureCheckEnabled + ')';
    }

    public final List<NotificationSignatureWhiteItem> getAppListSignatures() {
        return this.appListSignatures;
    }

    public final Boolean getGlobalWhiteListSignatureCheckEnabled() {
        return this.globalWhiteListSignatureCheckEnabled;
    }

    public ObricSecuritySettingsPackageWhitelistConfig(List<NotificationSignatureWhiteItem> r100, Boolean r101) {
        this.appListSignatures = r100;
        this.globalWhiteListSignatureCheckEnabled = r101;
    }

    public /* synthetic */ ObricSecuritySettingsPackageWhitelistConfig(List r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
