package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/SecuritySettingsConfig;", "", "enableOSecurity", "", "enableOBlockDeeplinkQuery", "enableOBlockShareInDoubao", "enableOBlockDebugRouter", "oChatInputMaxLength", "", "<init>", "(ZZZZI)V", "getEnableOSecurity", "()Z", "getEnableOBlockDeeplinkQuery", "getEnableOBlockShareInDoubao", "getEnableOBlockDebugRouter", "getOChatInputMaxLength", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecuritySettingsConfig {

    @SerializedName("enable_o_block_debug_router")
    private final boolean enableOBlockDebugRouter;

    @SerializedName("enable_o_block_deeplink_query")
    private final boolean enableOBlockDeeplinkQuery;

    @SerializedName("enable_o_block_share_in_doubao")
    private final boolean enableOBlockShareInDoubao;

    @SerializedName("enable_o_security")
    private final boolean enableOSecurity;

    @SerializedName("o_chat_input_max_length")
    private final int oChatInputMaxLength;

    public SecuritySettingsConfig() {
        this(false, false, false, false, 0, 31, null);
    }

    public static /* synthetic */ SecuritySettingsConfig copy$default(SecuritySettingsConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableOSecurity;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableOBlockDeeplinkQuery;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enableOBlockShareInDoubao;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableOBlockDebugRouter;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.oChatInputMaxLength;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableOSecurity;
    }

    public final boolean component2() {
        return this.enableOBlockDeeplinkQuery;
    }

    public final boolean component3() {
        return this.enableOBlockShareInDoubao;
    }

    public final boolean component4() {
        return this.enableOBlockDebugRouter;
    }

    public final int component5() {
        return this.oChatInputMaxLength;
    }

    public final SecuritySettingsConfig copy(boolean r100, boolean r101, boolean r110, boolean r111, int r112) {
        return new SecuritySettingsConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecuritySettingsConfig) == true) goto L8;
        return false;
    L8:
        SecuritySettingsConfig r101 = (SecuritySettingsConfig) r100;
        if (this.enableOSecurity == r101.enableOSecurity) goto L12;
        return false;
    L12:
        if (this.enableOBlockDeeplinkQuery == r101.enableOBlockDeeplinkQuery) goto L15;
        return false;
    L15:
        if (this.enableOBlockShareInDoubao == r101.enableOBlockShareInDoubao) goto L18;
        return false;
    L18:
        if (this.enableOBlockDebugRouter == r101.enableOBlockDebugRouter) goto L21;
        return false;
    L21:
        if (this.oChatInputMaxLength == r101.oChatInputMaxLength) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableOSecurity == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableOBlockDeeplinkQuery == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableOBlockShareInDoubao == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableOBlockDebugRouter == true) goto L19;
        r100 = 1237;
    L19:
        return ((r106 + r100) * 31) + this.oChatInputMaxLength;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SecuritySettingsConfig(enableOSecurity=" + this.enableOSecurity + ", enableOBlockDeeplinkQuery=" + this.enableOBlockDeeplinkQuery + ", enableOBlockShareInDoubao=" + this.enableOBlockShareInDoubao + ", enableOBlockDebugRouter=" + this.enableOBlockDebugRouter + ", oChatInputMaxLength=" + this.oChatInputMaxLength + ')';
    }

    public final boolean getEnableOBlockDebugRouter() {
        return this.enableOBlockDebugRouter;
    }

    public final boolean getEnableOBlockDeeplinkQuery() {
        return this.enableOBlockDeeplinkQuery;
    }

    public final boolean getEnableOBlockShareInDoubao() {
        return this.enableOBlockShareInDoubao;
    }

    public final boolean getEnableOSecurity() {
        return this.enableOSecurity;
    }

    public final int getOChatInputMaxLength() {
        return this.oChatInputMaxLength;
    }

    public SecuritySettingsConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104) {
        this.enableOSecurity = r100;
        this.enableOBlockDeeplinkQuery = r101;
        this.enableOBlockShareInDoubao = r102;
        this.enableOBlockDebugRouter = r103;
        this.oChatInputMaxLength = r104;
    }

    public /* synthetic */ SecuritySettingsConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104, int r105, DefaultConstructorMarker r110) {
        boolean r106 = true;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = true;
    L7:
        if ((r105 & 2) == 0) goto L9;
        boolean r107 = true;
    L11:
        if ((r105 & 4) == 0) goto L13;
        boolean r108 = true;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 10000;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
