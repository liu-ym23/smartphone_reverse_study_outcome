package com.bytedance.lynx.webview.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.lynx.webview.TTWebSdk;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public class MSReceiver extends BroadcastReceiver {
    public MSReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        String r102 = r101.getStringExtra("data");
        k.d(new String[]{"Receiver data is " + r102});
        if (TTWebSdk.isTTWebView() == false) goto L5;
        TTWebSdk.onCallMS(r102);
        k.d(new String[]{"on call MS " + r102});
        return;
    L5:
        k.d(new String[]{"Not load TTWebview"});
    }
}
