package com.larus.im.service.audio;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/ModalType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "AUDIO", "VIDEO", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModalType extends Enum<ModalType> {
    public static final ModalType AUDIO = null;
    public static final ModalType NONE = null;
    public static final ModalType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModalType[] f350671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350672b = null;

    public static EnumEntries<ModalType> getEntries() {
        return f350672b;
    }

    static {
        ModalType r100 = new ModalType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ModalType r101 = new ModalType("AUDIO", 1);
        AUDIO = r101;
        ModalType r102 = new ModalType("VIDEO", 2);
        VIDEO = r102;
        ModalType[] r103 = {r100, r101, r102};
        f350671a = r103;
        f350672b = EnumEntriesKt.enumEntries(r103);
    }

    public static ModalType[] values() {
        return (ModalType[]) f350671a.clone();
    }

    public static ModalType valueOf(String r100) {
        return (ModalType) r27.a.a(ModalType.class, r100);
    }

    public ModalType(String r100, int r101) {
        super(r100, r101);
    }
}
