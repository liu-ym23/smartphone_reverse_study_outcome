package kn9;

import com.larus.office.base.plugins.toolbar.submenu.AbsSubToolbarFragment;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements hn9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsSubToolbarFragment f504303a;

    public f(AbsSubToolbarFragment r100) {
        this.f504303a = r100;
    }

    @Override // hn9.e
    public final void a(int r100) {
        AbsSubToolbarFragment r101 = this.f504303a;     // Catch: Exception -> L8
        String r102 = String.valueOf(r100);     // Catch: Exception -> L8
        r101.getClass();     // Catch: Exception -> L8
        FLogger.f375446a.i("BaseSubToolbarV2Fragment", "processOnItemClick ");     // Catch: Exception -> L5
        r101.V90().processSubToolbarItemClick("fontSize", r102, 3);     // Catch: Exception -> L5
    L15:
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("BaseSubToolbarV2Fragment", e.getMessage());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("SDKSubToolbarFragment", e.getMessage());
    }
}
