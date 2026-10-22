package od4;

import android.content.Context;
import cd4.m;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.locallife.cube.PrefetchTiming;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f522832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f522833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, m> f522834c;

    /* JADX INFO: renamed from: od4.a$a, reason: collision with other inner class name */
    public static final class C7036a {

        /* JADX INFO: renamed from: od4.a$a$a, reason: collision with other inner class name */
        public static final class C7037a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f522835a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f522836b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Map<String, Object> f522837c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Map<String, m> f522838d;

            public final a a() {
                Map<String, Object> r100 = this.f522837c;
                if (r100 != null) goto L5;
                r100 = new LinkedHashMap();
            L5:
                this.f522837c = r100;
                r100.put("cj_JSWorker", "1");
                a r101 = new a();
                Intrinsics.checkNotNullParameter(this.f522836b, "<set-?>");
                r101.f522832a = this.f522835a;
                r101.f522833b = this.f522837c;
                r101.f522834c = this.f522838d;
                return r101;
            }

            public final Context getContext() {
                return this.f522835a;
            }

            public C7037a(Context r100) {
                this.f522835a = r100;
                this.f522836b = "default";
            }

            public final void b(String r100, m r101) {
                Intrinsics.checkNotNullParameter(r100, "jsbName");
                Intrinsics.checkNotNullParameter(r101, PrefetchTiming.JSB);
                if (this.f522838d != null) goto L5;
                this.f522838d = new LinkedHashMap();
            L5:
                Map<String, m> r102 = this.f522838d;
                if (r102 == null) goto L9;
                m r103 = r102.put(r100, r101);
                return;
            }
        }
    }

    static {
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "CJJSWorkerModel";
    }

    public a() {
    }

    public final Context getContext() {
        return this.f522832a;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
