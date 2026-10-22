package ic9;

import com.larus.platform.api.f2;
import com.larus.platform.service.z2;
import com.larus.settings.value.a5;
import com.larus.settings.value.e10;
import com.larus.settings.value.g8;
import com.larus.settings.value.h00;
import com.larus.settings.value.js;
import com.larus.settings.value.l00;
import com.larus.settings.value.lh;
import com.larus.settings.value.ob;
import com.larus.settings.value.ql;
import com.larus.settings.value.ub;
import com.larus.settings.value.ul;
import com.larus.utils.l0;
import com.obric.assistant.common.spi.security.ObricSecurityServiceDelegate;
import java.util.List;
import kotlin.collections.CollectionsKt;
import zv9.i;
import zv9.j;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements f2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f489264b = null;

    static {
        f489264b = new h();
    }

    public h() {
    }

    @Override // com.larus.platform.api.f2
    public final String a() {
        e10 r100 = e10.f368561a;
        String r101 = e10.e().b();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.larus.platform.api.f2
    public final String audioMediaSceneConfig() {
        e10 r100 = e10.f368561a;
        return (String) l0.a("", new a5());
    }

    @Override // com.larus.platform.api.f2
    public final String b() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        bv9.c r102 = ((bv9.a) l0.a(new bv9.a(0), new l00())).a();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a();
    }

    @Override // com.larus.platform.api.f2
    public final boolean c() {
        e10 r100 = e10.f368561a;
        return e10.S().getEnableOpenSchemaOptimizeAndroid();
    }

    @Override // com.larus.platform.api.f2
    public final boolean canGetDouyinLunaInstallBackground() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new g8())).booleanValue();
    }

    @Override // com.larus.platform.api.f2
    public final long d() {
        e10 r100 = e10.f368561a;
        return e10.B().b();
    }

    @Override // com.larus.platform.api.f2
    public final String e() {
        e10 r100 = e10.f368561a;
        String r101 = e10.e().a();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.larus.platform.api.f2
    public final boolean enableActRefreshProtect() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new ul())).booleanValue();
    }

    @Override // com.larus.platform.api.f2
    public final boolean enableIndependentImageCache() {
        e10 r100 = e10.f368561a;
        return e10.n();
    }

    @Override // com.larus.platform.api.f2
    public final boolean enableReconnectFrontierForDoraWhenBackground() {
        e10 r100 = e10.f368561a;
        return false;
    }

    @Override // com.larus.platform.api.f2
    public final String f() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        bv9.c r102 = ((bv9.a) l0.a(new bv9.a(0), new l00())).a();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b();
    }

    @Override // com.larus.platform.api.f2
    public final boolean g() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new js())).booleanValue();
    }

    @Override // com.larus.platform.api.f2
    public final int getMediaRequestManagerConfig() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Number) l0.a(0, new ob())).intValue();
    }

    @Override // com.larus.platform.api.f2
    public final boolean h() {
        z2.f365865a.w3();
        return false;
    }

    @Override // com.larus.platform.api.f2
    public final List<String> i() {
        e10 r100 = e10.f368561a;
        return e10.y().b();
    }

    @Override // com.larus.platform.api.f2
    public final Boolean j() {
        e10 r100 = e10.f368561a;
        return e10.b0().e();
    }

    @Override // com.larus.platform.api.f2
    public final String k() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        new ut9.a();
        return ((hq9.b) l0.a(new hq9.b(0), new ub())).b();
    }

    @Override // com.larus.platform.api.f2
    public final Boolean l() {
        e10 r100 = e10.f368561a;
        return e10.b0().f();
    }

    @Override // com.larus.platform.api.f2
    public final boolean m() {
        e10 r100 = e10.f368561a;
        return e10.S().getEnablePluginLoadInLoading();
    }

    @Override // com.larus.platform.api.f2
    public final boolean n() {
        e10 r100 = e10.f368561a;
        return e10.u().k();
    }

    @Override // com.larus.platform.api.f2
    public final boolean o() {
        e10 r100 = e10.f368561a;
        return e10.i0().a();
    }

    @Override // com.larus.platform.api.f2
    public final List<String> p() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        new i();
        List<String> r102 = ((j) l0.a(i.a(), new lh())).a();
        if (r102 == null) goto L5;
        List r103 = CollectionsKt.filterNotNull(r102);
    L6:
        if (r103 != null) goto L9;
        r103 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.distinct(CollectionsKt.plus(r103, ObricSecurityServiceDelegate.f387847b.b()));
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.platform.api.f2
    public final boolean q() {
        e10 r100 = e10.f368561a;
        return e10.S().getEnableOpenH5AndAuth();
    }

    @Override // com.larus.platform.api.f2
    public final boolean r() {
        e10 r100 = e10.f368561a;
        return e10.S().getEnableAuthWithCoupon();
    }

    @Override // com.larus.platform.api.f2
    public final long s() {
        e10 r100 = e10.f368561a;
        return e10.B().c();
    }

    @Override // com.larus.platform.api.f2
    public final String t() {
        e10 r100 = e10.f368561a;
        return e10.a().b();
    }

    @Override // com.larus.platform.api.f2
    public final boolean u() {
        e10 r100 = e10.f368561a;
        return e10.R().b();
    }

    @Override // com.larus.platform.api.f2
    public final boolean useNewAsrTasks() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new h00())).booleanValue();
    }

    @Override // com.larus.platform.api.f2
    public final boolean useNewAsrTasksV2() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new ql())).booleanValue();
    }
}
