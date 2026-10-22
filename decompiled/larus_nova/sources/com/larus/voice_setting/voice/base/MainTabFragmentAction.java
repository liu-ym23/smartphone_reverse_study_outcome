package com.larus.voice_setting.voice.base;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "CREATE_VOICE", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MainTabFragmentAction extends Enum<MainTabFragmentAction> {
    public static final MainTabFragmentAction CREATE_VOICE = null;
    public static final MainTabFragmentAction NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MainTabFragmentAction[] f376355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376356b = null;

    public static EnumEntries<MainTabFragmentAction> getEntries() {
        return f376356b;
    }

    static {
        MainTabFragmentAction r100 = new MainTabFragmentAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MainTabFragmentAction r101 = new MainTabFragmentAction("CREATE_VOICE", 1);
        CREATE_VOICE = r101;
        MainTabFragmentAction[] r102 = {r100, r101};
        f376355a = r102;
        f376356b = EnumEntriesKt.enumEntries(r102);
    }

    public static MainTabFragmentAction[] values() {
        return (MainTabFragmentAction[]) f376355a.clone();
    }

    public static MainTabFragmentAction valueOf(String r100) {
        return (MainTabFragmentAction) r27.a.a(MainTabFragmentAction.class, r100);
    }

    public MainTabFragmentAction(String r100, int r101) {
        super(r100, r101);
    }
}
