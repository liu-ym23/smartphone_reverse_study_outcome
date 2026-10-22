package idb;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements IFeatureGatingService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile f f489453c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jdb.e f489454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, jdb.c> f489455b;

    public static f a() {
        if (f489453c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f489453c != null) goto L9;
        f489453c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f489453c;
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void clear() {
        this.f489454a.U1();
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> getSettingsFGKeys() {
        return this.f489454a.getSettingsFGKeys();
    }

    public f() {
        this.f489455b = new ConcurrentHashMap();
        this.f489454a = (jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(FeatureGatingModule.getDependency().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void reload() {
        FeatureGatingModule.getDependency().N8();
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> allFg(String r100) {
        return this.f489454a.allFg(r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isCrossUserEnable(String r100) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        throw new UnsupportedOperationException("isCrossUserEnable is not supported");
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final boolean isCurrentEnable(String r100) {
        Log.d("FeatureGatingService", "from FeatureGatingService.");
        return this.f489454a.x(FeatureGatingModule.getDependency().getUserId(), r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final boolean isEnable(String r100) {
        Log.d("FeatureGatingService", "from FeatureGatingService.");
        return this.f489454a.B0(FeatureGatingModule.getDependency().getUserId(), r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isNoUserFGEnable(String r100) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        return this.f489454a.isNoUserFGEnable(r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isUserFGEnable(String r100) {
        Log.i("FeatureGatingService", "from FeatureGatingService.");
        return this.f489454a.tb(FeatureGatingModule.getDependency().getUserId(), r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Map<String, String> getChangedKeysBySyncUpdate(String r100, Map<String, String> r101) {
        return this.f489454a.getChangedKeysBySyncUpdate(r100, r101);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Set<String> getRuntimeFGSPCache(String r100, String r101) {
        return this.f489454a.getRuntimeFGSPCache(r100, r101);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final Map<String, Boolean> getUsedFGMap(String r100, String r101) {
        return this.f489454a.getUsedFGMap(r100, r101);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isCurrentEnable(String r100, boolean r101) {
        return isCurrentEnable(r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final boolean isEnable(String r100, boolean r101) {
        return isEnable(r100);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void notifySettingsFGChanged(Map<String, Boolean> r100, String r101) {
        this.f489454a.notifySettingsFGChanged(r100, r101);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void notifySettingsFGNoUserChanged(Map<String, Boolean> r100, String r101) {
        this.f489454a.notifySettingsFGNoUserChanged(r100, r101);
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService
    public final void removeFeatureGatingUpdateListener(jdb.c r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<String, jdb.c> r102 = this.f489455b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        jdb.c r104 = (jdb.c) r103.get(r100.toString());
        if (r104 == null) goto L8;
        String r105 = FeatureGatingModule.getDependency().getUserId();
        this.f489454a.Kb(r105, r104, r101);
        return;
    }

    @Override // com.ss.android.lark.featuregating.interfaces.IFeatureGatingService, jdb.g
    public final void addFeatureGatingUpdateListener(String r100, final jdb.c r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        jdb.c r103 = new e(r101);
        Map<String, jdb.c> r104 = this.f489455b;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r101.toString(), r103);
        String r106 = FeatureGatingModule.getDependency().getUserId();
        this.f489454a.T(r106, r100, r103, r102);
    }
}
