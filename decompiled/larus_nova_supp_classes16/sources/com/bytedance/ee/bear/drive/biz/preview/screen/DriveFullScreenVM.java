package com.bytedance.ee.bear.drive.biz.preview.screen;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveFullScreenVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveFullScreen", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveFullScreenEvent;", "kotlin.jvm.PlatformType", "getLiveFullScreen", "()Landroidx/lifecycle/MutableLiveData;", "liveTitleBarInTop", "", "getLiveTitleBarInTop", "originStatusBarColor", "", "getOriginStatusBarColor", "()I", "setOriginStatusBarColor", "(I)V", "originNavigationBarColor", "getOriginNavigationBarColor", "setOriginNavigationBarColor", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFullScreenVM extends ViewModel {
    private final MutableLiveData<a> liveFullScreen;
    private final MutableLiveData<Boolean> liveTitleBarInTop;
    private int originNavigationBarColor;
    private int originStatusBarColor;

    public DriveFullScreenVM() {
        int r1 = a.e;
        this.liveFullScreen = new MutableLiveData(new a());
        this.liveTitleBarInTop = new MutableLiveData(Boolean.FALSE);
    }

    public final MutableLiveData<a> getLiveFullScreen() {
        return this.liveFullScreen;
    }

    public final MutableLiveData<Boolean> getLiveTitleBarInTop() {
        return this.liveTitleBarInTop;
    }

    public final int getOriginNavigationBarColor() {
        return this.originNavigationBarColor;
    }

    public final int getOriginStatusBarColor() {
        return this.originStatusBarColor;
    }

    public final void setOriginNavigationBarColor(int r1) {
        this.originNavigationBarColor = r1;
    }

    public final void setOriginStatusBarColor(int r1) {
        this.originStatusBarColor = r1;
    }
}
