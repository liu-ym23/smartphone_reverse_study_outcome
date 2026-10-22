package h74;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bd_sec_tee.core.TeeProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TeeProvider.a f483982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TeeProvider.b f483983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f483984c;

    /* JADX INFO: renamed from: h74.a$a, reason: collision with other inner class name */
    public static final class C6109a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TeeProvider.a f483985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TeeProvider.b f483986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f483987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SharedPreferences f483988d;

        public C6109a(Context r100) {
            if (r100 == null) goto L7;
            this.f483987c = r100.getApplicationContext();
            this.f483988d = r100.getSharedPreferences("sec_tee_sp", 0);
            return;
        L7:
            throw new IllegalArgumentException("Context must not be null");
        }
    }

    public a(C6109a r100) {
        Context r101 = r100.f483987c;
        this.f483984c = r100.f483988d;
        this.f483982a = r100.f483985a;
        this.f483983b = r100.f483986b;
    }
}
