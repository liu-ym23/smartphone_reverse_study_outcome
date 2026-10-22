package com.bytedance.ruler.strategy.cache;

import com.bytedance.ruler.d;
import com.bytedance.ruler.utils.g;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<String, List<String>> f267708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267709b;

    /* JADX INFO: renamed from: com.bytedance.ruler.strategy.cache.a$a, reason: collision with other inner class name */
    public static final class C3743a implements c.a<String, List<? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f267710a;

        public C3743a(a r100) {
            this.f267710a = r100;
        }

        @Override // com.bytedance.ruler.strategy.cache.c.a
        public final void a(String r100, List<? extends String> r101) {
            String r102 = r100;
            g r103 = d.f267686j;
            if (r103 == null) goto L7;
            fh7.d r104 = r103.b(this.f267710a.f267709b);
            if (r104 == null) goto L7;
            r104.remove(r102);
        L7:
            g r105 = d.f267686j;
            if (r105 == null) goto L13;
            fh7.d r106 = r105.b(this.f267710a.f267709b + "_data");
            if (r106 == null) goto L14;
            r106.remove(r102);
            return;
        L14:
            return;
        }
    }

    public a(String r100) {
        this.f267709b = r100;
        c<String, List<String>> r101 = new c();
        this.f267708a = r101;
        r101.f267714a = new C3743a(this);
    }
}
