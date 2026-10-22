package h96;

import android.app.Application;
import com.bytedance.interaction.game.base.monitor.InteractiveMonitorReport;
import com.bytedance.interaction.game.ext.goldenFinger.predefine.builtin.BuiltInMetaManager;
import com.bytedance.interaction.game.ext.goldenFinger.predefine.meta.MetaManager;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractiveMonitorReport f484324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MetaManager f484325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BuiltInMetaManager f484326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f484327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f484329f;

    public b(Application r100, String r101, boolean r102) {
        this.f484327d = r100;
        this.f484328e = r101;
        this.f484329f = r102;
        this.f484324a = new InteractiveMonitorReport(r101);
        this.f484325b = new MetaManager(this.f484327d, this.f484328e, this.f484329f);
        this.f484326c = new BuiltInMetaManager(this.f484327d, this.f484328e, this.f484329f);
    }
}
