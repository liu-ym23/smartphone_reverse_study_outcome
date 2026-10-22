package hj7;

import android.app.Activity;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    public class a implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f485449b;

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            if (r100 == null) goto L13;
            int r101 = r100.f271394a;
            if (r101 != (-7)) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == false) goto L13;
            this.f485448a.callback(hj7.a.a(1, g.a(this.f485449b, r100), "success"));
            return;
        L7:
            if (r101 == (-6)) goto L9;
            r102 = true;
        L13:
            this.f485448a.callback(hj7.a.a(0, g.a(this.f485449b, r100), "failed"));
        }

        public a(g r100, IBridgeContext r101) {
            this.f485449b = r100;
            this.f485448a = r101;
        }
    }

    public class b implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f485451b;

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            if (r100 == null) goto L13;
            int r101 = r100.f271394a;
            if (r101 != (-7)) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == false) goto L13;
            this.f485450a.callback(hj7.a.a(1, g.a(this.f485451b, r100), "success"));
            return;
        L7:
            if (r101 == (-6)) goto L9;
            r102 = true;
        L13:
            this.f485450a.callback(hj7.a.a(0, g.a(this.f485451b, r100), "failed"));
        }

        public b(g r100, IBridgeContext r101) {
            this.f485451b = r100;
            this.f485450a = r101;
        }
    }

    public class c implements com.bytedance.ug.sdk.luckycat.impl.manager.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f485452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f485453b;

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.a.g
        public final void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100) {
            if (r100 == null) goto L13;
            int r101 = r100.f271394a;
            if (r101 != (-7)) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == false) goto L13;
            this.f485452a.callback(hj7.a.a(1, g.a(this.f485453b, r100), "success"));
            return;
        L7:
            if (r101 == (-6)) goto L9;
            r102 = true;
        L13:
            this.f485452a.callback(hj7.a.a(0, g.a(this.f485453b, r100), "failed"));
        }

        public c(g r100, IBridgeContext r101) {
            this.f485453b = r100;
            this.f485452a = r101;
        }
    }

    public g() {
    }

    public static JSONObject a(g r100, com.bytedance.ug.sdk.luckycat.impl.model.b r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L7;
    L5:
        return r102;
    L7:
        r102.put("client_error_code", r101.f271394a);     // Catch: Throwable -> L6
        r102.put("client_error_msg", r101.f271395b);     // Catch: Throwable -> L6
        goto L5
    }

    @BridgeMethod("luckycatAddCalendarEvent")
    public void addCalendarEvent(@BridgeContext IBridgeContext r110, @BridgeParam("data") JSONObject r111) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatAddCalendarEvent");
        Activity r100 = r110.getActivity();
        com.bytedance.ug.sdk.luckycat.impl.model.a r101 = new com.bytedance.ug.sdk.luckycat.impl.model.a();
        if (r111 == null) goto L6;
        r101.f271385a = r111.optString("remind_title", "");
        r101.f271386b = r111.optInt("remind_time", 0);
        r101.f271387c = r111.optInt("remind_time_minute", 0);
        r101.f271389e = r111.optInt("duration_minutes", 0);
        r101.f271388d = r111.optInt("remind_count", 0);
        r101.f271390f = r111.optLong("remind_start_time", 0) * 1000;
        r101.f271392h = r111.optBoolean("is_title_repeated", false);
        r101.f271393i = r111.optString("description", "");
        r101.f271391g = r111.optBoolean("is_request_permission", true);
    L6:
        if (r100 == null) goto L8;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r112 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "using sdk ability");
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.h(r100, r101, new a(this, r110));
        return;
    L8:
        r110.callback(hj7.a.a(0, null, "failed"));
    }

    @BridgeMethod("luckycatCheckCalendarEvent")
    public void checkCalendarEvent(@BridgeContext IBridgeContext r100, @BridgeParam("remind_title") String r101) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatCheckCalendarEvent");
        Activity r102 = r100.getActivity();
        if (r102 == null) goto L5;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r103 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "using sdk ability");
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.i(r102, r101, new b(this, r100));
        return;
    L5:
        r100.callback(hj7.a.a(0, null, "failed"));
    }

    @BridgeMethod("luckycatDeleteCalendarEvent")
    public void deleteCalendarEvent(@BridgeContext IBridgeContext r100, @BridgeParam("remind_title") String r101, @BridgeParam(defaultBoolean = true, value = "is_full_match") boolean r102) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatDeleteCalendarEvent");
        Activity r103 = r100.getActivity();
        if (r103 == null) goto L5;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r104 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "using sdk ability");
        com.bytedance.ug.sdk.luckycat.impl.manager.a.h.f271301a.j(r103, r101, new c(this, r100), r102);
        return;
    L5:
        r100.callback(hj7.a.a(0, null, "failed"));
    }
}
