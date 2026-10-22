package com.bytedance.ee.bear.drive.biz.preview.vc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import l65.d;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/vc/DriveVCFollowVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveIsGuest", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveIsGuest", "()Landroidx/lifecycle/MutableLiveData;", "liveIsPresenter", "getLiveIsPresenter", "liveIsReplay", "getLiveIsReplay", "liveIsMuted", "getLiveIsMuted", "liveBizType", "", "getLiveBizType", "liveIsVCFollowMode", "getLiveIsVCFollowMode", "liveFollowDocumentInfo", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/DriveFollowDocumentInfo;", "getLiveFollowDocumentInfo", "isPresenter", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVCFollowVM extends ViewModel {
    private final MutableLiveData<Integer> liveBizType;
    private final MutableLiveData<d> liveFollowDocumentInfo;
    private final MutableLiveData<Boolean> liveIsGuest;
    private final MutableLiveData<Boolean> liveIsMuted;
    private final MutableLiveData<Boolean> liveIsPresenter;
    private final MutableLiveData<Boolean> liveIsReplay;
    private final MutableLiveData<Boolean> liveIsVCFollowMode;

    public final boolean isPresenter() {
        return Boolean.TRUE.equals(this.liveIsPresenter.getValue());
    }

    public DriveVCFollowVM() {
        this.liveIsGuest = new MutableLiveData();
        this.liveIsPresenter = new MutableLiveData(Boolean.TRUE);
        this.liveIsReplay = new MutableLiveData();
        this.liveIsMuted = new MutableLiveData();
        this.liveBizType = new MutableLiveData();
        this.liveIsVCFollowMode = new MutableLiveData(Boolean.FALSE);
        this.liveFollowDocumentInfo = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getLiveBizType() {
        return this.liveBizType;
    }

    public final MutableLiveData<d> getLiveFollowDocumentInfo() {
        return this.liveFollowDocumentInfo;
    }

    public final MutableLiveData<Boolean> getLiveIsGuest() {
        return this.liveIsGuest;
    }

    public final MutableLiveData<Boolean> getLiveIsMuted() {
        return this.liveIsMuted;
    }

    public final MutableLiveData<Boolean> getLiveIsPresenter() {
        return this.liveIsPresenter;
    }

    public final MutableLiveData<Boolean> getLiveIsReplay() {
        return this.liveIsReplay;
    }

    public final MutableLiveData<Boolean> getLiveIsVCFollowMode() {
        return this.liveIsVCFollowMode;
    }
}
