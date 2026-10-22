package com.ss.android.lark.biz.officesdk.im.share;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanelType;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "MERGE_FORWARD", "SINGLE_FORWARD", "DELETE", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IOfficeSDKSharePanelType extends Enum<IOfficeSDKSharePanelType> {
    public static final IOfficeSDKSharePanelType ASK_DOUBAO = null;
    public static final IOfficeSDKSharePanelType DELETE = null;
    public static final IOfficeSDKSharePanelType MERGE_FORWARD = null;
    public static final IOfficeSDKSharePanelType SINGLE_FORWARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IOfficeSDKSharePanelType[] f410615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410616b = null;

    public static EnumEntries<IOfficeSDKSharePanelType> getEntries() {
        return f410616b;
    }

    static {
        IOfficeSDKSharePanelType r100 = new IOfficeSDKSharePanelType("ASK_DOUBAO", 0);
        ASK_DOUBAO = r100;
        IOfficeSDKSharePanelType r101 = new IOfficeSDKSharePanelType("MERGE_FORWARD", 1);
        MERGE_FORWARD = r101;
        IOfficeSDKSharePanelType r102 = new IOfficeSDKSharePanelType("SINGLE_FORWARD", 2);
        SINGLE_FORWARD = r102;
        IOfficeSDKSharePanelType r103 = new IOfficeSDKSharePanelType("DELETE", 3);
        DELETE = r103;
        IOfficeSDKSharePanelType[] r104 = {r100, r101, r102, r103};
        f410615a = r104;
        f410616b = EnumEntriesKt.enumEntries(r104);
    }

    public static IOfficeSDKSharePanelType[] values() {
        return (IOfficeSDKSharePanelType[]) f410615a.clone();
    }

    public static IOfficeSDKSharePanelType valueOf(String r100) {
        return (IOfficeSDKSharePanelType) a.a(IOfficeSDKSharePanelType.class, r100);
    }

    public IOfficeSDKSharePanelType(String r100, int r101) {
        super(r100, r101);
    }
}
