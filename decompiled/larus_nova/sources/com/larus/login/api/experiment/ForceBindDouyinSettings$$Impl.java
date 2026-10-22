package com.larus.login.api.experiment;

import h37.f;
import j37.a;
import java.util.Random;

/* JADX INFO: loaded from: classes30.dex */
public class ForceBindDouyinSettings$$Impl implements ForceBindDouyinSettings {
    private static final int MAX_NUM = 1000;
    private a mExposedManager;
    private f mStorage;

    @Override // com.larus.login.api.experiment.ForceBindDouyinSettings
    public int isVid1() {
        return 0;
    }

    @Override // com.larus.login.api.experiment.ForceBindDouyinSettings
    public int isVid2() {
        return 1;
    }

    @Override // com.larus.login.api.experiment.ForceBindDouyinSettings
    public int isVid3() {
        return 2;
    }

    @Override // com.larus.login.api.experiment.ForceBindDouyinSettings
    public int getResult() {
        if (this.mStorage.contains("force_bind_douyin_local_settings") == false) goto L5;
        int r100 = this.mStorage.getInt("force_bind_douyin_local_settings");
    L13:
        int r101 = (int) (((double) 0) + 1.0d);
        if (r100 >= r101) goto L17;
        this.mExposedManager.f("14280523");
        return 0;
    L17:
        int r102 = (int) (((double) r101) + 1.0d);
        if (r100 >= r102) goto L22;
        this.mExposedManager.f("14280524");
        return 1;
    L22:
        if (r100 >= ((int) (((double) r102) + 998.0d))) goto L26;
        this.mExposedManager.f("14280525");
        return 2;
    L26:
        return isVid1();
    L5:
        f r103 = this.mStorage;
        monitor-enter(r103);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (this.mStorage.contains("force_bind_douyin_local_settings") == false) goto L10;
        int r104 = this.mStorage.getInt("force_bind_douyin_local_settings");     // Catch: Throwable -> L27
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L27
        r100 = r104;
        goto L13
    L10:
        r104 = new Random().nextInt(1000);     // Catch: Throwable -> L27
        this.mStorage.putInt("force_bind_douyin_local_settings", r104);     // Catch: Throwable -> L27
        this.mStorage.apply();     // Catch: Throwable -> L27
        goto L11
    }

    public ForceBindDouyinSettings$$Impl(f r100) {
        this.mStorage = r100;
        this.mExposedManager = a.b(m37.a.getContext());
    }
}
