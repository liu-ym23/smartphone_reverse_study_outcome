package com.bytedance.ee.bear.bitable.panel;

import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitableViewPanelModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "bottomAction", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getBottomAction", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setBottomAction", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "canSort", "", "getCanSort", "()Ljava/lang/Boolean;", "setCanSort", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableViewPanelModel implements NonProguard {
    private SimpleItemModel bottomAction;
    private Boolean canSort;
    private ArrayList<CatalogItemModel> items;
    private String name;

    public BitableViewPanelModel() {
        this.canSort = Boolean.FALSE;
    }

    public final SimpleItemModel getBottomAction() {
        return this.bottomAction;
    }

    public final Boolean getCanSort() {
        return this.canSort;
    }

    public final ArrayList<CatalogItemModel> getItems() {
        return this.items;
    }

    public final String getName() {
        return this.name;
    }

    public final void setBottomAction(SimpleItemModel r100) {
        this.bottomAction = r100;
    }

    public final void setCanSort(Boolean r100) {
        this.canSort = r100;
    }

    public final void setItems(ArrayList<CatalogItemModel> r100) {
        this.items = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }
}
