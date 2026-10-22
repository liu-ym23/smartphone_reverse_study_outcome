package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends com.ss.android.lark.utils.rxjava.d<Map<String, ? extends FrameInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f429774a;

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f429774a.onFinish();
    }

    public f(l r100) {
        this.f429774a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.d
    public final void a(Throwable r100) {
        d r101 = this.f429774a;
        if (r100 == null) goto L5;
        String r102 = r100.getMessage();
    L6:
        r101.onError(new ErrorResult(r102));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        Map<String, FrameInfo> r101 = (Map) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        this.f429774a.onSuccess(r101);
    }
}
