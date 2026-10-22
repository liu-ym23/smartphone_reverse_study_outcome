package com.larus.platform.api;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365225a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365226a = null;

        static {
            f365226a = new a();
        }

        public a() {
        }
    }

    static {
        f365225a = a.f365226a;
    }

    void a(br9.a r100, String r101);

    int c();

    void d(Function1<? super byte[], Unit> r100);

    void f(byte[] r100, Map<String, String> r101, Function1<? super Boolean, Unit> r102);

    void g(Function1<? super Integer, Unit> r100);

    int getChannelId();

    int getServiceId();

    void h(String r100, boolean r101);

    void i(Function1<? super Integer, Unit> r100);
}
