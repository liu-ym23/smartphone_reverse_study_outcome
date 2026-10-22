package tb5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: tb5.a$a, reason: collision with other inner class name */
    public class C0296a implements m {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;

        @Override // tb5.m
        public final void a(NonProguard r3) {
            String r4 = swb.k.b(r3);
            this.b.b(this.a, r4);
        }

        @Override // tb5.m
        public final void b(JSONObject r3) {
            String r4 = r3.toString();
            this.b.b(this.a, r4);
        }

        @Override // tb5.m
        public final void onCallBack(String r3) {
            this.b.b(this.a, r3);
        }

        public C0296a(a r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements m {
        @Override // tb5.m
        public final void a(NonProguard r1) {
        }

        @Override // tb5.m
        public final void b(JSONObject r1) {
        }

        @Override // tb5.m
        public final void onCallBack(String r1) {
        }

        public b() {
        }
    }

    public a() {
    }

    public abstract void b(String r1, String r2);

    public final m a(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        return new C0296a(this, r2);
    L6:
        return new b();
    }
}
