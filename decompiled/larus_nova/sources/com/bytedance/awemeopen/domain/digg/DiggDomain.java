package com.bytedance.awemeopen.domain.digg;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.digg.DiggWorkingMode;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DiggDomain {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f198275f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiggWorkingMode f198276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.awemeopen.domain.digg.b f198277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ConcurrentHashMap<String, Boolean>> f198278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f198279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f198280e;

    public static final class a {
    }

    public static final class b implements q34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.awemeopen.domain.digg.a f198281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DiggDomain f198282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f198283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f198284d;

        @Override // q34.b
        public final void a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "token");
            String r100 = this.f198281a.a().invoke();
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            DiggDomain r102 = this.f198282b;
            com.bytedance.awemeopen.domain.digg.a r103 = this.f198281a;
            String r104 = this.f198283c;
            boolean r105 = this.f198284d;
            r102.getClass();
            AoPool.a(new DiggDomain$diggOrUndiggServer$1(r104, r110, r105, r102, r100, r103, null));
            return;
        L8:
            AoLogger.c("DiggDomain", new Object[]{"DiggOrUndigg failed, login success but openId is still null."});
            return;
        L5:
            r101 = false;
            goto L6
        }

        public b(com.bytedance.awemeopen.domain.digg.a r100, DiggDomain r101, String r102, boolean r103) {
            this.f198281a = r100;
            this.f198282b = r101;
            this.f198283c = r102;
            this.f198284d = r103;
        }
    }

    static {
    }

    public DiggDomain() {
        this.f198276a = DiggWorkingMode.SERVER_MODE;
        this.f198277b = new com.bytedance.awemeopen.domain.digg.b("digg_local_tbl");
        this.f198278c = new LinkedHashMap();
        this.f198279d = new LinkedHashSet();
        this.f198280e = new ArrayList();
    }

    public static final void a(DiggDomain r100, String r101) {
        Iterator r102 = ((ArrayList) r100.f198280e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).a(r101);
        goto L4
    }

    public final void c(c r100, final com.bytedance.awemeopen.domain.digg.a r101, final boolean r110) throws Exception {
        Context r102 = r101.getContext();
        final String r103 = r100.f198298a;
        if (TextUtils.equals(r100.f198300c, r101.a().invoke()) == false) goto L11;
        if (r100.f198301d != 1) goto L19;
        Function1<? super String, Unit> r104 = r101.f198288d;
        if (r104 == null) goto L33;
        r104.invoke(r102.getString(R.string.private_can_not_digg_hint));
        return;
    L33:
        return;
    L19:
        if (this.f198276a == DiggWorkingMode.SERVER_MODE) goto L21;
        AoPool.b(new DiggDomain$diggOrUndiggLocal$1(this, r101, r103, r110));
        return;
    L21:
        if (NetworkUtils.b(r102) == true) goto L26;
        Function1<? super String, Unit> r105 = r101.f198290f;
        if (r105 == null) goto L35;
        r105.invoke(r102.getString(R.string.network_unavailable));
        return;
    L35:
        return;
    L26:
        final b r106 = new b(r101, this, r103, r110);
        Function1<? super Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit>, Unit> r107 = r101.f198287c;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r107 = null;
    L30:
        r107.invoke(new DiggDomain$diggOrUndigg$1(r101, this, r103, r110, r106));
        return;
    L11:
        if (r100.f198301d != 2) goto L19;
        if (r100.f198302e == 2) goto L19;
        Function1<? super String, Unit> r108 = r101.f198289e;
        if (r108 == null) goto L34;
        r108.invoke(r102.getString(R.string.friend_visible_opus_hint));
        return;
    }

    public final boolean d(final Context r100, c r101, com.bytedance.awemeopen.domain.digg.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "config");
        if (this.f198276a != DiggWorkingMode.SERVER_MODE) goto L21;
        String r103 = r102.a().invoke();
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L34;
        LinkedHashMap r105 = (LinkedHashMap) this.f198278c;
        Object r106 = r105.get(r103);
        if (r106 != null) goto L16;
        r106 = new ConcurrentHashMap();
        r105.put(r103, r106);
    L16:
        Boolean r107 = (Boolean) ((ConcurrentHashMap) r106).get(r101.f198298a);
        if (r107 != null) goto L19;
        boolean r108 = r101.f198299b;
    L32:
        return r108;
    L19:
        r108 = r107.booleanValue();
        goto L32
    L34:
        return false;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L21:
        final String r109 = r101.f198298a;
        LinkedHashMap r110 = (LinkedHashMap) this.f198278c;
        final String r111 = "visitor";
        Object r112 = r110.get("visitor");
        if (r112 != null) goto L24;
        r112 = new ConcurrentHashMap();
        r110.put("visitor", r112);
    L24:
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;
        Boolean r114 = (Boolean) r113.get(r109);
        if (r114 != null) goto L31;
        if (this.f198279d.contains(r109) == true) goto L35;
        this.f198279d.add(r109);
        r113.put(r109, Boolean.valueOf(r101.f198299b));
        AoPool.b(new DiggDomain$getIsDiggedForLocalMode$1(this, r100, r109, r111));
        return false;
    L35:
        return false;
    L31:
        return r114.booleanValue();
    }

    public static final void b(DiggDomain r100, String r101, String r102, boolean r103) {
        LinkedHashMap r104 = (LinkedHashMap) r100.f198278c;
        Object r105 = r104.get(r101);
        if (r105 != null) goto L5;
        r105 = new ConcurrentHashMap();
        r104.put(r101, r105);
    L5:
        ((ConcurrentHashMap) r105).put(r102, Boolean.valueOf(r103));
    }
}
