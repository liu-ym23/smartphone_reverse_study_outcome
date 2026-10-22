package com.ss.android.lark.larkicon;

import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/larkicon/IconScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOW", AlarmSessionType.TODO, "SYNC_BLOCK", "LYNX", "DOCUMENT", "VC", "MINUTES", "WIKI", "MQC", "HOME_PAGE", "QUICK_LAUNCH", "BITABLE", "TEMPLATE", "lark-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconScene extends Enum<IconScene> {
    public static final IconScene BITABLE = null;
    public static final IconScene DOCUMENT = null;
    public static final IconScene HOME_PAGE = null;
    public static final IconScene LYNX = null;
    public static final IconScene MINUTES = null;
    public static final IconScene MQC = null;
    public static final IconScene QUICK_LAUNCH = null;
    public static final IconScene SYNC_BLOCK = null;
    public static final IconScene TEMPLATE = null;
    public static final IconScene TODO = null;
    public static final IconScene UNKNOW = null;
    public static final IconScene VC = null;
    public static final IconScene WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconScene[] f431154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431155b = null;

    public static EnumEntries<IconScene> getEntries() {
        return f431155b;
    }

    static {
        IconScene r100 = new IconScene("UNKNOW", 0);
        UNKNOW = r100;
        IconScene r101 = new IconScene(AlarmSessionType.TODO, 1);
        TODO = r101;
        IconScene r102 = new IconScene("SYNC_BLOCK", 2);
        SYNC_BLOCK = r102;
        IconScene r103 = new IconScene("LYNX", 3);
        LYNX = r103;
        IconScene r104 = new IconScene("DOCUMENT", 4);
        DOCUMENT = r104;
        IconScene r105 = new IconScene("VC", 5);
        VC = r105;
        IconScene r110 = new IconScene("MINUTES", 6);
        MINUTES = r110;
        IconScene r111 = new IconScene("WIKI", 7);
        WIKI = r111;
        IconScene r112 = new IconScene("MQC", 8);
        MQC = r112;
        IconScene r113 = new IconScene("HOME_PAGE", 9);
        HOME_PAGE = r113;
        IconScene r114 = new IconScene("QUICK_LAUNCH", 10);
        QUICK_LAUNCH = r114;
        IconScene r115 = new IconScene("BITABLE", 11);
        BITABLE = r115;
        IconScene r106 = new IconScene("TEMPLATE", 12);
        TEMPLATE = r106;
        IconScene[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f431154a = r107;
        f431155b = EnumEntriesKt.enumEntries(r107);
    }

    public static IconScene[] values() {
        return (IconScene[]) f431154a.clone();
    }

    public static IconScene valueOf(String r100) {
        return (IconScene) a.a(IconScene.class, r100);
    }

    public IconScene(String r100, int r101) {
        super(r100, r101);
    }
}
