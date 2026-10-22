package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.uploadFile")
public final class y extends zd7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f571465d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zd7.a.b f571466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap<String, File> f571468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ y f571469d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<zd7.a.c> f571470e;

        /* JADX INFO: renamed from: zd7.y$a$a, reason: collision with other inner class name */
        public static final class C8444a implements te7.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<zd7.a.c> f571471a;

            public C8444a(CompletionBlock<zd7.a.c> r100) {
                this.f571471a = r100;
            }

            @Override // te7.a
            public final void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r110) {
                Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
                Intrinsics.checkNotNullParameter(r101, "responseHeader");
                if (r102 != null) goto L29;
                int r103 = -1;
            L8:
                Gson r104 = te7.c.f545587a;     // Catch: Throwable -> L5
                ae7.b r105 = ((ae7.g) te7.c.a(r100.toString(), ae7.g.class)).a();     // Catch: Throwable -> L5
                if (r105 == null) goto L12;
                List<String> r106 = r105.b();     // Catch: Throwable -> L5
                if (r106 == null) goto L12;
            L13:
                CompletionBlock<zd7.a.c> r107 = this.f571471a;     // Catch: Throwable -> L5
                XBaseModel r108 = ne7.e.c(Reflection.getOrCreateKotlinClass(zd7.a.c.class));     // Catch: Throwable -> L5
                zd7.a.c r109 = (zd7.a.c) r108;     // Catch: Throwable -> L5
                if ((!r106.isEmpty()) == false) goto L16;
                String r111 = (String) ListProtector.get(r106, 0);     // Catch: Throwable -> L5
            L17:
                r109.setUrl(r111);     // Catch: Throwable -> L5
                r109.setHttpCode(Integer.valueOf(r103));     // Catch: Throwable -> L5
                r109.setClientCode(Integer.valueOf(r110));     // Catch: Throwable -> L5
                LinkedHashMap r112 = new LinkedHashMap();     // Catch: Throwable -> L5
                Iterator<String> r113 = r100.keys();     // Catch: Throwable -> L5
            L19:
                if (r113.hasNext() == false) goto L21;
                String r114 = r113.next();     // Catch: Throwable -> L5
                r112.put(r114, r100.get(r114));     // Catch: Throwable -> L5
                goto L19
            L21:
                r109.setResponse(r112);     // Catch: Throwable -> L5
                CompletionBlock.DefaultImpls.onSuccess$default(r107, (XBaseResultModel) r108, null, 2, null);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                CompletionBlock<zd7.a.c> r115 = this.f571471a;
                String r116 = th.getMessage();
                if (r116 != null) goto L26;
                String r117 = "";
            L27:
                CompletionBlock.DefaultImpls.onFailure$default(r115, 0, r117, null, 4, null);
                id7.c.a("parse post response body failed " + th.getMessage());
                return;
            L26:
                r117 = r116;
                goto L27
            L16:
                r111 = "";
            L12:
                r106 = new ArrayList();     // Catch: Throwable -> L5
                goto L13
            L29:
                r103 = r102.intValue();     // Catch: Throwable -> L5
                goto L8
            }

            @Override // te7.a
            public final void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r110, int r111) {
                Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
                if ((r110 instanceof NetworkNotAvailabeException) == false) goto L5;
                int r102 = -1001;
            L6:
                CompletionBlock<zd7.a.c> r103 = this.f571471a;
                String r104 = r110.getMessage();
                if (r104 != null) goto L9;
                r104 = "";
            L9:
                XBaseModel r105 = ne7.e.c(Reflection.getOrCreateKotlinClass(zd7.a.c.class));
                zd7.a.c r106 = (zd7.a.c) r105;
                int r107 = -408;
                if (r100 == null) goto L12;
                Integer r108 = r100;
            L13:
                r106.setHttpCode(r108);
                r106.setClientCode(Integer.valueOf(r111));
                LinkedHashMap r112 = new LinkedHashMap();
                if (r100 == null) goto L16;
                r107 = r100.intValue();
            L16:
                r112.put("errCode", Integer.valueOf(r107));
                String r109 = r110.getMessage();
                if (r109 != null) goto L19;
                r109 = "";
            L19:
                r112.put("message", r109);
                r112.put("prompts", "");
                r106.setResponse(r112);
                Unit r113 = Unit.INSTANCE;
                r103.onFailure(r102, r104, (XBaseResultModel) r105);
                return;
            L12:
                r108 = -408;
                goto L13
            L5:
                r102 = 0;
                goto L6
            }

            @Override // te7.a
            public final Unit b(JSONObject r100, LinkedHashMap<String, String> r101, String r102, Throwable r103, Integer r104, int r105) {
                te7.a.C7714a.a(r100, r101, r102, r103);
                return null;
            }
        }

        public a(zd7.a.b r100, IBDXBridgeContext r101, LinkedHashMap<String, File> r102, y r103, CompletionBlock<zd7.a.c> r104) {
            this.f571466a = r100;
            this.f571467b = r101;
            this.f571468c = r102;
            this.f571469d = r103;
            this.f571470e = r104;
        }

        public final void a() {
            te7.e r100 = te7.e.f545589a;
            Map<String, Object> r101 = this.f571466a.getHeader();
            r100.getClass();
            LinkedHashMap r102 = te7.e.f(r101);
            te7.e.b(r102, this.f571467b);
            Map r103 = te7.e.c(this.f571466a.getParams());
            C8444a r104 = new C8444a(this.f571470e);
            String r105 = this.f571466a.getUrl();
            LinkedHashMap<String, File> r106 = this.f571468c;
            y r107 = this.f571469d;
            boolean r108 = !this.f571466a.getAddCommonParams();
            r107.getClass();
            if (r108 == false) goto L5;
            IHostNetworkDepend r109 = com.bytedance.sdk.xbridge.cn.utils.g.g();
        L6:
            te7.e.s(r100, r105, r102, r106, r103, r104, r109, this.f571466a.getAddCommonParams(), 128);
            return;
        L5:
            r109 = com.bytedance.sdk.xbridge.cn.utils.g.d();
            goto L6
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
    }

    public y() {
        new String[]{"xml", "db"};
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        zd7.a.b r100 = (zd7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        if (r102 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        return;
    L8:
        ae7.a r103 = ae7.a.f3109a;
        String r104 = r100.getFilePath();
        r103.getClass();
        if (ae7.a.e(r101, r104) == true) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "file does not exist", null, 4, null);
        return;
    L11:
        IHostPermissionDepend r105 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r105 == null) goto L14;
        String[] r106 = ae7.h.c();
        boolean r107 = r105.isPermissionAllGranted(r102, (String[]) Arrays.copyOf(r106, r106.length));
    L15:
        this.f571465d = r107;
        if (r107 == false) goto L18;
    L26:
        a(r110, r101, r100, r112);
        return;
    L18:
        if (ae7.a.d(r101, r100.getFilePath()) == true) goto L26;
        IHostPermissionDepend r113 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r113 == null) goto L23;
        String r114 = this.f571319a;
        String[] r108 = ae7.h.c();
        r113.requestPermission(r102, r110, r114, (String[]) Arrays.copyOf(r108, r108.length), new x(this, r110, r101, r100, r112));
        Unit r109 = Unit.INSTANCE;
    L24:
        if (r109 != null) goto L31;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "uploadFileDepend is null", null, 4, null);
        return;
    L31:
        return;
    L23:
        r109 = null;
        goto L24
    L14:
        r107 = false;
        goto L15
    }

    public final void a(IBDXBridgeContext r110, Context r111, zd7.a.b r210, CompletionBlock<zd7.a.c> r211) {
        if (r210.getFilePath().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        LinkedHashMap r101 = null;
        if (r100 == false) goto L63;
        String r102 = r210.getFilePath();
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        CompletionBlock.DefaultImpls.onFailure$default(r211, -3, "The file path should not be empty.The key is filePath", null, 4, null);
    L56:
        PolarisFileWrapper r104 = null;
    L57:
        if (r104 == null) goto L64;
        s26.d r105 = s26.d.f540305c;
        m0 r106 = (m0) s26.d.f540305c.c(m0.class);
        if (r106 == null) goto L62;
        r106.a0();
    L62:
        r101 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("file", r104)});
    L64:
        LinkedHashMap r107 = r101;
        if (r107 != null) goto L67;
        return;
    L67:
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new a(r210, r110, r107, this, r211));
        return;
    L17:
        ae7.a.f3109a.getClass();
        String r108 = ae7.a.a(r111, r102);
        if (r108 != null) goto L20;
    L23:
        boolean r109 = true;
    L24:
        if (r109 == false) goto L26;
        CompletionBlock.DefaultImpls.onFailure$default(r211, -9, "File is not exist.The key is filePath", null, 4, null);
        goto L56
    L26:
        r104 = new PolarisFileWrapper(r108);
        if (r104.exists() == false) goto L48;
        if (r104.length() == 0) goto L48;
        if (r104.isFile() == true) goto L34;
        CompletionBlock.DefaultImpls.onFailure$default(r211, -9, "File is not file.The key is filePath", null, 4, null);
        goto L56
    L34:
        Lazy<ArgusGlobalDelegate> r112 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r113 = ArgusGlobalDelegate.a.a();
        if (r113 == null) goto L37;
        com.bytedance.ies.argus.bean.i r114 = r113.b(new com.bytedance.ies.argus.api.params.b(r108, "x.uploadFile"));
    L38:
        if (r114 != null) goto L40;
    L42:
        boolean r115 = false;
    L43:
        if (r115 == false) goto L57;
        CompletionBlock.DefaultImpls.onFailure$default(r211, 0, "file path " + r108 + " contains sensitive content, can not upload.", null, 4, null);
        goto L56
    L40:
        if (r114.c() != true) goto L42;
        r115 = true;
        goto L43
    L37:
        r114 = null;
    L48:
        if (r104.exists() == false) goto L55;
        if (r104.length() != 0) goto L55;
        if (this.f571465d == true) goto L55;
        CompletionBlock.DefaultImpls.onFailure$default(r211, 0, "permission denied", null, 4, null);
    L55:
        CompletionBlock.DefaultImpls.onFailure$default(r211, -9, "File is not exist.The key is filePath", null, 4, null);
        goto L56
    L20:
        if (r108.length() == 0) goto L23;
        r109 = false;
        goto L24
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L63:
        CompletionBlock.DefaultImpls.onFailure$default(r211, -3, "filePath or formDataBody can not be null.", null, 4, null);
        goto L64
    L5:
        r100 = false;
        goto L6
    }
}
