package com.bytedance.push.settings;

import com.bytedance.push.settings.annotation.Settings;
import java.util.Arrays;
import java.util.List;
import k77.b;
import s77.c;
import u77.d;
import u77.g;
import u77.i;
import u77.j;
import u77.l;
import y77.f;

/* JADX INFO: loaded from: classes3.dex */
@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
public interface PushOnlineSettings extends ISettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f267015a = null;

    int A();

    i B();

    boolean C();

    c D();

    int E();

    boolean F();

    boolean G();

    boolean H();

    b I();

    boolean J();

    r77.b K();

    boolean L();

    boolean M();

    d N();

    boolean O();

    int P();

    boolean Q();

    boolean R();

    u77.b S();

    long T();

    boolean U();

    boolean V();

    boolean W();

    int X();

    boolean Y();

    int Z();

    t77.b a0();

    long b0();

    f c0();

    int d0();

    boolean e0();

    boolean f();

    boolean g();

    l77.b getClientIntelligenceSettings();

    n77.b h();

    String i();

    boolean j();

    j k();

    boolean l();

    boolean m();

    int n();

    long o();

    g p();

    boolean q();

    l r();

    boolean s();

    long t();

    b87.b u();

    String v();

    boolean w();

    long x();

    boolean y();

    x77.b z();

    static {
        f267015a = Arrays.asList(new String[]{"gif_sys_permission_page_settings", "google_custom_sys_dialog_config"});
    }
}
