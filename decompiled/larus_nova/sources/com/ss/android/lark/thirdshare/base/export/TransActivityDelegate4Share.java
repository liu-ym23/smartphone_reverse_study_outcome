package com.ss.android.lark.thirdshare.base.export;

import android.os.Bundle;
import com.ss.android.lark.thirdshare.base.export.util.TsUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class TransActivityDelegate4Share extends TransActivity.TransActivityDelegate {
    public static final String EXTRA_SHARE_ENTITY = "extra_share_entity";

    public TransActivityDelegate4Share() {
    }

    @Override // com.ss.android.lark.thirdshare.base.export.TransActivity.TransActivityDelegate
    public void onCreated(final TransActivity r100, Bundle r101) {
        super.onCreated(r100, r101);
        Serializable r102 = r100.getIntent().getSerializableExtra(EXTRA_SHARE_ENTITY);
        if ((r102 instanceof ShareEntity) == false) goto L6;
        ShareEntity r103 = (ShareEntity) r102;
        r103.processIpcShareCallback();
        final OnShareCallback r104 = r103.getCallback();
        r103.setCallback(new AnonymousClass1(this, r104, r100));
        TsUtils.f(r100, r103);
        return;
    }
}
