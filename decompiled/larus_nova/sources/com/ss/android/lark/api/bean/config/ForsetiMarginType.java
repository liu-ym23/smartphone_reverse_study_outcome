package com.ss.android.lark.api.bean.config;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/api/bean/config/ForsetiMarginType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", UserProfileEvent.POSITION_NONE, "CUSTOM", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiMarginType extends Enum<ForsetiMarginType> {
    public static final ForsetiMarginType CUSTOM = null;
    public static final ForsetiMarginType DEFAULT = null;
    public static final ForsetiMarginType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiMarginType[] f408661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408662b = null;

    public static EnumEntries<ForsetiMarginType> getEntries() {
        return f408662b;
    }

    static {
        ForsetiMarginType r100 = new ForsetiMarginType("DEFAULT", 0);
        DEFAULT = r100;
        ForsetiMarginType r101 = new ForsetiMarginType(UserProfileEvent.POSITION_NONE, 1);
        NONE = r101;
        ForsetiMarginType r102 = new ForsetiMarginType("CUSTOM", 2);
        CUSTOM = r102;
        ForsetiMarginType[] r103 = {r100, r101, r102};
        f408661a = r103;
        f408662b = EnumEntriesKt.enumEntries(r103);
    }

    public static ForsetiMarginType[] values() {
        return (ForsetiMarginType[]) f408661a.clone();
    }

    public static ForsetiMarginType valueOf(String r100) {
        return (ForsetiMarginType) r27.a.a(ForsetiMarginType.class, r100);
    }

    public ForsetiMarginType(String r100, int r101) {
        super(r100, r101);
    }
}
