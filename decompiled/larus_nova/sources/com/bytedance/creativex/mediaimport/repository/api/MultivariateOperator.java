package com.bytedance.creativex.mediaimport.repository.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/MultivariateOperator;", "Lcom/bytedance/creativex/mediaimport/repository/api/Operator;", "", "option", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOption", "()Ljava/lang/String;", "IN", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultivariateOperator extends Enum<MultivariateOperator> {
    public static final MultivariateOperator IN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultivariateOperator[] f203617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203618b = null;
    private final String option;

    public MultivariateOperator() {
        super("IN", 0);
        this.option = "IN";
    }

    public static EnumEntries<MultivariateOperator> getEntries() {
        return f203618b;
    }

    static {
        MultivariateOperator r100 = new MultivariateOperator();
        IN = r100;
        MultivariateOperator[] r101 = {r100};
        f203617a = r101;
        f203618b = EnumEntriesKt.enumEntries(r101);
    }

    public static MultivariateOperator[] values() {
        return (MultivariateOperator[]) f203617a.clone();
    }

    public String getOption() {
        return this.option;
    }

    public static MultivariateOperator valueOf(String r100) {
        return (MultivariateOperator) r27.a.a(MultivariateOperator.class, r100);
    }
}
