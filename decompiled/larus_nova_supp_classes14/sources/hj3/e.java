package hj3;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.PageLoadStatus;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public Long a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public final JSONObject g;

    public e(JSONObject r1) {
        this.g = r1;
    }

    public final void b(long r4, di.d r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = ECMonitorService.b;
        JSONObject r1 = new JSONObject();
        r1.put("cursor", r4);
        Iterator r5 = r6.c.a().entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r7 = (Map.Entry) r5.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Result.constructor-impl(r1.put((String) r7.getKey(), r7.getValue()));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    L12:
        Unit r8 = Unit.INSTANCE;
        JSONObject r9 = new JSONObject();
        Iterator r10 = r6.a.a().entrySet().iterator();
    L14:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r11 = (Map.Entry) r10.next();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L18
        Result.constructor-impl(r9.put((String) r11.getKey(), r11.getValue()));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L20:
        Iterator r14 = r6.b.a().entrySet().iterator();
    L22:
        if (r14.hasNext() == false) goto L28;
        Map.Entry r15 = (Map.Entry) r14.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(r9.put((String) r15.getKey(), r15.getValue()));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L28:
        Unit r18 = Unit.INSTANCE;
        ECMonitorService.a.a("ec_perf_duration_shop_net", r1, r9, this.g);
    }

    public final void a(boolean r6, PageLoadStatus r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "loadStatus");
        int r0 = ECMonitorService.b;
        JSONObject r1 = new JSONObject();
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r6 == false) goto L5;
        Object r9 = CommentScene.COMMENTSCENE_NO_AWEME;
    L6:
        r1.put("is_first_screen", r9);
        r1.put("load_status", r7.getValue());
        r1.put("error_code", r8);
        if (this.e != null) goto L9;
        r2 = "0";
    L9:
        r1.put("flag_render_cache", r2);
        JSONObject r10 = new JSONObject();
        r10.put("t_tab_init_start", this.a);
        r10.put(TabkitFirstFramePref.T_PAGE_INIT_START, this.b);
        r10.put(TabkitFirstFramePref.T_REQUEST_START, this.c);
        r10.put(TabkitFirstFramePref.T_REQUEST_END, this.d);
        r10.put("t_page_show", this.f);
        Long r11 = this.e;
        if (r11 != null) goto L12;
        r11 = this.f;
    L12:
        r10.put("t_page_cache_show", r11);
        if (ECAppInfoService.e.i() == false) goto L34;
        Long r12 = this.f;
        Long r13 = null;
        if (r12 == null) goto L17;
        Long r14 = Long.valueOf(r12.longValue() - k.h(this.a));
    L18:
        r10.put("total_duration", r14);
        Long r15 = this.f;
        if (r15 == null) goto L21;
        Long r16 = Long.valueOf(r15.longValue() - k.h(this.b));
    L22:
        r10.put("total_tab_duration", r16);
        Long r17 = this.d;
        if (r17 == null) goto L25;
        Long r18 = Long.valueOf(r17.longValue() - k.h(this.c));
    L26:
        r10.put("api_duration", r18);
        Long r19 = this.f;
        if (r19 == null) goto L29;
        Long r20 = Long.valueOf(r19.longValue() - k.h(this.d));
    L30:
        r10.put("render_duration", r20);
        Long r21 = this.e;
        if (r21 == null) goto L33;
        r13 = Long.valueOf(r21.longValue() - k.h(this.b));
    L33:
        r10.put("cache_total_tab_duration", r13);
        goto L34
    L29:
        r20 = null;
        goto L30
    L25:
        r18 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L17:
        r14 = null;
    L34:
        ECMonitorService.a.a("ec_perf_shop_follow", r1, r10, this.g);
        return;
    L5:
        r9 = "0";
        goto L6
    }
}
