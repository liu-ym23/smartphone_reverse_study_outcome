package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.myai.export.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiAiController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f241354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f241355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Result<com.ss.android.lark.myai.export.b>, ? extends d> f241356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.ai.myai.a f241357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f241358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f241359f;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final boolean b() {
        e0 r100 = (e0) this.f241354a.getValue();
        if (r100 == null) goto L7;
        r100.k();
        return false;
    L7:
        return false;
    }

    public WikiAiController() {
        this.f241354a = LazyKt.lazy(WikiAiController$aiDependency$2.INSTANCE);
        this.f241357d = new com.bytedance.ee.bear.document.ai.myai.a();
        this.f241358e = new AtomicBoolean(false);
        this.f241359f = new Object();
    }

    public final void a(Context r100, com.bytedance.ee.bear.wikiv2.wikitreev2.ai.b r101, b r102) {
        b();
        tt5.a.h("WikiAiController", "checkAiEnable, isAIEnable intercepted");
    }
}
