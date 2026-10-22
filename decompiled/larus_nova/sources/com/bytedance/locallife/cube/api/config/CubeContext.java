package com.bytedance.locallife.cube.api.config;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.CubeTimingVersion;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.bytedance.locallife.cube.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\tR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/CubeContext;", "", "Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "schemaModel", "Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "c", "()Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "e", "(Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CubeContext {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f257161u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BulletContext f257162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<IPoiLynxKitDelegate> f257163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CubeTimingVersion f257164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f257165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f257166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<DelegateStatus> f257167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f257168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f257169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f257170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f257171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f257172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f257173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f257174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f257175n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f257176o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f257177p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d1 f257178q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f257179r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LoadType f257180s;
    private CubeInternalSchemaModel schemaModel;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CubeConfig f257181t;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f257182a = null;

        static {
            int[] r100 = new int[DelegateStatus.values().length];
            r100[DelegateStatus.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DelegateStatus.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DelegateStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DelegateStatus.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DelegateStatus.DESTROYED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f257182a = r100;
        }
    }

    static {
    }

    public final DelegateStatus a() {
        return this.f257167f.get();
    }

    public final CubeInternalSchemaModel c() {
        return this.schemaModel;
    }

    public CubeContext(BulletContext r100) {
        this.f257162a = r100;
        this.f257164c = CubeTimingVersion.V2;
        this.f257167f = new AtomicReference(DelegateStatus.INIT);
        this.f257175n = new AtomicBoolean(false);
        this.f257177p = r100.getSessionId();
        this.f257180s = LoadType.OLD_PRELOAD;
    }

    public final String b(boolean r100) {
        if (r100 == false) goto L9;
        d1 r101 = this.f257178q;
        if (r101 == null) goto L8;
        String r102 = Long.valueOf(r101.f247863f).toString();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return this.f257179r;
    L9:
        d1 r103 = this.f257178q;
        if (r103 == null) goto L13;
        String r104 = Long.valueOf(r103.f247863f).toString();
        if (r104 == null) goto L13;
    L17:
        if (r104 == null) goto L32;
        StringBuilder r105 = new StringBuilder();
        r105.append(r104);
        String r106 = "";
        if (this.f257169h == false) goto L21;
        String r107 = "_pc";
    L22:
        r105.append(r107);
        if (this.f257170i == false) goto L25;
        String r108 = "_pl";
    L26:
        r105.append(r108);
        if (this.f257166e == false) goto L29;
        r106 = "_cc";
    L29:
        r105.append(r106);
        return r105.toString();
    L25:
        r108 = "";
        goto L26
    L21:
        r107 = "";
        goto L22
    L32:
        return null;
    L13:
        String r109 = this.f257179r;
        if (r109 == null) goto L16;
        r104 = "pd_".concat(r109);
        goto L17
    L16:
        r104 = null;
        goto L17
    }

    public final void d(DelegateStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "newStatus");
        fp6.j r101 = d.f257194a;
        d.d("moveToStatus current status = " + a() + ", new status = " + r100);
        int r102 = b.f257182a[r100.ordinal()];
        if (r102 != 1) goto L5;
        AtomicReference<DelegateStatus> r103 = this.f257167f;
        DelegateStatus r104 = DelegateStatus.INIT;
    L37:
        if (r103.compareAndSet(r104, r100) == true) goto L61;
        if (r103.get() == r104) goto L37;
        return;
    L61:
        return;
    L5:
        if (r102 != 2) goto L7;
        AtomicReference<DelegateStatus> r105 = this.f257167f;
        DelegateStatus r106 = DelegateStatus.INIT;
    L30:
        if (r105.compareAndSet(r106, r100) == true) goto L60;
        if (r105.get() == r106) goto L30;
        return;
    L60:
        return;
    L7:
        if (r102 != 3) goto L9;
        AtomicReference<DelegateStatus> r107 = this.f257167f;
        DelegateStatus r108 = DelegateStatus.LOADING;
    L23:
        if (r107.compareAndSet(r108, r100) == true) goto L57;
        if (r107.get() == r108) goto L23;
        return;
    L57:
        return;
    L9:
        if (r102 != 4) goto L11;
        AtomicReference<DelegateStatus> r109 = this.f257167f;
        DelegateStatus r110 = DelegateStatus.LOADING;
    L16:
        if (r109.compareAndSet(r110, r100) == true) goto L55;
        if (r109.get() == r110) goto L16;
        return;
    L55:
        return;
    L11:
        if (r102 != 5) goto L54;
        this.f257167f.set(r100);
        return;
    }

    public final void e(CubeInternalSchemaModel r100) {
        this.schemaModel = r100;
    }
}
