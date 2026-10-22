package w75;

import android.util.SparseArray;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {

    public static final class a {
        public final int a;
        public final String b;

        public final String toString() {
            return "PreviewEntity{previewType=" + this.a + ", previewExt='" + this.b + "'}";
        }

        public a(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    a A();

    void D(List<Integer> r1);

    boolean F();

    boolean G();

    void H();

    void K(int r1);

    SparseArray<PreviewMeta> b();

    void c(String r1);

    void f(long r1);

    void g(DriveFilePath r1);

    void j();

    void k();

    void m(DriveFilePath r1);

    int n();

    void o(String r1);

    List<Integer> p();

    void q(String r1);

    void s(Map<String, String> r1);

    PreviewMeta t(int r1);

    void u(LinkedHashMap<String, String> r1);

    void x(a r1);

    void y();

    void z(String r1);
}
