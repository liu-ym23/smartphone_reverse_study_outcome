package qnb;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: qnb.a$a, reason: collision with other inner class name */
    public class C7369a implements snb.a {
        @Override // snb.a
        public final ExecutorService a() {
            return PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("DefaultDependency$1"));
        }

        @Override // snb.a
        public final Executor b() {
            return PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("DefaultDependency$1"));
        }

        public C7369a() {
        }
    }

    public a() {
    }

    @Override // qnb.b.a
    public final snb.a a() {
        return new C7369a();
    }

    public final rnb.b b() {
        return new rnb.a();
    }
}
