package com.bytedance.praisedialoglib.manager;

import android.app.Activity;
import com.bytedance.praisedialoglib.googleplay.IGooglePlayPraiseCallback;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements IGooglePlayPraiseCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f266651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f266652b;

    @Override // com.bytedance.praisedialoglib.googleplay.IGooglePlayPraiseCallback
    public final void statusCallback(boolean r100) {
        if (r100 == true) goto L5;
        h r101 = this.f266652b;
        Activity r102 = this.f266651a;
        r101.getClass();
        h.g(r102);
        return;
    }

    public e(h r100, Activity r101) {
        this.f266652b = r100;
        this.f266651a = r101;
    }
}
