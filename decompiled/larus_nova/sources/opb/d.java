package opb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import idb.f;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements yva.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f524814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f524815b;

    public d(e r100) {
        this.f524815b = r100;
        this.f524814a = null;
    }

    @Override // yva.a
    public final void onError(ErrorResult r100) {
        Log.w("AppSettingService", "pullAppSettings onError:" + r100);
        IGetDataCallback r101 = this.f524814a;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    @Override // yva.a
    public final void a(Map<String, String> r100, boolean r110) {
        Iterator<AbstractBaseSettingHandler> r101 = this.f524815b.f524816a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().i(r100, r110, true, false, "");
        goto L4
    L6:
        e r102 = this.f524815b;
        b r103 = r102.f524819d;
        Map<String, jpb.a> r104 = r102.b();
        ((LarkSettingModuleDependency.a) this.f524815b.f524820e).getClass();
        r103.a(r100, r104, true, r110, f.a().isEnable("common_settings_opt_close"));
        IGetDataCallback r105 = this.f524814a;
        if (r105 == null) goto L11;
        r105.onSuccess(Boolean.valueOf(r110));
        return;
    }
}
