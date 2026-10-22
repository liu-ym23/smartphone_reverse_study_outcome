package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/event/SubtitleSource;", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "PULL_TO_REFRESH", "NETWORK_RECONNECT", "LANGUAGE_CHANGE", "BILINGUAL_SWITCH", "DEFAULT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubtitleSource extends Enum<SubtitleSource> {
    public static final SubtitleSource BILINGUAL_SWITCH = null;
    public static final SubtitleSource DEFAULT = null;
    public static final SubtitleSource LANGUAGE_CHANGE = null;
    public static final SubtitleSource NETWORK_RECONNECT = null;
    public static final SubtitleSource PULL_TO_REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleSource[] f435217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435218b = null;
    private final String desc;

    public static EnumEntries<SubtitleSource> getEntries() {
        return f435218b;
    }

    static {
        SubtitleSource r100 = new SubtitleSource("PULL_TO_REFRESH", 0, "pull_to_refresh");
        PULL_TO_REFRESH = r100;
        SubtitleSource r101 = new SubtitleSource("NETWORK_RECONNECT", 1, "network_reconnect");
        NETWORK_RECONNECT = r101;
        SubtitleSource r102 = new SubtitleSource("LANGUAGE_CHANGE", 2, "language_change");
        LANGUAGE_CHANGE = r102;
        SubtitleSource r103 = new SubtitleSource("BILINGUAL_SWITCH", 3, "bilingual_switch");
        BILINGUAL_SWITCH = r103;
        SubtitleSource r104 = new SubtitleSource("DEFAULT", 4, "default");
        DEFAULT = r104;
        SubtitleSource[] r105 = {r100, r101, r102, r103, r104};
        f435217a = r105;
        f435218b = EnumEntriesKt.enumEntries(r105);
    }

    public static SubtitleSource[] values() {
        return (SubtitleSource[]) f435217a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public static SubtitleSource valueOf(String r100) {
        return (SubtitleSource) a.a(SubtitleSource.class, r100);
    }

    public SubtitleSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
