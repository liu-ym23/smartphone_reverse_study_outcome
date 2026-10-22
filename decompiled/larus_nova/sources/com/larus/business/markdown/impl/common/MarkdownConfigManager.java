package com.larus.business.markdown.impl.common;

import android.view.View;
import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.impl.common.utils.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f320510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super View, ? super String, ? super Boolean, Unit> f320511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f320512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f320513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f320514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f320515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f320516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ysc.a f320517h;

    public final com.larus.business.markdown.impl.markwon.a a() {
        return (com.larus.business.markdown.impl.markwon.a) this.f320516g.getValue();
    }

    public final c b() {
        return (c) this.f320510a.getValue();
    }

    public MarkdownConfigManager() {
        this.f320510a = LazyKt.lazy(MarkdownConfigManager$settings$2.INSTANCE);
        this.f320513d = LazyKt.lazy(MarkdownConfigManager$drawablePool$2.INSTANCE);
        this.f320514e = LazyKt.lazy(new MarkdownConfigManager$drawableLruPool$2(this));
        this.f320515f = LazyKt.lazy(MarkdownConfigManager$imageSize$2.INSTANCE);
        this.f320516g = LazyKt.lazy(MarkdownConfigManager$astModifier$2.INSTANCE);
    }
}
