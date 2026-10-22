package ib5;

import com.bytedance.ee.bear.route.h;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {

    /* JADX INFO: renamed from: ib5.a$a, reason: collision with other inner class name */
    public static final class C0239a implements a {
        public final List<kwc.a> a;
        public final List<ILaunchTask<?>> b;
        public final Map<String, h.b> c;
        public final List<com.bytedance.ee.bear.route.d> d;

        public C0239a() {
            this.a = CollectionsKt.emptyList();
            this.b = CollectionsKt.emptyList();
            this.c = MapsKt.emptyMap();
            this.d = CollectionsKt.emptyList();
        }

        @Override // ib5.a
        public final Map<String, h.b> a() {
            return this.c;
        }

        @Override // ib5.a
        public final List<com.bytedance.ee.bear.route.d> b() {
            return this.d;
        }

        @Override // ib5.a
        public final List<kwc.a> c() {
            return this.a;
        }

        @Override // ib5.a
        public final List<ILaunchTask<?>> d() {
            return this.b;
        }
    }

    Map<String, h.b> a();

    List<com.bytedance.ee.bear.route.d> b();

    List<kwc.a> c();

    List<ILaunchTask<?>> d();
}
