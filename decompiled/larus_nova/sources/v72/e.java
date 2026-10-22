package v72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Long> f553449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f553450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f553451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f553452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, d> f553453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w72.b f553454f;

    public static final class a {
    }

    static {
    }

    public e(w72.b r100) {
        this.f553454f = r100;
        this.f553449a = new HashMap();
        this.f553450b = new HashMap();
        this.f553451c = new HashMap();
        this.f553452d = new HashMap();
        this.f553453e = new HashMap();
    }

    public static d a(o r100, d r101) {
        if (r100.a() != null) goto L5;
    L17:
        return null;
    L5:
        if (r100.b() == null) goto L17;
        if (r101 == null) goto L10;
        long r102 = System.currentTimeMillis();
        if ((r102 - r101.f553447a) <= r100.b().longValue()) goto L15;
        return new d(r102, 1);
    L15:
        if (r101.f553448b >= r100.a().longValue()) goto L17;
        return new d(r101.f553447a, r101.f553448b + 1);
    L10:
        return new d(System.currentTimeMillis(), 1);
    }

    public static boolean b(String r100, Map r101, Map r102) {
        Long r103 = (Long) r102.get(r100);
        HashMap r104 = (HashMap) r101;
        Integer r105 = (Integer) r104.get(r100);
        if (r103 == null) goto L12;
        int r106 = 0;
        if (r105 != null) goto L7;
    L9:
        if (r105 == null) goto L11;
        r106 = r105.intValue();
    L11:
        r104.put(r100, Integer.valueOf(r106 + 1));
        goto L12
    L7:
        if (r105.intValue() <= r103.longValue()) goto L9;
        return false;
    L12:
        return true;
    }
}
