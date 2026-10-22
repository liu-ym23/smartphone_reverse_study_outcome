package com.ss.cast.discovery.ssdp;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class CastControlPoint {
    private static final int MAX_QUICK_SEARCH_COUNT = 15;
    private static final int MAX_SEARCH_COUNT = 30;
    private static final String PROTOCOL_VERSION = "1";
    private static final int QUICK_SEARCH_INTERVAL_SECONDS = 1;
    private static final int SLOW_SEARCH_INTERVAL_SECONDS = 3;
    private static final String TAG = null;
    private final ReentrantReadWriteLock devLock;
    private ListenerList deviceChangeListenerList;
    private ContextManager.CastContext mCastContext;
    private final ConcurrentHashMap<String, CastDevice> mDeviceMap;
    private boolean mIsStart;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private String mProtocol;
    private String mSearchTarget;
    private String mSourceVersion;
    private CastSSDPNotifySocketList mSsdpNotifySocketList;
    private CastSSDPSearchResponseSocketList mSsdpSearchResponseSocketList;
    private int searchCount;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CastSSDPSearchResponseSocketList f456407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f456408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CastControlPoint f456409c;

        public final void a() {
            CastSSDPSearchResponseSocketList r100 = this.f456407a;
            if (r100 != null) goto L5;
        L14:
            Dispatcher.getInstance().shutdownScheduleService(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK);
            CastControlPoint.access$100(this.f456409c).d(CastControlPoint.access$000(), "no available socket, stop cyclic search");
            return;
        L5:
            if (r100.isEmpty() == true) goto L14;
            this.f456407a.post(this.f456408b, DLNAOptionUtils.isEnableSourceBDLinkSSDPBroadcast(CastControlPoint.access$200(this.f456409c)));
            CastControlPoint.access$308(this.f456409c);
            CastControlPoint.access$100(this.f456409c).d(CastControlPoint.access$000(), "searchCount is " + CastControlPoint.access$300(this.f456409c));
            if (CastControlPoint.access$300(this.f456409c) != 15) goto L11;
            Dispatcher.getInstance().shutdownScheduleService(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK);
            Dispatcher.getInstance().schedule(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK, this, 3, 3);
            CastControlPoint.access$100(this.f456409c).d(CastControlPoint.access$000(), "change to slow search");
            return;
        L11:
            if (CastControlPoint.access$300(this.f456409c) < 30) goto L17;
            Dispatcher.getInstance().shutdownScheduleService(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK);
            CastControlPoint.access$100(this.f456409c).d(CastControlPoint.access$000(), "reach max search count, stop cyclic search");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CastControlPoint r100, CastSSDPSearchResponseSocketList r101, g r102) {
            this.f456409c = r100;
            this.f456407a = r101;
            this.f456408b = r102;
        }
    }

    static {
        TAG = "CastControlPoint";
    }

    public void clearDeviceList() {
        this.mDeviceMap.clear();
    }

    public void search() {
        g r100 = new g(this.mCastContext);
        r100.setHeader(HTTP.PROTOCOL, getProtocol());
        r100.setHeader(HTTP.SEARCHTARGET, getSearchTarget());
        r100.setHeader(HTTP.SOURCEVERSION, getSourceVersion());
        r100.setHeader(HTTP.PROTOCOLVERSION, "1");
        CastSSDPSearchResponseSocketList r101 = getSSDPSearchResponseSocketList();
        if (DLNAOptionUtils.isEnableSsdpCycleSearch(this.mCastContext) == false) goto L5;
        this.searchCount = 0;
        Dispatcher.getInstance().shutdownScheduleService(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK);
        Dispatcher.getInstance().schedule(Dispatcher.SCHEDULE_BDLINK_BROWSE_TASK, new a(this, r101, r100), 1, 0);
        return;
    L5:
        r101.post(r100, DLNAOptionUtils.isEnableSourceBDLinkSSDPBroadcast(this.mCastContext));
    }

    public boolean start() {
        CastLogger r100 = this.mLogger;
        String r101 = TAG;
        r100.d(r101, " start begin");
        stop();
        CastSSDPNotifySocketList r102 = getSSDPNotifySocketList();
        if (r102.open(DLNAOptionUtils.isEnableSourceBDLinkSSDPBroadcast(this.mCastContext)) == true) goto L6;
        this.mLogger.w(r101, " ssdp notify socket open failed");
        this.mMonitor.getSourceMonitor().trackSsdpErrorEvent(CastMonitor.SSDP_START_BROWSE_FAILED, 1001, "ssdp notify socket open failed");
        return false;
    L6:
        r102.setControlPoint(this);
        r102.start();
        CastSSDPSearchResponseSocketList r103 = getSSDPSearchResponseSocketList();
        if (r103.open(0) == true) goto L10;
        this.mLogger.i(r101, " ssdp search response socket open failed");
        this.mMonitor.getSourceMonitor().trackSsdpErrorEvent(CastMonitor.SSDP_START_BROWSE_FAILED, 1002, "ssdp search response socket open failed");
        return false;
    L10:
        r103.setControlPoint(this);
        r103.start();
        search();
        this.mIsStart = true;
        this.mLogger.i(r101, " start end");
        return true;
    }

    public boolean stop() {
        CastLogger r100 = this.mLogger;
        String r101 = TAG;
        r100.i(r101, " stop begin");
        CastSSDPNotifySocketList r102 = getSSDPNotifySocketList();
        r102.stop();
        r102.close();
        r102.clear();
        CastSSDPSearchResponseSocketList r103 = getSSDPSearchResponseSocketList();
        r103.stop();
        r103.close();
        r103.clear();
        this.mIsStart = false;
        this.mLogger.i(r101, " stop end");
        return true;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    private CastSSDPNotifySocketList getSSDPNotifySocketList() {
        return this.mSsdpNotifySocketList;
    }

    private CastSSDPSearchResponseSocketList getSSDPSearchResponseSocketList() {
        return this.mSsdpSearchResponseSocketList;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public String getSearchTarget() {
        return this.mSearchTarget;
    }

    public String getSourceVersion() {
        return this.mSourceVersion;
    }

    public boolean isStart() {
        return this.mIsStart;
    }

    public CastControlPoint(ContextManager.CastContext r100) {
        this.mIsStart = false;
        this.deviceChangeListenerList = new ListenerList();
        this.devLock = new ReentrantReadWriteLock();
        this.mDeviceMap = new ConcurrentHashMap();
        this.searchCount = 0;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mSsdpNotifySocketList = new CastSSDPNotifySocketList(r100, null);
        this.mSsdpSearchResponseSocketList = new CastSSDPSearchResponseSocketList(r100, null);
    }

    public static /* synthetic */ CastLogger access$100(CastControlPoint r100) {
        return r100.mLogger;
    }

    public static /* synthetic */ ContextManager.CastContext access$200(CastControlPoint r100) {
        return r100.mCastContext;
    }

    public static /* synthetic */ int access$300(CastControlPoint r100) {
        return r100.searchCount;
    }

    public static /* synthetic */ int access$308(CastControlPoint r100) {
        int r101 = r100.searchCount;
        r100.searchCount = r101 + 1;
        return r101;
    }

    private void addDevice(CastSSDPPacket r100) {
        CastLogger r101 = this.mLogger;
        String r102 = TAG;
        r101.d(r102, " addDevice ssdpPacket is " + r100);
        if (r100 != null) goto L6;
        this.mLogger.d(r102, " addDevice ssdpPacket is null");
        return;
    L6:
        String r103 = r100.getProtocol();
        if (TextUtils.isEmpty(r103) == false) goto L9;
    L20:
        this.mLogger.d(r102, " addDevice protocol error");
        return;
    L9:
        if (r103.equals(getProtocol()) == false) goto L20;
        String r104 = r100.getService();
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L18:
        this.mLogger.d(r102, " addDevice service error");
        return;
    L14:
        if (r104.equals(getSearchTarget()) == false) goto L18;
        HashMap r105 = new HashMap();
        r105.put("ssdp_packet", r100.toString());
        r105.put("ssdp_type", "alive");
        this.mMonitor.getSourceMonitor().trackSsdpBrowseEvent(CastMonitor.SSDP_RECEIVE_SUCCESS, r105);
        CastDevice r106 = new CastDevice(this.mCastContext);
        r106.setDeviceId(r100.getDeviceId());
        r106.setServiceType(r100.getService());
        r106.setProtocol(r100.getProtocol());
        r106.setIp(r100.getIp());
        r106.setPort(CastIntegerProtector.parseInt(r100.getPort()));
        r106.setMyName(r100.getMyName());
        r106.setSinkVersion(r100.getSinkVersion());
        addDevice(r106);
    }

    private void removeDevice(CastSSDPPacket r100) {
        CastLogger r101 = this.mLogger;
        String r102 = TAG;
        r101.d(r102, " removeDevice ssdpPacket is " + r100);
        if (r100 != null) goto L6;
        this.mLogger.d(r102, " removeDevice ssdpPacket is null");
        return;
    L6:
        String r103 = r100.getProtocol();
        if (TextUtils.isEmpty(r103) == false) goto L9;
    L27:
        this.mLogger.d(r102, " removeDevice protocol error");
        return;
    L9:
        if (r103.equals(getProtocol()) == false) goto L27;
        String r104 = r100.getService();
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L25:
        this.mLogger.d(r102, " removeDevice service error");
        return;
    L14:
        if (r104.equals(getSearchTarget()) == false) goto L25;
        HashMap r105 = new HashMap();
        r105.put("ssdp_packet", r100.toString());
        r105.put("ssdp_type", "byebye");
        this.mMonitor.getSourceMonitor().trackSsdpBrowseEvent(CastMonitor.SSDP_RECEIVE_SUCCESS, r105);
        String r106 = r100.getDeviceId();
        this.devLock.writeLock().lock();
    L22:
        th = move-exception;
        this.devLock.writeLock().unlock();
        throw th;
    L18:
        if (this.mDeviceMap.containsKey(r106) == false) goto L20;
        performRemoveDeviceListener(this.mDeviceMap.get(r106));     // Catch: Throwable -> L22
        this.mDeviceMap.remove(r106);     // Catch: Throwable -> L22
    L20:
        this.devLock.writeLock().unlock();
    }

    public void addDeviceChangeListener(b r100) {
        this.deviceChangeListenerList.add(r100);
    }

    public void notifyReceived(CastSSDPPacket r100) {
        if (r100.isAlive() == false) goto L6;
        addDevice(r100);
        return;
    L6:
        if (r100.isByeBye() == false) goto L10;
        removeDevice(r100);
        return;
    }

    public void onDeviceOffline(ServiceInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, CastDevice>> r101 = this.mDeviceMap.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        CastDevice r102 = r101.next().getValue();
        if (r100.f33719ip.equals(r102.getIp()) == false) goto L6;
        if (r100.port != r102.getPort()) goto L6;
        removeDevice(r102);
        goto L6
    }

    public void performAddDeviceListener(CastDevice r100) {
        int r101 = this.deviceChangeListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((b) this.deviceChangeListenerList.get(r102)).a();
        r102 = r102 + 1;
        goto L3
    }

    public void performRemoveDeviceListener(CastDevice r100) {
        int r101 = this.deviceChangeListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((b) this.deviceChangeListenerList.get(r102)).b();
        r102 = r102 + 1;
        goto L3
    }

    public void removeDeviceChangeListener(b r100) {
        this.deviceChangeListenerList.remove(r100);
    }

    public void searchResponseReceived(CastSSDPPacket r100) {
        addDevice(r100);
    }

    public void setProtocol(String r100) {
        this.mProtocol = r100;
    }

    public void setSearchTarget(String r100) {
        this.mSearchTarget = r100;
    }

    public void setSourceVersion(String r100) {
        this.mSourceVersion = r100;
    }

    private void addDevice(CastDevice r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.devLock.writeLock().lock();
        performAddDeviceListener(r100);     // Catch: Throwable -> L8
        this.mDeviceMap.put(r100.getDeviceId(), r100);     // Catch: Throwable -> L8
        this.devLock.writeLock().unlock();
        return;
    L8:
        th = move-exception;
        this.devLock.writeLock().unlock();
        throw th;
    }

    private void removeDevice(CastDevice r100) {
        this.devLock.writeLock().lock();
        performRemoveDeviceListener(r100);     // Catch: Throwable -> L6
        this.mDeviceMap.remove(r100.getDeviceId());     // Catch: Throwable -> L6
        this.devLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.devLock.writeLock().unlock();
        throw th;
    }
}
