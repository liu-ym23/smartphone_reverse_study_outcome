package qx6;

import com.bytedance.locallife.biz.experiment.GoodsDetailLynxImageExperiment;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535144a = 0;

    static {
    }

    public static void a(String r100, IPoiLynxKitDelegate r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        com.bytedance.locallife.biz.experiment.j.f256668d.getClass();
        Boolean r102 = com.bytedance.locallife.biz.experiment.j.d(r100);
        boolean r103 = false;
        if (r102 == null) goto L5;
    L12:
        CubeConfig r104 = r101.getCubeContext().f257181t;
        LynxLoadConfig r105 = null;
        if (r104 == null) goto L15;
        LynxLoadConfig r106 = r104.getLynxLoadConfig();
    L16:
        if (r106 == null) goto L19;
        r106.setEnablePreFetchImage(r102.booleanValue());
    L19:
        CubeConfig r107 = r101.getCubeContext().f257181t;
        if (r107 == null) goto L22;
        r105 = r107.getLynxLoadConfig();
    L22:
        if (r105 != null) goto L25;
        return;
    L25:
        if (GoodsDetailLynxImageExperiment.a() != 2) goto L27;
    L28:
        r103 = true;
    L29:
        r105.setEnableAsyncRequestImage(r103);
        return;
    L27:
        if (GoodsDetailLynxImageExperiment.a() != 3) goto L29;
    L15:
        r106 = null;
        goto L16
    L5:
        if (GoodsDetailLynxImageExperiment.a() != 1) goto L7;
    L10:
        boolean r108 = true;
    L11:
        r102 = Boolean.valueOf(r108);
        goto L12
    L7:
        if (GoodsDetailLynxImageExperiment.a() == 3) goto L10;
        r108 = false;
        goto L11
    }
}
