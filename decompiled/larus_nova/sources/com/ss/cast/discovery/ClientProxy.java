package com.ss.cast.discovery;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.api.IBrowseListener;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.api.IConnectListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.IPlayerListener;
import com.byted.cast.common.api.IWriteCacheListener;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.source.IClient;
import com.byted.cast.common.source.SearchType;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.ss.cast.discovery.nsd.NsdClient;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ClientProxy implements IClient {
    private final com.ss.cast.discovery.nsd.a bdLinkServiceDetector;
    private final com.ss.cast.discovery.nsd.c diskCacheHelper;
    private IClient mBleClient;
    private ContextManager.CastContext mCastContext;
    private final IClient mNsdClient;
    private final IClient mSsdpClient;

    public class a implements wjc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClientProxy f456262a;

        public a(ClientProxy r100) {
            this.f456262a = r100;
        }
    }

    public class b implements wjc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClientProxy f456263a;

        public b(ClientProxy r100) {
            this.f456263a = r100;
        }
    }

    public class c implements wjc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClientProxy f456264a;

        public c(ClientProxy r100) {
            this.f456264a = r100;
        }
    }

    public class d implements IWriteCacheListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClientProxy f456265a;

        public d(ClientProxy r100) {
            this.f456265a = r100;
        }

        @Override // com.byted.cast.common.api.IWriteCacheListener
        public final void writeCache(ServiceInfo r100) {
            com.ss.cast.discovery.nsd.c r101 = ClientProxy.access$000(this.f456265a);
            r101.f456361c.i("BDLinkServiceDiskCacheHelper", "writeCache");
            r101.f456364f.post(new com.ss.cast.discovery.nsd.d(r101, r100));
        }
    }

    private void initCacheAndServiceDetector() {
        if (this.bdLinkServiceDetector.f456353g == true) goto L11;
        if (DLNAOptionUtils.isEnableDeviceOffline(this.mCastContext) == false) goto L11;
        com.ss.cast.discovery.nsd.a r100 = this.bdLinkServiceDetector;
        r100.f456351e = new a(this);
        r100.f456352f = new b(this);
        r100.f456350d.i("BDLinkServiceDetector", "startDetect");
        if (r100.f456353g == false) goto L9;
        r100.f456350d.w("BDLinkServiceDetector", "has started");
        goto L11
    L9:
        r100.f456353g = true;
        long r101 = DLNAOptionUtils.getBdlinkDeviceOfflineDetectInterval(r100.f456349c);
        r100.f456348b.removeMessages(1);
        r100.f456348b.sendEmptyMessageDelayed(1, r101);
    L11:
        if (this.diskCacheHelper.f456368j == false) goto L13;
        return;
    L13:
        if (DLNAOptionUtils.isEnableBdlinkDiskCache(this.mCastContext) == false) goto L20;
        com.ss.cast.discovery.nsd.c r102 = this.diskCacheHelper;
        r102.f456365g = new c(this);
        setWriteCacheListener(new d(this));
        com.ss.cast.discovery.nsd.c r103 = this.diskCacheHelper;
        if (r103.f456368j == false) goto L17;
        r103.f456361c.w("BDLinkServiceDiskCacheHelper", "hasReadCache");
        return;
    L17:
        r103.f456361c.i("BDLinkServiceDiskCacheHelper", "readCache");
        r103.f456368j = true;
        r103.f456364f.removeMessages(1);
        r103.f456364f.sendEmptyMessage(1);
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void destroy() {
        IClient r100 = this.mNsdClient;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        IClient r101 = this.mBleClient;
        if (r101 == null) goto L8;
        r101.destroy();
    L8:
        this.mSsdpClient.destroy();
        if (this.bdLinkServiceDetector.f456353g == false) goto L15;
        com.ss.cast.discovery.nsd.a r102 = this.bdLinkServiceDetector;
        r102.f456350d.i("BDLinkServiceDetector", "stopDetect");
        if (r102.f456353g == true) goto L13;
        r102.f456350d.w("BDLinkServiceDetector", "has stopped");
        return;
    L13:
        r102.f456353g = false;
        r102.f456348b.removeCallbacksAndMessages(null);
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void stopBrowse() {
        IClient r100 = this.mNsdClient;
        if (r100 == null) goto L5;
        r100.stopBrowse();
    L5:
        IClient r101 = this.mBleClient;
        if (r101 == null) goto L8;
        r101.stopBrowse();
    L8:
        this.mSsdpClient.stopBrowse();
    }

    @Override // com.byted.cast.common.source.IClient
    public void startBrowse() {
        initCacheAndServiceDetector();
        com.ss.cast.discovery.nsd.c r100 = this.diskCacheHelper;
        r100.f456361c.i("BDLinkServiceDiskCacheHelper", "startCheck");
        if (r100.f456367i == true) goto L5;
        r100.f456361c.i("BDLinkServiceDiskCacheHelper", "ignore this detect, due to BDLink is been disabled.");
    L9:
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L12;
        r101.startBrowse();
    L12:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L15;
        r102.startBrowse();
    L15:
        this.mSsdpClient.startBrowse();
        return;
    L5:
        long r103 = System.currentTimeMillis() - r100.f456369k;
        if (r103 >= com.ss.cast.discovery.nsd.c.f456358n) goto L8;
        r100.f456361c.i("BDLinkServiceDiskCacheHelper", "ignore this detect, because detect interval is " + r103 + ", less than " + com.ss.cast.discovery.nsd.c.f456358n);
        goto L9
    L8:
        r100.f456369k = System.currentTimeMillis();
        r100.f456364f.removeMessages(2);
        Message r104 = Message.obtain();
        r104.what = 2;
        Bundle r105 = new Bundle();
        r105.putLong("msg.key.start_check_time", r100.f456369k);
        r104.setData(r105);
        r100.f456364f.sendMessage(r104);
        goto L9
    }

    public static /* synthetic */ com.ss.cast.discovery.nsd.c access$000(ClientProxy r100) {
        return r100.diskCacheHelper;
    }

    @Override // com.byted.cast.common.source.IClient
    public List<ServiceInfo> getDeviceList(SearchType r100) {
        if (SearchType.MDNS.equals(r100) == false) goto L7;
        return this.mNsdClient.getDeviceList(r100);
    L7:
        if (SearchType.SSDP.equals(r100) == false) goto L11;
        return this.mSsdpClient.getDeviceList(r100);
    L11:
        if (this.mBleClient != null) goto L13;
        return null;
    L13:
        if (SearchType.BLE.equals(r100) == true) goto L15;
        return null;
    L15:
        return this.mBleClient.getDeviceList(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void init(Context r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.init(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.init(r100);
    L8:
        this.mSsdpClient.init(r100);
        com.ss.cast.discovery.nsd.c r103 = this.diskCacheHelper;
        r103.f456359a = r100;
        Config r104 = ContextManager.getConfigManager(r103.f456360b).getInitConfig();
        com.ss.cast.discovery.nsd.c.f456358n = r104.getBDLinkDiskCacheDetectIntervalMills();
        String r105 = r104.getPrivateChannel();
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r103.f456366h = r105;
    L12:
        String r106 = r104.getLocalProtocols();
        if (TextUtils.isEmpty(r106) == false) goto L15;
    L17:
        boolean r107 = false;
    L18:
        r103.f456367i = r107;
        return;
    L15:
        if (r106.contains("BDLink") == false) goto L17;
        r107 = true;
        goto L18
    }

    @Override // com.byted.cast.common.source.IClient
    public void onAppendBDLinkInfoSuccess(ServiceInfo r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.onAppendBDLinkInfoSuccess(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L9;
        r102.onAppendBDLinkInfoSuccess(r100);
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void onDeviceOffline(ServiceInfo r100) {
        this.mNsdClient.onDeviceOffline(r100);
        IClient r101 = this.mBleClient;
        if (r101 == null) goto L5;
        r101.onDeviceOffline(r100);
    L5:
        this.mSsdpClient.onDeviceOffline(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void onDiskCacheFoundService(ServiceInfo r100) {
        this.mNsdClient.onDiskCacheFoundService(r100);
        IClient r101 = this.mBleClient;
        if (r101 == null) goto L5;
        r101.onDiskCacheFoundService(r100);
    L5:
        this.mSsdpClient.onDiskCacheFoundService(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setBrowseResultListener(IBrowseListener r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setBrowseResultListener(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.setBrowseResultListener(r100);
    L8:
        this.mSsdpClient.setBrowseResultListener(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setBrowseTime(int r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setBrowseTime(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.setBrowseTime(r100);
    L8:
        this.mSsdpClient.setBrowseTime(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setConnectListener(IConnectListener r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setConnectListener(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.setConnectListener(r100);
    L8:
        this.mSsdpClient.setConnectListener(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setLibraryLoader(ILibraryLoader r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setLibraryLoader(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L9;
        r102.setLibraryLoader(r100);
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void setLogger(ILogger r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setLogger(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.setLogger(r100);
    L8:
        this.mSsdpClient.setLogger(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setPlayerListener(IPlayerListener r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setPlayerListener(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L9;
        r102.setPlayerListener(r100);
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void setPrivateChannel(String r100) {
        IClient r101 = this.mNsdClient;
        if (r101 == null) goto L5;
        r101.setPrivateChannel(r100);
    L5:
        IClient r102 = this.mBleClient;
        if (r102 == null) goto L8;
        r102.setPrivateChannel(r100);
    L8:
        this.mSsdpClient.setPrivateChannel(r100);
        com.ss.cast.discovery.nsd.c r103 = this.diskCacheHelper;
        r103.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L13;
        r103.f456366h = r100;
        return;
    }

    @Override // com.byted.cast.common.source.IClient
    public void setWriteCacheListener(IWriteCacheListener r100) {
        this.mNsdClient.setWriteCacheListener(r100);
        IClient r101 = this.mBleClient;
        if (r101 == null) goto L5;
        r101.setWriteCacheListener(r100);
    L5:
        this.mSsdpClient.setWriteCacheListener(r100);
    }

    @Override // com.byted.cast.common.source.IClient
    public void setOption(int r100, Object... r101) {
        IClient r102 = this.mNsdClient;
        if (r102 == null) goto L5;
        r102.setOption(r100, r101);
    L5:
        IClient r103 = this.mBleClient;
        if (r103 == null) goto L8;
        r103.setOption(r100, r101);
    L8:
        this.mSsdpClient.setOption(r100, r101);
    }

    public ClientProxy(ContextManager.CastContext r100, ICastSource r101, ICastSource r102) {
        this.mCastContext = r100;
        this.diskCacheHelper = new com.ss.cast.discovery.nsd.c(r100, r101);
        this.bdLinkServiceDetector = new com.ss.cast.discovery.nsd.a(r100, r101);
        this.mNsdClient = new NsdClient(r100, r101, r102);
        this.mSsdpClient = new xjc.a(r100, r101, r102);
    }
}
