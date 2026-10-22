package com.bytedance.ee.bear.widgets;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;

/* JADX INFO: loaded from: classes18.dex */
public final enum BadgeStyle extends Enum<BadgeStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadgeStyle[] f239994a = null;
    public static final BadgeStyle mute = null;
    public static final BadgeStyle num = null;
    public static final BadgeStyle point = null;
    public static final BadgeStyle text = null;

    static {
        BadgeStyle r100 = new BadgeStyle("point", 0);
        point = r100;
        BadgeStyle r101 = new BadgeStyle("num", 1);
        num = r101;
        BadgeStyle r102 = new BadgeStyle(ITTVideoEngineEventSource.KEY_MUTE, 2);
        mute = r102;
        BadgeStyle r103 = new BadgeStyle("text", 3);
        text = r103;
        f239994a = new BadgeStyle[]{r100, r101, r102, r103};
    }

    public static BadgeStyle[] values() {
        return (BadgeStyle[]) f239994a.clone();
    }

    public static BadgeStyle valueOf(String r100) {
        return (BadgeStyle) r27.a.a(BadgeStyle.class, r100);
    }

    public BadgeStyle(String r100, int r101) {
        super(r100, r101);
    }
}
