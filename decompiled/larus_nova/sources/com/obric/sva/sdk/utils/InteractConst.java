package com.obric.sva.sdk.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/sva/sdk/utils/InteractConst;", "", "<init>", "()V", "WAKEUP_REQUEST_FROM", "", "WAKEUP_IGNORE_REQUEST", "WAKEUP_SOURCE_VOICE_ASSIST", InteractConst.WAKEUP_START_TIME, "WAKEUP_REQUEST_TIME", "WAKEUP_TRACKER_DURATION", "WAKEUP_PULL_UP_ONCE", "WAKEUP_SCREEN_STATE", "WAKEUP_MODEL_NAME", "WAKEUP_ONSHOT_WAKEWORD", "WAKEUP_ONESHOT_OFFSET_TIME", "WAKEUP_SESSION_TYPE", "WAKEUP_SESSION_NAME", "WAKEUP_WAKEUP_ID", "INTENT_SESSION_ID", "USER_HANDLE_ID", "INTENT_PIPE", "WAKEUP_STAGE1_START_TIME", "WAKEUP_INTERRUPTED_STAGE1", "WAKEUP_INTERRUPTED_STAGE2", "WAKEUP_INTERRUPTED_STAGE3", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractConst {
    public static final InteractConst INSTANCE = null;
    public static final String INTENT_PIPE = "pipe";
    public static final String INTENT_SESSION_ID = "sessionid";
    public static final String USER_HANDLE_ID = "userHandleId";
    public static final String WAKEUP_IGNORE_REQUEST = "IGNORE_REQUEST";
    public static final String WAKEUP_INTERRUPTED_STAGE1 = "stage1_entry";
    public static final String WAKEUP_INTERRUPTED_STAGE2 = "stage2_entry";
    public static final String WAKEUP_INTERRUPTED_STAGE3 = "stage3_entry";
    public static final String WAKEUP_MODEL_NAME = "smName";
    public static final String WAKEUP_ONESHOT_OFFSET_TIME = "offsetTime";
    public static final String WAKEUP_ONSHOT_WAKEWORD = "keyword";
    public static final String WAKEUP_PULL_UP_ONCE = "REQUEST_PULL_UP_ONCE";
    public static final String WAKEUP_REQUEST_FROM = "REQUEST_FROM";
    public static final String WAKEUP_REQUEST_TIME = "REQUEST_TIME";
    public static final String WAKEUP_SCREEN_STATE = "screen_state";
    public static final String WAKEUP_SESSION_NAME = "sessionName";
    public static final String WAKEUP_SESSION_TYPE = "sessionType";
    public static final String WAKEUP_SOURCE_VOICE_ASSIST = "VOICE_ASSIST";
    public static final String WAKEUP_STAGE1_START_TIME = "stage1_start_time";
    public static final String WAKEUP_START_TIME = "WAKEUP_START_TIME";
    public static final String WAKEUP_TRACKER_DURATION = "REQUEST_TRACK_DURATION";
    public static final String WAKEUP_WAKEUP_ID = "wakeupId";

    static {
        INSTANCE = new InteractConst();
    }

    private InteractConst() {
    }
}
