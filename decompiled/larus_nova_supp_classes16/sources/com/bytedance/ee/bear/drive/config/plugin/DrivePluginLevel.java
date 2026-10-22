package com.bytedance.ee.bear.drive.config.plugin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ DrivePluginLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DrivePluginLevel> getEntries() {
        return b;
    }

    static {
        DrivePluginLevel r0 = new DrivePluginLevel("Toolbar", 0);
        Toolbar = r0;
        DrivePluginLevel r1 = new DrivePluginLevel("Loading", 1);
        Loading = r1;
        DrivePluginLevel r3 = new DrivePluginLevel("Downloading", 2);
        Downloading = r3;
        DrivePluginLevel r5 = new DrivePluginLevel("Preview", 3);
        Preview = r5;
        DrivePluginLevel r7 = new DrivePluginLevel("Banner", 4);
        Banner = r7;
        DrivePluginLevel r9 = new DrivePluginLevel("At", 5);
        At = r9;
        DrivePluginLevel r11 = new DrivePluginLevel("Comment", 6);
        Comment = r11;
        DrivePluginLevel r13 = new DrivePluginLevel("ExtraInfo", 7);
        ExtraInfo = r13;
        DrivePluginLevel r16 = new DrivePluginLevel("GOD", 8);
        GOD = r16;
        DrivePluginLevel[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r16};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static DrivePluginLevel[] values() {
        return (DrivePluginLevel[]) a.clone();
    }

    public static DrivePluginLevel valueOf(String r1) {
        return (DrivePluginLevel) a.a(DrivePluginLevel.class, r1);
    }

    public DrivePluginLevel(String r1, int r2) {
        super(r1, r2);
    }
}
