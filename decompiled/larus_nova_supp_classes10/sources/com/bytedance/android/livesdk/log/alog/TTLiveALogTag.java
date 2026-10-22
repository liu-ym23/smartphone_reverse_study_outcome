package com.bytedance.android.livesdk.log.alog;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final enum TTLiveALogTag extends Enum<TTLiveALogTag> {
    public static final TTLiveALogTag Click = null;
    public static final TTLiveALogTag Exception = null;
    public static final TTLiveALogTag Feed = null;
    public static final TTLiveALogTag Gift = null;
    public static final TTLiveALogTag Msg = null;
    public static final TTLiveALogTag Net = null;
    public static final TTLiveALogTag Page = null;
    public static final TTLiveALogTag Pk = null;
    public static final TTLiveALogTag PullStream = null;
    public static final TTLiveALogTag PushStream = null;
    public static final TTLiveALogTag Recharge = null;
    public static final TTLiveALogTag Room = null;
    public static final TTLiveALogTag Screen_Shot = null;
    public static final /* synthetic */ TTLiveALogTag[] a = null;
    public String info;

    static {
        TTLiveALogTag r0 = new TTLiveALogTag("Room", 0, "ttlive_room");
        Room = r0;
        TTLiveALogTag r1 = new TTLiveALogTag("Gift", 1, "ttlive_gift");
        Gift = r1;
        TTLiveALogTag r2 = new TTLiveALogTag("PushStream", 2, "ttlive_pushstream");
        PushStream = r2;
        TTLiveALogTag r4 = new TTLiveALogTag("PullStream", 3, "ttlive_pullstream");
        PullStream = r4;
        TTLiveALogTag r6 = new TTLiveALogTag("Net", 4, "ttlive_net");
        Net = r6;
        TTLiveALogTag r8 = new TTLiveALogTag("Click", 5, "ttlive_click");
        Click = r8;
        TTLiveALogTag r10 = new TTLiveALogTag("Feed", 6, "ttlive_feed");
        Feed = r10;
        TTLiveALogTag r12 = new TTLiveALogTag("Msg", 7, "ttlive_msg");
        Msg = r12;
        TTLiveALogTag r14 = new TTLiveALogTag("Exception", 8, "ttlive_exception");
        Exception = r14;
        TTLiveALogTag r13 = new TTLiveALogTag("Page", 9, "ttlive_page");
        Page = r13;
        TTLiveALogTag r11 = new TTLiveALogTag("Recharge", 10, "ttlive_recharge");
        Recharge = r11;
        TTLiveALogTag r9 = new TTLiveALogTag("Pk", 11, "ttlive_pk");
        Pk = r9;
        TTLiveALogTag r7 = new TTLiveALogTag("Screen_Shot", 12, "ttlive_screenshot");
        Screen_Shot = r7;
        a = new TTLiveALogTag[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
    }

    public static TTLiveALogTag[] values() {
        return (TTLiveALogTag[]) a.clone();
    }

    public static TTLiveALogTag valueOf(String r1) {
        return (TTLiveALogTag) a.a(TTLiveALogTag.class, r1);
    }

    public TTLiveALogTag(String r1, int r2, String r3) {
        super(r1, r2);
        this.info = r3;
    }
}
