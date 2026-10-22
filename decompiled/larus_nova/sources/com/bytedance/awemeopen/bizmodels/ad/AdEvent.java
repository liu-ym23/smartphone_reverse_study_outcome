package com.bytedance.awemeopen.bizmodels.ad;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/ad/AdEvent;", "", "EVENT_CALL_PLAY_NEXT", "EVENT_ON_PLAY_START", "EVENT_ON_PLAY_STOP", "EVENT_ON_PLAY_RESUME", "EVENT_ON_PLAY_PAUSE", "EVENT_ON_PLAY_RESTART", "EVENT_ON_PLAY_COMPLETE", "EVENT_UNKNOWN", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AdEvent extends Enum<AdEvent> {
    public static final AdEvent EVENT_CALL_PLAY_NEXT = null;
    public static final AdEvent EVENT_ON_PLAY_COMPLETE = null;
    public static final AdEvent EVENT_ON_PLAY_PAUSE = null;
    public static final AdEvent EVENT_ON_PLAY_RESTART = null;
    public static final AdEvent EVENT_ON_PLAY_RESUME = null;
    public static final AdEvent EVENT_ON_PLAY_START = null;
    public static final AdEvent EVENT_ON_PLAY_STOP = null;
    public static final AdEvent EVENT_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdEvent[] f198166a = null;

    public static AdEvent valueOf(String r100) {
        return (AdEvent) a.a(AdEvent.class, r100);
    }

    public static AdEvent[] values() {
        return (AdEvent[]) f198166a.clone();
    }

    static {
        AdEvent r100 = new AdEvent("EVENT_CALL_PLAY_NEXT", 0);
        EVENT_CALL_PLAY_NEXT = r100;
        AdEvent r101 = new AdEvent("EVENT_ON_PLAY_START", 1);
        EVENT_ON_PLAY_START = r101;
        AdEvent r102 = new AdEvent("EVENT_ON_PLAY_STOP", 2);
        EVENT_ON_PLAY_STOP = r102;
        AdEvent r103 = new AdEvent("EVENT_ON_PLAY_RESUME", 3);
        EVENT_ON_PLAY_RESUME = r103;
        AdEvent r104 = new AdEvent("EVENT_ON_PLAY_PAUSE", 4);
        EVENT_ON_PLAY_PAUSE = r104;
        AdEvent r105 = new AdEvent("EVENT_ON_PLAY_RESTART", 5);
        EVENT_ON_PLAY_RESTART = r105;
        AdEvent r110 = new AdEvent("EVENT_ON_PLAY_COMPLETE", 6);
        EVENT_ON_PLAY_COMPLETE = r110;
        AdEvent r111 = new AdEvent("EVENT_UNKNOWN", 7);
        EVENT_UNKNOWN = r111;
        f198166a = new AdEvent[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public AdEvent(String r100, int r101) {
        super(r100, r101);
    }
}
