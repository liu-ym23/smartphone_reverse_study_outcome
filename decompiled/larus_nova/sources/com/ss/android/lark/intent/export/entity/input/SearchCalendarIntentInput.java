package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(By\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\b\u0010'\u001a\u00020\u0007H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", DyPayConstant.KEY_START_TIME, "", "endTime", "roomDesc", "", "participants", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "participantIds", "agenda", "timeType", "Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "version", "Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDesc", "()Ljava/lang/String;", "getParticipants", "()Ljava/util/ArrayList;", "getParticipantIds", "getAgenda", "getTimeType", "()Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "getVersion", "()Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "isAllDataInvalid", "", "onlyHaveTime", "isParticipantsValid", "isTimePoint", "isTimeRange", "toString", "TimeType", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCalendarIntentInput extends IntentInput implements Serializable {
    private final String agenda;
    private final Long endTime;
    private final ArrayList<String> participantIds;
    private final ArrayList<String> participants;
    private final String roomDesc;
    private final Long startTime;
    private final TimeType timeType;
    private final IntentInputVersion version;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SEARCH_TIME_START", "SEARCH_TIME_RANGE", "toDescString", "", "Companion", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeType extends Enum<TimeType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TimeType[] $VALUES = null;
        public static final Companion Companion = null;
        public static final TimeType SEARCH_TIME_RANGE = null;
        public static final TimeType SEARCH_TIME_START = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType$Companion;", "", "<init>", "()V", "valueOf", "Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "value", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final TimeType valueOf(int r100) {
                TimeType r101 = TimeType.SEARCH_TIME_START;
                if (r100 == r101.getValue()) goto L10;
                TimeType r102 = TimeType.SEARCH_TIME_RANGE;
                if (r100 == r102.getValue()) goto L8;
                return r101;
            L8:
                return r102;
            L10:
                return r101;
            }
        }

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[TimeType.values().length];
                r100[TimeType.SEARCH_TIME_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[TimeType.SEARCH_TIME_RANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private static final /* synthetic */ TimeType[] $values() {
            return new TimeType[]{SEARCH_TIME_START, SEARCH_TIME_RANGE};
        }

        public static EnumEntries<TimeType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final TimeType valueOf(int r100) {
            return Companion.valueOf(r100);
        }

        static {
            SEARCH_TIME_START = new TimeType("SEARCH_TIME_START", 0, 0);
            SEARCH_TIME_RANGE = new TimeType("SEARCH_TIME_RANGE", 1, 1);
            TimeType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
            Companion = new Companion(null);
        }

        public static TimeType[] values() {
            return (TimeType[]) $VALUES.clone();
        }

        public final String toDescString() {
            int r100 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (r100 != 1) goto L5;
            return "time_start_point";
        L5:
            if (r100 != 2) goto L8;
            return "time_range";
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeType valueOf(String r100) {
            return (TimeType) a.a(TimeType.class, r100);
        }

        private TimeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    private final boolean isParticipantsValid() {
        ArrayList<String> r100 = this.participantIds;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L20;
        ArrayList<String> r102 = this.participants;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isTimePoint() {
        if (this.startTime != null) goto L5;
    L7:
        return false;
    L5:
        if (this.endTime != null) goto L7;
        return true;
    }

    public final boolean isTimeRange() {
        if (this.startTime != null) goto L7;
        if (this.endTime != null) goto L7;
    L9:
        return false;
    L7:
        if (isTimePoint() == true) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SearchCalendarIntentInput(startTime=");
        Object r101 = this.startTime;
        String r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(", endTime=");
        Object r103 = this.endTime;
        if (r103 != null) goto L8;
        r103 = "null";
    L8:
        r100.append(r103);
        r100.append(", roomDesc=");
        String r104 = this.roomDesc;
        if (r104 == null) goto L12;
        String r105 = knb.a.a(r104);
        if (r105 == null) goto L12;
    L13:
        r100.append(r105);
        r100.append(", participants=");
        Object r106 = this.participants;
        if (r106 != null) goto L17;
        r106 = "null";
    L17:
        r100.append(r106);
        r100.append(", participantIds = ");
        Object r107 = this.participantIds;
        if (r107 != null) goto L21;
        r107 = "null";
    L21:
        r100.append(r107);
        r100.append(", agenda=");
        String r108 = this.agenda;
        if (r108 == null) goto L25;
        String r109 = knb.a.a(r108);
        if (r109 == null) goto L25;
    L26:
        r100.append(r109);
        r100.append(", timeType=");
        TimeType r110 = this.timeType;
        if (r110 == null) goto L32;
        String r111 = r110.toDescString();
        if (r111 == null) goto L32;
        r102 = r111;
    L32:
        r100.append(r102);
        r100.append(", version=");
        r100.append(this.version);
        r100.append(')');
        return r100.toString();
    L25:
        r109 = "null";
    L12:
        r105 = "null";
        goto L13
    }

    public final boolean isAllDataInvalid() {
        if (isParticipantsValid() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.roomDesc != null) goto L13;
        if (this.startTime != null) goto L13;
        if (this.endTime != null) goto L13;
        if (this.agenda != null) goto L13;
        return true;
    }

    public final boolean onlyHaveTime() {
        if (isParticipantsValid() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.roomDesc != null) goto L13;
        if (this.agenda != null) goto L13;
        if (this.startTime == null) goto L11;
    L12:
        return true;
    L11:
        if (this.endTime == null) goto L13;
        goto L12
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final ArrayList<String> getParticipantIds() {
        return this.participantIds;
    }

    public final ArrayList<String> getParticipants() {
        return this.participants;
    }

    public final String getRoomDesc() {
        return this.roomDesc;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final TimeType getTimeType() {
        return this.timeType;
    }

    public final IntentInputVersion getVersion() {
        return this.version;
    }

    public SearchCalendarIntentInput(Long r100, Long r101, String r102, ArrayList<String> r103, ArrayList<String> r104, String r105, TimeType r106, IntentInputVersion r107) {
        Intrinsics.checkNotNullParameter(r107, "version");
        super(IntentInput.IntentType.SEARCH_CALENDAR);
        this.startTime = r100;
        this.endTime = r101;
        this.roomDesc = r102;
        this.participants = r103;
        this.participantIds = r104;
        this.agenda = r105;
        this.timeType = r106;
        this.version = r107;
    }
}
