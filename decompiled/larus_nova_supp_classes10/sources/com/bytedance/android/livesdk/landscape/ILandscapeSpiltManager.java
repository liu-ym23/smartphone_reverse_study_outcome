package com.bytedance.android.livesdk.landscape;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface ILandscapeSpiltManager {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/landscape/ILandscapeSpiltManager$State;", "", "", "willShow", "HIDE", "HIDE_ANIMATING", "SHOW_ANIMATING", "SHOW", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State HIDE = null;
        public static final State HIDE_ANIMATING = null;
        public static final State SHOW = null;
        public static final State SHOW_ANIMATING = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("HIDE", 0);
            HIDE = r1;
            State r2 = new State("HIDE_ANIMATING", 1);
            HIDE_ANIMATING = r2;
            State r3 = new State("SHOW_ANIMATING", 2);
            SHOW_ANIMATING = r3;
            State r4 = new State("SHOW", 3);
            SHOW = r4;
            a = new State[]{r1, r2, r3, r4};
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final boolean willShow() {
            if (this != SHOW) goto L5;
        L8:
            return true;
        L5:
            if (this == SHOW_ANIMATING) goto L8;
            return false;
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    PropertyOwner getState();
}
