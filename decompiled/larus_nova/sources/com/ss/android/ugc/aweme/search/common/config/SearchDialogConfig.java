package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0083D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchDialogConfig;", "", "", "reportMonitor", "I", "useShowDialog", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchDialogConfig {

    @SerializedName("need_report_monitor")
    private final int reportMonitor;

    @SerializedName("use_show_dialog")
    private final int useShowDialog;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchDialogConfig$Companion;", "", "()V", "DISABLED", "", "ENABLED", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final boolean a() {
        if (this.reportMonitor == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public SearchDialogConfig() {
        this.reportMonitor = 1;
    }
}
