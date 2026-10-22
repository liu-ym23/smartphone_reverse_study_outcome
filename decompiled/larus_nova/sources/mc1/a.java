package mc1;

import com.bytedance.android.live.misc.LiveService$$liveemojiimpl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, b<?>> f512862a;

    /* JADX INFO: renamed from: mc1.a$a, reason: collision with other inner class name */
    public interface InterfaceC6796a<T> {

        /* JADX INFO: renamed from: mc1.a$a$a, reason: collision with other inner class name */
        public static final class C6797a<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public volatile R f512863a;

            public C6797a() {
            }
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC6796a<T> f512864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC6796a.C6797a<T> f512865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f512866c;

        public b() {
            throw null;
        }

        public b(LiveService$$liveemojiimpl.a r100) {
            this.f512864a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f512867a = null;

        static {
            f512867a = new a();
        }
    }

    public a() {
        this.f512862a = new ConcurrentHashMap();
    }
}
