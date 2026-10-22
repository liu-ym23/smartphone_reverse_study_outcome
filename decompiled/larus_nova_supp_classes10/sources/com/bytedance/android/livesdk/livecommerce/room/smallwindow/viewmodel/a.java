package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final Lazy a;
    public final c b;
    public b c;
    public Disposable d;
    public final String e;
    public final String f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0104a {
    }

    public interface b {
        void d(List<yi2.b> r1);
    }

    static {
    }

    public a() {
        this.e = null;
        this.f = null;
        this.a = LazyKt.lazy(LiveSmallWindowViewModel$countDownHandler$2.INSTANCE);
        this.b = new c(this);
    }
}
