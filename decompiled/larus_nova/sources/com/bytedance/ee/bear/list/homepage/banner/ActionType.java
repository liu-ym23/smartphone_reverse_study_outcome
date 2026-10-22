package com.bytedance.ee.bear.list.homepage.banner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_BITABLE", "CREATE_NEW_SURVEY", "CREATE_FORM", "OPEN_TEMPLATE", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType CREATE_BITABLE = null;
    public static final ActionType CREATE_FORM = null;
    public static final ActionType CREATE_NEW_SURVEY = null;
    public static final ActionType OPEN_TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f228255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f228256b = null;

    public static EnumEntries<ActionType> getEntries() {
        return f228256b;
    }

    static {
        ActionType r100 = new ActionType("CREATE_BITABLE", 0);
        CREATE_BITABLE = r100;
        ActionType r101 = new ActionType("CREATE_NEW_SURVEY", 1);
        CREATE_NEW_SURVEY = r101;
        ActionType r102 = new ActionType("CREATE_FORM", 2);
        CREATE_FORM = r102;
        ActionType r103 = new ActionType("OPEN_TEMPLATE", 3);
        OPEN_TEMPLATE = r103;
        ActionType[] r104 = {r100, r101, r102, r103};
        f228255a = r104;
        f228256b = EnumEntriesKt.enumEntries(r104);
    }

    public static ActionType[] values() {
        return (ActionType[]) f228255a.clone();
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public ActionType(String r100, int r101) {
        super(r100, r101);
    }
}
