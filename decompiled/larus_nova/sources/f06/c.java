package f06;

import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f474981a;

    public c() {
        this.f474981a = new ArrayList();
    }

    public final d b(int r110, String r111, String r112, Object r113, Object[] r114, String r115, b r210) {
        Integer r100 = Integer.valueOf(r110);
        g06.a r101 = ApiHookConfig.f245611b.get(r100);
        if (r101 == null) goto L5;
        a[] r102 = r101.f479473i;
    L6:
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L18;
        a r116 = r102[r104];
        d r105 = r116.preInvoke(r110, r111, r112, r113, r114, r115, r210);     // Catch: Exception -> L15
        if (r105.f474982a == true) goto L11;
        ((ArrayList) this.f474981a).add(r116);     // Catch: Exception -> L19
        goto L16
    L11:
        return r105;
    L16:
        r104 = r104 + 1;
        goto L7
    L18:
        return new d(false, null);
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void a(int r110, String r111, String r112, Object r113, Object[] r114, Object r115, b r116, boolean r210) {
        int r100 = ((ArrayList) this.f474981a).size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L7;
        ((a) ListProtector.get(this.f474981a, r100)).postInvoke(r110, r111, r112, r113, r114, r115, r116, r210);     // Catch: Exception -> L8
        goto L3
    }
}
