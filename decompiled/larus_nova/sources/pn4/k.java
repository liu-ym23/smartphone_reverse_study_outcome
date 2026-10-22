package pn4;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes15.dex */
public interface k {
    void a();

    void b(Activity r100, String r101, cmb.b r102);

    void c(vb5.a r100);

    void d(qn4.b r100, com.ss.android.lark.integrator.ccm.config.viewbinder.g r101);

    boolean getLeaderShareSetting(IGetDataCallback<Boolean> r100);

    boolean hasLeader();

    void updateLeaderShareSetting(boolean r100, IGetDataCallback<Boolean> r101);
}
