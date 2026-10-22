package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w75.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {

    public static class a implements w75.c<f85.a> {
        public final f85.a a;

        @Override // w75.d
        public final void H() {
            this.a.f(true);
        }

        @Override // w75.d
        public final void j() {
            this.a.j = true;
        }

        @Override // w75.d
        public final void k() {
            this.a.o = true;
        }

        @Override // w75.d
        public final void y() {
            this.a.n = true;
        }

        @Override // w75.d
        public final d.a A() {
            Integer r1 = Integer.valueOf(this.a.e);
            if (r1 != null) goto L5;
            r1 = -1;
        L5:
            int r2 = r1.intValue();
            String r3 = this.a.f;
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            return new d.a(r2, r3);
        }

        @Override // w75.c
        public final String B() {
            return this.a.f;
        }

        @Override // w75.c
        public final boolean C() {
            return ((f85.a.C0229a) this.a.a).g;
        }

        @Override // w75.c
        public final List<Integer> E() {
            List<Integer> r0 = this.a.b;
            ArrayList r1 = new ArrayList(0);
            if (r0 != null) goto L6;
            r0 = r1;
        L6:
            return r0;
        }

        @Override // w75.d
        public final boolean F() {
            return this.a.e();
        }

        @Override // w75.d
        public final boolean G() {
            return this.a.x;
        }

        @Override // w75.c
        public final String I() {
            return ((f85.a.C0229a) this.a.a).k;
        }

        @Override // w75.c
        public final int J() {
            return this.a.m;
        }

        @Override // w75.c
        public final String a() {
            f85.a r0 = this.a;
            if (r0 == null) goto L8;
            w75.b r1 = r0.a;
            if (((f85.a.C0229a) r1) != null) goto L7;
            return "";
        L7:
            return ((f85.a.C0229a) r1).q;
        L8:
            return "";
        }

        @Override // w75.d
        public final SparseArray<PreviewMeta> b() {
            return ((f85.a.C0229a) this.a.a).i;
        }

        @Override // w75.c
        public final String d() {
            return this.a.w;
        }

        @Override // w75.c
        public final int e() {
            return ((f85.a.C0229a) this.a.a).e;
        }

        @Override // w75.c
        public final String getExtra() {
            return this.a.h;
        }

        @Override // w75.c
        public final long getFileSize() {
            return ((f85.a.C0229a) this.a.a).c;
        }

        @Override // w75.c
        public final String getFileToken() {
            return ((f85.a.C0229a) this.a.a).a;
        }

        @Override // w75.c
        public final DriveFilePath getLocalFilePath() {
            return this.a.a();
        }

        @Override // w75.c
        public final String h() {
            return ((f85.a.C0229a) this.a.a).p;
        }

        @Override // w75.c
        public final boolean i() {
            return this.a.t;
        }

        @Override // w75.c
        public final boolean l() {
            return this.a.c.get();
        }

        @Override // w75.d
        public final int n() {
            return this.a.q;
        }

        @Override // w75.c
        public final String r() {
            return this.a.r;
        }

        @Override // w75.c
        public final DriveFilePath v() {
            return this.a.b();
        }

        @Override // w75.c
        public final int w() {
            return ((f85.a.C0229a) this.a.a).s;
        }

        @Override // w75.d
        public final List<Integer> p() {
            return E();
        }

        @Override // w75.c
        public final w75.a getDetails() {
            return this.a;
        }

        public a(f85.a r1) {
            this.a = r1;
        }

        @Override // w75.d
        public final void D(List<Integer> r2) {
            this.a.b = r2;
        }

        @Override // w75.d
        public final void K(int r2) {
            this.a.q = r2;
        }

        @Override // w75.d
        public final void c(String r2) {
            this.a.i = r2;
        }

        @Override // w75.d
        public final void f(long r2) {
            this.a.u = r2;
        }

        @Override // w75.d
        public final void g(DriveFilePath r2) {
            this.a.k = r2;
        }

        @Override // w75.d
        public final void m(DriveFilePath r2) {
            this.a.l = r2;
        }

        @Override // w75.d
        public final void o(String r2) {
            this.a.h = r2;
        }

        @Override // w75.d
        public final void q(String r2) {
            this.a.r = r2;
        }

        @Override // w75.d
        public final void s(Map<String, String> r2) {
            this.a.h(r2);
        }

        @Override // w75.d
        public final PreviewMeta t(int r2) {
            SparseArray<PreviewMeta> r0 = b();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get(r2);
        }

        @Override // w75.d
        public final void u(LinkedHashMap<String, String> r2) {
            this.a.h(r2);
        }

        @Override // w75.d
        public final void x(d.a r3) {
            f85.a r0 = this.a;
            r0.f = r3.b;
            r0.e = r3.a;
        }

        @Override // w75.d
        public final void z(String r2) {
            this.a.f = r2;
        }
    }

    public static class b implements w75.c<f85.b> {
        public final f85.b a;

        @Override // w75.d
        public final void H() {
            this.a.f(true);
        }

        @Override // w75.c
        public final String a() {
            return "";
        }

        @Override // w75.c
        public final String h() {
            return "";
        }

        @Override // w75.d
        public final void j() {
            this.a.j = true;
        }

        @Override // w75.d
        public final void k() {
            this.a.o = true;
        }

        @Override // w75.c
        public final int w() {
            return 0;
        }

        @Override // w75.d
        public final void y() {
            this.a.n = true;
        }

        @Override // w75.d
        public final d.a A() {
            Integer r1 = Integer.valueOf(this.a.e);
            if (r1 != null) goto L5;
            r1 = -1;
        L5:
            int r2 = r1.intValue();
            String r3 = this.a.f;
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            return new d.a(r2, r3);
        }

        @Override // w75.c
        public final String B() {
            return this.a.f;
        }

        @Override // w75.c
        public final boolean C() {
            return ((f85.b.a) this.a.a).g;
        }

        @Override // w75.c
        public final List<Integer> E() {
            List<Integer> r0 = this.a.b;
            ArrayList r1 = new ArrayList(0);
            if (r0 != null) goto L6;
            r0 = r1;
        L6:
            return r0;
        }

        @Override // w75.d
        public final boolean F() {
            return this.a.e();
        }

        @Override // w75.d
        public final boolean G() {
            return this.a.x;
        }

        @Override // w75.c
        public final String I() {
            String r0 = ((f85.b.a) this.a.a).k;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // w75.c
        public final int J() {
            return this.a.m;
        }

        @Override // w75.d
        public final SparseArray<PreviewMeta> b() {
            return ((f85.b.a) this.a.a).i;
        }

        @Override // w75.c
        public final String d() {
            return this.a.w;
        }

        @Override // w75.c
        public final int e() {
            return ((f85.b.a) this.a.a).e;
        }

        @Override // w75.c
        public final String getExtra() {
            return this.a.h;
        }

        @Override // w75.c
        public final long getFileSize() {
            return ((f85.b.a) this.a.a).c;
        }

        @Override // w75.c
        public final String getFileToken() {
            return ((f85.b.a) this.a.a).a;
        }

        @Override // w75.c
        public final DriveFilePath getLocalFilePath() {
            return this.a.a();
        }

        @Override // w75.c
        public final boolean i() {
            return this.a.t;
        }

        @Override // w75.c
        public final boolean l() {
            return this.a.c.get();
        }

        @Override // w75.d
        public final int n() {
            return this.a.q;
        }

        @Override // w75.c
        public final String r() {
            return this.a.r;
        }

        @Override // w75.c
        public final DriveFilePath v() {
            return this.a.b();
        }

        @Override // w75.d
        public final List<Integer> p() {
            return E();
        }

        @Override // w75.c
        public final w75.a getDetails() {
            return this.a;
        }

        public b(f85.b r1) {
            this.a = r1;
        }

        @Override // w75.d
        public final void D(List<Integer> r2) {
            this.a.b = r2;
        }

        @Override // w75.d
        public final void K(int r2) {
            this.a.q = r2;
        }

        @Override // w75.d
        public final void c(String r2) {
            this.a.i = r2;
        }

        @Override // w75.d
        public final void f(long r2) {
            this.a.u = r2;
        }

        @Override // w75.d
        public final void g(DriveFilePath r2) {
            this.a.k = r2;
        }

        @Override // w75.d
        public final void m(DriveFilePath r2) {
            this.a.l = r2;
        }

        @Override // w75.d
        public final void o(String r2) {
            this.a.h = r2;
        }

        @Override // w75.d
        public final void q(String r2) {
            this.a.r = r2;
        }

        @Override // w75.d
        public final void s(Map<String, String> r2) {
            this.a.h(r2);
        }

        @Override // w75.d
        public final PreviewMeta t(int r2) {
            SparseArray<PreviewMeta> r0 = b();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get(r2);
        }

        @Override // w75.d
        public final void u(LinkedHashMap<String, String> r2) {
            this.a.h(r2);
        }

        @Override // w75.d
        public final void x(d.a r3) {
            f85.b r0 = this.a;
            r0.f = r3.b;
            r0.e = r3.a;
        }

        @Override // w75.d
        public final void z(String r2) {
            this.a.f = r2;
        }
    }

    public static <F extends w75.a> w75.c<F> a(F r3) {
        if ((r3 instanceof f85.a) == false) goto L7;
        return new a((f85.a) r3);
    L7:
        if ((r3 instanceof f85.b) == false) goto L11;
        return new b((f85.b) r3);
    L11:
        throw new IllegalArgumentException("Not support fm type, fm=" + r3);
    }
}
