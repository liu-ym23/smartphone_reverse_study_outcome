package z2;

import android.webkit.PermissionRequest;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f569732a;

    public /* synthetic */ e(PermissionRequest r100) {
        this.f569732a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r210) {
        PermissionRequest r100 = this.f569732a;
        List r101 = (List) r210;
        Intrinsics.checkNotNullParameter(r101, "granted");
        if (r101.isEmpty() == false) goto L5;
        l.b(r100);
    L24:
        return Unit.INSTANCE;
    L5:
        String[] r110 = (String[]) r101.toArray(new String[0]);
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110};
        f06.b r113 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102605);
        if (r102 == null) goto L8;
        f06.a[] r103 = r102.f479473i;
    L9:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L18;
        f06.a r107 = r104[r106];
        int r114 = r106;
        int r115 = r105;
        f06.a[] r211 = r104;
        f06.d r108 = r107.preInvoke(102605, "android/webkit/PermissionRequest", "grant", r100, r112, "void", r113);     // Catch: Exception -> L25
        if (r108.f474982a == true) goto L20;
        r111.add(r107);     // Catch: Exception -> L25
    L20:
        if (r108.f474982a == true) goto L24;
        r100.grant(r110);
    L17:
        r106 = r114 + 1;
        r105 = r115;
        r104 = r211;
        goto L11
    L18:
        r108 = new f06.d(false, null);
        goto L20
    L8:
        r103 = ApiHookConfig.f245613d;
        goto L9
    }
}
