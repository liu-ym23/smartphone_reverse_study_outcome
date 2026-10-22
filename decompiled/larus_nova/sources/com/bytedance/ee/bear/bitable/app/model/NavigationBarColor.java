package com.bytedance.ee.bear.bitable.app.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/model/NavigationBarColor;", "Lcom/bytedance/ee/util/io/NonProguard;", "bgColor", "", "themeSystemTypeRaw", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getThemeSystemTypeRaw", "themeSystemType", "Lcom/bytedance/ee/bear/bitable/app/model/ThemeType;", "getThemeSystemType", "()Lcom/bytedance/ee/bear/bitable/app/model/ThemeType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationBarColor implements NonProguard {
    private final String bgColor;
    private final String themeSystemTypeRaw;

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationBarColor() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NavigationBarColor copy$default(NavigationBarColor r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bgColor;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.themeSystemTypeRaw;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.bgColor;
    }

    public final String component2() {
        return this.themeSystemTypeRaw;
    }

    public final NavigationBarColor copy(String r100, @JSONField(name = "themeSystemType") String r101) {
        Intrinsics.checkNotNullParameter(r100, "bgColor");
        return new NavigationBarColor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NavigationBarColor) == true) goto L8;
        return false;
    L8:
        NavigationBarColor r101 = (NavigationBarColor) r100;
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.themeSystemTypeRaw, r101.themeSystemTypeRaw) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.bgColor.hashCode() * 31;
        String r101 = this.themeSystemTypeRaw;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "NavigationBarColor(bgColor=" + this.bgColor + ", themeSystemTypeRaw=" + this.themeSystemTypeRaw + ')';
    }

    public final ThemeType getThemeSystemType() {
        ThemeType.a r100 = ThemeType.Companion;
        String r101 = this.themeSystemTypeRaw;
        if (r101 != null) goto L5;
        r101 = ThemeType.DEFAULT_THEME_SYSTEM_TYPE;
    L5:
        r100.getClass();
        int r102 = 0;
        if (StringsKt.isBlank(r101) == false) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L24;
        ThemeType[] r104 = ThemeType.values();
        int r105 = r104.length;
    L12:
        if (r102 >= r105) goto L17;
        ThemeType r106 = r104[r102];
        if (StringsKt.equals(r106.getRawValue(), r101, true) == true) goto L18;
        r102 = r102 + 1;
    L18:
        if (r106 != null) goto L21;
        return ThemeType.Light;
    L21:
        return r106;
    L17:
        r106 = null;
        goto L18
    L24:
        return ThemeType.Light;
    L8:
        r103 = false;
        goto L9
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getThemeSystemTypeRaw() {
        return this.themeSystemTypeRaw;
    }

    public NavigationBarColor(String r100, @JSONField(name = "themeSystemType") String r101) {
        Intrinsics.checkNotNullParameter(r100, "bgColor");
        this.bgColor = r100;
        this.themeSystemTypeRaw = r101;
    }

    public /* synthetic */ NavigationBarColor(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CustomHeaderConfig.COLOR_DARK;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
