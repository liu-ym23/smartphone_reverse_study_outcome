package m.l.lynx.svs.svsimpl;

import com.lynx.canvas.KryptonPluginLoaderService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import kotlin.Metadata;
import quc.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0006"}, d2 = {"Lm/l/lynx/svs/svsimpl/LynxSoLibLoader;", "", "()V", "onLynxViewCreated", "", "view", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class LynxSoLibLoader {
    public static final LynxSoLibLoader INSTANCE = null;

    private LynxSoLibLoader() {
    }

    static {
        INSTANCE = new LynxSoLibLoader();
    }

    public final void onLynxViewCreated(Object r100) {
        if ((r100 instanceof LynxView) == false) goto L8;
        a r101 = a.f534860b;
        LynxKryptonHelper r102 = LynxKryptonUtils.getLynxKryptonHelper((LynxView) r100);
        if (r102 == null) goto L9;
        r102.registerService(KryptonPluginLoaderService.class, r101);
        return;
    L9:
        return;
    }
}
