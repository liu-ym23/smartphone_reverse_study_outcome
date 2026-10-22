package com.cronutils.model;

import com.cronutils.model.definition.CronConstraint;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vr7.b;
import zr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class SingleCron implements Cron {
    private static final long serialVersionUID = 7487370826825439098L;
    private String asString;
    private final CronDefinition cronDefinition;
    private final Map<CronFieldName, CronField> fields;

    @Override // com.cronutils.model.Cron
    public String asString() {
        if (this.asString != null) goto L10;
        ArrayList r100 = new ArrayList(this.fields.values());
        r100.sort(CronField.createFieldComparator());
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.append(String.format("%s ", new Object[]{((CronField) r102.next()).getExpression().asString()}));
        goto L6
    L8:
        this.asString = r101.toString().trim();
    L10:
        return this.asString;
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        return Collections.unmodifiableMap(this.fields);
    }

    @Override // com.cronutils.model.Cron
    public Cron validate() {
        Iterator<Map.Entry<CronFieldName, CronField>> r100 = retrieveFieldsAsMap().entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<CronFieldName, CronField> r101 = r100.next();
        r101.getValue().getExpression().accept(new b(getCronDefinition().getFieldDefinition(r101.getKey()).getConstraints()));
        goto L4
    L6:
        Iterator<CronConstraint> r102 = getCronDefinition().getCronConstraints().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        CronConstraint r103 = r102.next();
        if (r103.validate(this) == true) goto L8;
        throw new IllegalArgumentException(String.format("Invalid cron expression: %s. %s", new Object[]{asString(), r103.getDescription()}));
    L14:
        return this;
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.cronDefinition;
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r100) {
        return asString().equals(r100.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r100) {
        Map<CronFieldName, CronField> r101 = this.fields;
        a.b(r100, "CronFieldName must not be null");
        return r101.get(r100);
    }

    public SingleCron(CronDefinition r100, List<CronField> r101) {
        a.b(r100, "CronDefinition must not be null");
        this.cronDefinition = r100;
        a.b(r101, "CronFields cannot be null");
        this.fields = new EnumMap(CronFieldName.class);
        Iterator<CronField> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        CronField r103 = r102.next();
        this.fields.put(r103.getField(), r103);
        goto L4
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(qr7.b r100, Cron r101) {
        asString();
        throw null;
    }
}
