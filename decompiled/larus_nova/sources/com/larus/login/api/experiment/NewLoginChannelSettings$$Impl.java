package com.larus.login.api.experiment;

import h37.f;
import j37.a;
import java.util.Random;

/* JADX INFO: loaded from: classes30.dex */
public class NewLoginChannelSettings$$Impl implements NewLoginChannelSettings {
    private static final int MAX_NUM = 1000;
    private a mExposedManager;
    private f mStorage;

    @Override // com.larus.login.api.experiment.NewLoginChannelSettings
    public boolean contrastGroup() {
        return false;
    }

    @Override // com.larus.login.api.experiment.NewLoginChannelSettings
    public boolean isVid() {
        return true;
    }

    @Override // com.larus.login.api.experiment.NewLoginChannelSettings
    public boolean getResult() {
        if (this.mStorage.contains("new_login_channel") == false) goto L5;
        int r100 = this.mStorage.getInt("new_login_channel");
    L13:
        int r101 = (int) (((double) 0) + 500.0d);
        if (r100 >= r101) goto L18;
        this.mExposedManager.f("71970340");
        return false;
    L18:
        if (r100 >= ((int) (((double) r101) + 500.0d))) goto L22;
        this.mExposedManager.f("71970341");
        return true;
    L22:
        return contrastGroup();
    L5:
        f r102 = this.mStorage;
        monitor-enter(r102);
    L23:
        th = move-exception;
        throw th;
    L8:
        if (this.mStorage.contains("new_login_channel") == false) goto L10;
        int r103 = this.mStorage.getInt("new_login_channel");     // Catch: Throwable -> L23
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L23
        r100 = r103;
        goto L13
    L10:
        r103 = new Random().nextInt(1000);     // Catch: Throwable -> L23
        this.mStorage.putInt("new_login_channel", r103);     // Catch: Throwable -> L23
        this.mStorage.apply();     // Catch: Throwable -> L23
        goto L11
    }

    public NewLoginChannelSettings$$Impl(f r100) {
        this.mStorage = r100;
        this.mExposedManager = a.b(m37.a.getContext());
    }
}
