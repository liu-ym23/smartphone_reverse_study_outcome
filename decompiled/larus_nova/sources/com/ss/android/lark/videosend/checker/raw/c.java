package com.ss.android.lark.videosend.checker.raw;

import com.ss.android.lark.log.Log;
import com.ss.android.vesdk.VEAVInterleaveChecker;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements VEAVInterleaveChecker.AVInterleaveCheckListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f444877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterLeaveChecker.a f444878b;

    public c(String r100, b r101) {
        this.f444877a = r100;
        this.f444878b = r101;
    }

    @Override // com.ss.android.vesdk.VEAVInterleaveChecker.AVInterleaveCheckListener
    public final void onInfo(int r100, boolean r101, long r102) {
        Log.i("InterLeaveChecker", "mediaPath:" + this.f444877a.hashCode() + ", status:" + r100 + ", isAbnormalInterleaved:" + r101 + ", pos:" + r102);
        if (r101 == false) goto L5;
    L10:
        Lazy r103 = InterLeaveChecker.f444857a;
        InterLeaveChecker.b(this.f444877a, this.f444878b, true);
        return;
    L5:
        if (r100 == 5) goto L10;
        if (r100 != 4) goto L12;
        Lazy r104 = InterLeaveChecker.f444857a;
        InterLeaveChecker.b(this.f444877a, this.f444878b, false);
        return;
    }
}
