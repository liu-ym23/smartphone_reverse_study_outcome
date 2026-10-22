package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.myai.export.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiAiController {
    public final Lazy a;
    public d b;
    public Function1<? super Result<com.ss.android.lark.myai.export.b>, ? extends d> c;
    public final com.bytedance.ee.bear.document.ai.myai.a d;
    public final AtomicBoolean e;
    public final Object f;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final boolean b() {
        e0 r0 = (e0) this.a.getValue();
        if (r0 == null) goto L7;
        r0.k();
        return false;
    L7:
        return false;
    }

    public WikiAiController() {
        this.a = LazyKt.lazy(WikiAiController$aiDependency$2.INSTANCE);
        this.d = new com.bytedance.ee.bear.document.ai.myai.a();
        this.e = new AtomicBoolean(false);
        this.f = new Object();
    }

    public final void a(Context r1, com.bytedance.ee.bear.wikiv2.wikitreev2.ai.b r2, b r3) {
        b();
        tt5.a.h("WikiAiController", "checkAiEnable, isAIEnable intercepted");
    }
}
