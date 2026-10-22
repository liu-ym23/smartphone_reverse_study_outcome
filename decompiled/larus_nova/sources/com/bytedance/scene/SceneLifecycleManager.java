package com.bytedance.scene;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.scene.Scene;
import com.bytedance.scene.m;

/* JADX INFO: loaded from: classes19.dex */
public final class SceneLifecycleManager<T extends Scene & m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f268613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SceneLifecycleManagerState f268614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f268615c;

    public static final enum SceneLifecycleManagerState extends Enum<SceneLifecycleManagerState> {
        public static final SceneLifecycleManagerState ACTIVITY_CREATED = null;
        public static final SceneLifecycleManagerState NONE = null;
        public static final SceneLifecycleManagerState PAUSE = null;
        public static final SceneLifecycleManagerState RESUME = null;
        public static final SceneLifecycleManagerState START = null;
        public static final SceneLifecycleManagerState STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneLifecycleManagerState[] f268616a = null;

        static {
            SceneLifecycleManagerState r100 = new SceneLifecycleManagerState(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SceneLifecycleManagerState r101 = new SceneLifecycleManagerState("ACTIVITY_CREATED", 1);
            ACTIVITY_CREATED = r101;
            SceneLifecycleManagerState r102 = new SceneLifecycleManagerState(GXAnimation.STATE_START, 2);
            START = r102;
            SceneLifecycleManagerState r103 = new SceneLifecycleManagerState("RESUME", 3);
            RESUME = r103;
            SceneLifecycleManagerState r104 = new SceneLifecycleManagerState("PAUSE", 4);
            PAUSE = r104;
            SceneLifecycleManagerState r105 = new SceneLifecycleManagerState("STOP", 5);
            STOP = r105;
            f268616a = new SceneLifecycleManagerState[]{r100, r101, r102, r103, r104, r105};
        }

        public static SceneLifecycleManagerState[] values() {
            return (SceneLifecycleManagerState[]) f268616a.clone();
        }

        public static SceneLifecycleManagerState valueOf(String r100) {
            return (SceneLifecycleManagerState) r27.a.a(SceneLifecycleManagerState.class, r100);
        }

        public SceneLifecycleManagerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SceneLifecycleManager() {
        this.f268614b = SceneLifecycleManagerState.NONE;
        this.f268615c = false;
    }
}
