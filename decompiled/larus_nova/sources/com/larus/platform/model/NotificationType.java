package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/NotificationType;", "", "<init>", "(Ljava/lang/String;I)V", "FEEDBACK", "DEFAULT", "AWEME_FEED", "QUOTA_LIMIT", "LEFT_RIGHT_IMAGE", "LEFT_RIGHT_IMAGE_TEXT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotificationType extends Enum<NotificationType> {
    public static final NotificationType AWEME_FEED = null;
    public static final NotificationType DEFAULT = null;
    public static final NotificationType FEEDBACK = null;
    public static final NotificationType LEFT_RIGHT_IMAGE = null;
    public static final NotificationType LEFT_RIGHT_IMAGE_TEXT = null;
    public static final NotificationType QUOTA_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationType[] f365477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365478b = null;

    public static EnumEntries<NotificationType> getEntries() {
        return f365478b;
    }

    static {
        NotificationType r100 = new NotificationType("FEEDBACK", 0);
        FEEDBACK = r100;
        NotificationType r101 = new NotificationType("DEFAULT", 1);
        DEFAULT = r101;
        NotificationType r102 = new NotificationType("AWEME_FEED", 2);
        AWEME_FEED = r102;
        NotificationType r103 = new NotificationType("QUOTA_LIMIT", 3);
        QUOTA_LIMIT = r103;
        NotificationType r104 = new NotificationType("LEFT_RIGHT_IMAGE", 4);
        LEFT_RIGHT_IMAGE = r104;
        NotificationType r105 = new NotificationType("LEFT_RIGHT_IMAGE_TEXT", 5);
        LEFT_RIGHT_IMAGE_TEXT = r105;
        NotificationType[] r110 = {r100, r101, r102, r103, r104, r105};
        f365477a = r110;
        f365478b = EnumEntriesKt.enumEntries(r110);
    }

    public static NotificationType[] values() {
        return (NotificationType[]) f365477a.clone();
    }

    public static NotificationType valueOf(String r100) {
        return (NotificationType) a.a(NotificationType.class, r100);
    }

    public NotificationType(String r100, int r101) {
        super(r100, r101);
    }
}
