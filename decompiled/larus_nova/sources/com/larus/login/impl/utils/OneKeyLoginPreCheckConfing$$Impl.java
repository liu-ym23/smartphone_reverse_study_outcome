package com.larus.login.impl.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes30.dex */
public class OneKeyLoginPreCheckConfing$$Impl implements OneKeyLoginPreCheckConfing {
    private static final int MAX_NUM = 1000;
    private j37.a mExposedManager;
    private h37.f mStorage;

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isNewVid0() {
        return 0;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isNewVid1() {
        return 1;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isNewVid2() {
        return 2;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isNewVid3() {
        return 4;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isUnused() {
        return 3;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isVid0() {
        return 0;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isVid1() {
        return 1;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int isVid2() {
        return 2;
    }

    @Override // com.larus.login.impl.utils.OneKeyLoginPreCheckConfing
    public int getResult() {
        if (this.mStorage.contains("one_key_login_pre_check_config") == false) goto L5;
        int r100 = this.mStorage.getInt("one_key_login_pre_check_config");
    L13:
        int r101 = (int) (((double) 0) + 50.0d);
        if (r100 >= r101) goto L17;
        this.mExposedManager.f("16367509");
        return 0;
    L17:
        int r102 = (int) (((double) r101) + 50.0d);
        if (r100 >= r102) goto L21;
        this.mExposedManager.f("16367510");
        return 1;
    L21:
        int r103 = (int) (((double) r102) + 50.0d);
        if (r100 >= r103) goto L25;
        this.mExposedManager.f("16367511");
        return 2;
    L25:
        int r104 = (int) (((double) r103) + 100.0d);
        if (r100 >= r104) goto L29;
        this.mExposedManager.f("16701858");
        return 0;
    L29:
        int r105 = (int) (((double) r104) + 100.0d);
        if (r100 >= r105) goto L33;
        this.mExposedManager.f("16701859");
        return 1;
    L33:
        int r106 = (int) (((double) r105) + 100.0d);
        if (r100 >= r106) goto L37;
        this.mExposedManager.f("16701861");
        return 2;
    L37:
        int r107 = (int) (((double) r106) + 100.0d);
        if (r100 >= r107) goto L42;
        this.mExposedManager.f("16701860");
        return 4;
    L42:
        if (r100 >= ((int) (((double) r107) + 450.0d))) goto L46;
        this.mExposedManager.f("16367512");
        return 3;
    L46:
        return isVid0();
    L5:
        h37.f r108 = this.mStorage;
        monitor-enter(r108);
    L47:
        th = move-exception;
        throw th;
    L8:
        if (this.mStorage.contains("one_key_login_pre_check_config") == false) goto L10;
        int r109 = this.mStorage.getInt("one_key_login_pre_check_config");     // Catch: Throwable -> L47
    L11:
        monitor-exit(r108);     // Catch: Throwable -> L47
        r100 = r109;
        goto L13
    L10:
        r109 = new Random().nextInt(1000);     // Catch: Throwable -> L47
        this.mStorage.putInt("one_key_login_pre_check_config", r109);     // Catch: Throwable -> L47
        this.mStorage.apply();     // Catch: Throwable -> L47
        goto L11
    }

    public OneKeyLoginPreCheckConfing$$Impl(h37.f r100) {
        this.mStorage = r100;
        this.mExposedManager = j37.a.b(m37.a.getContext());
    }
}
