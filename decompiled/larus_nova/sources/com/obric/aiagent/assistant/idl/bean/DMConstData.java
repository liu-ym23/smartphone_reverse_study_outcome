package com.obric.aiagent.assistant.idl.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData;", "", "<init>", "()V", "DMTaskType", "DMSimpleTaskState", "DMOAutoTaskState", "DMComplexTaskState", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DMConstData {
    public static final DMConstData INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMComplexTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Queueing", "Thinking", "CallUser", "Clarify", "ClarifyAck", "TakingOver", "ThinkingCompleted", "Terminated", "TTS", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMComplexTaskState extends Enum<DMComplexTaskState> {
        public static final DMComplexTaskState CallUser = null;
        public static final DMComplexTaskState Clarify = null;
        public static final DMComplexTaskState ClarifyAck = null;
        public static final DMComplexTaskState Idle = null;
        public static final DMComplexTaskState Queueing = null;
        public static final DMComplexTaskState TTS = null;
        public static final DMComplexTaskState TakingOver = null;
        public static final DMComplexTaskState Terminated = null;
        public static final DMComplexTaskState Thinking = null;
        public static final DMComplexTaskState ThinkingCompleted = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DMComplexTaskState[] f384497a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384498b = null;

        public static EnumEntries<DMComplexTaskState> getEntries() {
            return f384498b;
        }

        static {
            DMComplexTaskState r100 = new DMComplexTaskState("Idle", 0);
            Idle = r100;
            DMComplexTaskState r101 = new DMComplexTaskState("Queueing", 1);
            Queueing = r101;
            DMComplexTaskState r102 = new DMComplexTaskState("Thinking", 2);
            Thinking = r102;
            DMComplexTaskState r103 = new DMComplexTaskState("CallUser", 3);
            CallUser = r103;
            DMComplexTaskState r104 = new DMComplexTaskState("Clarify", 4);
            Clarify = r104;
            DMComplexTaskState r105 = new DMComplexTaskState("ClarifyAck", 5);
            ClarifyAck = r105;
            DMComplexTaskState r110 = new DMComplexTaskState("TakingOver", 6);
            TakingOver = r110;
            DMComplexTaskState r111 = new DMComplexTaskState("ThinkingCompleted", 7);
            ThinkingCompleted = r111;
            DMComplexTaskState r112 = new DMComplexTaskState("Terminated", 8);
            Terminated = r112;
            DMComplexTaskState r113 = new DMComplexTaskState("TTS", 9);
            TTS = r113;
            DMComplexTaskState[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f384497a = r114;
            f384498b = EnumEntriesKt.enumEntries(r114);
        }

        public static DMComplexTaskState[] values() {
            return (DMComplexTaskState[]) f384497a.clone();
        }

        public static DMComplexTaskState valueOf(String r100) {
            return (DMComplexTaskState) a.a(DMComplexTaskState.class, r100);
        }

        public DMComplexTaskState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMOAutoTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Processing", "Clarify", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMOAutoTaskState extends Enum<DMOAutoTaskState> {
        public static final DMOAutoTaskState Clarify = null;
        public static final DMOAutoTaskState Idle = null;
        public static final DMOAutoTaskState Processing = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DMOAutoTaskState[] f384499a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384500b = null;

        public static EnumEntries<DMOAutoTaskState> getEntries() {
            return f384500b;
        }

        static {
            DMOAutoTaskState r100 = new DMOAutoTaskState("Idle", 0);
            Idle = r100;
            DMOAutoTaskState r101 = new DMOAutoTaskState("Processing", 1);
            Processing = r101;
            DMOAutoTaskState r102 = new DMOAutoTaskState("Clarify", 2);
            Clarify = r102;
            DMOAutoTaskState[] r103 = {r100, r101, r102};
            f384499a = r103;
            f384500b = EnumEntriesKt.enumEntries(r103);
        }

        public static DMOAutoTaskState[] values() {
            return (DMOAutoTaskState[]) f384499a.clone();
        }

        public static DMOAutoTaskState valueOf(String r100) {
            return (DMOAutoTaskState) a.a(DMOAutoTaskState.class, r100);
        }

        public DMOAutoTaskState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMSimpleTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Processing", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMSimpleTaskState extends Enum<DMSimpleTaskState> {
        public static final DMSimpleTaskState Idle = null;
        public static final DMSimpleTaskState Processing = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DMSimpleTaskState[] f384501a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384502b = null;

        public static EnumEntries<DMSimpleTaskState> getEntries() {
            return f384502b;
        }

        static {
            DMSimpleTaskState r100 = new DMSimpleTaskState("Idle", 0);
            Idle = r100;
            DMSimpleTaskState r101 = new DMSimpleTaskState("Processing", 1);
            Processing = r101;
            DMSimpleTaskState[] r102 = {r100, r101};
            f384501a = r102;
            f384502b = EnumEntriesKt.enumEntries(r102);
        }

        public static DMSimpleTaskState[] values() {
            return (DMSimpleTaskState[]) f384501a.clone();
        }

        public static DMSimpleTaskState valueOf(String r100) {
            return (DMSimpleTaskState) a.a(DMSimpleTaskState.class, r100);
        }

        public DMSimpleTaskState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMTaskType;", "", "<init>", "(Ljava/lang/String;I)V", "SIMPLE", "OAUTO", "COMPLEX", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMTaskType extends Enum<DMTaskType> {
        public static final DMTaskType COMPLEX = null;
        public static final DMTaskType OAUTO = null;
        public static final DMTaskType SIMPLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DMTaskType[] f384503a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f384504b = null;

        public static EnumEntries<DMTaskType> getEntries() {
            return f384504b;
        }

        static {
            DMTaskType r100 = new DMTaskType("SIMPLE", 0);
            SIMPLE = r100;
            DMTaskType r101 = new DMTaskType("OAUTO", 1);
            OAUTO = r101;
            DMTaskType r102 = new DMTaskType("COMPLEX", 2);
            COMPLEX = r102;
            DMTaskType[] r103 = {r100, r101, r102};
            f384503a = r103;
            f384504b = EnumEntriesKt.enumEntries(r103);
        }

        public static DMTaskType[] values() {
            return (DMTaskType[]) f384503a.clone();
        }

        public static DMTaskType valueOf(String r100) {
            return (DMTaskType) a.a(DMTaskType.class, r100);
        }

        public DMTaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        INSTANCE = new DMConstData();
    }

    private DMConstData() {
    }
}
