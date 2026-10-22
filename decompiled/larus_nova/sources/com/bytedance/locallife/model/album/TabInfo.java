package com.bytedance.locallife.model.album;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PhotoPageTabStruct;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JT\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/locallife/model/album/TabInfo;", "Ljava/io/Serializable;", "tabName", "", "tabId", "tabCount", "contentSchema", "tabType", "", "hasMob", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getContentSchema", "()Ljava/lang/String;", "getHasMob", "()Z", "setHasMob", "(Z)V", "getTabCount", "getTabId", "getTabName", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/bytedance/locallife/model/album/TabInfo;", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TabInfo implements Serializable {

    @SerializedName("content_schema")
    private final String contentSchema;
    private boolean hasMob;

    @SerializedName(a.KEY_TOTAL_COUNT)
    private final String tabCount;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("tab_type")
    private final Integer tabType;

    public TabInfo() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ TabInfo copy$default(TabInfo r100, String r101, String r102, String r103, String r104, Integer r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.tabName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tabId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.tabCount;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.contentSchema;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.tabType;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.hasMob;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.tabName;
    }

    public final String component2() {
        return this.tabId;
    }

    public final String component3() {
        return this.tabCount;
    }

    public final String component4() {
        return this.contentSchema;
    }

    public final Integer component5() {
        return this.tabType;
    }

    public final boolean component6() {
        return this.hasMob;
    }

    public final TabInfo copy(String r100, String r110, String r111, String r112, Integer r113, boolean r114) {
        return new TabInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabInfo) == true) goto L8;
        return false;
    L8:
        TabInfo r101 = (TabInfo) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabCount, r101.tabCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentSchema, r101.contentSchema) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L24;
        return false;
    L24:
        if (this.hasMob == r101.hasMob) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tabCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.contentSchema;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.tabType;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.hasMob == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
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
        return "TabInfo(tabName=" + this.tabName + ", tabId=" + this.tabId + ", tabCount=" + this.tabCount + ", contentSchema=" + this.contentSchema + ", tabType=" + this.tabType + ", hasMob=" + this.hasMob + ')';
    }

    public final String getContentSchema() {
        return this.contentSchema;
    }

    public final boolean getHasMob() {
        return this.hasMob;
    }

    public final String getTabCount() {
        return this.tabCount;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final void setHasMob(boolean r100) {
        this.hasMob = r100;
    }

    public TabInfo(String r100, String r101, String r102, String r103, Integer r104, boolean r105) {
        this.tabName = r100;
        this.tabId = r101;
        this.tabCount = r102;
        this.contentSchema = r103;
        this.tabType = r104;
        this.hasMob = r105;
    }

    public /* synthetic */ TabInfo(String r100, String r101, String r102, String r103, Integer r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "全部";
    L5:
        String r105 = "";
        if ((r111 & 2) == 0) goto L8;
        String r113 = "";
    L10:
        if ((r111 & 4) == 0) goto L12;
        String r106 = "";
    L14:
        if ((r111 & 8) != 0) goto L18;
        r105 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r104 = Integer.valueOf(PhotoPageTabStruct.PHOTO.getValue());
    L20:
        Integer r107 = r104;
        if ((r111 & 32) == 0) goto L23;
        boolean r108 = false;
    L24:
        this(r100, r113, r106, r105, r107, r108);
        return;
    L23:
        r108 = r110;
        goto L24
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
