package com.ss.android.lark.keyboard.edittext;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyboardFunctionEditText f428941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f428942b;

    public static final class a {
    }

    static {
    }

    public e(KeyboardFunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f428941a = r100;
        this.f428942b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
        ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }
}
