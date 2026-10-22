package com.bytedance.locallife.pdp.biz.common.cache;

import com.bytedance.locallife.dito.core.v;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<v.c> f261020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CompositeDisposable f261021b = null;

    static {
        f261020a = new CopyOnWriteArraySet();
        f261021b = new CompositeDisposable();
    }
}
