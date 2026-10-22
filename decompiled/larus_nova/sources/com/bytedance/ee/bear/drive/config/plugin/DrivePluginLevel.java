package com.bytedance.ee.bear.drive.config.plugin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/config/plugin/DrivePluginLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Toolbar", "Loading", "Downloading", "Preview", "Banner", "At", "Comment", "ExtraInfo", "GOD", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePluginLevel extends Enum<DrivePluginLevel> {
    public static final DrivePluginLevel At = null;
    public static final DrivePluginLevel Banner = null;
    public static final DrivePluginLevel Comment = null;
    public static final DrivePluginLevel Downloading = null;
    public static final DrivePluginLevel ExtraInfo = null;
    public static final DrivePluginLevel GOD = null;
    public static final DrivePluginLevel Loading = null;
    public static final DrivePluginLevel Preview = null;
    public static final DrivePluginLevel Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePluginLevel[] f224086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f224087b = null;

    public static EnumEntries<DrivePluginLevel> getEntries() {
        return f224087b;
    }

    static {
        DrivePluginLevel r100 = new DrivePluginLevel("Toolbar", 0);
        Toolbar = r100;
        DrivePluginLevel r101 = new DrivePluginLevel("Loading", 1);
        Loading = r101;
        DrivePluginLevel r102 = new DrivePluginLevel("Downloading", 2);
        Downloading = r102;
        DrivePluginLevel r103 = new DrivePluginLevel("Preview", 3);
        Preview = r103;
        DrivePluginLevel r104 = new DrivePluginLevel("Banner", 4);
        Banner = r104;
        DrivePluginLevel r105 = new DrivePluginLevel("At", 5);
        At = r105;
        DrivePluginLevel r110 = new DrivePluginLevel("Comment", 6);
        Comment = r110;
        DrivePluginLevel r111 = new DrivePluginLevel("ExtraInfo", 7);
        ExtraInfo = r111;
        DrivePluginLevel r112 = new DrivePluginLevel("GOD", 8);
        GOD = r112;
        DrivePluginLevel[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f224086a = r113;
        f224087b = EnumEntriesKt.enumEntries(r113);
    }

    public static DrivePluginLevel[] values() {
        return (DrivePluginLevel[]) f224086a.clone();
    }

    public static DrivePluginLevel valueOf(String r100) {
        return (DrivePluginLevel) a.a(DrivePluginLevel.class, r100);
    }

    public DrivePluginLevel(String r100, int r101) {
        super(r100, r101);
    }
}
