package com.ss.android.lark.conditional.access.traffic.handler;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/handler/MatchRegulate;", "", "<init>", "(Ljava/lang/String;I)V", "ACCURATE", "ANY", UserProfileEvent.POSITION_NONE, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MatchRegulate extends Enum<MatchRegulate> {
    public static final MatchRegulate ACCURATE = null;
    public static final MatchRegulate ANY = null;
    public static final MatchRegulate NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MatchRegulate[] f418438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f418439b = null;

    public static EnumEntries<MatchRegulate> getEntries() {
        return f418439b;
    }

    static {
        MatchRegulate r100 = new MatchRegulate("ACCURATE", 0);
        ACCURATE = r100;
        MatchRegulate r101 = new MatchRegulate("ANY", 1);
        ANY = r101;
        MatchRegulate r102 = new MatchRegulate(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        MatchRegulate[] r103 = {r100, r101, r102};
        f418438a = r103;
        f418439b = EnumEntriesKt.enumEntries(r103);
    }

    public static MatchRegulate[] values() {
        return (MatchRegulate[]) f418438a.clone();
    }

    public static MatchRegulate valueOf(String r100) {
        return (MatchRegulate) a.a(MatchRegulate.class, r100);
    }

    public MatchRegulate(String r100, int r101) {
        super(r100, r101);
    }
}
