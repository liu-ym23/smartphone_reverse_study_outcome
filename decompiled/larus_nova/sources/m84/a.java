package m84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f512467a;

    public a() {
        this.f512467a = null;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r100) {
        BDLocationCallback r101 = this.f512467a;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101330);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(101330, "com/bytedance/bdlocation_impl/utils/LocationImplUtil$1", "onLocationChanged", this, r101, "void", r110);     // Catch: Exception -> L23
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L23
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        BDLocationCallback r108 = this.f512467a;
        if (r108 == null) goto L29;
        r108.onLocationChanged(r210);
        return;
    L29:
        return;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
