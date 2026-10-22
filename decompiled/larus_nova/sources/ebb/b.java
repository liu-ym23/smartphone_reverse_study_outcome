package ebb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.diskmanage.Biz;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f471973c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Biz, g> f471974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f471975b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ebb.b$b, reason: collision with other inner class name */
    public static final class C5764b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f471976a = null;

        static {
            f471976a = new b();
        }
    }

    static {
    }

    public b() {
        this.f471974a = new ConcurrentHashMap();
        this.f471975b = CoreThreadPool.getDefault().newSerialIODensityThreadPool("lk-disk-clean");
    }
}
