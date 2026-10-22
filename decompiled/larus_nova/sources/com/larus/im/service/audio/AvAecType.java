package com.larus.im.service.audio;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/AvAecType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", UserProfileEvent.POSITION_NONE, "SAMI", "RTC", "RTC_SPEECH", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvAecType extends Enum<AvAecType> {
    public static final AvAecType NONE = null;
    public static final AvAecType RTC = null;
    public static final AvAecType RTC_SPEECH = null;
    public static final AvAecType SAMI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvAecType[] f350631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350632b = null;
    private final int type;

    public static EnumEntries<AvAecType> getEntries() {
        return f350632b;
    }

    static {
        AvAecType r100 = new AvAecType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        AvAecType r101 = new AvAecType("SAMI", 1, 1);
        SAMI = r101;
        AvAecType r102 = new AvAecType("RTC", 2, 2);
        RTC = r102;
        AvAecType r103 = new AvAecType("RTC_SPEECH", 3, 3);
        RTC_SPEECH = r103;
        AvAecType[] r104 = {r100, r101, r102, r103};
        f350631a = r104;
        f350632b = EnumEntriesKt.enumEntries(r104);
    }

    public static AvAecType[] values() {
        return (AvAecType[]) f350631a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AvAecType valueOf(String r100) {
        return (AvAecType) r27.a.a(AvAecType.class, r100);
    }

    public AvAecType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
