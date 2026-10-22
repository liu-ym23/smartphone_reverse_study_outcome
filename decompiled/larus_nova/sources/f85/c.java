package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w75.d;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    public static class a implements w75.c<f85.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f85.a f475881a;

        @Override // w75.d
        public final void H() {
            this.f475881a.f(true);
        }

        @Override // w75.d
        public final void j() {
            this.f475881a.f558541j = true;
        }

        @Override // w75.d
        public final void k() {
            this.f475881a.f558546o = true;
        }

        @Override // w75.d
        public final void y() {
            this.f475881a.f558545n = true;
        }

        @Override // w75.d
        public final d.a A() {
            Integer r100 = Integer.valueOf(this.f475881a.f558536e);
            if (r100 != null) goto L5;
            r100 = -1;
        L5:
            int r101 = r100.intValue();
            String r102 = this.f475881a.f558537f;
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            return new d.a(r101, r102);
        }

        @Override // w75.c
        public final String B() {
            return this.f475881a.f558537f;
        }

        @Override // w75.c
        public final boolean C() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558563g;
        }

        @Override // w75.c
        public final List<Integer> E() {
            List<Integer> r100 = this.f475881a.f558533b;
            ArrayList r101 = new ArrayList(0);
            if (r100 != null) goto L6;
            r100 = r101;
        L6:
            return r100;
        }

        @Override // w75.d
        public final boolean F() {
            return this.f475881a.e();
        }

        @Override // w75.d
        public final boolean G() {
            return this.f475881a.f558555x;
        }

        @Override // w75.c
        public final String I() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558567k;
        }

        @Override // w75.c
        public final int J() {
            return this.f475881a.f558544m;
        }

        @Override // w75.c
        public final String a() {
            f85.a r100 = this.f475881a;
            if (r100 == null) goto L8;
            w75.b r101 = r100.f558532a;
            if (((f85.a.C5868a) r101) != null) goto L7;
            return "";
        L7:
            return ((f85.a.C5868a) r101).f475874q;
        L8:
            return "";
        }

        @Override // w75.d
        public final SparseArray<PreviewMeta> b() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558565i;
        }

        @Override // w75.c
        public final String d() {
            return this.f475881a.f558554w;
        }

        @Override // w75.c
        public final int e() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558561e;
        }

        @Override // w75.c
        public final String getExtra() {
            return this.f475881a.f558539h;
        }

        @Override // w75.c
        public final long getFileSize() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558559c;
        }

        @Override // w75.c
        public final String getFileToken() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f558557a;
        }

        @Override // w75.c
        public final DriveFilePath getLocalFilePath() {
            return this.f475881a.a();
        }

        @Override // w75.c
        public final String h() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f475873p;
        }

        @Override // w75.c
        public final boolean i() {
            return this.f475881a.f558551t;
        }

        @Override // w75.c
        public final boolean l() {
            return this.f475881a.f558534c.get();
        }

        @Override // w75.d
        public final int n() {
            return this.f475881a.f558548q;
        }

        @Override // w75.c
        public final String r() {
            return this.f475881a.f558549r;
        }

        @Override // w75.c
        public final DriveFilePath v() {
            return this.f475881a.b();
        }

        @Override // w75.c
        public final int w() {
            return ((f85.a.C5868a) this.f475881a.f558532a).f475876s;
        }

        @Override // w75.d
        public final List<Integer> p() {
            return E();
        }

        @Override // w75.c
        public final w75.a getDetails() {
            return this.f475881a;
        }

        public a(f85.a r100) {
            this.f475881a = r100;
        }

        @Override // w75.d
        public final void D(List<Integer> r100) {
            this.f475881a.f558533b = r100;
        }

        @Override // w75.d
        public final void K(int r100) {
            this.f475881a.f558548q = r100;
        }

        @Override // w75.d
        public final void c(String r100) {
            this.f475881a.f558540i = r100;
        }

        @Override // w75.d
        public final void f(long r100) {
            this.f475881a.f558552u = r100;
        }

        @Override // w75.d
        public final void g(DriveFilePath r100) {
            this.f475881a.f558542k = r100;
        }

        @Override // w75.d
        public final void m(DriveFilePath r100) {
            this.f475881a.f558543l = r100;
        }

        @Override // w75.d
        public final void o(String r100) {
            this.f475881a.f558539h = r100;
        }

        @Override // w75.d
        public final void q(String r100) {
            this.f475881a.f558549r = r100;
        }

        @Override // w75.d
        public final void s(Map<String, String> r100) {
            this.f475881a.h(r100);
        }

        @Override // w75.d
        public final PreviewMeta t(int r100) {
            SparseArray<PreviewMeta> r101 = b();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.get(r100);
        }

        @Override // w75.d
        public final void u(LinkedHashMap<String, String> r100) {
            this.f475881a.h(r100);
        }

        @Override // w75.d
        public final void x(d.a r100) {
            f85.a r101 = this.f475881a;
            r101.f558537f = r100.f558570b;
            r101.f558536e = r100.f558569a;
        }

        @Override // w75.d
        public final void z(String r100) {
            this.f475881a.f558537f = r100;
        }
    }

    public static class b implements w75.c<f85.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f85.b f475882a;

        @Override // w75.d
        public final void H() {
            this.f475882a.f(true);
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
            this.f475882a.f558541j = true;
        }

        @Override // w75.d
        public final void k() {
            this.f475882a.f558546o = true;
        }

        @Override // w75.c
        public final int w() {
            return 0;
        }

        @Override // w75.d
        public final void y() {
            this.f475882a.f558545n = true;
        }

        @Override // w75.d
        public final d.a A() {
            Integer r100 = Integer.valueOf(this.f475882a.f558536e);
            if (r100 != null) goto L5;
            r100 = -1;
        L5:
            int r101 = r100.intValue();
            String r102 = this.f475882a.f558537f;
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            return new d.a(r101, r102);
        }

        @Override // w75.c
        public final String B() {
            return this.f475882a.f558537f;
        }

        @Override // w75.c
        public final boolean C() {
            return ((f85.b.a) this.f475882a.f558532a).f558563g;
        }

        @Override // w75.c
        public final List<Integer> E() {
            List<Integer> r100 = this.f475882a.f558533b;
            ArrayList r101 = new ArrayList(0);
            if (r100 != null) goto L6;
            r100 = r101;
        L6:
            return r100;
        }

        @Override // w75.d
        public final boolean F() {
            return this.f475882a.e();
        }

        @Override // w75.d
        public final boolean G() {
            return this.f475882a.f558555x;
        }

        @Override // w75.c
        public final String I() {
            String r100 = ((f85.b.a) this.f475882a.f558532a).f558567k;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        @Override // w75.c
        public final int J() {
            return this.f475882a.f558544m;
        }

        @Override // w75.d
        public final SparseArray<PreviewMeta> b() {
            return ((f85.b.a) this.f475882a.f558532a).f558565i;
        }

        @Override // w75.c
        public final String d() {
            return this.f475882a.f558554w;
        }

        @Override // w75.c
        public final int e() {
            return ((f85.b.a) this.f475882a.f558532a).f558561e;
        }

        @Override // w75.c
        public final String getExtra() {
            return this.f475882a.f558539h;
        }

        @Override // w75.c
        public final long getFileSize() {
            return ((f85.b.a) this.f475882a.f558532a).f558559c;
        }

        @Override // w75.c
        public final String getFileToken() {
            return ((f85.b.a) this.f475882a.f558532a).f558557a;
        }

        @Override // w75.c
        public final DriveFilePath getLocalFilePath() {
            return this.f475882a.a();
        }

        @Override // w75.c
        public final boolean i() {
            return this.f475882a.f558551t;
        }

        @Override // w75.c
        public final boolean l() {
            return this.f475882a.f558534c.get();
        }

        @Override // w75.d
        public final int n() {
            return this.f475882a.f558548q;
        }

        @Override // w75.c
        public final String r() {
            return this.f475882a.f558549r;
        }

        @Override // w75.c
        public final DriveFilePath v() {
            return this.f475882a.b();
        }

        @Override // w75.d
        public final List<Integer> p() {
            return E();
        }

        @Override // w75.c
        public final w75.a getDetails() {
            return this.f475882a;
        }

        public b(f85.b r100) {
            this.f475882a = r100;
        }

        @Override // w75.d
        public final void D(List<Integer> r100) {
            this.f475882a.f558533b = r100;
        }

        @Override // w75.d
        public final void K(int r100) {
            this.f475882a.f558548q = r100;
        }

        @Override // w75.d
        public final void c(String r100) {
            this.f475882a.f558540i = r100;
        }

        @Override // w75.d
        public final void f(long r100) {
            this.f475882a.f558552u = r100;
        }

        @Override // w75.d
        public final void g(DriveFilePath r100) {
            this.f475882a.f558542k = r100;
        }

        @Override // w75.d
        public final void m(DriveFilePath r100) {
            this.f475882a.f558543l = r100;
        }

        @Override // w75.d
        public final void o(String r100) {
            this.f475882a.f558539h = r100;
        }

        @Override // w75.d
        public final void q(String r100) {
            this.f475882a.f558549r = r100;
        }

        @Override // w75.d
        public final void s(Map<String, String> r100) {
            this.f475882a.h(r100);
        }

        @Override // w75.d
        public final PreviewMeta t(int r100) {
            SparseArray<PreviewMeta> r101 = b();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.get(r100);
        }

        @Override // w75.d
        public final void u(LinkedHashMap<String, String> r100) {
            this.f475882a.h(r100);
        }

        @Override // w75.d
        public final void x(d.a r100) {
            f85.b r101 = this.f475882a;
            r101.f558537f = r100.f558570b;
            r101.f558536e = r100.f558569a;
        }

        @Override // w75.d
        public final void z(String r100) {
            this.f475882a.f558537f = r100;
        }
    }

    public static <F extends w75.a> w75.c<F> a(F r100) {
        if ((r100 instanceof f85.a) == false) goto L7;
        return new a((f85.a) r100);
    L7:
        if ((r100 instanceof f85.b) == false) goto L11;
        return new b((f85.b) r100);
    L11:
        throw new IllegalArgumentException("Not support fm type, fm=" + r100);
    }
}
