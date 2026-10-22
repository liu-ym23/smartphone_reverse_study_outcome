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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NotificationAnnotation$InstructionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Pending", "Completed", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum NotificationAnnotation$InstructionStatus extends Enum<NotificationAnnotation$InstructionStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NotificationAnnotation$InstructionStatus[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("Completed")
    public static final NotificationAnnotation$InstructionStatus Completed = null;

    @SerialName("Pending")
    public static final NotificationAnnotation$InstructionStatus Pending = null;

    public static EnumEntries<NotificationAnnotation$InstructionStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.bdnavigationsdk.navigation.NotificationAnnotation$InstructionStatus$a] */
    static {
        NotificationAnnotation$InstructionStatus r100 = new NotificationAnnotation$InstructionStatus("Pending", 0);
        Pending = r100;
        NotificationAnnotation$InstructionStatus r101 = new NotificationAnnotation$InstructionStatus("Completed", 1);
        Completed = r101;
        NotificationAnnotation$InstructionStatus[] r102 = {r100, r101};
        $VALUES = r102;
        $ENTRIES = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t());
    }

    public static NotificationAnnotation$InstructionStatus[] values() {
        return (NotificationAnnotation$InstructionStatus[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NotificationAnnotation$InstructionStatus valueOf(String r100) {
        return (NotificationAnnotation$InstructionStatus) r27.a.a(NotificationAnnotation$InstructionStatus.class, r100);
    }

    public NotificationAnnotation$InstructionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
