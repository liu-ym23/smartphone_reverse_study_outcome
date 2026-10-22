package jd7;

import android.app.Activity;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.k;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.login")
public final class f extends b {

    public static final class a implements IHostUserDepend.ILoginStatusCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostUserDepend f498654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<b.c> f498655b;

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILoginStatusCallback
        public final void onFail() {
            AppEvent r100 = AppEvent.LoginStatusChange;
            if (r100.isActive() == false) goto L5;
            Event r101 = new Event(r100.getEventName(), System.currentTimeMillis(), null, 4, null);
            Boolean r102 = Boolean.FALSE;
            r101.setMapParams(MapsKt.mapOf(TuplesKt.to(Keys.API_RETURN_KEY_IS_LOGIN, r102)));
            EventCenter.enqueueEvent(r101);
            Event r103 = new Event(r100.getEventName(), System.currentTimeMillis(), null, 4, null);
            r103.setMapParams(MapsKt.mapOf(TuplesKt.to(Keys.API_RETURN_KEY_IS_LOGIN, r102)));
            EventCenter.enqueueEvent(r103);
        L5:
            CompletionBlock<b.c> r104 = this.f498655b;
            XBaseModel r105 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
            b.c r106 = (b.c) r105;
            r106.setStatus("cancelled");
            r106.setAlreadyLoggedIn(Boolean.FALSE);
            CompletionBlock.DefaultImpls.onSuccess$default(r104, (XBaseResultModel) r105, null, 2, null);
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend.ILoginStatusCallback
        public final void onSuccess() {
            boolean r100 = this.f498654a.hasLogin();
            AppEvent r101 = AppEvent.LoginStatusChange;
            if (r101.isActive() == false) goto L6;
            Event r102 = new Event(r101.getEventName(), System.currentTimeMillis(), null, 4, null);
            r102.setMapParams(MapsKt.mapOf(TuplesKt.to(Keys.API_RETURN_KEY_IS_LOGIN, Boolean.valueOf(r100))));
            EventCenter.enqueueEvent(r102);
        L6:
            if (r100 == false) goto L8;
            CompletionBlock<b.c> r103 = this.f498655b;
            XBaseModel r104 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
            b.c r105 = (b.c) r104;
            r105.setStatus("loggedIn");
            r105.setAlreadyLoggedIn(Boolean.FALSE);
            CompletionBlock.DefaultImpls.onSuccess$default(r103, (XBaseResultModel) r104, null, 2, null);
            return;
        L8:
            CompletionBlock<b.c> r106 = this.f498655b;
            XBaseModel r107 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
            b.c r108 = (b.c) r107;
            r108.setStatus("cancelled");
            r108.setAlreadyLoggedIn(Boolean.FALSE);
            CompletionBlock.DefaultImpls.onSuccess$default(r106, (XBaseResultModel) r107, null, 2, null);
        }

        public a(IHostUserDepend r100, CompletionBlock<b.c> r101) {
            this.f498654a = r100;
            this.f498655b = r101;
        }
    }

    public f() {
    }

    public static void a(IBDXBridgeContext r110, b.InterfaceC6419b r111, CompletionBlock r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context is null", null, 4, null);
        return;
    L6:
        Activity r101 = k.f270262a.getActivity(r100);
        if (r101 != null) goto L10;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        return;
    L10:
        int r102 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        XBaseRuntime r103 = XBaseRuntime.f270095a;
        r103.getClass();
        IHostUserDepend r104 = XBaseRuntime.f270103i;
        if (r104 == null) goto L33;
        boolean r105 = r111.getKeepOpen();
        Object r106 = null;
        if (r104.hasLogin() == false) goto L20;
        XBaseModel r113 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r107 = (b.c) r113;
        r107.setStatus("loggedIn");
        r107.setAlreadyLoggedIn(Boolean.TRUE);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r113, null, 2, null);
        if (r105 == true) goto L36;
        r103.getClass();
        IHostRouterDepend r114 = XBaseRuntime.f270102h;
        if (r114 == null) goto L37;
        r114.closeView(r110, "", false);
        return;
    L37:
        return;
    L36:
        return;
    L20:
        LinkedHashMap r108 = new LinkedHashMap();
        Map<String, Object> r115 = r111.getContext();
        if (r115 == null) goto L26;
        Iterator<String> r109 = r115.keySet().iterator();
    L24:
        if (r109.hasNext() == false) goto L26;
        String r116 = r109.next();
        r108.put(r116, String.valueOf(r115.get(r116)));
    L26:
        a r117 = new a(r104, r112);
        if (r105 == false) goto L29;
        r104.login(r101, r117, r108);
        r106 = Unit.INSTANCE;
    L32:
        if (r106 == null) goto L33;
        return;
    L29:
        IHostUserDepend.LoginParamsExt r118 = new IHostUserDepend.LoginParamsExt();
        r118.setKeepOpen(r105);
        Unit r119 = Unit.INSTANCE;
        r104.login(r101, r117, r108, r118);
        int r120 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        XBaseRuntime.f270095a.getClass();
        IHostRouterDepend r121 = XBaseRuntime.f270102h;
        if (r121 == null) goto L32;
        r106 = Boolean.valueOf(r121.closeView(r110, "", false));
    L33:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "hostUserDepend is null", null, 4, null);
        Unit r122 = Unit.INSTANCE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (b.InterfaceC6419b) r101, r102);
    }
}
