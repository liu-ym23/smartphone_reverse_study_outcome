package m27;

import com.bytedance.mira.MiraPluginEventListener;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements MiraPluginEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f511672a;

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginLoaded(String r100) {
    }

    public b(c r100) {
        this.f511672a = r100;
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginInstallResult(String r100, boolean r101) {
        Plugin r102 = PluginManager.getInstance().getPlugin(r100);
        int r103 = 0;
        if (r101 == false) goto L9;
        if (r102 == null) goto L7;
        r103 = r102.mVersionCode;
    L7:
        i27.a r104 = new i27.a(r100, r103, 5);
    L14:
        h27.c.a().c(r104);
        h27.c.a().b(r104);
        return;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.mVersionCode;
    L11:
        r104 = new i27.a(r100, r103, 6);
        r104.f488053g = -100;
        Exception r105 = (Exception) ((HashMap) this.f511672a.f511676c).get(r100);
        if (r105 == null) goto L14;
        r104.f488055i = r105;
        ((HashMap) this.f511672a.f511676c).remove(r100);
        goto L14
    }
}
