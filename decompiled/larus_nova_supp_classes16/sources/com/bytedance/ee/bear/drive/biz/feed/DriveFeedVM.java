package com.bytedance.ee.bear.drive.biz.feed;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "feedCount", "Landroidx/lifecycle/MutableLiveData;", "", "getFeedCount", "()Landroidx/lifecycle/MutableLiveData;", "driveFeedManager", "Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedManager;", "getDriveFeedManager", "()Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedManager;", "setDriveFeedManager", "(Lcom/bytedance/ee/bear/drive/biz/feed/DriveFeedManager;)V", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFeedVM extends ViewModel {
    private c driveFeedManager;
    private final MutableLiveData<Integer> feedCount;

    public DriveFeedVM() {
        this.feedCount = new MutableLiveData();
    }

    public final c getDriveFeedManager() {
        return this.driveFeedManager;
    }

    public final MutableLiveData<Integer> getFeedCount() {
        return this.feedCount;
    }

    public final void setDriveFeedManager(c r1) {
        this.driveFeedManager = r1;
    }
}
