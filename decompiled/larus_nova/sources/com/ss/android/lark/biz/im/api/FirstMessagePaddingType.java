package com.ss.android.lark.biz.im.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/FirstMessagePaddingType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TITLE", "TITLE_AND_TAB", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FirstMessagePaddingType extends Enum<FirstMessagePaddingType> {
    public static final FirstMessagePaddingType NONE = null;
    public static final FirstMessagePaddingType TITLE = null;
    public static final FirstMessagePaddingType TITLE_AND_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FirstMessagePaddingType[] f409868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409869b = null;

    public static EnumEntries<FirstMessagePaddingType> getEntries() {
        return f409869b;
    }

    static {
        FirstMessagePaddingType r100 = new FirstMessagePaddingType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        FirstMessagePaddingType r101 = new FirstMessagePaddingType("TITLE", 1);
        TITLE = r101;
        FirstMessagePaddingType r102 = new FirstMessagePaddingType("TITLE_AND_TAB", 2);
        TITLE_AND_TAB = r102;
        FirstMessagePaddingType[] r103 = {r100, r101, r102};
        f409868a = r103;
        f409869b = EnumEntriesKt.enumEntries(r103);
    }

    public static FirstMessagePaddingType[] values() {
        return (FirstMessagePaddingType[]) f409868a.clone();
    }

    public static FirstMessagePaddingType valueOf(String r100) {
        return (FirstMessagePaddingType) r27.a.a(FirstMessagePaddingType.class, r100);
    }

    public FirstMessagePaddingType(String r100, int r101) {
        super(r100, r101);
    }
}
