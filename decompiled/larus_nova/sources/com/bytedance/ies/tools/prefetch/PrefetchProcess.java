package com.bytedance.ies.tools.prefetch;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class PrefetchProcess implements i.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f248734i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Set<x> f248735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient HitState f248736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Throwable f248737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i.b f248738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f248739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PrefetchRequest f248740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f248741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f248742h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;", "", "FALLBACK", "PENDING", "CACHED", "prefetch_release"}, k = 1, mv = {1, 4, 0})
    public static final enum HitState extends Enum<HitState> {
        public static final HitState CACHED = null;
        public static final HitState FALLBACK = null;
        public static final HitState PENDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HitState[] f248743a = null;

        static {
            HitState r100 = new HitState("FALLBACK", 0);
            FALLBACK = r100;
            HitState r101 = new HitState("PENDING", 1);
            PENDING = r101;
            HitState r102 = new HitState("CACHED", 2);
            CACHED = r102;
            f248743a = new HitState[]{r100, r101, r102};
        }

        public static HitState valueOf(String r100) {
            return (HitState) r27.a.a(HitState.class, r100);
        }

        public static HitState[] values() {
            return (HitState[]) f248743a.clone();
        }

        public HitState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static PrefetchProcess a(JSONObject r100) {
            PrefetchProcess r101 = new PrefetchProcess(JSONObjectProtectorUtils.getString(r100, "page_url"), new PrefetchRequest(JSONObjectProtectorUtils.getJSONObject(r100, "request")), JSONObjectProtectorUtils.getLong(r100, "timestamp"), JSONObjectProtectorUtils.getLong(r100, "expires"));
            JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r100, "response");
            new i.b();
            i.b r103 = new i.b();
            JSONObject r104 = r102.optJSONObject("headers");
            SortedMap<String, String> r105 = null;
            if (r104 == null) goto L5;
            SortedMap<String, String> r106 = g0.e(r104);
        L6:
            r103.f248822c = r106;
            r103.f248821b = r102.optString(ContainerPosition.BODY);
            r103.f248823d = r102.optInt("status_code");
            JSONObject r107 = r102.optJSONObject("extra");
            if (r107 == null) goto L9;
            r105 = g0.e(r107);
        L9:
            r103.f248824e = r105;
            r101.f248738d = r103;
            return r101;
        L5:
            r106 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.ies.tools.prefetch.i.a
    public final void a(Throwable r100) {
        this.f248737c = r100;
        Iterator<T> r101 = this.f248735a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((x) r101.next()).onFailed(r100);
        goto L4
    }

    @Override // com.bytedance.ies.tools.prefetch.i.a
    public final void b(i.b r100) {
        this.f248738d = r100;
        Iterator<T> r101 = this.f248735a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((x) r101.next()).a(r100);
        goto L4
    }

    public PrefetchProcess(String r100, PrefetchRequest r101, long r102, long r103) {
        this.f248739e = r100;
        this.f248740f = r101;
        this.f248741g = r102;
        this.f248742h = r103;
        this.f248735a = Collections.synchronizedSet(new HashSet());
        this.f248736b = HitState.FALLBACK;
        System.currentTimeMillis();
    }
}
