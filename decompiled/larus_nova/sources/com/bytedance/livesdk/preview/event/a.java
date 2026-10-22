package com.bytedance.livesdk.preview.event;

import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VHDispatcher f256431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f256432b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        ((List) this.f256431a.f256430a.getValue()).remove(this.f256432b);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return !((List) this.f256431a.f256430a.getValue()).contains(this.f256432b);
    }

    public a(VHDispatcher r100, Function1 r101) {
        this.f256431a = r100;
        this.f256432b = r101;
    }
}
