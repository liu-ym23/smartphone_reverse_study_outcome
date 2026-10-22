package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.bot.BgImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/platform/model/bot/BotMakerDataModel;", "", "nick_name", "", "role", "icon_url", "icon_uri", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImage;)V", "getNick_name", "()Ljava/lang/String;", "setNick_name", "(Ljava/lang/String;)V", "getRole", "setRole", "getIcon_url", "setIcon_url", "getIcon_uri", "setIcon_uri", "getBgImage", "()Lcom/larus/im/bean/bot/BgImage;", "setBgImage", "(Lcom/larus/im/bean/bot/BgImage;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotMakerDataModel {

    @SerializedName("bg_image")
    private BgImage bgImage;

    @SerializedName("icon_uri")
    private String icon_uri;

    @SerializedName("icon_url")
    private String icon_url;

    @SerializedName("name")
    private String nick_name;

    @SerializedName("role")
    private String role;

    public BotMakerDataModel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BotMakerDataModel copy$default(BotMakerDataModel r100, String r101, String r102, String r103, String r104, BgImage r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.nick_name;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.role;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.icon_url;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.icon_uri;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bgImage;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.nick_name;
    }

    public final String component2() {
        return this.role;
    }

    public final String component3() {
        return this.icon_url;
    }

    public final String component4() {
        return this.icon_uri;
    }

    public final BgImage component5() {
        return this.bgImage;
    }

    public final BotMakerDataModel copy(String r100, String r101, String r110, String r111, BgImage r112) {
        return new BotMakerDataModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotMakerDataModel) == true) goto L8;
        return false;
    L8:
        BotMakerDataModel r101 = (BotMakerDataModel) r100;
        if (Intrinsics.areEqual(this.nick_name, r101.nick_name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.role, r101.role) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon_url, r101.icon_url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon_uri, r101.icon_uri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgImage, r101.bgImage) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.nick_name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.role;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.icon_url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.icon_uri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        BgImage r113 = this.bgImage;
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
        return "BotMakerDataModel(nick_name=" + this.nick_name + ", role=" + this.role + ", icon_url=" + this.icon_url + ", icon_uri=" + this.icon_uri + ", bgImage=" + this.bgImage + ')';
    }

    public final BgImage getBgImage() {
        return this.bgImage;
    }

    public final String getIcon_uri() {
        return this.icon_uri;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setBgImage(BgImage r100) {
        this.bgImage = r100;
    }

    public final void setIcon_uri(String r100) {
        this.icon_uri = r100;
    }

    public final void setIcon_url(String r100) {
        this.icon_url = r100;
    }

    public final void setNick_name(String r100) {
        this.nick_name = r100;
    }

    public final void setRole(String r100) {
        this.role = r100;
    }

    public BotMakerDataModel(String r100, String r101, String r102, String r103, BgImage r104) {
        this.nick_name = r100;
        this.role = r101;
        this.icon_url = r102;
        this.icon_uri = r103;
        this.bgImage = r104;
    }

    public /* synthetic */ BotMakerDataModel(String r100, String r101, String r102, String r103, BgImage r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = "";
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = null;
    L21:
        BgImage r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
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
