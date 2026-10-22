package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import com.bytedance.awemeopen.infra.base.task.AoPool;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements com.bytedance.awemeopen.apps.framework.utils.a.b {
    public k() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppForeground() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppBackground() {
        wx3.a r100 = CollectionFailSnackBarManager.f196685b;
        if (r100 == null) goto L13;
        boolean r101 = true;
        if (r100.f561793b.isShowing() == true) goto L9;
        r101 = false;
    L9:
        if (r101 == false) goto L12;
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(CollectionFailSnackBarManager$tryDismiss$1.INSTANCE));
        return;
    L12:
        return;
    }
}
