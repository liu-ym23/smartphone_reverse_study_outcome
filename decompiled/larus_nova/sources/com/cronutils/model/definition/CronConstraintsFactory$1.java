package com.cronutils.model.definition;

import com.cronutils.model.Cron;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.QuestionMark;

/* JADX INFO: loaded from: classes22.dex */
final class CronConstraintsFactory$1 extends CronConstraint {
    private static final long serialVersionUID = 520379111876897579L;

    public CronConstraintsFactory$1(String r100) {
        super(r100);
    }

    @Override // com.cronutils.model.definition.CronConstraint
    public boolean validate(Cron r100) {
        CronField r101 = r100.retrieve(CronFieldName.DAY_OF_YEAR);
        if (r101 != null) goto L5;
        return true;
    L5:
        if ((r101.getExpression() instanceof QuestionMark) == false) goto L7;
        return true;
    L7:
        if ((r100.retrieve(CronFieldName.DAY_OF_WEEK).getExpression() instanceof QuestionMark) == true) goto L9;
    L11:
        return false;
    L9:
        if ((r100.retrieve(CronFieldName.DAY_OF_MONTH).getExpression() instanceof QuestionMark) == false) goto L11;
        return true;
    }
}
