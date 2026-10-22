package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.g1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "", "type", "", "text", "", "icon", "Lcom/larus/bmhome/actionbar/model/Icon;", "darkModeIcon", "tagExpireTime", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Ljava/lang/Long;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Ljava/lang/String;", "getIcon", "()Lcom/larus/bmhome/actionbar/model/Icon;", "getDarkModeIcon", "getTagExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Ljava/lang/Long;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyMenuItemTag {

    @SerializedName("dark_mode_icon")
    private final g1 darkModeIcon;

    @SerializedName("icon")
    private final g1 icon;

    @SerializedName("tag_expire_time")
    private final Long tagExpireTime;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final Integer type;

    public DefaultReplyMenuItemTag() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DefaultReplyMenuItemTag copy$default(DefaultReplyMenuItemTag r100, Integer r101, String r102, g1 r103, g1 r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.text;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        g1 r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.darkModeIcon;
    L14:
        g1 r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tagExpireTime;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final g1 component3() {
        return this.icon;
    }

    public final g1 component4() {
        return this.darkModeIcon;
    }

    public final Long component5() {
        return this.tagExpireTime;
    }

    public final DefaultReplyMenuItemTag copy(Integer r100, String r101, g1 r110, g1 r111, Long r112) {
        return new DefaultReplyMenuItemTag(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyMenuItemTag) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuItemTag r101 = (DefaultReplyMenuItemTag) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tagExpireTime, r101.tagExpireTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g1 r107 = this.icon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.darkModeIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.tagExpireTime;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "DefaultReplyMenuItemTag(type=" + this.type + ", text=" + this.text + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", tagExpireTime=" + this.tagExpireTime + ')';
    }

    public final g1 getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final g1 getIcon() {
        return this.icon;
    }

    public final Long getTagExpireTime() {
        return this.tagExpireTime;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getType() {
        return this.type;
    }

    public DefaultReplyMenuItemTag(Integer r100, String r101, g1 r102, g1 r103, Long r104) {
        this.type = r100;
        this.text = r101;
        this.icon = r102;
        this.darkModeIcon = r103;
        this.tagExpireTime = r104;
    }

    public /* synthetic */ DefaultReplyMenuItemTag(Integer r100, String r101, g1 r102, g1 r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        g1 r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        g1 r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Long r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
