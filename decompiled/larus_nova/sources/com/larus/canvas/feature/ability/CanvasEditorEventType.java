package com.larus.canvas.feature.ability;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/canvas/feature/ability/CanvasEditorEventType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "EVENT_CLICK_SEND_BUTTON", "EVENT_FINISH_SPEAK", "EVENT_FINISH_PASTE_AND_SEND", "EVENT_BOTTOM_INSET_UPDATE", "EVENT_INSTRUCTION_RENDER_CHANGE", "EVENT_DROP_DOWN_BOX_SELECTED", "EVENT_MSG_INSTRUCTION_TAB_CLICK", "EVENT_INSTRUCTION_TAB_SELECTED", "EVENT_INSTRUCTION_TAB_UN_SELECTED", "EVENT_INSTRUCTION_OPTION_CLICK", "EVENT_SELECTOR_PANEL_STATUS_CHANGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasEditorEventType extends Enum<CanvasEditorEventType> {
    public static final CanvasEditorEventType EVENT_BOTTOM_INSET_UPDATE = null;
    public static final CanvasEditorEventType EVENT_CLICK_SEND_BUTTON = null;
    public static final CanvasEditorEventType EVENT_DROP_DOWN_BOX_SELECTED = null;
    public static final CanvasEditorEventType EVENT_FINISH_PASTE_AND_SEND = null;
    public static final CanvasEditorEventType EVENT_FINISH_SPEAK = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_OPTION_CLICK = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_RENDER_CHANGE = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_TAB_SELECTED = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_TAB_UN_SELECTED = null;
    public static final CanvasEditorEventType EVENT_MSG_INSTRUCTION_TAB_CLICK = null;
    public static final CanvasEditorEventType EVENT_SELECTOR_PANEL_STATUS_CHANGE = null;
    public static final CanvasEditorEventType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CanvasEditorEventType[] f323024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323025b = null;

    public static EnumEntries<CanvasEditorEventType> getEntries() {
        return f323025b;
    }

    static {
        CanvasEditorEventType r100 = new CanvasEditorEventType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CanvasEditorEventType r101 = new CanvasEditorEventType("EVENT_CLICK_SEND_BUTTON", 1);
        EVENT_CLICK_SEND_BUTTON = r101;
        CanvasEditorEventType r102 = new CanvasEditorEventType("EVENT_FINISH_SPEAK", 2);
        EVENT_FINISH_SPEAK = r102;
        CanvasEditorEventType r103 = new CanvasEditorEventType("EVENT_FINISH_PASTE_AND_SEND", 3);
        EVENT_FINISH_PASTE_AND_SEND = r103;
        CanvasEditorEventType r104 = new CanvasEditorEventType("EVENT_BOTTOM_INSET_UPDATE", 4);
        EVENT_BOTTOM_INSET_UPDATE = r104;
        CanvasEditorEventType r105 = new CanvasEditorEventType("EVENT_INSTRUCTION_RENDER_CHANGE", 5);
        EVENT_INSTRUCTION_RENDER_CHANGE = r105;
        CanvasEditorEventType r110 = new CanvasEditorEventType("EVENT_DROP_DOWN_BOX_SELECTED", 6);
        EVENT_DROP_DOWN_BOX_SELECTED = r110;
        CanvasEditorEventType r111 = new CanvasEditorEventType("EVENT_MSG_INSTRUCTION_TAB_CLICK", 7);
        EVENT_MSG_INSTRUCTION_TAB_CLICK = r111;
        CanvasEditorEventType r112 = new CanvasEditorEventType("EVENT_INSTRUCTION_TAB_SELECTED", 8);
        EVENT_INSTRUCTION_TAB_SELECTED = r112;
        CanvasEditorEventType r113 = new CanvasEditorEventType("EVENT_INSTRUCTION_TAB_UN_SELECTED", 9);
        EVENT_INSTRUCTION_TAB_UN_SELECTED = r113;
        CanvasEditorEventType r114 = new CanvasEditorEventType("EVENT_INSTRUCTION_OPTION_CLICK", 10);
        EVENT_INSTRUCTION_OPTION_CLICK = r114;
        CanvasEditorEventType r115 = new CanvasEditorEventType("EVENT_SELECTOR_PANEL_STATUS_CHANGE", 11);
        EVENT_SELECTOR_PANEL_STATUS_CHANGE = r115;
        CanvasEditorEventType[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f323024a = r106;
        f323025b = EnumEntriesKt.enumEntries(r106);
    }

    public static CanvasEditorEventType[] values() {
        return (CanvasEditorEventType[]) f323024a.clone();
    }

    public static CanvasEditorEventType valueOf(String r100) {
        return (CanvasEditorEventType) a.a(CanvasEditorEventType.class, r100);
    }

    public CanvasEditorEventType(String r100, int r101) {
        super(r100, r101);
    }
}
