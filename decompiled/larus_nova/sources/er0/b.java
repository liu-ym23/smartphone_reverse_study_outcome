package er0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.launch.AudienceLaunchMgContextService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements wo0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OpenPlatformContext f473576a;

    public b() {
    }

    @Override // wo0.a
    public final jr0.a getAudienceMiniGameWidgetDescriptor() {
        return new jr0.a();
    }

    @Override // wo0.a
    public final void reportMpShow() {
        OpenPlatformContext r100 = this.f473576a;
        if (r100 == null) goto L8;
        AudienceMiniGameAppLogContextService r101 = (AudienceMiniGameAppLogContextService) r100.getService(AudienceMiniGameAppLogContextService.class);
        if (r101 == null) goto L9;
        r101.h(BdpAppEventConstant.EVENT_MP_SHOW, null);
        return;
    L9:
        return;
    }

    @Override // xo0.a
    public final OpenPlatformContext a() {
        return this.f473576a;
    }

    @Override // xo0.a
    public final void b(OpenPlatformContext r100) {
        this.f473576a = r100;
    }

    @Override // wo0.a
    public final void reportMpClick(MountedMiniGameSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        int r101 = a.f473575a[r100.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = kr0.a.a("mg_link");
    L9:
        OpenPlatformContext r103 = this.f473576a;
        if (r103 == null) goto L23;
        AudienceMiniGameAppLogContextService r104 = (AudienceMiniGameAppLogContextService) r103.getService(AudienceMiniGameAppLogContextService.class);
        if (r104 == null) goto L24;
        HashMap<String, String> r105 = new HashMap();
        r105.put("location", r102);
        n.e(r105);
        OpenPlatformContext r106 = this.f473576a;
        if (r106 == null) goto L20;
        AudienceLaunchMgContextService r107 = (AudienceLaunchMgContextService) r106.getService(AudienceLaunchMgContextService.class);
        if (r107 == null) goto L20;
        if (r107.f85299d != true) goto L20;
        r105.put("is_mg_dail_page", "1");
    L21:
        Unit r108 = Unit.INSTANCE;
        r104.h(BdpAppEventConstant.EVENT_MP_CLICK, r105);
        return;
    L20:
        r105.put("is_mg_dail_page", "0");
        goto L21
    L24:
        return;
    L23:
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = "";
        goto L9
    L7:
        r102 = kr0.a.a("mg_card");
        goto L9
    }

    @Override // wo0.a
    public final void openMountedMiniGame(MountedMiniGameSource r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r101 == null) goto L6;
        HashMap r102 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r101)});
        if (r102 == null) goto L6;
    L7:
        OpenPlatformContext r103 = this.f473576a;
        if (r103 == null) goto L13;
        AudienceLaunchMgContextService r104 = (AudienceLaunchMgContextService) r103.getService(AudienceLaunchMgContextService.class);
        if (r104 == null) goto L14;
        AudienceLaunchMgContextService.j(r104, r100, r102);
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r102 = null;
        goto L7
    }
}
