package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class ForwardStreamEventInfo {
    public ForwardStreamEvent event;
    public String roomId;

    public static final enum ForwardStreamEvent extends Enum<ForwardStreamEvent> {
        private static final /* synthetic */ ForwardStreamEvent[] $VALUES = null;
        public static final ForwardStreamEvent FORWARD_STREAM_EVENT_CONNECTED = null;
        public static final ForwardStreamEvent FORWARD_STREAM_EVENT_DISCONNECTED = null;
        public static final ForwardStreamEvent FORWARD_STREAM_EVENT_DST_ROOM_UPDATED = null;
        public static final ForwardStreamEvent FORWARD_STREAM_EVENT_INTERRUPT = null;
        public static final ForwardStreamEvent FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL = null;
        private int value;

        static {
            ForwardStreamEvent r100 = new ForwardStreamEvent("FORWARD_STREAM_EVENT_DISCONNECTED", 0, 0);
            FORWARD_STREAM_EVENT_DISCONNECTED = r100;
            ForwardStreamEvent r101 = new ForwardStreamEvent("FORWARD_STREAM_EVENT_CONNECTED", 1, 1);
            FORWARD_STREAM_EVENT_CONNECTED = r101;
            ForwardStreamEvent r102 = new ForwardStreamEvent("FORWARD_STREAM_EVENT_INTERRUPT", 2, 2);
            FORWARD_STREAM_EVENT_INTERRUPT = r102;
            ForwardStreamEvent r103 = new ForwardStreamEvent("FORWARD_STREAM_EVENT_DST_ROOM_UPDATED", 3, 3);
            FORWARD_STREAM_EVENT_DST_ROOM_UPDATED = r103;
            ForwardStreamEvent r104 = new ForwardStreamEvent("FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL", 4, 4);
            FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL = r104;
            $VALUES = new ForwardStreamEvent[]{r100, r101, r102, r103, r104};
        }

        public static ForwardStreamEvent[] values() {
            return (ForwardStreamEvent[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamEvent fromId(int r100) {
            ForwardStreamEvent[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ForwardStreamEvent r104 = r101[r103];
            if (r104.value() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static ForwardStreamEvent valueOf(String r100) {
            return (ForwardStreamEvent) a.a(ForwardStreamEvent.class, r100);
        }

        private ForwardStreamEvent(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ForwardStreamEventInfo(String r100, ForwardStreamEvent r101) {
        this.roomId = r100;
        this.event = r101;
    }

    private static ForwardStreamEventInfo create(String r100, int r101) {
        return new ForwardStreamEventInfo(r100, ForwardStreamEvent.fromId(r101));
    }
}
