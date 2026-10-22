package com.bytedance.ee.bear.middleground.drive.export.player;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.media.Scene;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import r27.a;
import sf5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface IPlayer {

    public static final enum State extends Enum<State> {
        public static final State BUFFERING = null;
        public static final State ENDED = null;
        public static final State ERROR = null;
        public static final State IDLE = null;
        public static final State PAUSED = null;
        public static final State PLAYING = null;
        public static final State PREPARED = null;
        public static final State PREPARING = null;
        public static final State STOPPED = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("PREPARING", 1);
            PREPARING = r1;
            State r3 = new State("PREPARED", 2);
            PREPARED = r3;
            State r5 = new State("STOPPED", 3);
            STOPPED = r5;
            State r7 = new State("PLAYING", 4);
            PLAYING = r7;
            State r9 = new State("BUFFERING", 5);
            BUFFERING = r9;
            State r11 = new State("PAUSED", 6);
            PAUSED = r11;
            State r13 = new State("ENDED", 7);
            ENDED = r13;
            State r15 = new State("ERROR", 8);
            ERROR = r15;
            a = new State[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int STATE_BUFFERING = 2;
        public static final int STATE_ENDED = 5;
        public static final int STATE_IDLE = 1;
        public static final int STATE_PLAYING = 4;
        public static final int STATE_READY = 3;
    }

    void a(b r1);

    void b(Uri r1);

    void c(Map<String, String> r1);

    void d();

    void e();

    void f(Scene r1);

    void g(b r1);

    long getCurrentPosition();

    int getPlaybackState();

    MutableLiveData h();

    void pause();

    void preload();

    void release();

    void seekTo(long r1);

    void setSpeed(float r1);

    void setStartTime(int r1);

    void setVolume(float r1);

    void start();

    void stop();
}
