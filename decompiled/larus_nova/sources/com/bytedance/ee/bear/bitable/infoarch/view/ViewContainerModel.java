package com.bytedance.ee.bear.bitable.infoarch.view;

import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/view/ViewContainerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "currentViewId", "", "getCurrentViewId", "()Ljava/lang/String;", "setCurrentViewId", "(Ljava/lang/String;)V", "viewList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "Lkotlin/collections/ArrayList;", "getViewList", "()Ljava/util/ArrayList;", "setViewList", "(Ljava/util/ArrayList;)V", "moreAction", "getMoreAction", "setMoreAction", "hideMoreBtn", "", "getHideMoreBtn", "()Z", "setHideMoreBtn", "(Z)V", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewContainerModel implements NonProguard {
    private String currentViewId;
    private boolean hideMoreBtn;
    private String moreAction;
    private ArrayList<SimpleItemModel> viewList;

    public ViewContainerModel() {
    }

    public String toString() {
        return "ViewData(currentViewId=" + this.currentViewId + ", viewList=" + this.viewList + ", moreAction=" + this.moreAction + ", hideMoreBtn=" + this.hideMoreBtn + ')';
    }

    public final String getCurrentViewId() {
        return this.currentViewId;
    }

    public final boolean getHideMoreBtn() {
        return this.hideMoreBtn;
    }

    public final String getMoreAction() {
        return this.moreAction;
    }

    public final ArrayList<SimpleItemModel> getViewList() {
        return this.viewList;
    }

    public final void setCurrentViewId(String r100) {
        this.currentViewId = r100;
    }

    public final void setHideMoreBtn(boolean r100) {
        this.hideMoreBtn = r100;
    }

    public final void setMoreAction(String r100) {
        this.moreAction = r100;
    }

    public final void setViewList(ArrayList<SimpleItemModel> r100) {
        this.viewList = r100;
    }
}
