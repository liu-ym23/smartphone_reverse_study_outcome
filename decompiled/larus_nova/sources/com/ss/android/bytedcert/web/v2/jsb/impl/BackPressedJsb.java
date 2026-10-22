package com.ss.android.bytedcert.web.v2.jsb.impl;

import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.web.IJsbHelper;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;

/* JADX INFO: loaded from: classes34.dex */
public class BackPressedJsb extends AbsJsBridge {
    private static final long serialVersionUID = -6503203181919440933L;
    private boolean certPageLoaded;
    private final IJsbHelper.SendEventAbility mAbility;

    public boolean onBackPressed() {
        if (BytedCertManager.getInstance().getCertConfig().isEnableWebBack() == true) goto L5;
        return false;
    L5:
        if (this.certPageLoaded == false) goto L10;
        this.mAbility.sendWebEvent(BytedCertConstant.JsbKey.EVENT_ON_BACK_PRESSED, null);
        return true;
    L10:
        return false;
    }

    public BackPressedJsb(IJsbHelper.SendEventAbility r100) {
        this.mAbility = r100;
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void invoke(IBridgeContext r100, Object... r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((String) r101[0]).equals(BytedCertConstant.JsbKey.METHOD_SET_PAGE_LOADED) == false) goto L8;
        this.certPageLoaded = true;
        r100.onSuccess(null);
        return;
    }
}
