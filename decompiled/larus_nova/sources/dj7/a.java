package dj7;

import android.text.TextUtils;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ug.sdk.luckycat.impl.lynx.LuckyCatContainerIDManager;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.manager.q;
import com.bytedance.ug.sdk.luckycat.impl.storage.ContainerLocalStorage;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements bk7.a {
    public a() {
    }

    @Override // bk7.a
    public final void b() {
        nj7.a.f519460b.b();
    }

    @Override // bk7.a
    public final void d() {
        nj7.a.f519460b.d();
    }

    @Override // bk7.a
    public final Object H(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return ContainerLocalStorage.a().b(r100);
    }

    @Override // bk7.a
    public final boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return ContainerLocalStorage.a().c(r100);
    }

    @Override // bk7.a
    public final bk7.a.C0312a registerXBridges(List<Class<? extends XBridgeMethod>> r100) {
        q r101 = q.b.f271365a;
        bk7.a.C0312a r102 = new bk7.a.C0312a();
        if (r101.f271357b == false) goto L11;
        LuckyCatSettingsManger r103 = LuckyCatSettingsManger.b.f271283a;
        r103.getClass();
        Object r104 = r103.c(new String[]{"common", "enable_lynx_dynamic_register_xbridge"});
        if ((r104 instanceof Boolean) == false) goto L8;
        boolean r105 = ((Boolean) r104).booleanValue();
    L9:
        if (r105 == false) goto L11;
        LuckyCatContainerIDManager.a(r100);
        goto L11
    L8:
        r105 = false;
    L11:
        return r102;
    }
}
