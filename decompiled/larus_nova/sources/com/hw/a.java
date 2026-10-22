package com.hw;

import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.f;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f278288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HWPushAdapter.b.C3877b f278289b;

    public a(HWPushAdapter.b.C3877b r100, int r101) {
        this.f278289b = r100;
        this.f278288a = r101;
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        if (((Boolean) r101).booleanValue() == false) goto L6;
        f.g(HWPushAdapter.TAG, "enable notification status failed because app to background");
        ActivityLifecycleObserver.getIns().deleteObserver(this);
        HWPushAdapter.b r102 = this.f278289b.f278279a;
        HWPushAdapter.access$400(r102.f278277f, false, r102.f278275d, this.f278288a, r102.f278273b);
        return;
    }
}
