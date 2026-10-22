package com.bytedance.ee.bear.bitable.fieldedit.viewmodel;

import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.SelectFieldCondition;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface d {
    FilterFieldOption getConditionCurrentFieldById(String r100);

    /* JADX INFO: renamed from: getConditionList */
    List<com.bytedance.ee.bear.bitable.fieldedit.model.a> mo8313getConditionList();

    FilterFieldOption getConditionTargetFieldById(String r100);

    FilterFieldOption.OperatorOption getOperatorByCondition(SelectFieldCondition r100);

    FilterFieldOption getTargetField();

    FieldEditPanelData.TableBean getTargetTable();
}
