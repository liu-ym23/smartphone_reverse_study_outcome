package com.bytedance.android.livesdk.ktvimpl.base.frame;

import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final HashMap<Class<? extends IKWidget<?>>, IKWidget<?>> a;
    public final ConcurrentHashMap<Class<? extends DataContext>, Pair<DataContext, Disposable>> b;

    public b() {
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
    }
}
