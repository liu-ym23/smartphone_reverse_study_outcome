package com.ss.android.lark.keyboard.edittext;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f428937d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyboardFunctionEditText f428938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f428939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f428940c;

    public static final class a {
    }

    static {
    }

    public d(KeyboardFunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f428938a = r100;
        this.f428939b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        this.f428940c = ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }
}
