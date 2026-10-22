package com.larus.sheet.sdk.api.orientation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/TitleBarStates;", "", "states", "", "<init>", "(Ljava/lang/String;II)V", "getStates", "()I", "VISIBLE", "GONE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarStates extends Enum<TitleBarStates> {
    public static final TitleBarStates GONE = null;
    public static final TitleBarStates VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarStates[] f369139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f369140b = null;
    private final int states;

    public static EnumEntries<TitleBarStates> getEntries() {
        return f369140b;
    }

    static {
        TitleBarStates r100 = new TitleBarStates("VISIBLE", 0, 1);
        VISIBLE = r100;
        TitleBarStates r101 = new TitleBarStates("GONE", 1, 0);
        GONE = r101;
        TitleBarStates[] r102 = {r100, r101};
        f369139a = r102;
        f369140b = EnumEntriesKt.enumEntries(r102);
    }

    public static TitleBarStates[] values() {
        return (TitleBarStates[]) f369139a.clone();
    }

    public final int getStates() {
        return this.states;
    }

    public static TitleBarStates valueOf(String r100) {
        return (TitleBarStates) a.a(TitleBarStates.class, r100);
    }

    public TitleBarStates(String r100, int r101, int r102) {
        super(r100, r101);
        this.states = r102;
    }
}
