package com.cronutils.model;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import rr7.b;
import zr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeCron implements Cron {
    private List<Cron> crons;
    private CronDefinition definition;
    private Pattern split;

    @Override // com.cronutils.model.Cron
    public String asString() {
        StringBuilder r100 = new StringBuilder();
        List r101 = (List) this.crons.stream().map(new b()).collect(Collectors.toList());
        int r102 = ((String) ListProtector.get(r101, 0)).split(" ").length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        StringBuilder r104 = new StringBuilder();
        Iterator r105 = r101.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r104.append(String.format("%s ", new Object[]{((String) r105.next()).split(" ")[r103]}));
        goto L6
    L8:
        String r106 = r104.toString().trim().replaceAll(" ", HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (this.split.splitAsStream(r106).distinct().limit(2).count() > 1) goto L11;
        r106 = this.split.split(r106)[0];
    L11:
        r100.append(String.format("%s ", new Object[]{r106}));
        r103 = r103 + 1;
        goto L3
    L13:
        return r100.toString().trim();
    }

    @Override // com.cronutils.model.Cron
    public Map<CronFieldName, CronField> retrieveFieldsAsMap() {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public Cron validate() {
        Iterator<Cron> r100 = this.crons.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().validate();
        goto L4
    L6:
        return this;
    }

    @Override // com.cronutils.model.Cron
    public CronDefinition getCronDefinition() {
        return this.definition;
    }

    public List<Cron> getCrons() {
        return this.crons;
    }

    public CompositeCron(List<Cron> r100) {
        this.split = PatternProtector.compile("\\|");
        this.crons = Collections.unmodifiableList(r100);
        a.c(r100, "List of Cron cannot be null or empty");
        boolean r101 = false;
        this.definition = ((Cron) ListProtector.get(r100, 0)).getCronDefinition();
        if (r100.size() != r100.stream().filter(new rr7.a(this)).count()) goto L5;
        r101 = true;
    L5:
        a.a(r101, "All Cron objects must have same definition for CompositeCron");
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(Cron r100) {
        return asString().equals(r100.asString());
    }

    @Override // com.cronutils.model.Cron
    public CronField retrieve(CronFieldName r100) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    public static /* synthetic */ boolean a(CompositeCron r100, Cron r101) {
        r100.getClass();
        return r101.getCronDefinition().equals(r100.definition);
    }

    @Override // com.cronutils.model.Cron
    public boolean equivalent(qr7.b r100, Cron r101) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }
}
