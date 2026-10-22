package rv3;

import com.bytedance.ai.api.navi.AppletNaviServiceDelegate;
import com.bytedance.applet.aibridge.navi.AbsStartThirdNaviOrPlanMethodIDL;
import com.bytedance.applet.aibridge.navi.StartThirdNaviOrPlanMethod;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f539391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsStartThirdNaviOrPlanMethodIDL.a f539392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f3.h f539393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f539394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StartThirdNaviOrPlanMethod f539395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f539396f;

    public /* synthetic */ f0(String r100, AbsStartThirdNaviOrPlanMethodIDL.a r101, f3.h r102, String r103, StartThirdNaviOrPlanMethod r104, String r105) {
        this.f539391a = r100;
        this.f539392b = r101;
        this.f539393c = r102;
        this.f539394d = r103;
        this.f539395e = r104;
        this.f539396f = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f539391a;
        AbsStartThirdNaviOrPlanMethodIDL.a r101 = this.f539392b;
        f3.h r102 = this.f539393c;
        String r103 = this.f539394d;
        StartThirdNaviOrPlanMethod r104 = this.f539395e;
        String r105 = this.f539396f;
        int r106 = StartThirdNaviOrPlanMethod.f191246b;
        FLogger.f375446a.i("StartThirdNaviOrPlanMethod", "startThirdNaviOrPlan");
        AppletNaviServiceDelegate r110 = AppletNaviServiceDelegate.f34049b;
        if (r100 != null) goto L5;
        r100 = r101.getAppName();
    L5:
        String r111 = r100;
        String r112 = r101.getType();
        String r113 = r101.getOrigin();
        String r114 = r101.getDestination();
        float r115 = r101.getOlat();
        float r116 = r101.getOlon();
        float r117 = r101.getDlat();
        float r118 = r101.getDlon();
        String r119 = r101.getRideType();
        Boolean r107 = r101.getStartNaviDirectly();
        if (r107 == null) goto L8;
        boolean r210 = r107.booleanValue();
    L9:
        r110.a(r111, r112, r115, r116, r113, r117, r118, r114, r119, r210, new com.bytedance.applet.aibridge.navi.b(r102, r103, r104, r105));
        return;
    L8:
        r210 = true;
        goto L9
    }
}
