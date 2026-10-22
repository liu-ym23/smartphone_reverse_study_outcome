package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements com.bytedance.awemeopen.apps.framework.utils.a.b {
    public l() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppForeground() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
    public final void onAppBackground() {
        CollectionSuccessSnackBarManager.b();
    }
}
