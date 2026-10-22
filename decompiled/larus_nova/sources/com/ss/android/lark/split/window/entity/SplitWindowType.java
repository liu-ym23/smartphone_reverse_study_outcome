package com.ss.android.lark.split.window.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/split/window/entity/SplitWindowType;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "NATIVE_SPLIT_WINDOW", "ACTIVITY_EMBEDDING", "EASY_GO", "WMUnit", "split-window_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SplitWindowType extends Enum<SplitWindowType> {
    public static final SplitWindowType ACTIVITY_EMBEDDING = null;
    public static final SplitWindowType EASY_GO = null;
    public static final SplitWindowType NATIVE_SPLIT_WINDOW = null;
    public static final SplitWindowType WMUnit = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SplitWindowType[] f440611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440612b = null;
    private final String description;

    public static EnumEntries<SplitWindowType> getEntries() {
        return f440612b;
    }

    static {
        SplitWindowType r100 = new SplitWindowType("NATIVE_SPLIT_WINDOW", 0, "Native Android split window support (API 24+)");
        NATIVE_SPLIT_WINDOW = r100;
        SplitWindowType r101 = new SplitWindowType("ACTIVITY_EMBEDDING", 1, "Android Activity Embedding API (API 30+)");
        ACTIVITY_EMBEDDING = r101;
        SplitWindowType r102 = new SplitWindowType("EASY_GO", 2, "Custom or third-party split window implementation");
        EASY_GO = r102;
        SplitWindowType r103 = new SplitWindowType("WMUnit", 3, "WMUnit split window support ColorOS 13+");
        WMUnit = r103;
        SplitWindowType[] r104 = {r100, r101, r102, r103};
        f440611a = r104;
        f440612b = EnumEntriesKt.enumEntries(r104);
    }

    public static SplitWindowType[] values() {
        return (SplitWindowType[]) f440611a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public static SplitWindowType valueOf(String r100) {
        return (SplitWindowType) a.a(SplitWindowType.class, r100);
    }

    public SplitWindowType(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
