package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0002R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/NumberFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mCommonNumberFormatList", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "mCurrentNumberFormat", "initView", "", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "notifyFieldPropertyOptionChanged", "newFieldPropertyOption", "", "getCurrentEditProperty", "updatePropertySelectorText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumberFieldPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FieldConfigMetaModel.NumberFormatBean[] f211208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FieldConfigMetaModel.NumberFormatBean f211209l;

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        FieldConfigMetaModel.NumberFormatBean r101 = this.f211209l;
        if (r101 == null) goto L5;
        String r102 = r101.getFormatCode();
    L6:
        r100.setFormatter(r102);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        BaseFieldPropertyEditViewHolder.w(true, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector)});
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r100.findViewById(R.id.fieldPropertyChecker)});
        ((TextView) r100.findViewById(R.id.fieldPropertyText)).setText(R.string.Bitable_Field_NumberFormat);
    }

    public final void x() {
        FieldConfigMetaModel.NumberFormatBean r100 = this.f211209l;
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.getType();
        int r103 = FieldConfigMetaModel.EFormatterType.CURRENCY.getValue();
        if (r102 == null) goto L10;
        if (r102.intValue() != r103) goto L10;
        r101 = true;
    L10:
        TextView r104 = (TextView) this.f211151c.findViewById(R.id.fieldPropertySelectorTV);
        FieldConfigMetaModel.NumberFormatBean r105 = this.f211209l;
        if (r105 == null) goto L13;
        String r106 = r105.getName();
    L14:
        r104.setText(r106);
        r104.setEnabled(true ^ r101);
        return;
    L13:
        r106 = null;
        goto L14
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void l(Object r100) {
        if ((r100 instanceof FieldConfigMetaModel.NumberFormatBean) == false) goto L5;
        FieldConfigMetaModel.NumberFormatBean r101 = (FieldConfigMetaModel.NumberFormatBean) r100;
    L6:
        if (r101 == null) goto L9;
        this.f211209l = r101;
        x();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public NumberFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101, FieldConfigMetaModel.NumberFormatBean[] r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
        this.f211208k = r102;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        FieldConfigMetaModel.NumberFormatBean[] r104 = this.f211208k;
        int r105 = 0;
        if (r104 == null) goto L16;
        int r106 = r104.length;
        int r107 = 0;
    L5:
        FieldConfigMetaModel.NumberFormatBean r108 = null;
        String r109 = null;
        if (r107 >= r106) goto L14;
        FieldConfigMetaModel.NumberFormatBean r110 = r104[r107];
        String r111 = r110.getFormatCode();
        if (r101 == null) goto L11;
        r109 = r101.getFormatter();
    L11:
        if (TextUtils.equals(r111, r109) == true) goto L12;
        r107 = r107 + 1;
        goto L5
    L12:
        r108 = r110;
    L14:
        if (r108 == null) goto L16;
        this.f211209l = r108;
    L27:
        x();
        q0.a r112 = r();
        if (r112 == null) goto L33;
        r112.l(this.f211209l);
        return;
    L33:
        return;
    L16:
        if (r100 == null) goto L22;
        FieldConfigMetaModel.Property r113 = r100.getProperty();
        if (r113 == null) goto L22;
        Integer r114 = r113.getDefaultNumberFormatIndex();
        if (r114 == null) goto L22;
        r105 = r114.intValue();
    L22:
        FieldConfigMetaModel.NumberFormatBean[] r115 = this.f211208k;
        if (r115 == null) goto L27;
        if (r115.length <= r105) goto L27;
        this.f211209l = r115[r105];
        goto L27
    }
}
