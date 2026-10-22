package com.ss.android.lark.ug.scheduler.rule.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/rule/entity/MetaRule;", "", "<init>", "(Ljava/lang/String;I)V", "COUNT", "DURATION", "CONTENT", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MetaRule extends Enum<MetaRule> {
    public static final MetaRule CONTENT = null;
    public static final MetaRule COUNT = null;
    public static final MetaRule DURATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MetaRule[] f444501a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444502b = null;

    public static EnumEntries<MetaRule> getEntries() {
        return f444502b;
    }

    static {
        MetaRule r100 = new MetaRule("COUNT", 0);
        COUNT = r100;
        MetaRule r101 = new MetaRule("DURATION", 1);
        DURATION = r101;
        MetaRule r102 = new MetaRule("CONTENT", 2);
        CONTENT = r102;
        MetaRule[] r103 = {r100, r101, r102};
        f444501a = r103;
        f444502b = EnumEntriesKt.enumEntries(r103);
    }

    public static MetaRule[] values() {
        return (MetaRule[]) f444501a.clone();
    }

    public static MetaRule valueOf(String r100) {
        return (MetaRule) r27.a.a(MetaRule.class, r100);
    }

    public MetaRule(String r100, int r101) {
        super(r100, r101);
    }
}
