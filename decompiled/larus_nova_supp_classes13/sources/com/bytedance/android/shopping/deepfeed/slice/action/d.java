package com.bytedance.android.shopping.deepfeed.slice.action;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final a a(String r1, w r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "container");
        switch(r1.hashCode()) {
            case -2115133839: goto L48;
            case -2074317298: goto L45;
            case -1968913237: goto L42;
            case -1850654380: goto L39;
            case -1794491833: goto L36;
            case -1681077417: goto L33;
            case -1534621073: goto L30;
            case -1396813790: goto L27;
            case -1343365017: goto L24;
            case -1203445292: goto L21;
            case -758654878: goto L18;
            case -221732173: goto L15;
            case 122108473: goto L12;
            case 1077645248: goto L9;
            case 1689782194: goto L6;
            default: goto L50;
        };
    L50:
        return null;
    L6:
        if (r1.equals("NotifyPosition") == false) goto L50;
        return new o(r2);
    L9:
        if (r1.equals("UpdateModel") == false) goto L50;
        return new s(r2);
    L12:
        if (r1.equals("AutoScrollTop") == false) goto L50;
        return new k(r2);
    L15:
        if (r1.equals("RegisterGestureArea") == false) goto L50;
        return new f(r2);
    L18:
        if (r1.equals("OpenPopup") == false) goto L50;
        return new m(r2);
    L21:
        if (r1.equals("RemoveCard") == false) goto L50;
        return new p(r2);
    L24:
        if (r1.equals("EventChain") == false) goto L50;
        return new e(r2);
    L27:
        if (r1.equals("PageFinish") == false) goto L50;
        return new n(r2);
    L30:
        if (r1.equals("Request") == false) goto L50;
        return new DeepFeedRequestAction(r2);
    L33:
        if (r1.equals("AdReport") == false) goto L50;
        return new i(r2);
    L36:
        if (r1.equals("AiRecRequest") == false) goto L50;
        return new j(r2);
    L39:
        if (r1.equals("Report") == false) goto L50;
        return new q(r2);
    L42:
        if (r1.equals("OpenSchema") == false) goto L50;
        return new DeepFeedSlcOpenAction(r2);
    L45:
        if (r1.equals("IntervalUpdate") == false) goto L50;
        return new DeepFeedSlcIntervalUpdateAction(r2);
    L48:
        if (r1.equals("VideoAction") == false) goto L50;
        return new r(r2);
    }
}
