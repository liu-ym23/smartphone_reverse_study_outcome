package com.larus.network.quota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/network/quota/AppStartState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NormalStart", "ColdStart", "HotStart", "WarmStart", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppStartState extends Enum<AppStartState> {
    public static final AppStartState ColdStart = null;
    public static final AppStartState HotStart = null;
    public static final AppStartState NormalStart = null;
    public static final AppStartState WarmStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppStartState[] f360217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360218b = null;
    private final int value;

    public static EnumEntries<AppStartState> getEntries() {
        return f360218b;
    }

    static {
        AppStartState r100 = new AppStartState("NormalStart", 0, -1);
        NormalStart = r100;
        AppStartState r101 = new AppStartState("ColdStart", 1, 0);
        ColdStart = r101;
        AppStartState r102 = new AppStartState("HotStart", 2, 1);
        HotStart = r102;
        AppStartState r103 = new AppStartState("WarmStart", 3, 2);
        WarmStart = r103;
        AppStartState[] r104 = {r100, r101, r102, r103};
        f360217a = r104;
        f360218b = EnumEntriesKt.enumEntries(r104);
    }

    public static AppStartState[] values() {
        return (AppStartState[]) f360217a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppStartState valueOf(String r100) {
        return (AppStartState) a.a(AppStartState.class, r100);
    }

    public AppStartState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
