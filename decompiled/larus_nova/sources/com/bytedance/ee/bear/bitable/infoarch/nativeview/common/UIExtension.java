package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UIExtension;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "searchBar", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SearchBar;", "getSearchBar", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SearchBar;", "setSearchBar", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SearchBar;)V", "titleBar", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/TitleBar;", "getTitleBar", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/TitleBar;", "setTitleBar", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/TitleBar;)V", "noticeTip", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NoticeTip;", "getNoticeTip", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NoticeTip;", "setNoticeTip", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NoticeTip;)V", "tabList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "Lkotlin/collections/ArrayList;", "getTabList", "()Ljava/util/ArrayList;", "setTabList", "(Ljava/util/ArrayList;)V", "theme", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "getTheme", "()Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "setTheme", "(Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIExtension implements NonProguard {
    private NoticeTip noticeTip;
    private SearchBar searchBar;
    private ArrayList<SimpleItemModel> tabList;
    private ThemeModel theme;
    private TitleBar titleBar;

    public UIExtension() {
    }

    public final NoticeTip getNoticeTip() {
        return this.noticeTip;
    }

    public final SearchBar getSearchBar() {
        return this.searchBar;
    }

    public final ArrayList<SimpleItemModel> getTabList() {
        return this.tabList;
    }

    public final ThemeModel getTheme() {
        return this.theme;
    }

    public final TitleBar getTitleBar() {
        return this.titleBar;
    }

    public final void setNoticeTip(NoticeTip r100) {
        this.noticeTip = r100;
    }

    public final void setSearchBar(SearchBar r100) {
        this.searchBar = r100;
    }

    public final void setTabList(ArrayList<SimpleItemModel> r100) {
        this.tabList = r100;
    }

    public final void setTheme(ThemeModel r100) {
        this.theme = r100;
    }

    public final void setTitleBar(TitleBar r100) {
        this.titleBar = r100;
    }
}
