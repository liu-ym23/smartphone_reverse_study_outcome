package com.bytedance.ee.bear.drive.biz.preview.banner;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveNotificationVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "iNotificationView", "Lcom/bytedance/ee/bear/notification/INotification$INotificationView;", "inited", "", "showState", "Landroidx/lifecycle/MutableLiveData;", "", "getShowState", "()Landroidx/lifecycle/MutableLiveData;", "initIfNeed", "", "getINotificationView", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveNotificationVM extends ViewModel {
    private com.bytedance.ee.bear.notification.a.b iNotificationView;
    private boolean inited;
    private final MutableLiveData<Integer> showState;

    public final void initIfNeed() {
        if (this.inited == false) goto L5;
        return;
    L5:
        this.iNotificationView = ((com.bytedance.ee.bear.notification.a) org.koin.java.a.c(com.bytedance.ee.bear.notification.a.class, null, null, 6)).d();
        this.inited = true;
    }

    public DriveNotificationVM() {
        this.showState = new MutableLiveData();
    }

    public final com.bytedance.ee.bear.notification.a.b getINotificationView() {
        return this.iNotificationView;
    }

    public final MutableLiveData<Integer> getShowState() {
        return this.showState;
    }
}
