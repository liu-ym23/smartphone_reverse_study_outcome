package com.ss.android.cert.manager.web.jsb;

import android.app.Activity;
import android.content.Intent;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public interface IJsBridge extends Serializable {
    void invoke(IBridgeContext r100, Object... r101);

    void onActivityResult(Activity r100, int r101, int r102, Intent r103);

    void onDestroy(Activity r100);
}
