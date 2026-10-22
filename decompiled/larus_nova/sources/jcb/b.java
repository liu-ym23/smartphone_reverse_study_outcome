package jcb;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class b implements IDomainConfigService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IDomainConfigService f498172b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGlobalDomainConfigService f498173a;

    public static IDomainConfigService c() {
        if (f498172b != null) goto L6;
        Log.i("DomainConfigService", "get DomainConfigService instance from hilt");
        f498172b = (IDomainConfigService) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(IDomainConfigService.class);
    L6:
        return f498172b;
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String f0() {
        Log.i("DomainConfigService", "getSdkConfigDirPath called");
        return this.f498173a.f0();
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void preload() {
        Log.i("DomainConfigService", "preload called");
        this.f498173a.preload();
    }

    @Inject
    public b() {
        this.f498173a = (IGlobalDomainConfigService) ((DwarfSPIEntryPoint) EntryPoints.get(gcb.a.a().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(IGlobalDomainConfigService.class);
        Log.i("DomainConfigService", "DomainConfigService constructor called");
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void M0(icb.a r100) {
        Log.i("DomainConfigService", "removeDomainSettingChangedObserver called.");
        Objects.requireNonNull(r100);
        a r101 = new a(r100);
        String r102 = gcb.a.a().getUserId();
        IGlobalDomainConfigService r103 = this.f498173a;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r103.Yb(r102, r101);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String a(String r100) {
        Log.d("DomainConfigService", "getDomain called, alias: " + r100);
        return this.f498173a.e0(gcb.a.a().getUserId(), r100);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final List<String> b(String r100) {
        Log.d("DomainConfigService", "getDomains called, alias: ".concat(r100));
        return this.f498173a.A(gcb.a.a().getUserId(), r100);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void h0(Map<String, List<String>> r100) {
        Log.i("DomainConfigService", "onForegroundUserDomainChanged called");
        this.f498173a.h0(r100);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final Map<String, List<String>> o0(String r100) {
        return this.f498173a.o0(r100);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String L0(String r100, String r101) {
        Log.d("DomainConfigService", "getDomain called, alias: ".concat(r101));
        return this.f498173a.e0(r100, r101);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void N0(String r100, icb.a r101) {
        Log.i("DomainConfigService", "addDomainSettingChangedObserver with uid: " + r100 + " called.");
        Objects.requireNonNull(r101);
        this.f498173a.sd(r100, new a(r101));
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final List<String> p0(String r100, int r101, String r102, String r103) {
        Log.d("DomainConfigService", "getDomainsFromFullEnvUnitBrandCache called, alias: " + r100 + ", envType:" + r101 + ", unit:" + r102 + ", brand:" + r103);
        List<String> r104 = this.f498173a.p0(r100, r101, r102, r103);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return Collections.emptyList();
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void K0(String r100, InitSDKRequest.EnvType r110, String r111, String r112, DomainSettings r113) {
        Log.i("DomainConfigService", "updateDomainSetting with uid start");
        this.f498173a.K0(r100, r110, r111, r112, r113);
    }
}
