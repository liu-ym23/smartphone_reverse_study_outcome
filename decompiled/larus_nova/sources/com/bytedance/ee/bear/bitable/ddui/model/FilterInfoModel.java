package com.bytedance.ee.bear.bitable.ddui.model;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/FilterInfoModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "titleBar", "Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", "getTitleBar", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", "setTitleBar", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;)V", "conjunction", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConjunctionModel;", "getConjunction", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ConjunctionModel;", "setConjunction", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ConjunctionModel;)V", "conditions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemModel;", "Lkotlin/collections/ArrayList;", "getConditions", "()Ljava/util/ArrayList;", "setConditions", "(Ljava/util/ArrayList;)V", "addCondition", "Lcom/bytedance/ee/bear/bitable/ddui/model/AddConditionModel;", "getAddCondition", "()Lcom/bytedance/ee/bear/bitable/ddui/model/AddConditionModel;", "setAddCondition", "(Lcom/bytedance/ee/bear/bitable/ddui/model/AddConditionModel;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterInfoModel extends BaseWidgetModel {
    private AddConditionModel addCondition;
    private ArrayList<ConditionItemModel> conditions;
    private ConjunctionModel conjunction;
    private TitleWidgetModel titleBar;

    public FilterInfoModel() {
    }

    public final AddConditionModel getAddCondition() {
        return this.addCondition;
    }

    public final ArrayList<ConditionItemModel> getConditions() {
        return this.conditions;
    }

    public final ConjunctionModel getConjunction() {
        return this.conjunction;
    }

    public final TitleWidgetModel getTitleBar() {
        return this.titleBar;
    }

    public final void setAddCondition(AddConditionModel r100) {
        this.addCondition = r100;
    }

    public final void setConditions(ArrayList<ConditionItemModel> r100) {
        this.conditions = r100;
    }

    public final void setConjunction(ConjunctionModel r100) {
        this.conjunction = r100;
    }

    public final void setTitleBar(TitleWidgetModel r100) {
        this.titleBar = r100;
    }
}
