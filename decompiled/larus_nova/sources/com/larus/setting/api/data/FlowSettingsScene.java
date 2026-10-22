package com.larus.setting.api.data;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/setting/api/data/FlowSettingsScene;", "", "<init>", "(Ljava/lang/String;I)V", "FIND_MY_WAY", "ADD_MY_WAY", HTTP.NOTIFY, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowSettingsScene extends Enum<FlowSettingsScene> {
    public static final FlowSettingsScene ADD_MY_WAY = null;
    public static final FlowSettingsScene FIND_MY_WAY = null;
    public static final FlowSettingsScene NOTIFY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowSettingsScene[] f367891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367892b = null;

    public static EnumEntries<FlowSettingsScene> getEntries() {
        return f367892b;
    }

    static {
        FlowSettingsScene r100 = new FlowSettingsScene("FIND_MY_WAY", 0);
        FIND_MY_WAY = r100;
        FlowSettingsScene r101 = new FlowSettingsScene("ADD_MY_WAY", 1);
        ADD_MY_WAY = r101;
        FlowSettingsScene r102 = new FlowSettingsScene(HTTP.NOTIFY, 2);
        NOTIFY = r102;
        FlowSettingsScene[] r103 = {r100, r101, r102};
        f367891a = r103;
        f367892b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowSettingsScene[] values() {
        return (FlowSettingsScene[]) f367891a.clone();
    }

    public static FlowSettingsScene valueOf(String r100) {
        return (FlowSettingsScene) a.a(FlowSettingsScene.class, r100);
    }

    public FlowSettingsScene(String r100, int r101) {
        super(r100, r101);
    }
}
