package com.bytedance.awemeopen.infra.plugs.applog;

import android.app.Application;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.g;
import com.bytedance.applog.h;
import com.bytedance.applog.q;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.bdinstall.f0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/applog/AoAppLogEventCompatServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/event/AoEventService;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_plugin_applog_release"}, k = 1, mv = {1, 7, 1})
public class AoAppLogEventCompatServiceImpl implements AoEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.infra.plugs.applog.c f198810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f198812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f198813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f198814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f198815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f198816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<a> f198817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k64.a f198818i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f198819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f198820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f198821c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f198819a, r101.f198819a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f198820b, r101.f198820b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f198821c, r101.f198821c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f198819a.hashCode() * 31) + this.f198820b.hashCode()) * 31;
            String r101 = this.f198821c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TempEventBufferData(event=" + this.f198819a + ", params=" + this.f198820b + ", hostRawData=" + this.f198821c + ')';
        }

        public a(String r100, JSONObject r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f198819a = r100;
            this.f198820b = r101;
            this.f198821c = r102;
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoAppLogEventCompatServiceImpl f198822a;

        public b(AoAppLogEventCompatServiceImpl r100) {
            this.f198822a = r100;
        }

        @Override // com.bytedance.applog.h
        public final void a(boolean r100, JSONObject r101) {
            this.f198822a.F2().d("AppLogIniter", "onRemoteConfigGet: changed = " + r100 + ", config = " + r101);
        }

        @Override // com.bytedance.applog.h
        public final void onIdLoaded(String r100, String r101, String r102) {
            this.f198822a.F2().d("AppLogIniter", "onIdLoaded: did = " + r100 + ", iid = " + r101 + ", ssid = " + r102);
        }

        @Override // com.bytedance.applog.h
        public final void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r110) {
            this.f198822a.F2().d("AppLogIniter", "onRemoteIdGet: changed = " + r100 + ", oldDid = " + r101 + ", newDid = " + r102 + ", oldIid = " + r103 + ", newIid = " + r104 + ", oldSsid = " + r105 + ", newSsid = " + r110);
        }
    }

    public static final class c implements f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AoAppLogEventCompatServiceImpl f198823a;

        public c(AoAppLogEventCompatServiceImpl r100) {
            this.f198823a = r100;
        }

        @Override // com.bytedance.bdinstall.f0
        public final void d(String r100, Throwable r101) {
            AoLogService r102 = this.f198823a.F2();
            StringBuilder r103 = new StringBuilder();
            r103.append(r100);
            if (r101 == null) goto L5;
            String r104 = r101.toString();
        L6:
            r103.append(r104);
            r102.d("AppLog", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.bytedance.bdinstall.f0
        public final void e(String r100, Throwable r101) {
            AoLogService r102 = this.f198823a.F2();
            StringBuilder r103 = new StringBuilder();
            r103.append(r100);
            if (r101 == null) goto L5;
            String r104 = r101.toString();
        L6:
            r103.append(r104);
            r102.e("AppLog", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.bytedance.bdinstall.f0
        public final void i(String r100, Throwable r101) {
            AoLogService r102 = this.f198823a.F2();
            StringBuilder r103 = new StringBuilder();
            r103.append(r100);
            if (r101 == null) goto L5;
            String r104 = r101.toString();
        L6:
            r103.append(r104);
            r102.i("AppLog", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.bytedance.bdinstall.f0
        public final void v(String r100, Throwable r101) {
            AoLogService r102 = this.f198823a.F2();
            StringBuilder r103 = new StringBuilder();
            r103.append(r100);
            if (r101 == null) goto L5;
            String r104 = r101.toString();
        L6:
            r103.append(r104);
            r102.d("AppLog", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.bytedance.bdinstall.f0
        public final void w(String r100, Throwable r101) {
            AoLogService r102 = this.f198823a.F2();
            StringBuilder r103 = new StringBuilder();
            r103.append(r100);
            if (r101 == null) goto L5;
            String r104 = r101.toString();
        L6:
            r103.append(r104);
            r102.w("AppLog", r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    @Override // com.bytedance.awemeopen.servicesapi.event.AoEventService
    public final void init() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f198816g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        g r100 = G2();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r100, "<set-?>");     // Catch: Throwable -> L14
        this.f198815f = r100;     // Catch: Throwable -> L14
        Iterator<a> r101 = this.f198817h.iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L11;
        a r102 = r101.next();     // Catch: Throwable -> L14
        E2(r102.f198819a, r102.f198820b);     // Catch: Throwable -> L14
        goto L9
    L11:
        this.f198817h.clear();     // Catch: Throwable -> L14
        this.f198816g = true;     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public final AoLogService F2() {
        return (AoLogService) this.f198812c.getValue();
    }

    public final g G2() {
        g r100 = AppLog.newInstance();
        int r101 = j64.b.f497514a;
        AoHostService r102 = (AoHostService) j64.b.a(AoHostService.class);
        Application r103 = r102.getHostApplication();
        int r104 = com.bytedance.awemeopen.infra.plugs.applog.a.f198826a;
        q r105 = new q("352969", r102.getHostChannel());
        r105.f192819k = "aweme_open_sdk_for_event";
        r105.f192820l = UriConstants.f192848a;
        r105.f192810b = true;
        r105.f192828t = NetworkClientForApplog.f198824a;
        boolean r106 = ((AoHostService) j64.b.a(AoHostService.class)).hostIsDebug();
        r100.t1(!r106);
        r100.E0(new b(this));
        r105.f192813e = new c(this);
        r100.O(r103, r105);
        if (r106 == false) goto L5;
        EventsSenderUtils.setEventsSenderEnable("352969", true, r103);
        EventsSenderUtils.setEventVerifyHost("352969", "https://log.snssdk.com");
    L5:
        return r100;
    }

    public AoAppLogEventCompatServiceImpl(d r100) {
        Intrinsics.checkNotNullParameter(r100, "compat");
        this.f198810a = r100;
        this.f198811b = "AoAppLogEventCompatServiceImpl";
        this.f198812c = LazyKt.lazy(AoAppLogEventCompatServiceImpl$logger$2.INSTANCE);
        this.f198813d = LazyKt.lazy(AoAppLogEventCompatServiceImpl$aoHostEnv$2.INSTANCE);
        this.f198814e = true;
        this.f198817h = new ArrayList();
    }

    @Override // com.bytedance.awemeopen.servicesapi.event.AoEventService
    public final void D1(com.bytedance.awemeopen.infra.base.event.a r100) {
        this.f198818i = r100;
    }

    @Override // com.bytedance.awemeopen.servicesapi.event.AoEventService
    public final String k(String r100) {
        if (this.f198816g == true) goto L24;
        F2().w(this.f198811b, "getDid applog not inited");
        if (r100 == null) goto L7;
        return r100;
    L7:
        return "";
    L24:
        String r101 = this.f198810a.k(r100);     // Catch: Exception -> L10
    L12:
        if (r101 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L27;
        F2().w(this.f198811b, "newUrl is null or empty");
        if (r100 == null) goto L23;
        return r100;
    L23:
        return "";
    L27:
        return r101;
    L14:
        if (r101.length() == 0) goto L17;
        r102 = false;
    L10:
        e = move-exception;
        F2().w(this.f198811b, "compat get url fail: " + e);
        r101 = null;
        goto L12
    }

    @Override // com.bytedance.awemeopen.servicesapi.event.AoEventService
    public final JSONObject z2(JSONObject r100) {
        k64.a r101 = this.f198818i;
        if (r101 == null) goto L5;
        JSONObject r102 = ((com.bytedance.awemeopen.infra.base.event.a) r101).f198599a.getParams();
    L6:
        e.a(r100, r102);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final void E2(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        k64.a r102 = this.f198818i;
        if (r102 == null) goto L6;
        e.a(r101, ((com.bytedance.awemeopen.infra.base.event.a) r102).f198599a.getParams());
    L6:
        if (this.f198814e == false) goto L12;
        g r103 = this.f198815f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mNewInstanceApplog");
        r103 = null;
    L11:
        r103.onEventV3(r100, r101);
        return;
    L12:
        AppLog.onEventV3(r100, r101);
    }

    @Override // com.bytedance.awemeopen.servicesapi.event.AoEventService
    public final void k2(String r100, JSONObject r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (this.f198816g == true) goto L22;
        F2().w(this.f198811b, "sendEventV3 applog not inited");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.f198816g == false) goto L9;
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        goto L22
    L9:
        if (this.f198817h.size() <= 5000) goto L13;
        F2().w(this.f198811b, "sendEventV3 event buffer too much");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L13:
        this.f198817h.add(new a(r100, r101, r102));     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L22:
        if (r102 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == false) goto L32;
        if (r103 == null) goto L34;
        if (r103.length() > 0) goto L32;
    L34:
        if (Intrinsics.areEqual(r100, "tobsdk_livesdk_live_show") == true) goto L38;
        E2(r100, r101);
        return;
    L38:
        return;
    L32:
        F2().i(this.f198811b, "send event(" + r100 + ") with hostRawData(" + r102 + ") and hostExtraParams(" + r103 + ')');
        goto L34
    L24:
        if (r102.length() == 0) goto L27;
        r105 = false;
        goto L28
    }
}
