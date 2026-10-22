package g37;

import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import h37.e;
import h37.g;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements m37.b {
    public final Context a;
    public final h37.b b;
    public final b c;

    public static class a {
        public Context a;
        public n37.a b;
        public h37.b c;
        public Executor d;
        public long e;
        public long f;
        public e g;
        public h37.d h;
        public boolean i;
        public h37.a j;
        public RequestV3Service k;

        public final d a() {
            if (this.a == null) goto L27;
            if (this.c == null) goto L25;
            if (this.b != null) goto L10;
            this.b = new n37.a();
        L10:
            if (this.d != null) goto L13;
            this.d = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("SettingsConfig$Builder"));
        L13:
            if (this.e >= 0) goto L16;
            this.e = 3600000;
        L16:
            if (this.f >= 0) goto L18;
            this.f = 120000;
        L18:
            b r0 = new b();
            r0.b = this.b;
            r0.c = this.d;
            r0.d = this.e;
            r0.e = this.f;
            r0.f = this.g;
            r0.h = this.i;
            r0.i = true;
            r0.g = this.h;
            r0.j = this.j;
            r0.k = this.k;
            Context r1 = this.a;
            if ((r1 instanceof Application) == false) goto L23;
            return new d(r1, this.c, r0);
        L23:
            return new d(r1.getApplicationContext(), this.c, r0);
        L25:
            throw new IllegalArgumentException("requestService不能为空");
        L27:
            throw new IllegalArgumentException("context不能为空");
        }

        public a() {
            this.e = -1;
            this.f = -1;
            this.i = true;
            this.j = null;
        }
    }

    public static class b {
        public String a;
        public g b;
        public Executor c;
        public long d;
        public long e;
        public e f;
        public h37.d g;
        public boolean h;
        public boolean i;
        public h37.a j;
        public RequestV3Service k;

        public b() {
            this.h = true;
            this.i = true;
        }
    }

    @Override // m37.b
    public final void a() {
        this.c.getClass();
    }

    @Override // m37.b
    public Context getContext() {
        return this.a;
    }

    public d(Context r1, h37.b r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
