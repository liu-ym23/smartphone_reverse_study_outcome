package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/ContainerHeaderItemData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "titleStyle", "Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "getTitleStyle", "()Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "setTitleStyle", "(Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;)V", "backgroundInfo", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBackGroundInfo;", "getBackgroundInfo", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBackGroundInfo;", "setBackgroundInfo", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/IBackGroundInfo;)V", "showTitle", "", "getShowTitle", "()Ljava/lang/Boolean;", "setShowTitle", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "paddingTop", "", "getPaddingTop", "()I", "setPaddingTop", "(I)V", "level", "getLevel", "setLevel", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerHeaderItemData implements NonProguard {
    private IBackGroundInfo backgroundInfo;
    private int level;
    private int paddingHorizontal;
    private int paddingTop;
    private Boolean showTitle;
    private String title;
    private IRenderFontStyle titleStyle;

    public ContainerHeaderItemData() {
    }

    public final IBackGroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final Boolean getShowTitle() {
        return this.showTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final IRenderFontStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final void setBackgroundInfo(IBackGroundInfo r100) {
        this.backgroundInfo = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setPaddingTop(int r100) {
        this.paddingTop = r100;
    }

    public final void setShowTitle(Boolean r100) {
        this.showTitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTitleStyle(IRenderFontStyle r100) {
        this.titleStyle = r100;
    }
}
