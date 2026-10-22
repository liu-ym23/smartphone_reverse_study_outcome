package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonColorStyle;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/Integer;", "setBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColor", "getTextColor", "setTextColor", "copyFromBean", "", "bean", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean$ButtonColorBeanStyle;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonColorStyle implements NonProguard {
    private Integer bgColor;
    private Integer textColor;

    public ButtonColorStyle() {
    }

    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final void copyFromBean(ButtonColorBean.ButtonColorBeanStyle r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getBgColor();
        if (r101 == null) goto L6;
        this.bgColor = Integer.valueOf(ColorUtils.h(r101));
    L6:
        if (r100 == null) goto L11;
        String r102 = r100.getTextColor();
        if (r102 == null) goto L12;
        this.textColor = Integer.valueOf(ColorUtils.h(r102));
        return;
    L12:
        return;
    }

    public final void setBgColor(Integer r100) {
        this.bgColor = r100;
    }

    public final void setTextColor(Integer r100) {
        this.textColor = r100;
    }
}
