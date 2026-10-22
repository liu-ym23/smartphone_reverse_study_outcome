package com.huawei.agconnect.core.service.auth;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public interface TokenSnapshot {

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State SIGNED_IN = null;
        public static final State SIGNED_OUT = null;
        public static final State TOKEN_INVALID = null;
        public static final State TOKEN_UPDATED = null;

        static {
            State r100 = new State("SIGNED_IN", 0);
            SIGNED_IN = r100;
            State r101 = new State("TOKEN_UPDATED", 1);
            TOKEN_UPDATED = r101;
            State r102 = new State("TOKEN_INVALID", 2);
            TOKEN_INVALID = r102;
            State r103 = new State("SIGNED_OUT", 3);
            SIGNED_OUT = r103;
            $VALUES = new State[]{r100, r101, r102, r103};
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    State getState();

    String getToken();
}
