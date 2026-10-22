package h84;

import android.text.TextUtils;
import com.bytedance.bdinstall.c1;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f484122a;

    public class a implements c<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f484123a;

        @Override // h84.e.c
        public final String getCache() {
            return this.f484123a.a("openudid");
        }

        public a(e r100) {
            this.f484123a = r100;
        }

        @Override // h84.e.c
        public final boolean a(String r100) {
            return c1.h(r100);
        }

        @Override // h84.e.c
        public final void c(String r100) {
            e r101 = this.f484123a;
            r101.c("openudid", r100);
        }

        @Override // h84.e.c
        public final boolean b(String r100, String r101) {
            return c1.f(r100, r101);
        }

        @Override // h84.e.c
        public final String d(String r100, String r101, e r102) {
            return r102.h(r100, r101);
        }
    }

    public class b implements c<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f484124a;

        @Override // h84.e.c
        public final String getCache() {
            return this.f484124a.a("device_id");
        }

        public b(e r100) {
            this.f484124a = r100;
        }

        @Override // h84.e.c
        public final boolean a(String r100) {
            return !TextUtils.isEmpty(r100);
        }

        @Override // h84.e.c
        public final void c(String r100) {
            e r101 = this.f484124a;
            r101.c("device_id", r100);
        }

        @Override // h84.e.c
        public final boolean b(String r100, String r101) {
            return c1.f(r100, r101);
        }

        @Override // h84.e.c
        public final String d(String r100, String r101, e r102) {
            return r102.b(r100, r101);
        }
    }

    public interface c<L> {
        boolean a(L r100);

        boolean b(L r100, L r101);

        void c(L r100);

        L d(L r100, L r101, e r102);

        L getCache();
    }

    public e() {
    }

    @Override // h84.n
    public abstract String a(String r100);

    @Override // h84.n
    public abstract void c(String r100, String r101);

    public abstract void d(String[] r100);

    public abstract String[] f();

    public void e(List<String> r100) {
        e r101 = this.f484122a;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // h84.n
    public final String b(String r100, String r101) {
        return (String) g(r100, r101, new b(this));
    }

    public final String h(String r100, String r101) {
        return (String) g(r100, r101, new a(this));
    }

    public final <T> T g(T r100, T r101, c<T> r102) {
        e r103 = this.f484122a;
        T r104 = r102.getCache();
        boolean r105 = r102.a(r100);
        boolean r106 = r102.a(r104);
        if (r105 == true) goto L6;
        if (r106 == false) goto L6;
        r100 = r104;
    L6:
        if (r103 == null) goto L11;
        T r107 = r102.d(r100, r101, r103);
        if (r102.b(r107, r104) == true) goto L10;
        r102.c(r107);
    L10:
        return r107;
    L11:
        if (r105 == true) goto L14;
        if (r106 == true) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == true) goto L17;
    L18:
        if (r105 == true) goto L20;
    L22:
        return r101;
    L20:
        if (r102.b(r101, r104) == true) goto L22;
    L21:
        r102.c(r101);
        goto L22
    L17:
        if (r102.a(r101) == true) goto L21;
    L14:
        r101 = r100;
        r108 = false;
        goto L15
    }
}
