package x64;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.utils.n;
import java.nio.charset.Charset;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair f562614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f562615b = null;

    public d() {
    }

    @Override // x64.j
    public final h b() {
        long r100 = ((Number) f562614a.getSecond()).longValue();
        com.bytedance.badger.v.d.f199322f0.getClass();
        return new h(0, r100, com.bytedance.badger.v.d.f().a(), false, 15);
    }

    static {
        f562615b = new d();
        com.bytedance.badger.C.b r100 = b.f562608a;
        f562614a = k.a(b.f562608a);
    }

    @Override // x64.j
    public final z64.c a(l r110) {
        BadgerCore.Companion.getClass();
        String r100 = com.bytedance.badger.j.a().getDeviceId();
        int r101 = n.f199273a;
        Charset r102 = Charsets.UTF_8;
        if (r100 == null) goto L7;
        String r103 = UInt.m9590toStringimpl(UInt.m9544constructorimpl(n.a(r100.getBytes(r102))));
        int r104 = r110.f562629b;
        String r105 = r110.f562632e;
        String r106 = r110.f562633f;
        return new z64.f(r103, r104, r100, System.currentTimeMillis(), r105, r106);
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
