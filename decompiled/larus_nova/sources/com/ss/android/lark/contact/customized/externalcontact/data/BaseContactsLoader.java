package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseContactsLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f419105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Boolean, Boolean, ErrorResult, Unit> f419106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f419107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f419108d;

    public static final class a {
    }

    static {
    }

    public void a(long r100) {
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public abstract void e();

    /* JADX WARN: Multi-variable type inference failed */
    public BaseContactsLoader(CoroutineScope r100, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "reportPerf");
        this.f419105a = r100;
        this.f419106b = r101;
        this.f419107c = LazyKt.lazy(BaseContactsLoader$syncStateStore$2.INSTANCE);
        this.f419108d = LazyKt.lazy(BaseContactsLoader$fullSyncTtlMillis$2.INSTANCE);
    }
}
