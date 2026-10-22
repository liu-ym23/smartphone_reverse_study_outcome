package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/camera/impl/entity/ResultBottomControlType;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM", "INPUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultBottomControlType extends Enum<ResultBottomControlType> {
    public static final ResultBottomControlType CONFIRM = null;
    public static final ResultBottomControlType INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultBottomControlType[] f321708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321709b = null;

    public static EnumEntries<ResultBottomControlType> getEntries() {
        return f321709b;
    }

    static {
        ResultBottomControlType r100 = new ResultBottomControlType("CONFIRM", 0);
        CONFIRM = r100;
        ResultBottomControlType r101 = new ResultBottomControlType("INPUT", 1);
        INPUT = r101;
        ResultBottomControlType[] r102 = {r100, r101};
        f321708a = r102;
        f321709b = EnumEntriesKt.enumEntries(r102);
    }

    public static ResultBottomControlType[] values() {
        return (ResultBottomControlType[]) f321708a.clone();
    }

    public static ResultBottomControlType valueOf(String r100) {
        return (ResultBottomControlType) a.a(ResultBottomControlType.class, r100);
    }

    public ResultBottomControlType(String r100, int r101) {
        super(r100, r101);
    }
}
