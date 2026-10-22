package com.larus.bmhome.chat.list.cell.spacer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/spacer/SpacerAnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", UserProfileEvent.POSITION_NONE, "EXPAND", "COLLAPSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpacerAnimationState extends Enum<SpacerAnimationState> {
    public static final SpacerAnimationState COLLAPSE = null;
    public static final SpacerAnimationState EXPAND = null;
    public static final SpacerAnimationState NONE = null;
    public static final SpacerAnimationState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpacerAnimationState[] f305890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f305891b = null;

    public static EnumEntries<SpacerAnimationState> getEntries() {
        return f305891b;
    }

    static {
        SpacerAnimationState r100 = new SpacerAnimationState("WAITING", 0);
        WAITING = r100;
        SpacerAnimationState r101 = new SpacerAnimationState(UserProfileEvent.POSITION_NONE, 1);
        NONE = r101;
        SpacerAnimationState r102 = new SpacerAnimationState("EXPAND", 2);
        EXPAND = r102;
        SpacerAnimationState r103 = new SpacerAnimationState("COLLAPSE", 3);
        COLLAPSE = r103;
        SpacerAnimationState[] r104 = {r100, r101, r102, r103};
        f305890a = r104;
        f305891b = EnumEntriesKt.enumEntries(r104);
    }

    public static SpacerAnimationState[] values() {
        return (SpacerAnimationState[]) f305890a.clone();
    }

    public static SpacerAnimationState valueOf(String r100) {
        return (SpacerAnimationState) r27.a.a(SpacerAnimationState.class, r100);
    }

    public SpacerAnimationState(String r100, int r101) {
        super(r100, r101);
    }
}
