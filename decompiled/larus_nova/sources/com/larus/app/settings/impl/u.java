package com.larus.app.settings.impl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/app/settings/impl/CreationUserConfigValue;", "", "configType", "", "configValue", "", "portraitAuth", "Lcom/larus/app/settings/impl/CreationPortraitAuthOption;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/app/settings/impl/CreationPortraitAuthOption;)V", "getConfigType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfigValue", "()Ljava/lang/String;", "getPortraitAuth", "()Lcom/larus/app/settings/impl/CreationPortraitAuthOption;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/app/settings/impl/CreationPortraitAuthOption;)Lcom/larus/app/settings/impl/CreationUserConfigValue;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class u {

    @SerializedName("config_type")
    private final Integer configType;

    @SerializedName("config_value")
    private final String configValue;

    @SerializedName("portrait_auth")
    private final s portraitAuth;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.configType, r101.configType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configValue, r101.configValue) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.portraitAuth, r101.portraitAuth) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.configType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.configValue;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        s r107 = this.portraitAuth;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationUserConfigValue(configType=" + this.configType + ", configValue=" + this.configValue + ", portraitAuth=" + this.portraitAuth + ')';
    }

    public u() {
        this.configType = null;
        this.configValue = null;
        this.portraitAuth = null;
    }

    public final Integer a() {
        return this.configType;
    }

    public final String b() {
        return this.configValue;
    }

    public final s c() {
        return this.portraitAuth;
    }
}
