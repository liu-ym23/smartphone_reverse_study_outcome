package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/StopReason;", "", "USER_STOP", "PAGE_DISAPPEAR", "PAGE_DESTROY", "COMPONENT_HIDE", "LIST_REFRESH", "REPLAY_SAME_SLICE", "REPLACED_BY_OTHER", "PLAY_COMPLETE", "PLAY_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StopReason extends Enum<StopReason> {
    public static final StopReason COMPONENT_HIDE = null;
    public static final StopReason LIST_REFRESH = null;
    public static final StopReason PAGE_DESTROY = null;
    public static final StopReason PAGE_DISAPPEAR = null;
    public static final StopReason PLAY_COMPLETE = null;
    public static final StopReason PLAY_ERROR = null;
    public static final StopReason REPLACED_BY_OTHER = null;
    public static final StopReason REPLAY_SAME_SLICE = null;
    public static final StopReason USER_STOP = null;
    public static final /* synthetic */ StopReason[] a = null;

    static {
        StopReason r1 = new StopReason("USER_STOP", 0);
        USER_STOP = r1;
        StopReason r2 = new StopReason("PAGE_DISAPPEAR", 1);
        PAGE_DISAPPEAR = r2;
        StopReason r3 = new StopReason("PAGE_DESTROY", 2);
        PAGE_DESTROY = r3;
        StopReason r4 = new StopReason("COMPONENT_HIDE", 3);
        COMPONENT_HIDE = r4;
        StopReason r5 = new StopReason("LIST_REFRESH", 4);
        LIST_REFRESH = r5;
        StopReason r6 = new StopReason("REPLAY_SAME_SLICE", 5);
        REPLAY_SAME_SLICE = r6;
        StopReason r7 = new StopReason("REPLACED_BY_OTHER", 6);
        REPLACED_BY_OTHER = r7;
        StopReason r8 = new StopReason("PLAY_COMPLETE", 7);
        PLAY_COMPLETE = r8;
        StopReason r9 = new StopReason("PLAY_ERROR", 8);
        PLAY_ERROR = r9;
        a = new StopReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static StopReason valueOf(String r1) {
        return (StopReason) r27.a.a(StopReason.class, r1);
    }

    public static StopReason[] values() {
        return (StopReason[]) a.clone();
    }

    public StopReason(String r1, int r2) {
        super(r1, r2);
    }
}
