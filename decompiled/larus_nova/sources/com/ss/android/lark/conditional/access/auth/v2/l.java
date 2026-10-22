package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f417831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f417832b;

    public l() {
        this.f417831a = new Object();
        this.f417832b = new HashMap();
    }

    public final void a(PolicyModel r110) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (idb.f.a().isEnable("lark.security.android_disable_policy_req_opt") == false) goto L5;
        return;
    L5:
        Object r100 = this.f417831a;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (this.f417832b.size() <= 20) goto L17;
        Iterator<Map.Entry<String, Long>> r101 = this.f417832b.entrySet().iterator();     // Catch: Throwable -> L20
        String r102 = null;
        long r103 = Long.MAX_VALUE;
    L11:
        if (r101.hasNext() == false) goto L15;
        Map.Entry<String, Long> r104 = r101.next();     // Catch: Throwable -> L20
        String r105 = r104.getKey();     // Catch: Throwable -> L20
        long r106 = r104.getValue().longValue();     // Catch: Throwable -> L20
        if (r106 >= r103) goto L11;
        r102 = r105;
        r103 = r106;
        goto L11
    L15:
        if (r102 == null) goto L17;
        this.f417832b.remove(r102);     // Catch: Throwable -> L20
    L17:
        this.f417832b.put(r110.getTaskId(), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L20
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r100);
    }
}
