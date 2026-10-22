package com.larus.dora.impl.notify;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/notify/DoraNotifyManager$NotifyScene;", "", "<init>", "(Ljava/lang/String;I)V", "SCENE_BATTERY_CHANGE", "SCENE_LINK_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraNotifyManager$NotifyScene extends Enum<DoraNotifyManager$NotifyScene> {
    public static final DoraNotifyManager$NotifyScene SCENE_BATTERY_CHANGE = null;
    public static final DoraNotifyManager$NotifyScene SCENE_LINK_CONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraNotifyManager$NotifyScene[] f336525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336526b = null;

    public static EnumEntries<DoraNotifyManager$NotifyScene> getEntries() {
        return f336526b;
    }

    static {
        DoraNotifyManager$NotifyScene r100 = new DoraNotifyManager$NotifyScene("SCENE_BATTERY_CHANGE", 0);
        SCENE_BATTERY_CHANGE = r100;
        DoraNotifyManager$NotifyScene r101 = new DoraNotifyManager$NotifyScene("SCENE_LINK_CONNECTED", 1);
        SCENE_LINK_CONNECTED = r101;
        DoraNotifyManager$NotifyScene[] r102 = {r100, r101};
        f336525a = r102;
        f336526b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraNotifyManager$NotifyScene[] values() {
        return (DoraNotifyManager$NotifyScene[]) f336525a.clone();
    }

    public static DoraNotifyManager$NotifyScene valueOf(String r100) {
        return (DoraNotifyManager$NotifyScene) a.a(DoraNotifyManager$NotifyScene.class, r100);
    }

    public DoraNotifyManager$NotifyScene(String r100, int r101) {
        super(r100, r101);
    }
}
