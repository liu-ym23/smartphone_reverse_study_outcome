package com.bytedance.bdnavigationsdk.navigation;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NotificationAnnotation$InstructionType;", "", "<init>", "(Ljava/lang/String;I)V", "Depart", "Through", "Arrive", "DepartAndArrive", "ArriveWayPoint", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum NotificationAnnotation$InstructionType extends Enum<NotificationAnnotation$InstructionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NotificationAnnotation$InstructionType[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;

    @SerialName("Arrive")
    public static final NotificationAnnotation$InstructionType Arrive = null;

    @SerialName("ArriveWayPoint")
    public static final NotificationAnnotation$InstructionType ArriveWayPoint = null;
    public static final a Companion = null;

    @SerialName("Depart")
    public static final NotificationAnnotation$InstructionType Depart = null;

    @SerialName("DepartAndArrive")
    public static final NotificationAnnotation$InstructionType DepartAndArrive = null;

    @SerialName("Through")
    public static final NotificationAnnotation$InstructionType Through = null;

    public static EnumEntries<NotificationAnnotation$InstructionType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.bdnavigationsdk.navigation.NotificationAnnotation$InstructionType$a] */
    static {
        NotificationAnnotation$InstructionType r100 = new NotificationAnnotation$InstructionType("Depart", 0);
        Depart = r100;
        NotificationAnnotation$InstructionType r101 = new NotificationAnnotation$InstructionType("Through", 1);
        Through = r101;
        NotificationAnnotation$InstructionType r102 = new NotificationAnnotation$InstructionType("Arrive", 2);
        Arrive = r102;
        NotificationAnnotation$InstructionType r103 = new NotificationAnnotation$InstructionType("DepartAndArrive", 3);
        DepartAndArrive = r103;
        NotificationAnnotation$InstructionType r104 = new NotificationAnnotation$InstructionType("ArriveWayPoint", 4);
        ArriveWayPoint = r104;
        NotificationAnnotation$InstructionType[] r105 = {r100, r101, r102, r103, r104};
        $VALUES = r105;
        $ENTRIES = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new u());
    }

    public static NotificationAnnotation$InstructionType[] values() {
        return (NotificationAnnotation$InstructionType[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NotificationAnnotation$InstructionType valueOf(String r100) {
        return (NotificationAnnotation$InstructionType) r27.a.a(NotificationAnnotation$InstructionType.class, r100);
    }

    public NotificationAnnotation$InstructionType(String r100, int r101) {
        super(r100, r101);
    }
}
