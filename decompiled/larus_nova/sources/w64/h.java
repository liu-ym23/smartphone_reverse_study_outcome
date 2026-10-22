package w64;

import android.content.Context;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.manager.PseudoCodeManager;
import com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements NetworkStatusMonitor.OnSimCardChangeListener, NetworkStatusMonitor.OnNetworkChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f558424a;

    public h(Context r100) {
        this.f558424a = r100;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor.OnNetworkChangeListener
    public final void onNetworkTypeChange(String r100) {
        r100.getClass();
        if (r100.equals(Constants.NetworkOperator.NETWORK_TYPE_MOBILE) == false) goto L5;
    L7:
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "network change, start execute...");
        PseudoCodeManager.getInstance().executeMobilePseudoCode(new e(this));     // Catch: Exception -> L10
        return;
    L14:
        return;
    L5:
        if (r100.equals(Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE) == true) goto L7;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor.OnSimCardChangeListener
    public final void onSimCardChange() {
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "sim card change, start execute...");
        PseudoCodeManager.getInstance().executeMobilePseudoCode(new g(this));     // Catch: Exception -> L5
        return;
    }
}
