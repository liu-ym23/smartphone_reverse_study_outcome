package com.bytedance.ee.bear.bitable.panel;

import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemModel;
import com.bytedance.ee.bear.bitable.uikit.search.SearchBarModel;
import com.bytedance.ee.bear.bitable.uikit.tree.TreeListData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u001a\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitableViewTreePanelModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "canSort", "", "getCanSort", "()Ljava/lang/Boolean;", "setCanSort", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "searchBar", "Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "getSearchBar", "()Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "setSearchBar", "(Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;)V", "searchAction", "getSearchAction", "setSearchAction", "treeList", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "getTreeList", "()Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "setTreeList", "(Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;)V", "confirmAction", "getConfirmAction", "setConfirmAction", "confirmButtonEnable", "getConfirmButtonEnable", "()Z", "setConfirmButtonEnable", "(Z)V", "rightText", "getRightText", "setRightText", "callback", "getCallback", "setCallback", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableViewTreePanelModel implements NonProguard {
    private String callback;
    private Boolean canSort;
    private String confirmAction;
    private boolean confirmButtonEnable;
    private String name;
    private String rightText;
    private String searchAction;
    private SearchBarModel searchBar;
    private TreeListData<CatalogItemModel> treeList;

    public BitableViewTreePanelModel() {
        this.canSort = Boolean.FALSE;
        this.callback = "";
    }

    public final String getCallback() {
        return this.callback;
    }

    public final Boolean getCanSort() {
        return this.canSort;
    }

    public final String getConfirmAction() {
        return this.confirmAction;
    }

    public final boolean getConfirmButtonEnable() {
        return this.confirmButtonEnable;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final String getSearchAction() {
        return this.searchAction;
    }

    public final SearchBarModel getSearchBar() {
        return this.searchBar;
    }

    public final TreeListData<CatalogItemModel> getTreeList() {
        return this.treeList;
    }

    public final void setCallback(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.callback = r100;
    }

    public final void setCanSort(Boolean r100) {
        this.canSort = r100;
    }

    public final void setConfirmAction(String r100) {
        this.confirmAction = r100;
    }

    public final void setConfirmButtonEnable(boolean r100) {
        this.confirmButtonEnable = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setRightText(String r100) {
        this.rightText = r100;
    }

    public final void setSearchAction(String r100) {
        this.searchAction = r100;
    }

    public final void setSearchBar(SearchBarModel r100) {
        this.searchBar = r100;
    }

    public final void setTreeList(TreeListData<CatalogItemModel> r100) {
        this.treeList = r100;
    }
}
