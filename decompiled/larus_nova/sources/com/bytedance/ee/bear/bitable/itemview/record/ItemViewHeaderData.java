package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewHeaderData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "titleStyle", "Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "getTitleStyle", "()Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "setTitleStyle", "(Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;)V", "catalogData", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCatalogData;", "getCatalogData", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCatalogData;", "setCatalogData", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCatalogData;)V", "coverFieldData", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverData;", "getCoverFieldData", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverData;", "setCoverFieldData", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverData;)V", "paddingHorizontal", "", "getPaddingHorizontal", "()I", "setPaddingHorizontal", "(I)V", "globalIndex", "getGlobalIndex$annotations", "getGlobalIndex", "setGlobalIndex", "recordId", "getRecordId$annotations", "getRecordId", "setRecordId", "showCatalog", "", "showCover", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewHeaderData implements NonProguard {
    private ItemViewRecordCatalogData catalogData;
    private ItemViewRecordCoverData coverFieldData;
    private int globalIndex;
    private int paddingHorizontal;
    private String recordId;
    private String title;
    private IRenderFontStyle titleStyle;

    @ContextField
    public static /* synthetic */ void getGlobalIndex$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getRecordId$annotations() {
    }

    public final boolean showCatalog() {
        if (this.catalogData == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean showCover() {
        if (this.coverFieldData == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ItemViewHeaderData() {
        this.title = "";
        this.paddingHorizontal = 12;
        this.recordId = "";
    }

    public final ItemViewRecordCatalogData getCatalogData() {
        return this.catalogData;
    }

    public final ItemViewRecordCoverData getCoverFieldData() {
        return this.coverFieldData;
    }

    public final int getGlobalIndex() {
        return this.globalIndex;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final IRenderFontStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final void setCatalogData(ItemViewRecordCatalogData r100) {
        this.catalogData = r100;
    }

    public final void setCoverFieldData(ItemViewRecordCoverData r100) {
        this.coverFieldData = r100;
    }

    public final void setGlobalIndex(int r100) {
        this.globalIndex = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setTitleStyle(IRenderFontStyle r100) {
        this.titleStyle = r100;
    }
}
