package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 {
    public static d0 a(NetService r1) {
        return new d0(new GetChildPuller(r1));
    }

    public static c0 b(NetService r1) {
        return new c0(new GetRootPermPuller(r1));
    }

    public static s c(NetService r1) {
        return new s(new GetSpaceInfoPuller(r1));
    }

    public static Flowable<Boolean> f(q r10) {
        NetService r1 = r10.f;
        p r0 = new p(r1);
        String r2 = r10.a;
        String r3 = r10.b;
        String r4 = r10.c;
        int r5 = r10.d.intValue();
        if (r10.e == false) goto L6;
        return r0.a(r3, r2);
    L6:
        if (r5 == 2) goto L33;
        if (r5 != 3) goto L10;
        NetService.f r11 = new NetService.f("/api/sheet/update_meta/");
        ((NetService.e) r11).c = 1;
        HashMap r6 = new HashMap();
        r6.put(ResourceData.KEY_TOKEN, r4);
        r6.put("title", r2);
        r6.put(ResourceData.KEY_TYPE, String.valueOf(sbb.e.h.b));
        r11.d(r6);
        return r1.Vc(new ax4.f()).a(r11).map(new m());
    L10:
        if (r5 != 8) goto L12;
        NetService.f r12 = new NetService.f("/api/bitable/update_meta/");
        ((NetService.e) r12).c = 1;
        HashMap r7 = new HashMap();
        r7.put(ResourceData.KEY_TOKEN, r4);
        r7.put("title", r2);
        r7.put(ResourceData.KEY_TYPE, String.valueOf(sbb.e.i.b));
        r12.d(r7);
        return r1.Vc(new ax4.f()).a(r12).map(new o());
    L12:
        if (r5 == 22) goto L33;
        if (r5 != 30) goto L16;
    L29:
        NetService.f r13 = new NetService.f("/api/meta/update/");
        ((NetService.e) r13).c = 1;
        HashMap r8 = new HashMap();
        r8.put(ResourceData.KEY_TOKEN, r4);
        r8.put("title", r2);
        r8.put(ResourceData.KEY_TYPE, String.valueOf(r5));
        r13.d(r8);
        return r1.Vc(new ax4.f()).a(r13).map(new n());
    L16:
        if (r5 == 11) goto L29;
        if (r5 != 12) goto L37;
        NetService.f r9 = new NetService.f("/api/box/file/update_info/");
        ((NetService.e) r9).c = 1;
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L23
        r14.put("file_token", r4);     // Catch: Exception -> L23
        r14.put("name", r2);     // Catch: Exception -> L23
        String r15 = r14.toString();     // Catch: Exception -> L23
    L26:
        if (TextUtils.isEmpty(r15) == true) goto L38;
        ((NetService.e) r9).j = r15;
        return r0.a.Vc(new ax4.f()).a(r9).map(new k());
    L38:
        return Flowable.error(new Exception("new jsonParams err!"));
    L23:
        e = move-exception;
        tt5.a.e("RenamePuller", "new jsonParams err!", e, false);
        r15 = null;
        goto L26
    L37:
        return Flowable.error(new Exception("unSupport documentType: " + r5));
    L33:
        return r0.a(r3, r2);
    }

    public static Flowable<PinPuller$Result> d(PinPuller$Params r4, NetService r5) {
        NetService.d r6 = r5.Vc(new j());
        tt5.a.h("PinPuller", "pullInfo");
        NetService.f r0 = new NetService.f("/space/api/explorer/pin/add/");
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r4.token);
        r1.put(ResourceData.KEY_TYPE, String.valueOf(r4.type));
        r1.put("pin_to_first", String.valueOf(r4.pinToFirst));
        r0.d(r1);
        return r6.a(r0).map(new i());
    }

    public static Flowable<Boolean> e(final String r8, final long r9, final int r11, final NetService r12) {
        if ((System.currentTimeMillis() - r9) > 30000) goto L5;
        int r0 = (r11 * 500) + CCMLynxCardView.ViewType.BANNER;
        tt5.a.h("Wiki_Api", "pollDelSingleNodeStatus taskId: " + r8 + ", times: " + r11 + ", delay: " + r0);
        return Flowable.just(Boolean.TRUE).delay(r0, TimeUnit.MILLISECONDS).flatMap(new x(r12, r8)).flatMap(new y(r8, r9, r11, r12));
    L5:
        return Flowable.error(new NetService.ServerErrorException(-5, "pollDelSingleNodeStatus timeout. taskId: " + r8, "", ""));
    }
}
