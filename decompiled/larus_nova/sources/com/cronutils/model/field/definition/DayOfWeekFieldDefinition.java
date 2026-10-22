package com.cronutils.model.field.definition;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;

/* JADX INFO: loaded from: classes6.dex */
public class DayOfWeekFieldDefinition extends FieldDefinition {
    private static final long serialVersionUID = 8684844402711204711L;
    private final WeekDay mondayDoWValue;

    public WeekDay getMondayDoWValue() {
        return this.mondayDoWValue;
    }

    public DayOfWeekFieldDefinition(CronFieldName r100, FieldConstraints r101, boolean r102, WeekDay r103) {
        super(r100, r101, r102);
        this.mondayDoWValue = r103;
    }
}
