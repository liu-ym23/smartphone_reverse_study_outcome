package com.larus.canvas.feature.component.instruction;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/InstructionTabEventType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "EVENT_INSTRUCTION_TAB_SELECTED", "EVENT_INSTRUCTION_TAB_UN_SELECTED", "EVENT_DROP_DOWN_BOX_SELECTED", "EVENT_MSG_INSTRUCTION_TAB_CLICK", "EVENT_INSTRUCTION_OPTION_CLICK", "EVENT_SELECTOR_PANEL_STATUS_SELECTED", "EVENT_SELECTOR_PANEL_STATUS_UNSELECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InstructionTabEventType extends Enum<InstructionTabEventType> {
    public static final InstructionTabEventType EVENT_DROP_DOWN_BOX_SELECTED = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_OPTION_CLICK = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_TAB_SELECTED = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_TAB_UN_SELECTED = null;
    public static final InstructionTabEventType EVENT_MSG_INSTRUCTION_TAB_CLICK = null;
    public static final InstructionTabEventType EVENT_SELECTOR_PANEL_STATUS_SELECTED = null;
    public static final InstructionTabEventType EVENT_SELECTOR_PANEL_STATUS_UNSELECTED = null;
    public static final InstructionTabEventType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstructionTabEventType[] f323120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323121b = null;

    public static EnumEntries<InstructionTabEventType> getEntries() {
        return f323121b;
    }

    static {
        InstructionTabEventType r100 = new InstructionTabEventType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        InstructionTabEventType r101 = new InstructionTabEventType("EVENT_INSTRUCTION_TAB_SELECTED", 1);
        EVENT_INSTRUCTION_TAB_SELECTED = r101;
        InstructionTabEventType r102 = new InstructionTabEventType("EVENT_INSTRUCTION_TAB_UN_SELECTED", 2);
        EVENT_INSTRUCTION_TAB_UN_SELECTED = r102;
        InstructionTabEventType r103 = new InstructionTabEventType("EVENT_DROP_DOWN_BOX_SELECTED", 3);
        EVENT_DROP_DOWN_BOX_SELECTED = r103;
        InstructionTabEventType r104 = new InstructionTabEventType("EVENT_MSG_INSTRUCTION_TAB_CLICK", 4);
        EVENT_MSG_INSTRUCTION_TAB_CLICK = r104;
        InstructionTabEventType r105 = new InstructionTabEventType("EVENT_INSTRUCTION_OPTION_CLICK", 5);
        EVENT_INSTRUCTION_OPTION_CLICK = r105;
        InstructionTabEventType r110 = new InstructionTabEventType("EVENT_SELECTOR_PANEL_STATUS_SELECTED", 6);
        EVENT_SELECTOR_PANEL_STATUS_SELECTED = r110;
        InstructionTabEventType r111 = new InstructionTabEventType("EVENT_SELECTOR_PANEL_STATUS_UNSELECTED", 7);
        EVENT_SELECTOR_PANEL_STATUS_UNSELECTED = r111;
        InstructionTabEventType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f323120a = r112;
        f323121b = EnumEntriesKt.enumEntries(r112);
    }

    public static InstructionTabEventType[] values() {
        return (InstructionTabEventType[]) f323120a.clone();
    }

    public static InstructionTabEventType valueOf(String r100) {
        return (InstructionTabEventType) r27.a.a(InstructionTabEventType.class, r100);
    }

    public InstructionTabEventType(String r100, int r101) {
        super(r100, r101);
    }
}
