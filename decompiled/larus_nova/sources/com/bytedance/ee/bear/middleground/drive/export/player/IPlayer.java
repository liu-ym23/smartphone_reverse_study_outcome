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

/* JADX INFO: loaded from: classes18.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f232521a = null;

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("PREPARING", 1);
            PREPARING = r101;
            State r102 = new State("PREPARED", 2);
            PREPARED = r102;
            State r103 = new State("STOPPED", 3);
            STOPPED = r103;
            State r104 = new State("PLAYING", 4);
            PLAYING = r104;
            State r105 = new State("BUFFERING", 5);
            BUFFERING = r105;
            State r110 = new State("PAUSED", 6);
            PAUSED = r110;
            State r111 = new State("ENDED", 7);
            ENDED = r111;
            State r112 = new State("ERROR", 8);
            ERROR = r112;
            f232521a = new State[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static State[] values() {
            return (State[]) f232521a.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
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

    void a(b r100);

    void b(Uri r100);

    void c(Map<String, String> r100);

    void d();

    void e();

    void f(Scene r100);

    void g(b r100);

    long getCurrentPosition();

    int getPlaybackState();

    MutableLiveData h();

    void pause();

    void preload();

    void release();

    void seekTo(long r100);

    void setSpeed(float r100);

    void setStartTime(int r100);

    void setVolume(float r100);

    void start();

    void stop();
}
