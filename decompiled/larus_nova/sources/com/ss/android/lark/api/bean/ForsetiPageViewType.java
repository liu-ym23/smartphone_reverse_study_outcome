package com.ss.android.lark.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "", "<init>", "(Ljava/lang/String;I)V", "MODAL_R_VIEW", "MODAL_C_FULL_VIEW", "MODAL_C_HALF_VIEW", "POPOVER_C_VIEW", "POPOVER_R_VIEW", "NORMAL_VIEW", "UNKNOWN_VIEW", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiPageViewType extends Enum<ForsetiPageViewType> {
    public static final ForsetiPageViewType MODAL_C_FULL_VIEW = null;
    public static final ForsetiPageViewType MODAL_C_HALF_VIEW = null;
    public static final ForsetiPageViewType MODAL_R_VIEW = null;
    public static final ForsetiPageViewType NORMAL_VIEW = null;
    public static final ForsetiPageViewType POPOVER_C_VIEW = null;
    public static final ForsetiPageViewType POPOVER_R_VIEW = null;
    public static final ForsetiPageViewType UNKNOWN_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiPageViewType[] f408651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408652b = null;

    public static EnumEntries<ForsetiPageViewType> getEntries() {
        return f408652b;
    }

    static {
        ForsetiPageViewType r100 = new ForsetiPageViewType("MODAL_R_VIEW", 0);
        MODAL_R_VIEW = r100;
        ForsetiPageViewType r101 = new ForsetiPageViewType("MODAL_C_FULL_VIEW", 1);
        MODAL_C_FULL_VIEW = r101;
        ForsetiPageViewType r102 = new ForsetiPageViewType("MODAL_C_HALF_VIEW", 2);
        MODAL_C_HALF_VIEW = r102;
        ForsetiPageViewType r103 = new ForsetiPageViewType("POPOVER_C_VIEW", 3);
        POPOVER_C_VIEW = r103;
        ForsetiPageViewType r104 = new ForsetiPageViewType("POPOVER_R_VIEW", 4);
        POPOVER_R_VIEW = r104;
        ForsetiPageViewType r105 = new ForsetiPageViewType("NORMAL_VIEW", 5);
        NORMAL_VIEW = r105;
        ForsetiPageViewType r110 = new ForsetiPageViewType("UNKNOWN_VIEW", 6);
        UNKNOWN_VIEW = r110;
        ForsetiPageViewType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f408651a = r111;
        f408652b = EnumEntriesKt.enumEntries(r111);
    }

    public static ForsetiPageViewType[] values() {
        return (ForsetiPageViewType[]) f408651a.clone();
    }

    public static ForsetiPageViewType valueOf(String r100) {
        return (ForsetiPageViewType) a.a(ForsetiPageViewType.class, r100);
    }

    public ForsetiPageViewType(String r100, int r101) {
        super(r100, r101);
    }
}
