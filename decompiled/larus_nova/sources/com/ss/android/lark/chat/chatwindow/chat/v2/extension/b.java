package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.UICallbackExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final MediatorLiveData a(MutableLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final MediatorLiveData r101 = new MediatorLiveData();
        r101.addSource(r100, new ExtensionsKt$distinctUntilChanged$1(r101));
        return r101;
    }

    public static final void b(final MutableLiveData r100, LifecycleOwner r101, final Observer r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        T r103 = r100.getValue();
        if (r103 != 0) goto L5;
    L7:
        r100.observe(r101, new ExtensionsKt$observeOnce$2(r102, r100));
        return;
    L5:
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        UICallbackExecutor.execute(new a(r102, r103));
        goto L7
    }
}
