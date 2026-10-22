package com.bytedance.ee.bear.bitable.fieldedit.model;

import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.DynamicFieldViewModel;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConditionCell;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "field", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "hintTitle", "", "<init>", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;I)V", "getField", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "getHintTitle", "()I", "", "getTitle", "getIconRes", "()Ljava/lang/Integer;", "isSync", "", "()Z", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldConditionCell implements ConditionListView.b, NonProguard {
    private final FilterFieldOption field;
    private final int hintTitle;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ String getCallbackId() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ Boolean isChecked() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public String getHintTitle() {
        FilterFieldOption r100 = this.field;
        if (r100 == null) goto L14;
        if ((r100 instanceof DynamicFieldViewModel.DeleteField) == true) goto L14;
        if (r100.isDeniedField() == false) goto L12;
        return UIHelper.getString(R.string.Bitable_SingleOption_NoPermToViewOptionTip);
    L12:
        return UIHelper.getString(this.hintTitle);
    L14:
        return UIHelper.getString(this.hintTitle);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public Integer getIconRes() {
        FilterFieldOption r100 = this.field;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof DynamicFieldViewModel.DeleteField) == false) goto L7;
        return null;
    L7:
        if (r100.isDeniedField() == false) goto L10;
        return null;
    L10:
        return Integer.valueOf(this.field.getFieldCompositeType().getIcon());
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public String getTitle() {
        FilterFieldOption r100 = this.field;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof DynamicFieldViewModel.DeleteField) == false) goto L7;
        return null;
    L7:
        if (r100.isDeniedField() == true) goto L16;
        FilterFieldOption r101 = this.field;
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.getName();
    L16:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public boolean isSync() {
        FilterFieldOption r100 = this.field;
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof DynamicFieldViewModel.DeleteField) == false) goto L7;
        return false;
    L7:
        if (r100.isDeniedField() == false) goto L10;
        return false;
    L10:
        return this.field.isSync();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public Integer getRightIconRes() {
        return Integer.valueOf(R.drawable.ud_icon_down_bold_outlined);
    }

    public final FilterFieldOption getField() {
        return this.field;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ CharSequence getHintTitle() {
        return getHintTitle();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public /* bridge */ /* synthetic */ CharSequence getTitle() {
        return getTitle();
    }

    public final int getHintTitle() {
        return this.hintTitle;
    }

    public FieldConditionCell(FilterFieldOption r100, int r101) {
        this.field = r100;
        this.hintTitle = r101;
    }
}
