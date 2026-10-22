package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.retrofit2.SsResponse;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface c {

    public static final class a {
        public static Function2 a() {
            return IPrefetchConfig$getDataCallBack$1.INSTANCE;
        }
    }

    Map<String, String> a();

    boolean b();

    Function0<Unit> c();

    Function2<SsResponse<?>, String, Unit> d();

    Function0<Unit> e();

    void f();

    Function0<Unit> g();

    String getScene();

    void h();

    String i();

    Function0<Unit> j();

    e k();

    boolean l();

    PrefetchType m();
}
