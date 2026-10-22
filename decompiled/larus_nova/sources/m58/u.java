package m58;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface u {

    /* JADX INFO: loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ void a(u r100, String r101, Integer r102, String r103) {
            r100.k(r101, r102, r103, null);
        }

        public static /* synthetic */ void b(u r100, String r101, String r110, Integer r111, String r112, JSONObject r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            Integer r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            String r103 = null;
        L11:
            if ((r114 & 16) == 0) goto L13;
            JSONObject r104 = null;
        L14:
            r100.h(r101, r110, r102, r103, r104);
            return;
        L13:
            r104 = r113;
            goto L14
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }
    }

    String a(String r100);

    void b(String r100, String r101, String r102, JSONObject r103);

    void c(String r100, String r101, Function2<? super String, ? super String, Unit> r102);

    void d(String r100, String r101, String r102);

    void e(String r100);

    void f(String r100, String r101, JSONObject r102);

    void g(String r100, Integer r101, String r102);

    void h(String r100, String r101, Integer r102, String r103, JSONObject r104);

    void i(String r100, Function2<? super String, ? super String, Unit> r101);

    void j(String r100, String r101, Integer r102, String r103);

    void k(String r100, Integer r101, String r102, String r103);

    String l(String r100);
}
