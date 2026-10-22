package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001c\u0010$\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTabData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "showTab", "", "getShowTab", "()Z", "setShowTab", "(Z)V", "tabList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewTabItemData;", "Lkotlin/collections/ArrayList;", "getTabList", "()Ljava/util/ArrayList;", "setTabList", "(Ljava/util/ArrayList;)V", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "paddingDividerHorizontal", "getPaddingDividerHorizontal", "setPaddingDividerHorizontal", "selectColor", "getSelectColor", "setSelectColor", "equals", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordTabData implements NonProguard {
    private String color;
    private int currentIndex;
    private int paddingDividerHorizontal;
    private int paddingHorizontal;
    private String selectColor;
    private boolean showTab;
    private ArrayList<ItemViewTabItemData> tabList;

    public int hashCode() {
        return (this.currentIndex * 31) + this.tabList.hashCode();
    }

    public ItemViewRecordTabData() {
        this.showTab = true;
        this.tabList = new ArrayList();
        this.paddingHorizontal = 8;
    }

    public final String getColor() {
        return this.color;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final int getPaddingDividerHorizontal() {
        return this.paddingDividerHorizontal;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final String getSelectColor() {
        return this.selectColor;
    }

    public final boolean getShowTab() {
        return this.showTab;
    }

    public final ArrayList<ItemViewTabItemData> getTabList() {
        return this.tabList;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ItemViewRecordTabData.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordTabData");
        ItemViewRecordTabData r102 = (ItemViewRecordTabData) r100;
        if (this.currentIndex == r102.currentIndex) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.tabList, r102.tabList) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.color, r102.color) == true) goto L21;
        return false;
    L21:
        int r103 = this.paddingDividerHorizontal;
        int r104 = r102.paddingHorizontal;
        if (r103 == r104) goto L25;
        return false;
    L25:
        if (this.paddingHorizontal == r104) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setCurrentIndex(int r100) {
        this.currentIndex = r100;
    }

    public final void setPaddingDividerHorizontal(int r100) {
        this.paddingDividerHorizontal = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setSelectColor(String r100) {
        this.selectColor = r100;
    }

    public final void setShowTab(boolean r100) {
        this.showTab = r100;
    }

    public final void setTabList(ArrayList<ItemViewTabItemData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabList = r100;
    }
}
