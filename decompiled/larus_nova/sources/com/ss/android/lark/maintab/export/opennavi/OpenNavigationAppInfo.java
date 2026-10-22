package com.ss.android.lark.maintab.export.opennavi;

import com.ss.android.lark.maintab.export.TabAppType;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/maintab/export/opennavi/OpenNavigationAppInfo;", "", "appType", "Lcom/ss/android/lark/maintab/export/TabAppType;", "uniqueId", "", "key", "i18nName", "", "<init>", "(Lcom/ss/android/lark/maintab/export/TabAppType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAppType", "()Lcom/ss/android/lark/maintab/export/TabAppType;", "getUniqueId", "()Ljava/lang/String;", "getKey", "getI18nName", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenNavigationAppInfo {
    private final TabAppType appType;
    private final Map<String, String> i18nName;
    private final String key;
    private final String uniqueId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenNavigationAppInfo copy$default(OpenNavigationAppInfo r100, TabAppType r101, String r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.appType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uniqueId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.key;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.i18nName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final TabAppType component1() {
        return this.appType;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final String component3() {
        return this.key;
    }

    public final Map<String, String> component4() {
        return this.i18nName;
    }

    public final OpenNavigationAppInfo copy(TabAppType r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "appType");
        Intrinsics.checkNotNullParameter(r103, "i18nName");
        return new OpenNavigationAppInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenNavigationAppInfo) == true) goto L8;
        return false;
    L8:
        OpenNavigationAppInfo r101 = (OpenNavigationAppInfo) r100;
        if (this.appType == r101.appType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nName, r101.i18nName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.appType.hashCode() * 31;
        String r101 = this.uniqueId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.key;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.i18nName.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenNavigationAppInfo(appType=" + this.appType + ", uniqueId=" + this.uniqueId + ", key=" + this.key + ", i18nName=" + this.i18nName + ')';
    }

    public final TabAppType getAppType() {
        return this.appType;
    }

    public final Map<String, String> getI18nName() {
        return this.i18nName;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public OpenNavigationAppInfo(TabAppType r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "appType");
        Intrinsics.checkNotNullParameter(r103, "i18nName");
        this.appType = r100;
        this.uniqueId = r101;
        this.key = r102;
        this.i18nName = r103;
    }

    public /* synthetic */ OpenNavigationAppInfo(TabAppType r100, String r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = new HashMap();
    L5:
        this(r100, r101, r102, r103);
    }
}
