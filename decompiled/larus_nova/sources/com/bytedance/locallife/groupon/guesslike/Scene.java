package com.bytedance.locallife.groupon.guesslike;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/guesslike/Scene;", "", "FMP_COMPLETE", "FEEDS_REFRESH", "FEEDS_LOADMORE", "BACK_TO_TOP", "RETURN_BACK", "FEEDS_SCROLL_IDLE", "FEEDS_SCROLL_ING", "RELEASE_BACK_TO_FEED", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum Scene extends Enum<Scene> {
    public static final Scene BACK_TO_TOP = null;
    public static final Scene FEEDS_LOADMORE = null;
    public static final Scene FEEDS_REFRESH = null;
    public static final Scene FEEDS_SCROLL_IDLE = null;
    public static final Scene FEEDS_SCROLL_ING = null;
    public static final Scene FMP_COMPLETE = null;
    public static final Scene RELEASE_BACK_TO_FEED = null;
    public static final Scene RETURN_BACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f258799a = null;

    public static Scene valueOf(String r100) {
        return (Scene) a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f258799a.clone();
    }

    static {
        Scene r100 = new Scene("FMP_COMPLETE", 0);
        FMP_COMPLETE = r100;
        Scene r101 = new Scene("FEEDS_REFRESH", 1);
        FEEDS_REFRESH = r101;
        Scene r102 = new Scene("FEEDS_LOADMORE", 2);
        FEEDS_LOADMORE = r102;
        Scene r103 = new Scene("BACK_TO_TOP", 3);
        BACK_TO_TOP = r103;
        Scene r104 = new Scene("RETURN_BACK", 4);
        RETURN_BACK = r104;
        Scene r105 = new Scene("FEEDS_SCROLL_IDLE", 5);
        FEEDS_SCROLL_IDLE = r105;
        Scene r110 = new Scene("FEEDS_SCROLL_ING", 6);
        FEEDS_SCROLL_ING = r110;
        Scene r111 = new Scene("RELEASE_BACK_TO_FEED", 7);
        RELEASE_BACK_TO_FEED = r111;
        f258799a = new Scene[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
