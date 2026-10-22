package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/performance/DozeMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DOZE_DEEP", "DOZE_LIGHT", "DOZE_NONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DozeMode extends Enum<DozeMode> {
    public static final DozeMode DOZE_DEEP = null;
    public static final DozeMode DOZE_LIGHT = null;
    public static final DozeMode DOZE_NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DozeMode[] f390973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390974b = null;
    private final int value;

    public static EnumEntries<DozeMode> getEntries() {
        return f390974b;
    }

    static {
        DozeMode r100 = new DozeMode("DOZE_DEEP", 0, 2);
        DOZE_DEEP = r100;
        DozeMode r101 = new DozeMode("DOZE_LIGHT", 1, 1);
        DOZE_LIGHT = r101;
        DozeMode r102 = new DozeMode("DOZE_NONE", 2, 0);
        DOZE_NONE = r102;
        DozeMode[] r103 = {r100, r101, r102};
        f390973a = r103;
        f390974b = EnumEntriesKt.enumEntries(r103);
    }

    public static DozeMode[] values() {
        return (DozeMode[]) f390973a.clone();
    }

    public static DozeMode valueOf(String r100) {
        return (DozeMode) r27.a.a(DozeMode.class, r100);
    }

    public DozeMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
