package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/CardTabInfo;", "Ljava/io/Serializable;", "tabId", "", "tabName", "", "cardList", "", "tabExtraText", "Lcom/bytedance/locallife/live/goodsshelves/bean/TabExtraText;", "tabNameEn", "(ILjava/lang/String;Ljava/util/List;Lcom/bytedance/locallife/live/goodsshelves/bean/TabExtraText;Ljava/lang/String;)V", "getCardList", "()Ljava/util/List;", "getTabExtraText", "()Lcom/bytedance/locallife/live/goodsshelves/bean/TabExtraText;", "getTabId", "()I", "getTabName", "()Ljava/lang/String;", "getTabNameEn", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CardTabInfo implements Serializable {

    @SerializedName("card_list")
    private final List<String> cardList;

    @SerializedName("tab_extra_map")
    private final TabExtraText tabExtraText;

    @SerializedName("tab_id")
    private final int tabId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("tab_name_en")
    private final String tabNameEn;

    public CardTabInfo() {
        this(0, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardTabInfo copy$default(CardTabInfo r100, int r101, String r102, List r103, TabExtraText r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tabId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.tabName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cardList;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.tabExtraText;
    L14:
        TabExtraText r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tabNameEn;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.tabId;
    }

    public final String component2() {
        return this.tabName;
    }

    public final List<String> component3() {
        return this.cardList;
    }

    public final TabExtraText component4() {
        return this.tabExtraText;
    }

    public final String component5() {
        return this.tabNameEn;
    }

    public final CardTabInfo copy(int r100, String r101, List<String> r110, TabExtraText r111, String r112) {
        return new CardTabInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardTabInfo) == true) goto L8;
        return false;
    L8:
        CardTabInfo r101 = (CardTabInfo) r100;
        if (this.tabId == r101.tabId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardList, r101.cardList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabExtraText, r101.tabExtraText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabNameEn, r101.tabNameEn) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.tabId * 31;
        String r101 = this.tabName;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.cardList;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        TabExtraText r108 = this.tabExtraText;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.tabNameEn;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CardTabInfo(tabId=" + this.tabId + ", tabName=" + this.tabName + ", cardList=" + this.cardList + ", tabExtraText=" + this.tabExtraText + ", tabNameEn=" + this.tabNameEn + ')';
    }

    public final List<String> getCardList() {
        return this.cardList;
    }

    public final TabExtraText getTabExtraText() {
        return this.tabExtraText;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameEn() {
        return this.tabNameEn;
    }

    public CardTabInfo(int r100, String r101, List<String> r102, TabExtraText r103, String r104) {
        this.tabId = r100;
        this.tabName = r101;
        this.cardList = r102;
        this.tabExtraText = r103;
        this.tabNameEn = r104;
    }

    public /* synthetic */ CardTabInfo(int r100, String r101, List r102, TabExtraText r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 1;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        List r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        TabExtraText r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
