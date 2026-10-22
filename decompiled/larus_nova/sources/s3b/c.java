package s3b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    public class a implements hya.c<String, f5b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hya.b f540507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hya.a f540508b;

        @Override // hya.c
        public final hya.a<f5b.b> a() {
            return this.f540508b;
        }

        @Override // hya.c
        public final hya.b<String> b() {
            return this.f540507a;
        }

        public a(hya.b r100, hya.a r101) {
            this.f540507a = r100;
            this.f540508b = r101;
        }
    }

    public static List<hya.c<String, f5b.b>> a(hya.b<String> r100, hya.a<f5b.b> r101) {
        ArrayList r102 = new ArrayList();
        r102.add(new a(r100, r101));
        return r102;
    }
}
