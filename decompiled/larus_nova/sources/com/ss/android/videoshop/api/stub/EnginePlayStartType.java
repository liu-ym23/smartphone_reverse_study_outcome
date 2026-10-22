package com.ss.android.videoshop.api.stub;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface EnginePlayStartType {
    public static final int PAUSE_TO_PLAY = 2;
    public static final int PREPARED_TO_PLAY = 4;
    public static final int PREPARING_TO_PLAY = 5;
    public static final int RELEASE_TO_PLAY = 1;
    public static final int REPLAY = 3;
    public static final int STOP_TO_PLAY = 6;
}
