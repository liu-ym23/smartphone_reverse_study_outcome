package jm7;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import ok7.i;
import org.json.JSONObject;
import rk7.f;
import rk7.u;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatTaskTimer", owner = "jianghaiyang.ocean")
public final class a extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499670a;

    public a() {
        this.f499670a = "luckycatTaskTimer";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f499670a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r110, i r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyXBridge", "LuckyCatTaskTimerMethod on call");
        JSONObject r100 = new JSONObject();
        String r101 = s.f(r110, "task_id", "");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r100.put("error_code", -1);
        r100.put("error_msg", "taskId is empty");
        r111.a(0, r100, "failed");
        return;
    L6:
        String r102 = s.f(r110, "action", "");
        switch(r102.hashCode()) {
            case -1761413287: goto L22;
            case -1522868952: goto L16;
            case -1005786936: goto L13;
            case 1347896753: goto L10;
            default: goto L47;
        };
    L47:
        r100.put("error_code", -1);
        r100.put("error_msg", "action is invalid");
        r111.a(0, r100, "failed");
        return;
    L10:
        if (r102.equals("finish_task") == false) goto L47;
        ek7.b.i(r101);
        ek7.b.h(r101);
    L45:
        r100.put("error_code", 1);
        r100.put("error_msg", "success");
        i.b(r111, 1, null, "success", 2);
        return;
    L13:
        if (r102.equals("stop_timer") == false) goto L47;
        ek7.b.i(r101);
        goto L45
    L16:
        if (r102.equals("start_timer") == false) goto L47;
        int r112 = r110.getInt("timer_interval");
        if (r112 <= 0) goto L20;
        ek7.b.g(r101, r112);
        goto L45
    L20:
        ek7.b.f(r101);
        goto L45
    L22:
        if (r102.equals("create_pendant") == false) goto L47;
        Context r113 = (Context) provideContext(Context.class);
        if ((r113 instanceof Activity) == false) goto L26;
        Activity r114 = (Activity) r113;
    L27:
        if (r114 == null) goto L37;
        Window r115 = r114.getWindow();
        if (r115 == null) goto L37;
        View r116 = r115.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L35;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L35;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L35:
        if (r116 == null) goto L37;
        FrameLayout r117 = (FrameLayout) r116.findViewById(R.id.content);
    L38:
        AtomicBoolean r104 = u.f538372v;
        u.c.f538395a.getClass();
        int r105 = bl7.c.f19499a;
        if (r101 == null) goto L45;
        if (r117 == null) goto L45;
        bl7.b r106 = f.d();
        if (r106 == null) goto L45;
        r106.showTimerTaskPendant(r101, r117, null, -1);
    L37:
        r117 = null;
        goto L38
    L26:
        r114 = to7.c.b();
        goto L27
    }
}
