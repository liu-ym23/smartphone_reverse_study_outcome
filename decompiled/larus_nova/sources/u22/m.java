package u22;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f548430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f548432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f548433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f548434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f548435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f548436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f548437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f548438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IBaseUser f548439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f548440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OpenInputSource f548441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f548442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f548443n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f548444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f548445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f548446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f548447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f548448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f548449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, String> f548450g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f548451h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f548452i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IBaseUser f548453j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f548454k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f548455l;

        public final void a(String r100, String r101) {
            ((HashMap) this.f548451h).put(r100, r101);
        }

        public a(String r100, boolean r101, String r102, int r103, String r104, long r105, String r110) {
            this.f548449f = 0;
            this.f548450g = new HashMap();
            this.f548451h = new HashMap();
            this.f548455l = false;
            this.f548446c = r101;
            this.f548444a = r100;
            this.f548447d = r102;
            this.f548445b = r103;
            this.f548448e = r104;
            this.f548449f = r105;
            this.f548452i = r110;
        }
    }

    public m() {
        this.f548430a = 0;
        this.f548436g = -1;
        this.f548437h = 2;
        this.f548440k = 0;
        this.f548441l = OpenInputSource.Unknow;
        this.f548442m = 0;
        this.f548443n = 0;
        this.f548438i = System.currentTimeMillis();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public int getType() {
        return this.f548430a;
    }

    public m(String r100) {
        this();
        this.f548430a = 1;
        this.f548431b = r100;
    }

    public m(int r100, boolean r101, OpenInputSource r102) {
        this();
        this.f548430a = r100;
        this.f548432c = r101;
        this.f548441l = r102;
    }
}
