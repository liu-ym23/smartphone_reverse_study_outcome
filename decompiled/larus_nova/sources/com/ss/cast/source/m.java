package com.ss.cast.source;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.source.SourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CastMonitor f456595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CastLogger f456596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f456597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f456598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f456599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f456600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ServiceInfo f456601g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f456602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f456603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f456604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f456605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ServiceInfo f456606e;

        public a() {
        }

        public final String toString() {
            return "ServiceInfoWrapper{ip='" + this.f456602a + "', name='" + this.f456603b + "', type='" + this.f456604c + "', port='" + this.f456605d + "', serviceInfo=" + this.f456606e + '}';
        }
    }

    public m() {
        throw null;
    }

    public final List<ServiceInfo> d() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((CopyOnWriteArrayList) this.f456597c).iterator();
    L3:
        int r102 = 1;
        if (r101.hasNext() == false) goto L137;
        a r103 = (a) r101.next();
        this.f456596b.d("ServiceInfoManager", "wrapper : " + r103);
        if ("ChromeCast".equals(r103.f456604c) == true) goto L7;
        Iterator r104 = r100.iterator();
        boolean r110 = false;
    L10:
        if (r104.hasNext() == false) goto L131;
        ServiceInfo r111 = (ServiceInfo) r104.next();
        if (r111 != null) goto L15;
    L38:
        boolean r112 = false;
    L40:
        if (r112 == false) goto L129;
        String r105 = r111.protocols;
        String r113 = r103.f456604c;
        if (TextUtils.isEmpty(r105) == false) goto L45;
    L43:
        boolean r106 = false;
    L62:
        if (r106 == false) goto L65;
        this.f456596b.d("ServiceInfoManager", "handle data set higher priority protocol port:" + r103.f456605d + ",service info port:" + r111.port);
        r111.port = r103.f456605d;
    L65:
        if (TextUtils.isEmpty(r111.protocols) == false) goto L67;
    L70:
        String r107 = r111.protocols;
        String r108 = r103.f456604c;
        if (TextUtils.isEmpty(r107) == false) goto L75;
        r107 = r108 + ",";
    L104:
        r111.protocols = r107;
        this.f456596b.d("ServiceInfoManager", " serviceInfo.protocols  : " + r111.protocols);
    L106:
        if (TextUtils.equals(r103.f456604c, "LeLink") == false) goto L109;
        ServiceInfo r109 = r103.f456606e;
        r111.types = r109.types;
        r111.browseLeLinkExtras = r109.browseLeLinkExtras;
    L125:
        r111.serviceIdentifierUDN = r103.f456606e.serviceIdentifierUDN;
        if (TextUtils.isEmpty(r111.dialServerUrl) == false) goto L128;
        r111.dialServerUrl = r103.f456606e.dialServerUrl;
    L128:
        r111.deviceParams.putAll(r103.f456606e.deviceParams);
        r110 = true;
    L130:
        r101 = r101;
        r102 = 1;
        goto L10
    L109:
        if (TextUtils.equals(r103.f456604c, "BDLink") == false) goto L112;
        ServiceInfo r114 = r103.f456606e;
        r111.data = r114.data;
        r111.width = r114.width;
        r111.height = r114.height;
        r111.deviceID = r114.deviceID;
        r111.setSupportPing(r114.isSupportPing());
        r111.setSupportDetect(r103.f456606e.isSupportDetect());
        this.f456596b.i("ServiceInfoManager", "serviceInfo.protocols:" + r111.protocols);
        goto L125
    L112:
        if (TextUtils.equals(r103.f456604c, "ByteLink") == false) goto L115;
        ServiceInfo r115 = r103.f456606e;
        r111.data = r115.data;
        r111.portMirror = r115.portMirror;
        r111.portInvite = r115.portInvite;
        r111.width = r115.width;
        r111.height = r115.height;
        r111.fps = r115.fps;
        r111.features = r115.features;
        r111.deviceID = r115.deviceID;
        r111.firewall = r115.firewall;
        r111.bitrate = r115.bitrate;
        r111.micScale = r115.micScale;
        r111.audioSource = r115.audioSource;
        r111.serverMode = r115.serverMode;
        r111.landscape = r115.landscape;
        r111.sinkPC = r115.sinkPC;
        r111.transTypes = r115.transTypes;
        goto L125
    L115:
        if (TextUtils.equals(r103.f456604c, "BDDLNA") == false) goto L117;
    L122:
        ServiceInfo r116 = r103.f456606e;
        r111.manufacture = r116.manufacture;
        if (TextUtils.isEmpty(r116.data) == true) goto L125;
        r111.data = r103.f456606e.data;
        goto L125
    L117:
        if (TextUtils.equals(r103.f456604c, "DIAL") == true) goto L122;
        if (TextUtils.equals(r103.f456604c, SourceModule.SMARTVIEW) == false) goto L125;
        r111.smartViewService = r103.f456606e.smartViewService;
        goto L125
    L75:
        if (r107.contains(r108) == true) goto L104;
        if (this.f456599e.contains(r108) == false) goto L80;
    L85:
        String[] r117 = r107.split(",");
        int r118 = r117.length + 1;
        String[] r119 = new String[r118];
        int r120 = 0;
    L87:
        if (r120 >= r117.length) goto L89;
        int r121 = r120 + 1;
        r119[r121] = r117[r120];
        r120 = r121;
        goto L87
    L89:
        int r122 = 1;
    L90:
        if (r122 >= r118) goto L97;
        if (this.f456599e.contains(r119[r122]) == false) goto L96;
        if (this.f456599e.indexOf(r119[r122]) >= this.f456599e.indexOf(r108)) goto L96;
        r119[r122 - 1] = r119[r122];
        r122 = r122 + 1;
    L96:
        r119[r122 - 1] = r108;
        boolean r123 = true;
    L98:
        if (r123 == true) goto L100;
        r119[r122 - 1] = r108;
    L100:
        r107 = "";
        int r124 = 0;
    L101:
        if (r124 >= r118) goto L103;
        r107 = r107 + r119[r124] + ",";
        r124 = r124 + 1;
        goto L101
    L103:
        this.f456596b.d("ServiceInfoManager", "get sorted protocols:" + r107);
        goto L104
    L97:
        r123 = false;
        goto L98
    L80:
        if (r107.contains(r108) == true) goto L85;
        if (r107.endsWith(",") == false) goto L84;
        r107 = r107 + r108 + ",";
        goto L104
    L84:
        r107 = r107 + "," + r108 + ",";
        goto L104
    L67:
        if (r111.protocols.contains(r103.f456604c) == false) goto L70;
        r101 = r101;
        goto L106
    L45:
        if (r105.contains(r113) == true) goto L43;
        String[] r125 = r105.split(",");
        if (r125.length < r102) goto L43;
        Iterator<String> r126 = this.f456599e.iterator();
    L52:
        if (r126.hasNext() == false) goto L61;
        String r127 = r126.next();
        if (TextUtils.equals(r127, r125[0]) == true) goto L61;
        if (TextUtils.equals(r127, r113) == false) goto L52;
        r106 = true;
    L61:
        r106 = false;
        goto L62
    L129:
        r101 = r101;
        goto L130
    L15:
        if (TextUtils.equals(r103.f456602a, r111.f33719ip) == false) goto L20;
        if (r103.f456605d != r111.port) goto L20;
        this.f456596b.d("ServiceInfoManager", "isSameDevice ip&port same,return true!");
    L37:
        r112 = true;
    L20:
        if (TextUtils.isEmpty(r103.f456604c) == false) goto L22;
    L39:
        this.f456596b.d("ServiceInfoManager", "isSameDevice type is empty, return false ! type is " + r103.f456604c + " protocols is " + r111.protocols);
        goto L38
    L22:
        if (TextUtils.isEmpty(r111.protocols) == true) goto L39;
        if (TextUtils.equals(r103.f456604c, "BDDLNA") == false) goto L34;
        if (r111.protocols.contains("BDDLNA") == false) goto L34;
        if (TextUtils.equals(r103.f456602a, r111.f33719ip) == false) goto L38;
        if (TextUtils.equals(r103.f456603b, r111.name) == false) goto L38;
        r112 = TextUtils.equals(r111.serviceIdentifierUDN, r103.f456606e.serviceIdentifierUDN);
    L34:
        if (TextUtils.equals(r103.f456602a, r111.f33719ip) == false) goto L38;
        if (TextUtils.equals(r103.f456603b, r111.name) == false) goto L38;
    L131:
        Iterator r128 = r101;
        if (r110 == false) goto L134;
    L136:
        r101 = r128;
        goto L3
    L134:
        if (r103.f456606e == null) goto L136;
        this.f456596b.d("ServiceInfoManager", "serviceInfo : " + r103.f456606e);
        r100.add(r103.f456606e.deepCopy());
        goto L136
    L7:
        this.f456596b.d("ServiceInfoManager", "serviceInfo : " + r103.f456606e);
        r100.add(r103.f456606e);
        goto L3
    L137:
        Iterator r129 = r100.iterator();
    L139:
        if (r129.hasNext() == false) goto L156;
        ServiceInfo r130 = (ServiceInfo) r129.next();
        this.f456596b.d("ServiceInfoManager", "service : " + r130);
        String[] r131 = r130.protocols.split(",");
        int r132 = 0;
    L142:
        if (r132 >= r131.length) goto L149;
        if (this.f456599e.contains(r131[r132]) == true) goto L148;
        if (this.f456600f.contains(r131[r132]) == true) goto L148;
        r131[r132] = "";
    L148:
        r132 = r132 + 1;
        goto L142
    L149:
        r130.protocols = "";
        int r133 = 0;
    L151:
        if (r133 >= r131.length) goto L139;
        if (TextUtils.isEmpty(r131[r133]) == true) goto L155;
        r130.protocols += r131[r133] + ",";
    L155:
        r133 = r133 + 1;
        goto L151
    L156:
        List<Object> r134 = this.f456598d;
        if (r134 != null) goto L159;
    L172:
        return r100;
    L159:
        if (((CopyOnWriteArrayList) r134).isEmpty() == true) goto L172;
        Iterator r135 = ((CopyOnWriteArrayList) this.f456598d).iterator();
    L163:
        if (r135.hasNext() == false) goto L172;
        a r136 = (a) r135.next();
        Iterator r137 = r100.iterator();
        boolean r138 = false;
    L166:
        if (r137.hasNext() == false) goto L170;
        ServiceInfo r139 = (ServiceInfo) r137.next();
        if (TextUtils.equals(r139.name, r136.f456603b) == false) goto L166;
        r139.protocols += "WIFIP2P,";
        r138 = true;
        goto L166
    L170:
        if (r138 == true) goto L163;
        r100.add(r136.f456606e);
        goto L163
    }

    public final a c(ServiceInfo r100) {
        monitor-enter(this);
        if (r100 != null) goto L9;
        this.f456596b.w("ServiceInfoManager", "serviceInfo is null");     // Catch: Throwable -> L97
        monitor-exit(this);     // Catch: Throwable -> L97
        return null;
    L9:
        List<String> r101 = this.f456599e;     // Catch: Throwable -> L97
        if (r101 != null) goto L12;
    L94:
        this.f456595a.sendSourceEvent(CastMonitor.BYTECAST_PLAY_FAILURE_INFO, "play we cannot find device, linkProtocols : " + this.f456599e + ",serviceInfo:" + r100, r100.connectID);     // Catch: Throwable -> L97
        monitor-exit(this);     // Catch: Throwable -> L97
        return null;
    L12:
        if (r101.size() == 0) goto L94;
        if (this.f456601g == null) goto L40;
        a r102 = new a();     // Catch: Throwable -> L97
        ServiceInfo r103 = this.f456601g;     // Catch: Throwable -> L97
        r102.f456606e = r103;     // Catch: Throwable -> L97
        String r104 = r103.protocols;     // Catch: Throwable -> L97
        if (r104 != null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L97
        return r102;
    L21:
        if (r104.contains("BDLink") == false) goto L24;
        r102.f456604c = "BDLink";     // Catch: Throwable -> L97
    L38:
        monitor-exit(this);     // Catch: Throwable -> L97
        return r102;
    L24:
        if (this.f456601g.protocols.contains("BDCloud") == false) goto L27;
        r102.f456604c = "BDCloud";     // Catch: Throwable -> L97
        r102.f456606e.isSupportPlayList = r100.isSupportPlayList;     // Catch: Throwable -> L97
        goto L38
    L27:
        if (this.f456601g.protocols.contains("ChromeCast") == false) goto L30;
        r102.f456604c = "ChromeCast";     // Catch: Throwable -> L97
        goto L38
    L30:
        if (this.f456601g.protocols.contains(SourceModule.SMARTVIEW) == false) goto L33;
        r102.f456604c = SourceModule.SMARTVIEW;     // Catch: Throwable -> L97
        goto L38
    L33:
        if (this.f456601g.protocols.contains("DIAL") == false) goto L36;
        r102.f456604c = "DIAL";     // Catch: Throwable -> L97
        goto L38
    L36:
        if (this.f456601g.protocols.contains("BDDLNA") == false) goto L38;
        r102.f456604c = "BDDLNA";     // Catch: Throwable -> L97
        goto L38
    L40:
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L97
        Iterator r106 = ((CopyOnWriteArrayList) this.f456597c).iterator();     // Catch: Throwable -> L97
    L42:
        if (r106.hasNext() == false) goto L48;
        a r107 = (a) r106.next();     // Catch: Throwable -> L97
        if (TextUtils.equals(r107.f456602a, r100.f33719ip) == false) goto L42;
        if (TextUtils.equals(r107.f456603b, r100.name) == false) goto L42;
        r105.add(r107);     // Catch: Throwable -> L97
        goto L42
    L48:
        Iterator<String> r108 = this.f456599e.iterator();     // Catch: Throwable -> L97
    L50:
        if (r108.hasNext() == false) goto L64;
        String r109 = r108.next();     // Catch: Throwable -> L97
        if (TextUtils.isEmpty(r100.protocols) == true) goto L50;
        if (r100.protocols.contains(r109) == false) goto L50;
        Iterator r110 = r105.iterator();     // Catch: Throwable -> L97
    L57:
        if (r110.hasNext() == false) goto L50;
        a r111 = (a) r110.next();     // Catch: Throwable -> L97
        if (TextUtils.equals(r111.f456604c, r109) == false) goto L57;
        if (r111.f456605d != r100.port) goto L57;
        monitor-exit(this);     // Catch: Throwable -> L97
        return r111;
    L64:
        Iterator<String> r112 = this.f456599e.iterator();     // Catch: Throwable -> L97
    L66:
        if (r112.hasNext() == false) goto L79;
        String r113 = r112.next();     // Catch: Throwable -> L97
        if (TextUtils.isEmpty(r100.protocols) == true) goto L66;
        if (r100.protocols.contains(r113) == false) goto L66;
        Iterator r114 = r105.iterator();     // Catch: Throwable -> L97
    L73:
        if (r114.hasNext() == false) goto L66;
        a r115 = (a) r114.next();     // Catch: Throwable -> L97
        if (TextUtils.equals(r115.f456604c, r113) == false) goto L73;
        monitor-exit(this);     // Catch: Throwable -> L97
        return r115;
    L79:
        if (this.f456599e.contains("BDDLNA") == true) goto L81;
    L91:
        this.f456595a.sendSourceEvent(CastMonitor.BYTECAST_PLAY_FAILURE_INFO, "play we cannot find device, linkProtocols : " + this.f456599e + ", alllist : " + this.f456597c + ",serviceInfo:" + r100, r100.connectID);     // Catch: Throwable -> L97
        monitor-exit(this);     // Catch: Throwable -> L97
        return null;
    L81:
        if (TextUtils.isEmpty(r100.protocols) == true) goto L91;
        if (r100.protocols.contains("BDDLNA") == false) goto L91;
        Iterator r116 = ((CopyOnWriteArrayList) this.f456597c).iterator();     // Catch: Throwable -> L97
    L86:
        if (r116.hasNext() == false) goto L91;
        a r117 = (a) r116.next();     // Catch: Throwable -> L97
        if (TextUtils.equals(r117.f456606e.serviceIdentifierUDN, r100.serviceIdentifierUDN) == false) goto L86;
        monitor-exit(this);     // Catch: Throwable -> L97
        return r117;
    L97:
        th = move-exception;
        throw th;
    }

    public final void b(int r100, String r101) {
        this.f456596b.d("ServiceInfoManager", "clearData, code: " + r100 + ", type: " + r101);
        if (TextUtils.equals(r101, "BDLink") == false) goto L5;
    L14:
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((CopyOnWriteArrayList) this.f456597c).iterator();
    L16:
        if (r103.hasNext() == false) goto L22;
        a r104 = (a) r103.next();
        if (TextUtils.equals(r104.f456604c, r101) == false) goto L16;
        if (r104.f456606e.getOriginFrom().clearOriginBit(r100, r101).isEmpty() == false) goto L16;
        r102.add(r104);
        goto L16
    L22:
        ((CopyOnWriteArrayList) this.f456597c).removeAll(r102);
    L24:
        if (TextUtils.equals(SourceModule.WIFIP2P, r101) == true) goto L26;
        return;
    L26:
        if (r100 != 5) goto L28;
        return;
    L28:
        if (r100 != 7) goto L30;
        return;
    L30:
        if (r100 == 8) goto L53;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((CopyOnWriteArrayList) this.f456598d).iterator();
    L33:
        if (r106.hasNext() == false) goto L35;
        r105.add((a) r106.next());
        goto L33
    L35:
        ((CopyOnWriteArrayList) this.f456598d).removeAll(r105);
        return;
    L53:
        return;
    L5:
        if (TextUtils.equals(r101, "ByteLink") == true) goto L14;
        ArrayList r107 = new ArrayList();
        Iterator r108 = ((CopyOnWriteArrayList) this.f456597c).iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        a r109 = (a) r108.next();
        if (TextUtils.equals(r109.f456604c, r101) == false) goto L9;
        r107.add(r109);
        goto L9
    L13:
        ((CopyOnWriteArrayList) this.f456597c).removeAll(r107);
        goto L24
    }

    public m(ContextManager.CastContext r100, List<String> r101, List<String> r102) {
        this.f456597c = new CopyOnWriteArrayList();
        this.f456598d = new CopyOnWriteArrayList();
        this.f456599e = r101;
        this.f456600f = r102;
        this.f456595a = ContextManager.getMonitor(r100);
        this.f456596b = ContextManager.getLogger(r100);
    }

    public final void a(int r100, String r110, List<ServiceInfo> r111) {
        this.f456596b.i("ServiceInfoManager", "addData, link :" + this.f456599e + ", mirror:" + this.f456600f);
        Iterator<ServiceInfo> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L59;
        ServiceInfo r101 = r112.next();
        this.f456596b.d("ServiceInfoManager", "addData, code: " + r100 + ", type: " + r110 + ", serviceInfo: " + r101);
        if (TextUtils.isEmpty(r101.protocols) == true) goto L10;
        if (r101.protocols.contains(r110) == false) goto L10;
    L25:
        String r102 = r101.f33719ip;
        int r103 = r101.port;
        String r104 = r101.name;
        if ("ChromeCast".equals(r110) == false) goto L28;
    L55:
        boolean r105 = true;
    L56:
        if (r105 == false) goto L4;
        r101.getOriginFrom().setOriginBit(r100, r110);
        a r106 = new a();
        r106.f456602a = r101.f33719ip;
        r106.f456603b = r101.name;
        r106.f456604c = r110;
        r106.f456606e = r101;
        r106.f456605d = r101.port;
        ((CopyOnWriteArrayList) this.f456597c).add(r106);
        goto L4
    L28:
        if ("DIAL".equals(r110) == true) goto L55;
        if (SourceModule.WEBOSTV.contains(r110) == true) goto L55;
        if (SourceModule.SMARTVIEW.contains(r110) == true) goto L55;
        if (TextUtils.isEmpty(r102) == true) goto L54;
        Iterator r107 = ((CopyOnWriteArrayList) this.f456597c).iterator();
    L39:
        if (r107.hasNext() == false) goto L55;
        a r108 = (a) r107.next();
        if (TextUtils.isEmpty(r108.f456603b) == true) goto L39;
        if (TextUtils.isEmpty(r108.f456604c) == true) goto L39;
        if (r102.equals(r108.f456602a) == false) goto L39;
        if (r108.f456605d != r103) goto L39;
        if (r108.f456603b.equals(r104) == false) goto L39;
        if (r108.f456604c.equals(r110) == false) goto L39;
        r108.f456606e.getOriginFrom().setOriginBit(r100, r110);
    L54:
        r105 = false;
    L10:
        if (TextUtils.equals(r110, "BDLink") == false) goto L14;
        if (this.f456599e.contains("BDLink") == false) goto L14;
    L16:
        if (this.f456599e.contains(r110) == false) goto L21;
        if (r101.deviceParams.containsKey(Constants.SINK_BDLINK_VERSION_KEY) == false) goto L21;
        r101.protocols += r110 + ",";
        this.f456596b.i("ServiceInfoManager", "addData, type:" + r110 + ", protocols:" + r101.protocols);
    L21:
        if (this.f456599e.contains(r110) == false) goto L25;
        if (TextUtils.equals("BDLink", r110) == true) goto L25;
        r101.protocols += r110 + ",";
        this.f456596b.i("ServiceInfoManager", "addData, type:" + r110 + ", protocols:" + r101.protocols);
    L14:
        if (TextUtils.equals(r110, "BDLink") == true) goto L25;
    }

    public final List<ServiceInfo> e(int r100, String r101, List<ServiceInfo> r102) {
        List<ServiceInfo> r103 = new ArrayList();
        if (r100 != 2) goto L5;
    L12:
        return r103;
    L5:
        monitor-enter(m.class);
        b(r100, r101);     // Catch: Throwable -> L9
        a(r100, r101, r102);     // Catch: Throwable -> L9
        r103 = d();     // Catch: Throwable -> L9
        monitor-exit(m.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
