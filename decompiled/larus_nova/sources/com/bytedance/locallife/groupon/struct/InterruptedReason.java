package com.bytedance.locallife.groupon.struct;

import com.ss.android.downloadad.api.constant.AdBaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/InterruptedReason;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PLAY_FAILED", "JUMP_OTHER_TAB", "JUMP_BACKGROUND", "JUMP_NEXT", "JUMP_SWITCH", "DIAMOND_EMPTY", "DIAMOND_REQUEST_FAILED", "DIAMOND_SDK_FAILED", "DIAMOND_LYNX_FAILED", "FEED_EMPTY", "FEED_REQUEST_FAILED", "JUMP_INNER_PAGE", "FEED_NO_LOGIN", "FEED_COVER_TIMEOUT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum InterruptedReason extends Enum<InterruptedReason> {
    public static final InterruptedReason DIAMOND_EMPTY = null;
    public static final InterruptedReason DIAMOND_LYNX_FAILED = null;
    public static final InterruptedReason DIAMOND_REQUEST_FAILED = null;
    public static final InterruptedReason DIAMOND_SDK_FAILED = null;
    public static final InterruptedReason FEED_COVER_TIMEOUT = null;
    public static final InterruptedReason FEED_EMPTY = null;
    public static final InterruptedReason FEED_NO_LOGIN = null;
    public static final InterruptedReason FEED_REQUEST_FAILED = null;
    public static final InterruptedReason JUMP_BACKGROUND = null;
    public static final InterruptedReason JUMP_INNER_PAGE = null;
    public static final InterruptedReason JUMP_NEXT = null;
    public static final InterruptedReason JUMP_OTHER_TAB = null;
    public static final InterruptedReason JUMP_SWITCH = null;
    public static final InterruptedReason PLAY_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterruptedReason[] f258827a = null;
    private final String value;

    public static InterruptedReason valueOf(String r100) {
        return (InterruptedReason) r27.a.a(InterruptedReason.class, r100);
    }

    public static InterruptedReason[] values() {
        return (InterruptedReason[]) f258827a.clone();
    }

    static {
        InterruptedReason r100 = new InterruptedReason("PLAY_FAILED", 0, "000");
        PLAY_FAILED = r100;
        InterruptedReason r101 = new InterruptedReason("JUMP_OTHER_TAB", 1, "100");
        JUMP_OTHER_TAB = r101;
        InterruptedReason r102 = new InterruptedReason("JUMP_BACKGROUND", 2, "200");
        JUMP_BACKGROUND = r102;
        InterruptedReason r103 = new InterruptedReason("JUMP_NEXT", 3, "300");
        JUMP_NEXT = r103;
        InterruptedReason r104 = new InterruptedReason("JUMP_SWITCH", 4, "400");
        JUMP_SWITCH = r104;
        InterruptedReason r105 = new InterruptedReason("DIAMOND_EMPTY", 5, "011");
        DIAMOND_EMPTY = r105;
        InterruptedReason r110 = new InterruptedReason("DIAMOND_REQUEST_FAILED", 6, "010");
        DIAMOND_REQUEST_FAILED = r110;
        InterruptedReason r111 = new InterruptedReason("DIAMOND_SDK_FAILED", 7, "012");
        DIAMOND_SDK_FAILED = r111;
        InterruptedReason r112 = new InterruptedReason("DIAMOND_LYNX_FAILED", 8, "013");
        DIAMOND_LYNX_FAILED = r112;
        InterruptedReason r113 = new InterruptedReason("FEED_EMPTY", 9, AdBaseConstants.InfoErrorCode.WEB_URL_NULL);
        FEED_EMPTY = r113;
        InterruptedReason r114 = new InterruptedReason("FEED_REQUEST_FAILED", 10, "000");
        FEED_REQUEST_FAILED = r114;
        InterruptedReason r106 = new InterruptedReason("JUMP_INNER_PAGE", 11, "500");
        JUMP_INNER_PAGE = r106;
        InterruptedReason r107 = new InterruptedReason("FEED_NO_LOGIN", 12, "600");
        FEED_NO_LOGIN = r107;
        InterruptedReason r108 = new InterruptedReason("FEED_COVER_TIMEOUT", 13, "002");
        FEED_COVER_TIMEOUT = r108;
        f258827a = new InterruptedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
    }

    public final String getValue() {
        return this.value;
    }

    public InterruptedReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
