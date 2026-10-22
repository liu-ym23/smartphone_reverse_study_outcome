package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarDrawerPriority;", "", "MUSIC", "PAYMENT_PREVIEW", "LONG_VIDEO_HIGHLIGHT", "CHAPTER", "VIDEO_ABSTRACT", "SHARE_VIDEO_MARK_TIME", "TRACKING_PLAY_PROGRESS", "BUFFER_BLOCK", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SeekBarDrawerPriority extends Enum<SeekBarDrawerPriority> {
    public static final SeekBarDrawerPriority BUFFER_BLOCK = null;
    public static final SeekBarDrawerPriority CHAPTER = null;
    public static final SeekBarDrawerPriority LONG_VIDEO_HIGHLIGHT = null;
    public static final SeekBarDrawerPriority MUSIC = null;
    public static final SeekBarDrawerPriority PAYMENT_PREVIEW = null;
    public static final SeekBarDrawerPriority SHARE_VIDEO_MARK_TIME = null;
    public static final SeekBarDrawerPriority TRACKING_PLAY_PROGRESS = null;
    public static final SeekBarDrawerPriority VIDEO_ABSTRACT = null;
    public static final /* synthetic */ SeekBarDrawerPriority[] a = null;

    public static SeekBarDrawerPriority valueOf(String r1) {
        return (SeekBarDrawerPriority) r27.a.a(SeekBarDrawerPriority.class, r1);
    }

    public static SeekBarDrawerPriority[] values() {
        return (SeekBarDrawerPriority[]) a.clone();
    }

    static {
        SeekBarDrawerPriority r0 = new SeekBarDrawerPriority("MUSIC", 0);
        MUSIC = r0;
        SeekBarDrawerPriority r1 = new SeekBarDrawerPriority("PAYMENT_PREVIEW", 1);
        PAYMENT_PREVIEW = r1;
        SeekBarDrawerPriority r3 = new SeekBarDrawerPriority("LONG_VIDEO_HIGHLIGHT", 2);
        LONG_VIDEO_HIGHLIGHT = r3;
        SeekBarDrawerPriority r5 = new SeekBarDrawerPriority("CHAPTER", 3);
        CHAPTER = r5;
        SeekBarDrawerPriority r7 = new SeekBarDrawerPriority("VIDEO_ABSTRACT", 4);
        VIDEO_ABSTRACT = r7;
        SeekBarDrawerPriority r9 = new SeekBarDrawerPriority("SHARE_VIDEO_MARK_TIME", 5);
        SHARE_VIDEO_MARK_TIME = r9;
        SeekBarDrawerPriority r11 = new SeekBarDrawerPriority("TRACKING_PLAY_PROGRESS", 6);
        TRACKING_PLAY_PROGRESS = r11;
        SeekBarDrawerPriority r13 = new SeekBarDrawerPriority("BUFFER_BLOCK", 7);
        BUFFER_BLOCK = r13;
        a = new SeekBarDrawerPriority[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public SeekBarDrawerPriority(String r1, int r2) {
        super(r1, r2);
    }
}
