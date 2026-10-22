package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.u;
import cq8.y;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ a0 a(e r100, u r101, c r102, Function1 r103) {
            return r100.k(r101, r102, r103, null, null);
        }
    }

    boolean a();

    String f();

    String g();

    int getType();

    String getWidgetId();

    void h(Integer r100);

    void i(String r100, boolean r101);

    void j();

    a0 k(u r100, c r101, Function1<? super y, Unit> r102, e r103, String r104);

    void l(Map<String, ?> r100);

    void m(y r100);

    a0 n(String r100);
}
