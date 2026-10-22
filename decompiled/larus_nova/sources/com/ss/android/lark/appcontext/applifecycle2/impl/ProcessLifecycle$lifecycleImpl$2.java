package com.ss.android.lark.appcontext.applifecycle2.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/appcontext/applifecycle2/api/IProcessLifecycle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ProcessLifecycle$lifecycleImpl$2 extends Lambda implements Function0<jva.d> {
    public static final ProcessLifecycle$lifecycleImpl$2 INSTANCE = null;

    static {
        INSTANCE = new ProcessLifecycle$lifecycleImpl$2();
    }

    public ProcessLifecycle$lifecycleImpl$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ jva.d invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final jva.d invoke2() {
        return AppLifecycle2.b();
    }
}
