package com.bytedance.locallife.poi.newdetail.widget.contentplayer;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/a;", "", "", "itemType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "lynxUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/ss/android/ugc/aweme/poi/model/PoiPhoto;", "photos", "Ljava/util/List;", "d", "()Ljava/util/List;", "subTabPageSymbol", "e", "anchorTabId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("anchor_tab_id")
    private final String anchorTabId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Integer itemType;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("photos")
    private final List<PoiPhoto> photos;

    @SerializedName("sub_tab_page_symbol")
    private final String subTabPageSymbol;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTabPageSymbol, r101.subTabPageSymbol) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.anchorTabId, r101.anchorTabId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<PoiPhoto> r107 = this.photos;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subTabPageSymbol;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.anchorTabId;
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

    public final String toString() {
        return "ContentItem(itemType=" + this.itemType + ", lynxUrl=" + this.lynxUrl + ", photos=" + this.photos + ", subTabPageSymbol=" + this.subTabPageSymbol + ", anchorTabId=" + this.anchorTabId + ')';
    }

    public final String a() {
        return this.anchorTabId;
    }

    public final Integer b() {
        return this.itemType;
    }

    public final String c() {
        return this.lynxUrl;
    }

    public final List<PoiPhoto> d() {
        return this.photos;
    }

    public final String e() {
        return this.subTabPageSymbol;
    }
}
