package com.cronutils.model.definition;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class CronDefinition implements Serializable {
    private static final long serialVersionUID = 7067112327461432170L;
    private final Set<CronConstraint> cronConstraints;
    private final Set<CronNicknames> cronNicknames;
    private final Map<CronFieldName, FieldDefinition> fieldDefinitions;
    private final boolean matchDayOfWeekAndDayOfMonth;

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldDefinitions, this.cronConstraints, this.cronNicknames, Boolean.valueOf(this.matchDayOfWeekAndDayOfMonth)});
    }

    public Set<FieldDefinition> getFieldDefinitions() {
        return new HashSet(this.fieldDefinitions.values());
    }

    public Map<CronFieldName, FieldDefinition> retrieveFieldDefinitionsAsMap() {
        return Collections.unmodifiableMap(this.fieldDefinitions);
    }

    public Set<CronConstraint> getCronConstraints() {
        return this.cronConstraints;
    }

    public Set<CronNicknames> getCronNicknames() {
        return this.cronNicknames;
    }

    public boolean isMatchDayOfWeekAndDayOfMonth() {
        return this.matchDayOfWeekAndDayOfMonth;
    }

    public boolean containsFieldDefinition(CronFieldName r100) {
        return this.fieldDefinitions.containsKey(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        CronDefinition r101 = (CronDefinition) r100;
        if (this.matchDayOfWeekAndDayOfMonth == r101.matchDayOfWeekAndDayOfMonth) goto L13;
    L19:
        return false;
    L13:
        if (this.fieldDefinitions.equals(r101.fieldDefinitions) == false) goto L19;
        if (this.cronConstraints.equals(r101.cronConstraints) == false) goto L19;
        if (this.cronNicknames.equals(r101.cronNicknames) == false) goto L19;
        return true;
    }

    public FieldDefinition getFieldDefinition(CronFieldName r100) {
        return this.fieldDefinitions.get(r100);
    }

    public CronDefinition(List<FieldDefinition> r100, Set<CronConstraint> r101, Set<CronNicknames> r102, boolean r103) {
        zr7.a.b(r102, "Cron nicknames must not be null");
        if (r102.contains(CronNicknames.REBOOT) == true) goto L5;
        zr7.a.b(r100, "Field definitions must not be null");
        zr7.a.b(r101, "Cron validations must not be null");
        zr7.a.c(r100, "Field definitions must not be empty");
        zr7.a.a(!((FieldDefinition) ListProtector.get(r100, 0)).isOptional(), "The first field must not be optional");
    L5:
        this.fieldDefinitions = new EnumMap(CronFieldName.class);
        Iterator<FieldDefinition> r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        FieldDefinition r105 = r104.next();
        this.fieldDefinitions.put(r105.getFieldName(), r105);
        goto L7
    L9:
        this.cronConstraints = Collections.unmodifiableSet(r101);
        this.cronNicknames = Collections.unmodifiableSet(r102);
        this.matchDayOfWeekAndDayOfMonth = r103;
    }
}
