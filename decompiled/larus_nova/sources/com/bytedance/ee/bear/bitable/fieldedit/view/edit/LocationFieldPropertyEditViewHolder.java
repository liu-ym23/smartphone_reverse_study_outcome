package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorModel;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J0\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/LocationFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;)V", "mLocationTypeBean", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$LocationTypeBean;", "initView", "", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "getCurrentEditProperty", "getLocationType", "", "notLimit", "", "notifyFieldPropertyOptionChanged", "newFieldPropertyOption", "", "updatePropertySelectorText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationFieldPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FieldConfigMetaModel.LocationTypeBean f211207k;

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        FieldConfigMetaModel.LocationTypeBean r101 = this.f211207k;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getInputType();
    L6:
        String r104 = LocationEditorModel.NOT_LIMIT;
        if (r103 == null) goto L15;
        FieldConfigMetaModel.LocationTypeBean r105 = this.f211207k;
        if (r105 == null) goto L12;
        r102 = r105.getInputType();
    L12:
        if (Intrinsics.areEqual(r102, LocationEditorModel.NOT_LIMIT) == true) goto L15;
        boolean r106 = false;
    L16:
        if (r106 == false) goto L18;
        Intrinsics.checkNotNull(LocationEditorModel.NOT_LIMIT);
    L19:
        r100.setInputType(r104);
        return r100;
    L18:
        r104 = LocationEditorModel.ONLY_MOBILE;
        Intrinsics.checkNotNull(LocationEditorModel.ONLY_MOBILE);
    L15:
        r106 = true;
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        BaseFieldPropertyEditViewHolder.w(true, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector)});
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r100.findViewById(R.id.fieldPropertyChecker)});
        ((TextView) r100.findViewById(R.id.fieldPropertyText)).setText(R.string.Bitable_Field_LocateMethodMobileVer);
    }

    public final void x() {
        TextView r100 = (TextView) this.f211151c.findViewById(R.id.fieldPropertySelectorTV);
        FieldConfigMetaModel.LocationTypeBean r101 = this.f211207k;
        if (r101 == null) goto L5;
        String r102 = r101.getInputType();
    L7:
        if (Intrinsics.areEqual(r102, LocationEditorModel.ONLY_MOBILE) == false) goto L9;
        int r103 = R.string.Bitable_Field_RealTimeLocationMobileVer;
    L10:
        r100.setText(r103);
        return;
    L9:
        r103 = R.string.Bitable_Field_LocateManuallyMobileVer;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void l(Object r100) {
        if ((r100 instanceof FieldConfigMetaModel.LocationTypeBean) == false) goto L5;
        FieldConfigMetaModel.LocationTypeBean r101 = (FieldConfigMetaModel.LocationTypeBean) r100;
    L6:
        if (r101 == null) goto L9;
        this.f211207k = r101;
        x();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public LocationFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        FieldConfigMetaModel.LocationTypeBean r104 = new FieldConfigMetaModel.LocationTypeBean();
        if (r101 == null) goto L5;
        String r105 = r101.getInputType();
    L6:
        String r106 = LocationEditorModel.NOT_LIMIT;
        if (r105 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        Intrinsics.checkNotNull(LocationEditorModel.NOT_LIMIT);
    L16:
        r104.setInputType(r106);
        this.f211207k = r104;
        x();
        return;
    L15:
        r106 = LocationEditorModel.ONLY_MOBILE;
        Intrinsics.checkNotNull(LocationEditorModel.ONLY_MOBILE);
        goto L16
    L9:
        if (Intrinsics.areEqual(r101.getInputType(), LocationEditorModel.NOT_LIMIT) == true) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }
}
