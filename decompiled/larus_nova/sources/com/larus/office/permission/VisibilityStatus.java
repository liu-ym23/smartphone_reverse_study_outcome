package com.larus.office.permission;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/office/permission/VisibilityStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "BAN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VisibilityStatus extends Enum<VisibilityStatus> {
    public static final VisibilityStatus BAN = null;
    public static final VisibilityStatus NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VisibilityStatus[] f362317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f362318b = null;
    private final int value;

    public static EnumEntries<VisibilityStatus> getEntries() {
        return f362318b;
    }

    static {
        VisibilityStatus r100 = new VisibilityStatus(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        VisibilityStatus r101 = new VisibilityStatus("BAN", 1, 2);
        BAN = r101;
        VisibilityStatus[] r102 = {r100, r101};
        f362317a = r102;
        f362318b = EnumEntriesKt.enumEntries(r102);
    }

    public static VisibilityStatus[] values() {
        return (VisibilityStatus[]) f362317a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VisibilityStatus valueOf(String r100) {
        return (VisibilityStatus) a.a(VisibilityStatus.class, r100);
    }

    public VisibilityStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
