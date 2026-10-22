package com.larus.login.api.experiment;

import h37.f;
import j37.a;
import java.util.Random;

/* JADX INFO: loaded from: classes30.dex */
public class LoginHighlightSettings$$Impl implements LoginHighlightSettings {
    private static final int MAX_NUM = 1000;
    private a mExposedManager;
    private f mStorage;

    @Override // com.larus.login.api.experiment.LoginHighlightSettings
    public int isVid1() {
        return 0;
    }

    @Override // com.larus.login.api.experiment.LoginHighlightSettings
    public int isVid2() {
        return 1;
    }

    @Override // com.larus.login.api.experiment.LoginHighlightSettings
    public int isVid3() {
        return 2;
    }

    @Override // com.larus.login.api.experiment.LoginHighlightSettings
    public int isVid4() {
        return 3;
    }

    @Override // com.larus.login.api.experiment.LoginHighlightSettings
    public int getResult() {
        if (this.mStorage.contains("login_local_settings") == false) goto L5;
        int r100 = this.mStorage.getInt("login_local_settings");
    L13:
        int r101 = (int) (((double) 0) + 30.0d);
        if (r100 >= r101) goto L17;
        this.mExposedManager.f("13971250");
        return 0;
    L17:
        int r102 = (int) (((double) r101) + 30.0d);
        if (r100 >= r102) goto L21;
        this.mExposedManager.f("13971251");
        return 1;
    L21:
        int r103 = (int) (((double) r102) + 30.0d);
        if (r100 >= r103) goto L26;
        this.mExposedManager.f("13971252");
        return 2;
    L26:
        if (r100 >= ((int) (((double) r103) + 910.0d))) goto L30;
        this.mExposedManager.f("13971253");
        return 3;
    L30:
        return isVid1();
    L5:
        f r104 = this.mStorage;
        monitor-enter(r104);
    L31:
        th = move-exception;
        throw th;
    L8:
        if (this.mStorage.contains("login_local_settings") == false) goto L10;
        int r105 = this.mStorage.getInt("login_local_settings");     // Catch: Throwable -> L31
    L11:
        monitor-exit(r104);     // Catch: Throwable -> L31
        r100 = r105;
        goto L13
    L10:
        r105 = new Random().nextInt(1000);     // Catch: Throwable -> L31
        this.mStorage.putInt("login_local_settings", r105);     // Catch: Throwable -> L31
        this.mStorage.apply();     // Catch: Throwable -> L31
        goto L11
    }

    public LoginHighlightSettings$$Impl(f r100) {
        this.mStorage = r100;
        this.mExposedManager = a.b(m37.a.getContext());
    }
}
