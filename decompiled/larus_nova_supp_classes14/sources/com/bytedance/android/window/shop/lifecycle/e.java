package com.bytedance.android.window.shop.lifecycle;

import android.content.Context;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(f r6, ECWindowParam r7, long r8) {
            r6.m(r7, r8, null, null);
        }

        public static /* synthetic */ void b(f r6, ECWindowParam r7, long r8, JSONObject r10) {
            r6.c(r7, r8, r10, null);
        }
    }

    void a();

    void b();

    void c(ECWindowParam r1, long r2, JSONObject r4, JSONObject r5);

    void d(long r1);

    void e(ECWindowParam r1, JSONObject r2, JSONObject r3);

    void f();

    void g(ECWindowParam r1);

    void h(ECWindowParam r1);

    void i(ECWindowParam r1, WindowTabInfoProvider r2, Map<String, String> r3);

    void j(WindowTabInfoProvider r1);

    void k();

    void l();

    void m(ECWindowParam r1, long r2, JSONObject r4, JSONObject r5);

    void n(uq3.a r1);

    void o(Context r1, ECWindowParam r2);

    void p(ECWindowParam r1, WindowHeaderResponseDTO r2);

    void q(Context r1, ECWindowParam r2);

    void r();

    e s(boolean r1);

    void t(int r1, Integer r2, WindowTypeSeparatedAdapter r3);

    void u();

    void v();
}
