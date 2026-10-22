package com.bytedance.flow_audio.impl.business.tts;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/tts/AssistantSessionTerminalAction;", "", "<init>", "(Ljava/lang/String;I)V", "STOP", "CANCEL", UserProfileEvent.POSITION_NONE, "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum AssistantSessionTerminalAction extends Enum<AssistantSessionTerminalAction> {
    public static final AssistantSessionTerminalAction CANCEL = null;
    public static final AssistantSessionTerminalAction NONE = null;
    public static final AssistantSessionTerminalAction STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssistantSessionTerminalAction[] f244057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f244058b = null;

    public static EnumEntries<AssistantSessionTerminalAction> getEntries() {
        return f244058b;
    }

    static {
        AssistantSessionTerminalAction r100 = new AssistantSessionTerminalAction("STOP", 0);
        STOP = r100;
        AssistantSessionTerminalAction r101 = new AssistantSessionTerminalAction("CANCEL", 1);
        CANCEL = r101;
        AssistantSessionTerminalAction r102 = new AssistantSessionTerminalAction(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        AssistantSessionTerminalAction[] r103 = {r100, r101, r102};
        f244057a = r103;
        f244058b = EnumEntriesKt.enumEntries(r103);
    }

    public static AssistantSessionTerminalAction[] values() {
        return (AssistantSessionTerminalAction[]) f244057a.clone();
    }

    public static AssistantSessionTerminalAction valueOf(String r100) {
        return (AssistantSessionTerminalAction) r27.a.a(AssistantSessionTerminalAction.class, r100);
    }

    public AssistantSessionTerminalAction(String r100, int r101) {
        super(r100, r101);
    }
}
