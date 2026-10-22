package com.larus.music.qq;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/music/qq/QQMusicBizErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "RESULT_CODE_OK", "SYSTEM_ERROR", "AUTH_ERROR", "NOT_LOGIN", "NOT_INSTALLED", "NOT_CONNECT", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QQMusicBizErrorCode extends Enum<QQMusicBizErrorCode> {
    public static final QQMusicBizErrorCode AUTH_ERROR = null;
    public static final QQMusicBizErrorCode NOT_CONNECT = null;
    public static final QQMusicBizErrorCode NOT_INSTALLED = null;
    public static final QQMusicBizErrorCode NOT_LOGIN = null;
    public static final QQMusicBizErrorCode RESULT_CODE_OK = null;
    public static final QQMusicBizErrorCode SYSTEM_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QQMusicBizErrorCode[] f359496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359497b = null;

    public static EnumEntries<QQMusicBizErrorCode> getEntries() {
        return f359497b;
    }

    static {
        QQMusicBizErrorCode r100 = new QQMusicBizErrorCode("RESULT_CODE_OK", 0);
        RESULT_CODE_OK = r100;
        QQMusicBizErrorCode r101 = new QQMusicBizErrorCode("SYSTEM_ERROR", 1);
        SYSTEM_ERROR = r101;
        QQMusicBizErrorCode r102 = new QQMusicBizErrorCode("AUTH_ERROR", 2);
        AUTH_ERROR = r102;
        QQMusicBizErrorCode r103 = new QQMusicBizErrorCode("NOT_LOGIN", 3);
        NOT_LOGIN = r103;
        QQMusicBizErrorCode r104 = new QQMusicBizErrorCode("NOT_INSTALLED", 4);
        NOT_INSTALLED = r104;
        QQMusicBizErrorCode r105 = new QQMusicBizErrorCode("NOT_CONNECT", 5);
        NOT_CONNECT = r105;
        QQMusicBizErrorCode[] r110 = {r100, r101, r102, r103, r104, r105};
        f359496a = r110;
        f359497b = EnumEntriesKt.enumEntries(r110);
    }

    public static QQMusicBizErrorCode[] values() {
        return (QQMusicBizErrorCode[]) f359496a.clone();
    }

    public static QQMusicBizErrorCode valueOf(String r100) {
        return (QQMusicBizErrorCode) r27.a.a(QQMusicBizErrorCode.class, r100);
    }

    public QQMusicBizErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
