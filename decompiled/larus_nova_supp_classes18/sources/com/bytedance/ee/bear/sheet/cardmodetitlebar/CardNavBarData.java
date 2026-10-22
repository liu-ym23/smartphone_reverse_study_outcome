package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "bgColor", "getBgColor", "setBgColor", "items", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarItem;", "getItems", "()Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarItem;", "setItems", "(Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarItem;)V", "toString", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardNavBarData implements NonProguard {
    private String bgColor;
    private CardNavBarItem items;
    private String title;

    public CardNavBarData() {
    }

    public String toString() {
        return "CardNavBarData(title=" + this.title + ", bgColor=" + this.bgColor + ", items=" + this.items + ')';
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final CardNavBarItem getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBgColor(String r1) {
        this.bgColor = r1;
    }

    public final void setItems(CardNavBarItem r1) {
        this.items = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }
}
