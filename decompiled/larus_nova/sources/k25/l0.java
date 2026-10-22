package k25;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class l0 extends LruCache<a, m0> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f501537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f501538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f501539c;

        public final int hashCode() {
            String r100 = this.f501537a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = (r102 + this.f501539c) * 31;
            String r104 = this.f501538b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L28:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L28;
            a r101 = (a) r100;
            String r102 = this.f501537a;
            if (r102 == null) goto L16;
            if (r102.equals(r101.f501537a) == true) goto L19;
        L17:
            return false;
        L19:
            if (this.f501539c == r101.f501539c) goto L21;
            return false;
        L21:
            String r103 = this.f501538b;
            String r104 = r101.f501538b;
            if (r103 != null) goto L29;
            if (r104 == null) goto L30;
            return false;
        L30:
            return true;
        L29:
            return r103.equals(r104);
        L16:
            if (r101.f501537a == null) goto L19;
            goto L17
        }

        public a(String r100, String r101, int r102) {
            this.f501537a = r100;
            this.f501538b = r101;
            this.f501539c = r102;
        }
    }

    public l0() {
        super(ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE);
    }

    public final void d(String r100) {
        Iterator<Map.Entry<a, m0>> r101 = snapshot().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a r102 = r101.next().getKey();
        if (TextUtils.equals(r100, r102.f501538b) == false) goto L4;
        remove(r102);
        goto L4
    }

    public final void c(String r100, String r101) {
        Iterator<Map.Entry<a, m0>> r102 = snapshot().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        a r103 = r102.next().getKey();
        if (TextUtils.equals(r100, r103.f501538b) == false) goto L4;
        if (TextUtils.equals(r101, r103.f501537a) == false) goto L4;
        remove(r103);
        goto L4
    }

    @Override // android.util.LruCache
    public final int sizeOf(a r100, m0 r101) {
        String r102 = r101.f501542c;
        if (r102 != null) goto L6;
        return 0;
    L6:
        return r102.length();
    }

    public final m0 a(String r100, String r101, int r102) {
        m0 r103 = get(new a(r100, r101, r102));
        if (r103 != null) goto L5;
        return r103;
    L5:
        return new m0(r103);
    }

    public final m0 b(String r100, String r101, m0 r102) {
        m0 r103 = new m0(r102);
        put(new a(r100, r101, r102.f501555p), r103);
        return r103;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, a r101, m0 r102, m0 r103) {
        m0 r104 = r102;
        super.entryRemoved(r100, r101, r104, r103);
        if (r104 == null) goto L13;
        String r105 = r104.f501541b;
        if (r105 == null) goto L14;
        int r106 = r105.indexOf("_", r105.indexOf("_") + 1) + 1;
        if (r106 > r105.length()) goto L12;
        tt5.a.h("OfflineMemCache", "entryRemoved, oldValue = [" + du5.b.g(r104.f501550k) + ", " + du5.b.k(r105.substring(r106)) + "]");
        return;
    L12:
        return;
    L14:
        return;
    }
}
