package com.bytedance.awemeopen.domain.follow;

import android.content.Context;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class FollowDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Integer>> f198400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f198401b;

    public FollowDomain() {
        this.f198400a = new LinkedHashMap();
        this.f198401b = new ArrayList();
    }

    public final int b(String r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        Intrinsics.checkNotNullParameter(r102, "config");
        String r103 = r102.a().invoke();
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return 0;
    L8:
        Map r105 = (Map) ((LinkedHashMap) this.f198400a).get(r103);
        if (r105 == null) goto L16;
        Integer r106 = (Integer) r105.get(r100);
        if (r106 != null) goto L14;
        return r101;
    L14:
        return r106.intValue();
    L16:
        return r101;
    L5:
        r104 = false;
        goto L6
    }

    public final void a(Context r100, String r101, int r110, final a r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(r111, "config");
        String r102 = r111.a().invoke();
        boolean r103 = false;
        if (r102.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L29;
        Map r105 = (Map) ((LinkedHashMap) this.f198400a).get(r102);
        if (r105 == null) goto L29;
        Integer r106 = (Integer) r105.get(r101);
        if (r106 == null) goto L13;
        r110 = r106.intValue();
    L13:
        if (r110 != 1) goto L15;
    L19:
        boolean r107 = true;
    L20:
        if (r110 != 4) goto L22;
        r103 = true;
    L22:
        if (r107 == true) goto L24;
        if (r103 == false) goto L29;
    L24:
        Function1<? super String, Unit> r108 = r111.f198407f;
        if (r108 == null) goto L40;
        r108.invoke("");
        return;
    L40:
        return;
    L15:
        if (r110 == 2) goto L19;
        if (r110 == 4) goto L19;
        r107 = false;
    L29:
        if (NetworkUtils.b(r100) == true) goto L34;
        Function1<? super String, Unit> r109 = r111.f198405d;
        if (r109 == null) goto L41;
        r109.invoke(r100.getString(R.string.network_unavailable));
        return;
    L41:
        return;
    L34:
        final FollowContinueByOpenId r112 = new FollowContinueByOpenId(r100, r101, 1, true, r111, new FollowDomain$followByOpenId$successThen$1(r111, this));
        Function1<? super Function1<? super String, Unit>, Unit> r113 = r111.f198404c;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r113 = null;
    L38:
        r113.invoke(new FollowDomain$followByOpenId$1(r111, r112));
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void c(Context r100, String r101, int r110, final a r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(r111, "config");
        String r102 = r111.a().invoke();
        boolean r103 = false;
        if (r102.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L20;
        Map r105 = (Map) ((LinkedHashMap) this.f198400a).get(r102);
        if (r105 == null) goto L20;
        Integer r106 = (Integer) r105.get(r101);
        if (r106 == null) goto L12;
        r110 = r106.intValue();
    L12:
        if (r110 != 0) goto L14;
        r103 = true;
    L14:
        if (r103 == false) goto L20;
        Function1<? super String, Unit> r107 = r111.f198407f;
        if (r107 == null) goto L31;
        r107.invoke("");
        return;
    L31:
        return;
    L20:
        if (NetworkUtils.b(r100) == true) goto L25;
        Function1<? super String, Unit> r108 = r111.f198405d;
        if (r108 == null) goto L32;
        r108.invoke(r100.getString(R.string.network_unavailable));
        return;
    L32:
        return;
    L25:
        final FollowContinueByOpenId r112 = new FollowContinueByOpenId(r100, r101, 0, false, r111, new FollowDomain$unFollowByOpenId$successThen$1(r111, this));
        Function1<? super Function1<? super String, Unit>, Unit> r109 = r111.f198404c;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r109 = null;
    L29:
        r109.invoke(new FollowDomain$unFollowByOpenId$1(r111, r112));
        return;
    L5:
        r104 = false;
        goto L6
    }
}
