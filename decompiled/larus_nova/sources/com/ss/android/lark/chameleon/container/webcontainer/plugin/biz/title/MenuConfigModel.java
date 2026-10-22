package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import com.ss.android.lark.chameleon.api.TitleType;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuConfigModel;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "titleType", "Lcom/ss/android/lark/chameleon/api/TitleType;", "leftItems", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuItemSrc;", "Lkotlin/collections/ArrayList;", "rightItems", "(Lcom/ss/android/lark/chameleon/api/TitleType;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getLeftItems", "()Ljava/util/ArrayList;", "getRightItems", "getTitleType", "()Lcom/ss/android/lark/chameleon/api/TitleType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuConfigModel implements NonProguard {
    private final ArrayList<MenuItemSrc> leftItems;
    private final ArrayList<MenuItemSrc> rightItems;
    private final TitleType titleType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MenuConfigModel copy$default(MenuConfigModel r100, TitleType r101, ArrayList r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.titleType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.leftItems;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.rightItems;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final TitleType component1() {
        return this.titleType;
    }

    public final ArrayList<MenuItemSrc> component2() {
        return this.leftItems;
    }

    public final ArrayList<MenuItemSrc> component3() {
        return this.rightItems;
    }

    public final MenuConfigModel copy(TitleType r100, ArrayList<MenuItemSrc> r101, ArrayList<MenuItemSrc> r102) {
        return new MenuConfigModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MenuConfigModel) == true) goto L8;
        return false;
    L8:
        MenuConfigModel r101 = (MenuConfigModel) r100;
        if (Intrinsics.areEqual(this.titleType, r101.titleType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftItems, r101.leftItems) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rightItems, r101.rightItems) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        TitleType r100 = this.titleType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<MenuItemSrc> r104 = this.leftItems;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<MenuItemSrc> r107 = this.rightItems;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MenuConfigModel(titleType=" + this.titleType + ", leftItems=" + this.leftItems + ", rightItems=" + this.rightItems + ')';
    }

    public final ArrayList<MenuItemSrc> getLeftItems() {
        return this.leftItems;
    }

    public final ArrayList<MenuItemSrc> getRightItems() {
        return this.rightItems;
    }

    public final TitleType getTitleType() {
        return this.titleType;
    }

    public MenuConfigModel(TitleType r100, ArrayList<MenuItemSrc> r101, ArrayList<MenuItemSrc> r102) {
        this.titleType = r100;
        this.leftItems = r101;
        this.rightItems = r102;
    }
}
