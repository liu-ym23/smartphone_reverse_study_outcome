package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuItemSrc;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "itemId", "", "udIconKey", "imageBase64", "badgeStyle", "badgeText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBadgeStyle", "()Ljava/lang/String;", "getBadgeText", "getImageBase64", "getItemId", "getUdIconKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getBadgeNum", "", "hashCode", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuItemSrc implements NonProguard {
    private final String badgeStyle;
    private final String badgeText;
    private final String imageBase64;
    private final String itemId;
    private final String udIconKey;

    public static /* synthetic */ MenuItemSrc copy$default(MenuItemSrc r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.itemId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.udIconKey;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.imageBase64;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.badgeStyle;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.badgeText;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.udIconKey;
    }

    public final String component3() {
        return this.imageBase64;
    }

    public final String component4() {
        return this.badgeStyle;
    }

    public final String component5() {
        return this.badgeText;
    }

    public final MenuItemSrc copy(String r100, String r101, String r110, String r111, String r112) {
        return new MenuItemSrc(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MenuItemSrc) == true) goto L8;
        return false;
    L8:
        MenuItemSrc r101 = (MenuItemSrc) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.udIconKey, r101.udIconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageBase64, r101.imageBase64) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.badgeStyle, r101.badgeStyle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.badgeText, r101.badgeText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getBadgeNum() {
        String r100 = this.badgeStyle;     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r100, WebappBadgeStyle.NUM.getValue()) == false) goto L9;
        String r101 = this.badgeText;     // Catch: Throwable -> L21
        if (r101 != null) goto L24;
        return -1;
    L24:
        return CastIntegerProtector.parseInt(r101);
    L9:
        if (Intrinsics.areEqual(r100, WebappBadgeStyle.DOT.getValue()) == false) goto L25;
        String r102 = this.badgeText;     // Catch: Throwable -> L21
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L20;
        return 1;
    L20:
        return CastIntegerProtector.parseInt(this.badgeText);
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L25:
        return -1;
    L27:
        return -1;
    }

    public int hashCode() {
        String r100 = this.itemId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.udIconKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.imageBase64;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.badgeStyle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.badgeText;
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
        return "MenuItemSrc(itemId=" + this.itemId + ", udIconKey=" + this.udIconKey + ", imageBase64=" + this.imageBase64 + ", badgeStyle=" + this.badgeStyle + ", badgeText=" + this.badgeText + ')';
    }

    public final String getBadgeStyle() {
        return this.badgeStyle;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getUdIconKey() {
        return this.udIconKey;
    }

    public MenuItemSrc(String r100, String r101, String r102, String r103, String r104) {
        this.itemId = r100;
        this.udIconKey = r101;
        this.imageBase64 = r102;
        this.badgeStyle = r103;
        this.badgeText = r104;
    }

    public /* synthetic */ MenuItemSrc(String r100, String r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        String r104 = null;
    L14:
        this(r100, r101, r102, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
