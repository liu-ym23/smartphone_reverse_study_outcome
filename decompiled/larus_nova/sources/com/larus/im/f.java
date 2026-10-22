package com.larus.im;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface f {

    public interface a {
        void a(String r100);

        void b(String r100);
    }

    public interface b {
        boolean a(String r100);

        void name();
    }

    int c();

    void d(Function1<? super byte[], Unit> r100);

    void e(Function1<? super byte[], Unit> r100);

    void f(byte[] r100, Map<String, String> r101, Function1<? super Boolean, Unit> r102);

    void g(Function1<? super Integer, Unit> r100);

    int getChannelId();

    int getServiceId();

    void h(String r100, boolean r101);

    void i(Function1<? super Integer, Unit> r100);

    void j(com.obric.assistant.frontier.g r100);

    void k();

    void l(ed9.a r100, String r101);
}
