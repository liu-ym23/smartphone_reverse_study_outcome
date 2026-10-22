package x64;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.v.w;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f562618a = null;

    static {
        f562618a = new g();
    }

    public g() {
    }

    @Override // x64.j
    public final h b() {
        BadgerCore.Companion.getClass();
        if (com.bytedance.badger.j.a().isLogin() == false) goto L5;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r100 = com.bytedance.badger.v.d.f199329m;
        KProperty r101 = com.bytedance.badger.v.d.f199311a[12];
        w r102 = (w) r100.a();
    L6:
        long r103 = r102.a();
        com.bytedance.badger.v.d.f199322f0.getClass();
        return new h(0, r103, com.bytedance.badger.v.d.f().a(), false, 16);
    L5:
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r104 = com.bytedance.badger.v.d.f199330n;
        KProperty r105 = com.bytedance.badger.v.d.f199311a[13];
        r102 = (w) r104.a();
        goto L6
    }
}
