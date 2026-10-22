package com.bytedance.push.settings;

import com.bytedance.push.settings.annotation.Settings;
import java.util.Map;
import u77.e;
import y77.c;

/* JADX INFO: loaded from: classes3.dex */
@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
public interface LocalSettings extends ILocalSettings {
    void B(int r100);

    void D(c r100);

    void E(int r100);

    void G();

    boolean I();

    void J(boolean r100);

    void K();

    void N(String r100);

    long Q();

    void R(boolean r100);

    String T();

    long U();

    k77.c V();

    void X(k77.c r100);

    void Z(String r100);

    boolean b();

    void c();

    void d0(long r100);

    Map<String, e> e();

    void e0(long r100);

    void f(long r100);

    String g0();

    String getAndroidId();

    long h();

    void h0();

    void k(String r100);

    boolean l();

    c n();

    void o(String r100);

    int o0();

    String q0();

    void r(boolean r100);

    String t0();

    boolean u();

    int v();

    int w();

    boolean x();

    boolean y();

    void z(Map<String, e> r100);
}
