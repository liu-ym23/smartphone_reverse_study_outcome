package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeekBarDrawerPriority[] f193643a = null;

    public static SeekBarDrawerPriority valueOf(String r100) {
        return (SeekBarDrawerPriority) r27.a.a(SeekBarDrawerPriority.class, r100);
    }

    public static SeekBarDrawerPriority[] values() {
        return (SeekBarDrawerPriority[]) f193643a.clone();
    }

    static {
        SeekBarDrawerPriority r100 = new SeekBarDrawerPriority("MUSIC", 0);
        MUSIC = r100;
        SeekBarDrawerPriority r101 = new SeekBarDrawerPriority("PAYMENT_PREVIEW", 1);
        PAYMENT_PREVIEW = r101;
        SeekBarDrawerPriority r102 = new SeekBarDrawerPriority("LONG_VIDEO_HIGHLIGHT", 2);
        LONG_VIDEO_HIGHLIGHT = r102;
        SeekBarDrawerPriority r103 = new SeekBarDrawerPriority("CHAPTER", 3);
        CHAPTER = r103;
        SeekBarDrawerPriority r104 = new SeekBarDrawerPriority("VIDEO_ABSTRACT", 4);
        VIDEO_ABSTRACT = r104;
        SeekBarDrawerPriority r105 = new SeekBarDrawerPriority("SHARE_VIDEO_MARK_TIME", 5);
        SHARE_VIDEO_MARK_TIME = r105;
        SeekBarDrawerPriority r110 = new SeekBarDrawerPriority("TRACKING_PLAY_PROGRESS", 6);
        TRACKING_PLAY_PROGRESS = r110;
        SeekBarDrawerPriority r111 = new SeekBarDrawerPriority("BUFFER_BLOCK", 7);
        BUFFER_BLOCK = r111;
        f193643a = new SeekBarDrawerPriority[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public SeekBarDrawerPriority(String r100, int r101) {
        super(r100, r101);
    }
}
