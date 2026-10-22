package com.ss.android.ugc.aweme.search.dynamic.core;

import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicContext;", "", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class DynamicContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f452633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f452634b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/DynamicContext$Companion;", "", "()V", "TAG", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final Context getContext() {
        return this.f452633a;
    }

    public DynamicContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f452633a = r100;
        this.f452634b = LazyKt.lazy(DynamicContext$keyValues$2.INSTANCE);
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L6;
        ((Map) this.f452634b.getValue()).put(r100, r101);
        return;
    L6:
        if (((Map) this.f452634b.getValue()).containsKey(r100) == false) goto L10;
        ((Map) this.f452634b.getValue()).remove(r100);
        return;
    }
}
