package rv3;

import com.bytedance.ai.api.navi.AppletNaviServiceDelegate;
import com.bytedance.applet.aibridge.navi.AbsStartThirdNaviOrPlanMethodIDL;
import com.bytedance.applet.aibridge.navi.StartThirdNaviOrPlanMethod;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ AbsStartThirdNaviOrPlanMethodIDL.a b;
    public final /* synthetic */ f3.h c;
    public final /* synthetic */ String d;
    public final /* synthetic */ StartThirdNaviOrPlanMethod e;
    public final /* synthetic */ String f;

    public /* synthetic */ f0(String r1, AbsStartThirdNaviOrPlanMethodIDL.a r2, f3.h r3, String r4, StartThirdNaviOrPlanMethod r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r1 = this.a;
        AbsStartThirdNaviOrPlanMethodIDL.a r2 = this.b;
        f3.h r3 = this.c;
        String r4 = this.d;
        StartThirdNaviOrPlanMethod r5 = this.e;
        String r6 = this.f;
        int r7 = StartThirdNaviOrPlanMethod.b;
        FLogger.a.i("StartThirdNaviOrPlanMethod", "startThirdNaviOrPlan");
        AppletNaviServiceDelegate r10 = AppletNaviServiceDelegate.b;
        if (r1 != null) goto L5;
        r1 = r2.getAppName();
    L5:
        String r11 = r1;
        String r12 = r2.getType();
        String r15 = r2.getOrigin();
        String r18 = r2.getDestination();
        float r13 = r2.getOlat();
        float r14 = r2.getOlon();
        float r16 = r2.getDlat();
        float r17 = r2.getDlon();
        String r19 = r2.getRideType();
        Boolean r8 = r2.getStartNaviDirectly();
        if (r8 == null) goto L8;
        boolean r20 = r8.booleanValue();
    L9:
        r10.a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, new com.bytedance.applet.aibridge.navi.b(r3, r4, r5, r6));
        return;
    L8:
        r20 = true;
        goto L9
    }
}
