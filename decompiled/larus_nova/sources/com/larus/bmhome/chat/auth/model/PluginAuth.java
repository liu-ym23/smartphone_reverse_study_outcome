package com.larus.bmhome.chat.auth.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/auth/model/PluginAuth;", "Ljava/io/Serializable;", "pluginId", "", "pluginName", "authType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/auth/model/PluginAuth;", "equals", "", "other", "", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginAuth implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(BdpAppEventConstant.PARAMS_AUTH_TYPE)
    public final Integer authType;

    @SerializedName("plugin_id")
    public final String pluginId;

    @SerializedName("plugin_name")
    public final String pluginName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PluginAuth() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PluginAuth copy$default(PluginAuth r100, String r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.pluginId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.pluginName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.authType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.pluginId;
    }

    public final String component2() {
        return this.pluginName;
    }

    public final Integer component3() {
        return this.authType;
    }

    public final PluginAuth copy(String r100, String r101, Integer r102) {
        return new PluginAuth(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PluginAuth) == true) goto L8;
        return false;
    L8:
        PluginAuth r101 = (PluginAuth) r100;
        if (Intrinsics.areEqual(this.pluginId, r101.pluginId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pluginName, r101.pluginName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.authType, r101.authType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.pluginId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pluginName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.authType;
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

    public String toString() {
        return "PluginAuth(pluginId=" + this.pluginId + ", pluginName=" + this.pluginName + ", authType=" + this.authType + ')';
    }

    public PluginAuth(String r100, String r101, Integer r102) {
        this.pluginId = r100;
        this.pluginName = r101;
        this.authType = r102;
    }

    public /* synthetic */ PluginAuth(String r100, String r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
