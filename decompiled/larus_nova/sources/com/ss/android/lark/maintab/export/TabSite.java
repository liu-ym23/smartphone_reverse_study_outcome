package com.ss.android.lark.maintab.export;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabSite;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.MAIN, MediaScene.NAVIGATION, "TEMPORARY", FlowDoraWifiScene.OTHER, "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabSite extends Enum<TabSite> {
    public static final TabSite MAIN = null;
    public static final TabSite NAVIGATION = null;
    public static final TabSite OTHER = null;
    public static final TabSite TEMPORARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabSite[] f431603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431604b = null;

    public static EnumEntries<TabSite> getEntries() {
        return f431604b;
    }

    static {
        TabSite r100 = new TabSite(AccountType.MAIN, 0);
        MAIN = r100;
        TabSite r101 = new TabSite(MediaScene.NAVIGATION, 1);
        NAVIGATION = r101;
        TabSite r102 = new TabSite("TEMPORARY", 2);
        TEMPORARY = r102;
        TabSite r103 = new TabSite(FlowDoraWifiScene.OTHER, 3);
        OTHER = r103;
        TabSite[] r104 = {r100, r101, r102, r103};
        f431603a = r104;
        f431604b = EnumEntriesKt.enumEntries(r104);
    }

    public static TabSite[] values() {
        return (TabSite[]) f431603a.clone();
    }

    public static TabSite valueOf(String r100) {
        return (TabSite) r27.a.a(TabSite.class, r100);
    }

    public TabSite(String r100, int r101) {
        super(r100, r101);
    }
}
