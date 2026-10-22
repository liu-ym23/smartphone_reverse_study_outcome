package com.ss.android.lark.framework.assembly.appcontext;

import android.app.Application;
import android.content.Context;
import androidx.startup.Initializer;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.z;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0001\u0018\u00010\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/framework/assembly/appcontext/AppLifecycleInitializer;", "Landroidx/startup/Initializer;", "Lcom/ss/android/lark/appcontext/applifecycle/AppLifecycle;", "Lcom/ss/android/lark/appcontext/applifecycle/IRunningProcessChecker;", "<init>", "()V", "create", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "canUseRunningProcess", "", "Companion", "appcontext-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLifecycleInitializer implements Initializer<AppLifecycle>, z {
    public static final a Companion = null;
    private static final String TAG = "AppLifecycleInitializer";

    /* JADX INFO: loaded from: classes36.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AppLifecycleInitializer() {
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.z
    public boolean canUseRunningProcess() {
        return false;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public AppLifecycle create(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r100.getApplicationContext();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.Application");
        LarkContext.setApplication((Application) r101);
        new InitAppLifecycleTask(this).a(r100);
        return AppLifecycle.a.f408803a;
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ AppLifecycle create(Context r100) {
        return create(r100);
    }
}
