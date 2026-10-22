package com.larus.home.api.main;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/home/api/main/AppIconsType;", XmlPullParser.NO_NAMESPACE, "appIconId", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;II)V", "getAppIconId", "()I", "DEFAULT", "ICON_2", "ICON_3", "ICON_4", "ICON_5", "ICON_6", "ICON_7", "ICON_8", "ICON_9", "ICON_10", "ICON_11", "ICON_12", "ICON_15", "ICON_25", "ICON_39", "ICON_41", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final enum AppIconsType extends Enum<AppIconsType> {
    public static final a Companion = null;
    public static final AppIconsType DEFAULT = null;
    public static final AppIconsType ICON_10 = null;
    public static final AppIconsType ICON_11 = null;
    public static final AppIconsType ICON_12 = null;
    public static final AppIconsType ICON_15 = null;
    public static final AppIconsType ICON_2 = null;
    public static final AppIconsType ICON_25 = null;
    public static final AppIconsType ICON_3 = null;
    public static final AppIconsType ICON_39 = null;
    public static final AppIconsType ICON_4 = null;
    public static final AppIconsType ICON_41 = null;
    public static final AppIconsType ICON_5 = null;
    public static final AppIconsType ICON_6 = null;
    public static final AppIconsType ICON_7 = null;
    public static final AppIconsType ICON_8 = null;
    public static final AppIconsType ICON_9 = null;
    public static final /* synthetic */ AppIconsType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int appIconId;

    public static final class a {
        public a() {
        }

        public static AppIconsType a(Integer r6) {
            AppIconsType[] r0 = AppIconsType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L11;
            AppIconsType r3 = r0[r2];
            int r4 = r3.getAppIconId();
            if (r6 == null) goto L10;
            if (r4 != r6.intValue()) goto L10;
            return r3;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return null;
        }
    }

    public static EnumEntries<AppIconsType> getEntries() {
        return b;
    }

    static {
        AppIconsType r0 = new AppIconsType("DEFAULT", 0, 1);
        DEFAULT = r0;
        AppIconsType r1 = new AppIconsType("ICON_2", 1, 2);
        ICON_2 = r1;
        AppIconsType r4 = new AppIconsType("ICON_3", 2, 3);
        ICON_3 = r4;
        AppIconsType r6 = new AppIconsType("ICON_4", 3, 4);
        ICON_4 = r6;
        AppIconsType r8 = new AppIconsType("ICON_5", 4, 5);
        ICON_5 = r8;
        AppIconsType r10 = new AppIconsType("ICON_6", 5, 6);
        ICON_6 = r10;
        AppIconsType r12 = new AppIconsType("ICON_7", 6, 7);
        ICON_7 = r12;
        AppIconsType r14 = new AppIconsType("ICON_8", 7, 8);
        ICON_8 = r14;
        AppIconsType r13 = new AppIconsType("ICON_9", 8, 9);
        ICON_9 = r13;
        AppIconsType r15 = new AppIconsType("ICON_10", 9, 10);
        ICON_10 = r15;
        AppIconsType r11 = new AppIconsType("ICON_11", 10, 11);
        ICON_11 = r11;
        AppIconsType r9 = new AppIconsType("ICON_12", 11, 12);
        ICON_12 = r9;
        AppIconsType r7 = new AppIconsType("ICON_15", 12, 15);
        ICON_15 = r7;
        AppIconsType r5 = new AppIconsType("ICON_25", 13, 25);
        ICON_25 = r5;
        AppIconsType r3 = new AppIconsType("ICON_39", 14, 39);
        ICON_39 = r3;
        AppIconsType r16 = new AppIconsType("ICON_41", 15, 41);
        ICON_41 = r16;
        AppIconsType[] r2 = {r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r5, r3, r16};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static AppIconsType[] values() {
        return (AppIconsType[]) a.clone();
    }

    public final int getAppIconId() {
        return this.appIconId;
    }

    public static AppIconsType valueOf(String r1) {
        return (AppIconsType) r27.a.a(AppIconsType.class, r1);
    }

    public AppIconsType(String r1, int r2, int r3) {
        super(r1, r2);
        this.appIconId = r3;
    }
}
