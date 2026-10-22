package com.larus.home.impl.main.tab.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/home/impl/main/tab/config/BottomTabConfig;", "", "tabKey", "", "text", "starlingKey", "normalTabItemConfig", "Lcom/larus/home/impl/main/tab/config/BottomTabItemConfig;", "darkTabItemConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/home/impl/main/tab/config/BottomTabItemConfig;Lcom/larus/home/impl/main/tab/config/BottomTabItemConfig;)V", "getTabKey", "()Ljava/lang/String;", "getText", "getStarlingKey", "getNormalTabItemConfig", "()Lcom/larus/home/impl/main/tab/config/BottomTabItemConfig;", "getDarkTabItemConfig", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTabConfig {

    @SerializedName("dark_model")
    private final BottomTabItemConfig darkTabItemConfig;

    @SerializedName("normal_model")
    private final BottomTabItemConfig normalTabItemConfig;

    @SerializedName("starling_key")
    private final String starlingKey;

    @SerializedName("tab_item_key")
    private final String tabKey;

    @SerializedName("text")
    private final String text;

    public BottomTabConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BottomTabConfig copy$default(BottomTabConfig r100, String r101, String r102, String r103, BottomTabItemConfig r104, BottomTabItemConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tabKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.text;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.starlingKey;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.normalTabItemConfig;
    L14:
        BottomTabItemConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.darkTabItemConfig;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.tabKey;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.starlingKey;
    }

    public final BottomTabItemConfig component4() {
        return this.normalTabItemConfig;
    }

    public final BottomTabItemConfig component5() {
        return this.darkTabItemConfig;
    }

    public final BottomTabConfig copy(String r100, String r101, String r110, BottomTabItemConfig r111, BottomTabItemConfig r112) {
        return new BottomTabConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BottomTabConfig) == true) goto L8;
        return false;
    L8:
        BottomTabConfig r101 = (BottomTabConfig) r100;
        if (Intrinsics.areEqual(this.tabKey, r101.tabKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.starlingKey, r101.starlingKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.normalTabItemConfig, r101.normalTabItemConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkTabItemConfig, r101.darkTabItemConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.tabKey;
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
        String r107 = this.starlingKey;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BottomTabItemConfig r110 = this.normalTabItemConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        BottomTabItemConfig r113 = this.darkTabItemConfig;
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
        return "BottomTabConfig(tabKey=" + this.tabKey + ", text=" + this.text + ", starlingKey=" + this.starlingKey + ", normalTabItemConfig=" + this.normalTabItemConfig + ", darkTabItemConfig=" + this.darkTabItemConfig + ')';
    }

    public final BottomTabItemConfig getDarkTabItemConfig() {
        return this.darkTabItemConfig;
    }

    public final BottomTabItemConfig getNormalTabItemConfig() {
        return this.normalTabItemConfig;
    }

    public final String getStarlingKey() {
        return this.starlingKey;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public final String getText() {
        return this.text;
    }

    public BottomTabConfig(String r100, String r101, String r102, BottomTabItemConfig r103, BottomTabItemConfig r104) {
        this.tabKey = r100;
        this.text = r101;
        this.starlingKey = r102;
        this.normalTabItemConfig = r103;
        this.darkTabItemConfig = r104;
    }

    public /* synthetic */ BottomTabConfig(String r100, String r101, String r102, BottomTabItemConfig r103, BottomTabItemConfig r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        BottomTabItemConfig r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        BottomTabItemConfig r109 = null;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
