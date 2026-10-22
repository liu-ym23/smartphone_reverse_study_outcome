package com.larus.chat.gallery.impl.preview;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends BaseDataSubscriber<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f324214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f324215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f324216c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Void> r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        FLogger.f375446a.e("OriginalImagePreloader", "awaitPrefetchReady: prefetch failed, bizTag=" + this.f324214a + ", path=" + this.f324215b, r100.getFailureCause());
        if (this.f324216c.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r101 = this.f324216c;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Void> r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        if (r100.isFinished() == true) goto L5;
        return;
    L5:
        if (this.f324216c.isActive() == false) goto L9;
        kotlinx.coroutines.i<Boolean> r101 = this.f324216c;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
        return;
    }

    public a(String r100, String r101, kotlinx.coroutines.j r102) {
        this.f324214a = r100;
        this.f324215b = r101;
        this.f324216c = r102;
    }
}
