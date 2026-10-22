package fp6;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f478289a;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final fp6.a f478290a = null;

        static {
            f478290a = new fp6.a();
        }
    }

    public c() {
        this.f478289a = new HashMap();
    }

    public final void a(String r100, Object r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r101 instanceof String) == false) goto L8;
        fp6.a r102 = a.f478290a;
        Map<String, String> r103 = this.f478289a;
        HashMap r104 = (HashMap) r103;
        r104.put(r100, r102.a((String) r101));
        return;
    L8:
        if ((r101 instanceof Integer) == false) goto L12;
        String r105 = String.valueOf(((Integer) r101).intValue());
        fp6.a r106 = a.f478290a;
        Map<String, String> r107 = this.f478289a;
        HashMap r108 = (HashMap) r107;
        r108.put(r100, r106.a(r105));
        return;
    L12:
        if ((r101 instanceof Long) == false) goto L15;
        String r109 = String.valueOf(((Long) r101).longValue());
        fp6.a r110 = a.f478290a;
        Map<String, String> r111 = this.f478289a;
        HashMap r112 = (HashMap) r111;
        r112.put(r100, r110.a(r109));
        return;
    L15:
        String r113 = GsonProtectorUtils.toJson(kp6.d.a(), r101);
        fp6.a r114 = a.f478290a;
        Map<String, String> r115 = this.f478289a;
        HashMap r116 = (HashMap) r115;
        r116.put(r100, r114.a(r113));
    }
}
