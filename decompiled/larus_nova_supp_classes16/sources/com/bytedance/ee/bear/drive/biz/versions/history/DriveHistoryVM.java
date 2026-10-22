package com.bytedance.ee.bear.drive.biz.versions.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/history/DriveHistoryVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveHasNewVersion", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveHasNewVersion", "()Landroidx/lifecycle/MutableLiveData;", "liveVersionDeleted", "getLiveVersionDeleted", "currentDataVersion", "getCurrentDataVersion", "()Ljava/lang/String;", "setCurrentDataVersion", "(Ljava/lang/String;)V", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveHistoryVM extends ViewModel {
    private String currentDataVersion;
    private final MutableLiveData<String> liveHasNewVersion;
    private final MutableLiveData<String> liveVersionDeleted;

    public DriveHistoryVM() {
        this.liveHasNewVersion = new MutableLiveData();
        this.liveVersionDeleted = new MutableLiveData();
    }

    public final String getCurrentDataVersion() {
        return this.currentDataVersion;
    }

    public final MutableLiveData<String> getLiveHasNewVersion() {
        return this.liveHasNewVersion;
    }

    public final MutableLiveData<String> getLiveVersionDeleted() {
        return this.liveVersionDeleted;
    }

    public final void setCurrentDataVersion(String r1) {
        this.currentDataVersion = r1;
    }
}
