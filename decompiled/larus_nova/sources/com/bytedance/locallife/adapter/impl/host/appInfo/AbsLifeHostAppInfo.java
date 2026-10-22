package com.bytedance.locallife.adapter.impl.host.appInfo;

import android.content.Context;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import ss6.c;

/* JADX INFO: loaded from: classes20.dex */
public abstract class AbsLifeHostAppInfo implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256452a;

    @Override // ss6.c
    public final void b() {
    }

    @Override // ss6.c
    public final Observable<Boolean> getAppEnterBackgroundOb() {
        Observable<Boolean> r100 = ((AppContextImpl) this.f256452a.getValue()).f256453a.share();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return PublishSubject.create();
    }

    public AbsLifeHostAppInfo() {
        this.f256452a = LazyKt.lazy(AbsLifeHostAppInfo$appContextImpl$2.INSTANCE);
    }

    @Override // ss6.c
    public final Context getApplicationContext() {
        return ApplicationUtil.a();
    }
}
