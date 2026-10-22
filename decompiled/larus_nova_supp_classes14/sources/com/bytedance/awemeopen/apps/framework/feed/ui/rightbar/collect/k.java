package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import com.bytedance.awemeopen.infra.base.task.AoPool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements com.bytedance.awemeopen.apps.framework.utils.a.b {
    public k() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppForeground() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppBackground() {
        wx3.a r0 = CollectionFailSnackBarManager.b;
        if (r0 == null) goto L13;
        boolean r1 = true;
        if (r0.b.isShowing() == true) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L12;
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(CollectionFailSnackBarManager$tryDismiss$1.INSTANCE));
        return;
    L12:
        return;
    }
}
