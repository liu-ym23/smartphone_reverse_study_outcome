package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR&\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\t¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "fixedTitleColor", "", "getFixedTitleColor", "()Z", "setFixedTitleColor", "(Z)V", "shareButtonIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getShareButtonIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setShareButtonIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "shareTitle", "getShareTitle", "setShareTitle", "showSubscribeButton", "getShowSubscribeButton", "setShowSubscribeButton", "showAddToMainNav", "getShowAddToMainNav", "setShowAddToMainNav", "moreMenuData", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewMoreMenuData;", "getMoreMenuData", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewMoreMenuData;", "setMoreMenuData", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewMoreMenuData;)V", "showCover", "getShowCover", "setShowCover", "recordId", "getRecordId$annotations", "getRecordId", "setRecordId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordTitleBarData implements NonProguard {
    private boolean fixedTitleColor;
    private ItemViewMoreMenuData moreMenuData;
    private String recordId;
    private Icon shareButtonIcon;
    private String shareTitle;
    private boolean showAddToMainNav;
    private boolean showCover;
    private boolean showSubscribeButton;
    private String title;

    @ContextField
    public static /* synthetic */ void getRecordId$annotations() {
    }

    public ItemViewRecordTitleBarData() {
        this.title = "";
        this.shareTitle = "";
    }

    public final boolean getFixedTitleColor() {
        return this.fixedTitleColor;
    }

    public final ItemViewMoreMenuData getMoreMenuData() {
        return this.moreMenuData;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final Icon getShareButtonIcon() {
        return this.shareButtonIcon;
    }

    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final boolean getShowAddToMainNav() {
        return this.showAddToMainNav;
    }

    public final boolean getShowCover() {
        return this.showCover;
    }

    public final boolean getShowSubscribeButton() {
        return this.showSubscribeButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setFixedTitleColor(boolean r100) {
        this.fixedTitleColor = r100;
    }

    public final void setMoreMenuData(ItemViewMoreMenuData r100) {
        this.moreMenuData = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setShareButtonIcon(Icon r100) {
        this.shareButtonIcon = r100;
    }

    public final void setShareTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareTitle = r100;
    }

    public final void setShowAddToMainNav(boolean r100) {
        this.showAddToMainNav = r100;
    }

    public final void setShowCover(boolean r100) {
        this.showCover = r100;
    }

    public final void setShowSubscribeButton(boolean r100) {
        this.showSubscribeButton = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }
}
