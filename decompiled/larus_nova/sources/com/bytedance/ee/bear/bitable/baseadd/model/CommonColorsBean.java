package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/CommonColorsBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "colors", "Ljava/util/LinkedList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "buttonColors", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;", "<init>", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "()V", "getColors", "()Ljava/util/LinkedList;", "setColors", "(Ljava/util/LinkedList;)V", "getButtonColors", "setButtonColors", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonColorsBean implements NonProguard {
    private LinkedList<ButtonColorBean> buttonColors;
    private LinkedList<ColorBean> colors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonColorsBean copy$default(CommonColorsBean r100, LinkedList r101, LinkedList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.colors;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.buttonColors;
    L9:
        return r100.copy(r101, r102);
    }

    public final LinkedList<ColorBean> component1() {
        return this.colors;
    }

    public final LinkedList<ButtonColorBean> component2() {
        return this.buttonColors;
    }

    public final CommonColorsBean copy(LinkedList<ColorBean> r100, LinkedList<ButtonColorBean> r101) {
        return new CommonColorsBean(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonColorsBean) == true) goto L8;
        return false;
    L8:
        CommonColorsBean r101 = (CommonColorsBean) r100;
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonColors, r101.buttonColors) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        LinkedList<ColorBean> r100 = this.colors;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        LinkedList<ButtonColorBean> r104 = this.buttonColors;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonColorsBean(colors=" + this.colors + ", buttonColors=" + this.buttonColors + ')';
    }

    public CommonColorsBean() {
        this(new LinkedList(), new LinkedList());
    }

    public final LinkedList<ButtonColorBean> getButtonColors() {
        return this.buttonColors;
    }

    public final LinkedList<ColorBean> getColors() {
        return this.colors;
    }

    public final void setButtonColors(LinkedList<ButtonColorBean> r100) {
        this.buttonColors = r100;
    }

    public final void setColors(LinkedList<ColorBean> r100) {
        this.colors = r100;
    }

    public CommonColorsBean(LinkedList<ColorBean> r100, LinkedList<ButtonColorBean> r101) {
        this.colors = r100;
        this.buttonColors = r101;
    }
}
