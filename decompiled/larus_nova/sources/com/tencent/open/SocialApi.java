package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* JADX INFO: loaded from: classes29.dex */
public class SocialApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SocialApiIml f461639a;

    public SocialApi(QQToken r100) {
        this.f461639a = new SocialApiIml(r100);
    }

    public void ask(Activity r100, Bundle r101, IUiListener r102) {
        if (com.tencent.connect.a.a("SocialApi", r102) == false) goto L5;
        return;
    L5:
        this.f461639a.ask(r100, r101, r102);
    }

    public void gift(Activity r100, Bundle r101, IUiListener r102) {
        if (com.tencent.connect.a.a("SocialApi", r102) == false) goto L5;
        return;
    L5:
        this.f461639a.gift(r100, r101, r102);
    }

    public void invite(Activity r100, Bundle r101, IUiListener r102) {
        if (com.tencent.connect.a.a("SocialApi", r102) == false) goto L5;
        return;
    L5:
        this.f461639a.invite(r100, r101, r102);
    }

    public void story(Activity r100, Bundle r101, IUiListener r102) {
        if (com.tencent.connect.a.a("SocialApi", r102) == false) goto L5;
        return;
    L5:
        this.f461639a.story(r100, r101, r102);
    }
}
