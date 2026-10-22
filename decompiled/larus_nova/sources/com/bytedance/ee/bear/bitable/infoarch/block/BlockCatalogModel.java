package com.bytedance.ee.bear.bitable.infoarch.block;

import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemModel;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.search.SearchBarModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.bitable.uikit.tree.TreeListData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010;\u001a\u00020\u0019H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001c\u0010,\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001e\u0010/\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001d¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/block/BlockCatalogModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "searchBar", "Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "getSearchBar", "()Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "setSearchBar", "(Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "treeListData", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "getTreeListData", "()Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "setTreeListData", "(Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;)V", "bottomText", "", "getBottomText", "()Ljava/lang/String;", "setBottomText", "(Ljava/lang/String;)V", "bottomMenu", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getBottomMenu", "setBottomMenu", "closePanel", "", "getClosePanel", "()Ljava/lang/Boolean;", "setClosePanel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "sortAction", "getSortAction", "setSortAction", "searchAction", "getSearchAction", "setSearchAction", "canSort", "getCanSort", "setCanSort", "empty", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "getEmpty", "()Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "setEmpty", "(Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;)V", "scrollId", "getScrollId", "setScrollId", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockCatalogModel implements NonProguard {
    private ArrayList<SimpleItemModel> bottomMenu;
    private String bottomText;
    private Boolean canSort;
    private Boolean closePanel;
    private EmptyData empty;
    private ArrayList<CatalogItemModel> items;
    private String scrollId;
    private String searchAction;
    private SearchBarModel searchBar;
    private String sortAction;
    private TreeListData<CatalogItemModel> treeListData;

    public String toString() {
        return "CatalogModel{searchModel='" + this.searchBar + "', items='" + this.items + "', ";
    }

    public BlockCatalogModel() {
        Boolean r100 = Boolean.FALSE;
        this.closePanel = r100;
        this.canSort = r100;
    }

    public final ArrayList<SimpleItemModel> getBottomMenu() {
        return this.bottomMenu;
    }

    public final String getBottomText() {
        return this.bottomText;
    }

    public final Boolean getCanSort() {
        return this.canSort;
    }

    public final Boolean getClosePanel() {
        return this.closePanel;
    }

    public final EmptyData getEmpty() {
        return this.empty;
    }

    public final ArrayList<CatalogItemModel> getItems() {
        return this.items;
    }

    public final String getScrollId() {
        return this.scrollId;
    }

    public final String getSearchAction() {
        return this.searchAction;
    }

    public final SearchBarModel getSearchBar() {
        return this.searchBar;
    }

    public final String getSortAction() {
        return this.sortAction;
    }

    public final TreeListData<CatalogItemModel> getTreeListData() {
        return this.treeListData;
    }

    public final void setBottomMenu(ArrayList<SimpleItemModel> r100) {
        this.bottomMenu = r100;
    }

    public final void setBottomText(String r100) {
        this.bottomText = r100;
    }

    public final void setCanSort(Boolean r100) {
        this.canSort = r100;
    }

    public final void setClosePanel(Boolean r100) {
        this.closePanel = r100;
    }

    public final void setEmpty(EmptyData r100) {
        this.empty = r100;
    }

    public final void setItems(ArrayList<CatalogItemModel> r100) {
        this.items = r100;
    }

    public final void setScrollId(String r100) {
        this.scrollId = r100;
    }

    public final void setSearchAction(String r100) {
        this.searchAction = r100;
    }

    public final void setSearchBar(SearchBarModel r100) {
        this.searchBar = r100;
    }

    public final void setSortAction(String r100) {
        this.sortAction = r100;
    }

    public final void setTreeListData(TreeListData<CatalogItemModel> r100) {
        this.treeListData = r100;
    }
}
