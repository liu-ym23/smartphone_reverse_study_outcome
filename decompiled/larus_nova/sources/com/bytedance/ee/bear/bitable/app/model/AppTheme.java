package com.bytedance.ee.bear.bitable.app.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/model/AppTheme;", "Lcom/bytedance/ee/util/io/NonProguard;", "themeSystemTypeRaw", "", "navigationBgColor", "appIconBgColor", "navigationTitleColor", "navigationItemTextColor", "navigationItemIconColor", "navigationItemFillFocusColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThemeSystemTypeRaw", "()Ljava/lang/String;", "getNavigationBgColor", "getAppIconBgColor", "getNavigationTitleColor", "getNavigationItemTextColor", "getNavigationItemIconColor", "getNavigationItemFillFocusColor", "themeSystemType", "Lcom/bytedance/ee/bear/bitable/app/model/ThemeSystemType;", "getThemeSystemType", "()Lcom/bytedance/ee/bear/bitable/app/model/ThemeSystemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppTheme implements NonProguard {
    private final String appIconBgColor;
    private final String navigationBgColor;
    private final String navigationItemFillFocusColor;
    private final String navigationItemIconColor;
    private final String navigationItemTextColor;
    private final String navigationTitleColor;
    private final String themeSystemTypeRaw;

    public AppTheme() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AppTheme copy$default(AppTheme r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.themeSystemTypeRaw;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.navigationBgColor;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.appIconBgColor;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.navigationTitleColor;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.navigationItemTextColor;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.navigationItemIconColor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.navigationItemFillFocusColor;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.themeSystemTypeRaw;
    }

    public final String component2() {
        return this.navigationBgColor;
    }

    public final String component3() {
        return this.appIconBgColor;
    }

    public final String component4() {
        return this.navigationTitleColor;
    }

    public final String component5() {
        return this.navigationItemTextColor;
    }

    public final String component6() {
        return this.navigationItemIconColor;
    }

    public final String component7() {
        return this.navigationItemFillFocusColor;
    }

    public final AppTheme copy(@JSONField(name = "themeSystemType") String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r111, "navigationBgColor");
        Intrinsics.checkNotNullParameter(r112, "appIconBgColor");
        Intrinsics.checkNotNullParameter(r113, "navigationTitleColor");
        Intrinsics.checkNotNullParameter(r114, "navigationItemTextColor");
        Intrinsics.checkNotNullParameter(r115, "navigationItemIconColor");
        Intrinsics.checkNotNullParameter(r116, "navigationItemFillFocusColor");
        return new AppTheme(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppTheme) == true) goto L8;
        return false;
    L8:
        AppTheme r101 = (AppTheme) r100;
        if (Intrinsics.areEqual(this.themeSystemTypeRaw, r101.themeSystemTypeRaw) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.navigationBgColor, r101.navigationBgColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appIconBgColor, r101.appIconBgColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.navigationTitleColor, r101.navigationTitleColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.navigationItemTextColor, r101.navigationItemTextColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.navigationItemIconColor, r101.navigationItemIconColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.navigationItemFillFocusColor, r101.navigationItemFillFocusColor) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.themeSystemTypeRaw;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((((r101 * 31) + this.navigationBgColor.hashCode()) * 31) + this.appIconBgColor.hashCode()) * 31) + this.navigationTitleColor.hashCode()) * 31) + this.navigationItemTextColor.hashCode()) * 31) + this.navigationItemIconColor.hashCode()) * 31) + this.navigationItemFillFocusColor.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "AppTheme(themeSystemTypeRaw=" + this.themeSystemTypeRaw + ", navigationBgColor=" + this.navigationBgColor + ", appIconBgColor=" + this.appIconBgColor + ", navigationTitleColor=" + this.navigationTitleColor + ", navigationItemTextColor=" + this.navigationItemTextColor + ", navigationItemIconColor=" + this.navigationItemIconColor + ", navigationItemFillFocusColor=" + this.navigationItemFillFocusColor + ')';
    }

    public final ThemeSystemType getThemeSystemType() {
        ThemeSystemType.a r100 = ThemeSystemType.Companion;
        String r101 = this.themeSystemTypeRaw;
        if (r101 != null) goto L5;
        r101 = "Default";
    L5:
        r100.getClass();
        int r102 = 0;
        if (StringsKt.isBlank(r101) == false) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L24;
        ThemeSystemType[] r104 = ThemeSystemType.values();
        int r105 = r104.length;
    L12:
        if (r102 >= r105) goto L17;
        ThemeSystemType r106 = r104[r102];
        if (StringsKt.equals(r106.getRawValue(), r101, true) == true) goto L18;
        r102 = r102 + 1;
    L18:
        if (r106 != null) goto L21;
        return ThemeSystemType.Default;
    L21:
        return r106;
    L17:
        r106 = null;
        goto L18
    L24:
        return ThemeSystemType.Default;
    L8:
        r103 = false;
        goto L9
    }

    public final String getAppIconBgColor() {
        return this.appIconBgColor;
    }

    public final String getNavigationBgColor() {
        return this.navigationBgColor;
    }

    public final String getNavigationItemFillFocusColor() {
        return this.navigationItemFillFocusColor;
    }

    public final String getNavigationItemIconColor() {
        return this.navigationItemIconColor;
    }

    public final String getNavigationItemTextColor() {
        return this.navigationItemTextColor;
    }

    public final String getNavigationTitleColor() {
        return this.navigationTitleColor;
    }

    public final String getThemeSystemTypeRaw() {
        return this.themeSystemTypeRaw;
    }

    public AppTheme(@JSONField(name = "themeSystemType") String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "navigationBgColor");
        Intrinsics.checkNotNullParameter(r102, "appIconBgColor");
        Intrinsics.checkNotNullParameter(r103, "navigationTitleColor");
        Intrinsics.checkNotNullParameter(r104, "navigationItemTextColor");
        Intrinsics.checkNotNullParameter(r105, "navigationItemIconColor");
        Intrinsics.checkNotNullParameter(r106, "navigationItemFillFocusColor");
        this.themeSystemTypeRaw = r100;
        this.navigationBgColor = r101;
        this.appIconBgColor = r102;
        this.navigationTitleColor = r103;
        this.navigationItemTextColor = r104;
        this.navigationItemIconColor = r105;
        this.navigationItemFillFocusColor = r106;
    }

    public /* synthetic */ AppTheme(String r100, String r101, String r102, String r103, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = null;
    L5:
        int r115 = r113 & 2;
        String r104 = CustomHeaderConfig.COLOR_DARK;
        if (r115 == 0) goto L8;
        String r116 = CustomHeaderConfig.COLOR_DARK;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r105 = CustomHeaderConfig.COLOR_DARK;
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r106 = CustomHeaderConfig.COLOR_DARK;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r107 = CustomHeaderConfig.COLOR_DARK;
    L22:
        if ((r113 & 32) == 0) goto L24;
        String r108 = CustomHeaderConfig.COLOR_DARK;
    L26:
        if ((r113 & 64) != 0) goto L29;
        r104 = r112;
    L29:
        this(r100, r116, r105, r106, r107, r108, r104);
        return;
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r116 = r101;
        goto L10
    }
}
