package x64;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.v.w;
import kotlin.Pair;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f562617a = null;

    static {
        f562617a = new f();
    }

    public f() {
    }

    @Override // x64.j
    public final h b() {
        BadgerCore.Companion.getClass();
        if (com.bytedance.badger.j.a().isLogin() == false) goto L5;
        com.bytedance.badger.C.b r100 = com.bytedance.badger.C.b.f199024b;
    L6:
        com.bytedance.badger.C.b r101 = b.f562608a;
        b.f562608a = r100;
        Pair r102 = k.a(b.f562608a);
        long r103 = ((Number) r102.component1()).longValue();
        long r104 = ((Number) r102.component2()).longValue();
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r105 = com.bytedance.badger.v.d.f199333q;
        KProperty r106 = com.bytedance.badger.v.d.f199311a[16];
        return new h(r103, r104, ((w) r105.a()).a(), true, 23);
    L5:
        r100 = com.bytedance.badger.C.b.f199023a;
        goto L6
    }
}
