package com.ss.android.lark.callback;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.larksuite.framework.callback.b;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/callback/InitCallbackTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitCallbackTask extends AsyncLaunchTask<Object> {

    public static final class a<I, O> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<I, O> f410768a = null;

        static {
            f410768a = new a();
        }

        public a() {
        }

        @Override // androidx.arch.core.util.Function
        public final Object apply(Object r100) {
            Runnable r101 = (Runnable) r100;
            Intrinsics.checkNotNull(r101);
            return new zza.a(qqb.a.d(), r101);
        }
    }

    public InitCallbackTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        b.f285565a = a.f410768a;
    }
}
