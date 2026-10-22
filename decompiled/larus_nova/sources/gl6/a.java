package gl6;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.locallife.ILocalLifeService;
import com.bytedance.locallife.rate.LifeServiceRateListLynxFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: gl6.a$a, reason: collision with other inner class name */
    public static final class C6034a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Uri r101 = r100.f267530d;
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = UriProtector.getQueryParameter(r101, LifeServiceRateListLynxFragment.IS_LIFE_POI);
    L10:
        if (Intrinsics.areEqual(r103, "1") == true) goto L16;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L15;
        r102 = r104.getHost();
    L15:
        if (Intrinsics.areEqual(r102, AppletNaviType.POI) == true) goto L16;
    L19:
        ILocalLifeService r105 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r105 != null) goto L22;
        return false;
    L22:
        return r105.b(r100.f267530d);
    L16:
        ILocalLifeService r106 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r106 == null) goto L19;
        r106.a();
        goto L19
    L8:
        r103 = null;
        goto L10
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L12;
        ILocalLifeService r102 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.handleSchema(r100, r101.f267530d);
    L12:
        return false;
    L10:
        return false;
    }
}
