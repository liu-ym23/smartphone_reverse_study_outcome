package gm6;

import com.bytedance.crash.Npth;
import com.bytedance.crash.d;
import java.util.Map;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements st6.a {
    public a() {
    }

    @Override // st6.a
    public final void b(String r100) {
        Npth.removeTag(r100);
    }

    @Override // st6.a
    public final void ensureNotReachHere(Throwable r100) {
        d.c(r100);
    }

    @Override // st6.a
    public final void a(String r100, String r101) {
        Npth.addTag(r100, r101);
    }

    @Override // st6.a
    public final void ensureNotReachHere(Throwable r100, String r101) {
        d.d(r100, r101);
    }

    @Override // st6.a
    public final void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        d.e(r100, r101, r102);
    }
}
