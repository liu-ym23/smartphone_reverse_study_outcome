package w75;

import android.util.SparseArray;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f558569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f558570b;

        public final String toString() {
            return "PreviewEntity{previewType=" + this.f558569a + ", previewExt='" + this.f558570b + "'}";
        }

        public a(int r100, String r101) {
            this.f558569a = r100;
            this.f558570b = r101;
        }
    }

    a A();

    void D(List<Integer> r100);

    boolean F();

    boolean G();

    void H();

    void K(int r100);

    SparseArray<PreviewMeta> b();

    void c(String r100);

    void f(long r100);

    void g(DriveFilePath r100);

    void j();

    void k();

    void m(DriveFilePath r100);

    int n();

    void o(String r100);

    List<Integer> p();

    void q(String r100);

    void s(Map<String, String> r100);

    PreviewMeta t(int r100);

    void u(LinkedHashMap<String, String> r100);

    void x(a r100);

    void y();

    void z(String r100);
}
