package jo2;

import com.bytedance.android.livesdk.performance.scrollstall.ScrollState;
import com.bytedance.apm.util.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f499872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f499873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f499874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Float> f499875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f499876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f499877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f499878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f499879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f499880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f499881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f499882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f499883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f499884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f499885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f499886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f499887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f499888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f499889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f499890s;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f499872a = ScrollState.IDEL.getValue();
        this.f499873b = -1;
        this.f499874c = -1.0f;
        this.f499875d = new ArrayList();
        this.f499876e = -1.0d;
        this.f499877f = -1;
        this.f499878g = -1.0f;
        this.f499879h = -1.0f;
        this.f499880i = -1;
        this.f499881j = -1.0f;
        this.f499882k = -1.0f;
        this.f499883l = -1;
        this.f499884m = -1.0f;
        this.f499885n = -1.0f;
        this.f499886o = -1;
        this.f499887p = -1.0f;
        this.f499888q = -1.0d;
        this.f499889r = -1.0d;
        this.f499890s = "";
    }

    public final void a(Map<String, Double> r100) {
        if (r100 == null) goto L6;
        Double r101 = r100.get("cpu_rate");
        if (r101 == null) goto L6;
        double r102 = r101.doubleValue();
    L7:
        this.f499888q = r102;
        if (r100 == null) goto L13;
        Double r103 = r100.get("cpu_speed");
        if (r103 == null) goto L14;
        r103.doubleValue();
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r102 = -1.0d;
        goto L7
    }

    public final void b(long r100) {
        this.f499873b = r100;
        this.f499876e = ((double) this.f499878g) / r100;
        float r101 = r100;
        this.f499879h = this.f499881j / r101;
        this.f499882k = this.f499884m / r101;
        this.f499885n = this.f499887p / r101;
    }

    public final void c(double r110, JSONObject r111) {
        JSONObject r100 = r111;
        float r101 = (float) r110;
        this.f499874c = r101;
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f499875d).size() < 4) goto L12;
        int r102 = ((ArrayList) this.f499875d).size() - 4;     // Catch: Throwable -> L47
        if (r102 < 0) goto L12;
        int r103 = 0;
    L9:
        ListProtector.remove(this.f499875d, 0);     // Catch: Throwable -> L47
        if (r103 == r102) goto L12;
        r103 = r103 + 1;     // Catch: Throwable -> L47
    L12:
        ((ArrayList) this.f499875d).add(Float.valueOf(r101));     // Catch: Throwable -> L47
        if (((ArrayList) this.f499875d).size() != 4) goto L19;
        Iterator r104 = ((ArrayList) this.f499875d).iterator();     // Catch: Throwable -> L47
    L15:
        if (r104.hasNext() == false) goto L19;
        ((Number) r104.next()).floatValue();     // Catch: Throwable -> L47
    L19:
        monitor-exit(this);
        if (r100 == null) goto L22;
        r111.toString();
    L22:
        float r105 = 0.0f;
        if (r100 == null) goto L44;
        float r106 = i.f190669a;
        Iterator<String> r107 = r111.keys();
        long r108 = 0;
        long r109 = 0;
        long r112 = 0;
        float r113 = 0.0f;
        float r114 = 0.0f;
    L26:
        if (r107.hasNext() == false) goto L45;
        String r115 = r107.next();
        int r116 = CastIntegerProtector.parseInt(r115);
        int r117 = r100.optInt(r115);
        if (3 > r116) goto L34;
        if (6 < r116) goto L34;
        r108 = r108 + ((long) r117);
        r105 = r105 + ((r116 * r117) * r106);
    L42:
        r100 = r111;
    L34:
        if (7 > r116) goto L40;
        if (13 < r116) goto L40;
        r109 = r109 + ((long) r117);
        r113 = r113 + ((r116 * r117) * r106);
    L40:
        if (r116 < 14) goto L42;
        r112 = r112 + ((long) r117);
        r114 = r114 + ((r116 * r117) * r106);
    L45:
        this.f499880i = r108;
        this.f499881j = r105;
        this.f499883l = r109;
        this.f499884m = r113;
        this.f499886o = r112;
        this.f499887p = r114;
        this.f499877f = (r108 + r109) + r112;
        this.f499878g = (r105 + r113) + r114;
        return;
    L44:
        r108 = 0;
        r109 = 0;
        r112 = 0;
        r113 = 0.0f;
        r114 = 0.0f;
        goto L45
    }
}
