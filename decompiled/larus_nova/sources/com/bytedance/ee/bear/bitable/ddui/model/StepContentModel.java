package com.bytedance.ee.bear.bitable.ddui.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "field", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionEditItemModel;", "Lkotlin/collections/ArrayList;", "getField", "()Ljava/util/ArrayList;", "setField", "(Ljava/util/ArrayList;)V", OnekeyLoginConstants.CU_KEY_OPERATOR, "getOperator", "setOperator", "valueScope", "getValueScope", "setValueScope", BdpAppEventConstant.MULTIPLE, "", "getMultiple", "()Ljava/lang/Boolean;", "setMultiple", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "value", "Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueModel;", "getValue", "()Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueModel;", "setValue", "(Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueModel;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StepContentModel extends BaseWidgetModel {
    private ArrayList<ConditionEditItemModel> field;
    private Boolean multiple;
    private ArrayList<ConditionEditItemModel> operator;
    private StepContentValueModel value;
    private ArrayList<ConditionEditItemModel> valueScope;

    public StepContentModel() {
    }

    public final ArrayList<ConditionEditItemModel> getField() {
        return this.field;
    }

    public final Boolean getMultiple() {
        return this.multiple;
    }

    public final ArrayList<ConditionEditItemModel> getOperator() {
        return this.operator;
    }

    public final StepContentValueModel getValue() {
        return this.value;
    }

    public final ArrayList<ConditionEditItemModel> getValueScope() {
        return this.valueScope;
    }

    public final void setField(ArrayList<ConditionEditItemModel> r100) {
        this.field = r100;
    }

    public final void setMultiple(Boolean r100) {
        this.multiple = r100;
    }

    public final void setOperator(ArrayList<ConditionEditItemModel> r100) {
        this.operator = r100;
    }

    public final void setValue(StepContentValueModel r100) {
        this.value = r100;
    }

    public final void setValueScope(ArrayList<ConditionEditItemModel> r100) {
        this.valueScope = r100;
    }
}
