package com.bytedance.ee.bear.drive.biz.preview.screen;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveViewFullScreenVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "immersiveTitleTopState", "Landroidx/lifecycle/MutableLiveData;", "", "getImmersiveTitleTopState", "()Landroidx/lifecycle/MutableLiveData;", "liveOuterFullScreenSate", "Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveFullScreenEvent;", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveViewFullScreenVM extends ViewModel {
    private final MutableLiveData<Boolean> immersiveTitleTopState;
    public final MutableLiveData<a> liveOuterFullScreenSate;

    public DriveViewFullScreenVM() {
        this.immersiveTitleTopState = new MutableLiveData();
        this.liveOuterFullScreenSate = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getImmersiveTitleTopState() {
        return this.immersiveTitleTopState;
    }
}
