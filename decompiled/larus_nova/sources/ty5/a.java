package ty5;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<GeckoUpdateListener> f547967a = null;

    static {
        f547967a = new CopyOnWriteArraySet();
    }

    public static void a(GeckoUpdateListener r100, UpdatePackage r101, Throwable r102) {
        if (r100 == null) goto L5;
        r100.onUpdateFailed(r101, r102);
        r100.onUpdateFailed(r101.getChannel(), r102);
        return;
    }

    public static void b(GeckoUpdateListener r100, String r101, String r102, long r103) {
        if (r100 == null) goto L5;
        AtomicBoolean r104 = GlobalManager.f250632a;
        String r105 = ResLoadUtils.getChannelPath(new PolarisFileWrapper(GlobalManager.b(r101)), r101, r102, r103);
        LocalPackageModel r106 = new LocalPackageModel(r101, r102);
        r106.setLatestVersion(r103);
        r106.setChannelPath(r105);
        r100.onLocalNewestVersion(r106);
        return;
    }
}
