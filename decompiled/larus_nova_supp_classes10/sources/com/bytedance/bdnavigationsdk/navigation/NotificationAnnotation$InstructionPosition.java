package com.bytedance.bdnavigationsdk.navigation;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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
        NotificationAnnotation$InstructionPosition r0 = new NotificationAnnotation$InstructionPosition("StepEnter", 0);
        StepEnter = r0;
        NotificationAnnotation$InstructionPosition r1 = new NotificationAnnotation$InstructionPosition("Step3000mExit", 1);
        Step3000mExit = r1;
        NotificationAnnotation$InstructionPosition r3 = new NotificationAnnotation$InstructionPosition("Step2000mExit", 2);
        Step2000mExit = r3;
        NotificationAnnotation$InstructionPosition r5 = new NotificationAnnotation$InstructionPosition("Step1000mExit", 3);
        Step1000mExit = r5;
        NotificationAnnotation$InstructionPosition r7 = new NotificationAnnotation$InstructionPosition("Step500mExit", 4);
        Step500mExit = r7;
        NotificationAnnotation$InstructionPosition r9 = new NotificationAnnotation$InstructionPosition("Step200mExit", 5);
        Step200mExit = r9;
        NotificationAnnotation$InstructionPosition r11 = new NotificationAnnotation$InstructionPosition("Step100mExit", 6);
        Step100mExit = r11;
        NotificationAnnotation$InstructionPosition r13 = new NotificationAnnotation$InstructionPosition("Step50mExit", 7);
        Step50mExit = r13;
        NotificationAnnotation$InstructionPosition r15 = new NotificationAnnotation$InstructionPosition("Step30mExit", 8);
        Step30mExit = r15;
        NotificationAnnotation$InstructionPosition r14 = new NotificationAnnotation$InstructionPosition("Step20mExit", 9);
        Step20mExit = r14;
        NotificationAnnotation$InstructionPosition r12 = new NotificationAnnotation$InstructionPosition("StepExit", 10);
        StepExit = r12;
        NotificationAnnotation$InstructionPosition[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s());
    }

    public static NotificationAnnotation$InstructionPosition[] values() {
        return (NotificationAnnotation$InstructionPosition[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NotificationAnnotation$InstructionPosition valueOf(String r1) {
        return (NotificationAnnotation$InstructionPosition) r27.a.a(NotificationAnnotation$InstructionPosition.class, r1);
    }

    public NotificationAnnotation$InstructionPosition(String r1, int r2) {
        super(r1, r2);
    }
}
