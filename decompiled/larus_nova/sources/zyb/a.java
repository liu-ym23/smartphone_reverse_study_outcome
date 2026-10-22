package zyb;

import com.ss.android.lark.log.Log;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f574004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f574005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f574006c;

    /* JADX INFO: renamed from: zyb.a$a, reason: collision with other inner class name */
    public static final class C8507a {
    }

    public static final class b implements zyb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f574007a;

        public final zyb.b e() {
            this.f574007a.f574004a.a();
            this.f574007a.f574005b.a();
            return null;
        }

        public b(a r100) {
            this.f574007a = r100;
        }

        @Override // zyb.b
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            zyb.b r101 = e();
            if (r101 == null) goto L5;
            r101.b(r100);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. step:" + r100);
        }

        public final void d(String r100) {
            Intrinsics.checkNotNullParameter("rust_online_scenario", "key");
            Intrinsics.checkNotNullParameter(r100, "value");
            e();
            Log.i("ContainerFlowMonitorService", "no active trace. ck:rust_online_scenario,cv:" + r100);
        }

        @Override // zyb.b
        public final void a(String r100, Number r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            zyb.b r102 = e();
            if (r102 == null) goto L5;
            r102.a(r100, r101);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. mk:" + r100 + ",mv:" + r101);
        }

        @Override // zyb.b
        public final void c(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            zyb.b r102 = e();
            if (r102 == null) goto L5;
            r102.c(r100, r101);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. step:" + r100 + ",value:" + r101);
        }
    }

    static {
    }

    @Override // zyb.c
    public final b a() {
        return this.f574006c;
    }

    @Inject
    public a(d r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "enterAppFlowMonitorService");
        Intrinsics.checkNotNullParameter(r101, "switchMonitorService");
        this.f574004a = r100;
        this.f574005b = r101;
        this.f574006c = new b(this);
    }
}
