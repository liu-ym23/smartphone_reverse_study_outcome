package com.bytedance.awemeopen.domain.young.digg;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.digg.DiggWorkingMode;
import com.bytedance.awemeopen.domain.digg.c;
import com.bytedance.awemeopen.domain.digg.f;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class YoungDiggDomain {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f198543f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiggWorkingMode f198544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f198545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.awemeopen.domain.digg.b f198546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f198547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f198548e;

    public static final class a {
    }

    public static final class b implements q34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ YoungDiggDomain f198549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.awemeopen.domain.digg.a f198550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f198551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f198552d;

        @Override // q34.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            YoungDiggDomain r101 = this.f198549a;
            com.bytedance.awemeopen.domain.digg.a r102 = this.f198550b;
            String r103 = this.f198551c;
            boolean r104 = this.f198552d;
            r101.getClass();
            AoPool.a(new YoungDiggDomain$diggOrUndiggServer$1(r103, r100, r104, r101, r102, null));
        }

        public b(YoungDiggDomain r100, com.bytedance.awemeopen.domain.digg.a r101, String r102, boolean r103) {
            this.f198549a = r100;
            this.f198550b = r101;
            this.f198551c = r102;
            this.f198552d = r103;
        }
    }

    static {
    }

    public YoungDiggDomain() {
        this.f198544a = DiggWorkingMode.SERVER_MODE;
        this.f198545b = new ConcurrentHashMap();
        this.f198546c = new com.bytedance.awemeopen.domain.digg.b("young_digg_local_tbl");
        this.f198547d = new LinkedHashSet();
        this.f198548e = new ArrayList();
    }

    public static final void a(YoungDiggDomain r100, String r101) {
        Iterator r102 = ((ArrayList) r100.f198548e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).a(r101);
        goto L4
    }

    public final boolean c(final Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        final String r102 = r101.f198298a;
        if (this.f198544a != DiggWorkingMode.SERVER_MODE) goto L9;
        Boolean r103 = this.f198545b.get(r102);
        if (r103 != null) goto L8;
        return r101.f198299b;
    L8:
        return r103.booleanValue();
    L9:
        Boolean r104 = this.f198545b.get(r102);
        if (r104 != null) goto L16;
        if (this.f198547d.contains(r102) == false) goto L14;
        return false;
    L14:
        this.f198547d.add(r102);
        this.f198545b.put(r102, Boolean.valueOf(r101.f198299b));
        AoPool.b(new YoungDiggDomain$isDigged$1$1(this, r100, r102));
        return false;
    L16:
        return r104.booleanValue();
    }

    public final void b(c r100, final com.bytedance.awemeopen.domain.digg.a r101, final boolean r110) throws Exception {
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
        if (this.f198544a == DiggWorkingMode.SERVER_MODE) goto L21;
        AoPool.b(new YoungDiggDomain$diggOrUndiggLocal$1(this, r101, r103, r110));
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
        final b r106 = new b(this, r101, r103, r110);
        Function1<? super Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit>, Unit> r107 = r101.f198287c;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r107 = null;
    L30:
        r107.invoke(new YoungDiggDomain$diggOrUndigg$1(r101, this, r103, r110, r106));
        return;
    L11:
        if (r100.f198301d != 2) goto L19;
        if (r100.f198302e == 2) goto L19;
        Function1<? super String, Unit> r108 = r101.f198289e;
        if (r108 == null) goto L34;
        r108.invoke(r102.getString(R.string.friend_visible_opus_hint));
        return;
    }
}
