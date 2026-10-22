package com.cronutils.model;

import com.cronutils.model.definition.CronConstraint;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import vr7.b;
import zr7.a;

/* JADX INFO: loaded from: classes22.dex */
public class RebootCron implements Cron {
    private static final long serialVersionUID = 7487370826825439099L;
    private final CronDefinition cronDefinition;

    @Override // com.cronutils.model.Cron
    public String asString() {
        return "@reboot";
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        return Collections.unmodifiableMap(new HashMap());
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

    public RebootCron(CronDefinition r100) {
        a.b(r100, "CronDefinition must not be null");
        this.cronDefinition = r100;
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r100) {
        return asString().equals(r100.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r100) {
        a.b(r100, "CronFieldName must not be null");
        return null;
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(qr7.b r100, Cron r101) {
        asString();
        throw null;
    }
}
