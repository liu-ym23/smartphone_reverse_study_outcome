package com.ss.android.lark.keyboard.event;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/event/ImeState;", "Lcom/ss/android/lark/keyboard/event/ITransformable;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "IME", "PANEL", "getTag", "", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImeState extends Enum<ImeState> implements m {
    public static final ImeState IME = null;
    public static final ImeState NONE = null;
    public static final ImeState PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImeState[] f429289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429290b = null;

    public static EnumEntries<ImeState> getEntries() {
        return f429290b;
    }

    static {
        ImeState r100 = new ImeState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ImeState r101 = new ImeState("IME", 1);
        IME = r101;
        ImeState r102 = new ImeState("PANEL", 2);
        PANEL = r102;
        ImeState[] r103 = {r100, r101, r102};
        f429289a = r103;
        f429290b = EnumEntriesKt.enumEntries(r103);
    }

    public static ImeState[] values() {
        return (ImeState[]) f429289a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        return name();
    }

    public static ImeState valueOf(String r100) {
        return (ImeState) r27.a.a(ImeState.class, r100);
    }

    public ImeState(String r100, int r101) {
        super(r100, r101);
    }
}
