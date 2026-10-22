package dac;

import aac.g;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f467768c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<dac.b, Object> f467769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<dac.a, Object> f467770b;

    public class a implements aac.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f467771a;

        public a(c r100) {
            this.f467771a = r100;
        }

        @Override // aac.b.a
        public final void a(UserSetting r100, UserSetting r101) {
            c r102 = this.f467771a;
            r102.getClass();
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r102, r101, r100));
            c r103 = this.f467771a;
            r103.getClass();
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new e(r103, r101));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f467772a = null;

        static {
            f467772a = new c();
        }
    }

    public c() {
        this.f467769a = new ConcurrentHashMap();
        this.f467770b = new ConcurrentHashMap();
        a r100 = new a(this);
        g.d.f2395a.c(r100);
    }

    static {
    }
}
