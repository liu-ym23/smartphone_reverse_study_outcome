package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmDisplaySpeakerEditBackgroundStyle;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "DISABLE_MARKED", "DISABLE_UNMARKED", "EDITABLE_MARKED", "EDITABLE_UNMARKED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmDisplaySpeakerEditBackgroundStyle extends Enum<MmDisplaySpeakerEditBackgroundStyle> {
    public static final MmDisplaySpeakerEditBackgroundStyle DISABLE_MARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle DISABLE_UNMARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle EDITABLE_MARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle EDITABLE_UNMARKED = null;
    public static final MmDisplaySpeakerEditBackgroundStyle NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmDisplaySpeakerEditBackgroundStyle[] f435153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435154b = null;

    public static EnumEntries<MmDisplaySpeakerEditBackgroundStyle> getEntries() {
        return f435154b;
    }

    static {
        MmDisplaySpeakerEditBackgroundStyle r100 = new MmDisplaySpeakerEditBackgroundStyle(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MmDisplaySpeakerEditBackgroundStyle r101 = new MmDisplaySpeakerEditBackgroundStyle("DISABLE_MARKED", 1);
        DISABLE_MARKED = r101;
        MmDisplaySpeakerEditBackgroundStyle r102 = new MmDisplaySpeakerEditBackgroundStyle("DISABLE_UNMARKED", 2);
        DISABLE_UNMARKED = r102;
        MmDisplaySpeakerEditBackgroundStyle r103 = new MmDisplaySpeakerEditBackgroundStyle("EDITABLE_MARKED", 3);
        EDITABLE_MARKED = r103;
        MmDisplaySpeakerEditBackgroundStyle r104 = new MmDisplaySpeakerEditBackgroundStyle("EDITABLE_UNMARKED", 4);
        EDITABLE_UNMARKED = r104;
        MmDisplaySpeakerEditBackgroundStyle[] r105 = {r100, r101, r102, r103, r104};
        f435153a = r105;
        f435154b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmDisplaySpeakerEditBackgroundStyle[] values() {
        return (MmDisplaySpeakerEditBackgroundStyle[]) f435153a.clone();
    }

    public static MmDisplaySpeakerEditBackgroundStyle valueOf(String r100) {
        return (MmDisplaySpeakerEditBackgroundStyle) r27.a.a(MmDisplaySpeakerEditBackgroundStyle.class, r100);
    }

    public MmDisplaySpeakerEditBackgroundStyle(String r100, int r101) {
        super(r100, r101);
    }
}
