package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.media.MediaScene;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatHostType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, MediaScene.SYSTEM, BannerBizName.ACTIVITY, "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingFloatHostType extends Enum<MmRecordingFloatHostType> {
    public static final MmRecordingFloatHostType ACTIVITY = null;
    public static final MmRecordingFloatHostType NONE = null;
    public static final MmRecordingFloatHostType SYSTEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingFloatHostType[] f436876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f436877b = null;

    public static EnumEntries<MmRecordingFloatHostType> getEntries() {
        return f436877b;
    }

    static {
        MmRecordingFloatHostType r100 = new MmRecordingFloatHostType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MmRecordingFloatHostType r101 = new MmRecordingFloatHostType(MediaScene.SYSTEM, 1);
        SYSTEM = r101;
        MmRecordingFloatHostType r102 = new MmRecordingFloatHostType(BannerBizName.ACTIVITY, 2);
        ACTIVITY = r102;
        MmRecordingFloatHostType[] r103 = {r100, r101, r102};
        f436876a = r103;
        f436877b = EnumEntriesKt.enumEntries(r103);
    }

    public static MmRecordingFloatHostType[] values() {
        return (MmRecordingFloatHostType[]) f436876a.clone();
    }

    public static MmRecordingFloatHostType valueOf(String r100) {
        return (MmRecordingFloatHostType) a.a(MmRecordingFloatHostType.class, r100);
    }

    public MmRecordingFloatHostType(String r100, int r101) {
        super(r100, r101);
    }
}
