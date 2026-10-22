package com.ss.videoarch.live;

import android.os.Looper;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.videoarch.live.a$a, reason: collision with other inner class name */
    public interface InterfaceC5509a extends b {
        void f(String r100);
    }

    public interface b {
    }

    public interface c extends b {
        void a();
    }

    public interface d extends b {
        JSONObject c(int r100, JSONObject r101);

        void e(String r100);

        String g();
    }

    public interface e extends b {
        String b(String r100);

        List<String> d(String r100);

        int getEffectiveConnectionType();
    }

    public a() {
    }

    public abstract long a(int r100);

    public abstract long b(String r100, int r101);

    public abstract String c();

    public abstract String d(String r100, int r101);

    public abstract boolean e();

    public abstract void f(String r100, String r101);

    public abstract void g(String r100);

    public abstract void h(String r100, String r101);

    public abstract void i(String r100, String r101);

    public abstract void j(String r100);

    public abstract void k(int r100, String r101, long r102);

    public abstract void l(int r100, int r101);

    public abstract void m(int r100, b r101);

    public abstract void n(int r100, long r101);

    public abstract void o(int r100, String r101);

    public abstract void p(String r100, String r101);

    public abstract int q(Looper r100);

    public abstract void r(String r100);
}
