package com.bytedance.bdnavigationsdk.navigation;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class InstructionAction {
    public static final b Companion = null;
    public static final juc.d<Object>[] d = null;
    public final ActionMode a;
    public final ActionType b;
    public final String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/InstructionAction$ActionMode;", "", "<init>", "(Ljava/lang/String;I)V", "FromTypeToContent", "FromContentToType", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final enum ActionMode extends Enum<ActionMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ActionMode[] $VALUES = null;
        private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
        public static final a Companion = null;

        @SerialName("FromContentToType")
        public static final ActionMode FromContentToType = null;

        @SerialName("FromTypeToContent")
        public static final ActionMode FromTypeToContent = null;

        public static final class a {
            public a() {
            }

            public final juc.d<ActionMode> serializer() {
                return (juc.d) ActionMode.access$get$cachedSerializer$delegate$cp().getValue();
            }
        }

        public static EnumEntries<ActionMode> getEntries() {
            return $ENTRIES;
        }

        static {
            ActionMode r0 = new ActionMode("FromTypeToContent", 0);
            FromTypeToContent = r0;
            ActionMode r1 = new ActionMode("FromContentToType", 1);
            FromContentToType = r1;
            ActionMode[] r3 = {r0, r1};
            $VALUES = r3;
            $ENTRIES = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new com.bytedance.bdnavigationsdk.navigation.b());
        }

        public static ActionMode[] values() {
            return (ActionMode[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public static ActionMode valueOf(String r1) {
            return (ActionMode) r27.a.a(ActionMode.class, r1);
        }

        public ActionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\b\u0087\u0081\u0002\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00015B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4¨\u00066"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/InstructionAction$ActionType;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "Unknown", "UTurn", "SharpRight", "Right", "SlightRight", "Straight", "SlightLeft", "Left", "SharpLeft", "Along", "Pass", "Up", "Down", "Before", "After", "Enter", "Exit", "In", "Out", "Depart", "Arrive", "Move", "Yaw", "Reroute", "Toward", "Arrived", "Now", "Immediate", "Ahead", "Behind", "NewRoute", "StartLocation", "EndLocation", "CrossLink", "ToAcrossRoad", "ToDiagonalAcrossRoad", "AfterWard", "Start", "End", "ArriveWayPointAround", "ArriveWayPoint", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ActionType[] $VALUES = null;
        private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;

        @SerialName("After")
        public static final ActionType After = null;

        @SerialName("AfterWard")
        public static final ActionType AfterWard = null;

        @SerialName("Ahead")
        public static final ActionType Ahead = null;

        @SerialName("Along")
        public static final ActionType Along = null;

        @SerialName("Arrive")
        public static final ActionType Arrive = null;

        @SerialName("ArriveWayPoint")
        public static final ActionType ArriveWayPoint = null;

        @SerialName("ArriveWayPointAround")
        public static final ActionType ArriveWayPointAround = null;

        @SerialName("Arrived")
        public static final ActionType Arrived = null;

        @SerialName("Before")
        public static final ActionType Before = null;

        @SerialName("Behind")
        public static final ActionType Behind = null;
        public static final a Companion = null;

        @SerialName("CrossLink")
        public static final ActionType CrossLink = null;

        @SerialName("Depart")
        public static final ActionType Depart = null;

        @SerialName("Down")
        public static final ActionType Down = null;

        @SerialName("End")
        public static final ActionType End = null;

        @SerialName("EndLocation")
        public static final ActionType EndLocation = null;

        @SerialName("Enter")
        public static final ActionType Enter = null;

        @SerialName("Exit")
        public static final ActionType Exit = null;

        @SerialName("Immediate")
        public static final ActionType Immediate = null;

        @SerialName("In")
        public static final ActionType In = null;

        @SerialName("Left")
        public static final ActionType Left = null;

        @SerialName("Move")
        public static final ActionType Move = null;

        @SerialName("NewRoute")
        public static final ActionType NewRoute = null;

        @SerialName("Now")
        public static final ActionType Now = null;

        @SerialName("Out")
        public static final ActionType Out = null;

        @SerialName("Pass")
        public static final ActionType Pass = null;

        @SerialName("Reroute")
        public static final ActionType Reroute = null;

        @SerialName("Right")
        public static final ActionType Right = null;

        @SerialName("SharpLeft")
        public static final ActionType SharpLeft = null;

        @SerialName("SharpRight")
        public static final ActionType SharpRight = null;

        @SerialName("SlightLeft")
        public static final ActionType SlightLeft = null;

        @SerialName("SlightRight")
        public static final ActionType SlightRight = null;

        @SerialName("Start")
        public static final ActionType Start = null;

        @SerialName("StartLocation")
        public static final ActionType StartLocation = null;

        @SerialName("Straight")
        public static final ActionType Straight = null;

        @SerialName("ToAcrossRoad")
        public static final ActionType ToAcrossRoad = null;

        @SerialName("ToDiagonalAcrossRoad")
        public static final ActionType ToDiagonalAcrossRoad = null;

        @SerialName("Toward")
        public static final ActionType Toward = null;

        @SerialName("UTurn")
        public static final ActionType UTurn = null;

        @SerialName("Unknown")
        public static final ActionType Unknown = null;

        @SerialName("Up")
        public static final ActionType Up = null;

        @SerialName("Yaw")
        public static final ActionType Yaw = null;
        private final int code;
        private final String description;

        public static final class a {
            public a() {
            }

            public final juc.d<ActionType> serializer() {
                return (juc.d) ActionType.access$get$cachedSerializer$delegate$cp().getValue();
            }
        }

        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }

        static {
            ActionType r0 = new ActionType("Unknown", 0, -1, "未知");
            Unknown = r0;
            ActionType r1 = new ActionType("UTurn", 1, 0, "掉头");
            UTurn = r1;
            ActionType r2 = new ActionType("SharpRight", 2, 1, "向右后方直行");
            SharpRight = r2;
            ActionType r3 = new ActionType("Right", 3, 2, "右转");
            Right = r3;
            ActionType r6 = new ActionType("SlightRight", 4, 3, "向右前方直行");
            SlightRight = r6;
            ActionType r8 = new ActionType("Straight", 5, 4, "直行");
            Straight = r8;
            ActionType r10 = new ActionType("SlightLeft", 6, 5, "向左前方直行");
            SlightLeft = r10;
            ActionType r12 = new ActionType("Left", 7, 6, "左转");
            Left = r12;
            ActionType r13 = new ActionType("SharpLeft", 8, 7, "向左后方直行");
            SharpLeft = r13;
            ActionType r14 = new ActionType("Along", 9, 8, "沿");
            Along = r14;
            ActionType r11 = new ActionType("Pass", 10, 9, "通过");
            Pass = r11;
            ActionType r9 = new ActionType("Up", 11, 10, "上");
            Up = r9;
            ActionType r7 = new ActionType("Down", 12, 11, "下");
            Down = r7;
            ActionType r5 = new ActionType("Before", 13, 12, "前");
            Before = r5;
            ActionType r4 = new ActionType("After", 14, 13, "后");
            After = r4;
            ActionType r15 = new ActionType("Enter", 15, 14, "进入");
            Enter = r15;
            ActionType r16 = new ActionType("Exit", 16, 15, "离开");
            Exit = r16;
            ActionType r17 = new ActionType("In", 17, 16, "进");
            In = r17;
            ActionType r18 = new ActionType("Out", 18, 17, "出");
            Out = r18;
            ActionType r19 = new ActionType("Depart", 19, 18, "出发");
            Depart = r19;
            ActionType r20 = new ActionType("Arrive", 20, 19, "到达目的地");
            Arrive = r20;
            ActionType r21 = new ActionType("Move", 21, 20, "请到路线起点");
            Move = r21;
            ActionType r22 = new ActionType("Yaw", 22, 21, "已偏航");
            Yaw = r22;
            ActionType r23 = new ActionType("Reroute", 23, 22, "已经重新规划路线");
            Reroute = r23;
            ActionType r24 = new ActionType("Toward", 24, 23, "向");
            Toward = r24;
            ActionType r25 = new ActionType("Arrived", 25, 24, "目的地在您附近,导航结束");
            Arrived = r25;
            ActionType r26 = new ActionType("Now", 26, 25, "现在");
            Now = r26;
            ActionType r27 = new ActionType("Immediate", 27, 26, "立即");
            Immediate = r27;
            ActionType r28 = new ActionType("Ahead", 28, 27, "前方");
            Ahead = r28;
            ActionType r29 = new ActionType("Behind", 29, 28, "后方");
            Behind = r29;
            ActionType r30 = new ActionType("NewRoute", 30, 29, "新路线");
            NewRoute = r30;
            ActionType r31 = new ActionType("StartLocation", 31, 30, "起点");
            StartLocation = r31;
            ActionType r32 = new ActionType("EndLocation", 32, 31, "终点");
            EndLocation = r32;
            ActionType r33 = new ActionType("CrossLink", 33, 32, "路口");
            CrossLink = r33;
            ActionType r34 = new ActionType("ToAcrossRoad", 34, 33, "到马路对面");
            ToAcrossRoad = r34;
            ActionType r35 = new ActionType("ToDiagonalAcrossRoad", 35, 34, "到马路斜对面");
            ToDiagonalAcrossRoad = r35;
            ActionType r36 = new ActionType("AfterWard", 36, 35, "随后");
            AfterWard = r36;
            ActionType r37 = new ActionType("Start", 37, 36, "开始");
            Start = r37;
            ActionType r38 = new ActionType("End", 38, 37, "结束");
            End = r38;
            ActionType r39 = new ActionType("ArriveWayPointAround", 39, 38, "到达途经点附近");
            ArriveWayPointAround = r39;
            ActionType r40 = new ActionType("ArriveWayPoint", 40, 39, "到达途经点");
            ArriveWayPoint = r40;
            ActionType[] r41 = {r0, r1, r2, r3, r6, r8, r10, r12, r13, r14, r11, r9, r7, r5, r4, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40};
            $VALUES = r41;
            $ENTRIES = EnumEntriesKt.enumEntries(r41);
            Companion = new a();
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new com.bytedance.bdnavigationsdk.navigation.c());
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.description = r4;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<InstructionAction> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.InstructionAction", r0, 3);
            r1.j("actionMode", false);
            r1.j("actionType", false);
            r1.j("actionContent", false);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = InstructionAction.d;
            return new juc.d[]{r0[0], r0[1], v2.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            juc.c[] r1 = InstructionAction.d;
            ActionMode r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            ActionMode r2 = (ActionMode) r14.decodeSerializableElement(r0, 0, r1[0], null);
            ActionType r3 = (ActionType) r14.decodeSerializableElement(r0, 1, r1[1], null);
            String r4 = r14.decodeStringElement(r0, 2);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new InstructionAction(r5, r2, r3, r4);
        L5:
            ActionType r7 = null;
            String r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r14.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r6 = (ActionMode) r14.decodeSerializableElement(r0, 0, r1[0], r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (ActionType) r14.decodeSerializableElement(r0, 1, r1[1], r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = r14.decodeStringElement(r0, 2);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r3 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            InstructionAction r8 = (InstructionAction) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            juc.n[] r1 = InstructionAction.d;
            r9.encodeSerializableElement(r0, 0, r1[0], r8.a);
            r9.encodeSerializableElement(r0, 1, r1[1], r8.b);
            r9.encodeStringElement(r0, 2, r8.c);
            r9.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<InstructionAction> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionMode.values().length];
            r0[ActionMode.FromTypeToContent.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ActionMode.FromContentToType.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InstructionAction) == true) goto L8;
        return false;
    L8:
        InstructionAction r6 = (InstructionAction) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    static {
        Companion = new b();
        d = new juc.d[]{ActionMode.Companion.serializer(), ActionType.Companion.serializer(), null};
    }

    public final String a() {
        if (this.b == ActionType.Unknown) goto L5;
        int r0 = c.a[this.a.ordinal()];
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L12;
        return this.c + this.b.getDescription();
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return this.b.getDescription() + this.c;
    L5:
        return this.c;
    }

    public final String toString() {
        return "InstructionAction{actionMode=" + this.a + ", actionType=" + this.b + ", actionContent='" + this.c + "'}";
    }

    public InstructionAction(ActionMode r2, ActionType r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "actionMode");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "actionContent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public InstructionAction(int r3, ActionMode r4, ActionType r5, String r6) {
        if (7 != (r3 & 7)) goto L6;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        return;
    L6:
        b2.b(r3, 7, a.b);
        throw null;
    }
}
