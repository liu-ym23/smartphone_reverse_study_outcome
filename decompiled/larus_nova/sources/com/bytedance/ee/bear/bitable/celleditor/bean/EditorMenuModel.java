package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.platform.api.creation.TplType;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMenuModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "style", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMenuStyle;", "getStyle", "()Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMenuStyle;", "setStyle", "(Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorMenuStyle;)V", TplType.MENU, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "Lkotlin/collections/ArrayList;", "getMenu", "()Ljava/util/ArrayList;", "setMenu", "(Ljava/util/ArrayList;)V", "isClose", "", "()Ljava/lang/Boolean;", "setClose", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isBottomSheet", "isMenu", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditorMenuModel implements NonProguard {
    private Boolean isClose;
    private ArrayList<SimpleItemModel> menu;
    private EditorMenuStyle style;

    public EditorMenuModel() {
    }

    public final boolean isBottomSheet() {
        EditorMenuStyle r100 = this.style;
        if (r100 == null) goto L11;
        Integer r101 = r100.getType();
        int r102 = EditorMenuType.BottomSheet.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != r102) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final boolean isMenu() {
        EditorMenuStyle r100 = this.style;
        if (r100 == null) goto L11;
        Integer r101 = r100.getType();
        int r102 = EditorMenuType.Menu.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != r102) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final ArrayList<SimpleItemModel> getMenu() {
        return this.menu;
    }

    public final EditorMenuStyle getStyle() {
        return this.style;
    }

    public final Boolean isClose() {
        return this.isClose;
    }

    public final void setClose(Boolean r100) {
        this.isClose = r100;
    }

    public final void setMenu(ArrayList<SimpleItemModel> r100) {
        this.menu = r100;
    }

    public final void setStyle(EditorMenuStyle r100) {
        this.style = r100;
    }
}
