package com.google.i18n.phonenumbers;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class PhoneNumberMatcher implements Iterator<Object> {

    public static final enum State extends Enum<State> {
        public static final State DONE = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f275916a = null;

        static {
            State r100 = new State("NOT_READY", 0);
            NOT_READY = r100;
            State r101 = new State("READY", 1);
            READY = r101;
            State r102 = new State("DONE", 2);
            DONE = r102;
            f275916a = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) f275916a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }
}
