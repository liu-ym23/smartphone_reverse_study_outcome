package com.larus.settings.provider.actionbar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/actionbar/ActionBarConnectorConfig;", "", "acbConnectorEnable", "", "acbAddConnectorSchema", "", "acbConnectorLinkSchema", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getAcbConnectorEnable", "()Z", "getAcbAddConnectorSchema", "()Ljava/lang/String;", "getAcbConnectorLinkSchema", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarConnectorConfig {

    @SerializedName("acb_add_connector_schema")
    private final String acbAddConnectorSchema;

    @SerializedName("acb_connector_enable")
    private final boolean acbConnectorEnable;

    @SerializedName("acb_connector_link_schema")
    private final String acbConnectorLinkSchema;

    public ActionBarConnectorConfig() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ActionBarConnectorConfig copy$default(ActionBarConnectorConfig r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.acbConnectorEnable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.acbAddConnectorSchema;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.acbConnectorLinkSchema;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.acbConnectorEnable;
    }

    public final String component2() {
        return this.acbAddConnectorSchema;
    }

    public final String component3() {
        return this.acbConnectorLinkSchema;
    }

    public final ActionBarConnectorConfig copy(boolean r100, String r101, String r102) {
        return new ActionBarConnectorConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionBarConnectorConfig) == true) goto L8;
        return false;
    L8:
        ActionBarConnectorConfig r101 = (ActionBarConnectorConfig) r100;
        if (this.acbConnectorEnable == r101.acbConnectorEnable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.acbAddConnectorSchema, r101.acbAddConnectorSchema) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.acbConnectorLinkSchema, r101.acbConnectorLinkSchema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.acbConnectorEnable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.acbAddConnectorSchema;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.acbConnectorLinkSchema;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ActionBarConnectorConfig(acbConnectorEnable=" + this.acbConnectorEnable + ", acbAddConnectorSchema=" + this.acbAddConnectorSchema + ", acbConnectorLinkSchema=" + this.acbConnectorLinkSchema + ')';
    }

    public final String getAcbAddConnectorSchema() {
        return this.acbAddConnectorSchema;
    }

    public final boolean getAcbConnectorEnable() {
        return this.acbConnectorEnable;
    }

    public final String getAcbConnectorLinkSchema() {
        return this.acbConnectorLinkSchema;
    }

    public ActionBarConnectorConfig(boolean r100, String r101, String r102) {
        this.acbConnectorEnable = r100;
        this.acbAddConnectorSchema = r101;
        this.acbConnectorLinkSchema = r102;
    }

    public /* synthetic */ ActionBarConnectorConfig(boolean r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
