package ih3;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements s83.a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    @Override // s83.a
    public final JsonObject a() {
        return b.a.a();
    }

    @Override // s83.a
    public final boolean b() {
        return b.a.b();
    }

    @Override // s83.a
    public final int c() {
        return b.a.c();
    }

    @Override // s83.a
    public final boolean f() {
        return b.a.f();
    }

    @Override // s83.a
    public final int h() {
        return b.a.h();
    }

    @Override // s83.a
    public final int i() {
        return b.a.i();
    }

    @Override // s83.a
    public final Map<String, Object> d(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return b.a.d(r2);
    }

    @Override // s83.a
    public final <T> T e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (T) b.a.e(r2);
    }

    @Override // s83.a
    public final Map<String, Object> g(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        return b.a.g(r2);
    }

    @Override // s83.a
    public final Object getValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return b.a.getValue(r2);
    }
}
