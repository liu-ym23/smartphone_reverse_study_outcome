package uc;

import android.app.Activity;
import android.util.AndroidRuntimeException;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.d;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.g;
import com.bytedance.android.bst.api.saas.SaasService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SaasService f549419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f549420b = null;

    public a() {
    }

    @Override // uc.c
    public final void a() {
    }

    @Override // uc.c
    public final void b() {
    }

    @Override // uc.c
    public final void bindView() {
    }

    @Override // uc.c
    public final void c() {
    }

    @Override // uc.c
    public final void f() {
    }

    @Override // uc.c
    public final void h() {
    }

    static {
        f549420b = new a();
        f549419a = new SaasService();
    }

    @Override // uc.c
    public final void e(d r100) {
        SaasService r101 = f549419a;
        r101.getClass();
        r101.b(r100.f41912g);
        g r102 = r100.f41911f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L5:
        String r103 = r100.f41907b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L8:
        r102.a(r103, new LinkedHashMap());
        ExtKt.a("clickTrack", r100.f41906a + " emit");
    }

    @Override // uc.c
    public final void g(d r110) {
        SaasService r100 = f549419a;
        r100.getClass();
        r100.b(r110.f41912g);
        Activity r101 = ExtKt.getActivity(r110.f41912g);
        if (r101 != null) goto L11;
        g r102 = r110.f41911f;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L7:
        String r103 = r110.f41907b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L10:
        r102.a(r103, new LinkedHashMap());
        ExtKt.a("autoShowTrack", r110.f41906a + " emit for activity is null");
        return;
    L11:
        String r104 = r110.f41909d;
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L49;
        Object r106 = r110.f41912g;
        Object r107 = r110.f41908c;
        if ((r107 instanceof String) == false) goto L22;
        String r108 = (String) r107;
    L25:
        String r109 = r104 + '_' + r108;
        List<SaasService.b> r111 = (List) ((LinkedHashMap) r100.f41927b).get(new com.bytedance.android.bst.api.ext.c(r101));
        if (r111 == null) goto L37;
        Iterator<T> r112 = r111.iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((SaasService.b) r113).f41928a, r109) == false) goto L29;
    L34:
        if (r113 == null) goto L37;
        ExtKt.a("autoShowTrack", r110.f41906a + " intercept,for exposure repeat");
        return;
    L33:
        r113 = null;
    L37:
        if (r111 != null) goto L40;
        r111 = new ArrayList();
    L40:
        r111.add(new SaasService.b(r109, r110.f41910e));
        r100.f41927b.put(new com.bytedance.android.bst.api.ext.c(r101), r111);
        g r114 = r110.f41911f;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L43:
        String r115 = r110.f41907b;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L46:
        r114.a(r115, new LinkedHashMap());
        ExtKt.a("autoShowTrack", r110.f41906a + " emit");
        return;
    L22:
        if (r107 == null) goto L24;
        r106 = r107;
    L24:
        r108 = String.valueOf(System.identityHashCode(r106));
        goto L25
    L49:
        throw new AndroidRuntimeException("rule key is null");
    L14:
        if (r104.length() == 0) goto L17;
        r105 = false;
        goto L18
    }

    @Override // uc.c
    public final void d(RecyclerView r100, int r101) {
        f549419a.a(r100, r101);
    }
}
