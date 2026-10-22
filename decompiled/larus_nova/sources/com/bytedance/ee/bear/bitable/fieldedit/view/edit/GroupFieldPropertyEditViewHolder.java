package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J0\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/GroupFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;)V", "initView", "", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "getCurrentEditProperty", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupFieldPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {
    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        r100.setMultiple(Boolean.valueOf(((UDSwitch) this.f211151c.findViewById(R.id.checkBox)).isChecked()));
        return r100;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector)});
        BaseFieldPropertyEditViewHolder.w(true, new View[]{r100.findViewById(R.id.fieldPropertyChecker)});
        ((TextView) r100.findViewById(R.id.fieldPropertyCheckerTV)).setText(R.string.Bitable_Group_AllowAddingMultipleGroups_Checkbox);
        ((UDSwitch) r100.findViewById(R.id.checkBox)).setChecked(false);
    }

    public GroupFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        UDSwitch r104 = (UDSwitch) this.f211151c.findViewById(R.id.checkBox);
        if (r101 == null) goto L7;
        Boolean r105 = r101.getMultiple();
        if (r105 == null) goto L7;
        boolean r106 = r105.booleanValue();
    L8:
        r104.setChecked(r106);
        return;
    L7:
        r106 = false;
        goto L8
    }
}
