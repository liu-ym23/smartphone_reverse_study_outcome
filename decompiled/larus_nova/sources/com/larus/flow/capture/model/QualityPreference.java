package com.larus.flow.capture.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/flow/capture/model/QualityPreference;", "", "<init>", "(Ljava/lang/String;I)V", "CLEAR", "FLUENT", "OApp.flowSDK.baseSDK.common.flow-capture"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QualityPreference extends Enum<QualityPreference> {
    public static final QualityPreference CLEAR = null;
    public static final QualityPreference FLUENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QualityPreference[] f343426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343427b = null;

    public static EnumEntries<QualityPreference> getEntries() {
        return f343427b;
    }

    static {
        QualityPreference r100 = new QualityPreference("CLEAR", 0);
        CLEAR = r100;
        QualityPreference r101 = new QualityPreference("FLUENT", 1);
        FLUENT = r101;
        QualityPreference[] r102 = {r100, r101};
        f343426a = r102;
        f343427b = EnumEntriesKt.enumEntries(r102);
    }

    public static QualityPreference[] values() {
        return (QualityPreference[]) f343426a.clone();
    }

    public static QualityPreference valueOf(String r100) {
        return (QualityPreference) a.a(QualityPreference.class, r100);
    }

    public QualityPreference(String r100, int r101) {
        super(r100, r101);
    }
}
