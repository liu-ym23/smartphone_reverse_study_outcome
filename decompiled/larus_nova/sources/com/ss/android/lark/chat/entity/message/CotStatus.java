package com.ss.android.lark.chat.entity.message;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotStatus;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "RUNNING", "DONE", "ERROR", "TIMEOUT", "INTERRUPTED", "PAUSED", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotStatus extends Enum<CotStatus> {
    public static final a Companion = null;
    public static final CotStatus DONE = null;
    public static final CotStatus ERROR = null;
    public static final CotStatus INTERRUPTED = null;
    public static final CotStatus NONE = null;
    public static final CotStatus PAUSED = null;
    public static final CotStatus RUNNING = null;
    public static final CotStatus TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotStatus[] f415214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415215b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CotStatus> getEntries() {
        return f415215b;
    }

    static {
        CotStatus r100 = new CotStatus(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CotStatus r101 = new CotStatus("RUNNING", 1);
        RUNNING = r101;
        CotStatus r102 = new CotStatus("DONE", 2);
        DONE = r102;
        CotStatus r103 = new CotStatus("ERROR", 3);
        ERROR = r103;
        CotStatus r104 = new CotStatus("TIMEOUT", 4);
        TIMEOUT = r104;
        CotStatus r105 = new CotStatus("INTERRUPTED", 5);
        INTERRUPTED = r105;
        CotStatus r110 = new CotStatus("PAUSED", 6);
        PAUSED = r110;
        CotStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f415214a = r111;
        f415215b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static CotStatus[] values() {
        return (CotStatus[]) f415214a.clone();
    }

    @JvmStatic
    public static final CotStatus fromValue(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 == 4) goto L17;
        return NONE;
    L17:
        return TIMEOUT;
    L18:
        return ERROR;
    L19:
        return DONE;
    L15:
        return RUNNING;
    }

    public static CotStatus valueOf(String r100) {
        return (CotStatus) r27.a.a(CotStatus.class, r100);
    }

    public CotStatus(String r100, int r101) {
        super(r100, r101);
    }
}
