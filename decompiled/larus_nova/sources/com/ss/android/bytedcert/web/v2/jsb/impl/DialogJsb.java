package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.app.Activity;
import com.ss.android.bytedcert.dialog.LoadingDialog;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DialogJsb extends AbsJsBridge {
    private static final long serialVersionUID = -8521786730038386184L;
    private LoadingDialog mLoadingDialog;

    public void hideLoading() {
        rsa.b.b(this.mLoadingDialog);
    }

    public DialogJsb() {
        this.mLoadingDialog = null;
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void invoke(IBridgeContext r110, Object... r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        byte r100 = 0;
        String r101 = (String) r111[0];
        r101.getClass();
        switch(r101.hashCode()) {
            case -514721133: goto L16;
            case 1427456300: goto L12;
            case 1936026385: goto L8;
            default: goto L6;
        };
    L6:
        r100 = -1;
    L18:
        switch(r100) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            default: goto L26;
        };
    L20:
        showLoading(r110.getActivity(), (String) r111[1]);
        return;
    L21:
        hideLoading();
        return;
    L22:
        int r102 = ((Integer) r111[1]).intValue();
        String r103 = (String) r111[3];
        String r104 = (String) r111[4];
        String r105 = (String) r111[5];
        String r106 = (String) r111[6];
        BytedCertManager.getInstance().executeInMainThread(new a(this, r102, r110, r106, r105, r103, r104));
        return;
    L26:
        return;
    L8:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_SHOW_LOADING) == false) goto L6;
        r100 = 2;
        goto L18
    L12:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_HIDE_LOADING) == false) goto L6;
        r100 = 1;
        goto L18
    L16:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_SHOW_DIALOG) == true) goto L18;
        goto L18
    }

    public void showLoading(Activity r100, String r101) {
        if (r100 != null) goto L10;
        return;
    L10:
        if (this.mLoadingDialog != null) goto L7;
        this.mLoadingDialog = LoadingDialog.create(r100, r101);     // Catch: Exception -> L9
    L7:
        rsa.b.c(this.mLoadingDialog);     // Catch: Exception -> L9
        return;
    }

    public static void access$000(DialogJsb r100, IBridgeContext r101, int r102) {
        r100.getClass();
        if (r101 == null) goto L12;
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r102);     // Catch: Exception -> L7
        r103.put("status_code", 0);     // Catch: Exception -> L7
        r103.put("data", r104);     // Catch: Exception -> L7
        r101.onSuccess(r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
