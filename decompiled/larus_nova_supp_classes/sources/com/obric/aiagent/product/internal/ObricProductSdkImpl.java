package com.obric.aiagent.product.internal;

import android.util.EventsUtils;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.xmlpull.v1.XmlPullParser;
import v9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/product/internal/ObricProductSdkImpl;", "Lcom/obric/aiagent/product/IObricProductSdk;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", "init", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", XmlPullParser.NO_NAMESPACE, "getInitialize", "()Z", XmlPullParser.NO_NAMESPACE, "platformService", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "featureService", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "destroy", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricProductSdkImpl implements t9a.a {
    public static final a Companion = null;
    private static final String TAG = "ObricProductSdkImpl";
    private static final ObricProductSdkImpl instance = null;
    private final AtomicBoolean init;
    private Job loopJob;
    private final CoroutineScope scope;

    public static final class a {
        public a() {
        }
    }

    public void destroy() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == true) goto L6;
        ILogDepend.a.e(TAG, "product sdk is not init");     // Catch: Throwable -> L10
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        u9a.a.a.getClass();     // Catch: Throwable -> L10
        f.h.a().getClass();     // Catch: Throwable -> L10
        ILogDepend.Companion r1 = ILogDepend.a;     // Catch: Throwable -> L10
        r1.i("FeatureServiceImpl", "destroy");     // Catch: Throwable -> L10
        w9a.a.a.getClass();     // Catch: Throwable -> L10
        w9a.a.C0015a.a().getClass();     // Catch: Throwable -> L10
        r1.i("PlatformServiceImpl", "destroy");     // Catch: Throwable -> L10
        this.init.set(false);     // Catch: Throwable -> L10
        goto L7
    }

    public void init() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == false) goto L6;
        ILogDepend.a.e(TAG, "product sdk is already init");     // Catch: Throwable -> L10
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        u9a.a.a.getClass();     // Catch: Throwable -> L10
        f.h.a().i();     // Catch: Throwable -> L10
        w9a.a.a.getClass();     // Catch: Throwable -> L10
        w9a.a.C0015a.a().getClass();     // Catch: Throwable -> L10
        ILogDepend.a.i("PlatformServiceImpl", "init");     // Catch: Throwable -> L10
        RomInfo.a.i();     // Catch: Throwable -> L10
        this.init.set(true);     // Catch: Throwable -> L10
        goto L7
    }

    static {
        Companion = new a();
        instance = new ObricProductSdkImpl();
    }

    public u9a.a featureService() {
        u9a.a.a.getClass();
        return f.h.a();
    }

    public final boolean getInitialize() {
        return this.init.get();
    }

    public w9a.a platformService() {
        w9a.a.a.getClass();
        return w9a.a.C0015a.a();
    }

    public ObricProductSdkImpl() {
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.init = new AtomicBoolean(false);
    }

    public static final /* synthetic */ ObricProductSdkImpl access$getInstance$cp() {
        return instance;
    }
}
