package com.obric.assistant.login;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/assistant/login/ObricLoginType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "O_SYSTEM_ONE_LOGIN", "LARK_ENTERPRISE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricLoginType extends Enum<ObricLoginType> {
    public static final a Companion = null;
    public static final ObricLoginType LARK_ENTERPRISE = null;
    public static final ObricLoginType NONE = null;
    public static final ObricLoginType O_SYSTEM_ONE_LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricLoginType[] f390246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390247b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ObricLoginType> getEntries() {
        return f390247b;
    }

    static {
        ObricLoginType r100 = new ObricLoginType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ObricLoginType r101 = new ObricLoginType("O_SYSTEM_ONE_LOGIN", 1);
        O_SYSTEM_ONE_LOGIN = r101;
        ObricLoginType r102 = new ObricLoginType("LARK_ENTERPRISE", 2);
        LARK_ENTERPRISE = r102;
        ObricLoginType[] r103 = {r100, r101, r102};
        f390246a = r103;
        f390247b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ObricLoginType[] values() {
        return (ObricLoginType[]) f390246a.clone();
    }

    public static ObricLoginType valueOf(String r100) {
        return (ObricLoginType) r27.a.a(ObricLoginType.class, r100);
    }

    public ObricLoginType(String r100, int r101) {
        super(r100, r101);
    }
}
