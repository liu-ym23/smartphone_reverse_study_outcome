package com.ss.android.lark.notification.export.speech;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class NotificationMediaPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433081a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/notification/export/speech/NotificationMediaPlayer$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "PREPARING", "PREPARED", "STARTED", "STOPPED", GXAnimation.STATE_END, "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State END = null;
        public static final State IDLE = null;
        public static final State INITIALIZED = null;
        public static final State PREPARED = null;
        public static final State PREPARING = null;
        public static final State STARTED = null;
        public static final State STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f433082a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f433083b = null;

        public static EnumEntries<State> getEntries() {
            return f433083b;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("INITIALIZED", 1);
            INITIALIZED = r101;
            State r102 = new State("PREPARING", 2);
            PREPARING = r102;
            State r103 = new State("PREPARED", 3);
            PREPARED = r103;
            State r104 = new State("STARTED", 4);
            STARTED = r104;
            State r105 = new State("STOPPED", 5);
            STOPPED = r105;
            State r110 = new State(GXAnimation.STATE_END, 6);
            END = r110;
            State[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f433082a = r111;
            f433083b = EnumEntriesKt.enumEntries(r111);
        }

        public static State[] values() {
            return (State[]) f433082a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }
}
