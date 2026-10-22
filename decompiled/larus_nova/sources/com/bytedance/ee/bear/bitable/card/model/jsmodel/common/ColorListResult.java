package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorListResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "ColorList", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "getColorList", "()[Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "setColorList", "([Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;)V", "[Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorListResult implements NonProguard {
    private ColorBean[] ColorList;

    public ColorListResult() {
    }

    public final ColorBean[] getColorList() {
        return this.ColorList;
    }

    public final void setColorList(ColorBean[] r100) {
        this.ColorList = r100;
    }
}
