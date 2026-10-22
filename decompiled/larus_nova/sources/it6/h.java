package it6;

import com.alibaba.gaiax.api.IGXRegisterCenter;
import com.alibaba.gaiax.api.IGXTemplateEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface h {
    void a(Function1<? super d, Unit> r100);

    void b(Function1<? super IGXRegisterCenter, Unit> r100);

    void c(Function1<? super IGXTemplateEngine, Unit> r100);

    void d(Function0 r100, Function2 r101);

    boolean isPluginReady();
}
