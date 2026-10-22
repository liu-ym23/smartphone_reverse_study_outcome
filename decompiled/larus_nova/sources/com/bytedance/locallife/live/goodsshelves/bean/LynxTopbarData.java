package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LynxTopbarData;", "Ljava/io/Serializable;", "cardTabInfos", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/CardTabInfo;", "barType", "", "newShelf", "Lcom/bytedance/locallife/live/goodsshelves/bean/NewTopBarData;", "(Ljava/util/List;ILcom/bytedance/locallife/live/goodsshelves/bean/NewTopBarData;)V", "getBarType", "()I", "getCardTabInfos", "()Ljava/util/List;", "getNewShelf", "()Lcom/bytedance/locallife/live/goodsshelves/bean/NewTopBarData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxTopbarData implements Serializable {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE)
    private final int barType;

    @SerializedName("card_tab_info")
    private final List<CardTabInfo> cardTabInfos;

    @SerializedName("new_shelf")
    private final NewTopBarData newShelf;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxTopbarData copy$default(LynxTopbarData r100, List r101, int r102, NewTopBarData r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.cardTabInfos;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.barType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.newShelf;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<CardTabInfo> component1() {
        return this.cardTabInfos;
    }

    public final int component2() {
        return this.barType;
    }

    public final NewTopBarData component3() {
        return this.newShelf;
    }

    public final LynxTopbarData copy(List<CardTabInfo> r100, int r101, NewTopBarData r102) {
        Intrinsics.checkNotNullParameter(r102, "newShelf");
        return new LynxTopbarData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxTopbarData) == true) goto L8;
        return false;
    L8:
        LynxTopbarData r101 = (LynxTopbarData) r100;
        if (Intrinsics.areEqual(this.cardTabInfos, r101.cardTabInfos) == true) goto L12;
        return false;
    L12:
        if (this.barType == r101.barType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.newShelf, r101.newShelf) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<CardTabInfo> r100 = this.cardTabInfos;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.barType) * 31) + this.newShelf.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "LynxTopbarData(cardTabInfos=" + this.cardTabInfos + ", barType=" + this.barType + ", newShelf=" + this.newShelf + ')';
    }

    public final int getBarType() {
        return this.barType;
    }

    public final List<CardTabInfo> getCardTabInfos() {
        return this.cardTabInfos;
    }

    public final NewTopBarData getNewShelf() {
        return this.newShelf;
    }

    public LynxTopbarData(List<CardTabInfo> r100, int r101, NewTopBarData r102) {
        Intrinsics.checkNotNullParameter(r102, "newShelf");
        this.cardTabInfos = r100;
        this.barType = r101;
        this.newShelf = r102;
    }

    public /* synthetic */ LynxTopbarData(List r100, int r101, NewTopBarData r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101, r102);
    }
}
