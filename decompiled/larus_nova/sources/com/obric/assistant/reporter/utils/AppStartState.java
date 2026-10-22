package com.obric.assistant.reporter.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/reporter/utils/AppStartState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ColdStart", "WarmStart", "HotStart", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppStartState extends Enum<AppStartState> {
    public static final AppStartState ColdStart = null;
    public static final AppStartState HotStart = null;
    public static final AppStartState WarmStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppStartState[] f391414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391415b = null;
    private final int value;

    public static EnumEntries<AppStartState> getEntries() {
        return f391415b;
    }

    static {
        AppStartState r100 = new AppStartState("ColdStart", 0, 0);
        ColdStart = r100;
        AppStartState r101 = new AppStartState("WarmStart", 1, 1);
        WarmStart = r101;
        AppStartState r102 = new AppStartState("HotStart", 2, 2);
        HotStart = r102;
        AppStartState[] r103 = {r100, r101, r102};
        f391414a = r103;
        f391415b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppStartState[] values() {
        return (AppStartState[]) f391414a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppStartState valueOf(String r100) {
        return (AppStartState) r27.a.a(AppStartState.class, r100);
    }

    public AppStartState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
