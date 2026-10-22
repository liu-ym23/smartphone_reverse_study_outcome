package com.bytedance.applet.utils;

import com.bytedance.ai.api.OperateResult;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.b0;
import com.larus.login.api.g0;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.service.i0;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements b0 {
    public final /* synthetic */ Function2<OperateResult, String, Unit> a;
    public final /* synthetic */ Map<String, Object> b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DouYinBindStatus.values().length];
            r0[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DouYinBindStatus.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public r(Function2<? super OperateResult, ? super String, Unit> r1, Map<String, ? extends Object> r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.applet.utils.q] */
    public final void a(DouYinBindStatus r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "status");
        FLogger.a.i("FirstPartyAuthManager", "onDouYinBind, status:" + r8 + ", errorCode:" + r9 + ", errorMsg:" + r10);
        int r11 = a.a[r8.ordinal()];
        if (r11 == 1) goto L9;
        if (r11 == 2) goto L9;
        if (r11 == 3) goto L8;
        OperateResult r12 = OperateResult.REJECT;
    L10:
        JSONObject r3 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r4 = this.b.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, Object> r5 = r4.next();
        r3.put(r5.getKey(), r5.getValue());
        goto L12
    L14:
        int r13 = a.a[r8.ordinal()];
        if (r13 == 1) goto L18;
        if (r13 == 2) goto L18;
        r3.put("success", "0");
        r3.put("bind_fail_step", "douyin_verify");
    L19:
        com.larus.platform.service.o.a.reportEvent("bind_with_account", r3);
        if (r12 != OperateResult.SUCCESS) goto L27;
        WeakReference<g0> r14 = o.b;
        final Function2<OperateResult, String, Unit> r15 = this.a;
        ?? r16 = new q(r15);
        FLogger.a.i("FirstPartyAuthManager", "handleAuthSuccess, tryHeartBeatRequest with delay=0, immediate=true");
        ISdkDouyinAuth r17 = i0.a();
        if (r17 == null) goto L24;
        boolean r18 = ISdkDouyinAuth.a.a(r17, new p(r16), 4);
    L25:
        if (r18 == true) goto L30;
        r16.invoke(Boolean.FALSE);
        return;
    L30:
        return;
    L24:
        r18 = false;
        goto L25
    L27:
        this.a.invoke(r12, r10);
        return;
    L18:
        r3.put("success", CommentScene.COMMENTSCENE_NO_AWEME);
        goto L19
    L8:
        r12 = OperateResult.CANCEL;
    L9:
        r12 = OperateResult.SUCCESS;
        goto L10
    }
}
