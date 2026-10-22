package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "left", "", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "getLeft", "()[Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "setLeft", "([Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;)V", "[Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "right", "getRight", "setRight", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardNavBarItem implements NonProguard {
    private NavBarItem[] left;
    private NavBarItem[] right;

    public CardNavBarItem() {
    }

    public int hashCode() {
        NavBarItem[] r0 = this.left;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = Arrays.hashCode(r0);
    L6:
        int r3 = r2 * 31;
        NavBarItem[] r4 = this.right;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CardNavBarItem(left=");
        NavBarItem[] r1 = this.left;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = Arrays.toString(r1);
    L6:
        r0.append(r3);
        r0.append(", right=");
        NavBarItem[] r4 = this.right;
        if (r4 == null) goto L9;
        r2 = Arrays.toString(r4);
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public final NavBarItem[] getLeft() {
        return this.left;
    }

    public final NavBarItem[] getRight() {
        return this.right;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (Intrinsics.areEqual(CardNavBarItem.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.sheet.cardmodetitlebar.CardNavBarItem");
        CardNavBarItem r5 = (CardNavBarItem) r4;
        if (this.left == null) goto L18;
        if (r5.left != null) goto L21;
        return false;
    L21:
        if (this.right == null) goto L26;
        if (r5.right != null) goto L28;
        return false;
    L28:
        return true;
    L26:
        if (r5.right == null) goto L28;
        return false;
    L18:
        if (r5.left == null) goto L21;
        return false;
    L8:
        r2 = null;
        goto L10
    }

    public final void setLeft(NavBarItem[] r1) {
        this.left = r1;
    }

    public final void setRight(NavBarItem[] r1) {
        this.right = r1;
    }
}
