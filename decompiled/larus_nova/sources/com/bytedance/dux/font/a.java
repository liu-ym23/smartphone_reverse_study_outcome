package com.bytedance.dux.font;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f205088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f205089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f205090c;

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateStart(UpdatePackage r100) {
        DuxFontHelper.f205087d.add(this.f205090c);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        this.f205088a.element = false;
        this.f205089b.countDown();
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        System.currentTimeMillis();
        this.f205088a.element = true;
        this.f205089b.countDown();
    }

    public a(long r100, Ref.BooleanRef r101, CountDownLatch r102, String r103) {
        this.f205088a = r101;
        this.f205089b = r102;
        this.f205090c = r103;
    }
}
