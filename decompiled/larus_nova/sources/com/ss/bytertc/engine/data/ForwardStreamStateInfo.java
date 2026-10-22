package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class ForwardStreamStateInfo {
    public ForwardStreamError error;
    public String roomId;
    public ForwardStreamState state;

    public static final enum ForwardStreamError extends Enum<ForwardStreamError> {
        private static final /* synthetic */ ForwardStreamError[] $VALUES = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_INVALID_ARGUMENT = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_INVALID_TOKEN = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_NOT_SUPPORT = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_OK = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_REMOTE_KICKED = null;
        public static final ForwardStreamError FORWARD_STREAM_ERROR_RESPONSE = null;
        private int value;

        static {
            ForwardStreamError r100 = new ForwardStreamError("FORWARD_STREAM_ERROR_OK", 0, 0);
            FORWARD_STREAM_ERROR_OK = r100;
            ForwardStreamError r101 = new ForwardStreamError("FORWARD_STREAM_ERROR_INVALID_ARGUMENT", 1, 1201);
            FORWARD_STREAM_ERROR_INVALID_ARGUMENT = r101;
            ForwardStreamError r102 = new ForwardStreamError("FORWARD_STREAM_ERROR_INVALID_TOKEN", 2, 1202);
            FORWARD_STREAM_ERROR_INVALID_TOKEN = r102;
            ForwardStreamError r103 = new ForwardStreamError("FORWARD_STREAM_ERROR_RESPONSE", 3, 1203);
            FORWARD_STREAM_ERROR_RESPONSE = r103;
            ForwardStreamError r104 = new ForwardStreamError("FORWARD_STREAM_ERROR_REMOTE_KICKED", 4, 1204);
            FORWARD_STREAM_ERROR_REMOTE_KICKED = r104;
            ForwardStreamError r105 = new ForwardStreamError("FORWARD_STREAM_ERROR_NOT_SUPPORT", 5, 1205);
            FORWARD_STREAM_ERROR_NOT_SUPPORT = r105;
            $VALUES = new ForwardStreamError[]{r100, r101, r102, r103, r104, r105};
        }

        public static ForwardStreamError[] values() {
            return (ForwardStreamError[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamError fromId(int r100) {
            ForwardStreamError[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ForwardStreamError r104 = r101[r103];
            if (r104.value() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static ForwardStreamError valueOf(String r100) {
            return (ForwardStreamError) a.a(ForwardStreamError.class, r100);
        }

        private ForwardStreamError(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ForwardStreamState extends Enum<ForwardStreamState> {
        private static final /* synthetic */ ForwardStreamState[] $VALUES = null;
        public static final ForwardStreamState FORWARD_STREAM_STATE_FAILURE = null;
        public static final ForwardStreamState FORWARD_STREAM_STATE_IDLE = null;
        public static final ForwardStreamState FORWARD_STREAM_STATE_SUCCESS = null;
        private int value;

        static {
            ForwardStreamState r100 = new ForwardStreamState("FORWARD_STREAM_STATE_IDLE", 0, 0);
            FORWARD_STREAM_STATE_IDLE = r100;
            ForwardStreamState r101 = new ForwardStreamState("FORWARD_STREAM_STATE_SUCCESS", 1, 1);
            FORWARD_STREAM_STATE_SUCCESS = r101;
            ForwardStreamState r102 = new ForwardStreamState("FORWARD_STREAM_STATE_FAILURE", 2, 2);
            FORWARD_STREAM_STATE_FAILURE = r102;
            $VALUES = new ForwardStreamState[]{r100, r101, r102};
        }

        public static ForwardStreamState[] values() {
            return (ForwardStreamState[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamState fromId(int r100) {
            ForwardStreamState[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ForwardStreamState r104 = r101[r103];
            if (r104.value() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static ForwardStreamState valueOf(String r100) {
            return (ForwardStreamState) a.a(ForwardStreamState.class, r100);
        }

        private ForwardStreamState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ForwardStreamStateInfo(String r100, ForwardStreamState r101, ForwardStreamError r102) {
        this.roomId = r100;
        this.state = r101;
        this.error = r102;
    }

    private static ForwardStreamStateInfo create(String r100, int r101, int r102) {
        return new ForwardStreamStateInfo(r100, ForwardStreamState.fromId(r101), ForwardStreamError.fromId(r102));
    }
}
