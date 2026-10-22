package com.ttnetuploader.uploader.discovery;

import android.content.Context;
import android.net.nsd.NsdManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.cast.discovery.mdns.NsdType;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class ServiceDiscovery {
    private static final String TAG = "ServiceDiscovery";
    private final IDiscoveryCallback mCallback;
    private final Context mContext;
    private volatile NsdManager.DiscoveryListener mDiscoveryListener;
    private boolean mIsFindAll;
    private final Map<String, String> mKeyMap;
    private volatile NsdManager mNsdManager;

    public void startDiscovery() {
        if (this.mNsdManager != null) goto L14;
        Context r100 = this.mContext;
        if (r100 == null) goto L15;
        this.mNsdManager = (NsdManager) r100.getSystemService("servicediscovery");     // Catch: Exception -> L9
        this.mDiscoveryListener = new AnonymousClass1(this);     // Catch: Exception -> L9
        this.mNsdManager.discoverServices(NsdType.HTTP, 1, this.mDiscoveryListener);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.toString();
        return;
    L15:
        return;
    }

    public void stopDiscovery() {
        if (this.mNsdManager != null) goto L5;
        return;
    L5:
        if (this.mDiscoveryListener == null) goto L10;
        this.mNsdManager.stopServiceDiscovery(this.mDiscoveryListener);
        this.mDiscoveryListener = null;
        return;
    }

    public static /* synthetic */ IDiscoveryCallback access$100(ServiceDiscovery r100) {
        return r100.mCallback;
    }

    private boolean checkServerInfo(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith("t-t-l-b_") == false) goto L6;
        return true;
    }

    private ServerInfo getServerInfo(String r110) {
        String[] r111 = r110.split("_");
        if (r111.length > 4) goto L5;
        return null;
    L5:
        int r100 = CastIntegerProtector.parseInt(r111[1]);
        String r101 = r111[2];
        if (this.mIsFindAll == true) goto L12;
        if (this.mKeyMap.containsKey(r101) == true) goto L12;
        return null;
    L12:
        return new ServerInfo(r101, this.mKeyMap.get(r101), CommonTools.getWifiIpAddress(r100), CastIntegerProtector.parseInt(r111[3]), System.currentTimeMillis());
    }

    public static /* synthetic */ boolean access$000(ServiceDiscovery r100, String r101) {
        return r100.checkServerInfo(r101);
    }

    public static /* synthetic */ ServerInfo access$200(ServiceDiscovery r100, String r101) {
        return r100.getServerInfo(r101);
    }

    public ServiceDiscovery(Context r100, IDiscoveryCallback r101, boolean r102, List<String> r103) {
        this.mDiscoveryListener = null;
        this.mIsFindAll = false;
        this.mKeyMap = new HashMap();
        this.mCallback = r101;
        this.mContext = r100;
        this.mIsFindAll = r102;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isEmpty() == true) goto L19;
        Iterator<String> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        String r105 = r104.next();
        String r106 = CommonTools.getSNId(r105);
        if (r106 == null) goto L8;
        this.mKeyMap.put(r106, r105);
        goto L8
    L20:
        return;
    }
}
