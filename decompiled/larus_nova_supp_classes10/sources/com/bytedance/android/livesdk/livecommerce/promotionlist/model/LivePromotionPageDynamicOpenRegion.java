package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import ll.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageDynamicOpenRegion;", "Ljava/io/Serializable;", "Lll/a;", "listOpenTop", "Lll/a;", "getListOpenTop", "()Lll/a;", "setListOpenTop", "(Lll/a;)V", "listOpenTab", "getListOpenTab", "setListOpenTab", "listOpenTabContent", "getListOpenTabContent", "setListOpenTabContent", "listOpenCover", "getListOpenCover", "setListOpenCover", "listOpenFloatBottom", "getListOpenFloatBottom", "setListOpenFloatBottom", "listOpenSidebar", "getListOpenSidebar", "setListOpenSidebar", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionPageDynamicOpenRegion implements Serializable {

    @SerializedName("list_open_cover")
    private a listOpenCover;

    @SerializedName("list_open_float_bottom")
    private a listOpenFloatBottom;

    @SerializedName("list_open_sidebar")
    private a listOpenSidebar;

    @SerializedName("list_open_tab")
    private a listOpenTab;

    @SerializedName("list_open_tab_content")
    private a listOpenTabContent;

    @SerializedName("list_open_top")
    private a listOpenTop;

    public LivePromotionPageDynamicOpenRegion() {
    }

    public final a getListOpenCover() {
        return this.listOpenCover;
    }

    public final a getListOpenFloatBottom() {
        return this.listOpenFloatBottom;
    }

    public final a getListOpenSidebar() {
        return this.listOpenSidebar;
    }

    public final a getListOpenTab() {
        return this.listOpenTab;
    }

    public final a getListOpenTabContent() {
        return this.listOpenTabContent;
    }

    public final a getListOpenTop() {
        return this.listOpenTop;
    }

    public final void setListOpenCover(a r1) {
        this.listOpenCover = r1;
    }

    public final void setListOpenFloatBottom(a r1) {
        this.listOpenFloatBottom = r1;
    }

    public final void setListOpenSidebar(a r1) {
        this.listOpenSidebar = r1;
    }

    public final void setListOpenTab(a r1) {
        this.listOpenTab = r1;
    }

    public final void setListOpenTabContent(a r1) {
        this.listOpenTabContent = r1;
    }

    public final void setListOpenTop(a r1) {
        this.listOpenTop = r1;
    }
}
