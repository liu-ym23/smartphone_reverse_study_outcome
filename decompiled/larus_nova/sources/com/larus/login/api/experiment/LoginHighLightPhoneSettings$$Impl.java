package com.larus.login.api.experiment;

import h37.f;
import j37.a;
import java.util.Random;

/* JADX INFO: loaded from: classes30.dex */
public class LoginHighLightPhoneSettings$$Impl implements LoginHighLightPhoneSettings {
    private static final int MAX_NUM = 1000;
    private a mExposedManager;
    private f mStorage;

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isNewPhoneFirstWithoutDouyin() {
        return 3;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isNewVid1() {
        return 0;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isPhoneFirst() {
        return 1;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isPhoneFirstMinifyDouyin() {
        return 3;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isPhoneFirstWithoutDouyin() {
        return 3;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isUnused() {
        return 4;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int isVid1() {
        return 0;
    }

    @Override // com.larus.login.api.experiment.LoginHighLightPhoneSettings
    public int getResult() {
        if (this.mStorage.contains("login_highlight_phone_settings") == false) goto L5;
        int r100 = this.mStorage.getInt("login_highlight_phone_settings");
    L13:
        int r101 = (int) (((double) 0) + 20.0d);
        if (r100 >= r101) goto L17;
        this.mExposedManager.f("16285927");
        return 0;
    L17:
        int r102 = (int) (((double) r101) + 20.0d);
        if (r100 >= r102) goto L21;
        this.mExposedManager.f("16285928");
        return 1;
    L21:
        int r103 = (int) (((double) r102) + 20.0d);
        if (r100 >= r103) goto L25;
        this.mExposedManager.f("16285929");
        return 3;
    L25:
        int r104 = (int) (((double) r103) + 20.0d);
        if (r100 >= r104) goto L29;
        this.mExposedManager.f("16285930");
        return 3;
    L29:
        int r105 = (int) (((double) r104) + 100.0d);
        if (r100 >= r105) goto L33;
        this.mExposedManager.f("16525210");
        return 0;
    L33:
        int r106 = (int) (((double) r105) + 100.0d);
        if (r100 >= r106) goto L38;
        this.mExposedManager.f("16525211");
        return 3;
    L38:
        if (r100 >= ((int) (((double) r106) + 720.0d))) goto L42;
        this.mExposedManager.f("16285931");
        return 4;
    L42:
        return isVid1();
    L5:
        f r107 = this.mStorage;
        monitor-enter(r107);
    L43:
        th = move-exception;
        throw th;
    L8:
        if (this.mStorage.contains("login_highlight_phone_settings") == false) goto L10;
        int r108 = this.mStorage.getInt("login_highlight_phone_settings");     // Catch: Throwable -> L43
    L11:
        monitor-exit(r107);     // Catch: Throwable -> L43
        r100 = r108;
        goto L13
    L10:
        r108 = new Random().nextInt(1000);     // Catch: Throwable -> L43
        this.mStorage.putInt("login_highlight_phone_settings", r108);     // Catch: Throwable -> L43
        this.mStorage.apply();     // Catch: Throwable -> L43
        goto L11
    }

    public LoginHighLightPhoneSettings$$Impl(f r100) {
        this.mStorage = r100;
        this.mExposedManager = a.b(m37.a.getContext());
    }
}
