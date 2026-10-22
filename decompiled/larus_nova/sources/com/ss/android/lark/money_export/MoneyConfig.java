package com.ss.android.lark.money_export;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "money_config")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/money_export/MoneyConfig;", "", "walletLynxUrl", "", "<init>", "(Ljava/lang/String;)V", "getWalletLynxUrl", "()Ljava/lang/String;", "setWalletLynxUrl", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "money-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoneyConfig {

    @SerializedName("wallet_lynx_url")
    private String walletLynxUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public MoneyConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MoneyConfig copy$default(MoneyConfig r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.walletLynxUrl;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.walletLynxUrl;
    }

    public final MoneyConfig copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "walletLynxUrl");
        return new MoneyConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MoneyConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.walletLynxUrl, ((MoneyConfig) r100).walletLynxUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.walletLynxUrl.hashCode();
    }

    public String toString() {
        return "MoneyConfig(walletLynxUrl=" + this.walletLynxUrl + ')';
    }

    public final String getWalletLynxUrl() {
        return this.walletLynxUrl;
    }

    public MoneyConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "walletLynxUrl");
        this.walletLynxUrl = r100;
    }

    public final void setWalletLynxUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.walletLynxUrl = r100;
    }

    public /* synthetic */ MoneyConfig(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
