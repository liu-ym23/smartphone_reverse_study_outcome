package com.ss.android.lark.widget.photopicker.coordinator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/coordinator/PreviewEvent;", "", "<init>", "(Ljava/lang/String;I)V", "PAGER_ENTER_ANIMATION_START", "PAGER_ENTER_ANIMATION_END", "PAGER_EXIT_ANIMATION_START", "PLAYER_EVENT_ON_VIDEO_RENDER_START", "PAGER_ON_DRAG_SCALE_BEGIN", "PAGER_ON_DRAG_SCALE_END", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewEvent extends Enum<PreviewEvent> {
    public static final PreviewEvent PAGER_ENTER_ANIMATION_END = null;
    public static final PreviewEvent PAGER_ENTER_ANIMATION_START = null;
    public static final PreviewEvent PAGER_EXIT_ANIMATION_START = null;
    public static final PreviewEvent PAGER_ON_DRAG_SCALE_BEGIN = null;
    public static final PreviewEvent PAGER_ON_DRAG_SCALE_END = null;
    public static final PreviewEvent PLAYER_EVENT_ON_VIDEO_RENDER_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewEvent[] f447464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f447465b = null;

    public static EnumEntries<PreviewEvent> getEntries() {
        return f447465b;
    }

    static {
        PreviewEvent r100 = new PreviewEvent("PAGER_ENTER_ANIMATION_START", 0);
        PAGER_ENTER_ANIMATION_START = r100;
        PreviewEvent r101 = new PreviewEvent("PAGER_ENTER_ANIMATION_END", 1);
        PAGER_ENTER_ANIMATION_END = r101;
        PreviewEvent r102 = new PreviewEvent("PAGER_EXIT_ANIMATION_START", 2);
        PAGER_EXIT_ANIMATION_START = r102;
        PreviewEvent r103 = new PreviewEvent("PLAYER_EVENT_ON_VIDEO_RENDER_START", 3);
        PLAYER_EVENT_ON_VIDEO_RENDER_START = r103;
        PreviewEvent r104 = new PreviewEvent("PAGER_ON_DRAG_SCALE_BEGIN", 4);
        PAGER_ON_DRAG_SCALE_BEGIN = r104;
        PreviewEvent r105 = new PreviewEvent("PAGER_ON_DRAG_SCALE_END", 5);
        PAGER_ON_DRAG_SCALE_END = r105;
        PreviewEvent[] r110 = {r100, r101, r102, r103, r104, r105};
        f447464a = r110;
        f447465b = EnumEntriesKt.enumEntries(r110);
    }

    public static PreviewEvent[] values() {
        return (PreviewEvent[]) f447464a.clone();
    }

    public static PreviewEvent valueOf(String r100) {
        return (PreviewEvent) a.a(PreviewEvent.class, r100);
    }

    public PreviewEvent(String r100, int r101) {
        super(r100, r101);
    }
}
