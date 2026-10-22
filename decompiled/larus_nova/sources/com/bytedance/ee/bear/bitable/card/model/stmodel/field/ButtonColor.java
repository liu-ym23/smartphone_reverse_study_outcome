package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonColor;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "defaultState", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonColorStyle;", "getDefaultState", "()Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonColorStyle;", "active", "getActive", "disable", "getDisable", "loading", "getLoading", "done", "getDone", "copyFromBean", "", "bean", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ButtonColorBean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonColor implements NonProguard {
    private final ButtonColorStyle active;
    private final ButtonColorStyle defaultState;
    private final ButtonColorStyle disable;
    private final ButtonColorStyle done;
    private final ButtonColorStyle loading;

    public ButtonColor() {
        this.defaultState = new ButtonColorStyle();
        this.active = new ButtonColorStyle();
        this.disable = new ButtonColorStyle();
        this.loading = new ButtonColorStyle();
        this.done = new ButtonColorStyle();
    }

    public final ButtonColorStyle getActive() {
        return this.active;
    }

    public final ButtonColorStyle getDefaultState() {
        return this.defaultState;
    }

    public final ButtonColorStyle getDisable() {
        return this.disable;
    }

    public final ButtonColorStyle getDone() {
        return this.done;
    }

    public final ButtonColorStyle getLoading() {
        return this.loading;
    }

    public final void copyFromBean(ButtonColorBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        ButtonColorStyle r101 = this.defaultState;
        HashMap<String, ButtonColorBean.ButtonColorBeanStyle> r102 = r100.getStyles();
        ButtonColorBean.ButtonColorBeanStyle r103 = null;
        if (r102 == null) goto L5;
        ButtonColorBean.ButtonColorBeanStyle r104 = r102.get("default");
    L6:
        r101.copyFromBean(r104);
        ButtonColorStyle r105 = this.active;
        HashMap<String, ButtonColorBean.ButtonColorBeanStyle> r106 = r100.getStyles();
        if (r106 == null) goto L9;
        ButtonColorBean.ButtonColorBeanStyle r107 = r106.get("active");
    L10:
        r105.copyFromBean(r107);
        ButtonColorStyle r108 = this.disable;
        HashMap<String, ButtonColorBean.ButtonColorBeanStyle> r109 = r100.getStyles();
        if (r109 == null) goto L13;
        ButtonColorBean.ButtonColorBeanStyle r110 = r109.get("disable");
    L14:
        r108.copyFromBean(r110);
        ButtonColorStyle r111 = this.loading;
        HashMap<String, ButtonColorBean.ButtonColorBeanStyle> r112 = r100.getStyles();
        if (r112 == null) goto L17;
        ButtonColorBean.ButtonColorBeanStyle r113 = r112.get("loading");
    L18:
        r111.copyFromBean(r113);
        ButtonColorStyle r114 = this.done;
        HashMap<String, ButtonColorBean.ButtonColorBeanStyle> r115 = r100.getStyles();
        if (r115 == null) goto L21;
        r103 = r115.get("done");
    L21:
        r114.copyFromBean(r103);
        return;
    L17:
        r113 = null;
        goto L18
    L13:
        r110 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
