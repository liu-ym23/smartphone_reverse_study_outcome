package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmDisplayAvatarTypeData;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "KEY", "URL", "USER_ID_FALLBACK", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmDisplayAvatarTypeData extends Enum<MmDisplayAvatarTypeData> {
    public static final MmDisplayAvatarTypeData KEY = null;
    public static final MmDisplayAvatarTypeData NONE = null;
    public static final MmDisplayAvatarTypeData URL = null;
    public static final MmDisplayAvatarTypeData USER_ID_FALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmDisplayAvatarTypeData[] f433514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433515b = null;

    public static EnumEntries<MmDisplayAvatarTypeData> getEntries() {
        return f433515b;
    }

    static {
        MmDisplayAvatarTypeData r100 = new MmDisplayAvatarTypeData(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MmDisplayAvatarTypeData r101 = new MmDisplayAvatarTypeData("KEY", 1);
        KEY = r101;
        MmDisplayAvatarTypeData r102 = new MmDisplayAvatarTypeData("URL", 2);
        URL = r102;
        MmDisplayAvatarTypeData r103 = new MmDisplayAvatarTypeData("USER_ID_FALLBACK", 3);
        USER_ID_FALLBACK = r103;
        MmDisplayAvatarTypeData[] r104 = {r100, r101, r102, r103};
        f433514a = r104;
        f433515b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmDisplayAvatarTypeData[] values() {
        return (MmDisplayAvatarTypeData[]) f433514a.clone();
    }

    public static MmDisplayAvatarTypeData valueOf(String r100) {
        return (MmDisplayAvatarTypeData) a.a(MmDisplayAvatarTypeData.class, r100);
    }

    public MmDisplayAvatarTypeData(String r100, int r101) {
        super(r100, r101);
    }
}
