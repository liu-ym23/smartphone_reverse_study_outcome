package com.larus.home.api.main;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/home/api/main/AppIconsType;", "", "appIconId", "", "<init>", "(Ljava/lang/String;II)V", "getAppIconId", "()I", "DEFAULT", "ICON_2", "ICON_3", "ICON_4", "ICON_5", "ICON_6", "ICON_7", "ICON_8", "ICON_9", "ICON_10", "ICON_11", "ICON_12", "ICON_15", "ICON_25", "ICON_39", "ICON_41", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppIconsType[] f344092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344093b = null;
    private final int appIconId;

    public static final class a {
        public a() {
        }

        public static AppIconsType a(Integer r100) {
            AppIconsType[] r101 = AppIconsType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            AppIconsType r104 = r101[r103];
            int r105 = r104.getAppIconId();
            if (r100 == null) goto L10;
            if (r105 != r100.intValue()) goto L10;
            return r104;
        L10:
            r103 = r103 + 1;
            goto L3
        L11:
            return null;
        }
    }

    public static EnumEntries<AppIconsType> getEntries() {
        return f344093b;
    }

    static {
        AppIconsType r100 = new AppIconsType("DEFAULT", 0, 1);
        DEFAULT = r100;
        AppIconsType r101 = new AppIconsType("ICON_2", 1, 2);
        ICON_2 = r101;
        AppIconsType r102 = new AppIconsType("ICON_3", 2, 3);
        ICON_3 = r102;
        AppIconsType r103 = new AppIconsType("ICON_4", 3, 4);
        ICON_4 = r103;
        AppIconsType r104 = new AppIconsType("ICON_5", 4, 5);
        ICON_5 = r104;
        AppIconsType r110 = new AppIconsType("ICON_6", 5, 6);
        ICON_6 = r110;
        AppIconsType r111 = new AppIconsType("ICON_7", 6, 7);
        ICON_7 = r111;
        AppIconsType r112 = new AppIconsType("ICON_8", 7, 8);
        ICON_8 = r112;
        AppIconsType r113 = new AppIconsType("ICON_9", 8, 9);
        ICON_9 = r113;
        AppIconsType r114 = new AppIconsType("ICON_10", 9, 10);
        ICON_10 = r114;
        AppIconsType r115 = new AppIconsType("ICON_11", 10, 11);
        ICON_11 = r115;
        AppIconsType r105 = new AppIconsType("ICON_12", 11, 12);
        ICON_12 = r105;
        AppIconsType r106 = new AppIconsType("ICON_15", 12, 15);
        ICON_15 = r106;
        AppIconsType r107 = new AppIconsType("ICON_25", 13, 25);
        ICON_25 = r107;
        AppIconsType r108 = new AppIconsType("ICON_39", 14, 39);
        ICON_39 = r108;
        AppIconsType r109 = new AppIconsType("ICON_41", 15, 41);
        ICON_41 = r109;
        AppIconsType[] r116 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109};
        f344092a = r116;
        f344093b = EnumEntriesKt.enumEntries(r116);
        Companion = new a();
    }

    public static AppIconsType[] values() {
        return (AppIconsType[]) f344092a.clone();
    }

    public final int getAppIconId() {
        return this.appIconId;
    }

    public static AppIconsType valueOf(String r100) {
        return (AppIconsType) r27.a.a(AppIconsType.class, r100);
    }

    public AppIconsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.appIconId = r102;
    }
}
