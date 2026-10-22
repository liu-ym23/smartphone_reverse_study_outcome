package ppa;

import com.lynx.tasm.LynxEnv;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f530238c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.lynx.tasm.behavior.a> f530239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Future<Boolean> f530240b;

    public final Map<String, com.lynx.tasm.behavior.a> a() {
        Map<String, com.lynx.tasm.behavior.a> r100 = this.f530239a;
        monitor-enter(r100);
        HashMap r101 = new HashMap(this.f530239a);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public c() {
        this.f530239a = new HashMap(LynxEnv.inst().getBehaviorMap());
        a r100 = new a("relaxui");
        this.f530240b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DefaultLibraryLoaderRelaxUI")).submit(r100);
    }
}
