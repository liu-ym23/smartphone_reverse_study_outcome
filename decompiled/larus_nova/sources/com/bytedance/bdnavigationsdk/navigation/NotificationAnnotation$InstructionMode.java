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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NotificationAnnotation$InstructionMode;", "", "<init>", "(Ljava/lang/String;I)V", "Turn", "Straight", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum NotificationAnnotation$InstructionMode extends Enum<NotificationAnnotation$InstructionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NotificationAnnotation$InstructionMode[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("Straight")
    public static final NotificationAnnotation$InstructionMode Straight = null;

    @SerialName("Turn")
    public static final NotificationAnnotation$InstructionMode Turn = null;

    public static EnumEntries<NotificationAnnotation$InstructionMode> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.bdnavigationsdk.navigation.NotificationAnnotation$InstructionMode$a] */
    static {
        NotificationAnnotation$InstructionMode r100 = new NotificationAnnotation$InstructionMode("Turn", 0);
        Turn = r100;
        NotificationAnnotation$InstructionMode r101 = new NotificationAnnotation$InstructionMode("Straight", 1);
        Straight = r101;
        NotificationAnnotation$InstructionMode[] r102 = {r100, r101};
        $VALUES = r102;
        $ENTRIES = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r());
    }

    public static NotificationAnnotation$InstructionMode[] values() {
        return (NotificationAnnotation$InstructionMode[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NotificationAnnotation$InstructionMode valueOf(String r100) {
        return (NotificationAnnotation$InstructionMode) r27.a.a(NotificationAnnotation$InstructionMode.class, r100);
    }

    public NotificationAnnotation$InstructionMode(String r100, int r101) {
        super(r100, r101);
    }
}
