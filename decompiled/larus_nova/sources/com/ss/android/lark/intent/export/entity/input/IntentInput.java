package com.ss.android.lark.intent.export.entity.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "", "type", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput$IntentType;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/input/IntentInput$IntentType;)V", "getType", "()Lcom/ss/android/lark/intent/export/entity/input/IntentInput$IntentType;", "IntentType", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IntentInput {
    private final IntentType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/IntentInput$IntentType;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_MESSAGE", "BOOKING_CALENDAR", "SEARCH_CALENDAR", "OPEN_CALENDAR_DETAIL", "OPEN_CHAT_DETAIL", "ASR_RECOGNIZE", "QUERY_KNOWLEDGE_AI", "OPEN_URL", "SEARCH_CONTACT", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum IntentType extends Enum<IntentType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ IntentType[] $VALUES = null;
        public static final IntentType ASR_RECOGNIZE = null;
        public static final IntentType BOOKING_CALENDAR = null;
        public static final IntentType OPEN_CALENDAR_DETAIL = null;
        public static final IntentType OPEN_CHAT_DETAIL = null;
        public static final IntentType OPEN_URL = null;
        public static final IntentType QUERY_KNOWLEDGE_AI = null;
        public static final IntentType SEARCH_CALENDAR = null;
        public static final IntentType SEARCH_CONTACT = null;
        public static final IntentType SEND_MESSAGE = null;

        private static final /* synthetic */ IntentType[] $values() {
            return new IntentType[]{SEND_MESSAGE, BOOKING_CALENDAR, SEARCH_CALENDAR, OPEN_CALENDAR_DETAIL, OPEN_CHAT_DETAIL, ASR_RECOGNIZE, QUERY_KNOWLEDGE_AI, OPEN_URL, SEARCH_CONTACT};
        }

        public static EnumEntries<IntentType> getEntries() {
            return $ENTRIES;
        }

        static {
            SEND_MESSAGE = new IntentType("SEND_MESSAGE", 0);
            BOOKING_CALENDAR = new IntentType("BOOKING_CALENDAR", 1);
            SEARCH_CALENDAR = new IntentType("SEARCH_CALENDAR", 2);
            OPEN_CALENDAR_DETAIL = new IntentType("OPEN_CALENDAR_DETAIL", 3);
            OPEN_CHAT_DETAIL = new IntentType("OPEN_CHAT_DETAIL", 4);
            ASR_RECOGNIZE = new IntentType("ASR_RECOGNIZE", 5);
            QUERY_KNOWLEDGE_AI = new IntentType("QUERY_KNOWLEDGE_AI", 6);
            OPEN_URL = new IntentType("OPEN_URL", 7);
            SEARCH_CONTACT = new IntentType("SEARCH_CONTACT", 8);
            IntentType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static IntentType[] values() {
            return (IntentType[]) $VALUES.clone();
        }

        public static IntentType valueOf(String r100) {
            return (IntentType) a.a(IntentType.class, r100);
        }

        private IntentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final IntentType getType() {
        return this.type;
    }

    public IntentInput(IntentType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
    }
}
