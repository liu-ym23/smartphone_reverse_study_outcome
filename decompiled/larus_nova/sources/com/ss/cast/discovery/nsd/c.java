package com.ss.cast.discovery.nsd;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.MaxSizeLinkedHashMap;
import com.byted.cast.common.PreferenceUtils;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.GsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f456358n = 15000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f456359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContextManager.CastContext f456360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CastLogger f456361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CastMonitor f456362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ICastSource f456363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f456364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wjc.b f456365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f456366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f456367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f456368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f456369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f456370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MaxSizeLinkedHashMap f456371m;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f456372a;

        public a(c r100) {
            this.f456372a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            int r100 = r110.what;
            if (r100 != 1) goto L5;
            c r111 = this.f456372a;
            if (r111.f456359a != null) goto L25;
            r111.f456361c.w("BDLinkServiceDiskCacheHelper", "readCacheInner context is null");
        L33:
            return true;
        L25:
            r111.f456361c.i("BDLinkServiceDiskCacheHelper", "readCacheInner");
            Context r101 = r111.f456359a;
            ContextManager.CastContext r102 = r111.f456360b;
            if (r102 != null) goto L28;
            String r103 = "";
        L29:
            LinkedHashMap r104 = (LinkedHashMap) GsonUtils.fromJsonIgnoreException(PreferenceUtils.getBDLinkServiceInfo(r101, r103), new e().getType());
            if (r104 != null) goto L32;
            r111.f456361c.w("BDLinkServiceDiskCacheHelper", "readCacheInner diskCacheServiceMap is null");
            goto L33
        L32:
            r111.f456371m.putAll(r104);
            r111.f456361c.i("BDLinkServiceDiskCacheHelper", "readCacheInner serviceMap size: " + r111.f456371m.size());
            goto L33
        L28:
            r103 = r102.getProjectId();
            goto L29
        L5:
            if (r100 != 2) goto L33;
            Bundle r112 = r110.getData();
            long r105 = this.f456372a.f456369k;
            if (r112 == null) goto L10;
            r105 = r112.getLong("msg.key.start_check_time", r105);
        L10:
            c r113 = this.f456372a;
            r113.f456361c.i("BDLinkServiceDiskCacheHelper", "startCheckInner");
            if (r113.f456371m.isEmpty() == false) goto L13;
            r113.f456361c.i("BDLinkServiceDiskCacheHelper", "serviceMap is empty");
            goto L33
        L13:
            Iterator r106 = r113.f456371m.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L33;
            Map.Entry r107 = (Map.Entry) r106.next();
            if (r107 == null) goto L15;
            ServiceInfo r108 = (ServiceInfo) r107.getValue();
            if (r105 != r113.f456369k) goto L20;
            Dispatcher.getInstance().enqueue(new f(r113, r108, r105));
            goto L15
        L20:
            r113.f456361c.i("BDLinkServiceDiskCacheHelper", "before enqueue task expired, ignore this task.");
            goto L15
        }
    }

    public c(ContextManager.CastContext r100, ICastSource r101) {
        this.f456366h = "BDLink";
        this.f456368j = false;
        this.f456369k = 0;
        this.f456370l = Constants.BDLINK_DEFAULT_PORT_ARRAY;
        this.f456371m = new MaxSizeLinkedHashMap(5);
        this.f456360b = r100;
        this.f456361c = ContextManager.getLogger(r100);
        this.f456362d = ContextManager.getMonitor(r100);
        this.f456363e = r101;
        this.f456364f = new Handler(Dispatcher.getInstance().getByteCastThreadLooper(), new a(this));
    }
}
