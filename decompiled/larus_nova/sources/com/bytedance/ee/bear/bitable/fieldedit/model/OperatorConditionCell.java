package com.bytedance.ee.bear.bitable.fieldedit.model;

import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/OperatorConditionCell;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItem;", "Lcom/bytedance/ee/util/io/NonProguard;", OnekeyLoginConstants.CU_KEY_OPERATOR, "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "<init>", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;)V", "getOperator", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption$OperatorOption;", "getHintTitle", "", "getTitle", "getIconRes", "", "()Ljava/lang/Integer;", "isSync", "", "()Z", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatorConditionCell implements ConditionListView.b, NonProguard {
    private final FilterFieldOption.OperatorOption operator;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ String getCallbackId() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public Integer getIconRes() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ Boolean isChecked() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public boolean isSync() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public String getTitle() {
        FilterFieldOption.OperatorOption r100 = this.operator;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getText();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public String getHintTitle() {
        return UIHelper.getString(R.string.Bitable_BTModule_Equal);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public Integer getRightIconRes() {
        return Integer.valueOf(R.drawable.ud_icon_down_bold_outlined);
    }

    public final FilterFieldOption.OperatorOption getOperator() {
        return this.operator;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ CharSequence getHintTitle() {
        return getHintTitle();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ CharSequence getTitle() {
        return getTitle();
    }

    public OperatorConditionCell(FilterFieldOption.OperatorOption r100) {
        this.operator = r100;
    }
}
