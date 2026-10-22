package tb5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: tb5.a$a, reason: collision with other inner class name */
    public class C7710a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f545253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f545254b;

        @Override // tb5.m
        public final void a(NonProguard r100) {
            String r101 = swb.k.b(r100);
            this.f545254b.b(this.f545253a, r101);
        }

        @Override // tb5.m
        public final void b(JSONObject r100) {
            String r101 = r100.toString();
            this.f545254b.b(this.f545253a, r101);
        }

        @Override // tb5.m
        public final void onCallBack(String r100) {
            this.f545254b.b(this.f545253a, r100);
        }

        public C7710a(a r100, String r101) {
            this.f545254b = r100;
            this.f545253a = r101;
        }
    }

    public class b implements m {
        @Override // tb5.m
        public final void a(NonProguard r100) {
        }

        @Override // tb5.m
        public final void b(JSONObject r100) {
        }

        @Override // tb5.m
        public final void onCallBack(String r100) {
        }

        public b() {
        }
    }

    public a() {
    }

    public abstract void b(String r100, String r101);

    public final m a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return new C7710a(this, r100);
    L6:
        return new b();
    }
}
