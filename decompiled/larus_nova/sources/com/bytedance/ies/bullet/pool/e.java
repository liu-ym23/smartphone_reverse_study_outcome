package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.k;
import com.bytedance.ies.bullet.service.base.o0;
import com.bytedance.ies.bullet.service.base.z;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f247479b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f247480c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f247481a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f247482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f247483b;

        public a() {
            this.f247482a = e.f247479b;
            this.f247483b = e.f247480c;
        }
    }

    public static final class b implements k {
        public b() {
        }

        @Override // com.bytedance.ies.bullet.service.base.k
        public final void a(com.bytedance.ies.bullet.service.base.f r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "extraInfo");
        }

        @Override // com.bytedance.ies.bullet.service.base.k
        public final void b() {
        }

        @Override // com.bytedance.ies.bullet.service.base.k
        public final void c(com.bytedance.ies.bullet.service.base.f r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.bytedance.ies.bullet.service.base.k
        public final void d(com.bytedance.ies.bullet.service.base.f r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }
    }

    public static final class c implements o0 {
        public c() {
        }

        @Override // com.bytedance.ies.bullet.service.base.o0
        public final Uri a(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            return r100;
        }
    }

    public static final class d {
    }

    static {
        f247479b = new c();
        f247480c = new b();
    }

    @Override // com.bytedance.ies.bullet.service.base.z
    public final void a() {
        this.f247481a.getClass();
    }

    @Override // com.bytedance.ies.bullet.service.base.z
    public final c b() {
        return this.f247481a.f247482a;
    }

    @Override // com.bytedance.ies.bullet.service.base.z
    public final void c() {
        this.f247481a.getClass();
    }

    @Override // com.bytedance.ies.bullet.service.base.z
    public final b d() {
        return this.f247481a.f247483b;
    }

    public e(a r100) {
        this.f247481a = r100;
    }
}
