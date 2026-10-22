package com.larus.suggest.impl.popup;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u extends BaseDataSubscriber<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f369904a;

    public u(String r100) {
        this.f369904a = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Void> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        FLogger.f375446a.i("NexPulseDialogManager", "preload video cover failed " + this.f369904a);
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Void> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        FLogger.f375446a.i("NexPulseDialogManager", "preload video cover success " + this.f369904a);
        q.f369899d = true;
    }
}
