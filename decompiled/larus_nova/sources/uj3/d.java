package uj3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.entity.Module;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sj3.n;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f550264k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUrlModel f550265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECUrlModel f550266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f550267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f550268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f550269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECUrlModel f550270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public sj3.d f550271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f550272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f550273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f550274j;

    public static final class a {
        public a() {
        }

        public static d a(Module r100) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
            sj3.e r101 = (sj3.e) GsonProtectorUtils.fromJson(new Gson(), r100.getData(), sj3.e.class);
            if (r101 == null) goto L5;
            Intrinsics.checkNotNullParameter(r101, "dto");
            d r102 = new d();
            r102.f550265a = r101.b();
            r102.f550266b = r101.a();
            r102.f550267c = r101.i();
            r102.f550268d = r101.g();
            r102.f550269e = r101.h();
            r102.f550270f = r101.e();
            r102.f550271g = r101.c();
            r102.f550272h = r101.f();
            r102.f550274j = r101.d();
            r100.getName();
            r102.f550273i = r100.getModuleExtra();
            return r102;
        L5:
            ECExceptionMonitor.c("transFromShopMemberModule error moduleData:{" + r100.getData() + '}');
            return new d();
        }
    }

    public d() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 20;
    }

    static {
        f550264k = new a();
    }
}
