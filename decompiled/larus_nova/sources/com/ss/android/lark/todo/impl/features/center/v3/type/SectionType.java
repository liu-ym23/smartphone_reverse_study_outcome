package com.ss.android.lark.todo.impl.features.center.v3.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "DUE_TIME_OVER_SECTION", "DUE_TIME_TODAY_SECTION", "DUE_TIME_TOMORROW_SECTION", "DUE_TIME_THIS_WEEK_SECTION", "DUE_TIME_NEXT_WEEK_SECTION", "DUE_TIME_FUTURE_SECTION", "NO_DUE_TIME_SECTION", "CREATE_TIME_TODAY_SECTION", "CREATE_TIME_YESTERDAY_SECTION", "CREATE_TIME_THIS_WEEK_SECTION", "CREATE_TIME_LAST_WEEK_SECTION", "CREATE_TIME_EARLY_SECTION", "ASSIGN_TO_ME_SECTION", "ASSIGN_FROM_ME_SECTION", "OTHER_COMPLETE", "DEFINED_SECTION", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SectionType extends Enum<SectionType> {
    public static final SectionType ASSIGN_FROM_ME_SECTION = null;
    public static final SectionType ASSIGN_TO_ME_SECTION = null;
    public static final SectionType CREATE_TIME_EARLY_SECTION = null;
    public static final SectionType CREATE_TIME_LAST_WEEK_SECTION = null;
    public static final SectionType CREATE_TIME_THIS_WEEK_SECTION = null;
    public static final SectionType CREATE_TIME_TODAY_SECTION = null;
    public static final SectionType CREATE_TIME_YESTERDAY_SECTION = null;
    public static final SectionType DEFINED_SECTION = null;
    public static final SectionType DUE_TIME_FUTURE_SECTION = null;
    public static final SectionType DUE_TIME_NEXT_WEEK_SECTION = null;
    public static final SectionType DUE_TIME_OVER_SECTION = null;
    public static final SectionType DUE_TIME_THIS_WEEK_SECTION = null;
    public static final SectionType DUE_TIME_TODAY_SECTION = null;
    public static final SectionType DUE_TIME_TOMORROW_SECTION = null;
    public static final SectionType NO_DUE_TIME_SECTION = null;
    public static final SectionType OTHER_COMPLETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SectionType[] f441766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441767b = null;

    public static EnumEntries<SectionType> getEntries() {
        return f441767b;
    }

    static {
        SectionType r100 = new SectionType("DUE_TIME_OVER_SECTION", 0);
        DUE_TIME_OVER_SECTION = r100;
        SectionType r101 = new SectionType("DUE_TIME_TODAY_SECTION", 1);
        DUE_TIME_TODAY_SECTION = r101;
        SectionType r102 = new SectionType("DUE_TIME_TOMORROW_SECTION", 2);
        DUE_TIME_TOMORROW_SECTION = r102;
        SectionType r103 = new SectionType("DUE_TIME_THIS_WEEK_SECTION", 3);
        DUE_TIME_THIS_WEEK_SECTION = r103;
        SectionType r104 = new SectionType("DUE_TIME_NEXT_WEEK_SECTION", 4);
        DUE_TIME_NEXT_WEEK_SECTION = r104;
        SectionType r105 = new SectionType("DUE_TIME_FUTURE_SECTION", 5);
        DUE_TIME_FUTURE_SECTION = r105;
        SectionType r110 = new SectionType("NO_DUE_TIME_SECTION", 6);
        NO_DUE_TIME_SECTION = r110;
        SectionType r111 = new SectionType("CREATE_TIME_TODAY_SECTION", 7);
        CREATE_TIME_TODAY_SECTION = r111;
        SectionType r112 = new SectionType("CREATE_TIME_YESTERDAY_SECTION", 8);
        CREATE_TIME_YESTERDAY_SECTION = r112;
        SectionType r113 = new SectionType("CREATE_TIME_THIS_WEEK_SECTION", 9);
        CREATE_TIME_THIS_WEEK_SECTION = r113;
        SectionType r114 = new SectionType("CREATE_TIME_LAST_WEEK_SECTION", 10);
        CREATE_TIME_LAST_WEEK_SECTION = r114;
        SectionType r115 = new SectionType("CREATE_TIME_EARLY_SECTION", 11);
        CREATE_TIME_EARLY_SECTION = r115;
        SectionType r106 = new SectionType("ASSIGN_TO_ME_SECTION", 12);
        ASSIGN_TO_ME_SECTION = r106;
        SectionType r107 = new SectionType("ASSIGN_FROM_ME_SECTION", 13);
        ASSIGN_FROM_ME_SECTION = r107;
        SectionType r108 = new SectionType("OTHER_COMPLETE", 14);
        OTHER_COMPLETE = r108;
        SectionType r109 = new SectionType("DEFINED_SECTION", 15);
        DEFINED_SECTION = r109;
        SectionType[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
        f441766a = r116;
        f441767b = EnumEntriesKt.enumEntries(r116);
    }

    public static SectionType[] values() {
        return (SectionType[]) f441766a.clone();
    }

    public static SectionType valueOf(String r100) {
        return (SectionType) a.a(SectionType.class, r100);
    }

    public SectionType(String r100, int r101) {
        super(r100, r101);
    }
}
