package com.ss.android.lark.thirdshare.base.export.downgrade;

import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public interface ShareDowngradePanelCallback extends Serializable {
    void onFailed(ShareActionType r100, OnShareCallback.ShareError r101);

    void onSuccess(ShareActionType r100);
}
