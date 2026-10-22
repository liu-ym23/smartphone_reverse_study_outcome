package com.ss.android.lark.integrator.ccm.spacekit;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.bytedance.ee.bear.lark.dependency.v;
import com.bytedance.ee.bear.lark.selector.DocModuleInner;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsRequest;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.ccm_api.SpacekitConst$LoginEvent;
import com.ss.android.lark.doc.entity.DocFeed;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.MapsKt;
import okhttp3.HttpUrl;
import on4.r;

/* JADX INFO: loaded from: classes36.dex */
public final class SpacekitSdkWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f427888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<r> f427889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<gmb.a> f427890c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f427891a;

        @Override // java.lang.Runnable
        public final void run() {
            qa5.b.a.f532259a.f532258a.b().g(this.f427891a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(List r100) {
            this.f427891a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SpacekitSdkWrapper f427892a = null;

        static {
            f427892a = new SpacekitSdkWrapper();
        }
    }

    public final void c() {
        Log.i("SpacekitSdkWrapper", "DocsImpl.checkAndInit ");
        c r100 = this.f427888a;
        getContext();
        r100.a(0);
    }

    public SpacekitSdkWrapper() {
        this.f427888a = new c();
        this.f427889b = new CopyOnWriteArrayList();
        this.f427890c = new CopyOnWriteArrayList();
        eu5.b.f474075a = LarkContext.getApplication();
    }

    private Application getContext() {
        return LarkContext.getApplication();
    }

    public static String a(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        yob.e.a().getClass();
        int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
        r101.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, com.ss.android.lark.language.service.impl.a.b.f431098a.b());
        return av5.c.b(r100, r101, false);
    }

    public static boolean b(String r100) {
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == true) goto L6;
        return false;
    L6:
        int r101 = jl5.a.f499529a;
        User r102 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r102 == null) goto L9;
        String r103 = r102.getTenantCode();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        String r104 = gcb.b.a(r103);
        String r105 = jcb.b.c().a("docs_api");
        return ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).c(r104, r105, r100);
    L9:
        r103 = null;
        goto L10
    }

    public static int d(DocType r100) {
        int r101 = DocModuleInner.a.f227455a[r100.ordinal()];
        if (r101 != 2) goto L5;
        int r102 = R.drawable.ud_icon_file_link_sheet_outlined;
    L25:
        return kac.a.b(r102);
    L5:
        if (r101 != 3) goto L7;
        r102 = R.drawable.ud_icon_file_link_bitable_outlined;
        goto L25
    L7:
        if (r101 != 4) goto L9;
        r102 = R.drawable.ud_icon_file_link_mindnote_outlined;
        goto L25
    L9:
        if (r101 != 5) goto L11;
        r102 = R.drawable.ud_icon_file_link_otherfile_outlined;
        goto L25
    L11:
        if (r101 != 6) goto L13;
        r102 = R.drawable.ud_icon_file_link_slides_outlined;
        goto L25
    L13:
        if (r101 != 8) goto L15;
        r102 = R.drawable.ud_icon_file_link_docx_outlined;
        goto L25
    L15:
        if (r101 == 10) goto L17;
        r102 = R.drawable.ud_icon_file_link_word_outlined;
        goto L25
    L17:
        r102 = R.drawable.ud_icon_file_link_slide_outlined;
        goto L25
    }

    public static void h(List r100) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r100));
    }

    public static void k(DocAppUserConfig r100) {
        if (qa5.b.a() == true) goto L5;
        return;
    L5:
        if (r100.getUrlRegex().isEmpty() == false) goto L7;
        Log.i("SpacekitSdkWrapper", "update url regex fail url regex is empty");
    L7:
        pn4.f r101 = qa5.b.a.f532259a.f532258a.i();
        com.bytedance.ee.bear.basesdk.apisupport.g r102 = (com.bytedance.ee.bear.basesdk.apisupport.g) r101;
        r102.a(r100.getUrlRegex());
        tt5.a.h("SpacekitSdkWrapper", "update url regex success");
    }

    public final void f(int r110) {
        Log.i("SpacekitSdkWrapper", "DocsImpl.onLoginStatusChangedEvent, event: " + r110);
        if (r110 != SpacekitConst$LoginEvent.Login.ordinal()) goto L53;
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        r100.getClass();
        tt5.a.h("AppSetting", "clear cache");
        cn4.a r101 = r100.f206236b;
        ((ConcurrentHashMap) r101.f24509b).clear();
        ((ConcurrentHashMap) r101.f24510c).clear();
        Iterator r102 = ((ConcurrentSkipListSet) r100.f206235a).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((com.bytedance.ee.bear.appsetting.m) r102.next()).onClear();
        goto L6
    L8:
        com.bytedance.ee.bear.appsetting.c.a.f206237a.b();
        if (qa5.b.a() == false) goto L53;
        Log.i("SpacekitSdkWrapper", "DocsImpl.trySetAccountInfo ");
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L53;
        String r103 = jl5.a.a();
        User r104 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r104 == null) goto L16;
        Map<String, SessionInfo> r105 = r104.getSessionWithDomainMap();
        if (r105 == null) goto L16;
    L17:
        if (r105 != null) goto L19;
        tt5.a.k("SpacekitSdkWrapper", "sessionInfoMap is null");
        HashMap r106 = new HashMap();
    L27:
        if (TextUtils.isEmpty(r103) == false) goto L29;
        Log.e("SpacekitSdkWrapper", "set account info fail due to session is null");
        goto L53
    L29:
        com.bytedance.ee.bear.lark.dependency.k r107 = (com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class);
        String r108 = ((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).getTenantCode();
        if (qa5.b.a() == false) goto L32;
        ((com.bytedance.ee.bear.basesdk.apisupport.a) qa5.b.a.f532259a.f532258a.h()).a(jmb.d.a());
    L32:
        String r109 = r107.a(r108);
        String r111 = HttpUrl.parse(r109).host();
        ArrayList r112 = new ArrayList();
        r112.add(r111);
        r112.add(r107.getMainDomain());
        if (z.e(getContext()) == true) goto L45;
        DocAppUserConfig r113 = r107.c();
        jb5.b.c(r109, r103, r112, r113.getDocDomains());
        x18.b r114 = ((v) org.koin.java.a.a(v.class)).getLarkHttpClient();
        if (r114 == null) goto L44;
        ArrayList r115 = new ArrayList();
        Iterator r116 = r106.keySet().iterator();
    L39:
        if (r116.hasNext() == false) goto L43;
        com.bytedance.ee.bear.integrator.cookies.SessionInfo r117 = (com.bytedance.ee.bear.integrator.cookies.SessionInfo) r106.get((String) r116.next());
        if (r117 == null) goto L39;
        r115.add(jb5.b.a(r117.getSession(), r117.getSessionName(), r117.getHostUrl()));
        goto L39
    L43:
        CoreThreadPool.getBackgroundHandler().post(new jb5.a(r114, r109, r115));
    L44:
        k(r113);
        goto L53
    L45:
        DocAppUserConfig r118 = r107.b();
        if (r118 != null) goto L48;
        jb5.b.b(r109, r103, r112);
    L50:
        if (qa5.b.a() == false) goto L53;
        ((com.bytedance.ee.bear.basesdk.apisupport.g) qa5.b.a.f532259a.f532258a.i()).b(jcb.b.c().a("passport"));
        goto L53
    L48:
        jb5.b.c(r109, r103, r112, r118.getDocDomains());
        k(r118);
        goto L50
    L19:
        HashMap r119 = new HashMap(r105.size());
        Iterator<String> r120 = r105.keySet().iterator();
    L21:
        if (r120.hasNext() == false) goto L25;
        String r121 = r120.next();
        SessionInfo r122 = r105.get(r121);
        if (r122 == null) goto L21;
        r119.put(r121, new com.bytedance.ee.bear.integrator.cookies.SessionInfo(r122.getHostUrl(), r122.getSessionName(), r122.getSession()));
        goto L21
    L25:
        r106 = r119;
    L16:
        r105 = MapsKt.emptyMap();
    L53:
        if (qa5.b.a() == false) goto L67;
        Log.i("SpacekitSdkWrapper", "LarkSpacekitSdk fully initiated, flow the event");
        ((com.bytedance.ee.bear.basesdk.apisupport.a) qa5.b.a.f532259a.f532258a.h()).onLoginStatusChangedEvent(r110);
        return;
    }

    public final void i(int r100) {
        Log.i("SpacekitSdkWrapper", "DocsImpl.preloadDocSdk ");
        c r101 = this.f427888a;
        getContext();
        r101.a(r100);
    }

    public static String e(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        HashMap r102 = new HashMap();
        r102.put("docId", r101);
    L7:
        return av5.c.b(r100, r102, false);
    L5:
        r102 = null;
        goto L7
    }

    public static boolean g(String r100, Map r101) {
        if (b(r100) == false) goto L6;
        String r102 = a(r100);
        return ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).open(r102, r101);
    L6:
        return false;
    }

    public final void j(final String r100, final IGetDataCallback<DocFeed> r101) {
        List<String> r102 = Collections.singletonList(r100);
        IGetDataCallback<ibb.a> r103 = new AnonymousClass10(this, r101, r100);
        MGetDocFeedsRequest.Builder r104 = new MGetDocFeedsRequest.Builder().ids(r102);
        SdkSender.asynSendRequestNonWrap(Command.MGET_DOC_FEEDS, r104, r103, new h());
    }
}
