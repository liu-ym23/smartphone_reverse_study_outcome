package com.larus.canvas.feature.ability;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/canvas/feature/ability/CanvasInputEventType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "EVENT_CLICK_SEND_BUTTON", "EVENT_FINISH_SPEAK", "EVENT_FINISH_PASTE_AND_SEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasInputEventType extends Enum<CanvasInputEventType> {
    public static final CanvasInputEventType EVENT_CLICK_SEND_BUTTON = null;
    public static final CanvasInputEventType EVENT_FINISH_PASTE_AND_SEND = null;
    public static final CanvasInputEventType EVENT_FINISH_SPEAK = null;
    public static final CanvasInputEventType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CanvasInputEventType[] f323026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323027b = null;

    public static EnumEntries<CanvasInputEventType> getEntries() {
        return f323027b;
    }

    static {
        CanvasInputEventType r100 = new CanvasInputEventType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CanvasInputEventType r101 = new CanvasInputEventType("EVENT_CLICK_SEND_BUTTON", 1);
        EVENT_CLICK_SEND_BUTTON = r101;
        CanvasInputEventType r102 = new CanvasInputEventType("EVENT_FINISH_SPEAK", 2);
        EVENT_FINISH_SPEAK = r102;
        CanvasInputEventType r103 = new CanvasInputEventType("EVENT_FINISH_PASTE_AND_SEND", 3);
        EVENT_FINISH_PASTE_AND_SEND = r103;
        CanvasInputEventType[] r104 = {r100, r101, r102, r103};
        f323026a = r104;
        f323027b = EnumEntriesKt.enumEntries(r104);
    }

    public static CanvasInputEventType[] values() {
        return (CanvasInputEventType[]) f323026a.clone();
    }

    public static CanvasInputEventType valueOf(String r100) {
        return (CanvasInputEventType) a.a(CanvasInputEventType.class, r100);
    }

    public CanvasInputEventType(String r100, int r101) {
        super(r100, r101);
    }
}
