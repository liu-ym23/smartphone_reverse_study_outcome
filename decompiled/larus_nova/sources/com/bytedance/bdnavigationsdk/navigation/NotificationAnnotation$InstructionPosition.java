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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NotificationAnnotation$InstructionPosition;", "", "<init>", "(Ljava/lang/String;I)V", "StepEnter", "Step3000mExit", "Step2000mExit", "Step1000mExit", "Step500mExit", "Step200mExit", "Step100mExit", "Step50mExit", "Step30mExit", "Step20mExit", "StepExit", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum NotificationAnnotation$InstructionPosition extends Enum<NotificationAnnotation$InstructionPosition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NotificationAnnotation$InstructionPosition[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("Step1000mExit")
    public static final NotificationAnnotation$InstructionPosition Step1000mExit = null;

    @SerialName("Step100mExit")
    public static final NotificationAnnotation$InstructionPosition Step100mExit = null;

    @SerialName("Step2000mExit")
    public static final NotificationAnnotation$InstructionPosition Step2000mExit = null;

    @SerialName("Step200mExit")
    public static final NotificationAnnotation$InstructionPosition Step200mExit = null;

    @SerialName("Step20mExit")
    public static final NotificationAnnotation$InstructionPosition Step20mExit = null;

    @SerialName("Step3000mExit")
    public static final NotificationAnnotation$InstructionPosition Step3000mExit = null;

    @SerialName("Step30mExit")
    public static final NotificationAnnotation$InstructionPosition Step30mExit = null;

    @SerialName("Step500mExit")
    public static final NotificationAnnotation$InstructionPosition Step500mExit = null;

    @SerialName("Step50mExit")
    public static final NotificationAnnotation$InstructionPosition Step50mExit = null;

    @SerialName("StepEnter")
    public static final NotificationAnnotation$InstructionPosition StepEnter = null;

    @SerialName("StepExit")
    public static final NotificationAnnotation$InstructionPosition StepExit = null;

    public static EnumEntries<NotificationAnnotation$InstructionPosition> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.bdnavigationsdk.navigation.NotificationAnnotation$InstructionPosition$a] */
    static {
        NotificationAnnotation$InstructionPosition r100 = new NotificationAnnotation$InstructionPosition("StepEnter", 0);
        StepEnter = r100;
        NotificationAnnotation$InstructionPosition r101 = new NotificationAnnotation$InstructionPosition("Step3000mExit", 1);
        Step3000mExit = r101;
        NotificationAnnotation$InstructionPosition r102 = new NotificationAnnotation$InstructionPosition("Step2000mExit", 2);
        Step2000mExit = r102;
        NotificationAnnotation$InstructionPosition r103 = new NotificationAnnotation$InstructionPosition("Step1000mExit", 3);
        Step1000mExit = r103;
        NotificationAnnotation$InstructionPosition r104 = new NotificationAnnotation$InstructionPosition("Step500mExit", 4);
        Step500mExit = r104;
        NotificationAnnotation$InstructionPosition r105 = new NotificationAnnotation$InstructionPosition("Step200mExit", 5);
        Step200mExit = r105;
        NotificationAnnotation$InstructionPosition r110 = new NotificationAnnotation$InstructionPosition("Step100mExit", 6);
        Step100mExit = r110;
        NotificationAnnotation$InstructionPosition r111 = new NotificationAnnotation$InstructionPosition("Step50mExit", 7);
        Step50mExit = r111;
        NotificationAnnotation$InstructionPosition r112 = new NotificationAnnotation$InstructionPosition("Step30mExit", 8);
        Step30mExit = r112;
        NotificationAnnotation$InstructionPosition r113 = new NotificationAnnotation$InstructionPosition("Step20mExit", 9);
        Step20mExit = r113;
        NotificationAnnotation$InstructionPosition r114 = new NotificationAnnotation$InstructionPosition("StepExit", 10);
        StepExit = r114;
        NotificationAnnotation$InstructionPosition[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        $VALUES = r115;
        $ENTRIES = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s());
    }

    public static NotificationAnnotation$InstructionPosition[] values() {
        return (NotificationAnnotation$InstructionPosition[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NotificationAnnotation$InstructionPosition valueOf(String r100) {
        return (NotificationAnnotation$InstructionPosition) r27.a.a(NotificationAnnotation$InstructionPosition.class, r100);
    }

    public NotificationAnnotation$InstructionPosition(String r100, int r101) {
        super(r100, r101);
    }
}
