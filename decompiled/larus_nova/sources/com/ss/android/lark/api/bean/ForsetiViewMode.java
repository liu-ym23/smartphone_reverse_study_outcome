package com.ss.android.lark.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "", "<init>", "(Ljava/lang/String;I)V", "COMPACT", "MEDIUM", "EXPAND", "UNKNOWN", "isCompact", "", "isMedium", "isExpand", "isUnknown", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiViewMode extends Enum<ForsetiViewMode> {
    public static final ForsetiViewMode COMPACT = null;
    public static final ForsetiViewMode EXPAND = null;
    public static final ForsetiViewMode MEDIUM = null;
    public static final ForsetiViewMode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiViewMode[] f408655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408656b = null;

    public static EnumEntries<ForsetiViewMode> getEntries() {
        return f408656b;
    }

    static {
        ForsetiViewMode r100 = new ForsetiViewMode("COMPACT", 0);
        COMPACT = r100;
        ForsetiViewMode r101 = new ForsetiViewMode("MEDIUM", 1);
        MEDIUM = r101;
        ForsetiViewMode r102 = new ForsetiViewMode("EXPAND", 2);
        EXPAND = r102;
        ForsetiViewMode r103 = new ForsetiViewMode("UNKNOWN", 3);
        UNKNOWN = r103;
        ForsetiViewMode[] r104 = {r100, r101, r102, r103};
        f408655a = r104;
        f408656b = EnumEntriesKt.enumEntries(r104);
    }

    public static ForsetiViewMode[] values() {
        return (ForsetiViewMode[]) f408655a.clone();
    }

    public final boolean isCompact() {
        if (this != COMPACT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isExpand() {
        if (this != EXPAND) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMedium() {
        if (this != MEDIUM) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUnknown() {
        if (this != UNKNOWN) goto L5;
        return true;
    L5:
        return false;
    }

    public static ForsetiViewMode valueOf(String r100) {
        return (ForsetiViewMode) a.a(ForsetiViewMode.class, r100);
    }

    public ForsetiViewMode(String r100, int r101) {
        super(r100, r101);
    }
}
