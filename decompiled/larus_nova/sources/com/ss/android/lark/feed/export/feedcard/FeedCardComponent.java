package com.ss.android.lark.feed.export.feedcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class FeedCardComponent<P, V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f420996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f420997b;

    public static final class a {
    }

    static {
    }

    public abstract V a();

    public ViewGroup.MarginLayoutParams b() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final V c() {
        return (V) this.f420997b.getValue();
    }

    public Context getContext() {
        return this.f420996a;
    }

    public FeedCardComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f420996a = r100;
        this.f420997b = LazyKt.lazy(new FeedCardComponent$view$2(this));
    }
}
