package com.ss.android.lark.screenprotect.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/screenprotect/model/FlagState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Original", "Ban", "Allow", "None", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlagState extends Enum<FlagState> {
    public static final FlagState Allow = null;
    public static final FlagState Ban = null;
    public static final FlagState None = null;
    public static final FlagState Original = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlagState[] f439797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439798b = null;
    private final int value;

    public static EnumEntries<FlagState> getEntries() {
        return f439798b;
    }

    static {
        FlagState r100 = new FlagState("Original", 0, 0);
        Original = r100;
        FlagState r101 = new FlagState("Ban", 1, 1);
        Ban = r101;
        FlagState r102 = new FlagState("Allow", 2, 2);
        Allow = r102;
        FlagState r103 = new FlagState("None", 3, -1);
        None = r103;
        FlagState[] r104 = {r100, r101, r102, r103};
        f439797a = r104;
        f439798b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlagState[] values() {
        return (FlagState[]) f439797a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlagState valueOf(String r100) {
        return (FlagState) a.a(FlagState.class, r100);
    }

    public FlagState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
