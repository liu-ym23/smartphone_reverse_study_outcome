package android.ss.com.vboost.request;

import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomRequest;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class d implements Comparable {
    private static final String u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CapabilityType f158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrequencyLevel f159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f160c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CoreCluster f161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CustomScene f162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public android.ss.com.vboost.d f163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public android.ss.com.vboost.b f164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f165j;
    public boolean k;
    private g l;
    c m;
    private long n;
    private i o;
    public e p;
    private long q;
    private h r;
    public CustomRequest s;
    public android.ss.com.vboost.i.i t;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f166a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f167b = null;

        static {
            int[] r0 = new int[i.values().length];
            f167b = r0;
            r0[i.d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L72:
            f167b[i.f177c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L60:
            f167b[i.f175a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L70:
            f167b[i.f176b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L10:
            int[] r4 = new int[CapabilityType.values().length];
            f166a = r4;
            r4[CapabilityType.IO_PRELOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L54:
            f166a[CapabilityType.THUMB_FETCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L78:
            f166a[CapabilityType.PRESET_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L90:
            f166a[CapabilityType.CPU_AFFINITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L52:
            f166a[CapabilityType.TASK_PRIORITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L76:
            f166a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L94:
            f166a[CapabilityType.IDLE_STATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L58:
            f166a[CapabilityType.CPU_FREQ_MAX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L82:
            f166a[CapabilityType.CPU_CORE_MAX.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L88:
            f166a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L68:
            f166a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L74:
            f166a[CapabilityType.UFS_FREQ_MAX.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L62:
            f166a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L64:
            f166a[CapabilityType.CPU_CORE_MIN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L92:
            f166a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L56:
            f166a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L80:
            f166a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L86:
            f166a[CapabilityType.NETWORK_ENHANCE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
            return;
        }
    }

    static {
        u = "d";
        FrequencyLevel r0 = FrequencyLevel.LEVEL_0;
    }

    public d(CapabilityType r3) {
        this.f158a = r3;
        b(r3);
        a(r3);
        long r0 = System.currentTimeMillis();
        this.q = r0;
        this.n = r0;
    }

    private void a(CapabilityType r2) {
        switch(a.f166a[r2.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            default: goto L10;
        };
    L5:
        g r3 = g.f170b;
    L8:
        this.l = r3;
        return;
    L6:
        r3 = g.f171c;
        goto L8
    L7:
        r3 = g.d;
        goto L8
    }

    private void b(CapabilityType r2) {
        switch(a.f166a[r2.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            case 18: goto L7;
            default: goto L10;
        };
    L5:
        i r3 = i.d;
    L8:
        this.o = r3;
        return;
    L6:
        r3 = i.f177c;
        goto L8
    L7:
        r3 = i.f175a;
        goto L8
    }

    public long a() {
        long r0 = this.f160c - (this.q - this.n);
        LogUtil.debug(u, "real timeout:" + r0);
        return r0;
    }

    public void a(long r1) {
        this.q = r1;
    }

    public void a(g r1) {
        this.l = r1;
    }

    public void a(h r1) {
        this.r = r1;
    }

    public g b() {
        return this.l;
    }

    public h c() {
        return this.r;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r9) {
        d r10 = (d) r9;
        int r0 = a.f167b[r10.d().ordinal()];
        int r1 = 0;
        if (r0 != 1) goto L5;
        FrequencyLevel r2 = this.f159b;
        if (r2 != null) goto L44;
    L52:
        int r3 = 1;
    L53:
        if (r3 != 0) goto L67;
        long r4 = this.f160c;
        long r6 = r10.f160c;
        if (r4 >= r6) goto L57;
        r3 = 1;
    L60:
        if (r3 != 0) goto L67;
        long r5 = this.n;
        long r7 = r10.n;
        if (r5 <= r7) goto L64;
    L63:
        r1 = 1;
    L68:
        LogUtil.debug(u, "compare result " + r1);
        return r1;
    L64:
        if (r5 == r7) goto L68;
    L66:
        r1 = -1;
        goto L68
    L57:
        if (r4 != r6) goto L59;
        r3 = 0;
        goto L60
    L59:
        r3 = -1;
    L67:
        r1 = r3;
        goto L68
    L44:
        if (r10.f159b == null) goto L52;
        if (r2.ordinal() < r10.f159b.ordinal()) goto L52;
        if (this.f159b.ordinal() != r10.f159b.ordinal()) goto L51;
        r3 = 0;
        goto L53
    L51:
        r3 = -1;
        goto L53
    L5:
        if (r0 == 2) goto L29;
        if (r0 != 3) goto L9;
        long r8 = this.n;
        long r11 = r10.n;
        if (r8 <= r11) goto L23;
        r1 = 1;
    L26:
        if (r1 != 0) goto L68;
    L23:
        if (r8 == r11) goto L26;
        r1 = -1;
        goto L26
    L9:
        if (r0 == 4) goto L15;
        LogUtil.warn(u, "request not implement any update strategy!!!");
        long r12 = this.n;
        long r13 = r10.n;
        if (r12 > r13) goto L63;
        if (r12 != r13) goto L66;
    L15:
        long r14 = this.n;
        long r15 = r10.n;
        if (r14 < r15) goto L63;
        if (r14 != r15) goto L66;
    L29:
        if (this.f159b.ordinal() <= r10.f159b.ordinal()) goto L32;
        r3 = 1;
    L35:
        if (r3 != 0) goto L67;
        long r16 = this.n;
        long r17 = r10.n;
        if (r16 > r17) goto L63;
        if (r16 != r17) goto L66;
    L32:
        if (this.f159b.ordinal() != r10.f159b.ordinal()) goto L34;
        r3 = 0;
        goto L35
    L34:
        r3 = -1;
        goto L35
    }

    public i d() {
        return this.o;
    }

    public String toString() {
        return "Request{type=" + this.f158a + ", level=" + this.f159b + ", timeout=" + this.f160c + ", tid=" + this.d + ", priority=" + this.e + ", cluster=" + this.f161f + ", timeoutStrategy=" + this.l + ", createTime=" + this.n + ", updateStrategy=" + this.o + ", info=" + this.p + ", commitTime=" + this.q + ", task=" + this.r + '}';
    }
}
