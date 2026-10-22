package ih3;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements s83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f489799a = null;

    public a() {
    }

    static {
        f489799a = new a();
    }

    @Override // s83.a
    public final JsonObject a() {
        return b.f489800a.a();
    }

    @Override // s83.a
    public final boolean b() {
        return b.f489800a.b();
    }

    @Override // s83.a
    public final int c() {
        return b.f489800a.c();
    }

    @Override // s83.a
    public final boolean f() {
        return b.f489800a.f();
    }

    @Override // s83.a
    public final int h() {
        return b.f489800a.h();
    }

    @Override // s83.a
    public final int i() {
        return b.f489800a.i();
    }

    @Override // s83.a
    public final Map<String, Object> d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return b.f489800a.d(r100);
    }

    @Override // s83.a
    public final <T> T e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) b.f489800a.e(r100);
    }

    @Override // s83.a
    public final Map<String, Object> g(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        return b.f489800a.g(r100);
    }

    @Override // s83.a
    public final Object getValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return b.f489800a.getValue(r100);
    }
}
