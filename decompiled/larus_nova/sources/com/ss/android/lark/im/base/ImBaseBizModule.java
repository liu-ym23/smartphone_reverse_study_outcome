package com.ss.android.lark.im.base;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class ImBaseBizModule {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ImBaseBizModule> f425876c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public c f425877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.im.base.b f425878b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/im/base/ImBaseBizModule$ImBaseBizModuleEntryPoint;", "", "getImBaseBizModule", "Lcom/ss/android/lark/im/base/ImBaseBizModule;", "im-biz-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        ImBaseBizModule a();
    }

    @Inject
    public ImBaseBizModule() {
    }

    static {
        f425876c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImBaseBizModule$Companion$instance$2.INSTANCE);
    }
}
