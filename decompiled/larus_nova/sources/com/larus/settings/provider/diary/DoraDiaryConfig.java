package com.larus.settings.provider.diary;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/settings/provider/diary/DoraDiaryConfig;", "", "topbarShowEnvAuth", "", "doraDiaryWidgetUpdateInterval", "", "<init>", "(ZI)V", "getTopbarShowEnvAuth", "()Z", "getDoraDiaryWidgetUpdateInterval", "()I", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDiaryConfig {

    @SerializedName("dora_diary_widget_update_interval")
    private final int doraDiaryWidgetUpdateInterval;

    @SerializedName("topbar_show_env_auth")
    private final boolean topbarShowEnvAuth;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraDiaryConfig() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public final int getDoraDiaryWidgetUpdateInterval() {
        return this.doraDiaryWidgetUpdateInterval;
    }

    public final boolean getTopbarShowEnvAuth() {
        return this.topbarShowEnvAuth;
    }

    public DoraDiaryConfig(boolean r100, int r101) {
        this.topbarShowEnvAuth = r100;
        this.doraDiaryWidgetUpdateInterval = r101;
    }

    public /* synthetic */ DoraDiaryConfig(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 1800;
    L8:
        this(r100, r101);
    }
}
