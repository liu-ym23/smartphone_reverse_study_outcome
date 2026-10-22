package z16;

import android.os.FileObserver;
import com.bytedance.ies.bullet.service.base.d1;
import com.obric.sva.sdk.data.ISmModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f569669e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z16.c f569670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z16.b f569671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, d1> f569672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, FileObserver> f569673d;

    /* JADX INFO: renamed from: z16.a$a, reason: collision with other inner class name */
    public static final class C8410a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f569674a = null;

        static {
            f569674a = new a();
        }
    }

    public static final class c extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f569675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d1 f569676b;

        @Override // android.os.FileObserver
        public final void onEvent(int r100, String r101) {
            if (r100 != 512) goto L5;
        L7:
            this.f569675a.a(this.f569676b);
            return;
        L5:
            if (r100 == 1024) goto L7;
        }

        public c(a r100, d1 r101, String r102) {
            this.f569675a = r100;
            this.f569676b = r101;
            super(r102, ISmModel.VERSION_0600);
        }
    }

    static {
    }

    public a() {
        this.f569672c = new ConcurrentHashMap();
        this.f569673d = new ConcurrentHashMap();
    }

    public final void a(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        String r101 = r100.f247870m;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r101.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        this.f569672c.remove(r101);
        z16.b r103 = this.f569671b;
        if (r103 == null) goto L14;
        byte[] r104 = r103.remove(r101);
    L14:
        z16.c r105 = this.f569670a;
        if (r105 == null) goto L17;
        byte[] r106 = r105.remove(r101);
    L17:
        this.f569673d.remove(r101);
        return;
    L8:
        r102 = false;
        goto L9
    }

    public final void b(String r100, d1 r101) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        Intrinsics.checkNotNullParameter(r101, "resInfo");
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        String r104 = r101.f247859b;
        if (r104 != null) goto L11;
    L12:
        r102 = true;
    L13:
        if (r102 == false) goto L23;
        return;
    L23:
        c r105 = new c(this, r101, r101.f247859b);     // Catch: Throwable -> L20
        this.f569672c.put(r100, r101);     // Catch: Throwable -> L20
        FileObserver r106 = this.f569673d.get(r100);     // Catch: Throwable -> L20
        if (r106 == null) goto L18;
        r106.stopWatching();     // Catch: Throwable -> L20
    L18:
        r105.startWatching();     // Catch: Throwable -> L20
        this.f569673d.put(r100, r105);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        if (r104.length() != 0) goto L13;
    L5:
        r103 = false;
        goto L6
    }
}
