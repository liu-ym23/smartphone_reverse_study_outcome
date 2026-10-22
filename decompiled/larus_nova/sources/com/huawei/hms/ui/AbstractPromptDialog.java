package com.huawei.hms.ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractPromptDialog extends AbstractDialog {
    @Override // com.huawei.hms.ui.AbstractDialog
    public String onGetNegativeButtonString(Context r100) {
        return null;
    }

    public AbstractPromptDialog() {
    }

    @Override // com.huawei.hms.ui.AbstractDialog
    public String onGetTitleString(Context r100) {
        if (ResourceLoaderUtil.getmContext() != null) goto L6;
        ResourceLoaderUtil.setmContext(r100);
    L6:
        return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}
