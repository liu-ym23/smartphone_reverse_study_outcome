package com.ss.android.lark.feed.app.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/AutoMuteSettingNoticeType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "DIGITAL_NOTICE", "RED_DOT_NOTICE", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AutoMuteSettingNoticeType extends Enum<AutoMuteSettingNoticeType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMuteSettingNoticeType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final AutoMuteSettingNoticeType DIGITAL_NOTICE = null;
    public static final AutoMuteSettingNoticeType RED_DOT_NOTICE = null;
    public static final AutoMuteSettingNoticeType UNKNOWN = null;
    private final int number;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/AutoMuteSettingNoticeType$Companion;", "", "<init>", "()V", "valueOf", "Lcom/ss/android/lark/feed/app/entity/AutoMuteSettingNoticeType;", "value", "", "(Ljava/lang/Integer;)Lcom/ss/android/lark/feed/app/entity/AutoMuteSettingNoticeType;", "forNumber", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final AutoMuteSettingNoticeType forNumber(Integer r100) {
            if (r100 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
        L12:
            if (r100 == null) goto L18;
            if (r100.intValue() != 2) goto L18;
            return AutoMuteSettingNoticeType.RED_DOT_NOTICE;
        L18:
            return AutoMuteSettingNoticeType.UNKNOWN;
        L10:
            if (r100.intValue() != 1) goto L12;
            return AutoMuteSettingNoticeType.DIGITAL_NOTICE;
        L5:
            if (r100.intValue() != 0) goto L7;
            return AutoMuteSettingNoticeType.UNKNOWN;
        }

        @JvmStatic
        public final AutoMuteSettingNoticeType valueOf(Integer r100) {
            return forNumber(r100);
        }
    }

    private static final /* synthetic */ AutoMuteSettingNoticeType[] $values() {
        return new AutoMuteSettingNoticeType[]{UNKNOWN, DIGITAL_NOTICE, RED_DOT_NOTICE};
    }

    @JvmStatic
    public static final AutoMuteSettingNoticeType forNumber(Integer r100) {
        return Companion.forNumber(r100);
    }

    public static EnumEntries<AutoMuteSettingNoticeType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final AutoMuteSettingNoticeType valueOf(Integer r100) {
        return Companion.valueOf(r100);
    }

    static {
        UNKNOWN = new AutoMuteSettingNoticeType("UNKNOWN", 0, 0);
        DIGITAL_NOTICE = new AutoMuteSettingNoticeType("DIGITAL_NOTICE", 1, 1);
        RED_DOT_NOTICE = new AutoMuteSettingNoticeType("RED_DOT_NOTICE", 2, 2);
        AutoMuteSettingNoticeType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static AutoMuteSettingNoticeType[] values() {
        return (AutoMuteSettingNoticeType[]) $VALUES.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static AutoMuteSettingNoticeType valueOf(String r100) {
        return (AutoMuteSettingNoticeType) a.a(AutoMuteSettingNoticeType.class, r100);
    }

    private AutoMuteSettingNoticeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
