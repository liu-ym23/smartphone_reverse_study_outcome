package com.bytedance.locallife.dito.log.error;

import com.bytedance.locallife.dito.log.ReportType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/log/error/DitoWarnExceptionType;", "Lcom/bytedance/locallife/dito/log/error/a;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class DitoWarnExceptionType implements a {
    public DitoWarnExceptionType() {
    }

    @Override // com.bytedance.locallife.dito.log.error.a
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.locallife.dito.log.error.a
    public String getType() {
        return a.C3659a.getType(this);
    }

    @Override // com.bytedance.locallife.dito.log.error.a
    public final ReportType b() {
        return ReportType.WARNING;
    }
}
