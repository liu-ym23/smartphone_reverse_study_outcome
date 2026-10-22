package u26;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static abstract class a implements b {
        public a() {
        }

        @Override // u26.b
        public void b(o r100) {
        }

        @Override // u26.b
        public void c(o r100) {
        }

        @Override // u26.b
        public void d(o r100) {
        }

        @Override // u26.b
        public void e(o r100, JSONObject r101) {
        }

        @Override // u26.b
        public void f(o r100, String r101) {
        }

        @Override // u26.b
        public void g(o r100, String r101) {
        }

        @Override // u26.b
        public void h(o r100) {
        }

        @Override // u26.b
        public void i(o r100, JSONObject r101) {
        }

        @Override // u26.b
        public void j(o r100) {
        }

        @Override // u26.b
        public void k(d36.e r100) {
        }

        @Override // u26.b
        public void l(o r100, e r101) {
        }

        @Override // u26.b
        public void m(d36.e r100) {
        }

        @Override // u26.b
        public void n(o r100, String r101) {
        }

        @Override // u26.b
        public void onTimingSetup(Map<String, Object> r100) {
        }

        @Override // u26.b
        public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        }

        @Override // u26.b
        public String shouldRedirectImageUrl(String r100) {
            return null;
        }

        @Override // u26.b
        public void a(o r100, Context r101, String r102, String r103, float r104, float r105, Transformer r106, Function2<Object, ? super Throwable, Unit> r107) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r107, "handler");
            r107.invoke(null, null);
        }
    }

    void a(o r100, Context r101, String r102, String r103, float r104, float r105, Transformer r106, Function2<Object, ? super Throwable, Unit> r107);

    void b(o r100);

    void c(o r100);

    void d(o r100);

    void e(o r100, JSONObject r101);

    void f(o r100, String r101);

    void g(o r100, String r101);

    void h(o r100);

    void i(o r100, JSONObject r101);

    void j(o r100);

    void k(d36.e r100);

    void l(o r100, e r101);

    void m(d36.e r100);

    void n(o r100, String r101);

    void onTimingSetup(Map<String, Object> r100);

    void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102);

    String shouldRedirectImageUrl(String r100);
}
