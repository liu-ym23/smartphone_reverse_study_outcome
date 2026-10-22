package com.suite.lark.platform.feature.forward.doubao.api.entity;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoThreadType;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.ALL, "NORMAL_THREAD", "MSG_THREAD", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoThreadType extends Enum<DoubaoThreadType> {
    public static final DoubaoThreadType ALL = null;
    public static final DoubaoThreadType MSG_THREAD = null;
    public static final DoubaoThreadType NORMAL_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoThreadType[] f461277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f461278b = null;

    public static EnumEntries<DoubaoThreadType> getEntries() {
        return f461278b;
    }

    static {
        DoubaoThreadType r100 = new DoubaoThreadType(AccountType.ALL, 0);
        ALL = r100;
        DoubaoThreadType r101 = new DoubaoThreadType("NORMAL_THREAD", 1);
        NORMAL_THREAD = r101;
        DoubaoThreadType r102 = new DoubaoThreadType("MSG_THREAD", 2);
        MSG_THREAD = r102;
        DoubaoThreadType[] r103 = {r100, r101, r102};
        f461277a = r103;
        f461278b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoubaoThreadType[] values() {
        return (DoubaoThreadType[]) f461277a.clone();
    }

    public static DoubaoThreadType valueOf(String r100) {
        return (DoubaoThreadType) a.a(DoubaoThreadType.class, r100);
    }

    public DoubaoThreadType(String r100, int r101) {
        super(r100, r101);
    }
}
