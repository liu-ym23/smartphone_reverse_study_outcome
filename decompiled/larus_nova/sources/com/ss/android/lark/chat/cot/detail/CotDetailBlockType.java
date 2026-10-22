package com.ss.android.lark.chat.cot.detail;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/CotDetailBlockType;", "", "<init>", "(Ljava/lang/String;I)V", "THINKING", "GROUP", "TOOLCALL", "ACTION", CommonConstant.RETKEY.STATUS, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailBlockType extends Enum<CotDetailBlockType> {
    public static final CotDetailBlockType ACTION = null;
    public static final CotDetailBlockType GROUP = null;
    public static final CotDetailBlockType STATUS = null;
    public static final CotDetailBlockType THINKING = null;
    public static final CotDetailBlockType TOOLCALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotDetailBlockType[] f414800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414801b = null;

    public static EnumEntries<CotDetailBlockType> getEntries() {
        return f414801b;
    }

    static {
        CotDetailBlockType r100 = new CotDetailBlockType("THINKING", 0);
        THINKING = r100;
        CotDetailBlockType r101 = new CotDetailBlockType("GROUP", 1);
        GROUP = r101;
        CotDetailBlockType r102 = new CotDetailBlockType("TOOLCALL", 2);
        TOOLCALL = r102;
        CotDetailBlockType r103 = new CotDetailBlockType("ACTION", 3);
        ACTION = r103;
        CotDetailBlockType r104 = new CotDetailBlockType(CommonConstant.RETKEY.STATUS, 4);
        STATUS = r104;
        CotDetailBlockType[] r105 = {r100, r101, r102, r103, r104};
        f414800a = r105;
        f414801b = EnumEntriesKt.enumEntries(r105);
    }

    public static CotDetailBlockType[] values() {
        return (CotDetailBlockType[]) f414800a.clone();
    }

    public static CotDetailBlockType valueOf(String r100) {
        return (CotDetailBlockType) r27.a.a(CotDetailBlockType.class, r100);
    }

    public CotDetailBlockType(String r100, int r101) {
        super(r100, r101);
    }
}
