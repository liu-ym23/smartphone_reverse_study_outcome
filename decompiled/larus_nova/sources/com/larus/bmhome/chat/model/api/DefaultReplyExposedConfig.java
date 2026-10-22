package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "", "maxExposedNum", "", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "text", "", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;)V", "getMaxExposedNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;)Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyExposedConfig {

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("max_exposed_num")
    private final Integer maxExposedNum;

    @SerializedName("text")
    private final String text;

    public DefaultReplyExposedConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DefaultReplyExposedConfig copy$default(DefaultReplyExposedConfig r100, Integer r101, DefaultReplyMenuItemIcon r102, DefaultReplyMenuItemIcon r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.maxExposedNum;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.icon;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.darkModeIcon;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.text;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.maxExposedNum;
    }

    public final DefaultReplyMenuItemIcon component2() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component3() {
        return this.darkModeIcon;
    }

    public final String component4() {
        return this.text;
    }

    public final DefaultReplyExposedConfig copy(Integer r100, DefaultReplyMenuItemIcon r101, DefaultReplyMenuItemIcon r102, String r103) {
        return new DefaultReplyExposedConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyExposedConfig) == true) goto L8;
        return false;
    L8:
        DefaultReplyExposedConfig r101 = (DefaultReplyExposedConfig) r100;
        if (Intrinsics.areEqual(this.maxExposedNum, r101.maxExposedNum) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.maxExposedNum;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DefaultReplyMenuItemIcon r104 = this.icon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        DefaultReplyMenuItemIcon r107 = this.darkModeIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.text;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "DefaultReplyExposedConfig(maxExposedNum=" + this.maxExposedNum + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", text=" + this.text + ')';
    }

    public final DefaultReplyMenuItemIcon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final Integer getMaxExposedNum() {
        return this.maxExposedNum;
    }

    public final String getText() {
        return this.text;
    }

    public DefaultReplyExposedConfig(Integer r100, DefaultReplyMenuItemIcon r101, DefaultReplyMenuItemIcon r102, String r103) {
        this.maxExposedNum = r100;
        this.icon = r101;
        this.darkModeIcon = r102;
        this.text = r103;
    }

    public /* synthetic */ DefaultReplyExposedConfig(Integer r100, DefaultReplyMenuItemIcon r101, DefaultReplyMenuItemIcon r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
