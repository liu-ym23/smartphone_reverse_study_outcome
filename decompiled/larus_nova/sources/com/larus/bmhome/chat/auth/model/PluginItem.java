package com.larus.bmhome.chat.auth.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Ljava/io/Serializable;", "pluginId", "", "pluginName", "iconUrl", "developer", "authType", "", "pluginDesc", "privacy", "usage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/auth/model/PluginItem;", "equals", "", "other", "", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginItem implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(BdpAppEventConstant.PARAMS_AUTH_TYPE)
    public final Integer authType;

    @SerializedName("developer")
    public final String developer;

    @SerializedName("icon_url")
    public final String iconUrl;

    @SerializedName("plugin_desc")
    public final String pluginDesc;

    @SerializedName("plugin_id")
    public final String pluginId;

    @SerializedName("plugin_name")
    public final String pluginName;

    @SerializedName("privacy")
    public final String privacy;

    @SerializedName("usage")
    public final String usage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PluginItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ PluginItem copy$default(PluginItem r100, String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.pluginId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.pluginName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.iconUrl;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.developer;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.authType;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.pluginDesc;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.privacy;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.usage;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.pluginId;
    }

    public final String component2() {
        return this.pluginName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.developer;
    }

    public final Integer component5() {
        return this.authType;
    }

    public final String component6() {
        return this.pluginDesc;
    }

    public final String component7() {
        return this.privacy;
    }

    public final String component8() {
        return this.usage;
    }

    public final PluginItem copy(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, String r117) {
        return new PluginItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PluginItem) == true) goto L8;
        return false;
    L8:
        PluginItem r101 = (PluginItem) r100;
        if (Intrinsics.areEqual(this.pluginId, r101.pluginId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pluginName, r101.pluginName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.developer, r101.developer) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authType, r101.authType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pluginDesc, r101.pluginDesc) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.privacy, r101.privacy) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.usage, r101.usage) == true) goto L32;
        return false;
    L32:
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
        String r107 = this.iconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.developer;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.authType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.pluginDesc;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.privacy;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.usage;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PluginItem(pluginId=" + this.pluginId + ", pluginName=" + this.pluginName + ", iconUrl=" + this.iconUrl + ", developer=" + this.developer + ", authType=" + this.authType + ", pluginDesc=" + this.pluginDesc + ", privacy=" + this.privacy + ", usage=" + this.usage + ')';
    }

    public PluginItem(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, String r107) {
        this.pluginId = r100;
        this.pluginName = r101;
        this.iconUrl = r102;
        this.developer = r103;
        this.authType = r104;
        this.pluginDesc = r105;
        this.privacy = r106;
        this.usage = r107;
    }

    public /* synthetic */ PluginItem(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
