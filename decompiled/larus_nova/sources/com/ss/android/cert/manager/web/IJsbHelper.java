package com.ss.android.cert.manager.web;

import android.app.Activity;
import android.content.Intent;
import com.ss.android.cert.manager.web.jsb.IJsBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IJsbHelper extends ICertJsbDefine, IUserIdentityJsbDefine {

    public interface SendEventAbility {
        void sendWebEvent(String r100, JSONObject r101);
    }

    void addJsb(String r100, IJsBridge r101);

    void hideLoading();

    void init(SendEventAbility r100);

    void onActivityResult(Activity r100, int r101, int r102, Intent r103);

    boolean onBackPressed();

    void onDestroy(Activity r100);

    void showLoading(Activity r100);
}
