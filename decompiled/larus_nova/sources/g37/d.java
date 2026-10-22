package g37;

import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import h37.g;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m37.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f479838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h37.b f479839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f479840c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f479841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n37.a f479842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h37.b f479843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Executor f479844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f479845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f479846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h37.e f479847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h37.d f479848h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f479849i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h37.a f479850j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public RequestV3Service f479851k;

        public final d a() {
            if (this.f479841a == null) goto L27;
            if (this.f479843c == null) goto L25;
            if (this.f479842b != null) goto L10;
            this.f479842b = new n37.a();
        L10:
            if (this.f479844d != null) goto L13;
            this.f479844d = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("SettingsConfig$Builder"));
        L13:
            if (this.f479845e >= 0) goto L16;
            this.f479845e = 3600000;
        L16:
            if (this.f479846f >= 0) goto L18;
            this.f479846f = 120000;
        L18:
            b r100 = new b();
            r100.f479853b = this.f479842b;
            r100.f479854c = this.f479844d;
            r100.f479855d = this.f479845e;
            r100.f479856e = this.f479846f;
            r100.f479857f = this.f479847g;
            r100.f479859h = this.f479849i;
            r100.f479860i = true;
            r100.f479858g = this.f479848h;
            r100.f479861j = this.f479850j;
            r100.f479862k = this.f479851k;
            Context r101 = this.f479841a;
            if ((r101 instanceof Application) == false) goto L23;
            return new d(r101, this.f479843c, r100);
        L23:
            return new d(r101.getApplicationContext(), this.f479843c, r100);
        L25:
            throw new IllegalArgumentException("requestService不能为空");
        L27:
            throw new IllegalArgumentException("context不能为空");
        }

        public a() {
            this.f479845e = -1;
            this.f479846f = -1;
            this.f479849i = true;
            this.f479850j = null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f479852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f479853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f479854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f479855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f479856e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public h37.e f479857f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h37.d f479858g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f479859h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f479860i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h37.a f479861j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public RequestV3Service f479862k;

        public b() {
            this.f479859h = true;
            this.f479860i = true;
        }
    }

    @Override // m37.b
    public final void a() {
        this.f479840c.getClass();
    }

    @Override // m37.b
    public Context getContext() {
        return this.f479838a;
    }

    public d(Context r100, h37.b r101, b r102) {
        this.f479838a = r100;
        this.f479839b = r101;
        this.f479840c = r102;
    }
}
