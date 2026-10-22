package com.ss.cast.discovery.nsd;

import android.os.Handler;
import android.os.Message;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.source.SearchType;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.ss.cast.discovery.ClientProxy;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICastSource f456347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f456348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContextManager.CastContext f456349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CastLogger f456350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public wjc.a f456351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public wjc.c f456352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f456353g;

    /* JADX INFO: renamed from: com.ss.cast.discovery.nsd.a$a, reason: collision with other inner class name */
    public class C5462a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f456354a;

        public C5462a(a r100) {
            this.f456354a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            if (r110.what != 1) goto L47;
            a r111 = this.f456354a;
            if (r111.f456347a == null) goto L43;
            wjc.c r100 = r111.f456352f;
            if (r100 == null) goto L43;
            SearchType r101 = SearchType.MDNS;
            List<ServiceInfo> r102 = ((ClientProxy.b) r100).f456263a.getDeviceList(r101);
            wjc.c r103 = r111.f456352f;
            SearchType r104 = SearchType.SSDP;
            List<ServiceInfo> r105 = ((ClientProxy.b) r103).f456263a.getDeviceList(r104);
            if (r102 != null) goto L13;
        L18:
            if (r105 == null) goto L45;
            if (r105.isEmpty() == true) goto L45;
            Iterator<ServiceInfo> r106 = r105.iterator();
        L23:
            if (r106.hasNext() == false) goto L45;
            ServiceInfo r107 = r106.next();
            if (r107 == null) goto L38;
            if (r102 == null) goto L38;
            if (r102.isEmpty() == true) goto L38;
            Iterator<ServiceInfo> r108 = r102.iterator();
        L32:
            if (r108.hasNext() == false) goto L39;
            ServiceInfo r109 = r108.next();
            if (r109.f33719ip.equals(r107.f33719ip) == false) goto L32;
            if (r109.port != r107.port) goto L32;
            boolean r112 = true;
        L40:
            if (r112 == true) goto L23;
            Dispatcher.getInstance().enqueue(new b(r111, r107));
        L39:
            r112 = false;
        L38:
            r111.f456350d.d("BDLinkServiceDetector", " hasServiceInfo return !");
        L45:
            if (this.f456354a.f456353g == false) goto L47;
            a r113 = this.f456354a;
            long r114 = DLNAOptionUtils.getBdlinkDeviceOfflineDetectInterval(r113.f456349c);
            r113.f456348b.removeMessages(1);
            r113.f456348b.sendEmptyMessageDelayed(1, r114);
            goto L47
        L13:
            if (r102.isEmpty() == true) goto L18;
            Iterator<ServiceInfo> r115 = r102.iterator();
        L16:
            if (r115.hasNext() == false) goto L18;
            ServiceInfo r116 = r115.next();
            Dispatcher.getInstance().enqueue(new b(r111, r116));
        L43:
            r111.f456350d.w("BDLinkServiceDetector", "handleDetectMessage bdlinkSource is null or iGetDeviceListListener is null");
        L47:
            return true;
        }
    }

    public a(ContextManager.CastContext r100, ICastSource r101) {
        this.f456353g = false;
        this.f456347a = r101;
        this.f456349c = r100;
        this.f456350d = ContextManager.getLogger(r100);
        this.f456348b = new Handler(Dispatcher.getInstance().getByteCastThreadLooper(), new C5462a(this));
    }
}
