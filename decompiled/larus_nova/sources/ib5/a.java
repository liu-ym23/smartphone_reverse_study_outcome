package ib5;

import com.bytedance.ee.bear.route.h;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes16.dex */
public interface a {

    /* JADX INFO: renamed from: ib5.a$a, reason: collision with other inner class name */
    public static final class C6249a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<kwc.a> f488990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ILaunchTask<?>> f488991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, h.b> f488992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<com.bytedance.ee.bear.route.d> f488993d;

        public C6249a() {
            this.f488990a = CollectionsKt.emptyList();
            this.f488991b = CollectionsKt.emptyList();
            this.f488992c = MapsKt.emptyMap();
            this.f488993d = CollectionsKt.emptyList();
        }

        @Override // ib5.a
        public final Map<String, h.b> a() {
            return this.f488992c;
        }

        @Override // ib5.a
        public final List<com.bytedance.ee.bear.route.d> b() {
            return this.f488993d;
        }

        @Override // ib5.a
        public final List<kwc.a> c() {
            return this.f488990a;
        }

        @Override // ib5.a
        public final List<ILaunchTask<?>> d() {
            return this.f488991b;
        }
    }

    Map<String, h.b> a();

    List<com.bytedance.ee.bear.route.d> b();

    List<kwc.a> c();

    List<ILaunchTask<?>> d();
}
