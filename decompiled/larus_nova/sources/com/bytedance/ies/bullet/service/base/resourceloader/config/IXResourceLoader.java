package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.n;
import com.bytedance.ies.bullet.service.base.d1;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J@\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\r\u001a\u00020\bH&R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "", "Lcom/bytedance/ies/bullet/service/base/d1;", "input", "Lv26/l;", "config", "loadSync", "Lkotlin/Function1;", "", JSEventListener.ACTION_RESOLVE, "", "reject", "loadAsync", "cancelLoad", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "service", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "getService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "setService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;)V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/bytedance/ies/bullet/kit/resourceloader/n;", VideoThumbInfo.KEY_INTERVAL, "Lcom/bytedance/ies/bullet/kit/resourceloader/n;", "getInterval", "()Lcom/bytedance/ies/bullet/kit/resourceloader/n;", "setInterval", "(Lcom/bytedance/ies/bullet/kit/resourceloader/n;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class IXResourceLoader {
    private final String TAG;
    private n interval;
    public ResourceLoaderService service;

    public abstract void cancelLoad();

    public abstract void loadAsync(d1 r100, l r101, Function1<? super d1, Unit> r102, Function1<? super Throwable, Unit> r103);

    public abstract d1 loadSync(d1 r100, l r101);

    public final ResourceLoaderService getService() {
        ResourceLoaderService r100 = this.service;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("service");
        return null;
    }

    public IXResourceLoader() {
        this.TAG = getClass().getSimpleName();
        this.interval = new n();
    }

    public final n getInterval() {
        return this.interval;
    }

    public String getTAG() {
        return this.TAG;
    }

    public final void setInterval(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interval = r100;
    }

    public final void setService(ResourceLoaderService r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.service = r100;
    }
}
