package zjc;

import android.content.Context;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.wifidirect.IWiFiP2PListener;
import com.byted.cast.wifidirect.WiFiP2PHelper;
import com.ss.cast.source.m;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WiFiP2PHelper f572556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f572557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContextManager.CastContext f572558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CastLogger f572559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IWiFiP2PListener f572560e;

    /* JADX INFO: renamed from: zjc.a$a, reason: collision with other inner class name */
    public class C8471a implements IWiFiP2PListener {
        public C8471a() {
        }
    }

    public final boolean b() {
        if (this.f572557b == true) goto L6;
        return false;
    L6:
        this.f572556a.discoverPeers();
        this.f572559d.i("WifiP2PManager", "start wifi-p2p browse");
        return true;
    }

    public final boolean c() {
        if (this.f572557b == true) goto L6;
        return false;
    L6:
        this.f572556a.stopDiscover();
        this.f572559d.i("WifiP2PManager", "stop wifi-p2p browse");
        return true;
    }

    public a(ContextManager.CastContext r100) {
        this.f572557b = false;
        this.f572560e = new C8471a();
        this.f572558c = r100;
        this.f572559d = ContextManager.getLogger(r100);
        this.f572556a = WiFiP2PHelper.getInstance();
    }

    public final void a(Context r100, m r101) {
        if (this.f572556a != null) goto L5;
    L9:
        this.f572557b = false;
        if (r101 == null) goto L18;
        List<Object> r102 = r101.f456598d;
        if (r102 == null) goto L19;
        ((CopyOnWriteArrayList) r102).clear();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (ContextManager.getConfigManager(this.f572558c).getInitConfig().isEnableWifiP2PSearch() == false) goto L9;
        this.f572556a.init(r100, this.f572560e);
        this.f572559d.d("WifiP2PManager", "wifi-p2p isWifiDirectSupported:" + this.f572556a.isWifiDirectSupported() + ",isWifiDirectEnabled:" + this.f572556a.isWifiDirectEnabled());
        if (this.f572556a.isWifiDirectSupported() == false) goto L16;
        this.f572557b = true;
        this.f572559d.d("WifiP2PManager", "allow wifi-p2p browse");
        return;
    }
}
